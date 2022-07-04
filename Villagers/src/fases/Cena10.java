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
import cenarios.PlayerBatalha;
import cenarios.Velho;
import dialogos.Caixa;
/**
 * Classe Cena10
 * @author Equipe11: Alberto, Cauã, Vinicius, Pedro, Arthur
 *
 */
public class Cena10 extends JPanel implements ActionListener, KeyListener{

	private static final long serialVersionUID = 1L;
	
	//Resolução da tela
	final static int SCREEN_WIDTH = Intro.SCREEN_WIDTH;
	final static int SCREEN_HEIGHT = Intro.SCREEN_HEIGHT;
		
	//Timer ajustes, delay define intervalo(ms) em que ações são percebidas
	Timer timer;
	int delay = 10;  
	
	//Inicializando player
	Player player = new Player(20,370, "Direita");

	//Selecionar o caminho trocando o parâmetro de Caminhos.
	Caminhos caminhos = new Caminhos(9);
	
	//Inicializar velho
	Velho velho = new Velho(800, 250);
	
	//Inicializar botao
	BotaoE botao = new BotaoE(velho.x +40, velho.y - 50);

	Decorativos decorativos4 = new Decorativos(6, 120, 200);
	Decorativos decorativos5 = new Decorativos(5, 500, 90);
	Decorativos decorativos6 = new Decorativos(6, 200, 10);
	Decorativos decorativos8 = new Decorativos(8, 1160, 70);
	Decorativos decorativos9 = new Decorativos(14, 900, 200);
	Decorativos decorativos10 = new Decorativos(6, 0, 600);
	Decorativos decorativos11 = new Decorativos(6, 150, 600);
	Decorativos decorativos12 = new Decorativos(6, 300, 600);
	Decorativos decorativos13 = new Decorativos(6, 900, 600);
	Decorativos decorativos14 = new Decorativos(6, 1050, 600);
	Decorativos decorativos15 = new Decorativos(6, 1200, 600);
	Decorativos decorativos17 = new Decorativos(3, 550, 650);
	Decorativos decorativos18 = new Decorativos(3, 650, 650);
	Decorativos decorativos19 = new Decorativos(3, 750, 650);
	
	Caixa caixa = new Caixa();
	
	//Caracterização da Cena
	public Cena10(){ 
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
		decorativos4.draw(g);
		decorativos5.draw(g);
		decorativos6.draw(g);
		decorativos8.draw(g);
		decorativos9.draw(g);
		decorativos10.draw(g);
		decorativos11.draw(g);
		decorativos12.draw(g);
		decorativos13.draw(g);
		decorativos14.draw(g);
		decorativos15.draw(g);
		decorativos17.draw(g);
		decorativos18.draw(g);
		
		
		velho.draw(g);
		
		player.draw(g);
	
		Caixa.cena = 9;

		if(velho.proximo) {
			botao.draw(g);			
		}	
		
		// Se dialogo da menina estiver disponivel e  tecla E foi pressionada, desenhe a caixa de dialogo
		if(velho.proximo == true && Caixa.CaixaMenina == true) {
			Caixa.DialogoV(g, velho);
			player.travado(player);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//Verificar como passar o algoritmo para classe de diálogo >>> caua
		//Algoritmo de checar proximidade
		if((player.x >= velho.x - 150 && player.x <= velho.x + 150) &&
				(player.y >= velho.y - 150 && player.y <= velho.y +150)) {
			velho.proximo = true;
		}
		else {
			velho.proximo = false;
			velho.contador = 0;
			velho.Frase = "";
		}
		
		botao.animacao(botao);
		
		player.animacao(player);
		player.colisaoTotalTela(player);
		
		velho.colisao(player, velho);
		velho.animacao(player, velho);
		velho.proximidade(player, velho);

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
			if(velho.proximo && player.adaga == false) {
				if(Caixa.auxPassagemdeDialogo != 0) {
					Caixa.currentDialog = "";
					Caixa.auxiliar = "";	
					Caixa.contador = 0;
					Caixa.fala++;
					if(Caixa.fala == 6) {
						velho.entregaAdaga = true;
					}
					else if(Caixa.fala == 7) {
						velho.adaga = false;
						player.adaga = true;
						Janela.cena11.player.adaga = true;
					}
				}
				Caixa.CaixaMenina = true;
				
				Caixa.auxPassagemdeDialogo++;

			}
			else {
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
	/**
	 *Algoritmo para mudar de cena ao chegar no fim do caminho
	*/
	public void passagemDeCaminho() {
		if(player.adaga) {
			if(player.y < Intro.SCREEN_HEIGHT - 751) {
	        	Janela.cena11.timer.start();
	        	Janela.cena10.timer.stop();
	            Janela.cl.show(Janela.panelBase, "cena11");
	        }
		}        
  
	}	
	
	
}
