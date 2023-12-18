package Entidades;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import Main.Game;

public class Rato extends Entity{
	public boolean right, left, down, up;
	public double speed;
	public boolean start = true;
	
	public int cor;
	public int direita = 1, esquerda = 0, cima = 2, baixo = 3;
	public int direcaoatual = direita;
	public int movimentacao = 0;
	public static int maskx= 0;
	public static int masky = 0;
	public static int maskw = 14;
	public static int maskh = 14;
	
	public BufferedImage[] ratoright;
	public BufferedImage[] ratoleft;
	public BufferedImage[] ratoup;
	public BufferedImage[] ratodown;
	public int posx, posy;
	public int frames = 0, maxframes = 5, index = 0, maxindex = 2;
	public Rato(int x, int y, int widht, int height, BufferedImage sprite, int cor) {
		super(x, y, widht, height, sprite);
		ratoright = new BufferedImage[3];
		ratoleft = new BufferedImage[3];
		ratoup = new BufferedImage[3];
		ratodown = new BufferedImage[3];
		System.out.println(cor);
		int corrato = cor;
		
		for(int i= 0; i < 3; i++) {
			if(corrato==0)
				ratoright[i] = Game.sprite.getSprite(0 + (i*16), 96, 16, 16);
			if(corrato==1)
				ratoright[i] = Game.sprite.getSprite(0 + (i*16), 160, 16, 16);
			if(corrato==2)
				ratoright[i] = Game.sprite.getSprite(0 + (i*16), 128, 16, 16);
			if(corrato==3)
				ratoright[i] = Game.sprite.getSprite(0 + (i*16), 64, 16, 16);
		}
		for(int i= 0; i < 3; i++) {
			if(corrato==0)
				ratoleft[i] = Game.sprite.getSprite(32 - (i*16), 112, 16, 16);
			if(corrato==1)
				ratoleft[i] = Game.sprite.getSprite(32 - (i*16), 176, 16, 16);
			if(corrato==2)
				ratoleft[i] = Game.sprite.getSprite(32 - (i*16), 144, 16, 16);
			if(corrato==3)
				ratoleft[i] = Game.sprite.getSprite(32 - (i*16), 80, 16, 16);
		}
		for(int i= 0; i < 3; i++) {
			if(corrato==0)
				ratoup[i] = Game.sprite.getSprite(0 + (i*16), 96, 16, 16);
			if(corrato==1)
				ratoup[i] = Game.sprite.getSprite(0 + (i*16), 160, 16, 16);
			if(corrato==2)
				ratoup[i] = Game.sprite.getSprite(0 + (i*16), 128, 16, 16);
			if(corrato==3)
				ratoup[i] = Game.sprite.getSprite(0 + (i*16), 64, 16, 16);
		}
		for(int i= 0; i < 3; i++) {
			if(corrato==0)
				ratodown[i] = Game.sprite.getSprite(32 - (i*16), 112, 16, 16);
			if(corrato==1)
				ratodown[i] = Game.sprite.getSprite(32 - (i*16), 176, 16, 16);
			if(corrato==2)
				ratodown[i] = Game.sprite.getSprite(32 - (i*16), 144, 16, 16);
			if(corrato==3)
				ratodown[i] = Game.sprite.getSprite(32 - (i*16), 80, 16, 16);
		}
		}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public void tick() {
		if(start) {
			x+=speed;
			if (colisao1((int)(x+speed), this.getY())) {
			    start = false;
			    mudarDirecao();
			}
		}
	    int oldX = Game.rato1.getX();
	    int oldY = Game.rato1.getY();
	    movimentacao = 0;
	    if(right && colisao1((int)(x+speed), this.getY())) {
	    	right = false; 
	    	mudarDirecao();
	    }
	    if(right && !colisao1((int)(x+speed), this.getY())) {
	        x+=speed;
	        movimentacao = 1;
	        direcaoatual = direita;
	    }
	    if(left && colisao1((int)(x-speed), this.getY())) {
	    	left = false;
	    	mudarDirecao();
	    }
	    if(left && !colisao1((int)(x-speed), this.getY())) {
	        x-=speed;
	        movimentacao = 1;
	        direcaoatual = esquerda;
	    }
	    if(up && colisao1(this.getX(), (int)(y-speed))) {
	    	up = false;
	    	mudarDirecao();
	    }
	    if(up && !colisao1(this.getX(), (int)(y-speed))) {
	        y-=speed;
	        movimentacao = 1;
	        direcaoatual = cima;
	    }
	    if(down && colisao1(this.getX(), (int)(y+speed))) {
	    	down = false;
	    	mudarDirecao();
	    }
	    if(down && !colisao1(this.getX(), (int)(y+speed))) {
	        y+=speed;
	        movimentacao = 1;
	        direcaoatual = baixo;
	    }
	    if(movimentacao == 1 && colisao1(posx, posy)) {
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
	private void mudarDirecao() {
	    Random rand = new Random();
	    int numSorteado = rand.nextInt(4) + 1;
	    switch(numSorteado) {
	        case 1:
	            right = true;
	            left = false;
	            up = false;
	            down = false;
	            direcaoatual = direita;
	            break;
	        case 2:
	            right = false;
	            left = true;
	            up = false;
	            down = false;
	            direcaoatual = esquerda;
	            break;
	        case 3:
	            right = false;
	            left = false;
	            up = true;
	            down = false;
	            direcaoatual = cima;
	            break;
	        case 4:
	            right = false;
	            left = false;
	            up = false;
	            down = true;
	            direcaoatual = baixo;
	            break;
	        default:
	            break;
	    }
	}
	public boolean colisao1(int nextx, int nexty) {
	    Rectangle rato  = new Rectangle(nextx + maskx, nexty + masky, maskw, maskh);
	    for(int i = 0; i < Game.entidades.size(); i++) {
	        Entity entidade = (Entity) Game.entidades.get(i);
	        if(entidade instanceof Solido) {
	            Rectangle solido = new Rectangle(entidade.getX() + maskx, entidade.getY() + masky, maskw, maskh);
	            if(rato.intersects(solido)) {
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
	public void render(Graphics g) {
		if(direcaoatual == direita && movimentacao == 1) {
			g.drawImage(ratoright[index], this.getX(), this.getY(), null);
		}
		
		if(direcaoatual == direita && movimentacao == 0) {
			g.drawImage(ratoright[0], this.getX(), this.getY(), null);
		}
		
		if(direcaoatual == esquerda && movimentacao == 1) {
			g.drawImage(ratoleft[index], this.getX(), this.getY(), null);
		}
		if(direcaoatual == esquerda && movimentacao == 0) {
			g.drawImage(ratoleft[0], this.getX(), this.getY(), null);
		}
		if(direcaoatual == cima && movimentacao == 1) {
			g.drawImage(ratoup[index], this.getX(), this.getY(), null);
		}
		
		if(direcaoatual == cima && movimentacao == 0) {
			g.drawImage(ratoup[0], this.getX(), this.getY(), null);
		}
		if(direcaoatual == baixo && movimentacao == 1) {
			g.drawImage(ratodown[index], this.getX(), this.getY(), null);
		}
		
		if(direcaoatual == baixo && movimentacao == 0) {
			g.drawImage(ratodown[0], this.getX(), this.getY(), null);
		}//this.getX(), this.getY()
	}
}
