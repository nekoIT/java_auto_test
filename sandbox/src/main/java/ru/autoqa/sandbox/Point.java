package ru.autoqa.sandbox;

public class Point {

    public int x;
    public int y;

    public  Point (int x, int y){
        this.x = x;
        this.y = y;
    }

    public double distanceTo(Point point) {
        int n = (this.x - point.x);
		int m = (this.y - point.y);

		return  Math.sqrt(n*n + m*m);
    }
}
