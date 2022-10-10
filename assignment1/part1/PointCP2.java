package part1;

public class PointCP2 extends PointCP5 {

  private double rho;
  private double theta;

  public PointCP2(double rho, double theta) {
    this.rho = rho;
    this.theta = theta;
  }

  @Override
  public double getX() {
    return Math.cos(Math.toRadians(this.theta)) * this.rho;
  }

  @Override
  public double getY() {
    return Math.sin(Math.toRadians(this.theta)) * this.rho;
  }

  @Override
  public double getRho() {
    return this.rho;
  }

  @Override
  public double getTheta() {
    return this.theta;
  }

  @Override
  public String toString() {
    return String.format("PolarCoord{%f, %f}", this.rho, this.theta);
  }

}
