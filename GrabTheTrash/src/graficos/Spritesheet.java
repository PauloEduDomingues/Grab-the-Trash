package graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Mundo.Camera;

public class Spritesheet {
	public BufferedImage spritesheet;
	
	public Spritesheet(String path) {
		try {
			spritesheet = ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public BufferedImage getSprite(int x, int y, int widht, int height) {
		return spritesheet.getSubimage(x-Camera.x, y-Camera.y, widht, height);
	}
}
