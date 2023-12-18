package Entidades;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Main.Game;

public class Gamewin extends Entity{

	public static boolean up,down,enter;
	public static String[] options = {"JogarNovamente", "Sair"};
	public int atualOption = 0;
	public int finalOption = options.length - 1;
	
	public Gamewin(int x, int y, int widht, int height, BufferedImage sprite) {
		super(x, y, widht, height, sprite);
		
	}
	
	public void tick() {
		
		if(up) {
			up = false;
			atualOption--;
			if(atualOption < 0) {
				atualOption = finalOption;
			}
		}
		if(down) {
			down=false;
			atualOption++;
			if(atualOption > finalOption) {
				atualOption = 0;
			}
		}
		if(enter) {
		enter = false;
		if(options[atualOption] == "JogarNovamente") {
			Game.reiniciar();
			Score.time = 250000;
			Score.cont = 0;
			}
		else if(options[atualOption] == "Sair") {
			System.exit(1);	
		}
	}
	}
		public void render(Graphics g) {
			g.setColor(new Color(70,130,180,150));
			g.fillRect(0, 0, Game.WIDHT, Game.HEIGHT);
			g.setFont(new Font("arial", Font.BOLD,30));
	        g.setColor(new Color(0,255,0));
	        g.drawString("VITÓRIA",  Game.WIDTH+55, Game.HEIGHT/2-40);
			g.setFont(new Font("arial", Font.BOLD,12));
			g.drawString("Você fez " + Score.cont + " pontos", Game.WIDTH+65, Game.HEIGHT/2-20);
			g.setColor(new Color(255,255,255));
			g.drawString("Jogar Novamente", Game.WIDTH+75, Game.HEIGHT/2-5);
			g.drawString("Sair", Game.WIDTH+75, Game.HEIGHT/2+10);
			if(options[atualOption] == "JogarNovamente") {
				g.drawString(">", Game.WIDTH+65, Game.HEIGHT/2-5);
			} else     if(options[atualOption] == "Sair") {
				g.drawString(">", Game.WIDTH+65, Game.HEIGHT/2+10);
			}
		}
}
