public class PointCP3 {

  private double x;
  private double y;

  public PointCP3(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double getX() {
    return this.x;
  }

  public double getY() {
    return this.y;
  }

  public double getRho() {
    return (Math.sqrt(this.x * this.x + this.y * this.y));
  }

  public double getTheta() {
    return Math.toDegrees(Math.atan2(this.y, this.x));
  }

  public String toString() {
    return String.format("CartesianCoord{%f, %f}", this.x, this.y);
  }

}
