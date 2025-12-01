package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import com.Controle;

public class VisaoMenu extends JFrame{

	private Controle controle;
	private JPanel menu;
	private JTextField nomeJogador;
	
	public VisaoMenu(Controle c){
		super();
		controle = c;
		menu = new JPanel();
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		this.setMenu();
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		nomeJogador = new JTextField(c.getJogador().getNome());
		this.add(nomeJogador,gbc);
		gbc.gridy++;
		
		this.add(menu,gbc);
		this.pack();
		this.setVisible(true);
	}
	private void setMenu(){
		
		menu.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		
		JButton conectar = new JButton("Conectar");
		conectar.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				controle.conectar();		
			}
		});
		JButton verRegras = new JButton("Ver Regras");
		verRegras.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				controle.verRegras();		
			}
		});
		JButton iniciarPartida = new JButton("Iniciar Partida");
		iniciarPartida.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				controle.iniciarPartida();		
			}
		});
		JButton mudarNomeJogador = new JButton("Mudar Nome");
		mudarNomeJogador.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				controle.getJogador().setNome(nomeJogador.getText());
			}
		});
		
		menu.add(conectar,gbc);
		gbc.gridy++;
		menu.add(iniciarPartida,gbc);
		gbc.gridy++;
		menu.add(verRegras,gbc);
		gbc.gridy++;
		menu.add(mudarNomeJogador,gbc);
	
	}
	
}
