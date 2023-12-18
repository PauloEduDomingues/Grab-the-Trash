package Entidades;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Main.Game;
import Mundo.Camera;


public class Entity {
	public int maskx, masky, mwidth, mheight;
	public static BufferedImage paredetest = Game.sprite.getSprite(48, 64, 16, 16);
	public static BufferedImage buraco1 = Game.sprite.getSprite(48, 80, 16, 16);
	public static BufferedImage buraco2 = Game.sprite.getSprite(64, 80, 16, 16);
	public static BufferedImage buraco3 = Game.sprite.getSprite(48, 96, 16, 16);
	public static BufferedImage buraco4 = Game.sprite.getSprite(64, 96, 16, 16);
	public static BufferedImage buraco5 = Game.sprite.getSprite(48, 112, 16, 16);
	public static BufferedImage buraco6 = Game.sprite.getSprite(64, 112, 16, 16);
	public static BufferedImage buraco7 = Game.sprite.getSprite(112, 96, 16, 16);
	public static BufferedImage buraco8 = Game.sprite.getSprite(112, 80, 16, 16);
	public static BufferedImage buraco9 = Game.sprite.getSprite(80, 96, 16, 16);
	public static BufferedImage buraco10 = Game.sprite.getSprite(96, 80, 16, 16);
	public static BufferedImage buraco11 = Game.sprite.getSprite(96, 96, 16, 16);
	public static BufferedImage buraco12 = Game.sprite.getSprite(80, 80, 16, 16);
	public static BufferedImage buraco13 = Game.sprite.getSprite(144, 80, 16, 16);
	public static BufferedImage buraco14 = Game.sprite.getSprite(128, 96, 16, 16);
	public static BufferedImage buraco15 = Game.sprite.getSprite(144, 96, 16, 16);
	public static BufferedImage buraco16 = Game.sprite.getSprite(128, 80, 16, 16);
	
	public static BufferedImage ruavertical = Game.sprite.getSprite(80, 32, 16, 16);
	public static BufferedImage ruahorizontal = Game.sprite.getSprite(96, 32, 16, 16);
	public static BufferedImage cruzamento1 = Game.sprite.getSprite(112, 32, 16, 16);
	public static BufferedImage cruzamento2 = Game.sprite.getSprite(128, 32, 16, 16);
	public static BufferedImage cruzamento3 = Game.sprite.getSprite(112, 48, 16, 16);
	public static BufferedImage cruzamento4 = Game.sprite.getSprite(128, 48, 16, 16);
	public static BufferedImage cruzamentotriplo1 = Game.sprite.getSprite(48, 32, 16, 16);
	public static BufferedImage cruzamentotriplo2 = Game.sprite.getSprite(64, 32, 16, 16);
	public static BufferedImage cruzamentotriplo3 = Game.sprite.getSprite(48, 48, 16, 16);
	public static BufferedImage cruzamentotriplo4 = Game.sprite.getSprite(64, 48, 16, 16);
	
	public static BufferedImage casaduplatelha = Game.sprite.getSprite(64, 0, 16, 16);
	public static BufferedImage casaduplabaixo1 = Game.sprite.getSprite(80, 0, 16, 16);
	public static BufferedImage casaduplabaixo2 = Game.sprite.getSprite(96, 0, 16, 16);
	
	public static BufferedImage casa1 = Game.sprite.getSprite(144, 0, 16, 16);
	public static BufferedImage vazio = Game.sprite.getSprite(144, 144, 16, 16);
	
	public static BufferedImage paredetijolos = Game.sprite.getSprite(80, 112, 16, 16);
	public static BufferedImage paredetijolos2 = Game.sprite.getSprite(96, 112, 16, 16);
	protected double x;
	protected double y;
	protected int widht;
	protected int height;
	protected BufferedImage sprite;
	
	public Entity(int x, int y, int widht, int height, BufferedImage sprite) {
		this.x = x;
		this.y = y;
		this.widht = widht;
		this.height = height;
		this.sprite = sprite;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getX() {
		return (int)this.x;
	}
	public int getY() {
		return (int)this.y;
	}
	public int getWidht() {
		return widht;
	}
	public int getHeight() {
		return height;
	}
	public void tick() {
		
	}
	public void render(Graphics g) {
		 g.drawImage(sprite, this.getX()-Camera.x, this.getY()-Camera.y, null);
	}
}

