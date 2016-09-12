public class MyFirstProgram{
	public static void main(String[] args){

		Point point1 = new Point(12, 10);
		Point point2 = new Point(6, 7);

		//реализация через функцию вне класса
		double result1 = distance(point1, point2);
		System.out.println("Расстояние между точками т1 ("+ point1.x+","+point1.y +") и т2 ("+ point2.x+","+ point2.y +") = "+  result1);
		// реализация в классе
		double result2 = point1.distanceTo(point2);
		System.out.println("Расстояние между точками т1 ("+ point1.x+","+point1.y +") и т2 ("+ point2.x+","+ point2.y +") = "+  result2);
	}
	public static double distance(Point p1, Point p2)	{
		int n = (p1.x - p2.x);
		int m = (p1.y - p2.y);

		return  Math.sqrt(n*n + m*m);
	}
}

