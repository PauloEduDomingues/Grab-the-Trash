package Entidades;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import Main.Game;
import Mundo.Camera;

public class player extends Entity{
	public boolean right, left, down, up;
	public double speed = 0.8;

	public int direita = 1, esquerda = 0, cima = 2, baixo = 3;
	public int direcaoatual = direita;
	public int movimentacao = 0;
	public int maskx= 0, masky = 0, maskw = 13, maskh = 13;
	
	public BufferedImage[] playerright;
	public BufferedImage[] playerleft;
	public BufferedImage[] playerup;
	public BufferedImage[] playerdown;
	public int posx, posy;
	public int frames = 0, maxframes = 5, index = 0, maxindex = 2;
	public player(int x, int y, int widht, int height, BufferedImage sprite) {
		super(x, y, widht, height, sprite);
		playerright = new BufferedImage[3];
		playerleft = new BufferedImage[3];
		playerup = new BufferedImage[3];
		playerdown = new BufferedImage[3];
		
		for(int i= 0; i < 3; i++) {
			playerright[i] = Game.sprite.getSprite(0 + (i*16), 0, 16, 16);
		}
		for(int i= 0; i < 3; i++) {
			playerleft[i] = Game.sprite.getSprite(32 - (i*16), 16, 16, 16);
		}
		for(int i= 0; i < 3; i++) {
			playerup[i] = Game.sprite.getSprite(0 + (i*16), 48, 16, 16);
		}
		for(int i= 0; i < 3; i++) {
			playerdown[i] = Game.sprite.getSprite(0 + (i*16), 32, 16, 16);
		}
	}
	public void tick() {
	    int oldX = Game.player.getX();
	    int oldY = Game.player.getY();
	    movimentacao = 0;
	    colisao3(Game.player.getX(),  Game.player.getY());
	    colisao2((int)(x+speed), this.getY());
	    colisao1((int)(x+speed), this.getY());
	    if(right && !colisao((int)(x+speed), this.getY())) {
	        x+=speed;
	        movimentacao = 1;
	        direcaoatual = direita;
	    }
	    if(left && !colisao((int)(x-speed), this.getY())) {
	        x-=speed;
	        movimentacao = 1;
	        direcaoatual = esquerda;
	    }
	    if(up && !colisao(this.getX(), (int)(y-speed))) {
	        y-=speed;
	        movimentacao = 1;
	        direcaoatual = cima;
	    }
	    if(down && !colisao(this.getX(), (int)(y+speed))) {
	        y+=speed;
	        movimentacao = 1;
	        direcaoatual = baixo;
	    }
	    if(movimentacao == 1 && colisao(posx, posy)) {
	        x = oldX;
	        y = oldY;
	        movimentacao = 0;
	    }
	    if(movimentacao == 1) {
	        frames++;
	        if(frames == maxframes) {
	            index++;
	            frames = 0;
	            if(index > maxindex) {
	                index = 0;
	            }
	        }
	    }
	    
	}
	public boolean colisao(int nextx, int nexty) {
	    Rectangle player = new Rectangle(nextx + maskx, nexty + masky, maskw, maskh);
	    for(int i = 0; i < Game.entidades.size(); i++) {
	        Entity entidade = (Entity) Game.entidades.get(i);
	        if(entidade instanceof Solido) {
	            Rectangle solido = new Rectangle(entidade.getX() + maskx, entidade.getY() + masky, maskw, maskh);
	            if(player.intersects(solido)) {
	                int dx = Math.min(Math.abs(nextx - entidade.getX()), Math.abs((entidade.getX() + entidade.getWidht()) - nextx));
	                int dy = Math.min(Math.abs(nexty - entidade.getY()), Math.abs((entidade.getY() + entidade.getHeight()) - nexty));
	                if(dx < dy) {
	                    if(nextx < entidade.getX()) {
	                        nextx = entidade.getX() - maskx - maskw;
	                    } else {
	                        nextx = entidade.getX() + entidade.getWidht() - maskx;
	                    }
	                } else {
	                    if(nexty < entidade.getY()) {
	                        nexty = entidade.getY() - masky - maskh;
	                    } else {
	                        nexty = entidade.getY() + entidade.getHeight() - masky;
	                    }
	                }
	                return true;
	            }
	        }
	    }
	    return false;
	}
	public void colisao1(int nextx, int nexty) {
		for(int i = 0; i < Game.entidades.size(); i++) {
			Rectangle player = new Rectangle(nextx + maskx, nexty + masky, maskw, maskh);
		    Entity entidade = Game.entidades.get(i);
		    if(entidade instanceof Ponto) {
		        Rectangle ponto = new Rectangle(entidade.getX() + maskx, entidade.getY() + masky, maskw, maskh);
		        if(player.intersects(ponto)) {
		            Game.entidades.remove(i);
		            Score.pontuou = true;
		        }
		    }
		}
	}
	public void colisao2(int nextx, int nexty) {
		for(int i = 0; i < Game.entidades.size(); i++) {
			Rectangle player = new Rectangle(nextx + maskx, nexty + masky, maskw, maskh);
		    Entity entidade = Game.entidades.get(i);
		    if(entidade instanceof Bonus) {
		        Rectangle ponto = new Rectangle(entidade.getX() + maskx, entidade.getY() + masky, maskw, maskh);
		        if(player.intersects(ponto)) {
		            Game.entidades.remove(i);
		            Score.time += 100000;
		        }
		    }
		}
	}
	public void colisao3(int nextX, int nextY) {
	    Rectangle player = new Rectangle(nextX + maskx, nextY + masky, maskw, maskh);
	    
	    for (Entity entity : Game.entidades) {
	        if (entity instanceof Rato) {
	            Rectangle rato = new Rectangle(entity.getX() + Rato.maskx, entity.getY() + Rato.masky,
	                    Rato.maskw, Rato.maskh);
	            
	            if (player.intersects(rato)) {
	            	Game.gamestate = "gamestatus";
	            	
	                System.out.println("Alvejado");
	            }
	        }
	    }
	}
	public void render(Graphics g) {
		if(direcaoatual == direita && movimentacao == 1) {
			g.drawImage(playerright[index], this.getX()-Camera.x, this.getY()-Camera.y, null);
		}
		
		if(direcaoatual == direita && movimentacao == 0) {
			g.drawImage(playerright[0], this.getX()-Camera.x, this.getY()-Camera.y, null);
		}
		
		if(direcaoatual == esquerda && movimentacao == 1) {
			g.drawImage(playerleft[index], this.getX()-Camera.x, this.getY()-Camera.y, null);
		}
		if(direcaoatual == esquerda && movimentacao == 0) {
			g.drawImage(playerleft[0], this.getX()-Camera.x, this.getY()-Camera.y, null);
		}
		if(direcaoatual == cima && movimentacao == 1) {
			g.drawImage(playerup[index], this.getX()-Camera.x, this.getY()-Camera.y, null);
		}
		
		if(direcaoatual == cima && movimentacao == 0) {
			g.drawImage(playerup[0], this.getX()-Camera.x, this.getY()-Camera.y, null);
		}
		if(direcaoatual == baixo && movimentacao == 1) {
			g.drawImage(playerdown[index], this.getX()-Camera.x, this.getY()-Camera.y, null);
		}
		
		if(direcaoatual == baixo && movimentacao == 0) {
			g.drawImage(playerdown[0], this.getX()-Camera.x, this.getY()-Camera.y, null);
		}//this.getX(), this.getY()
	}
}
