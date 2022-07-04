package dialogos;


import java.awt.Font;
import java.awt.Graphics;
/**
 * Diálogos FinalFeliz
 * @author Equipe11: Alberto, Cauã, Vinicius, Pedro, Arthur
 */

public class FinalFeliz{
	
	static int fontSize = 20;
	public static int contador = 0;
    static Font f = new Font("SansSerif Bold Italic", Font.BOLD, fontSize);
	String[] paragrafos;
    static String frasefeliz = "O aldeão decide salvar a menina do seu destino, recitando a \noração passada pelo guerreiro. "
    		+ "\nMenina: Não acredito... Você me salvou! \nMenina: Achava que não era possivel, nem aquele velho "
    		+ "\nconseguiu. \nMenina: Agora poderei viver minha vida de verdade, obrigado.";
    static int x = 410;
	static int y = 210;
    public FinalFeliz() {
    	
    	
    }
    
    public static void perg(Graphics g) {
		String[] paragrafos = frasefeliz.split("\n");	
		String p1 = paragrafos[0];
		String p2 = paragrafos[1];
		String p3 = paragrafos[2];
		String p4 = paragrafos[3];
		String p5 = paragrafos[4];
		String p6 = paragrafos[5];
		
		g.setFont(f);

		g.drawString(p1, x, y+10);
		g.drawString(p2, x, y+40);
		g.drawString(p3, x, y+120);
		g.drawString(p4, x, y+200);
		g.drawString(p5, x, y+240);
		g.drawString(p6, x, y+320);
	
	}
}