
import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

public class TestRomanCalculator {

	@Test
	public void testRomanCalculatorCalculate() {
		String expr1 = RomanCalculator.calculate("I+IV+VII+IV*III");
		String expr2 = RomanCalculator.calculate("(I+IV)+VII+IV*III");
		String expr3 = RomanCalculator.calculate("I+IV+VII+(IV*III)/II");
		String expr4 = RomanCalculator.calculate("I+IV+VII+((IV*III)*II)/II");
		
		assertEquals("24", expr1);
		assertEquals("24", expr2);
		assertEquals("18", expr3);
		assertEquals("24", expr4);
	}
	
	@Test
	public void testRomanConversionRomanToArab() {
		int roman1 = RomanConversion.RomanToArab("V");
		int roman2 = RomanConversion.RomanToArab("MMM");	
		int roman3 = RomanConversion.RomanToArab("XXXIX");	
		int roman4 = RomanConversion.RomanToArab("XXI");	
		int roman5 = RomanConversion.RomanToArab("MCD");	
		int roman6 = RomanConversion.RomanToArab("CDIX");	
		
		assertEquals(5, roman1);
		assertEquals(3000, roman2);
		assertEquals(39, roman3);
		assertEquals(21, roman4);
		assertEquals(1400, roman5);
		assertEquals(409, roman6);
		
	}
	
	@Test
	public void testRomanConversionValidateRoman() {
		Boolean val1 = RomanConversion.ValidateRoman("MM");
		Boolean val2 = RomanConversion.ValidateRoman("MMMM");
		Boolean val3 = RomanConversion.ValidateRoman("IVV");
		Boolean val4 = RomanConversion.ValidateRoman("XXXIX");
		Boolean val5 = RomanConversion.ValidateRoman("IXC");
		Boolean val6 = RomanConversion.ValidateRoman("XXCX");
				
		assertEquals(true, val1);
		assertEquals(false, val2);
		assertEquals(false, val3);
		assertEquals(true, val4);
		assertEquals(false, val5);
		assertEquals(false, val6);
		
	}	
	
	@Test
	public void testCalculate2() {
		MyClass mockedObject = Mockito.spy(new MyClass());
		Mockito.when(mockedObject.Get()).thenReturn(9999);
		
		int actual = mockedObject.Get();
		
		assertEquals(9999, actual);
	}
	

}
