package com;

import br.ufsc.inf.leobr.cliente.Jogada;

public class Acao implements Jogada{
	
		protected int xInicio;
		protected int yInicio;
		protected int xFim;
		protected int yFim;
		protected AcaoEnum tipo;
		
		
		public Acao(AcaoEnum t,int xIni, int yIni,int xF,int yF){
			xInicio = xIni;
			yInicio = yIni;
			xFim = xF;
			yFim = yF;
			tipo = t;
		}

		public AcaoEnum getTipo() {
			return tipo;
		}

		public int getxInicio() {
			return xInicio;
		}

		public int getyInicio() {
			return yInicio;
		}

		public int getxFim() {
			return xFim;
		}

		public int getyFim() {
			return yFim;
		}
}
