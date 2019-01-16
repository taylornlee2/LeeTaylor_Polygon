import java.awt.geom.*;     // for Point2D.Double
import java.util.ArrayList; // for ArrayList
import gpdraw.*;            // for DrawingTool
public class LeeTaylor implements Polygon{
      private ArrayList <Point2D.Double> myPolygon;
      private double x;
      private double y;
      private double perimeter;
      private double total;
      private DrawingTool Pen;
      private SketchPad Paper;
      private String getName;
      private double area = 0.0;
      public LeeTaylor()
      { 
        myPolygon = new ArrayList <Point2D.Double> ();
        Paper = new SketchPad(500,500);
        Pen = new DrawingTool(Paper);
      }
      public void add(Point2D.Double aPoint) 
      { 
        myPolygon.add(aPoint);
      } 
      public String getName()
      {
          return "Taylor Lee";
      }
      public void draw()
      {
        Pen.up();
        Pen.move(myPolygon.get(0).getX(), myPolygon.get(0).getY());
        Pen.down();
        for ( int i = 1; i < myPolygon.size(); i++ )
        {
            Pen.move(myPolygon.get(i).getX(), myPolygon.get(i).getY());
        }
        Pen.move(myPolygon.get(0).getX(), myPolygon.get(0).getY());
      }
      public double perimeter() 
      { 
          for(int i = 0; i < myPolygon.size() - 1; i++)
         {
           perimeter = perimeter + (myPolygon.get(i)).distance(myPolygon.get(i + 1));
        }
        perimeter += distance(myPolygon.get(myPolygon.size() - 1 ), myPolygon.get(0));
        return perimeter;
        }
      public double area() 
      {
        double j1 = (myPolygon.get(myPolygon.size()-1).getX() * myPolygon.get(0).getY());
        double j2 = (myPolygon.get(myPolygon.size()-1).getY() * myPolygon.get(0).getX());
        for(int i = 1; i < myPolygon.size(); i++)
        {
            j1 = j1 + (myPolygon.get(i - 1).getX() * myPolygon.get(i).getY());
            j2 = j2 + (myPolygon.get(i - 1).getY() * myPolygon.get(i).getX());
        }
        return Math.abs((j1-j2)/2);
      } 
      private double distance( Point2D.Double a, Point2D.Double b )
      {
         return Math.sqrt(Math.pow(( b.x - a.x ),2) + Math.pow(( b.y - a.y ),2));
      }
     }