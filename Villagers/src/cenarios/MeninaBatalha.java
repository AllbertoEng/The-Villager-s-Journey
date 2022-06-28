package cenarios;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
/**
 * Menina - Batalha
 * @author Equipe11
 *
 */
public class MeninaBatalha {
	/**
	 * Parâmetros de posição inicial
	 */
	public int x;
	public int y;
	int corrida = 10;
	public boolean iniciandoAtaque = false;
	public boolean atacando = false;
	public boolean dano = false;
	public boolean voltando = false;
	public boolean meninaDerrotada = false , manterDerrotada = false;
	public int tipoAtaque = -1;
	
	/**
	 * Parametrizacao animação personagem
	 */
	public int personagemDelay = 0, voltarDelay = 0;
	public int TrocaPosicao = 15, voltar = 30;
	
	/**
	 * MeninaBatalha parada png
	 */
	static Image Parada01;
	String Parada01Path = "images///Menina//possuidaParada//michica-attack-00.png";
	Image Parada02;
	String Parada02Path = "images///Menina//possuidaParada//michica-attack-01.png";
	/**
	 * MeninaBatalha ataques png
	 */
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
	Image Ataque06;
	String Ataque06Path = "images//Menina//ataque02//michica-attack-03.png";
	Image Ataque07;
	String Ataque07Path = "images//Menina//ataque02//michica-attack-04.png";
	Image Ataque08;
	String Ataque08Path = "images//Menina//ataque02//michica-attack-05.png";
	Image Ataque09;
	String Ataque09Path = "images//Menina//ataque02//michica-attack-06.png";
	Image Ataque10;
	String Ataque10Path = "images//Menina//ataque02//michica-attack-07.png";
	/**
	 * MeninaBatalha dano png
	 */
	Image Dano01;
	String Dano01Path = "images//Menina//dano//michica-attack-03.png";
	Image Dano02;
	String Dano02Path = "images//Menina//Dano//michica-attack-04.png";
	Image Dano03;
	String Dano03Path = "images//Menina//Dano//michica-attack-05.png";
	Image Dano04;
	String Dano04Path = "images//Menina//Dano//michica-attack-06.png";	
	/**
	 * MeninaBatalha derrota png
	 */
	Image Derrota01;
	String Derrota01Path = "images//Menina//derrotada//michica-defeat1.png";
	Image Derrota02;
	String Derrota02Path = "images//Menina//derrotada//michica-defeat2.png";
	Image Derrota03;
	String Derrota03Path = "images//Menina//derrotada//michica-defeat3.png";
	Image Derrota04;
	String Derrota04Path = "images//Menina//derrotada//michica-defeat4.png";
	Image Derrota05;
	String Derrota05Path = "images//Menina//derrotada//michica-defeat5.png";

	
	/**
	 * Inicializar posição de batalha da menina
	 * @param x = posição horizontal da menina
	 * @param y = posição vertical da menina
	 */
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
		
		Ataque06 = new ImageIcon(Ataque06Path).getImage();
		Ataque07 = new ImageIcon(Ataque07Path).getImage();
		Ataque08 = new ImageIcon(Ataque08Path).getImage();
		Ataque09 = new ImageIcon(Ataque09Path).getImage();
		Ataque10 = new ImageIcon(Ataque10Path).getImage();
		
		Dano01 = new ImageIcon(Dano01Path).getImage();
		Dano02 = new ImageIcon(Dano02Path).getImage();
		Dano03 = new ImageIcon(Dano03Path).getImage();
		Dano04 = new ImageIcon(Dano04Path).getImage();
		
