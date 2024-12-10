import java.awt.Graphics;
import javax.swing.JPanel;
public class MovieView extends JPanel{
	public void paint(Graphics g)
	{
		g.drawImage(null, WIDTH, SOMEBITS, PROPERTIES, HEIGHT, FRAMEBITS, ERROR, ALLBITS, ABORT, getFocusCycleRootAncestor());
	}

}
