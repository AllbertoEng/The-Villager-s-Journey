package fases;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
 * Classe Cena03
 * @author Equipe11: Alberto, Cauã, Vinicius, Pedro, Arthur
 *
 */
public class Cena02 extends JPanel implements ActionListener, KeyListener{

	private static final long serialVersionUID = 1L;
	
	//Resolução da tela
	final static int SCREEN_WIDTH = Intro.SCREEN_WIDTH;
	final static int SCREEN_HEIGHT = Intro.SCREEN_HEIGHT;
	
	//Timer ajustes, delay define intervalo(ms) em que ações são percebidas
	Timer timer;
	int delay = 10;  
	
	//Inicializando player
	Player player = new Player(0,500, "Direita");
	
	//Selecionar o caminho trocando o parâmetro de Caminhos.
	Caminhos caminhos = new Caminhos(1);

	Decorativos decorativos = new Decorativos(0, 300, 420);
	Decorativos decorativos3 = new Decorativos(0, 700, 420);
	Decorativos decorativos6 = new Decorativos(5, 810, 300);
	Decorativos decorativos7 = new Decorativos(5, 240, 150);
	Decorativos decorativos8 = new Decorativos(5, 400, 380);
	Decorativos decorativos9 = new Decorativos(5, 20, 300);
	
	/*
	 *Lista de decorativos:
	 	0 - Cogumelos
	 	1 - Placa de perigo
	 	2 - Arbusto
	 	3 - Arbusto com frutas
	 	4 - Arbusto em chamas
	 	5 - Arvore com frutos
	 	6 - Arvore 
	 	7 - Arvore seca
	 	8 - Arvore seca em chamas
	 	9 - Casa 01
	 	10 - Casa 02
	 	11 - Casa 03
	 	12 - Casa 04
	 	13 - Casa 05
	 	14 - Mercado Guerreiro
	 	
	 */

	//Caracterização da Cena
	public Cena02(){ 
		//Inicialização do painel	
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.black);
				
		//Timer iniciado
		timer = new Timer(delay, this);
		//timer.start();
		
		//Parâmetros para detecção do teclado
		requestFocusInWindow();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		
	}
	
	public void paint(Graphics g) {
		requestFocusInWindow();
		super.paint(g);
		
		caminhos.draw(g);
		decorativos.draw(g);
		decorativos3.draw(g);
		decorativos6.draw(g);
		decorativos7.draw(g);
		decorativos8.draw(g);
		decorativos9.draw(g);
	
		player.draw(g);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		player.animacao(player);
		player.colisaoTotalTela(player);
		
		decorativos.colisaoD(player, decorativos6, 5);
		decorativos.colisaoD(player, decorativos7, 5);
		
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
			
		}

	}

	public void keyTyped(KeyEvent e) {}
	
	public void keyReleased(KeyEvent e) {
		//iguala zero aqui para parar o movimento quanto soltar o botao
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
	 * Algoritmo para mudar de cena ao chegar no fim do caminho
	 */
	public void passagemDeCaminho() {
		if(player.x > 1219) {
	    	Janela.cena03.timer.start();
	    	Janela.cena02.timer.stop();
	        Janela.cl.show(Janela.panelBase, "cena03");
	    }
	}
	
}
