package EQSD.Calculator;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase
{
	Calculator calculator = new Calculator();
	public void testDivision()
	{
		String str="2,4,/";
		
		assertEquals("0.5", calculator.calculatePostfix(str));
	}
	public void testAddition()
	{
		String str="2,4,+";
		
		assertEquals("6.0", calculator.calculatePostfix(str));
	}
	public void testMultiplication()
	{
		String str="2,4,*";
		
		assertEquals("8.0", calculator.calculatePostfix(str));
	}
	public void testSubstraction()
	{
		String str="2,4,-";
	
		assertEquals("-2.0", calculator.calculatePostfix(str));
	}
	public void testSingle()
	{
		String str="2";
		
		assertEquals("2.0", calculator.calculatePostfix(str));
	}
	
	public void testOneopError()
	{
		String str="+";
		
		assertEquals("Error", calculator.calculatePostfix(str));
	}

	public void testNoneopError()
	{
		String str="2,3,a";
		
		assertEquals("Error", calculator.calculatePostfix(str));
	}
	
	public void testNoInput()
	{
		String str=null;
		
		assertEquals("Error", calculator.calculatePostfix(str));
	}
	public void testPower()
	{
		String str="3,2,^";
		//System.out.println(calculator.calculatePostfix(str));
		assertEquals("9.0", calculator.calculatePostfix(str));
	}
	public void testFactorial()
	{
		String str="3,!";
		//System.out.println(calculator.calculatePostfix(str));
		assertEquals("6.0", calculator.calculatePostfix(str));
	}
	public void testInvalidExpression()
	{
		String str="3,1,2,+";
		//System.out.println(calculator.calculatePostfix(str));
		assertEquals("Error", calculator.calculatePostfix(str));
	}
	public void testInvalidRandomString()
	{
		String str="kfngvlkhwpajmpocf oi";
		assertEquals("Error", calculator.calculatePostfix(str));
	}
	public void testZeroDivisionByZero()
	{
		String str="0,0,/";
		assertEquals("NaN", calculator.calculatePostfix(str));
	}
	public void testOneDivisionByZero()
	{
		String str="1,0,/";
		assertEquals("Infinity", calculator.calculatePostfix(str));
	}
	public void testInvalidStringManyComma()
	{
		String str="3,3,,,";
		assertEquals("Error", calculator.calculatePostfix(str));
	}
	public void testInvalidStringNoComma()
	{
		String str="3213+";
		assertEquals("Error", calculator.calculatePostfix(str));
	}
	public void testMultipleOperators()
	{
		String str = "3,4,-,5,-";
		assertEquals("-6.0",calculator.calculatePostfix(str));
	}
}
