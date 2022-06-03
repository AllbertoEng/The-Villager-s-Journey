package cenarios;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class BotaoE {
	
	public Image Botao01;
	String Botao01Path = "images//botoes//button-e1.png";
	Image Botao02;
	String Botao02Path = "images//botoes//button-e2.png";
	
	//Posição inicial botao
	public int x;
	public int y;
	
	//Parametrizacao animação
	public int personagemDelay = 0;
	//Intervalo de tempo entre frames da animacao do personagem
	//Cada unidade multiplica o delay (TrocaPosicao = delay * unidade)
	public int TrocaPosicao = 15;
	
	public BotaoE(int x, int y) {		
		this.x = x;
		this.y = y;
		
		Botao01 = new ImageIcon(Botao01Path).getImage();
		Botao02 = new ImageIcon(Botao02Path).getImage();
	}
	
	public void animacao(BotaoE botao) {
		//Animacao botao
		botao.personagemDelay += 1;
		if(botao.personagemDelay > (botao.TrocaPosicao*2)) {
			botao.personagemDelay = 0;
		}
	}

	
	public void draw(Graphics g) {
		if (personagemDelay <= TrocaPosicao) {
			g.drawImage(Botao01, x, y, null);
		}
		else if (personagemDelay <= (TrocaPosicao*2)) {
			g.drawImage(Botao02, x, y, null);		}
		
	}

}
