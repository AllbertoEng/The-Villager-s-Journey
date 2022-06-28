package Interface;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * Animações do incio do jogo
 * @author Equipe11
 *
 */
public class animacao extends JPanel implements ActionListener {
	final int SCREEN_WIDTH = 1366;
	final int SCREEN_HEIGHT = 768;
	/**
	 * Imagens da animação inicial
	 */
	String LaserPath = "images//laser.png";
	Image Laser;
	String BackgroundPath = "images//bg_red.jpg";
	Image Background;
	
	Timer timer;
	int delay = 10;
	
	/*
	 * Implementando velocidade e posição 
	 */
	int xVelocity = 5;
	int yVelocity = 5;
	int x = 0;
	int y = 0;
	int x2 = 200;
	int y2 = 200;
	
	/**
	 * Adicionando animações no painel
	 */
	animacao(){
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.black);
		Laser = new ImageIcon(LaserPath).getImage();
		Background = new ImageIcon(BackgroundPath).getImage();
		timer = new Timer(delay,this);
	}
	/**
	 * Método para "pintar" os componentes na tela
	 */
	public void paint(Graphics g) {
		super.paint(g);
		
		Graphics2D g2D = (Graphics2D) g;
		
		g2D.drawImage(Background, 0, 0, null);
		g2D.drawImage(Laser, x, y, null);
		g2D.drawImage(Laser, x2, y2, null);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(x >= SCREEN_WIDTH-Laser.getWidth(null) || x < 0) {
			xVelocity = xVelocity * -1;
		}
		x = x + xVelocity;
		x2 = x2 + xVelocity^2;
		
		if(y >= SCREEN_HEIGHT-Laser.getHeight(null) || y < 0) {
			yVelocity = yVelocity * -1;
		}
		y = y + yVelocity;
		y2 = y2 + xVelocity^2;
		repaint();
	}
}

