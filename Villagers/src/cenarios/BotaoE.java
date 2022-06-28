package cenarios;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
/**
 * Botão de interação 'E'
 * @author Equipe11
 *
 */
public class BotaoE {
	
	public Image Botao01;
	String Botao01Path = "images//botoes//button-e1.png";
	Image Botao02;
	String Botao02Path = "images//botoes//button-e2.png";
	
	/**
	 * Posição inicial do botão
	 */
	public int x;
	public int y;
	
	/**
	 * Parametrizacao animação
	 */
	public int personagemDelay = 0;
	public int TrocaPosicao = 15;
	/**
	 * Introduzindo Botão 'E'
	 * @param x = posição horizontal	
	 * @param y = posição vertical
	 */
	public BotaoE(int x, int y) {		
		this.x = x;
		this.y = y;
		/**
		 * Inicializando botão 'E'
		 */
		Botao01 = new ImageIcon(Botao01Path).getImage();
		Botao02 = new ImageIcon(Botao02Path).getImage();
	}
	/**
	 * Animação do botão 'E'
	 * @param interagir com o botão 
	 */
	public void animacao(BotaoE botao) {
		botao.personagemDelay += 1;
		if(botao.personagemDelay > (botao.TrocaPosicao*2)) {
			botao.personagemDelay = 0;
		}
	}

	/**
	 * Método para "pintar" o botão 'E' na tela
	 */
	public void draw(Graphics g) {
		if (personagemDelay <= TrocaPosicao) {
			g.drawImage(Botao01, x, y, null);
		}
		else if (personagemDelay <= (TrocaPosicao*2)) {
			g.drawImage(Botao02, x, y, null);		}
		
	}

}
