package Mundo;

public class Camera {
	public static int x, y;
	
	public static int Clamp(int ini, int min, int max) {
		if(ini < min) {
			ini = min;
		}
		if(ini > max) {
			ini = max;
		}
		return ini;
	}
}
