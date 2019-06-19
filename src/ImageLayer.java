import java.awt.*;

public class ImageLayer
{
	Image image;
	
	int x; 
	int y;
	int z;

	public ImageLayer(int x, int y, int z, String filename)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		
		image = Toolkit.getDefaultToolkit().getImage(filename);
	}
	
	
	public void draw(Graphics g)
	{
		for(int i = 0; i < 54; i++)
	   	g.drawImage(image, (int)(x + 720*i - Camera.x / z), (int)(y- Camera.y / z), null);
	}

}