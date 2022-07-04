package dialogos;

import java.awt.Font;
import java.awt.Graphics;
/**
 * Diálogos FinalRuim
 * @author Equipe11: Alberto, Cauã, Vinicius, Pedro, Arthur
 */
public class FinalRuim {
	static int fontSize = 20;
	public static int contador = 0;
    static Font f = new Font("SansSerif Bold Italic", Font.BOLD, fontSize);
	String[] paragrafos;
    static String fraseruim = "O aldeão decide dar um fim nessa história macabra dando o \núltimo golpe na menina possuída... "
    		+ "\nA menina deu seu último suspiro, e o aldeão fica triste com a \nsituação \nDe repente, "
    		+ "ele começa a ouvir vozes o tentando a pegar o anél \namaldiçoado \nEle sente o grande poder que "
    		+ "ele o daria, e cede sua vontade \npara a maldição... \nO ciclo continua...";
    static int x = 410;
	static int y = 140;
    public FinalRuim() {
    	
    	
    }
    
    public static void perg(Graphics g) {
    	String[] paragrafos = fraseruim.split("\n");	
		String p1 = paragrafos[0];
		String p2 = paragrafos[1];
		String p3 = paragrafos[2];
		String p4 = paragrafos[3];
		String p5 = paragrafos[4];
		String p6 = paragrafos[5];
		String p7 = paragrafos[6];
		String p8 = paragrafos[7];
		String p9 = paragrafos[8];
		
		g.setFont(f);

		g.drawString(p1, x, y+10);
		g.drawString(p2, x, y+40);
		g.drawString(p3, x, y+130);
		g.drawString(p4, x, y+155);
		g.drawString(p5, x, y+245);
		g.drawString(p6, x, y+275);
		g.drawString(p7, x, y+355);
		g.drawString(p8, x, y+385);
		g.drawString(p9, x, y+440);
		
	}
}

