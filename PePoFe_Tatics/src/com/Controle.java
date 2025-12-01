package com;

import java.util.Random;

import javax.swing.JOptionPane;

import rede.AtorNetGames;
import ui.AtorJogador;

public class Controle {
	
	Jogador jogador;
	Jogo jogo;

	AtorNetGames atorNetGames;
	AtorJogador atorJogador;
	
	public Controle(){ 
		jogador = new Jogador();
		atorNetGames = new AtorNetGames(this);
		atorJogador = new AtorJogador(this);
	}
	
	public void setJogo(Jogo j){
		jogo = j;
	}

	public Tabuleiro getTabuleiro(){
		return jogo.getTabuleiro();
	}
	
	public Jogador getJogador(){
		return jogador;
	}
	
	public Jogo getJogo(){
		return jogo;
	}
	
	public void conectar(){
		atorNetGames.conectar(jogador.getNome(),"localhost");
	}
	
	public void clikPosicao(int x, int y) {
		if(jogador.EVezDeJogar()){
			Acao jogada = jogo.selecionarPosicao(jogador, x, y);
			if(jogada != null){
				atorNetGames.enviarJogada(jogada);
				this.marcarAcao(jogada);
				if(jogador.verificarFimTurno())
					passarAvez();
			}
		}
	}

	public void marcarAcao(Acao j){
		String mensagem = "";
		switch(j.getTipo()){
			case MOVIMENTO: 
				mensagem = "O personagem da Posicao ( " + j.getxInicio() + " , " + j.getyInicio() + ") movimentou para a posicao ( " + j.getxFim() + " " + j.getyFim();
				jogo.marcarMovimento(j);
				if(jogador.EVezDeJogar())
					jogo.verificaPersonagemAtacar(jogo.getAdversario(jogador), j);
			break;
			case ATAQUE:
				mensagem = "O personagem da Posicao ( " + j.getxInicio() + " , " + j.getyInicio() + ") Atacou o da posicao ( " + j.getxFim() + " " + j.getyFim();
				jogo.marcarAtaque(j);
				if(jogo.verificarFimDeJogo())
					finalizarJogo();
			break;
			case ATAQUECONTRAATAQUE:
				mensagem = "O personagem da Posicao ( " + j.getxInicio() + " , " + j.getyInicio() + ") Atacou o da posicao (" + j.getxFim() + " , " + j.getyFim() + " ) e foi contra atacado";
				jogo.marcarAtaqueContraAtaque(j);
				if(jogo.verificarFimDeJogo())
					finalizarJogo();
			break;
			case PASSARAVEZ:
				mensagem = "Jogador passou a vez";
				jogador.mudarVezDeJogar();
				if(jogador.EVezDeJogar())
					jogador.atualizarMovimentosAtaques();
				atorJogador.atualizarTabuleiro();
			break;
		}
		jogador.setPosicaoSelecionada(null);
		atorJogador.atualizarTabuleiro();
		atorJogador.mostraMensagemTabuleiro(mensagem);
	}
	
	private void finalizarJogo() {
		jogo.finalizar();
		atorJogador.mostrarFimJogo();
	}

	public void passarAvez() { 
		if(jogador.EVezDeJogar()){
			Acao passarVez = new Acao(AcaoEnum.PASSARAVEZ,0,0,0,0);
			atorNetGames.enviarJogada(passarVez);
			marcarAcao(passarVez);
		}
	}
	
	public void verRegras() {
		atorJogador.mostrarRegras();
	}
	
	// PROCURA ADVERSARIO
	public void iniciarPartida(){
		atorNetGames.iniciarPartida();
	}

	// chamado Para iniciar partida (iniciarPartidaRede)
	public void iniciarNovaPartida(int posicao) {
		if (posicao == 1){
			jogador.setEVezDeJogar(true);
		}
		else{
			jogador.setEVezDeJogar(false);
		}
		jogador.setVencedor(false);
		jogador.setPosicaoTabuleiro(posicao);
		novoJogo();
	}
	

	public void novoJogo(){
		jogo = new Jogo();
		String nomeAdversario = atorNetGames.getNomeAdversario();
		if(jogador.EVezDeJogar()){
			jogo.setJogador1(jogador);
			jogo.setJogador2(new Jogador(nomeAdversario));
		}else{
			jogo.setJogador1(new Jogador(nomeAdversario));
			jogo.setJogador2(jogador);
		}
		atorJogador.escolherMapa();
	}
	
