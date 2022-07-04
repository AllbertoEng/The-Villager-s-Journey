package cenarios;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Interface.Intro;
/**
 * Player - Batalha
 * @author Equipe11: Alberto, Cauã, Vinicius, Pedro, Arthur
 */
public class PlayerBatalha extends JPanel  {

	private static final long serialVersionUID = 1L;
	
	//Parâmetros para posição inicial
	public int x;
	public int y;	
	int corrida = 10;
	public boolean sobreposto = true;
	public boolean caminhando = true, iniciandoAtaque = false;
	public boolean atacando = false;
	public boolean dano = false;
	public boolean voltando = false;
	public int tipoAtaque = -1;
		
	//Parametrizacao animação personagem
	public int personagemDelay = 0, voltarDelay = 0;
	//Intervalo de tempo entre frames da animacao do personagem
	//Cada unidade multiplica o delay (TrocaPosicao = delay * unidade)
	public int TrocaPosicao = 15, voltar = 30;
	
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
	
	Image Ataque03;
	String pathAtaque03 = "images//player//ataque02//chico-attack-03.png";
	
	Image Ataque04;
	String pathAtaque04 = "images//player//ataque02//chico-attack-04.png";
	
	Image Ataque05;
	String pathAtaque05 = "images//player//ataque02//chico-attack-05.png";	
	
	Image Dano01;
	String Dano01Path = "images//player//dano//chico-attack-03.png";
	
	Image Dano02;
	String Dano02Path = "images//player//dano//chico-attack-04.png";
	
	Image Dano03;
	String Dano03Path = "images//player//dano//chico-attack-05.png";
	
	Image Dano04;
	String Dano04Path = "images//player//dano//chico-attack-06.png";	

	/**
	 * Inicializar posição de batalha do player
	 * @param x = posição horizontal do player
	 * @param y = posição vertical do player
	 */
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
		
		Ataque03 = new ImageIcon(pathAtaque03).getImage();
		Ataque04 = new ImageIcon(pathAtaque04).getImage();
		Ataque05 = new ImageIcon(pathAtaque05).getImage();
		
		Dano01 = new ImageIcon(Dano01Path).getImage();
		Dano02 = new ImageIcon(Dano02Path).getImage();
		Dano03 = new ImageIcon(Dano03Path).getImage();
		Dano04 = new ImageIcon(Dano04Path).getImage();
	}
	/**
	 * Player volta para posição inicial
	 * @param player = batalha com menina
	 * @param x = posição horizontal
	 * @param menina = batalha com player
	 */
	public void caminhaPosicaoInicial(PlayerBatalha player, int x, MeninaBatalha menina) {
		player.voltarDelay++;
		
        if(player.voltarDelay > (player.voltar*2)) {
        	if(player.x >= x) {
        		menina.dano = false;	
    			player.x = player.x - corrida;
    			player.atacando = false;
    			player.caminhando = true;
    			player.voltando = true;
    		}
        }	
        if(player.x < x) {  
			player.caminhando = false;    			    			
			player.voltando = false;
			player.voltarDelay = 0;
		}
	}
	
	/**
	 * Movimento horizontal durante batalha
	 * @param player = personagem que se movimentará
	 * @param x = posição horizontal
	 */
	public void caminhaPosicaoX(PlayerBatalha player, int x) {
		if(player.x <= x) {
			player.x = player.x + 1;
			
			caminhando = true;
		}
		else {
			caminhando = false;
		}
	}
		
	/**
	 * Movimento de ataque do Player
	 * @param player = ataque
	 * @param x = posição horizontal
	 */
	public void ataque01(PlayerBatalha player, int x) {
		if(player.x <= x) {
			player.x = player.x + corrida;
			
			iniciandoAtaque = true;
		}
		else {
			iniciandoAtaque = false;
			atacando = true;
			voltando = true;
		}
	}
	/**
	 * Animação de batalha do player
	 * @param player = posição
	 */
	public void animacao(PlayerBatalha player) {
		player.personagemDelay += 1;
        if(player.personagemDelay > (player.TrocaPosicao*2)) {
        	player.personagemDelay = 0;
        }
	}
	/**
	 * Método para "pintar" o PlayerBatalha na tela
	 * @param g = pinta
	 */
	public void draw(Graphics g) {
		if(dano == false) {
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
				if(tipoAtaque == 0) {
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
				else {
					if (personagemDelay <= TrocaPosicao/2) {
						g.drawImage(Ataque03, x, y, null);
					}
					else if (personagemDelay <= (TrocaPosicao)) {
						g.drawImage(Ataque04, x, y, null);
					}
					else if (personagemDelay <= TrocaPosicao*3/2) {
						g.drawImage(Ataque05, x, y, null);
					}
					else if (personagemDelay <= (TrocaPosicao*2)) {
						g.drawImage(Ataque03, x, y, null);
					}
				}
			}
		}
		else {
			if (personagemDelay <= TrocaPosicao/2) {
				g.drawImage(Dano01, x, y, null);
			}
			else if (personagemDelay <= (TrocaPosicao)) {
				g.drawImage(Dano02, x, y, null);
			}
			else if (personagemDelay <= TrocaPosicao*3/2) {
				g.drawImage(Dano03, x, y, null);
			}
			else if (personagemDelay <= (TrocaPosicao*2)) {
				g.drawImage(Dano04, x, y, null);
			}
		}
		
	}
}
