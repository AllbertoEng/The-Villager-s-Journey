package Interface;

import javax.swing.*;

import fases.*;

import java.awt.*;
/**
 * Janela do jogo.
 * @author Equipe11
 *
 */
public class Janela extends JFrame{		

	private static final long serialVersionUID = 1L;
		/**
		 * Card Layout (controlam o mesmo espaço do painel).
		 */
		public static CardLayout cl = new CardLayout();
		public static JPanel panelBase = new JPanel();
		
		/**
		 * Cenas a serem inseridas na Janela
		 */
		static Menu menu = new Menu();
		public static Intro intro = new Intro();
		static animacao animacao = new animacao();
		public static Cena02 cena02 = new Cena02();
		public static Cena03 cena03 = new Cena03();
		public static Cena04 cena04 = new Cena04();
		public static Cena05 cena05 = new Cena05();
		public static Cena06 cena06 = new Cena06();
		public static Cena07 cena07 = new Cena07();
		public static Cena08 cena08 = new Cena08();
		public static Cena09 cena09 = new Cena09();
		public static Cena10 cena10 = new Cena10();
		public static Cena11 cena11 = new Cena11();
		public static Cena01Pergaminho cena01Pergaminho = new Cena01Pergaminho();
		public static Batalha batalha = new Batalha();
		
		/**
		 * Título da janela.
		 */
		String TituloJanela = "The Villager's Journey";
	/**
	 * Adcionar Cenas na Janela	
	 */
	Janela(){
		panelBase.setLayout(cl);
		panelBase.add(intro, "intro");		
		panelBase.add(menu, "menu");
		panelBase.add(animacao, "animacao");
		panelBase.add(cena01Pergaminho, "cena01Pergaminho");
		panelBase.add(cena02, "cena02");
		panelBase.add(cena03, "cena03");
		panelBase.add(cena04, "cena04");
		panelBase.add(cena05, "cena05");
		panelBase.add(cena06, "cena06");
		panelBase.add(cena07, "cena07");
		panelBase.add(cena08, "cena08");
		panelBase.add(cena09, "cena09");
		panelBase.add(cena10, "cena10");
		panelBase.add(cena11, "cena11");
		panelBase.add(batalha, "batalha");
		cl.show(panelBase, "cena06");		
		
		/**
		 * Adicionar componentes da Janela.
		 */
		this.setTitle(TituloJanela);		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(panelBase);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	/**
	 * Método para incorporar a Introdução do jogo.
	 * @return Introdução do jogo.
	 */
	public static Intro getIntro(){
		return intro;
	}

}