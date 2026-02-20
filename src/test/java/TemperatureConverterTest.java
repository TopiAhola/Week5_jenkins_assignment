import junit_assignment.TemperatureConverter;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


class TemperatureConverterTest {

    @Test
    @DisplayName("Test fahrenheitToCelcius")
    public void fahrenheitToCelsiusTest() {
        TemperatureConverter tc = new TemperatureConverter();
        assertEquals(-17.22222222222222, tc.fahrenheitToCelsius(1));
        assertEquals(37.77777777777778, tc.fahrenheitToCelsius(100));
        assertEquals(-73.33333333333334, tc.fahrenheitToCelsius(-100));
        assertEquals(-40, tc.fahrenheitToCelsius(-40));
    }

    @Test
    @DisplayName("Test celsiusToFahrenheit")
    public void celsiusToFahrenheitTest() {
        TemperatureConverter tc = new TemperatureConverter();
        assertEquals(32.0, tc.celsiusToFahrenheit(0));
        assertEquals(212.0, tc.celsiusToFahrenheit(100));
        assertEquals(-148.0, tc.celsiusToFahrenheit(-100));
        assertEquals(-40, tc.celsiusToFahrenheit(-40));
    }

    @Test
    @DisplayName("Test isExtremeTemperature")
            public void isExtremeTemperatureTest() {
            TemperatureConverter tc = new TemperatureConverter();
            assertTrue(tc.isExtremeTemperature(-9999));
            assertTrue(tc.isExtremeTemperature(9999));
            assertTrue(tc.isExtremeTemperature(51));
            assertTrue(tc.isExtremeTemperature(-40.000000001));
            assertFalse(tc.isExtremeTemperature(-1));
            assertFalse(tc.isExtremeTemperature(0));
            assertFalse(tc.isExtremeTemperature(50));
            assertFalse(tc.isExtremeTemperature(-40));
    }

    @Test
    @DisplayName("Test kelvinToCelsius")
    public void kelvinToCelsiusTest() {
        TemperatureConverter tc = new TemperatureConverter();
        assertEquals(-273.15, tc.kelvinToCelsius(0), "Wrong kelvin conversion" );
        assertEquals(457-273.15, tc.kelvinToCelsius(457), "Wrong kelvin conversion" );
        assertThrows(IllegalArgumentException.class , ()-> tc.kelvinToCelsius(-5),"Invalid input not detected" ) ;
    }



}
