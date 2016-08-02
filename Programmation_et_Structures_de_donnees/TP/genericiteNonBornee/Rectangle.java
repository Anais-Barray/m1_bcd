package genericiteNonBornee;

public class Rectangle{
    private double width;
    private double height;

    public double getWidth()
    {
        return width;
    }

    public void setWidth(double width)
    {
        this.width = width;
    }

    public double getHeight()
    {
        return height;
    }

    public void setHeight(double height)
    {
        this.height = height;
    }

    public Rectangle(double width, double height)
    {
        this.width = width;
        this.height = height;
    }
    
    public Rectangle()
    {
        this.width = 0;
        this.height = 0;
    }
    
    public String toString()
    {
        return "Rectangle de largeur " + this.width + " et hauteur " + this.height;
    }

}
