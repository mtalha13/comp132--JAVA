package materials;

import javax.swing.JLabel;

import materials.interfaces.drawable;

public abstract class Material extends JLabel implements drawable{
	public int precision = 51;

	public abstract void draw();
	

}
