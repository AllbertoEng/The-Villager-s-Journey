package cenarios;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
/**
 * Velho - Personagem
 * @author Equipe11
 *
 */
public class Velho {
	/**
	 * Velho olhando para a direita
	 */
	Image VelhoDireita01;
	String VelhoDireita01Path = "images//Velho//parado//velho_right1.png";
	Image VelhoDireita02;
	String VelhoDireita02Path = "images//Velho//parado//velho_right2.png";
	/**
	 * Velho olhando para a esquerda
	 */
	public Image VelhoEsquerda01;
	String VelhoEsquerda01Path = "images//Velho//parado//velho_left1.png";
	Image VelhoEsquerda02;
	String VelhoEsquerda02Path = "images//Velho//parado//velho_left2.png";
	/**
	 * Velho com a adaga
	 */
	public Image VelhoAdaga01;
	String VelhoAdaga01Path = "images//Velho//entregaAdaga//velho-sword1.png";
	Image VelhoAdaga02;
	String VelhoAdaga02Path = "images//Velho//entregaAdaga//velho-sword2.png";
	Image VelhoAdaga03;
	String VelhoAdaga03Path = "images//Velho//entregaAdaga//velho-sword3.png";
	
	/**
	 * Iniciar posição do Velho
	 */
	public int x;
	public int y;
	public boolean orientacaoVelho = false, proximo = false;
	public boolean adaga = false, entregaAdaga = false;
	/**
	 * Desenvolvendo a caixa de diálogos do velho.
	 */
	static int fontSize = 20;
	public int contador = 0;
    static Font f = new Font("Comic Sans MS", Font.BOLD, fontSize);
    public String Frase = "";
	
	public static boolean dialogV = false;
	
	//Parametrizacao animação personagem
	public int personagemDelay = 0;
	//Intervalo de tempo entre frames da animacao do personagem
	//Cada unidade multiplica o delay (TrocaPosicao = delay * unidade)
	public int TrocaPosicao = 20;


	/**
	 * Inicializar posição do Velho
	 * @param x = posição horizontal do Velho
	 * @param y = posição vertical do Velho
	 */
	public Velho(int x ,int y) {
		this.x = x;
		this.y = y;
		
		VelhoDireita01 = new ImageIcon(VelhoDireita01Path).getImage();
		VelhoDireita02 = new ImageIcon(VelhoDireita02Path).getImage();
		VelhoEsquerda01 = new ImageIcon(VelhoEsquerda01Path).getImage();
		VelhoEsquerda02 = new ImageIcon(VelhoEsquerda02Path).getImage();
		
		VelhoAdaga01 = new ImageIcon(VelhoAdaga01Path).getImage();
		VelhoAdaga02 = new ImageIcon(VelhoAdaga02Path).getImage();
		VelhoAdaga03 = new ImageIcon(VelhoAdaga03Path).getImage();
	}
	/**
	 * Verifica a relação de proximidade entre o jogador e o velho
	 */
	public void proximidade(Player player, Velho velho) {
		if((player.x >= velho.x - 150 && player.x <= velho.x + 150) &&
				(player.y >= velho.y - 150 && player.y <= velho.y +150)) {
			velho.proximo = true;
		}
		else {
			velho.proximo = false;	
		}
	}
	/**
	 * Animação de olhar para a Menina olhar para o Player.
	 * @param player = aproximar do velho e causar animação
	 * @param velho = seguir o movimento player.
	 */
	public void animacao(Player player, Velho velho) {
	    velho.personagemDelay += 1;
	    if(velho.personagemDelay > (velho.TrocaPosicao*2)) {
	    	velho.personagemDelay = 0;
	    }
	    if(player.x > velho.x) {
	    	velho.orientacaoVelho = true;
	    }
	    else {
	    	velho.orientacaoVelho = false;
	    }
	}
	/**
	 * Algoritmo de colisão com o Velho.
	 * @param player = posição x e y de colisão
	 * @param velho = posição x e y de colisão
	 */
	public void colisao(Player player, Velho velho) {
		if (player.x >= velho.x - velho.VelhoEsquerda01.getWidth(null)/2 && 
				(player.y >= velho.y - velho.VelhoEsquerda01.getHeight(null)*0.7 && 
				player.y <= velho.y + velho.VelhoEsquerda01.getHeight(null)*0.7 ) &&
				player.x <= velho.x) {
			
			player.x = player.x - player.velMax;
		}

		else if (player.x <= velho.x + velho.VelhoEsquerda01.getWidth(null)/2 && 
				(player.y >= velho.y - velho.VelhoEsquerda01.getHeight(null)*0.7 &&
				player.y <= velho.y + velho.VelhoEsquerda01.getHeight(null)*0.7 ) &&
				player.x >= velho.x) {
			
			player.x = player.x + player.velMax;
		}

		if (player.y >= velho.y - velho.VelhoEsquerda01.getHeight(null)*0.7 - player.velMax &&
				(player.x >= velho.x - velho.VelhoEsquerda01.getWidth(null)/2 && 
				player.x <= velho.x + velho.VelhoEsquerda01.getWidth(null)/2) &&
				player.y <= velho.y) {
			player.y = player.y - player.velMax;
		}
			
		else if (player.y <= velho.y + velho.VelhoEsquerda01.getHeight(null)*0.7+ player.velMax &&
				(player.x >= velho.x - velho.VelhoEsquerda01.getWidth(null)/2 && 
				player.x <= velho.x + velho.VelhoEsquerda01.getWidth(null)/2) &&
				player.y >= velho.y) {
			player.y = player.y + player.velMax;
		}
	}
	/**
	 * Método para "pintar" o Velho na tela
	 */
	public void draw(Graphics g) {
		if(entregaAdaga) {
			if (personagemDelay <= TrocaPosicao*2/5) {
				g.drawImage(VelhoAdaga01, x, y, null);
			}
			else if (personagemDelay <= (TrocaPosicao*4/5)) {
				g.drawImage(VelhoAdaga02, x, y, null);
			}
			else if (personagemDelay <= (TrocaPosicao*6/5)) {
				g.drawImage(VelhoAdaga02, x, y, null);
			}
			else if (personagemDelay <= (TrocaPosicao*8/5)) {
				g.drawImage(VelhoAdaga02, x, y, null);
			}
			else if (personagemDelay <= (TrocaPosicao*10/5)) {
				g.drawImage(VelhoAdaga03, x, y, null);
				entregaAdaga = false;
				adaga = true;
			}
		}
		else if(adaga) {
			g.drawImage(VelhoAdaga03, x, y, null);
		}
		else {
			if(orientacaoVelho) {
				if (personagemDelay <= TrocaPosicao) {
					g.drawImage(VelhoDireita01, x, y, null);
				}
				else if (personagemDelay <= (TrocaPosicao*2)) {
					g.drawImage(VelhoDireita02, x, y, null);
				}
			}
			else {
				if (personagemDelay <= TrocaPosicao) {
					g.drawImage(VelhoEsquerda01, x, y, null);
				}
				else if (personagemDelay <= (TrocaPosicao*2)) {
					g.drawImage(VelhoEsquerda02, x, y, null);
				}
				
			}
		}		
		
	}

}
