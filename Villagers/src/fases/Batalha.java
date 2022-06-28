package fases;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import Interface.Intro;
import Interface.Janela;
import cenarios.*;
import dialogos.Caixa;


public class Batalha extends JPanel implements ActionListener, KeyListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Resolução da tela
	final static int SCREEN_WIDTH = Intro.SCREEN_WIDTH;
	final static int SCREEN_HEIGHT = Intro.SCREEN_HEIGHT;
		
	//Timer ajustes, delay define intervalo(ms) em que ações são percebidas
	Timer timer;
	int delay = 15;  
	
	
	Caminhos caminhos = new Caminhos(11);
	MeninaBatalha menina = new MeninaBatalha(SCREEN_WIDTH/3*2 -120, SCREEN_HEIGHT/3);
	PlayerBatalha player = new PlayerBatalha(0, SCREEN_HEIGHT/3);
	
	boolean aparecerbotao = false;
	
	public Batalha(){ 
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
		

		if(player.sobreposto) {
			menina.draw(g);
			player.draw(g);
			
		}
		else {
			player.draw(g);
			menina.draw(g);			
		}
		if((player.caminhando == false &&
				menina.iniciandoAtaque == false && menina.voltando == false) &&
				player.iniciandoAtaque == false && player.voltando == false) {
			Caixa.cena = 10;
			Caixa.DialogoSemProximidade(g, menina);
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//Pedir para java ativar garbage collector
		System.gc();
		
		if(!Janela.getIntro().clip.isRunning()) {
			Janela.getIntro().playAudio(Janela.getIntro().batalha2, 99);
		}
		
		//MENINA
		menina.animacao(menina);
		
		if(menina.iniciandoAtaque) {
			menina.ataque01(menina, player.x + 100);
			if(menina.atacando) {
				player.dano = true;
			}
		}
		if(menina.voltando) {
			menina.caminhaPosicaoInicial(menina, SCREEN_WIDTH/3*2 -120, player);
		}		
				
		
		//Player
		player.animacao(player);
		
		if(player.caminhando) {
			player.caminhaPosicaoX(player, SCREEN_WIDTH/3 -120);
		}			
		if(player.iniciandoAtaque) {
			player.ataque01(player, menina.x - 100);
			if(player.atacando) {
				menina.dano = true;					
			}
		}
		if(player.voltando) {
			if(player.atacando == false && Caixa.fala >= 7) {
				menina.meninaDerrotada = true;
				player.caminhando = false;    			    			
				player.voltando = false;
			}
			else {
				player.caminhaPosicaoInicial(player, SCREEN_WIDTH/3 -120, menina);
			}
			
		}		
        repaint();
		
	}

	@Override
	public void keyPressed(KeyEvent e) {	
		if (e.getKeyCode() == KeyEvent.VK_E) {
			if((player.caminhando == false &&
					menina.iniciandoAtaque == false && menina.voltando == false) &&
					player.iniciandoAtaque == false && player.voltando == false){

				//Player ataca
				if(Caixa.fala == 3 || Caixa.fala == 5 || Caixa.fala == 7) { 
					player.sobreposto = true;
					player.iniciandoAtaque = true;
					
					player.tipoAtaque++;
					if(player.tipoAtaque > 1) {
						player.tipoAtaque = 0;
					}					
				}
				
				//Menina ataca
				else if(Caixa.fala == 4 || Caixa.fala == 6 ) {
					player.sobreposto = false;
					menina.iniciandoAtaque = true;
					
					menina.tipoAtaque++;
					if(menina.tipoAtaque > 1) {
						menina.tipoAtaque = 0;
					}
				}
				
				if(Caixa.auxPassagemdeDialogo != 0) {
					Caixa.currentDialog = "";
					Caixa.auxiliar = "";	
					Caixa.contador = 0;
					Caixa.fala++;
				}
				Caixa.CaixaMenina = true;				
				Caixa.auxPassagemdeDialogo++;

			}
			
		}
	}	
	
	public void keyTyped(KeyEvent e) {}
	
	public void keyReleased(KeyEvent e) {}	
	
}
