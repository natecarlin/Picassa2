package Expressions;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Parser;
import model.ParserException;
import model.RGBColor;

/**
 * CommandExpression represents a type of expression that requires a command,
 * and then subsequent constituent expressions
 * 
 * @author ntc2
 * 
 */

public abstract class CommandExpression extends Expression {
	List<Expression> myExpressions;
	private static final Pattern EXPRESSION_BEGIN_REGEX = Pattern
			.compile("\\(([a-z]+)");

	CommandExpression(List<Expression> operands) {
		myExpressions = operands;
	}

	public abstract boolean correctParams();
	
	@Override
	public boolean isVariable(){
		return false;
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		if (this.correctParams()) {
			return this.operate(x, y);
		} else
			throw new ParserException(
					"Incorrect number of parameters for command");
	}

	public abstract RGBColor operate(double x, double y);

	public static abstract class CommandFactory extends ExpressionFactory {

		public String findName(String input) {
			Matcher expMatcher = EXPRESSION_BEGIN_REGEX.matcher(input);
			if (expMatcher.lookingAt()) {
				int currentposition = 0;
				expMatcher.find(currentposition);
				String commandName = expMatcher.group(1);
				return commandName;
			}
			return "";
		}
		
		public List<Expression> findOperands(String input) {
			int end = 0;
			Matcher expMatcher = EXPRESSION_BEGIN_REGEX.matcher(input);
			expMatcher.find(end);
			end = expMatcher.end();
			List<Expression> expressions = new ArrayList<Expression>();

			if (input.charAt(input.length() - 1) != ')') {
				throw new ParserException("expected a ')', found none");
			} else
				input = input.substring(end, input.length() - 1);

			int currentposition = 0;

			while (currentposition < input.length()) {
				while (input.charAt(currentposition) == ' '
						&& currentposition < input.length() - 1)
					currentposition++;
				if (input.charAt(currentposition) == '(') {
					int endparen = findMatchingParen(input
							.substring(currentposition));
					if (endparen + currentposition == input.length() - 1) {
						expressions.add(Parser.makeExpression(input
								.substring(currentposition)));
					} else {
						expressions.add(Parser.makeExpression(input
								.substring(currentposition, currentposition
										+ endparen + 1)));
					}
					currentposition = currentposition + endparen + 1;
				}

				else {
					int nextspace = currentposition;
					if (input.indexOf(' ', currentposition) == -1) {
						expressions.add(Parser.makeExpression(input
								.substring(currentposition)));
						break;
					} else {
						nextspace = input.indexOf(' ', currentposition);
						expressions.add(Parser.makeExpression(input.substring(
								currentposition, nextspace)));
						currentposition = nextspace;
					}
				}
			}
			return expressions;

		}

		// first character should always be parentheses
		public int findMatchingParen(String input) {
			int parencount = 0;
			char[] inputarray = input.toCharArray();

			int index = -1;
			for (int i = 0; i < inputarray.length; i++) {
				if (inputarray[i] == '(')
					parencount++;
				if (inputarray[i] == ')')
					parencount--;
				if (parencount == 0) {
					index = i;
					return index;
				}
			}
			throw new ParserException("incorrect number of parentheses");
		}
	}

}
