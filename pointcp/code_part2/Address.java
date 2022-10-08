package code_part2;

public class Address {

    private String street;
    private int number;
    private String postal;

    public Address(String street, int number, String postal) {
        this.street = street;
        this.number = number;
        this.postal = postal;
    }

    public String getStreet() {
        return this.street;
    }

    public int getNumber() {
        return this.number;
    }

    public String getPostal() {
        return this.postal;
    }

}



