package com;

import br.ufsc.inf.leobr.cliente.Jogada;

public class NotificarEscolha implements Jogada{
	
	EscolhaEnum escolha;
	
	public NotificarEscolha(EscolhaEnum e){
		escolha = e;
	}
	
	EscolhaEnum getEscolha(){
		return escolha;
	}
}
