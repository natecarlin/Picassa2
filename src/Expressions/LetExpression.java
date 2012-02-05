package Expressions;

import java.util.List;

import model.Parser;
import model.ParserException;
import model.RGBColor;

public class LetExpression extends CommandExpression {
	static final String myCommand = "let";

	public LetExpression(List<Expression> operands) {
		super(operands);
	}

	@Override
	public boolean correctParams() {
		return (myExpressions.size() == 3);
	}

	@Override
	public RGBColor operate(double x, double y) {
		Expression variable = myExpressions.get(0);
		Expression assignment = myExpressions.get(1);
		if(!variable.isVariable()){
			throw new ParserException("first argument must be a variable");
		}
		Parser.VarMap2.setmap(variable.toString(), assignment);
		return myExpressions.get(2).evaluate(x, y);
	}

	public static class LetFactory extends CommandFactory {
		@Override
		public boolean isThisThing(String input) {
			return (findName(input).equals(myCommand));
		}

		public Expression parseExpression(String input) {
			return new LetExpression(this.findOperands(input));
		}
	}
}
