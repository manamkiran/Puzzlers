package puzzlers;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class NineStonesBagsTest {
	
	int[] input;
	String expectedOutput;
	
	public NineStonesBagsTest(String inp,int[] input,String expectedOutput ) {
		this.input = input;
		this.expectedOutput = expectedOutput;
	}

	
	@Parameters(name="{0}FaultBagIs{index}")
	public static Collection ligherInputs() {
		return Arrays.asList(createInputList());
	}


	private static Object[] createInputList() {
		int numberOfInputs = 18;
		Object[][] inputs = new Object[numberOfInputs][];
		for(int i=0 ; i< numberOfInputs/2; i++ )
		{
			inputs[i] = generateLighterInput(i);
		}
		for(int i=numberOfInputs/2 ; i< numberOfInputs; i++ )
		{
			inputs[i] = generateHeavierInput(i-numberOfInputs/2);
		}
		return inputs;
	
	}



	private static Object[] generateHeavierInput(int i) {
		int []input = new int[]{10,10,10,10,10,10,10,10,10};
		input[i]=11;
		String expectedOutput = (i)+"\r\n" + "3\r\n";
		expectedOutput+="Stone is heavier\r\n";
		return new Object[]{"Heavier",input,expectedOutput};
	}

	
	private static Object[] generateLighterInput(int i) {
		int []input = new int[]{10,10,10,10,10,10,10,10,10};
		input[i]=9;
		String expectedOutput = (i)+"\r\n" + "3\r\n";
		expectedOutput+="Stone is lighter\r\n";
		return new Object[]{"Lighter",input,expectedOutput};
	}


	@Test
	public void findInCorrectBag()
	{
		NineStonesBags nineBags = new NineStonesBags();
		nineBags.setInput(input);
		final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(myOut));
		nineBags.solve();
		final String standardOutput = myOut.toString();
		Assert.assertEquals(expectedOutput, standardOutput);

	}
}
