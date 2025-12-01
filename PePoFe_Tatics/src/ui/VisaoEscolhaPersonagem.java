package ui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import com.Controle;
import com.Personagem;
import com.PersonagemEnum;

public class VisaoEscolhaPersonagem extends JFrame{


	private Controle controle;
	private JPanel escolhaPersonagem;
	private JList tabela;
	private DefaultListModel model;	
	private ArrayList<Personagem> personagens;
	
	public VisaoEscolhaPersonagem(Controle c){
		super();
		controle = c;
		escolhaPersonagem = new JPanel();
		personagens  = new ArrayList();;

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		this.setLista();
		gbc.gridx = 0;
		gbc.gridy = 0;

		this.add(escolhaPersonagem,gbc);
		this.pack();
		this.setVisible(true);
	}	
	
	
	private void setLista(){
		escolhaPersonagem.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		model = new DefaultListModel();
		tabela = new JList(model);
		JScrollPane pane = new JScrollPane(tabela);

		JButton pe = new JButton("Pe (Guerreiro)");
		pe.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if( personagens.size() < 6){					
				model.addElement("pe");
				personagens.add(new Personagem(PersonagemEnum.GUERREIRO));
				}
			}
		});
		JButton po = new JButton("Po (Arqueiro");
		po.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if( personagens.size() < 6){					
				model.addElement("po");
				personagens.add(new Personagem(PersonagemEnum.ARQUEIRO));
				}
			}
		});
		JButton fe = new JButton("Fe (Mago)");
		fe.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				if( personagens.size() < 6){					
				model.addElement("fe");
				personagens.add(new Personagem(PersonagemEnum.MAGO));
				}
			}
		});
		JButton removePe = new JButton("Remover Guerreiro");
		removePe.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				for(Personagem p: personagens){
					if(p.getTipo() == "GUERREIRO"){
						personagens.remove(p);
						break;
					}		
				}
					model.removeElement("pe");
				System.out.print(personagens.size());
			}
		});
		JButton removePo = new JButton("Remover Arqueiro");
		removePo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				for(Personagem p: personagens){
					if(p.getTipo() == "ARQUEIRO"){
						personagens.remove(p);
						break;
					}		
				}
					model.removeElement("po");
				System.out.print(personagens.size());
			}
		});
		JButton removeFe = new JButton("Remover Mago");
		removeFe.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				for(Personagem p: personagens){
					if(p.getTipo() == "MAGO"){
						personagens.remove(p);
						break;
					}		
				}
					model.removeElement("fe");
				System.out.print(personagens.size());
			}
		});
		
		JButton confirmar = new JButton("Confirmar");
		confirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				if(personagens.size() == 6){
					Personagem[] perso = new Personagem[6];
					int aux = 0;
					for(Personagem p: personagens){	
						perso[aux] = p;
						aux++;
					}
					controle.setPersonagensJogador(perso);
					dispose();
				}			
			}
		});
		JPanel botoes = new JPanel();
		botoes.setLayout(new GridBagLayout());
		gbc.gridx = 0;
		gbc.gridy = 0;
		escolhaPersonagem.add(pane,gbc);
		botoes.add(pe,gbc);	
		gbc.gridx = 1;	
		botoes.add(removePe,gbc);
		gbc.gridx = 0;	
		gbc.gridy++;
		botoes.add(po,gbc);
		gbc.gridx = 1;
		botoes.add(removePo,gbc);
		gbc.gridy++;
		gbc.gridx = 0;
		botoes.add(fe,gbc);
		gbc.gridx = 1;
		botoes.add(removeFe,gbc);
		gbc.gridy++;
		gbc.gridx = 0;
		botoes.add(confirmar,gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		escolhaPersonagem.add(botoes,gbc);
		
	}
}

