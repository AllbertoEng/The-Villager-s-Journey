package cenarios;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Interface.Intro;
/**
 * Player - Personagem
 * @author Equipe11: Alberto, Cauã, Vinicius, Pedro, Arthur
 */
public class Player extends JPanel  {

	private static final long serialVersionUID = 1L;
	
	//Parâmetros para movimentação, velocidade inicial e posição inicial
	public int x;
	public int y;
	public int velx = 0;
	public int vely = 0;
	public int velMax = 5;
	public boolean w = false, s = false, a = false, d = false, aaux = false, daux = false;
	
	
	public boolean direita = false;
	String orientacao;
	public boolean adaga = false;
		
	//Parametrizacao animação personagem
	public int personagemDelay = 0;
	//Intervalo de tempo entre frames da animacao do personagem
	//Cada unidade multiplica o delay (TrocaPosicao = delay * unidade)
	public int TrocaPosicao = 13;
	
	//Imagens e seus caminhos
	//Player parado
	public Image parado01;
	String pathParado01 = "images//player//parado//player_parado1.png";
	
	Image parado02;
	String pathParado02 = "images//player//parado//player_parado2.png";
	
	//Player esquerda
	Image paradoEsquerda01;
	String pathParadoEsquerda01 = "images//player//parado//player_parado_left1.png";
	
	Image paradoEsquerda02;
	String pathParadoEsquerda02 = "images//player//parado//player_parado_left2.png";
	
	//Player andando para direita
	Image direita01;
	String pathDireita01 = "images//player//direita//player_andando_right1.png";
	
	Image direita02;
	String pathDireita02 = "images//player//direita//player_andando_right2.png";
	
	Image direita03;
	String pathDireita03 = "images//player//direita//player_andando_right3.png";
	
	Image direita04;
	String pathDireita04 = "images//player//direita//player_andando_right4.png";
	
	//Player andando para esquerda
	Image esquerda01;
	String pathEsquerda01 = "images//player//esquerda//player_andando_left1.png";
	
	Image esquerda02;
	String pathEsquerda02 = "images//player//esquerda//player_andando_left2.png";
	
	Image esquerda03;
	String pathEsquerda03 = "images//player//esquerda//player_andando_left3.png";
	
	Image esquerda04;
	String pathEsquerda04 = "images//player//esquerda//player_andando_left4.png";
	
	//***********************************************ADAGA************************************************
	//Player parado com adaga
	public Image parado01Adaga;
	String pathParado01Adaga = "images//player//paradoAdaga//chico-attack-00.png";
	
	Image parado02Adaga;
	String pathParado02Adaga = "images//player//paradoAdaga//chico-attack-01.png";
	
	//Player esquerda com adaga
	Image paradoEsquerda01Adaga;
	String pathParadoEsquerda01Adaga = "images//player//paradoAdaga//chico-00-left1.png";
	
	Image paradoEsquerda02Adaga;
	String pathParadoEsquerda02Adaga = "images//player//paradoAdaga//chico-00-left2.png";
	
	//Player andando para direita com adaga
	Image direita01Adaga;
	String pathDireita01Adaga = "images//player//direitaAdaga//chicoliro_right-w-sword1.png";
	
	Image direita02Adaga;
	String pathDireita02Adaga = "images//player//direitaAdaga//chicoliro_right-w-sword2.png";
	
	Image direita03Adaga;
	String pathDireita03Adaga = "images//player//direitaAdaga//chicoliro_right-w-sword3.png";
	
	Image direita04Adaga;
	String pathDireita04Adaga = "images//player//direitaAdaga//chicoliro_right-w-sword4.png";
	
	//Player andando para esquerda com adaga
	Image esquerda01Adaga;
	String pathEsquerda01Adaga = "images//player//esquerdaAdaga//chicoliro_left-w-sword1.png";
	
	Image esquerda02Adaga;
	String pathEsquerda02Adaga = "images//player//esquerdaAdaga//chicoliro_left-w-sword2.png";
	
	Image esquerda03Adaga;
	String pathEsquerda03Adaga = "images//player//esquerdaAdaga//chicoliro_left-w-sword3.png";
	
	Image esquerda04Adaga;
	String pathEsquerda04Adaga = "images//player//esquerdaAdaga//chicoliro_left-w-sword4.png";

