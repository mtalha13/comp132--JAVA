package materials.interfaces;

import java.awt.Graphics;

public abstract interface drawable {
	public abstract void draw();

	void doAction(Graphics g, int walk);
}
