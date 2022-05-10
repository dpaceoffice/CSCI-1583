public class Point2D {

    // instance variables
    private double x;
    private double y;

    // constructor that takes 2 arguments
    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public double distance(Point2D other) {
        double x = (other.getX() - this.getX());
        double y = (other.getY() - this.getY());
        double distance = Math.pow((x * x) + (y * y), .5);
        return distance;
    }

    // queries (or getters) return a value by usually
    // don't change the STATE (values of the instance variables)
    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    // commands, or setters, usually don't return anything, but DO
    // modify the state of the object

    public void moveTo(double newX, double newY) {
        this.x = newX;
        this.y = newY;
    }

    public void moveBy(double deltaX, double deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }
    
    public String toString() {
        return String.format("(%.1f,%.1f)", this.x, this.y);
    }


}