package Expressions;
/**
 * represents a Factory to identify and parse expressions.
 * implemented in Expression
 * @author ntc2
 *
 */

public abstract class ExpressionFactory {
	
	
	public abstract Expression parseExpression(String input);
	
	public abstract boolean isThisThing(String input);
}
