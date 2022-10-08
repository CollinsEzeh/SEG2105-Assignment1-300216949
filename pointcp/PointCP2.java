public class PointCP2 {

  private double rho;
  private double theta;

  public PointCP2(double rho, double theta) {
    this.rho = rho;
    this.theta = theta;
  }

  public double getX() {
    return Math.cos(Math.toRadians(this.theta)) * this.rho;
  }

  public double getY() {
    return Math.sin(Math.toRadians(this.theta)) * this.rho;
  }

  public double getRho() {
    return this.rho;
  }

  public double getTheta() {
    return this.theta;
  }

  public String toString() {
    return String.format("PolarCoord{%f, %f}", this.rho, this.theta);
  }

}
