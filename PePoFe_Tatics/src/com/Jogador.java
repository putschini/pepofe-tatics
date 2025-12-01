package com;

public class Jogador {
	
	protected String nome;
	protected Personagem[] personagens;
	protected Personagem torre;
	protected Posicao posicaoSelecionada; // so sera selecionada caso seja um personagem //
	protected boolean EVezDeJogar;
	protected int posicaoTabuleiro;
	protected boolean vencedor;
	protected boolean conectado;
	
	
	public Jogador() {
		nome = "Novo Jogador";
		EVezDeJogar = false;
		posicaoTabuleiro = 0;
		vencedor = false;
		conectado = false;
		personagens = null;
	}
	
	public Jogador(String nomeAdversario) {
		nome = nomeAdversario;
		EVezDeJogar = false;
		posicaoTabuleiro = 0;
		vencedor = false;
		conectado = false;
		personagens = null;
	}

	public void mudarVezDeJogar(){
		EVezDeJogar = !EVezDeJogar;
	}
	
	public boolean EVezDeJogar() {
		return EVezDeJogar;
	}
	
	public void setPersonagens (Personagem[] p){
		personagens = p;
	}
	
	public Personagem[] getPersonagens(){
		return personagens;
	}
	
	public void atualizarMovimentosAtaques(){
		for(Personagem p:personagens){
			p.setJaAtacou(false);
			p.setJaMovimentou(false);
		}
	}
	
	public void setPosicaoSelecionada(Posicao p){
		posicaoSelecionada = p;
	}
	
	public Posicao getPosicaoSelecionada(){
		return posicaoSelecionada;
	}

	public boolean verificaPertencePersonagem(Personagem personagemVerificar) {
		if(personagemVerificar.getTipo() == "TORRE")
			if(personagemVerificar == torre)
				return true;
		for(Personagem p:personagens)
			if(p == personagemVerificar)
				return true;
		return false;
	}
	
	public boolean verificarFimTurno() {
		for(Personagem p: personagens)
			if(!p.getJaMovimentou() || !p.getJaAtacou())
				return false;
		return true;
	}
		
	public boolean verificaDerrota() {
		if(torre.verificaMorte())
			return true;
		for(Personagem p: personagens)
			if(!p.verificaMorte())
				return false;
		return true;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public int getPosicaoTabuleiro(){
		return posicaoTabuleiro;
	}
	
	public void setPosicaoTabuleiro(int v){
		posicaoTabuleiro = v;
	}
	
	public void setVencedor(boolean v){
		vencedor = v;
	}
	
	public boolean getVencedor(){
		return vencedor;
	}

	public boolean getConectado(){
		return conectado;
	}
	
	public void setConectado(boolean c){
		conectado = c;
	}
	
	public void setEVezDeJogar(boolean c){
		EVezDeJogar = c;
	}

	public Personagem getTorre() {
		return torre;
	}

	public void setTorre(Personagem personagem) {
		if(personagem.getTipo() == "TORRE")
			torre = personagem;		
	}
}
