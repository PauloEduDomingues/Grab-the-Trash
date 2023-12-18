package Entidades;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Main.Game;

public class Menu extends Entity{
	
	public static boolean up,down,enter;
	public static String[] options = {"NovoJogo", "Sair"};
	public int atualOption = 0;
	public int finalOption = options.length - 1;
	
	public Menu(int x, int y, int widht, int height, BufferedImage sprite) {
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
		if(options[atualOption] == "NovoJogo") {
			Game.gamestate = "game";
	}	else if(options[atualOption] == "Sair") {
			System.exit(1);	
			}
		}
	}
	public void render(Graphics g) {
		g.setColor(new Color(0,20,0));
		g.fillRect(0, 0, (Game.HEIGHT*Game.SCALE)*2, (Game.WIDTH*Game.SCALE)*2);
		g.setFont(new Font("arial", Font.BOLD,12));
		g.setColor(new Color(255,255,255));
		g.drawString("Novo Jogo", Game.WIDTH+90, Game.HEIGHT/2-20);
		g.drawString("Sair", Game.WIDTH+90, Game.HEIGHT/2-5);
		
		if(options[atualOption] == "NovoJogo") {
			g.drawString(">", Game.WIDTH+75, Game.HEIGHT/2-20);
		} else     if(options[atualOption] == "Sair") {
			g.drawString(">", Game.WIDTH+75, Game.HEIGHT/2-5);
		}
			
		}
		
}
	


