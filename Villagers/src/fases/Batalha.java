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
import cenarios.BotaoE;
import cenarios.Caminhos;
import cenarios.MeninaBatalha;
import cenarios.PlayerBatalha;


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
	int delay = 10;  
	
	
	Caminhos caminhos = new Caminhos(11);
	MeninaBatalha menina = new MeninaBatalha(SCREEN_WIDTH/3*2 -120, SCREEN_HEIGHT/3);
	PlayerBatalha player = new PlayerBatalha(0, SCREEN_HEIGHT/3);
	
	//REMOVER
	BotaoE botao = new BotaoE(SCREEN_WIDTH/3 -100, player.y -50);
	boolean aparecerbotao = false;
	
	public Batalha(){ 
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
		player.draw(g);
		menina.draw(g);
		
		
		//REMOVER
		if(aparecerbotao) {
			botao.draw(g);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//REMOVER
		if(player.caminhando == false && player.iniciandoAtaque ==false && player.atacando ==false) {
			aparecerbotao = true;
			botao.animacao(botao);
		}
		else {
			aparecerbotao = false;
		}
		
		//MENINA
		menina.animacao(menina);
		
		if(menina.iniciandoAtaque) {
			menina.ataque01(menina, player.x + 100);
		}
		
		//Player
		player.animacao(player);		
		
		if(player.caminhando) {
			player.caminhaPosiçãoX(player, SCREEN_WIDTH/3 -120);
		}			
		if(player.iniciandoAtaque) {
			player.ataque01(player, menina.x - 100);
		}
		player.animacao(player);
		
        repaint();
		
	}

	@Override
	public void keyPressed(KeyEvent e) {	
		if (e.getKeyCode() == KeyEvent.VK_E) {
			if (player.caminhando == false) {
				menina.iniciandoAtaque = true;
			}			
		}
	}
		
	
	
	
	public void keyTyped(KeyEvent e) {}
	
	public void keyReleased(KeyEvent e) {}
	


	
	
}
