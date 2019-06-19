import java.awt.Color;
import java.awt.Graphics;

public abstract class PolygonModel 
{
	double   x;      
	double   y;
	
	int score;
	
	
	int      angle;
	
	int[]    theta  = new int[numberOfPolygons()];
	Color[]  color  = new Color[numberOfPolygons()];
	
	int[][]  x_struct = generate_x_struct();
	int[][]  y_struct = generate_y_struct();
	
	public abstract int[][] generate_x_struct();
	public abstract int[][] generate_y_struct(); 
	public abstract int numberOfPolygons();
	
	

	public PolygonModel(int x, int y, int angle) {
		
		this.x      =  x;
		this.y      =  y;
		
		this.angle  =  angle;
	}
	
		
	public void moveForwardBy(double d)
	{
		x += d * Lookup.cos[angle];
		y += d * Lookup.sin[angle];
	}
	
	public void moveBackwardBy(double d)
	{
		x -= d * Lookup.cos[angle];
		y -= d * Lookup.sin[angle];
	}
	
	
	public void moveBy(int dx, int dy)
	{
		x += dx;
		y += dy;
	}
	
	public void moveUpBy(int dy)
	{
		y -= dy;
	}
	
	public void moveDownBy(int dy)
	{
		y += dy;
	}
	
	public void moveUp(double dist)
	{
		y -= dist;
			
	}
	
	public void moveDown(double dist)
	{
		y += dist;
				
}

	public void moveLeft(double dist)
	{
		x -= dist;
			
   }
	
	public void moveRight(double dist)
	{
		x += dist;
			
   }
	
	public void moveR(Double dist){
		x=dist;
	}
	
	public void showScore(double dist){
		
		score +=dist; 
		
	}
	public double moveAmount(double dist){
		
		x+=dist;
		return x;
		
	}
	
	public void rotateBy(int dangle)
	{
		angle += dangle;
		
		if(angle > 359)  angle -= 360;
		if(angle < 0)    angle += 360;
	}

	
	private static int[] x_temp = new int[10];
	private static int[] y_temp = new int[10];
	
	public void draw(Graphics g)
	{
		// Go through each polygon of the model
		for(int poly = 0; poly < x_struct.length; poly++)
		{
			int A = (angle + theta[poly]);   
			
			if(A > 359)  A -= 360;
			if(A < 0)    A += 360;  
			
			double cosA = Lookup.cos[A];
			double sinA = Lookup.sin[A];

			// Go through each vertex of the current polygon
			for(int vert = 0; vert < x_struct[poly].length; vert++)
			{
				// Work with the next vertex of the model
				double xs = x_struct[poly][vert];
				double ys = y_struct[poly][vert];
				
				// Rotate vertex
				double xr =  xs * cosA - ys * sinA;
				double yr =  xs * sinA + ys * cosA;
				
				// Translate vertex
				double xt = xr + x;
				double yt = yr + y;

				// Truncate to integer coordinates
				x_temp[vert] = (int)(xt);
				y_temp[vert] = (int)(yt);
			}
        
			// Fill in the current polygon with its associated color
			g.setColor(color[poly]);
			g.fillPolygon(x_temp, y_temp, x_struct[poly].length);	
			
			// Outline the current polygon in black
			g.setColor(Color.BLACK);
			g.drawPolygon(x_temp, y_temp, x_struct[poly].length);			
		}
	}
}