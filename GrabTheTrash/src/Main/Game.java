package Main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.List;
import javax.swing.JFrame;

import Entidades.Bonus;
import Entidades.Entity;
import Entidades.Gamestatus;
import Entidades.Gamewin;
import Entidades.Menu;
import Entidades.Pausa;
import Entidades.Ponto;
import Entidades.Rato;
import Entidades.Score;
import graficos.Spritesheet;
import Entidades.player;
import Mundo.Mundo;

import java.util.ArrayList;

public class Game extends Canvas implements Runnable, KeyListener {

	private static final long serialVersionUID = 1L;
	public JFrame janela;
	private Thread thread;
	private boolean rodando = true;
	public static int WIDHT = 240;//160
	public static int HEIGHT = 320;//120
	public static int SCALE = 3;
	
	private static BufferedImage fundo;
	public static List<Entity> entidades; 
	public static Spritesheet sprite;
	public static Mundo mundo;
	public static player player;
	public static Rato rato1;
	public static Rato rato2;
	public static Rato rato3;
	public static Rato rato4;
	public static Ponto vidro;
	public static Ponto vidro1;
	public static Ponto vidro2;
	public static Ponto plastico;
	public static Ponto plastico1;
	public static Ponto plastico2;
	public static Ponto papel;
	public static Ponto papel1;
	public static Ponto papel2;
	public static Ponto metal;
	public static Ponto metal1;
	public static Ponto metal2;
	public static Bonus lixo;
	public static Bonus lixo1;
	
	public static String gamestate = "menu";
	public static Score score;
	public static Pausa pausa;
	public static Menu menu;
	public static Gamestatus gamestatus;
	public static Gamewin gamewin;
	
