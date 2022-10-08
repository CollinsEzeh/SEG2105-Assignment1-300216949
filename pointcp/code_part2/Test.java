package code_part2;
import java.io.*;

public class Test {
    public static void main(String args[]){
        Address addressOne= new Address( "King Edward", 800, "k16N5");
        Address addressTwo= new Address("Queen",48,  "K1PN2");
        Employee employeeOne= new Employee("Falcao", 40, 15.50, addressOne);

    }
}
