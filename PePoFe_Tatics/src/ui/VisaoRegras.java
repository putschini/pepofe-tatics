package ui;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.Controle;

public class VisaoRegras extends JFrame {
	
	private Controle controle;
	private JPanel regras;
	private JTextArea regrasEscritas;
	
	
	public VisaoRegras(){
	super();
	regras = new JPanel();
	
	this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	regrasEscritas = 
			new JTextArea("1 - Objetivo: destruir todos os personagens ou a torre inimigo;\n\n" +
					"Dos personagens: tem 3 tipos de personagens diferentes selecionáveis:\n\n" +
					
					"1.1 - Pe(guerreiro): podendo se movimentar até 6 quadrados a sua volta e"+
					"tacar somente o que estiver no quadro a sua volta. Seus status são:\n" +
					"- 8 pontos de ataque e 60 pontos de vida;\n\n" +
					
					"1.2 - Po (arqueiro): podendo se movimentar até 5 quadrados a sua volta e\n " +
					"atacar inimigos que estejam a um mínimo 1 quadrado de distância e no máximo 2 quadrados. Seus status são:\n" +
					"12 pontos de ataque e 30 pontos de vida;\n\n" +
					
					"1.3 - Fe(mago): podendo se movimentar até 5 quadrados a sua volta\n" +
					"atacar inimigos 2 quadrados a sua volta. Seus status são:\n" +
					"15 pontos de ataque e 24 pontos de vida;\n\n" +
					
					"2 - Da torre: a torre fica localizada no canto direito superior e a outra no canto esquerdo inferior,\n" +
					"não se movimenta e não ataca e possui 150 pontos de vida;\n\n" +
					
					"3 - Do campo de batalha: o campo de batalha consiste em uma matriz 30x30, são 3 diferentes mapas\n" +
					"e o que diferencia são obstáculos espalhados pelo campo,\n" +
					"onde não é possível se movimentar;\n\n" +
					
					"4 - Configurando jogo: antes de iniciar partida os jogadores devem definir quais personagens irão usar durante a partida,\n" +
					"cada jogador deve selecionar 6 personagens, as escolha deve ser definida conforme for a estratégia dos jogadores;\n\n" +
					
					"5 - Durante partida: quem irá começar a partida é decidido aleatoriamente, cada personagem inicia partida sempre em volta de sua torre. \n" +
					"O jogador pode escolher movimentar e atacar ou atacar e movimentar; \n\n" +
					"5.1 - Movimento: seleciona um personagem e depois seleciona uma posição válida no campo de batalha, seguindo as características de movimentação de cada personagem;\n\n" +
					"5.2 - Combate: cada personagem pode atacar uma vez por turno, o resultado da batalha consiste em subtração simples de status dos personagens envolvidos no combate,\n" +
					"o atacante será contra atacado caso esteja na zona de ataque do personagem adversário\n\n" +
					
					"6 - Terminando o jogo: o jogo termina quando um dos lados não tiver mais personagens em campo de batalha ou a torre estiver destruída,\n" +
					"Caso algum jogador desista a partida será encerrada também. O jogador que destruir a torre inimiga ou matar todos os personagens adversários será o vencedor; ");
		
	
	this.add(regrasEscritas);
	this.pack();
	this.setVisible(true);
	}

}