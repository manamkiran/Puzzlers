import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CalculatorTest {
    enum Type {SUBSTRACT, ADD};
    @Parameters(name="{0}{index}")
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][] {
          {Type.SUBSTRACT, 3.0, 2.0, 1.0},
          {Type.ADD, 23.0, 5.0, 28.0}
        });
    }

    private Type type;
    private Double a, b, expected;

    public CalculatorTest(Type type, Double a, Double b, Double expected){
        this.type = type;
        this.a=a; this.b=b; this.expected=expected;
    }

    @Test
    public void testAdd(){
        Assume.assumeTrue(type == Type.ADD);
        Assert.assertEquals(expected, (a+b),0);
    }

    @Test
    public void testSubstract(){
        Assume.assumeTrue(type == Type.SUBSTRACT);
        Assert.assertEquals(expected, (a-b),0);
    }
}