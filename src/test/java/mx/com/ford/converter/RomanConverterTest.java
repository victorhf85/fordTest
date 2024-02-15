package mx.com.ford.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RomanConverterTest {

    private RomanConverter romanConverter;

    private Random random = new Random();
    @BeforeEach
    public void setup() {
        romanConverter = new RomanConverter();
    }

    @Test
    void converter() {

        int number = random.nextInt(1, 3000);
        String result = romanConverter.converter(number);

        assertNotNull(result);

        number = 9;
        result = romanConverter.converter(number);
        assertEquals("IX", result);

        number = 85;
        result = romanConverter.converter(number);
        assertEquals("LXXXV", result);

        number = 621;
        result = romanConverter.converter(number);
        assertEquals("DCXXI", result);

        number = 2024;
        result = romanConverter.converter(number);
        assertEquals("MMXXIV", result);

    }

    @Test
    void converter_error() {

        int number = 0;
        String result = romanConverter.converter(number);

        assertEquals("ERROR", result);
    }
}