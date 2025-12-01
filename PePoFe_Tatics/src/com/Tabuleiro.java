package com;

public class Tabuleiro {

	protected Posicao[][] tabuleiro;
	protected int comprimento;
	protected int altura;
	protected Posicao jogador1Inicio;
	protected Posicao jogador2Inicio;
	
	public Tabuleiro(){
		comprimento = 10;
		altura = 10;
		tabuleiro = new Posicao[comprimento][altura];	
		for(int x = 0; x < altura; x++){
			for(int y = 0; y < comprimento; y++){
				tabuleiro[x][y] = new Posicao(PosicaoEnum.TERRA , x, y);
			}
		}
	}

	public Posicao getPosicaoInicial(int i){
		if(i == 1)
			return jogador1Inicio;
		return jogador2Inicio;
	}
	
	public Tabuleiro(int index) {
		PosicaoEnum[][] matriz = getMatrizTabuleiro(index);
		
		altura = matriz.length;
		comprimento = matriz[0].length;
		System.out.print("" + altura + "  "  + comprimento);
		tabuleiro = new Posicao[altura][comprimento];	
		
		for(int x = 0; x < altura; x++){
			for(int y = 0; y < comprimento; y++){
				tabuleiro[x][y] = new Posicao(matriz[x][y] , x, y);
			}
		}
		
		setPosicaoInicio(index);
	}

	public Posicao getPosicao(int x, int y){
		if(x < 0 || x > altura || y < 0 || y > comprimento)
			return tabuleiro[0][0];
		return tabuleiro[x][y];
	}
	
	
	public int getComprimento(){
		return comprimento;
	}
	
	public int getAltura(){
		return altura;
	}
	
	private void setPosicaoInicio(int index){
		switch (index){
			case 1:
				 jogador1Inicio = getPosicao(4,4);
				 jogador2Inicio = getPosicao(13,13);
			break;
			case 2:
				 jogador1Inicio = getPosicao(9,1);
				 jogador2Inicio = getPosicao(9,28);
			break;
			default:
				 jogador1Inicio = getPosicao(5,5);
				 jogador2Inicio = getPosicao(7,7);
			break;
		}
	}
	
	private PosicaoEnum[][] getMatrizTabuleiro(int index){
		switch (index){
			case 1:
				PosicaoEnum[][] matriz = { 
						{ PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA },
						{ PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA },
						{ PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA },
						{ PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA },
						{ PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA },
						{ PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA },
						{ PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA },
						{ PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA },
						{ PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA },
						{ PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA },
						{ PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA },
						{ PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA },
						{ PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA },
						{ PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA },
						{ PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA },
						{ PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA },
						{ PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA },
						{ PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA }
						};
				return matriz;
			case 2:
				PosicaoEnum[][] matriz2 = {
						{ PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE },
						{ PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE },
						{ PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE },
						{ PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE },
						{ PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE },
						{ PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE },
						{ PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE },
						{ PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE },						
						{ PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE },
						{ PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE },
						{ PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE },
						{ PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE },
						{ PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE },
						{ PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE },
						{ PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE },
						{ PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE },
						{ PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE },
						{ PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE },
						{ PosicaoEnum.PAREDE, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.CHAO, PosicaoEnum.PAREDE },
						{ PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE, PosicaoEnum.PAREDE }
				};
				return matriz2;
			default:
				PosicaoEnum[][] matrizDefault = { 
						{ PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA },
						{ PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA },
						{ PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA },
						{ PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA },
						{ PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA },
						{ PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA },
						{ PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA },
						{ PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA },
						{ PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA },
						{ PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA, PosicaoEnum.TERRA }
				};
				return matrizDefault;
		}
	}
}