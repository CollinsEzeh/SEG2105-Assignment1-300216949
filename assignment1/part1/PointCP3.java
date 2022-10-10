package part1;

public class PointCP3 extends PointCP5 {

  private double x;
  private double y;

  public PointCP3(double x, double y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public double getX() {
    return this.x;
  }

  @Override
  public double getY() {
    return this.y;
  }

  @Override
  public double getRho() {
    return Math.sqrt(this.x * this.x + this.y * this.y);
  }

  @Override
  public double getTheta() {
    return Math.toDegrees(Math.atan2(this.y, this.x));
  }

  @Override
  public String toString() {
    return String.format("CartesianCoord{%f, %f}", this.x, this.y);
  }

}
