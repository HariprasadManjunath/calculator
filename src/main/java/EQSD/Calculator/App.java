package EQSD.Calculator;

public class App 
{
    public static void main( String[] args )
    {
    	String result;
        Calculator c = new Calculator();
        result = c.calculatePostfix("1,2,+");
        System.out.println(result);
    }
}
