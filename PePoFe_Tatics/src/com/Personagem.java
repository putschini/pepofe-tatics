package com;
import br.ufsc.inf.leobr.cliente.Jogada;


public class Personagem implements Jogada {
	
	protected PersonagemEnum tipo;
	protected int vida;
	protected int movimento;
	protected int ataque;
	protected int distanciaAtaque;
	protected String imagem1;
	protected String imagem2;
	protected boolean jaMovimentou;
	protected boolean jaAtacou;
	protected Posicao posicao;
	
	
	public Personagem(PersonagemEnum t){
		switch(t){
			case ARQUEIRO:
			tipo = t;
			vida = 45;
			ataque = 12;
			movimento = 5;
			distanciaAtaque = 3;
			imagem1 = "src/imagens/ArqueiroSprite1.png";
			imagem2 = "src/imagens/ArqueiroSprite2.png";
			jaMovimentou = false;  	
			jaAtacou = false;
			posicao = null;
			break;

			case GUERREIRO:
			tipo = t;
			vida = 60;
			ataque = 8;
			movimento = 6;
			distanciaAtaque = 1;
			imagem1 = "src/imagens/GuerreiroSprite1.png";
			imagem2 = "src/imagens/GuerreiroSprite2.png";
			jaMovimentou = false;  	
			jaAtacou = false;
			posicao = null;
			break;
			
			case MAGO:
			tipo = t;
			vida = 36;
			ataque = 15;
			movimento = 5;
			distanciaAtaque = 2;
			imagem1 = "src/imagens/MagoSprite1.png";
			imagem2 = "src/imagens/MagoSprite2.png";
			jaMovimentou = false;  	
			jaAtacou = false;
			posicao = null;
			break;
			
			case TORRE:
			tipo = t;
			vida = 150;
			ataque = 0;
			movimento = 0;
			distanciaAtaque = 0;
			imagem1 = "src/imagens/TorreSprite1.png";
			imagem2 = "src/imagens/TorreSprite2.png";
			jaMovimentou = false;  	
			jaAtacou = false;
			posicao = null;
			break;
		}	
	}

	
	public String getTipo() {
		return tipo.name();
	}
	
	public int getAtaque() {
		return ataque;
	}

	public int getDistanciaAtaque(){
		return distanciaAtaque;
	}
	
	public int getVida() {
		return vida;
	}

	public int getMovimento() {
		return movimento;
	}

	public boolean getJaAtacou() {
		return jaAtacou;
	}
	
	public boolean getJaMovimentou(){
		return jaMovimentou;
	}

	public void setJaAtacou(boolean jaAtacou) {
		if(tipo != PersonagemEnum.TORRE)
			this.jaAtacou = jaAtacou;
	}

	public void setJaMovimentou(boolean jaMovimentou) {
		if(tipo != PersonagemEnum.TORRE)
			this.jaMovimentou = jaMovimentou;
	}

	public String getImagem1() {
		return imagem1;
	}

	public void setPosicao(Posicao pos){
		posicao = pos;
	}
	
	public Posicao getPosicao(){
		return posicao;
	}
	
	public void marcarAtaque(int dano) {
		vida = vida - dano;
	}

	public boolean verificaMorte(){   //RETORNA TRUE CASSO ESTEJA MORTO
		if(vida > 0)
			return false;
		return true;
	}

	public String getImagem2() {
		return imagem2;
	}
}
