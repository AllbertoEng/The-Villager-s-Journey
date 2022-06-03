package cenarios;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Interface.Intro;

public class PlayerBatalha extends JPanel  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Parâmetros para posição inicial
	public int x;
	public int y;	
	public boolean caminhando = true, iniciandoAtaque = false;
	public boolean atacando = false;
		
	//Parametrizacao animação personagem
	public int personagemDelay = 0;
	//Intervalo de tempo entre frames da animacao do personagem
	//Cada unidade multiplica o delay (TrocaPosicao = delay * unidade)
	public int TrocaPosicao = 15;
	
	//Imagens e seus caminhos
	//Player parado com adaga
	public Image parado01Adaga;
	String pathParado01Adaga = "images//player//paradoAdaga//chico-attack-00.png";
	Image parado02Adaga;
	String pathParado02Adaga = "images//player//paradoAdaga//chico-attack-01.png";
	
	//Player andando para direita com adaga
	Image direita01Adaga;
	String pathDireita01Adaga = "images//player//direitaAdaga//chicoliro_right-w-sword1.png";
	Image direita02Adaga;
	String pathDireita02Adaga = "images//player//direitaAdaga//chicoliro_right-w-sword2.png";
	Image direita03Adaga;
	String pathDireita03Adaga = "images//player//direitaAdaga//chicoliro_right-w-sword3.png";
	Image direita04Adaga;
	String pathDireita04Adaga = "images//player//direitaAdaga//chicoliro_right-w-sword4.png";
	
	Image Ataque01;
	String pathAtaque01 = "images//player//ataque01//chico-attack-01.png";
	Image Ataque02;
	String pathAtaque02 = "images//player//ataque01//chico-attack-02.png";
	

	//Parâmetros x e y para definir posição inicial
	//Orientação indica a direção que o player inicia, caso "Direita" a orientação é direita
	public PlayerBatalha(int x, int y) {
		this.x = x;
		this.y = y;		

		parado01Adaga = new ImageIcon(pathParado01Adaga).getImage();
		parado02Adaga = new ImageIcon(pathParado02Adaga).getImage();
		direita01Adaga = new ImageIcon(pathDireita01Adaga).getImage();
		direita02Adaga = new ImageIcon(pathDireita02Adaga).getImage();
		direita03Adaga = new ImageIcon(pathDireita03Adaga).getImage();
		direita04Adaga = new ImageIcon(pathDireita04Adaga).getImage();
		
		Ataque01 = new ImageIcon(pathAtaque01).getImage();
		Ataque02 = new ImageIcon(pathAtaque02).getImage();
	}
	
	public void caminhaPosiçãoX(PlayerBatalha player, int x) {
		if(player.x <= x) {
			player.x = player.x + 3;
			
			caminhando = true;
		}
		else {
			caminhando = false;
		}
	}
	
	public void ataque01(PlayerBatalha player, int x) {
		if(player.x <= x) {
			player.x = player.x + 10;
			
			iniciandoAtaque = true;
		}
		else {
			iniciandoAtaque = false;
			atacando = true;
		}
	}
	
	public void animacao(PlayerBatalha player) {
		//Animacao player
		player.personagemDelay += 1;
        if(player.personagemDelay > (player.TrocaPosicao*2)) {
        	player.personagemDelay = 0;
        }
	}

	public void draw(Graphics g) {
		if(caminhando == false && iniciandoAtaque == false && atacando == false) {
			if (personagemDelay <= TrocaPosicao) {
				g.drawImage(parado01Adaga, x, y, null);
			}
			else  {
				g.drawImage(parado02Adaga, x, y, null);
			}	
		}
		else if ((caminhando == true || iniciandoAtaque == true) && atacando == false) {
			if (personagemDelay <= TrocaPosicao/2) {
				g.drawImage(direita01Adaga, x, y, null);
			}
			else if (personagemDelay <= (TrocaPosicao)) {
				g.drawImage(direita02Adaga, x, y, null);
			}
			else if (personagemDelay <= TrocaPosicao*3/2) {
				g.drawImage(direita03Adaga, x, y, null);
			}
			else if (personagemDelay <= (TrocaPosicao*2)) {
				g.drawImage(direita04Adaga, x, y, null);
			}
		}
		else if (atacando) {
			if (personagemDelay <= TrocaPosicao/2) {
				g.drawImage(Ataque01, x, y, null);
			}
			else if (personagemDelay <= (TrocaPosicao)) {
				g.drawImage(Ataque02, x, y, null);
			}
			else if (personagemDelay <= TrocaPosicao*3/2) {
				g.drawImage(Ataque01, x, y, null);
			}
			else if (personagemDelay <= (TrocaPosicao*2)) {
				g.drawImage(Ataque02, x, y, null);
			}
		}
	}
}
