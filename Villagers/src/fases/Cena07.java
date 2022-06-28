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

public class Cena07 extends JPanel implements ActionListener, KeyListener{
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
	Player player = new Player(5,320, "Direita");
	
	//Inicializar menina
	Menina menina = new Menina(552,323);

	//Selecionar o caminho trocando o parâmetro de Caminhos.
	Caminhos caminhos = new Caminhos(6);
	
	//Inicializar velho
	Velho velho = new Velho(555, 423);
	
	//Inicializar botao
	BotaoE botao = new BotaoE(menina.x +40, menina.y - 50);
	
	Decorativos decorativos = new Decorativos(0, 595, 546);
	Decorativos decorativos2 = new Decorativos(4, 413, 415);
	Decorativos decorativos3 = new Decorativos(8, 150, 200);
	Decorativos decorativos4 = new Decorativos(12, -50, 116);
	Decorativos decorativos5 = new Decorativos(8, 400, 200);
	Decorativos decorativos6 = new Decorativos(4, 315, 280);
	Decorativos decorativos7 = new Decorativos(0, 0, 420);
	Decorativos decorativos8 = new Decorativos(15, 39, 210);
	Decorativos decorativos9 = new Decorativos(15, 120, 210);
	
	Caixa caixa = new Caixa();
	
	public Cena07(){ 
		//
		//Inicialização do painel	
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.black);
				
		//Timer iniciado
		timer = new Timer(delay, this);
		timer.start();
		
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
		
		menina.draw(g);
		//velho.draw(g);
		
		player.draw(g);
		
		Caixa.cena = 6;

		if(menina.proxima) {
			botao.draw(g);			
		}	
		
		// Se dialogo da menina estiver disponivel e  tecla E foi pressionada, desenhe a caixa de dialogo
		if(velho.proximo == true && Caixa.CaixaMenina == true) {
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
		
		menina.proximidade(player, menina);
		menina.colisao(player, menina);
		menina.animacao(player, menina);
		
		decorativos.colisaoD(player, decorativos8, 03);
		decorativos.colisaoD(player, decorativos9, 04);
		
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
	//Mudar de cena ao chegar no fim do caminho.
	 public void passagemDeCaminho() {
     /*

	        if(player.y > 600 ) {
	            Janela.cl.show(Janela.panelBase, "cena08");
	        }
	            else if(player.x < 3) {
	        	Janela.cl.show(Janela.panelBase, "cena06");

		 /*
	        if(player.x < 3) {
	        	Janela.cena06.timer.start();
	        	Janela.cena07.timer.stop();
	            Janela.cl.show(Janela.panelBase, "cena06");
	        }
	            else */if(player.y > 610) {
            	Janela.cena08.timer.start();
	        	Janela.cena07.timer.stop();
	        	Janela.cl.show(Janela.panelBase, "cena08");
	        }
	
	 }		
}
