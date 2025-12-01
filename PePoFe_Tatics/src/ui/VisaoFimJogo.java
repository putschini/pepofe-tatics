package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.Controle;

public class VisaoFimJogo extends JFrame {

	private Controle controle;
	private JButton reinicia;
	public VisaoFimJogo(Controle c){
		super();
		controle = c;
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		reinicia = new JButton("Reiniciar Partida");
		
		this.add(reinicia);
		this.pack();
		this.setVisible(true);
	}
	
	
}
