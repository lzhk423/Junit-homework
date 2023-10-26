import com.atguigu.spring.aop.annotion.CalculatorImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class CalculatorImplTest {
    private int input1;
    private int input2;
    private int expectedAdd;
    private int expectedSub;
    private int expectedMul;
    private int expectedDiv;

    public CalculatorImplTest(int input1, int input2, int expectedAdd, int expectedSub, int expectedMul, int expectedDiv) {
        this.input1 = input1;
        this.input2 = input2;
        this.expectedAdd = expectedAdd;
        this.expectedSub = expectedSub;
        this.expectedMul = expectedMul;
        this.expectedDiv = expectedDiv;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 2, 2, 4, 0, 4, 1 },
                { 5, 3, 8, 2, 15, 1 },
                { 7, 5, 12, 2, 35, 1 },
                { 9, 3, 12, 6, 27, 3 },
                { 10, 2, 12, 8, 20, 5 }
        });
    }

    @Test
    public void testAdd() {
        CalculatorImpl calculator = new CalculatorImpl();
        assertEquals(expectedAdd, calculator.add(input1, input2));
    }

    @Test
    public void testSub() {
        CalculatorImpl calculator = new CalculatorImpl();
        assertEquals(expectedSub, calculator.sub(input1, input2));
    }

    @Test
    public void testMul() {
        CalculatorImpl calculator = new CalculatorImpl();
        assertEquals(expectedMul, calculator.mul(input1, input2));
    }

    @Test
    public void testDiv() {
        CalculatorImpl calculator = new CalculatorImpl();
        assertEquals(expectedDiv, calculator.div(input1, input2));
    }

    @Test
    public void testCalculatorClassName() {
        CalculatorImpl calculator = new CalculatorImpl();
        assertThat(calculator.getClass().getSimpleName(), startsWith("CalculatorImpl"));
    }
}
