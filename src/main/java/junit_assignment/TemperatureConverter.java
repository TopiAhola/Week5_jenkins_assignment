package junit_assignment;

public class TemperatureConverter {

/**
 This method should convert a temperature from Fahrenheit to Celsius using the formula: [ Celsius = (Fahrenheit - 32) * 5 \ 9 ]
 The method should accept a double parameter (temperature in Fahrenheit) and return a double value (temperature in Celsius).
 celsiusToFahrenheit:
 */
public double fahrenheitToCelsius(double fahrenheit){
    return (fahrenheit-32)*(5.0 /9.0) ;
}

/** This method should convert a temperature from Celsius to Fahrenheit using the formula: [ Fahrenheit = (Celsius * 9 / 5 + 32 ]
 The method should accept a double parameter (temperature in Celsius) and return a double value (temperature in Fahrenheit).
 isExtremeTemperature:
 */
public double celsiusToFahrenheit(double celsius){
    return (celsius * 9.0/5.0) + 32;
}

/** This method should check if the given Celsius temperature is considered "extreme."
 A temperature is considered extreme if it is:
 Below -40°C, or
 Above 50°C.
 The method should accept a double parameter (temperature in Celsius) and return a boolean value (true for extreme temperatures and false otherwise).
 */
public boolean isExtremeTemperature(double celsius){
    return (celsius > 50 || celsius < -40);
}

    /**
     * Converts kelvin temperature to Celsius temperature
     * @param kelvin temperature in kelvin. Has to be >= 0
     * @return Celsius
     */
public double kelvinToCelsius(double kelvin){
    if(kelvin >= 0) {
        return kelvin - 273.15 ;
    } else {
        throw new IllegalArgumentException("kelvin temperature must be greater or equal to 0");
    }
}



}




