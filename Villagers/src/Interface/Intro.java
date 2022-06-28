package Interface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
/**
 * Introdução do jogo.
 * @author Equipe11
 *
 */
public class Intro extends JPanel{
	/**
	 * Resolução da tela.
	 */
	public final static int SCREEN_WIDTH = 1366;
	public final static int SCREEN_HEIGHT = 768;
	
	/**
	 * Inicializar áudio.
	 */
	public static AudioInputStream stream;
	public static Clip clip;
	public String audioFileName = "sounds//UndetaleCompact.wav";
	public String startBotao = "sounds//Intro.wav";
	public String fundoPadrao = "sounds//DentrodasCenas.wav";
	public String batalha1 = "sounds//Batalha1.wav";
	public String batalha2 = "sounds//Batalha2.wav";
	public String vilaSombrio = "sounds//ChegandonaVila.wav";
	public String finalTriste = "sounds//FinalTriste.wav";
	public String finalFeliz = "sounds//Final_feliz.wav";

	
	/**
	 * Delay para fechar a introdução
	 */
	static int wait = 1500;
	/**
	 * Introduzindo componentes do painel
	 */
	Intro(){
		playAudio(audioFileName, 99);
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.black);
		this.setLayout(null);

		JButton botaoMenu = new JButton("");	
		botaoMenu.setIcon(new ImageIcon("images//introducao_black.png"));
		botaoMenu.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);		
		botaoMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Janela.cl.show(Janela.panelBase, "menu");	
			}
		});
		this.add(botaoMenu);
	}
	
	/**
	 * Método para "pintar" os componentes na tela
	 */
	@Override
	public void paint(Graphics g) {
		Graphics2D intro2D = (Graphics2D) g;
		super.paint(intro2D);
	}	
	
	/**
	 * Leitura de arquivo .wav
	 * 
	 */
	public void playAudio(String caminho, int loop){
		try {
		File audioPath = new File(caminho);
		stream = AudioSystem.getAudioInputStream(audioPath);
		clip = AudioSystem.getClip();
		clip.open(stream);
		clip.start();
		clip.loop(loop);
		}

		catch(Exception e){
			e.printStackTrace();
		}
	}
}
