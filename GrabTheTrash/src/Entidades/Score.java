package Entidades;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Main.Game;

public class Score extends Entity {
    public static int time = 250000;
    public static boolean up, down, pontuou;
    public static int cont = 0;
    public int atualpoint = 0;
    public static String[] scores = { "Placar: ", "Tempo: " };

    public Score(int x, int y, int widht, int height, BufferedImage sprite) {
        super(x, y, widht, height, sprite);
    }

    Thread contagemThread = new Thread(() -> {
        while (time > 0) {
            System.out.println(time);
            time--;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Contagem regressiva concluída!");
        
    });

    public void tick() {
        if (time > 0) {
            time--;
            if (time == 0) {
            	if (cont == 0) {
                	Game.gamestate = "gamestatus";
                		
            	}
            	else {
                	Game.gamestate = "gamewin";

            	}
                System.out.println("Contagem regressiva concluída!");
            }
        }
        
       
        if (cont == 36) {
        	Game.gamestate = "gamewin";
            System.out.println("Acabou");
        }

        
        if (pontuou) {
            pontuou = false;
            cont += 3;
        }

    }

    public void render(Graphics g) {
        g.setColor(new Color(0, 20, 0));
        g.fillRect(0, 0, (Game.HEIGHT * Game.SCALE) * 2, (Game.WIDTH * Game.SCALE) * 2);
        g.setFont(new Font("arial", Font.BOLD,10));
        g.setColor(new Color(0,0,0));
        g.drawString("Pressione 'ESC' para pausar! ", Game.WIDTH+20, Game.HEIGHT/2-145);
        g.setFont(new Font("arial", Font.BOLD,12));
        g.setColor(new Color(0,0,0));
        g.drawString("Placar: " + cont, Game.WIDTH+165, Game.HEIGHT/2-145);
        g.drawString("Tempo: " + time/10000, Game.WIDTH + 90, Game.HEIGHT/2 + 100);
        
    }

}