	/**
	 * Inicializar posição do player
	 * @param x = posição horizontal do player
	 * @param y = posição vertical do player
	 * @param orientacao = indica a direção que o player inicia, caso "Direita" a orientação é direita.
	 */
	public Player(int x, int y, String orientacao) {
		this.x = x;
		this.y = y;
		this.orientacao = orientacao;
		
		if(orientacao == "Direita") {
			direita = true;
		}		
				
		//Player normal (adaga = false)
		parado01 = new ImageIcon(pathParado01).getImage();
		parado02 = new ImageIcon(pathParado02).getImage();
		paradoEsquerda01 = new ImageIcon(pathParadoEsquerda01).getImage();
		paradoEsquerda02 = new ImageIcon(pathParadoEsquerda02).getImage();
		
		direita01 = new ImageIcon(pathDireita01).getImage();
		direita02 = new ImageIcon(pathDireita02).getImage();
		direita03 = new ImageIcon(pathDireita03).getImage();
		direita04 = new ImageIcon(pathDireita04).getImage();
		esquerda01 = new ImageIcon(pathEsquerda01).getImage();
		esquerda02 = new ImageIcon(pathEsquerda02).getImage();
		esquerda03 = new ImageIcon(pathEsquerda03).getImage();
		esquerda04 = new ImageIcon(pathEsquerda04).getImage();
		
		//Player com adaga (adaga = true)
		parado01Adaga = new ImageIcon(pathParado01Adaga).getImage();
		parado02Adaga = new ImageIcon(pathParado02Adaga).getImage();
		paradoEsquerda01Adaga = new ImageIcon(pathParadoEsquerda01Adaga).getImage();
		paradoEsquerda02Adaga = new ImageIcon(pathParadoEsquerda02Adaga).getImage();
		
		direita01Adaga = new ImageIcon(pathDireita01Adaga).getImage();
		direita02Adaga = new ImageIcon(pathDireita02Adaga).getImage();
		direita03Adaga = new ImageIcon(pathDireita03Adaga).getImage();
		direita04Adaga = new ImageIcon(pathDireita04Adaga).getImage();
		esquerda01Adaga = new ImageIcon(pathEsquerda01Adaga).getImage();
		esquerda02Adaga = new ImageIcon(pathEsquerda02Adaga).getImage();
		esquerda03Adaga = new ImageIcon(pathEsquerda03Adaga).getImage();
		esquerda04Adaga = new ImageIcon(pathEsquerda04Adaga).getImage();
	}
	/**
	 * Algoritmo de colisão do player com as bordas da tela
	 * @param player = colisão em relação ao player
	 */
	public void colisaoTotalTela(Player player){
		if(player.x >= Intro.SCREEN_WIDTH - player.parado01.getWidth(null)) {
			player.x = player.x - player.velMax;
		}
		else if(player.x <= -1) {
			player.x = player.x + player.velMax;
		}
		if(player.y >= Intro.SCREEN_HEIGHT - player.parado01.getHeight(null) ) {
			player.y = player.y - player.velMax;
		}
		else if(player.y <= -1) {
			player.y = player.y + player.velMax;
		}
	}
	/**
	 * Animação do player
	 * @param player = posição e velocidade
	 */
	public void animacao(Player player) {
		player.x = player.x + player.velx;
		player.y = player.y + player.vely;
		player.personagemDelay += 1;
        if(player.personagemDelay > (player.TrocaPosicao*2)) {
        	player.personagemDelay = 0;
        }
	}
	/**
	 * Player 'trava' ao parar de pressionar as teclas de movimento
	 * @param player = travar
	 */
	public void travado(Player player) {
		player.x = player.x - player.velx;
		player.y = player.y - player.vely;
	}
	
	public void up() {
        vely = -1*velMax;
    }

    public void down() {
        vely = velMax;
    }

    public void left() {
        velx = -1*velMax;
    }

