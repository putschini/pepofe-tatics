package com;

import br.ufsc.inf.leobr.cliente.Jogada;

public class NotificarMapa implements Jogada {
	
	int tab;
	
	public NotificarMapa(int index) {
		tab = index;
	}

	public int getIndex(){
		return tab;
	}
}
