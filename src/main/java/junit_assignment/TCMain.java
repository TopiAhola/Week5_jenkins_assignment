package junit_assignment;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TCMain {
    public static void main(String[] args) {
        TemperatureConverter tc = new TemperatureConverter();
        Scanner input = new Scanner(System.in);
        System.out.println("Give temp in c:");
        if(input.hasNext()) {
            System.out.println(
                    tc.celsiusToFahrenheit(input.nextDouble())
                            + " F"
            );

        } else {
            System.out.println("No input...");
        }

    }
}
