import java.awt.Color;


public class BadJet2 extends PolygonModel 
{
	
	
	
	public BadJet2(int x, int y, int angle)
	{
		super(x, y, angle);
		
		color[0] = Color.GREEN;
		color[1] = Color.BLUE;
		
		color[2] = Color.BLUE;
		color[3] = Color.YELLOW;
		
		color[4] = Color.BLACK;
		color[5] = Color.BLACK;
	}
	

	public int numberOfPolygons()
	{
	   return 7;	
	}
	
	public int[][] generate_x_struct()
	{
	   int[][] x_struct =
   	{
		  
		   {80/3, 60/3, 60/3}, // Head
		   {60/3, -35/3, -35/3, 60/3}, // Body
		   {-35/3, -50/3, -65/3, -45/3}, // Left Tail
		   {-35/3, -50/3, -65/3, -45/3}, // Right Tail
		   {35/3, 20/3, 5/3, 15/3}, // Left Wing
		   {35/3, 20/3, 5/3, 15/3}, // Right Wing
		   
		   
		   
	   };
	   
	   return x_struct;
	}
	
	public int[][] generate_y_struct()
	{
   	   int[][] y_struct =
   	{
    
   		{0/3, -15/3, 15/3}, // Head
   		{-15/3, -15/3, 15/3, 15/3}, // Body
   		{-15/3, -55/3, -55/3, 0/3}, // Left Tail
   		{15/3, 55/3, 55/3, 0/3}, // Right Tail
   		{-15/3, -75/3, -75/3, -15/3}, // Left Wing
   		{15/3, 75/3, 75/3, 15/3}, // Right Wing
   		

   		
   		
   	};
   	   
   
   	
   	return y_struct;
	}
	
		
}
