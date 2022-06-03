package cenarios;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Decorativos {
	
	ArrayList<Image> Decorativos = new ArrayList<Image>();

	
	//Path das imagens dos caminhos
	Image Decorativos00;
	String Decorativos00Path = "images//Decorativos//mushroom.png";
	Image Decorativos01;
	String Decorativos01Path = "images//Decorativos//plaquinha.png";
	
int numeroDecorativo, x, y;
	
	public Decorativos(int numeroDecorativo, int x, int y) {
		this.numeroDecorativo = numeroDecorativo;
		this.x = x;
		this.y = y;
		
		Decorativos00 = new ImageIcon(Decorativos00Path).getImage();
		Decorativos01 = new ImageIcon(Decorativos01Path).getImage();
		
		Decorativos.add(Decorativos00);
		Decorativos.add(Decorativos01);
	}		
	public void colisaoD(Player player, Decorativos decorativos, int numeroDecorativo) {
		//Algoritmo de colisão com a objetos.
		if (player.x >= decorativos.x - decorativos.Decorativos.get(numeroDecorativo).getWidth(null)/2 && 
				(player.y >= decorativos.y - decorativos.Decorativos.get(numeroDecorativo).getHeight(null)*0.7 && 
				player.y <= decorativos.y + decorativos.Decorativos.get(numeroDecorativo).getHeight(null)*0.7 ) &&
				player.x <= decorativos.x) {
			
			player.x = player.x - player.velMax;
		}

		else if (player.x <= decorativos.x + decorativos.Decorativos.get(numeroDecorativo).getWidth(null)/2 && 
				(player.y >= decorativos.y - decorativos.Decorativos.get(numeroDecorativo).getHeight(null)*0.7 &&
				player.y <= decorativos.y + decorativos.Decorativos.get(numeroDecorativo).getHeight(null)*0.7 ) &&
				player.x >= decorativos.x) {
			
			player.x = player.x + player.velMax;
		}

		if (player.y >= decorativos.y - decorativos.Decorativos.get(numeroDecorativo).getHeight(null)*0.7 - player.velMax &&
				(player.x >= decorativos.x - decorativos.Decorativos.get(numeroDecorativo).getWidth(null)/2 && 
				player.x <= decorativos.x + decorativos.Decorativos.get(numeroDecorativo).getWidth(null)/2) &&
				player.y <= decorativos.y) {
			player.y = player.y - player.velMax;
		}
			
		else if (player.y <= decorativos.y + decorativos.Decorativos.get(numeroDecorativo).getHeight(null)*0.7+ player.velMax &&
				(player.x >= decorativos.x - decorativos.Decorativos.get(numeroDecorativo).getWidth(null)/2 && 
				player.x <= decorativos.x + decorativos.Decorativos.get(numeroDecorativo).getWidth(null)/2) &&
				player.y >= decorativos.y) {
			player.y = player.y + player.velMax;
		}
	}
	
	public void draw(Graphics g) {
		g.drawImage(Decorativos.get(numeroDecorativo), x, y, null);
		
	}
}
