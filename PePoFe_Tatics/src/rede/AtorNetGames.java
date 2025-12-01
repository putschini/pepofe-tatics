package rede;

import javax.swing.JOptionPane;

import br.ufsc.inf.leobr.cliente.Jogada;
import br.ufsc.inf.leobr.cliente.OuvidorProxy;
import br.ufsc.inf.leobr.cliente.Proxy;
import br.ufsc.inf.leobr.cliente.exception.ArquivoMultiplayerException;
import br.ufsc.inf.leobr.cliente.exception.JahConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoJogandoException;
import br.ufsc.inf.leobr.cliente.exception.NaoPossivelConectarException;

import com.*;

public class AtorNetGames implements OuvidorProxy {
	
	private Controle controle;
	private Proxy proxy;
	
	public AtorNetGames(Controle c){
		super();
		controle = c;
		proxy = Proxy.getInstance();
		proxy.addOuvinte(this);
	}
	/*
	 *TRATAR EXCEPTION 
	 */
	public void conectar(String nome, String servidor){
		try {
			proxy.conectar(servidor, nome);
		} catch (JahConectadoException e) {
			JOptionPane.showMessageDialog(null, "Ja esta conectado");
		} catch (NaoPossivelConectarException e) {
			JOptionPane.showMessageDialog(null, "Nao foi possivel conectar");
		} catch (ArquivoMultiplayerException e) {
			JOptionPane.showMessageDialog(null, "Falha no arquivo");
		}
	}
	
	public void desconectar(){
		try {
			proxy.desconectar();
		} catch (NaoConectadoException e) {
			JOptionPane.showMessageDialog(null, "Nao esta conectado");

		}
	}
	/*
	 *TRATAR EXCEPTION 
	 */
	public void iniciarPartida(){
		try {
			proxy.iniciarPartida(2);
		} catch (NaoConectadoException e) {
			JOptionPane.showMessageDialog(null, "Nao esta conectado");
		}
	}
	
	@Override
	public void iniciarNovaPartida(Integer posicao) { // CHAMADO NOS DOIS JOGADORES DEPOIS DE INICIAR PARTIDA
		controle.iniciarNovaPartida(posicao);
	}
	
	public void enviarJogada(Jogada j){
		try {
			proxy.enviaJogada(j);
		} catch (NaoJogandoException e) {
			JOptionPane.showMessageDialog(null, "Nao esta numa partida");
		}
	}
	
	@Override
	public void receberJogada(Jogada jogada) {
		// PROVAVELMENTE JOGO TABULEIRO
		if(jogada instanceof Acao)
			controle.marcarAcao((Acao)jogada);

		if(jogada instanceof NotificarMapa)
			controle.setTabuleiro((NotificarMapa) jogada);
		
		if(jogada instanceof ListaPersonagem)
			controle.setListaPersonagemAdversario((ListaPersonagem)jogada);
	}
	
	public String getNomeAdversario() {
		if(controle.getJogador().EVezDeJogar())
			return proxy.obterNomeAdversario(2);
		return proxy.obterNomeAdversario(1);
	}

	@Override
	public void finalizarPartidaComErro(String message) {
		// TODO Auto-generated method stub

	}

	@Override
	public void receberMensagem(String msg) {
		// TODO Auto-generated method stub

	}


	@Override
	public void tratarConexaoPerdida() {
		// TODO Auto-generated method stub

	}

	@Override
	public void tratarPartidaNaoIniciada(String message) {
		// TODO Auto-generated method stub

	}
}
