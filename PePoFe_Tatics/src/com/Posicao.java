package com;
import br.ufsc.inf.leobr.cliente.Jogada;


public class Posicao implements Jogada{
	protected String imagem;
	protected Personagem personagemPosicao;
	protected boolean valida;
	protected int x;
	protected int y;
	protected PosicaoEnum tipo;
	
	public Posicao(PosicaoEnum pe, int x, int y){
		this.x = x;
		this.y = y;

		tipo = pe;
		switch(pe){
			case TERRA:
			imagem = "src/imagens/TerraSprite.png";
			personagemPosicao = null;
			valida = true; 
			break;

			case AGUA:
			imagem = "src/imagens/AguaSprite.png";
			personagemPosicao = null;
			valida = false; 
			break;
			
			case MONTANHA:
			imagem = "src/imagens/MontanhaSprite.png";
			personagemPosicao = null;
			valida = false; 
			break;
			
			case PONTE:
			imagem = "src/imagens/PonteSprite.png";
			personagemPosicao = null;
			valida = true; 
			break;
			
			case PAREDE:
			imagem = "src/imagens/ParedeSprite.png";
			personagemPosicao = null;
			valida = false; 
			break;
			
			case CHAO:
			imagem = "src/imagens/ChaoSprite.png";
			personagemPosicao = null;
			valida = true; 
			break;
		}
	}
	
	public String getImagem(){
		return imagem;
	}
	
	public Personagem getPersonagemPosicao(){
		return personagemPosicao;
	}
	
	public void setPersonagemPosicao(Personagem p){
		personagemPosicao = p;
	}
	
	public boolean verificaPersonagemPosicao(){
		if(personagemPosicao != null)
			return true;
		return false;
	}
	
	public boolean getValida(){
		if(personagemPosicao != null)
			return false;
		return valida;
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
}
