package cenarios;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
/**
 * Menina - Personagem
 * @author Equipe11
 *
 */
public class Menina {
	/**
	 * Menina olhando para a direita png
	 */
	Image MeninaDireita01;
	String MeninaDireita01Path = "images//Menina//michica_parada_2.png";
	Image MeninaDireita02;
	String MeninaDireita02Path = "images//Menina//michica_parada_3.png";
	
	/**
	 * Menina olhando para a esquerda
	 */
	public Image MeninaEsquerda01;
	String MeninaEsquerda01Path = "images//Menina//michica_parada_left2.png";
	Image MeninaEsquerda02;
	String MeninaEsquerda02Path = "images//Menina//michica_parada_left3.png";
	
	/**
	 * Parâmetros de posição inicial
	 */
	public int x;
	public int y;
	public boolean orientacaoMenina = false;
	public boolean proxima = false;
	
	
	/**
	 * Desenvolvendo a caixa de diálogos da menina.
	 */
	static int fontSize = 20;
	public int contador = 0;
    static Font f = new Font("Comic Sans MS", Font.BOLD, fontSize);
    public String Frase = "";
    static String Letras = "Pressione [E]";
    
    public static boolean dialogM = false;
	
	/**
	 * Parametrização animação personagem
	 */
	public int personagemDelay = 0;

	public int TrocaPosicao = 16;
	
	/**
	 * Inicializar posição da Menina
	 * @param x = posição horizontal da Menina.
	 * @param y = posição vertical da Menina
	 */
	public Menina(int x ,int y) {
		this.x = x;
		this.y = y;

		MeninaDireita01 = new ImageIcon(MeninaDireita01Path).getImage();
		MeninaDireita02 = new ImageIcon(MeninaDireita02Path).getImage();
		MeninaEsquerda01 = new ImageIcon(MeninaEsquerda01Path).getImage();
		MeninaEsquerda02 = new ImageIcon(MeninaEsquerda02Path).getImage();
	}

	/**
	 * Verifica a relação de proximidade entre o jogador e a menina.
	 * @param instanciar um player e menina e verificar proximidade.
	 */
	public void proximidade(Player player, Menina menina) {
		if((player.x >= menina.x - 150 && player.x <= menina.x + 150) &&
				(player.y >= menina.y - 150 && player.y <= menina.y +150)) {
			menina.proxima = true;
		}
		else {
			menina.proxima = false;			
		}
	}
	/**
	 * Animação de olhar para a Menina olhar para o Player.
	 * @param player = aproximar da menina e causar animação
	 * @param menina = seguir o movimento player.
	 */
	public void animacao(Player player, Menina menina) {
		menina.personagemDelay += 1;
		if(menina.personagemDelay > (menina.TrocaPosicao*2)) {
			menina.personagemDelay = 0;
		}
		if(player.x > menina.x) {
			menina.orientacaoMenina = true;
		}
		else {
			menina.orientacaoMenina = false;
		}
	}
	/**
	 * Algoritmo de colisão com a Menina
	 * @param player = posição x e y de colisão
	 * @param menina = posição x e y de colisão
	 */
	public void colisao(Player player, Menina menina) {
		if (player.x >= menina.x - menina.MeninaEsquerda01.getWidth(null)/2 && 
				(player.y >= menina.y - menina.MeninaEsquerda01.getHeight(null)*0.7 && 
				player.y <= menina.y + menina.MeninaEsquerda01.getHeight(null)*0.7 ) &&
				player.x <= menina.x) {
			
			player.x = player.x - player.velMax;
		}

		else if (player.x <= menina.x + menina.MeninaEsquerda01.getWidth(null)/2 && 
				(player.y >= menina.y - menina.MeninaEsquerda01.getHeight(null)*0.7 &&
				player.y <= menina.y + menina.MeninaEsquerda01.getHeight(null)*0.7 ) &&
				player.x >= menina.x) {
			 
			player.x = player.x + player.velMax;
		}

		if (player.y >= menina.y - menina.MeninaEsquerda01.getHeight(null)*0.7 - player.velMax &&
				(player.x >= menina.x - menina.MeninaEsquerda01.getWidth(null)/2 && 
				player.x <= menina.x + menina.MeninaEsquerda01.getWidth(null)/2) &&
				player.y <= menina.y) {
			player.y = player.y - player.velMax;
		}
			
		else if (player.y <= menina.y + menina.MeninaEsquerda01.getHeight(null)*0.7+ player.velMax &&
				(player.x >= menina.x - menina.MeninaEsquerda01.getWidth(null)/2 && 
				player.x <= menina.x + menina.MeninaEsquerda01.getWidth(null)/2) &&
				player.y >= menina.y) {
			player.y = player.y + player.velMax;
		}
	}
	/**
	 * Método para "pintar" a Menina na tela
	 */
	public void draw(Graphics g) {
		if(orientacaoMenina) {
			if (personagemDelay <= TrocaPosicao) {
				g.drawImage(MeninaDireita01, x, y, null);
			}
			else if (personagemDelay <= (TrocaPosicao*2)) {
				g.drawImage(MeninaDireita02, x, y, null);
			}
		}
		else {
			if (personagemDelay <= TrocaPosicao) {
				g.drawImage(MeninaEsquerda01, x, y, null);
			}
			else if (personagemDelay <= (TrocaPosicao*2)) {
				g.drawImage(MeninaEsquerda02, x, y, null);
			}
			
		}
		
	}

}
	
