package data;

public class ShapeCreator {
	
	private static double getUp(double point1, double point2, double arg) {		
		return (arg - point1)/(point2 - point1);
	}
	
	private static double getDown(double point1, double point2, double arg) {
		return (point2 - arg)/(point2 - point1);
	}
	
	static double trapeze(boolean fromOne, double arg, int... points) {
		
		if(points.length == 2) {
			if(arg < points[0]) {
				return (fromOne ? 1 : 0);
			}
			else if(arg < points[1]) {
				return (fromOne ? getDown(points[0], points[1], arg) : getUp(points[0], points[1], arg));
			}
			else {
				return (fromOne ? 0 : 1);
			}
		}
		else {
			if(arg < points[0] || arg > points[3]) {
				return 0;
			}
			else if(arg < points[1]) {
				return getUp(points[0], points[1], arg);
			}
			else if(arg < points[2]) {
				return 1;
			}
			else {
				return getDown(points[2], points[3], arg);
			}
		}		
	}
}