	public Game() {
		addKeyListener(this);
		this.setPreferredSize(new Dimension(WIDHT*SCALE, HEIGHT*SCALE));
		initFrame();
		fundo = new BufferedImage(WIDHT, HEIGHT, BufferedImage.TYPE_INT_RGB);
		entidades = new ArrayList<Entity>();
		sprite =  new Spritesheet("/personagem.png");
		player = new player(0, 0, 16, 16, sprite.getSprite(0, 0, 16, 16)); 
		entidades.add(player);
		rato1 = new Rato(0, 0, 16, 16, sprite.getSprite(0, 64, 16, 16), 0);
		rato1.setSpeed(0.8);
		entidades.add(rato1);
		rato2 = new Rato(0, 0, 16, 16, sprite.getSprite(0, 64, 16, 16), 1);
		rato2.setSpeed(0.7);
		entidades.add(rato2);
		rato3 = new Rato(0, 0, 16, 16, sprite.getSprite(0, 64, 16, 16), 2);
		rato3.setSpeed(0.6);
		entidades.add(rato3);
		rato4 = new Rato(0, 0, 16, 16, sprite.getSprite(0, 64, 16, 16), 3);
		rato4.setSpeed(1);
		entidades.add(rato4);
		vidro = new Ponto(0, 0, 16, 16, sprite.getSprite(48, 0, 16, 16));
		entidades.add(vidro);
		vidro1 = new Ponto(0, 0, 16, 16, sprite.getSprite(48, 0, 16, 16));
		entidades.add(vidro1);
		vidro2 = new Ponto(0, 0, 16, 16, sprite.getSprite(48, 0, 16, 16));
		entidades.add(vidro2);
		plastico = new Ponto(0, 0, 16, 16, sprite.getSprite(96, 16, 16, 16));
		entidades.add(plastico);
		plastico1 = new Ponto(0, 0, 16, 16, sprite.getSprite(96, 16, 16, 16));
		entidades.add(plastico1);
		plastico2 = new Ponto(0, 0, 16, 16, sprite.getSprite(96, 16, 16, 16));
		entidades.add(plastico2);
		papel = new Ponto(0, 0, 16, 16, sprite.getSprite(64, 16, 16, 16));
		entidades.add(papel);
		papel1 = new Ponto(0, 0, 16, 16, sprite.getSprite(64, 16, 16, 16));
		entidades.add(papel1);
		papel2 = new Ponto(0, 0, 16, 16, sprite.getSprite(64, 16, 16, 16));
		entidades.add(papel2);
		metal = new Ponto(0, 0, 16, 16, sprite.getSprite(48, 16, 16, 16));
		entidades.add(metal);
		metal1 = new Ponto(0, 0, 16, 16, sprite.getSprite(48, 16, 16, 16));
		entidades.add(metal1);
		metal2 = new Ponto(0, 0, 16, 16, sprite.getSprite(48, 16, 16, 16));
		entidades.add(metal2);
		lixo = new Bonus(0, 0, 16, 16, sprite.getSprite(80, 16, 16, 16));
		entidades.add(lixo);
		lixo1 = new Bonus(0, 0, 16, 16, sprite.getSprite(80, 16, 16, 16));
		entidades.add(lixo1);
		menu = new Menu(0, 0, 0, 0, fundo);
		score = new Score(0, 0, 0, 0, fundo);
		pausa = new Pausa(0,0,0,0, null);
		gamestatus = new Gamestatus(0, 0, 0, 0, fundo);
		gamewin = new Gamewin(0, 0, 0, 0, fundo);
		mundo =  new Mundo("/level teste.png");
	}
	private  void initFrame() {
		janela = new JFrame("GrabTrash");
		janela.add(this);
		janela.setResizable(false);
		janela.pack();
		janela.setLocationRelativeTo(null);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
		//janela.setSize(500, 700);
	}
	public static void main(String[] args) {
		Game gaptrash = new Game();
		gaptrash.iniciar();
	}
	public synchronized void iniciar() {
		thread = new Thread(this);
		rodando =true;
		thread.start();
	}
	public synchronized void parar() {
		rodando = false;
		try {
			thread.join();
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void tick() {
		if(gamestate == "game")
		for(int i=0; i < entidades.size(); i++) {
			Entity entidade = entidades.get(i);
			entidade.tick();
			score.tick();
		}
		else if(gamestate == "menu") {
			menu.tick();
		}
		else if(gamestate == "pausa") {
			pausa.tick();
		}
		else if(gamestate == "gamestatus") {
			gamestatus.tick();
		}
		
		else if(gamestate == "gamewin") {
			gamewin.tick();
		}
	}
	public void render() {
		BufferStrategy buffer = this.getBufferStrategy();
		if(buffer==null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = fundo.getGraphics();
		g.setColor(new Color(160, 82, 45));
		g.fillRect(0, 0, WIDHT, HEIGHT);
		
		mundo.render(g);
		if (gamestate == "game") {
			for(int i=0; i < entidades.size(); i++) {
				Entity entidade = entidades.get(i);
				entidade.render(g);
				score.render(g);
			
			}
			}
			else if(gamestate == "menu") {
				menu.render(g);
			}
		
			else if (gamestate == "gamestatus") {
				gamestatus.render(g);
				
			}
		
			else if(gamestate == "gamewin") {
				gamewin.render(g);
			}
			else if(gamestate == "pausa") {
				for(int i=0; i < entidades.size(); i++) {
					Entity entidade = entidades.get(i);
					entidade.render(g);
					score.render(g);
					pausa.render(g);
			}
			}
		
		
		g = buffer.getDrawGraphics();
		g.drawImage(fundo, 0, 0, WIDHT*SCALE, HEIGHT*SCALE, null);
		buffer.show();
	}
	

public static void reiniciar() {
    entidades.clear();

    player = new player(0, 0, 16, 16, sprite.getSprite(0, 0, 16, 16)); 
    entidades.add(player);

    rato1 = new Rato(0, 0, 16, 16, sprite.getSprite(0, 64, 16, 16), 0);
    rato1.setSpeed(0.8);
    entidades.add(rato1);

    rato2 = new Rato(0, 0, 16, 16, sprite.getSprite(0, 64, 16, 16), 1);
    rato2.setSpeed(0.7);
    entidades.add(rato2);
  
    rato3 = new Rato(0, 0, 16, 16, sprite.getSprite(0, 64, 16, 16), 2);
		rato3.setSpeed(0.6);
		entidades.add(rato3);
		rato4 = new Rato(0, 0, 16, 16, sprite.getSprite(0, 64, 16, 16), 3);
		rato4.setSpeed(1);
		entidades.add(rato4);
		vidro = new Ponto(0, 0, 16, 16, sprite.getSprite(48, 0, 16, 16));
		entidades.add(vidro);
		vidro1 = new Ponto(0, 0, 16, 16, sprite.getSprite(48, 0, 16, 16));
		entidades.add(vidro1);
		vidro2 = new Ponto(0, 0, 16, 16, sprite.getSprite(48, 0, 16, 16));
		entidades.add(vidro2);
		plastico = new Ponto(0, 0, 16, 16, sprite.getSprite(96, 16, 16, 16));
		entidades.add(plastico);
		plastico1 = new Ponto(0, 0, 16, 16, sprite.getSprite(96, 16, 16, 16));
		entidades.add(plastico1);
		plastico2 = new Ponto(0, 0, 16, 16, sprite.getSprite(96, 16, 16, 16));
		entidades.add(plastico2);
		papel = new Ponto(0, 0, 16, 16, sprite.getSprite(64, 16, 16, 16));
		entidades.add(papel);
		papel1 = new Ponto(0, 0, 16, 16, sprite.getSprite(64, 16, 16, 16));
		entidades.add(papel1);
		papel2 = new Ponto(0, 0, 16, 16, sprite.getSprite(64, 16, 16, 16));
		entidades.add(papel2);
		metal = new Ponto(0, 0, 16, 16, sprite.getSprite(48, 16, 16, 16));
		entidades.add(metal);
		metal1 = new Ponto(0, 0, 16, 16, sprite.getSprite(48, 16, 16, 16));
		entidades.add(metal1);
		metal2 = new Ponto(0, 0, 16, 16, sprite.getSprite(48, 16, 16, 16));
		entidades.add(metal2);
		lixo = new Bonus(0, 0, 16, 16, sprite.getSprite(80, 16, 16, 16));
		entidades.add(lixo);
		lixo1 = new Bonus(0, 0, 16, 16, sprite.getSprite(80, 16, 16, 16));
		entidades.add(lixo1);
		menu = new Menu(0, 0, 0, 0, fundo);
		score = new Score(0, 0, 0, 0, fundo);
		pausa = new Pausa(0,0,0,0, null);
		gamestate = "game";
		mundo =  new Mundo("/level teste.png");
}
	
	
	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTick = 60.0f;
		double ms = 1000000000 / amountOfTick;
		double delta = 0;
		int frames = 0;
		double timer = System.currentTimeMillis();
		while(rodando) {
			long now = System.nanoTime();
			delta +=(now - lastTime) / ms;
			lastTime = now;
			if(delta > 1) {
				tick();
				render();
				frames++;
				delta--;
			}
			if(System.currentTimeMillis() - timer >= 1000) {
				System.out.printf("FPS: %s\n", frames);
				frames = 0;
				timer += 1000;
			}
		}
	parar();
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_D) {
			player.up = false;
			player.down = false;
			player.left = false;
			player.right = true;
		}else if(e.getKeyCode() == KeyEvent.VK_A) {
			player.right = false;
			player.up = false;
			player.down = false;
			player.left = true;
		}else if(e.getKeyCode() == KeyEvent.VK_W) {
			player.down = false;
			player.left = false;
			player.right = false;
			player.up = true;
		}else if(e.getKeyCode() == KeyEvent.VK_S) {
			player.left = false;
			player.right = false;
			player.up = false;
			player.down = true;
		}if(e.getKeyCode() == KeyEvent.VK_UP) {
			if(gamestate == "menu")
			 Menu.up = true;
			
			
			if(gamestate == "pausa")
				Pausa.up = true;
			
			
			 if(gamestate == "gamestatus")
				 Gamestatus.up = true;
			 if(gamestate == "gamewin")
					Gamewin.up = true;
		}
		
		
			
			if(e.getKeyCode() == KeyEvent.VK_DOWN) {
				
				if(gamestate == "menu")
					Menu.down = true;	
				
				if(gamestate == "pausa")
					Pausa.down = true;
				
				
				if(gamestate == "gamestatus")
					Gamestatus.down = true;
				
				if(gamestate == "gamewin")
					Gamewin.down = true;
		}
				
		
			
			
				
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			if(gamestate == "menu")
				Menu.enter = true;
			
			if(gamestate == "pausa")
				Pausa.enter = true;
			
			if(gamestate == "gamestatus")
				Gamestatus.enter = true;
				System.out.println("funfando");
			if(gamestate == "gamewin")
				Gamewin.enter = true;
	}
		
				
		
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			if(gamestate == "game") {
				gamestate = "pausa";
			}
			else if(gamestate == "pausa") {
				gamestate = "game";
			}
			
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {	
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			 Menu.up = false;
		}
			 
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			 Menu.down = false;	}	 
			
			

		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			Menu.enter = false;			
		}
			
	}
}
