package code_part2;

public class Employee {

    private String name;
    private int hours;
    private double rate;
    private Address address;

    public Employee(String name, int hours, double rate, Address address) {
        this.name = name;
        this.hours = hours;
        this.rate = rate;
        this.address = address;
    }

    public String getName() {
        return this.name;
    }

    public int getHours() {
        return this.hours;
    }

    public double getRate() {
        return this.rate;
    }

    public Address getAddress() {
        return this.address;
    }

}




