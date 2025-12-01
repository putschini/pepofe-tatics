package ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.Controle;
import com.Tabuleiro;

public class VisaoEscolhaMapa extends JFrame {

	Controle controle;
	
	public VisaoEscolhaMapa(Controle c){
		super();
		controle = c;
	
		System.out.print(controle.getJogador().EVezDeJogar());
		
		JPanel menu = new JPanel();
		menu.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		JButton mapa1 = new JButton("Mapa 1");
		mapa1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				controle.getJogo().setTabuleiro(new Tabuleiro(1));
				controle.escolherPersonagens();
				controle.notificarMapaEscolhido(1);
				dispose();
			}
		});
		JButton mapa2 = new JButton("Mapa 2");
		mapa2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				controle.getJogo().setTabuleiro(new Tabuleiro(2));
				controle.escolherPersonagens();
				controle.notificarMapaEscolhido(2);
				dispose();
			}
		});
		JButton mapa3 = new JButton("Mapa 3");
		mapa3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				controle.getJogo().setTabuleiro(new Tabuleiro(3));		
				controle.escolherPersonagens();
				controle.notificarMapaEscolhido(3);
				dispose();
			}
		});
		menu.add(mapa1,gbc);
		gbc.gridx++;
		menu.add(mapa2,gbc);
		gbc.gridx++;
		menu.add(mapa3,gbc);
		gbc.gridx++;
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(menu);
		this.setVisible(true);
		this.pack();
		
	}
	
}