		Derrota01 = new ImageIcon(Derrota01Path).getImage();
		Derrota02 = new ImageIcon(Derrota02Path).getImage();
		Derrota03 = new ImageIcon(Derrota03Path).getImage();
		Derrota04 = new ImageIcon(Derrota04Path).getImage();
		Derrota05 = new ImageIcon(Derrota05Path).getImage();

	}
	
	public void caminhaPosicaoInicial(MeninaBatalha menina, int x, PlayerBatalha player) {
		menina.voltarDelay++;
		System.out.println("voltarDelay = " + menina.voltarDelay);
        if(menina.voltarDelay > (menina.voltar*2)) {
        	if(menina.x <= x) {
        		player.dano = false;	
        		menina.x = menina.x + corrida;
        		menina.atacando = false;
        		menina.voltando = true;
    		}
        }	
        if(menina.x > x) {  			    			
			menina.voltando = false;
			menina.voltarDelay = 0;
		}
	}
	
	public void ataque01(MeninaBatalha menina, int x) {
		if(menina.x >= x) {
			menina.x = menina.x - corrida;
			
			iniciandoAtaque = true;
		}
		else {
			iniciandoAtaque = false;
			atacando = true;
			voltando = true;
		}
	}
	/**
	 * Animação de batalha da menina
	 * @param menina = posição
	 */
	public void animacao(MeninaBatalha menina) {
		menina.personagemDelay += 1;
		if(menina.personagemDelay > (menina.TrocaPosicao*2)) {
			menina.personagemDelay = 0;
		}		
	}
	/**
	 * Método para "pintar" o MeninaBatalha na tela
	 */
	public void draw(Graphics g) {	
		if(meninaDerrotada == false) {
			if(dano == false) {
				if(iniciandoAtaque == false && atacando == false) {
					if (personagemDelay <= TrocaPosicao) {
						g.drawImage(Parada01, x, y, null);
					}
					else if (personagemDelay <= (TrocaPosicao*2)) {
						g.drawImage(Parada02, x, y, null);
					}
				}
				
				else if (iniciandoAtaque == true && atacando == false) {
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
					if(tipoAtaque == 0) {
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
					else {
						if (personagemDelay <= TrocaPosicao*2/5) {
							g.drawImage(Ataque06, x-MeninaBatalha.Parada01.getWidth(null), y, null);
						}
						else if (personagemDelay <= (TrocaPosicao*4/5)) {
							g.drawImage(Ataque07, x-MeninaBatalha.Parada01.getWidth(null), y, null);
						}
						else if (personagemDelay <= TrocaPosicao*6/5) {
							g.drawImage(Ataque08, x-MeninaBatalha.Parada01.getWidth(null), y, null);
						}
						else if (personagemDelay <= (TrocaPosicao*8/5)) {
							g.drawImage(Ataque09, x-MeninaBatalha.Parada01.getWidth(null), y, null);
						}
						else if (personagemDelay <= TrocaPosicao*2) {
							g.drawImage(Ataque10, x-MeninaBatalha.Parada01.getWidth(null), y, null);
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
		else {
			if(manterDerrotada == false) {
				if (personagemDelay <= TrocaPosicao*2/5) {
					g.drawImage(Derrota02, x, y, null);
				}
				else if (personagemDelay <= (TrocaPosicao*4/5)) {
					g.drawImage(Derrota02, x, y, null);
				}
				else if (personagemDelay <= TrocaPosicao*6/5) {
					g.drawImage(Derrota03, x, y, null);
				}
				else if (personagemDelay <= (TrocaPosicao*8/5)) {
					g.drawImage(Derrota04, x, y, null);
				}
				else if (personagemDelay <= TrocaPosicao*2) {
					g.drawImage(Derrota05, x, y, null);
				}
				manterDerrotada = true;
			}
			else {
				if (personagemDelay <= TrocaPosicao*2/3) {
					g.drawImage(Derrota03, x, y, null);
				}
				else if (personagemDelay <= (TrocaPosicao*4/3)) {
					g.drawImage(Derrota04, x, y, null);
				}
				else if (personagemDelay <= TrocaPosicao*2) {
					g.drawImage(Derrota05, x, y, null);
				}
			}			
		}
	}
}
