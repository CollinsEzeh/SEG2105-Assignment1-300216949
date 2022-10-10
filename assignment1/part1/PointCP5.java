package part1;

public abstract class PointCP5 {

    public abstract double getX();
    public abstract double getY();

    public abstract double getRho();
    public abstract double getTheta();

    public double getDistance(PointCP5 other) {
        double deltaX = getX() - other.getX();
        double deltaY = getY() - other.getY();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    public PointCP5 rotatePoint(double rotation) {
        double a = Math.toRadians(rotation);
        double x = this.getX(), y = this.getY();
        double sa = Math.sin(a), ca = Math.cos(a);
        return new PointCP3(ca * x - sa * y, sa * x + ca * y);
    }

}
