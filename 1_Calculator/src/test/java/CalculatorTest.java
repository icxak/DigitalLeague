
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {


    @Test
    public void expressionToRpn() {
        String expectedString = "2 2 +10 5 /4*+";
        assertEquals(expectedString,Calculator.ExpressionToRpn("2+2+10/5*4"));
    }

    @Test
    public void TestRPNtoAnswer() {

        double expectedDouble = 12;
        assertEquals(12,Calculator.RPNtoAnswer("2 2 +10 5 /4*+"),0.001);
    }
}