package Interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 * Menu do jogo.
 * @author Equipe11: Alberto, Cauã, Vinicius, Pedro, Arthur
 */

public class Menu extends JPanel{

	private static final long serialVersionUID = 1L;
	
	//Resolução da tela
	final static int SCREEN_WIDTH = Intro.SCREEN_WIDTH;
	final static int SCREEN_HEIGHT = Intro.SCREEN_HEIGHT;
	
	//Declaração imagem de fundo
	Image Background;
	String BackgroundPath = "images//logo_menu.png";
	//Caracterização do menu
	public Menu(){	
		//Panel
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));	
		this.setBackground(Color.black);
		this.setLayout(null);
		
		Background = new ImageIcon(BackgroundPath).getImage();
		
		//Configurações botão jogar
		JButton botaoJogar = new JButton("Jogar");	
		botaoJogar.setIcon(new ImageIcon("images//button_start.png"));
		botaoJogar.setBounds(SCREEN_WIDTH-500, 175, 360, 100);		
		botaoJogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Janela.cena01Pergaminho.timer.start();
				Janela.intro.clip.stop();
				Janela.intro.playAudio(Janela.intro.startBotao, 0);
				Janela.cl.show(Janela.panelBase, "cena01Pergaminho");	
				try {
					Thread.sleep(2400);					
					Janela.intro.playAudio(Janela.intro.fundoPadrao, 99);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}			
								
			}
		});
		this.add(botaoJogar);
		
		//Configurações botão Opções
		JButton botaoOpcoes = new JButton("Opcoes");
		botaoOpcoes.setIcon(new ImageIcon("images//button_opcoes.png"));
		botaoOpcoes.setBounds(SCREEN_WIDTH-500, 300, 360, 100);
		
		botaoOpcoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Botao opções sendo pressionado");
				JOptionPane.showMessageDialog(null, "Botão opções em construção");	
				Janela.cl.show(Janela.panelBase, "animacao");
			}
		});
		this.add(botaoOpcoes);
		
		//Configurações botão sair
		JButton botaoSair = new JButton("Sair");		
		botaoSair.setIcon(new ImageIcon("images//button_sair.png"));
		botaoSair.setBounds(SCREEN_WIDTH-500, 425, 360, 100);
		
		botaoSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Botão sair em construção");
				System.out.println("Botao sair sendo pressionado");
				Intro.clip.stop();
				Exe.janela.dispose();
			}
		});
		this.add(botaoSair);
		this.setVisible(true);

	}	

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(Background, 0, 0, null);

	}
}