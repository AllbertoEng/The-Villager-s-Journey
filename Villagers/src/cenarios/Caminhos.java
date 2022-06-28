package cenarios;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
/**
 * Lista dos Caminhos das Cenas
 * @author Equipe11
 *
 */
public class Caminhos {
	/**
	 * Array com png dos caminhos
	 */
	ArrayList<Image> caminhos = new ArrayList<Image>();

	
	/**
	 * Path das imagens dos caminhos
	 */
	Image caminho00;
	String caminho00Path = "images//Caminhos//01.png";
	Image caminho01;
	String caminho01Path = "images//Caminhos//01.png";
	Image caminho02;
	String caminho02Path = "images//Caminhos//02.png";
	Image caminho03;
	String caminho03Path = "images//Caminhos//03.png";
	Image caminho04;
	String caminho04Path = "images//Caminhos//04.png";
	Image caminho05;
	String caminho05Path = "images//Caminhos//05.png";
	Image caminho06;
	String caminho06Path = "images//Caminhos//06.png";
	Image caminho07;
	String caminho07Path = "images//Caminhos//07.png";
	Image caminho08;
	String caminho08Path = "images//Caminhos//08.png";
	Image caminho09;
	String caminho09Path = "images//Caminhos//09.png";
	Image caminho10;
	String caminho10Path = "images//Caminhos//10.png";
	Image caminho11;
	String caminho11Path = "images//Caminhos//11.png";
	
	
	
	int numeroCaminho;
	/**
	 * Enumerando os caminhos para cada Cena
	 * @param numeroCaminho
	 */
	public Caminhos(int numeroCaminho) {
		this.numeroCaminho = numeroCaminho;
		
		caminho00 = new ImageIcon(caminho00Path).getImage();
		caminho01 = new ImageIcon(caminho01Path).getImage();
		caminho02 = new ImageIcon(caminho02Path).getImage();
		caminho03 = new ImageIcon(caminho03Path).getImage();
		caminho04 = new ImageIcon(caminho04Path).getImage();
		caminho05 = new ImageIcon(caminho05Path).getImage();
		caminho06 = new ImageIcon(caminho06Path).getImage();
		caminho07 = new ImageIcon(caminho07Path).getImage();
		caminho08 = new ImageIcon(caminho08Path).getImage();
		caminho09 = new ImageIcon(caminho09Path).getImage();
		caminho10 = new ImageIcon(caminho10Path).getImage();
		caminho11 = new ImageIcon(caminho11Path).getImage();
		
		/**
		 * Adicionando Caminhos na tela
		 */
		caminhos.add(caminho00);
		caminhos.add(caminho01);
		caminhos.add(caminho02);
		caminhos.add(caminho03);
		caminhos.add(caminho04);
		caminhos.add(caminho05);
		caminhos.add(caminho06);
		caminhos.add(caminho07);
		caminhos.add(caminho08);
		caminhos.add(caminho09);
		caminhos.add(caminho10);
		caminhos.add(caminho11);
	}
	/**
	 * Método para "pintar" os caminhos na tela
	 */
	public void draw(Graphics g) {
		g.drawImage(caminhos.get(numeroCaminho), 0, 0, null);
		
	}
	
}
