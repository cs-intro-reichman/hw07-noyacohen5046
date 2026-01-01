/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

        /*
		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		curve(Integer.parseInt(args[0]),
			  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		      Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		*/

		
		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		snowFlake(Integer.parseInt(args[0]));
		
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		if (n == 0) {
            StdDraw.line(x1, y1, x2, y2);
            return;
        }

		double px1 = x1 + (x2 - x1) / 3.0;
        double py1 = y1 + (y2 - y1) / 3.0;

		double px3 = x1 + 2.0 * (x2 - x1) / 3.0;
        double py3 = y1 + 2.0 * (y2 - y1) / 3.0;

		double angle = Math.toRadians(60);
        double dx = px3 - px1;
        double dy = py3 - py1;

		double px2 = px1 + dx * Math.cos(angle) - dy * Math.sin(angle);
        double py2 = py1 + dx * Math.sin(angle) + dy * Math.cos(angle);

		curve(n - 1, x1, y1, px1, py1);  
        curve(n - 1, px1, py1, px2, py2); 
        curve(n - 1, px2, py2, px3, py3); 
        curve(n - 1, px3, py3, x2, y2);   
	}

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
		// A little tweak that makes the drawing look better
		StdDraw.setYscale(0, 1.1);
		StdDraw.setXscale(0, 1.1);
		// Draws a Koch snowflake of depth n
		double x1 = 0.5, y1 = 0.0;
        double x2 = 0.933, y2 = 0.75; 
        double x3 = 0.067, y3 = 0.75;

		curve(n, x3, y3, x2, y2);
        curve(n, x2, y2, x1, y1);
        curve(n, x1, y1, x3, y3);
	}
}