package ui;

import javax.swing.JOptionPane;

import com.Controle;

public class AtorJogador {

	private Controle controle;
	private VisaoJogo jogo;
	private VisaoMenu menu;
	
	
	public AtorJogador(Controle c){
		controle = c;
	}
		
	public void iniciaTabuleiro(){
		jogo = new VisaoJogo(controle);
	}
	public void atualizarTabuleiro(){
		jogo.atualizarTabuleiro();
	}

	public void mostrarRegras() {
		new VisaoRegras();
	}

	public void escolherMapa() {
		menu.setVisible(false);
		if(controle.getJogador().EVezDeJogar())
			new VisaoEscolhaMapa(controle);
		else
			JOptionPane.showMessageDialog(null, "Espere o adversario escolher o Mapa");
	}

	public void escolherPersonagens() {
		new VisaoEscolhaPersonagem(controle);
		
	}

	public void iniciaVisao() {
		menu = new VisaoMenu(controle);
	}

	public void mostraMensagemTabuleiro(String mensagem) {
		jogo.atualizarMensagem(mensagem);
	}

	public void mostrarFimJogo() {
		jogo.setVisible(false);
		new VisaoFimJogo(controle);
	}
}
