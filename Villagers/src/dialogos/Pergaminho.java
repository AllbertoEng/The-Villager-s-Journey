package dialogos;

import java.awt.Font;
import java.awt.Graphics;
/**
 * Pergaminho do jogo
 * @author Equipe11
 *
 */
public class Pergaminho {
	/**
	 * Personalizando texto do pergaminho	
	 */
	static int fontSize = 20;
	public static int contador = 0;
    static Font f = new Font("SansSerif Bold Italic", Font.BOLD, fontSize);
	String[] paragrafos;
    static String frasePergaminho = "Você que está lendo este pergaminho. \nSeja um rei, cavaleiro, ou um aldeão desajeitado... \nAqui irá encontrar o caminho para um tesouro lendário. \nSe deseja adentrar essa aventura, entenda que o \nperigo também esta a altura. \nEssa recompensa tão antes cobiçada, se encontra longe, \nna floresta amaldiçoada.";
    static int x = 430;
	static int y = 210;
    public Pergaminho() {
    	
    	
    }
    /**
     * Desenhando textos do pergaminho
     * @param g = pintar
     */
    public static void perg(Graphics g) {
		String[] paragrafos = frasePergaminho.split("\n");	
		String p1 = paragrafos[0];
		String p2 = paragrafos[1];
		String p3 = paragrafos[2];
		String p4 = paragrafos[3];
		String p5 = paragrafos[4];
		String p6 = paragrafos[5];
		String p7 = paragrafos[6];
		
		g.setFont(f);

		g.drawString(p1, x, y+10);
		g.drawString(p2, x, y+80);
		g.drawString(p3, x, y+150);
		g.drawString(p4, x, y+220);
		g.drawString(p5, x, y+245);
		g.drawString(p6, x, y+315);
		g.drawString(p7, x, y+340);

	}
}
