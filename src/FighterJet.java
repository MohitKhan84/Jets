import java.awt.Color;


public class FighterJet extends PolygonModel 
{
	
	
	
	public FighterJet(int x, int y, int angle)
	{
		super(x, y, angle);
		
		color[0] = Color.RED;
		color[1] = Color.BLUE;
		
		color[2] = Color.RED;
		color[3] = Color.RED;
		
		color[4] = Color.LIGHT_GRAY;
		color[5] = Color.LIGHT_GRAY;
	}
	

	public int numberOfPolygons()
	{
	   return 7;	
	}
	
	public int[][] generate_x_struct()
	{
	   int[][] x_struct =
   	{
		  
		   {80/2, 60/2, 60/2}, // Head
		   {60/2, -35/2, -35/2, 60/2}, // Body
		   {-35/2, -50/2, -65/2, -45/2}, // Left Tail
		   {-35/2, -50/2, -65/2, -45/2}, // Right Tail
		   {35/2, 20/2, 5/2, 15/2}, // Left Wing
		   {35/2, 20/2, 5/2, 15/2}, // Right Wing
		   
		   
		   
	   };
	   
	   return x_struct;
	}
	
	public int[][] generate_y_struct()
	{
   	   int[][] y_struct =
   	{
    
   		{0/2, -15/2, 15/2}, // Head
   		{-15/2, -15/2, 15/2, 15/2}, // Body
   		{-15/2, -55/2, -55/2, 0/2}, // Left Tail
   		{15/2, 55/2, 55/2, 0/2}, // Right Tail
   		{-15/2, -75/2, -75/2, -15/2}, // Left Wing
   		{15/2, 75/2, 75/2, 15/2}, // Right Wing
   		

   		
   		
   	};
   	   
   
   	
   	return y_struct;
	}
	
		
}
