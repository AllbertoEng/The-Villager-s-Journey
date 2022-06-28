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

import Interface.*;

public class Cena05 extends JPanel implements ActionListener, KeyListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Resolução da tela
	final static int SCREEN_WIDTH = Intro.SCREEN_WIDTH;
	final static int SCREEN_HEIGHT = Intro.SCREEN_HEIGHT;
		
	//Timer ajustes, delay define intervalo(ms) em que ações são percebidas
	Timer timer;
	int delay = 10;  
	
	//Inicializando player
	Player player = new Player(670,600, "Direita");
	
	//Inicializar menina
	Menina menina = new Menina(500,300);

	//Selecionar o caminho trocando o parâmetro de Caminhos.
	Caminhos caminhos = new Caminhos(4);
	
	//Inicializar velho
	Velho velho = new Velho(700, 300);
	
	//Inicializar botao
	BotaoE botao = new BotaoE(menina.x +40, menina.y - 50);
	
	Decorativos decorativos = new Decorativos(5, 300, 400);
	Decorativos decorativos2 = new Decorativos(5, 400, 300);
	Decorativos decorativos3 = new Decorativos(5, 300, 400);
	Decorativos decorativos4 = new Decorativos(6, 100, 200);
	Decorativos decorativos5 = new Decorativos(9, 650, 0);
	Decorativos decorativos6 = new Decorativos(5, 400, 650);
	Decorativos decorativos7 = new Decorativos(5, 900, 300);
	Decorativos decorativos8 = new Decorativos(3, 900, 650);
	Decorativos decorativos9 = new Decorativos(2, 1000, 450);
	Decorativos decorativos10 = new Decorativos(6, 1200, 650);
	Decorativos decorativos11 = new Decorativos(4, 800, 250);
	Decorativos decorativos12 = new Decorativos(4, 1200, 100);
	Decorativos decorativos13 = new Decorativos(3, 1100, 400);
	Decorativos decorativos14 = new Decorativos(6, 1100, 400);
	Decorativos decorativos15 = new Decorativos(4, 750, 200);
	Decorativos decorativos16 = new Decorativos(4, 650, 200);
	Decorativos decorativos17 = new Decorativos(8, 550, 200);
	Decorativos decorativos18 = new Decorativos(8, 950, 100);
	Decorativos decorativos19 = new Decorativos(1, 1242, 240);

	

	

	
	
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
	
	Caixa caixa = new Caixa();
	
	public Cena05(){ 
		//
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
		decorativos15.draw(g);
		decorativos16.draw(g);
		decorativos17.draw(g);
		decorativos18.draw(g);
		decorativos19.draw(g);
	
		
		
		menina.draw(g);
		velho.draw(g);
		
		player.draw(g);
		
		Caixa.cena = 4;
		
		if(menina.proxima) {
			botao.draw(g);			
		}	
		// Se dialogo da menina estiver disponivel e  tecla E foi pressionada, desenhe a caixa de dialogo
		if(menina.proxima == true && Caixa.CaixaMenina == true) {
			Caixa.DialogoM(g, menina);
			player.travado(player);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//Verificar como passar o algoritmo para classe de diálogo >>> caua
		//Algoritmo de checar proximidade
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
		
		velho.colisao(player, velho);
		velho.animacao(player, velho);
		
		menina.proximidade(player, menina);
		menina.colisao(player, menina);
		menina.animacao(player, menina);
		
		decorativos.colisaoD(player, decorativos16, 01);
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
	
	 public void passagemDeCaminho() {
	        if(player.x > 1219) {
	        	Janela.cena06.timer.start();
	        	Janela.cena05.timer.stop();
	        	Janela.getIntro().clip.stop();
	        	Janela.getIntro().playAudio(Janela.getIntro().vilaSombrio, 99);
	            Janela.cl.show(Janela.panelBase, "cena06");
	        }/*
	            else if(player.y > 610) {
	            	Janela.cena04.timer.start();
		        	Janela.cena05.timer.stop();
	        	Janela.cl.show(Janela.panelBase, "cena04");
	        }*/

	
	
	 	}
	 }
