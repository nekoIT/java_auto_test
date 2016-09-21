package ru.autoqa.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.autoqa.sandbox.Point;

public class PointTest {

    // Assert testNG
    @Test
    public void distance1(){
        Point p1 = new Point(0, 5);
        Point p2 = new Point(0, 10);
        Assert.assertEquals(p1.distanceTo(p2),5.0);
    }
    // Assert testNG
    @Test
    public void distance2(){
        Point p1 = new Point(4, 1);
        Point p2 = new Point(2, 1);
        Assert.assertEquals(p1.distanceTo(p2),2.0);
    }
    // assert
    @Test
    public void distance3(){
        Point p1 = new Point(15, 5);
        Point p2 = new Point(15, 4);
        assert  p1.distanceTo(p2)== 1;
    }
}
