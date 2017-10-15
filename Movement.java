
public class Movement {
	
	private int angle;
	private int distance;
	private int side;
	private int C = 69; // (2piR) (R = 11.3, pi = 3.14) (11.3*3.14*2 = ~71)
	
	public Movement(int angle, int distance, int side)
	{
		this.angle = angle;
		this.distance = distance;
		this.side = side;
	}
		
	public int getAngle()
	{
		return this.angle;
	}	
	
	public int getDistance()
	{
		return this.distance;
	}
	
	public int convertDistance()
	{
		double d = ((double)distance / 19) * 360; // 19 (size of the wheel) (2piR)
		return (int)d; 
	}
	
	public int convertAngle()
	{	
		double a = ((C/(360/(double)angle)) / 19) * 360; // 19 (size of the wheel) (2piR)
		return (int)a;  
	}
	
	public int getSide()
	{
		return side;
	}

}
