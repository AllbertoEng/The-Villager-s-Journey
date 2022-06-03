package cenarios;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class MeninaBatalha {
	static Image Parada01;
	String Parada01Path = "images///Menina//possuidaParada//michica-attack-00.png";
	Image Parada02;
	String Parada02Path = "images///Menina//possuidaParada//michica-attack-01.png";
	
	Image Ataque01;
	String Ataque01Path = "images//Menina//ataque01//michica-attack-01.png";
	Image Ataque02;
	String Ataque02Path = "images//Menina//ataque01//michica-attack-02.png";
	Image Ataque03;
	String Ataque03Path = "images//Menina//ataque01//michica-attack-03.png";
	Image Ataque04;
	String Ataque04Path = "images//Menina//ataque01//michica-attack-04.png";
	Image Ataque05;
	String Ataque05Path = "images//Menina//ataque01//michica-attack-05.png";
	
	//Posição inicial da menina
	public int x;
	public int y;
	int corrida = 10;
	public boolean iniciandoAtaque = false;
	public boolean atacando = false;
	
	//Parametrizacao animação personagem
	public int personagemDelay = 0;
	//Intervalo de tempo entre frames da animacao do personagem
	//Cada unidade multiplica o delay (TrocaPosicao = delay * unidade)
	public int TrocaPosicao = 15;
	
	
	//Parâmetros x e y para definir posição inicial
	public MeninaBatalha(int x ,int y) {
		this.x = x;
		this.y = y;

		Parada01 = new ImageIcon(Parada01Path).getImage();
		Parada02 = new ImageIcon(Parada02Path).getImage();
		
		Ataque01 = new ImageIcon(Ataque01Path).getImage();
		Ataque02 = new ImageIcon(Ataque02Path).getImage();
		Ataque03 = new ImageIcon(Ataque03Path).getImage();
		Ataque04 = new ImageIcon(Ataque04Path).getImage();
		Ataque05 = new ImageIcon(Ataque05Path).getImage();


	}
	
	public void ataque01(MeninaBatalha menina, int x) {
		if(menina.x >= x) {
			menina.x = menina.x - corrida;
			
			iniciandoAtaque = true;
		}
		else {
			iniciandoAtaque = false;
			atacando = true;
		}
	}
	
	public void animacao(MeninaBatalha menina) {
		//Animacao menina
		menina.personagemDelay += 1;
		if(menina.personagemDelay > (menina.TrocaPosicao*2)) {
			menina.personagemDelay = 0;
		}		
	}
	
	public void draw(Graphics g) {		
		if(iniciandoAtaque == false && atacando == false) {
			if (personagemDelay <= TrocaPosicao) {
				g.drawImage(Parada01, x, y, null);
			}
			else if (personagemDelay <= (TrocaPosicao*2)) {
				g.drawImage(Parada02, x, y, null);
			}
		}
		
		if (iniciandoAtaque == true && atacando == false) {
			if (personagemDelay <= TrocaPosicao/2) {
				g.drawImage(Ataque01, x-MeninaBatalha.Parada01.getWidth(null), y, null);
			}
			else if (personagemDelay <= (TrocaPosicao)) {
				g.drawImage(Ataque01, x-MeninaBatalha.Parada01.getWidth(null), y, null);
			}
			else if (personagemDelay <= TrocaPosicao*3/2) {
				g.drawImage(Ataque01, x-MeninaBatalha.Parada01.getWidth(null), y, null);
			}
			else if (personagemDelay <= (TrocaPosicao*2)) {
				g.drawImage(Ataque01, x-MeninaBatalha.Parada01.getWidth(null), y, null);
			}
		}
		else if (atacando) {
			if (personagemDelay <= TrocaPosicao/4) {
				g.drawImage(Ataque02, x-MeninaBatalha.Parada01.getWidth(null), y, null);
			}
			else if (personagemDelay <= (TrocaPosicao*2/4)) {
				g.drawImage(Ataque03, x-MeninaBatalha.Parada01.getWidth(null), y, null);
			}
			else if (personagemDelay <= TrocaPosicao*3/4) {
				g.drawImage(Ataque04, x-MeninaBatalha.Parada01.getWidth(null), y, null);
			}
			else if (personagemDelay <= (TrocaPosicao*4/4)) {
				g.drawImage(Ataque05, x-MeninaBatalha.Parada01.getWidth(null), y, null);
			}
			else if (personagemDelay <= TrocaPosicao*5/4) {
				g.drawImage(Ataque02, x-MeninaBatalha.Parada01.getWidth(null), y, null);
			}
			else if (personagemDelay <= (TrocaPosicao*6/4)) {
				g.drawImage(Ataque03, x-MeninaBatalha.Parada01.getWidth(null), y, null);
			}
			else if (personagemDelay <= TrocaPosicao*7/4) {
				g.drawImage(Ataque04, x-MeninaBatalha.Parada01.getWidth(null), y, null);
			}
			else if (personagemDelay <= (TrocaPosicao*8/4)) {
				g.drawImage(Ataque05, x-MeninaBatalha.Parada01.getWidth(null), y, null);
			}
		}
	}
}
