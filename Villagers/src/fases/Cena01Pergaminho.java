package fases;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import Interface.Intro;
import Interface.Janela;


public class Cena01Pergaminho extends JPanel implements ActionListener, KeyListener{
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
	
	Image Pergaminho01;
	String Pergaminho01Path = "images//pergaminho//pergaminho1.png";
	Image Pergaminho02;
	String Pergaminho02Path = "images//pergaminho//pergaminho2.png";
	Image Pergaminho03;
	String Pergaminho03Path = "images//pergaminho//pergaminho3.png";

	int TrocaFrame = 0;
	
	public Cena01Pergaminho(){ 
		Pergaminho01 = new ImageIcon(Pergaminho01Path).getImage();
		Pergaminho02 = new ImageIcon(Pergaminho02Path).getImage();
		Pergaminho03 = new ImageIcon(Pergaminho03Path).getImage();
		
		
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
		
		if(TrocaFrame <= delay) {
			g.drawImage(Pergaminho01, Pergaminho01.getWidth(null)/5, 0, null);
		}
		else if(TrocaFrame <= delay*2) {
			g.drawImage(Pergaminho02, Pergaminho01.getWidth(null)/5, 0, null);
		}
		else {
			g.drawImage(Pergaminho03, Pergaminho01.getWidth(null)/5, 0, null);
		}

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {		
		if(TrocaFrame <= delay*3) {
			TrocaFrame++;
		}
        repaint();
		
	}

	@Override
	public void keyPressed(KeyEvent e) {		
		if (e.getKeyCode() == KeyEvent.VK_E) {			
			Janela.cl.show(Janela.panelBase, "cena02");	
		}
	}
	public void keyTyped(KeyEvent e) {}
	
	public void keyReleased(KeyEvent e) {}	
}