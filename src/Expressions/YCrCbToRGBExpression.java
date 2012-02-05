package Expressions;

import java.util.List;

import model.RGBColor;
import model.util.ColorModel;

public class YCrCbToRGBExpression extends CommandExpression{
	final static String myCommand = "yCrCbtoRGB";

	YCrCbToRGBExpression(List<Expression> operands) {
		super(operands);
	}

	@Override
	public boolean correctParams() {
		return (myExpressions.size() == 1);
	}

	@Override
	public RGBColor operate(double x, double y) {
		RGBColor input = myExpressions.get(0).evaluate(x, y);
		return ColorModel.ycrcb2rgb(input);
	}
	
	public static class YCrCbToRGBFactory extends CommandFactory{

		@Override
		public boolean isThisThing(String input) {
			return (findName(input).equals(myCommand));
		}

		@Override
		public Expression parseExpression(String input) {
			return new YCrCbToRGBExpression(this.findOperands(input));
		}
		
	}

}
