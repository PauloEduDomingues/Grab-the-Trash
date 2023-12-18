package Mundo;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import Entidades.Entity;
import Entidades.Solido;
import javax.imageio.ImageIO;

import Main.Game;

public class Mundo {
	
	public static int width;
	public static int heigth;
	public Tile[] tiles;
	

	public Mundo(String path) {
		try {
			BufferedImage level = ImageIO.read(getClass().getResource(path));
			int[] pixels = new int[level.getWidth() * level.getHeight()];
			tiles = new Tile[level.getWidth() * level.getHeight()];
			width = level.getWidth();
			heigth = level.getHeight();
			level.getRGB(0, 0, level.getWidth(), level.getHeight(), pixels, 0, level.getWidth());
			
			for(int i = 0; i < level.getWidth(); i ++) {	
				for(int j = 0; j < level.getHeight(); j++) {
					int pixelatual = pixels[i + (j*level.getWidth())];
					tiles[i + (j*width)] = new Vazio(i*16, j*16, Entity.vazio);
					if(pixelatual == 0xFF99e550) {
						//player
						Game.player.setX(i*16);
						Game.player.setY(j*16);
						tiles[i + (j*width)] = new Vazio(i*16, j*16, Entity.ruahorizontal);
					}
					else if(pixelatual == 0xFFfbf236) {
						//rato1
						Game.rato1.setX(i*16);
						Game.rato1.setY(j*16);
						tiles[i + (j*width)] = new Vazio(i*16, j*16, Entity.ruahorizontal);
					}
					else if(pixelatual == 0xFFef0499) {
						//rato2
						Game.rato2.setX(i*16);
						Game.rato2.setY(j*16);
						tiles[i + (j*width)] = new Vazio(i*16, j*16, Entity.ruahorizontal);
					}
					else if(pixelatual == 0xFF6c37e0) {
						//rato3
						Game.rato3.setX(i*16);
						Game.rato3.setY(j*16);
						tiles[i + (j*width)] = new Vazio(i*16, j*16, Entity.ruahorizontal);
					}
					else if(pixelatual == 0xFFe55858) {
						//rato4
						Game.rato4.setX(i*16);
						Game.rato4.setY(j*16);
						tiles[i + (j*width)] = new Vazio(i*16, j*16, Entity.ruahorizontal);
					}
					else if(pixelatual == 0xFFcbc7ca) {
						//vidro
						Game.vidro.setX(i*16);
						Game.vidro.setY(j*16);
						tiles[i + (j*width)] = new Vazio(i*16, j*16, Entity.ruahorizontal);
					}
					else if(pixelatual == 0xFFe052bb) {
						//vidro1
						Game.vidro1.setX(i*16);
						Game.vidro1.setY(j*16);
						tiles[i + (j*width)] = new Vazio(i*16, j*16, Entity.ruahorizontal);
					}
					else if(pixelatual == 0xFF636cb1) {
						//vidro2
						Game.vidro2.setX(i*16);
						Game.vidro2.setY(j*16);
						tiles[i + (j*width)] = new Vazio(i*16, j*16, Entity.ruavertical);
					}
					else if(pixelatual == 0xFFb67373) {
						//plastico
						Game.plastico.setX(i*16);
						Game.plastico.setY(j*16);
						tiles[i + (j*width)] = new Vazio(i*16, j*16, Entity.cruzamentotriplo3);
					}
					else if(pixelatual == 0xFF3e1037) {
						//plastico1
						Game.plastico1.setX(i*16);
						Game.plastico1.setY(j*16);
						tiles[i + (j*width)] = new Vazio(i*16, j*16, Entity.ruavertical);
					}
					else if(pixelatual == 0xFF7d5c78) {
						//plastico2
						Game.plastico2.setX(i*16);
						Game.plastico2.setY(j*16);
						tiles[i + (j*width)] = new Vazio(i*16, j*16, Entity.ruavertical);
					}
					else if(pixelatual == 0xFF9ae6f5) {
						//papel
						Game.papel.setX(i*16);
						Game.papel.setY(j*16);
						tiles[i + (j*width)] = new Vazio(i*16, j*16, Entity.cruzamento1);
					}
					else if(pixelatual == 0xFFc38ec6) {
						//papel1
						Game.papel1.setX(i*16);
						Game.papel1.setY(j*16);
						tiles[i + (j*width)] = new Vazio(i*16, j*16, Entity.ruahorizontal);
					}
					else if(pixelatual == 0xFF929cf5) {
						//papel2
						Game.papel2.setX(i*16);
						Game.papel2.setY(j*16);
						tiles[i + (j*width)] = new Vazio(i*16, j*16, Entity.ruavertical);
					}
					else if(pixelatual == 0xFF99a0d5) {
						//metal
						Game.metal.setX(i*16);
						Game.metal.setY(j*16);
						tiles[i + (j*width)] = new Vazio(i*16, j*16, Entity.ruahorizontal);
					}
					else if(pixelatual == 0xFFb1a176) {
						//metal1
						Game.metal1.setX(i*16);
						Game.metal1.setY(j*16);
						tiles[i + (j*width)] = new Vazio(i*16, j*16, Entity.ruavertical);
					}
					else if(pixelatual == 0xFF2a2004) {
						//metal2
						Game.metal2.setX(i*16);
						Game.metal2.setY(j*16);
						tiles[i + (j*width)] = new Vazio(i*16, j*16, Entity.cruzamento2);
					}
					else if(pixelatual == 0xFFde9cea) {
						//lixo
						Game.lixo.setX(i*16);
						Game.lixo.setY(j*16);
						tiles[i + (j*width)] = new Vazio(i*16, j*16, Entity.cruzamentotriplo1);
					}
					else if(pixelatual == 0xFFd3c6d5) {
						//lixo2
						Game.lixo1.setX(i*16);
						Game.lixo1.setY(j*16);
						tiles[i + (j*width)] = new Vazio(i*16, j*16, Entity.cruzamento1);
					}
					else if(pixelatual == 0xFFf52904) {
						//parede de teste
						Solido solido = new Solido(i*16, j*16, 16, 16, Entity.paredetijolos2);
						Game.entidades.add(solido);
					}
					else if(pixelatual == 0xFFff0000) {
						//casa1 frontal dupla parte 1 
						Solido solido = new Solido(i*16, j*16, 16, 16, Entity.paredetijolos);
						Game.entidades.add(solido);
					}
					else if(pixelatual == 0xFF050505) {
						//casa dupla cinza
						Solido solido = new Solido(i*16, j*16, 16, 16, Entity.casaduplabaixo1);
						Game.entidades.add(solido);
					}
					else if(pixelatual == 0xFFdbd8a9) {
						//buraco1
						Solido solido = new Solido(i*16, j*16, 16, 16, Entity.buraco1);
						Game.entidades.add(solido);
					}
					else if(pixelatual == 0xFFc6b3aa) {
						//buraco2
						Solido solido = new Solido(i*16, j*16, 16, 16, Entity.buraco2);
						Game.entidades.add(solido);
					}
					else if(pixelatual == 0xFFe0bdad) {
						//buraco3
						Solido solido = new Solido(i*16, j*16, 16, 16, Entity.buraco3);
						Game.entidades.add(solido);
					}
					else if(pixelatual == 0xFFefad8f) {
						//buraco4
						Solido solido = new Solido(i*16, j*16, 16, 16, Entity.buraco4);
						Game.entidades.add(solido);
					}
					else if(pixelatual == 0xFFf5b285) {
						//buraco5
						Solido solido = new Solido(i*16, j*16, 16, 16, Entity.buraco5);
						Game.entidades.add(solido);
					}
					else if(pixelatual == 0xFFf59e63) {
						//buraco6
						Solido solido = new Solido(i*16, j*16, 16, 16, Entity.buraco6);
						Game.entidades.add(solido);
					}
					else if(pixelatual == 0xFFefccb5) {
						//buraco7
						Solido solido = new Solido(i*16, j*16, 16, 16, Entity.buraco7);
						Game.entidades.add(solido);
					}
					else if(pixelatual == 0xFFf5a570) {
						//buraco8
						Solido solido = new Solido(i*16, j*16, 16, 16, Entity.buraco8);
						Game.entidades.add(solido);
					}
					else if(pixelatual == 0xFFe5d9b9) {
						//buraco9
						Solido solido = new Solido(i*16, j*16, 16, 16, Entity.buraco9);
						Game.entidades.add(solido);
					}
					else if(pixelatual == 0xFFb8fabf) {
						//buraco10
						Solido solido = new Solido(i*16, j*16, 16, 16, Entity.buraco10);
						Game.entidades.add(solido);
					}
					else if(pixelatual == 0xFFbfd5c1) {
						//buraco11
						Solido solido = new Solido(i*16, j*16, 16, 16, Entity.buraco11);
						Game.entidades.add(solido);
					}
					else if(pixelatual == 0xFF828282) {
						//buraco12
						Solido solido = new Solido(i*16, j*16, 16, 16, Entity.buraco12);
						Game.entidades.add(solido);
					}
					else if(pixelatual == 0xFFcdead0) {
						//buraco13
						Solido solido = new Solido(i*16, j*16, 16, 16, Entity.buraco13);
						Game.entidades.add(solido);
					}
					else if(pixelatual == 0xFF99b1e5) {
						//buraco14
						Solido solido = new Solido(i*16, j*16, 16, 16, Entity.buraco14);
						Game.entidades.add(solido);
					}
					else if(pixelatual == 0xFF749df5) {
						//buraco15
						Solido solido = new Solido(i*16, j*16, 16, 16, Entity.buraco15);
						Game.entidades.add(solido);
					}
					else if(pixelatual == 0xFFc7c9cb) {
						//buraco16
						Solido solido = new Solido(i*16, j*16, 16, 16, Entity.buraco16);
						Game.entidades.add(solido);
					}
					else if(pixelatual == 0xFFeaa8a8) {
						//rua vertical
						tiles[i + (j*width)] = new Vazio(i*16, j*16,  Entity.ruavertical);
					}
					else if(pixelatual == 0xFF94caea) {
						//rua horizontal
						tiles[i + (j*width)] = new Vazio(i*16, j*16, Entity.ruahorizontal);
					}
					else if(pixelatual == 0xFFbeef69) {
						//cruzamento 1
						tiles[i + (j*width)] = new Vazio(i*16, j*16, Entity.cruzamento1);
					}
					else if(pixelatual == 0xFFef97cf) {
						//cruzamento 2
						tiles[i + (j*width)] = new Vazio(i*16, j*16, Entity.cruzamento2);
					}
					else if(pixelatual == 0xFFe5bf54) {
						//cruzamento 3
						tiles[i + (j*width)] = new Vazio(i*16, j*16, Entity.cruzamento3);
					}
					else if(pixelatual == 0xFFdbce8e) {
						//cruzamento 4
						tiles[i + (j*width)] = new Vazio(i*16, j*16, Entity.cruzamento4);
					}
					else if(pixelatual == 0xFFd6e7ea) {
						//cruzamento triplo 1
						tiles[i + (j*width)] = new Vazio(i*16, j*16, Entity.cruzamentotriplo1);
					}
					else if(pixelatual == 0xFFf5e8a3) {
						//cruzamento triplo 2
						tiles[i + (j*width)] = new Vazio(i*16, j*16, Entity.cruzamentotriplo2);
					}
					else if(pixelatual == 0xFFc083d5) {
						//cruzamento triplo 3
						tiles[i + (j*width)] = new Vazio(i*16, j*16, Entity.cruzamentotriplo3);
					}
					else if(pixelatual == 0xFF9c9797) {
						//cruzamento triplo 4
						tiles[i + (j*width)] = new Vazio(i*16, j*16, Entity.cruzamentotriplo4);
					}
					else if(pixelatual == 0xFF5485db) {
						//casa dupla azul
						Solido solido= new Solido(i*16, j*16, 16, 16, Entity.casaduplabaixo2);
						Game.entidades.add(solido);
					}
					else if(pixelatual == 0xFF696a6a) {
						//telha das casas duplas
						Solido solido = new Solido(i*16, j*16, 16, 16, Entity.casaduplatelha);
						Game.entidades.add(solido);
					}
					else if(pixelatual == 0xFF2d3e1c) {
						//casa verde
						Solido solido = new Solido(i*16, j*16, 16, 16, Entity.casa1);
						Game.entidades.add(solido);
					}
					else if(pixelatual == 0xFFffffff) {
						//transparente
						tiles[i + (j*width)] = new Vazio(i*16, j*16, Entity.vazio);
					}
					
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void render(Graphics g) {
		int xi = Camera.x/16;
		int yi = Camera.y/16;
		int xf = xi + (Game.WIDHT/16);
		int yf = yi + (Game.HEIGHT/16);
		for(int i = xi; i <= xf; i++) {
			for(int j = yi; j <= yf; j++) {
				if(i < 0 || j < 0 || i >= width || j >= heigth)
					continue;
				Tile tile = tiles[i + (j* width)];
				tile.render(g); 
			}
		}
	}
}
