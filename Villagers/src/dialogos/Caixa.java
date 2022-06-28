package dialogos;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import Interface.Intro;
import cenarios.Caminhos;
import cenarios.Menina;
import cenarios.MeninaBatalha;
import cenarios.Velho;
import fases.Cena02;
/**
 * Caixa de diálogos
 * @author Equipe11
 *
 */

public class Caixa {
	public static int cena;
	public static int fala =0;
	/*Se alternancia for 1, serão utilizados falas da menina, 2, do guerreiro.*/
	public static int Alternancia = 0; 
	
	/**
	 * Boolean para verificar interação com a menina
	 */
	public static boolean CaixaMenina = false;
	public static int auxPassagemdeDialogo = 0;
	
	/**
	 * Personalizando caixa de diálogo	
	 */
	static int fontSize = 20;
	public static int contador = 0;
    static Font f = new Font("Comic Sans MS", Font.BOLD, fontSize);
	/**
	 * Dialogos
	 */
  	public static String currentDialog = "";
  	public static String auxiliar = "";
	public static String dialogos[] [] = new String[12][12];

	public Caixa() {
		
	/**
	 * Dialogos segunda tela (Cena03)
	 */
		dialogos[2][0] = "Menina \n Oi, licença, sei que parece estranho, mas posso te pedir um favor?";
		dialogos[2][1] = "Menina \n Estou um pouco longe de casa e me perdi...";
		dialogos[2][2] = "Menina \n Posso ir com você por enquanto?";
			
	/**
	 * Dialogos terceira tela (Cena04) 
	 */
		dialogos[3][0] = "Menina \n Moro em uma vila próxima daqui sabe, ela foi destruída recentemente e os moradores sumiram, junto com minha \nfamília.";
		dialogos[3][1] = "Menina \n Não consigo lembrar de nada daquele dia, tudo é tão confuso, não sei o que fazer."; 
	
	/**
	 * Dialogos quarta tela (Cena05)
	 */
		dialogos[4][0] = "Menina \n Sabe, lá era um lugar bem animado e divertido.";
		dialogos[4][1] = "Menina \n Lá a maioria dass pessoas saiam em viagens para explorar o mundo.";
		dialogos[4][2] = "Menina \n As histórias que eles contavam ao retornar da vila me encantavam.";
		
	/**
	 * Dialogos quinta tela (Cena06)
	 */
		dialogos[5][0] = "Menina \n Tinha um guerreiro bem famoso que sempre achava os mais estranhos itens.";
		dialogos[5][1] = "Menina \n Um dia, ele chegou com um saco de riquezas, e atraiu a atenção de toda a vila.";
		dialogos[5][2] = "Menina \n Ao abrir o saco, eu me senti atraída por um anel muito bonito. Acho que o guerreiro viu minha curiosidade e \nme presenteou com ele.";
		dialogos[5][3] = "Menina \n Parando pra pensar, foi ali que minha mente ficou estranha.";

		
	/**
	 * Dialogos sexta tela (Cena07)
	 */
		dialogos[6][0] = "Menina \n Depois desse dia, eu começei a ter pensamentos estranhos.";
		dialogos[6][1] = "Menina \n O que mais me marcou, era uma canção esquisita, que nunca ouvi alguém cantar.";
		dialogos[6][2] = "Menina \n Enquanto eu a cantava, me sentia bem ♪♪♪♪♪.";
		dialogos[6][3] = "Menina \n Mas as pessoas ao meu redor, minha família, meus amigos, todos começaram a se sentir mal, por uma doença \ndesconhecida.";
		
	/**
	 * Dialogos sétima tela (Cena08)
	 */
		dialogos[7][0] = "Menina \n O guerreiro famoso percebeu a doença que assolava a vila, e partiu uma jornada... ";
		dialogos[7][1] = "Menina \n Ele retornou depois de um tempo, mas já era tarde.";
		dialogos[7][2] = "Menina \n O anél... me fez fazer coisas horríveis! Não era eu, eu juro!";
		dialogos[7][3] = "Menina \n Estou sentindo ele de novo, tenho que correr, não quero machucar você também!";
		
	/**
	 * Dialogos nona tela (Cena10)
	 */
		dialogos[9][0] = "Guerreiro \n Olá aldeão, pela sua cara já sei que descobriu certas coisas sobre aquela vila.";
		dialogos[9][1] = "Guerreiro \n Aquela menina já sofreu muito, não merecia nada daquela tragédia...";
		dialogos[9][2] = "Guerreiro \n Quando voltei com a cura, todos já estavam mortos, e só ela restava.";
		dialogos[9][3] = "Guerreiro \n O ser maligno que a possuia era muito forte, eu mal conseguia lutar contra ele";
		dialogos[9][4] = "Guerreiro \n A minha breve vitória se deu por uma oração que aprendi na viagem, talvez possa funcionar de novo.";
		dialogos[9][5] = "Guerreiro \n Porém ela não é tão forte como antes, acho que se você lutar, deve ter uma chance boa de ganhar.";
		dialogos[9][6] = "Guerreiro \n Leve essa espada com você, junto com a oração. Por favor, acabe com essa história de terror!";
		
	/**
	 * Dialogos décima tela (Cena11)
	 */
		dialogos[10][0] = "Menina \n Então agora você já sabe de tudo, está está aqui para me matar?";
		dialogos[10][1] = "Menina \n Eu não consigo controlar meu corpo, espero que esteja preparado.";
		dialogos[10][2] = "Menina \n Pelo menos tive uma pessoa para passsar meus ultimos suspiros, lhe agradeço por isso";
		dialogos[10][3] = "Menina \n Me perdoe pelo que irá acontecer agora";
		/**
		 * Primeira Batida(Player)
		 */
		dialogos[10][4] = "Menina \n Argh, essa espada daquele guerreiro é forte!";
		/**
		 *  Segunda Batida(Menina)
		 */
		dialogos[10][5] = "Menina \n Não consigo me controlar...";
		/**
		 * Terceira Batida(Player)
		 */
		dialogos[10][6] = "Menina \n Continue! Acho que o ser não deve aguentar muito mais!";
		/**
		 * Quarta Batida(Menina)
		 */
		dialogos[10][7] = "Menina \n Por favo resista esse ataque!";
		/**
		 * Quinta Batida(Player)
		 */
		dialogos[10][8] = "Menina \n Finalmente, vejo o fim desse sofrimento";
		dialogos[10][9] = "Menina \n O fim que você, aldeão, quiser me dar, aceitarei.";
		/**
		 * Escolha final
		 */
		dialogos [10][10] = "Deseja poupar a menina com a oração ou mata-la com a espada? \n \n  POUPAR[P]                                             MATAR[M]";
	}
	/**
	 * Adicionando diálogos da menina na tela
	 * @param g = pintar
	 * @param menina = caixa de diálogos
	 */
	public static void DialogoM(Graphics g, Menina menina) {
		
		/**
		 * Pintar janela
		 */
		Graphics2D g2 = (Graphics2D) g;
		
		/**
		 * Janela de texto
		 */
		int x = 50, y = 500, width = 1250, height= Intro.SCREEN_HEIGHT/4;
		drawSubWindow(g2,x, y, width, height);
		
		/**
		 * Imprimir frase letra por letra na caixa
		 */
		if((menina.proxima && auxiliar.length() < currentDialog.length()) &&
		(menina.personagemDelay <= menina.TrocaPosicao*2)) {
			auxiliar = auxiliar + currentDialog.charAt(contador);
			contador++;			
			Menina.dialogM = true;
		}
		
		g.setColor(Color.white);
		g.setFont(f);
		
		for(String line : currentDialog.split("\n")) {
			if(cena >= 0  && dialogos[cena][fala] != null) {
				g.drawString(line, x+30, y+35);
				y+= 45;
				x+= 10;
		
				currentDialog = dialogos[cena][fala];
			}
			
			else {
				contador = 0;
				currentDialog = "";
				auxiliar = "";
				fala = 0;
				auxPassagemdeDialogo = 0;
				CaixaMenina = false;
			}
		}
		
	}
	/**
	 * Mostrar diálogo sem se aproximar com a menina
	 * @param g = pintar
	 * @param menina = mostrar diálogo 
	 */
	public static void DialogoSemProximidade(Graphics g, MeninaBatalha menina) {
		
		Graphics2D g2 = (Graphics2D) g;
		/**
		 * Janela de texto
		 */
		int x = 50, y = 500, width = 1250, height= Intro.SCREEN_HEIGHT/4;
		drawSubWindow(g2,x, y, width, height);
		
		/**
		 * Imprimir frase letra por letra na caixa
		 */
		if((auxiliar.length() < currentDialog.length()) &&
		(menina.personagemDelay <= menina.TrocaPosicao*2)) {
			auxiliar = auxiliar + currentDialog.charAt(contador);
			contador++;			
			Menina.dialogM = true;
		}
		
		g.setColor(Color.white);
		g.setFont(f);
		
		for(String line : currentDialog.split("\n")) {
			if(cena >= 0  && dialogos[cena][fala] != null) {
				g.drawString(line, x+30, y+35);
				y+= 45;
				x+= 10;
		
				currentDialog = dialogos[cena][fala];
			}
			
			else {
				contador = 0;
				currentDialog = "";
				auxiliar = "";
				fala = 0;
				auxPassagemdeDialogo = 0;
				CaixaMenina = false;
			}
		}
		
	}
	