	public void setTabuleiro(int index){
		jogo.setTabuleiro(new Tabuleiro(index));
	}
	
	public void setPersonagensJogador(Personagem[] personagens){
		jogador.setPersonagens(personagens);
		posicionaPersonagens(personagens);
	}
	
	public void posicionaPersonagens(Personagem[] personagens){
		Posicao inicio = jogo.getTabuleiro().getPosicaoInicial(jogo.getNumeroJogador(jogador));
		int xPosIni = inicio.getX();
		int yPosIni = inicio.getY();		
		jogador.setTorre(new Personagem(PersonagemEnum.TORRE));
		jogador.getTorre().setPosicao(inicio);
		inicio.setPersonagemPosicao(jogador.getTorre());
		Random rnd = new Random();
		Posicao[] posicoes = new Posicao[personagens.length];
		for(int k = 0; k < personagens.length; k++){
			Posicao pos = jogo.getTabuleiro().getPosicao(xPosIni + (rnd.nextInt(4) - 2), yPosIni + (rnd.nextInt(4) - 2));
			while(!pos.getValida())
				pos = jogo.getTabuleiro().getPosicao(xPosIni + (rnd.nextInt(4) - 2), yPosIni + (rnd.nextInt(4) - 2));
			pos.setPersonagemPosicao(personagens[k]);
			personagens[k].setPosicao(pos);
			posicoes[k] = pos;
		}		
		atorNetGames.enviarJogada(new ListaPersonagem(personagens, posicoes));
		if(jogo.getAdversario(jogador).getPersonagens() != null)
			atorJogador.iniciaTabuleiro(); // iniciar Visao Tabuleiro
		else
			JOptionPane.showMessageDialog(null, "Espere o adversario escolher os Personagens");
	}

	public void setListaPersonagemAdversario(ListaPersonagem jogada) {
		Jogador adver = jogo.getAdversario(jogador);
		Posicao inicio = jogo.getTabuleiro().getPosicaoInicial(jogo.getNumeroJogador(adver));		
		adver.setTorre(new Personagem(PersonagemEnum.TORRE));
		adver.getTorre().setPosicao(inicio);
		inicio.setPersonagemPosicao(adver.getTorre());
		for(int k = 0; k< jogada.getNumeroPersonagens(); k++){
			int x = jogada.getXPosicao(k);
			int y = jogada.getYPosicao(k);
			jogo.getTabuleiro().getPosicao(x, y).setPersonagemPosicao(jogada.getPersonagem(k));
			jogada.getPersonagem(k).setPosicao(jogo.getTabuleiro().getPosicao(x, y));
		}
		adver.setPersonagens(jogada.getPersonagens());
		if(jogador.getPersonagens() != null)
			atorJogador.iniciaTabuleiro();
	}
	
	public void desistir(){
		finalizarJogo();
		atorNetGames.enviarJogada(new NotificarEscolha(EscolhaEnum.DESISTIR));
	}
	
	public void reiniciarJogo(){
		NotificarEscolha escolha = new NotificarEscolha(EscolhaEnum.REINICIAR);
		atorNetGames.enviarJogada(escolha);
		marcarEscolha(escolha);
	}

	public void iniciar() {
		atorJogador.iniciaVisao();	
	}

	public void escolherPersonagens() {
		atorJogador.escolherPersonagens();		
	}

	public void notificarMapaEscolhido(int index) {
		atorNetGames.enviarJogada(new NotificarMapa(index));
	}

	public void setTabuleiro(NotificarMapa jogada) {
		jogo.setTabuleiro(new Tabuleiro(jogada.getIndex()));
		atorJogador.escolherPersonagens();
	}

	public void marcarEscolha(NotificarEscolha jogada) {
		if(jogada.getEscolha() == EscolhaEnum.DESISTIR){
			jogador.setVencedor(true);
			finalizarJogo();			
		}
		else{
			if(jogador.getPosicaoTabuleiro() == 1)
				iniciarNovaPartida(2);
			else
				iniciarNovaPartida(1);
		}
			
	}
	
}
