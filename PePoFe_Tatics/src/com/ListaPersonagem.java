package com;

import br.ufsc.inf.leobr.cliente.Jogada;

public class ListaPersonagem implements Jogada {

	Personagem[] personagens;
	Posicao[] posicao;
	
	public ListaPersonagem(Personagem[] personagens, Posicao[] posicoes) {
		this.personagens = personagens;
		this.posicao = posicoes;
	}

	public int getNumeroPersonagens() {
		return personagens.length;
	}

	public int getYPosicao(int k) {
		return posicao[k].getY();
	}
	
	public int getXPosicao(int k) {
		return posicao[k].getX();
	}

	public Personagem getPersonagem(int k) {
		return personagens[k];
	}
	
	public Personagem[] getPersonagens(){
		return personagens;
	}

}
