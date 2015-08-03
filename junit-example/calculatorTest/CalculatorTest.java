/*************************************************************************
    > File Name: CalculatorTest.java
    > Author: kinsang
    > Mail: 492159680@qq.com
    > Created Time: 2015年08月02日 星期日 21时02分49秒
 ************************************************************************/

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void evaluatesExpression() {
        Calculator calculator = new Calculator();
        int sum = calculator.evaluate("1+2+3");
        assertEquals(6, sum);
    }
}

