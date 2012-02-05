package Expressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Parser;
import model.ParserException;
import model.RGBColor;

public class VarExpression extends Expression{
	String myVar;
	private static final Pattern VAR_REGEX = Pattern.compile("[a-z]+");
	
	VarExpression(String input){
		myVar = input;
	}
	
	@Override
	public boolean isVariable(){
		return true;
	}
	
	public String toString(){
		return myVar;
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		Expression hopeful = Parser.VarMap2.getexp(myVar);
		if(hopeful != null){
			return hopeful.evaluate(x, y);
		}
		else throw new ParserException("unassigned variable");
	}
	
	public static class VarFactory extends ExpressionFactory{

		@Override
		public boolean isThisThing(String input) {
			Matcher varMatcher = VAR_REGEX.matcher(input);
			return varMatcher.lookingAt();
		}

		@Override
		public Expression parseExpression(String input) {
			return new VarExpression(input);
		}
		
	}

}
