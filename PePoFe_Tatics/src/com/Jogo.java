package com;

public class Jogo {

		protected Tabuleiro tabuleiro;
		protected Jogador jogador1;
		protected Jogador jogador2;
		protected boolean finalizado;
		
		public Jogo(){
			finalizado = false;
		}
		
		public Acao selecionarPosicao(Jogador jogador, int x, int y){ 	

			Posicao posicaoSelc = jogador.getPosicaoSelecionada();
			Posicao posicaoClick = tabuleiro.getPosicao(x,y);
			Personagem personagemPos = posicaoClick.getPersonagemPosicao();
			
			if (personagemPos != null){				// SO SELECIONA
				if (jogador.verificaPertencePersonagem(personagemPos)){
					System.out.println("SELECIONA");
					jogador.setPosicaoSelecionada(posicaoClick);
					return null; 
				}else{				// ATACA
					if (posicaoSelc != null){
						if (this.verificaAtaque(posicaoSelc, posicaoClick)){ // VERIFICA ATAQUE
							if (this.verificaAtaque(posicaoClick, posicaoSelc)){ // VERIFICA CONTRA ATAQUE
								System.out.println("ATAQUECONTRAATAQUE");
								return new Acao(AcaoEnum.ATAQUECONTRAATAQUE, posicaoSelc.getX(), posicaoSelc.getY(), posicaoClick.getX(), posicaoClick.getY());								
							}
							System.out.println("ATAQUE");
							return new Acao(AcaoEnum.ATAQUE, posicaoSelc.getX(), posicaoSelc.getY(), posicaoClick.getX(), posicaoClick.getY());							
						}
					}
				}						
			}else{
				if (posicaoSelc != null)
					if(this.verificaMovimento(posicaoSelc, posicaoClick )){						
						System.out.println("MOVIMENTO");
						return new Acao(AcaoEnum.MOVIMENTO, posicaoSelc.getX(), posicaoSelc.getY(), posicaoClick.getX(), posicaoClick.getY());								
					}
			}
			return null;
		}

		private boolean verificaMovimento(Posicao posIni, Posicao posFim) {
			int distancia = getDistancia(posIni, posFim);
			Personagem personagem = posIni.getPersonagemPosicao();
			if(personagem.getMovimento() >= distancia && !personagem.getJaMovimentou() && posFim.getValida()){
				//VERIFICA SE HA CAMINHO VALIDO
				return true;			
			}
			return false;
		}
		
		
		private boolean verificaAtaque(Posicao posAtac, Posicao posDef) {
			int distancia = getDistancia(posAtac, posDef);
			Personagem personagemAtac = posAtac.getPersonagemPosicao();
			// fazer distancia e distancia -1 pois o mago e arqueiro atacam em 2 posicoes
			if((personagemAtac.getDistanciaAtaque() == distancia || personagemAtac.getDistanciaAtaque() - 1 == distancia) &&  !personagemAtac.getJaAtacou()){
				return true;
			}
			return false;
		}
		
		private int getDistancia(Posicao posIni, Posicao posFim){
			return Math.abs(posIni.getX() - posFim.getX()) + Math.abs(posIni.getY() - posFim.getY());
		}
		
		public void marcarAtaque(Acao jogada){
			Personagem personagemAtac = tabuleiro.getPosicao(jogada.getxInicio(), jogada.getyInicio()).getPersonagemPosicao();
			Personagem personagemDef = tabuleiro.getPosicao(jogada.getxFim(), jogada.getyFim()).getPersonagemPosicao();
			personagemAtac.setJaAtacou(true);
			personagemDef.marcarAtaque(personagemAtac.getAtaque());
		}
		
		public void marcarAtaqueContraAtaque(Acao jogada) {
			Personagem personagemAtac = tabuleiro.getPosicao(jogada.getxInicio(), jogada.getyInicio()).getPersonagemPosicao();
			Personagem personagemDef = tabuleiro.getPosicao(jogada.getxFim(), jogada.getyFim()).getPersonagemPosicao();
			personagemAtac.setJaAtacou(true);
			personagemAtac.marcarAtaque(personagemDef.getAtaque());
			personagemDef.marcarAtaque(personagemAtac.getAtaque());
		}
		
		public void marcarMovimento(Acao jogada){
			Personagem personagem = tabuleiro.getPosicao(jogada.getxInicio(), jogada.getyInicio()).getPersonagemPosicao();
			personagem.setJaMovimentou(true);
			personagem.setPosicao(tabuleiro.getPosicao(jogada.getxFim(), jogada.getyFim()));
			tabuleiro.getPosicao(jogada.getxInicio(), jogada.getyInicio()).setPersonagemPosicao(null);
			tabuleiro.getPosicao(jogada.getxFim(), jogada.getyFim()).setPersonagemPosicao(personagem);
		}
		

		public void verificaPersonagemAtacar(Jogador adversario, Acao jogada) {
			Personagem personagem = tabuleiro.getPosicao(jogada.getxFim(), jogada.getyFim()).getPersonagemPosicao();
			System.out.println("VerificaPodeAtacar : " );
			boolean naoPode = true;
			int distancia = getDistancia(personagem.getPosicao(), adversario.getTorre().getPosicao());
			if(distancia == personagem.getDistanciaAtaque() || distancia == personagem.getDistanciaAtaque() - 1)
				naoPode = false;
			for(Personagem p: adversario.getPersonagens()){
				distancia = getDistancia(personagem.getPosicao(), p.getPosicao());
				System.out.println("Posicao p : " + p.getPosicao().getX() +" " + p.getPosicao().getY());
				if(distancia == personagem.getDistanciaAtaque() || distancia == personagem.getDistanciaAtaque() - 1){
					naoPode = false;
					break;
				}
			}
			personagem.setJaAtacou(naoPode);
			System.out.println("Personagem movimentado : " + naoPode);
		}

		public boolean verificarFimDeJogo() {
			if(jogador1.verificaDerrota()){
				jogador2.setVencedor(true);
				finalizado  =  true;
				return true;
			}
			if(jogador2.verificaDerrota()){
				jogador1.setVencedor(true);
				finalizado  =  true;
				return true;
			}
			return false;			
		}
			
		public void setTabuleiro(Tabuleiro tab){
			tabuleiro = tab;
		}
		
		public Tabuleiro getTabuleiro() {
			return tabuleiro;
		}
		
		public void setJogador1(Jogador j){
			jogador1 = j;
		}
		
		public Jogador getJogador1(){
			return jogador1;
		}
		
		public void setJogador2(Jogador j){
			jogador2 = j;
		}

		public Jogador getJogador2(){
			return jogador2;
		}

		public void finalizar() {
			finalizado  =  true;
		}

		public Jogador getAdversario(Jogador jogador) {
			if(jogador1 == jogador)
				return jogador2;
			return jogador1;
		}
		
		public int getNumeroJogador(Jogador jogador){
			if(jogador1 == jogador)
				return 1;
			return 2;
		}
}