	public static void DialogoV(Graphics g, Velho velho) {
		
		Graphics2D g2 = (Graphics2D) g;
		
		/**
		 * Janela de texto
		 */
		int x = 50, y = 500, width = 1250, height= Intro.SCREEN_HEIGHT/4;
		drawSubWindow(g2,x, y, width, height);
		
		/**
		 * Imprimir frase letra por letra na caixa
		 */
		if((velho.proximo && auxiliar.length() < currentDialog.length()) &&
			(velho.personagemDelay <= velho.TrocaPosicao*2)) {
			auxiliar = auxiliar + currentDialog.charAt(contador);
			contador++;			
			Velho.dialogV = true;
		}
		
		g.setColor(Color.white);
		g.setFont(f);
		
		for(String line : currentDialog.split("\n")) {
			if(cena >= 0  && dialogos[cena][fala] != null) {
				g.drawString(line, x+30, y+35);
				y+= 45;
				x+= 10;
		
				currentDialog = dialogos[cena][fala];
			}
			else {
				contador = 0;
				currentDialog = "";
				auxiliar = "";
				fala = 0;
				auxPassagemdeDialogo = 0;
				CaixaMenina = false;
			}
		}
		
	}
	
	/**
	 * Desenhar caixa de diálogo do jogo
	 * @param g = pintar
	 * @param x = posição horizontal
	 * @param y = posição vertical
	 * @param width = largura
	 * @param height = altura
	 */
	public static void drawSubWindow(Graphics g, int x, int y, int width, int height) {
		Graphics2D g2 = (Graphics2D) g;
		Color c = new Color(0,0,0);
		g2.setColor(c);
		g2.fillRoundRect(x, y, width, height, 25, 25);
		
		c = new Color(255,255,255);
		g2.setColor(c);
		g2.setStroke(new BasicStroke(5));
		g2.drawRoundRect(x+5, y+5, width-10, height-10, 15, 15);
		
	}
}
	
	
	

