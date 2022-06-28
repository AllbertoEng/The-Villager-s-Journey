package fases;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import Interface.Exe;
import Interface.Intro;
import Interface.Janela;
import cenarios.BotaoE;
import cenarios.Caminhos;
import cenarios.Decorativos;
import cenarios.Menina;
import cenarios.Player;
import cenarios.Velho;
import dialogos.Caixa;
/**
 * Classe Cena06
 * @author Equipe11.
 *
 */
public class Cena06 extends JPanel implements ActionListener, KeyListener{

	private static final long serialVersionUID = 1L;
	
	/**
	 * Resolução da Tela
	 */
	final static int SCREEN_WIDTH = Intro.SCREEN_WIDTH;
	final static int SCREEN_HEIGHT = Intro.SCREEN_HEIGHT;
		
	/**
	 * Timer ajustes, delay define intervalo(ms) em que ações são percebidas
	 */
	Timer timer;
	int delay = 10;  
	
	/**
	 * Inicializar Payer.
	 */
	Player player = new Player(15,320, "Direita");
	
	/**
	 * Inicializar Menina.
	 */
	Menina menina = new Menina(545,440);

	/**
	 * Selecionar o caminho trocando o parâmetro de Caminhos
	 */
	Caminhos caminhos = new Caminhos(5);
	
	/**
	 * Inicializar velho
	 */
	Velho velho = new Velho(660, 439);
	
	/**
	 * Inicializar botão de diálogo.
	 */
	BotaoE botao = new BotaoE(menina.x +40, menina.y - 50);
	
	/**
	 * Adicionar Decorativos pelo número e coordenadas na Cena.
	 */
	Decorativos decorativos = new Decorativos(6, 100, 220);
	Decorativos decorativos2 = new Decorativos(10, 988, 160);
	Decorativos decorativos3 = new Decorativos(11, 720, 163);
	Decorativos decorativos4 = new Decorativos(7, 550, 210);
	Decorativos decorativos5 = new Decorativos(13, 290, 161);
	Decorativos decorativos6 = new Decorativos(0, 1220, 317);
	Decorativos decorativos7 = new Decorativos(4, 1255, 268);
	Decorativos decorativos8 = new Decorativos(15, 300, 220);
	Decorativos decorativos9 = new Decorativos(15, 890, 220);
	Decorativos decorativos10 = new Decorativos(15, 396, 220);
	Decorativos decorativos11 = new Decorativos(15, 709, 220);
	Decorativos decorativos12 = new Decorativos(15, 805, 220);
	Decorativos decorativos13 = new Decorativos(15, 1105, 220);
	Decorativos decorativos14 = new Decorativos(15, 1020, 220);
	
	/**
	 * Inicializando caixa de diálogos.
	 */
	Caixa caixa = new Caixa();
	
	public Cena06(){ 
		/**
		 * Inicializar painel.
		 */
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.black);
		
		/**
		 * Timer iniciado
		 */
		timer = new Timer(delay, this);

		
		/**
		 * Parâmetros para detecção de teclado.
		 */
		requestFocusInWindow();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		
	}
	/**
	 * Pintar componentes na tela.
	 * @param Graphics g
	 */
	public void paint(Graphics g) {
		requestFocusInWindow();
		super.paint(g);
		
		caminhos.draw(g);
		decorativos.draw(g);
		decorativos2.draw(g);
		decorativos3.draw(g);
		decorativos4.draw(g);
		decorativos5.draw(g);
		decorativos6.draw(g);
		decorativos7.draw(g);
		decorativos8.draw(g);
		decorativos9.draw(g);
		decorativos10.draw(g);
		decorativos11.draw(g);
		decorativos12.draw(g);
		decorativos13.draw(g);
		decorativos14.draw(g);
		
		menina.draw(g);
		
		player.draw(g);
		
		Caixa.cena = 5;

		if(menina.proxima) {
			botao.draw(g);			
		}	
		
		/**
		 * Se diálogo da menina estiver disponvel e  tecla 'E' foi pressionada, desenhe a caixa de dialogo
		 */
		if(velho.proximo == true && Caixa.CaixaMenina == true) {
			Caixa.DialogoM(g, menina);
			player.travado(player);
		}
	}
	
	/**
	 * Verificar como passar o algoritmo para classe de diálogo.
	 * @param ActionEvent e
	 * @author Cauã
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		/**
		 * Algoritmo de checar proximidade
		 */
		if((player.x >= menina.x - 150 && player.x <= menina.x + 150) &&
				(player.y >= menina.y - 150 && player.y <= menina.y +150)) {
			menina.proxima = true;
		}
		else {
			menina.proxima = false;
			menina.contador = 0;
			menina.Frase = "";
		}
		
		botao.animacao(botao);
		
		player.animacao(player);
		player.colisaoTotalTela(player);
		
		
		menina.proximidade(player, menina);
		menina.colisao(player, menina);
		menina.animacao(player, menina);
		
		/**
		 * Colisão do player com Decorativos.
		 */
		decorativos.colisaoD(player, decorativos8, 03);
		decorativos.colisaoD(player, decorativos9, 03);
		decorativos.colisaoD(player, decorativos10, 03);
		decorativos.colisaoD(player, decorativos11, 04);
		decorativos.colisaoD(player, decorativos12, 03);
		decorativos.colisaoD(player, decorativos13, 04);
		decorativos.colisaoD(player, decorativos14, 03);
		
		
		passagemDeCaminho();
        
		repaint();
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W) {
			player.w = true;
			player.up();
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			player.s =  true;
			player.down();
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			player.a = true;
			player.left();
			
			player.daux = false;
			player.aaux = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			player.d = true;
			player.right();
		
			player.aaux = false;
			player.daux = true;
		}
		
		if (e.getKeyCode() == KeyEvent.VK_E) {
			if(menina.proxima) {
				if(Caixa.auxPassagemdeDialogo != 0) {
					Caixa.currentDialog = "";
					Caixa.auxiliar = "";	
					Caixa.contador = 0;
					Caixa.fala++;
				}
				Caixa.CaixaMenina = true;
				System.out.println("Botao E pressionado proximo a menina.");
				
				Caixa.auxPassagemdeDialogo++;

			}
			else {
				System.out.println("Botao E pressionado longe da menina.");
			}
			
		}
	}
		
	
	
	/**
	 * Movimento e velocidade do Player.
	 * @param KeyEvent e
	 */
	public void keyTyped(KeyEvent e) {}
	
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W) {
			player.w = false;
			player.vely = 0;
		}
		
		if (e.getKeyCode() == KeyEvent.VK_S) {
			player.s = false;
			player.vely = 0;
		}
		
		if (e.getKeyCode() == KeyEvent.VK_A) {
			player.a = false;
			player.velx = 0;
			
			player.direita = false;
			
			if(player.d) {
				player.daux = true;
			}
			player.aaux = false;
			
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			player.d = false;
			player.velx = 0;
			
			player.direita = true;
			
			if(player.a) {
				player.aaux = true;
			}
			player.daux = false;
		}

		if(player.w == true & player.s == false) {
			player.up();
		}
		else if(player.w == false & player.s == true) {
			player.down();
		}
		
		if(player.a == true & player.d == false) {
			player.left();
		}
		else if(player.a == false & player.d == true) {
			player.right();
		}
	}

	/**
	 * Método para mudar de cena.
	 */
	 public void passagemDeCaminho() {
	        if(player.x > 1219 && player.y == 320) {
	        	Janela.cena07.timer.start();
	        	Janela.cena06.timer.stop();
	            Janela.cl.show(Janela.panelBase, "cena07");
	        }
	
	 }	
	
	
}
