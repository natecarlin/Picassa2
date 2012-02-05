package Expressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.RGBColor;

/**
 * NumExpression represents a greyscale color
 * 
 * @author ntc2
 * 
 */

public class NumExpression extends Expression {

	private static final Pattern DOUBLE_REGEX = Pattern
			.compile("(\\-?[0-9]+(\\.[0-9]+)?)|(\\.[0-9]+)");
	RGBColor myValue;

	public NumExpression(RGBColor value) {
		myValue = value;
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		return myValue;
	}
	
	@Override
	public boolean isVariable(){
		return false;
	}

	public static class NumFactory extends ExpressionFactory {
	

		@Override
		public boolean isThisThing(String input) {
			Matcher doubleMatcher = DOUBLE_REGEX.matcher(input);
			return doubleMatcher.lookingAt();
		}

		@Override
		public Expression parseExpression(String input) {
			double value = Double.parseDouble(input);
			RGBColor gray = new RGBColor(value);
			return new NumExpression(gray);
		}

	}

}
