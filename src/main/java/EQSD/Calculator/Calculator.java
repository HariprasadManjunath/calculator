package EQSD.Calculator;

import java.util.Stack;

public class Calculator {

	public int errodID = 0;
	public String calculatePostfix(String str) {
		if(str == null) return "Error";
		String[] splittedStr = str.split(",");
		Token token = new Token();
		Stack<Float> stack = new Stack<Float>();
		float op1, op2;
		
		int length  = splittedStr.length; 
		
		for(int i = 0; i<length ; i++){
			
			token.setStr(splittedStr[i]);
			try {
				
				if(token.isOperand()){
					stack.push(token.value);
				}
				
				else if(token.operatorType()==1){
					op1 = stack.pop();
					stack.push(eval(op1, token.str));
					if(errodID > 0){
						return "Error";
					}
				}
				else if(token.operatorType()==2){
					op1 = stack.pop();
					op2 = stack.pop();
					
					if(errodID > 0){
						return "Error";
					}
					stack.push(eval(op2,op1, token.str));
					
				}
				else {
					return "Error";
				}
				
			} catch (Exception e) {
				
				return "Error";
			}
		
			
		}
		if(stack.size()!=1){
			return "Error";
		}
		return Float.toString(stack.pop());
	}

	private Float eval(Float op, String str) {
		try {
			switch (str) {
			case "!": 
				return factorial(op);
				
			case "%": 
				return op/100;	

			default:
				return null;
			}
		} catch (Exception e) {
			errodID = 1;
			return (float) 0.0;
		}
		
	}

	private Float factorial(Float op) {
		try {
			if ((Math.ceil(op)-op > 0) && (op < 0)){
				return null;
			}
			else {
				float result =1;
				while(op > 0){
					result *= op;
					op--;
				}
				return result;
			}
		} catch (Exception e) {
			errodID  = 1;
			return (float) 0.0;
		}
		
	}

	private float eval(Float op1, Float op2, String str) {
		try {
			switch (str) {
			case "+":
				return op1 + op2;
			case "-":
				return op1 - op2;
			case "*":
				return op1 * op2;
			case "/":
				return op1 / op2;
			case "^":
				return (float) Math.pow(op1,op2);
			default:
				return (Float) null;
			}
		} catch (Exception e) {
			errodID  = 1;
			return (float) 0.0;
		}
		
		
	}

}


class Token{
	String str;
	float value;
		
	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public int operatorType(){
		switch (str) {
		case "+":
		case "-":
		case "*":
		case "/":
		case "^":	
			return 2;
		case "!":
		case "%":
			
			return 1;	

		default:
			return 0;
		}
	}
	
	public Boolean isOperand(){
		try {
			value = Float.parseFloat(str);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	
}