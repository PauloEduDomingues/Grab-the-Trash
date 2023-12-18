package Entidades;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Main.Game;


public class Pausa extends Entity{
	public static String[] options = {"Reiniciar", "Sair"};
	public int atualOption = 0;
	public int finalOption = options.length - 1;
	public static boolean up, down, enter;
    public Pausa(int x, int y, int widht, int height, BufferedImage sprite) {
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
		if(options[atualOption] == "Reiniciar") {
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
	
    	
    	
        g.setFont(new Font("arial", Font.BOLD,25));
        g.setColor(new Color(250,150,0));
        g.drawString("PAUSA", 80,80);
        
        g.setFont(new Font("arial", Font.BOLD,15));
        g.setColor(new Color(250,150,0));

        
        g.drawString("Reiniciar", Game.WIDTH+95, Game.HEIGHT/2-45);
		g.drawString("Sair", Game.WIDTH+95, Game.HEIGHT/2-25);
		
		if(options[atualOption] == "Reiniciar") {
			g.drawString(">", Game.WIDTH+85, Game.HEIGHT/2-45);
		} else     if(options[atualOption] == "Sair") {
			g.drawString(">", Game.WIDTH+85, Game.HEIGHT/2-25);
		}
	}
    }