    public void right() {
        velx = velMax;
    }
    /**
     * Método para "pintar" o Player na tela
     */
	public void draw(Graphics g) {
		Graphics2D cena022D = (Graphics2D) g;
		super.paintComponent(cena022D);
		if(adaga) {
			if (w == true & d == true | s == true & d == true |  daux == true) {
				if (personagemDelay <= TrocaPosicao/2) {
					cena022D.drawImage(direita01Adaga, x, y, null);
				}
				else if (personagemDelay <= (TrocaPosicao)) {
					cena022D.drawImage(direita02Adaga, x, y, null);
				}
				else if (personagemDelay <= TrocaPosicao*3/2) {
					cena022D.drawImage(direita03Adaga, x, y, null);
				}
				else if (personagemDelay <= (TrocaPosicao*2)) {
					cena022D.drawImage(direita04Adaga, x, y, null);
				}	
			}
			
			else if (w == true & a == true | s == true & a == true | aaux == true) {
				if (personagemDelay <= TrocaPosicao/2) {
					cena022D.drawImage(esquerda01Adaga, x, y, null);
				}
				else if (personagemDelay <= (TrocaPosicao)) {
					cena022D.drawImage(esquerda02Adaga, x, y, null);
				}
				else if (personagemDelay <= TrocaPosicao*3/2) {
					cena022D.drawImage(esquerda03Adaga, x, y, null);
				}
				else if (personagemDelay <= (TrocaPosicao*2)) {
					cena022D.drawImage(esquerda04Adaga, x, y, null);
				}	
			}
			
			else if (w == true | s == true) {
				if (personagemDelay <= TrocaPosicao/2) {
					cena022D.drawImage(direita01Adaga, x, y, null);
				}
				else if (personagemDelay <= (TrocaPosicao)) {
					cena022D.drawImage(direita02Adaga, x, y, null);
				}
				else if (personagemDelay <= TrocaPosicao*3/2) {
					cena022D.drawImage(direita03Adaga, x, y, null);
				}
				else if (personagemDelay <= (TrocaPosicao*2)) {
					cena022D.drawImage(direita04Adaga, x, y, null);
				}	
			}
			
			else {	
				if(direita) {
					if (personagemDelay <= TrocaPosicao) {
						cena022D.drawImage(parado01Adaga, x, y, null);
					}
					else if (personagemDelay <= (TrocaPosicao*2)) {
						cena022D.drawImage(parado02Adaga, x, y, null);
					}
				}
				else {
					if (personagemDelay <= TrocaPosicao) {
						cena022D.drawImage(paradoEsquerda01Adaga, x, y, null);
					}
					else if (personagemDelay <= (TrocaPosicao*2)) {
						cena022D.drawImage(paradoEsquerda02Adaga, x, y, null);
					}
					
				}
									
			}
		}
		else {
			if (w == true & d == true | s == true & d == true |  daux == true) {
				if (personagemDelay <= TrocaPosicao/2) {
					cena022D.drawImage(direita01, x, y, null);
				}
				else if (personagemDelay <= (TrocaPosicao)) {
					cena022D.drawImage(direita02, x, y, null);
				}
				else if (personagemDelay <= TrocaPosicao*3/2) {
					cena022D.drawImage(direita03, x, y, null);
				}
				else if (personagemDelay <= (TrocaPosicao*2)) {
					cena022D.drawImage(direita04, x, y, null);
				}	
			}
			
			else if (w == true & a == true | s == true & a == true | aaux == true) {
				if (personagemDelay <= TrocaPosicao/2) {
					cena022D.drawImage(esquerda01, x, y, null);
				}
				else if (personagemDelay <= (TrocaPosicao)) {
					cena022D.drawImage(esquerda02, x, y, null);
				}
				else if (personagemDelay <= TrocaPosicao*3/2) {
					cena022D.drawImage(esquerda03, x, y, null);
				}
				else if (personagemDelay <= (TrocaPosicao*2)) {
					cena022D.drawImage(esquerda04, x, y, null);
				}	
			}
			
			else if (w == true | s == true) {
				if (personagemDelay <= TrocaPosicao/2) {
					cena022D.drawImage(direita01, x, y, null);
				}
				else if (personagemDelay <= (TrocaPosicao)) {
					cena022D.drawImage(direita02, x, y, null);
				}
				else if (personagemDelay <= TrocaPosicao*3/2) {
					cena022D.drawImage(direita03, x, y, null);
				}
				else if (personagemDelay <= (TrocaPosicao*2)) {
					cena022D.drawImage(direita04, x, y, null);
				}	
			}
			
			else {	
				if(direita) {
					if (personagemDelay <= TrocaPosicao) {
						cena022D.drawImage(parado01, x, y, null);
					}
					else if (personagemDelay <= (TrocaPosicao*2)) {
						cena022D.drawImage(parado02, x, y, null);
					}
				}
				else {
					if (personagemDelay <= TrocaPosicao) {
						cena022D.drawImage(paradoEsquerda01, x, y, null);
					}
					else if (personagemDelay <= (TrocaPosicao*2)) {
						cena022D.drawImage(paradoEsquerda02, x, y, null);
					}
					
				}
									
			}
		}	
	}
}
