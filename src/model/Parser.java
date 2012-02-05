package model;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import Expressions.ExpressionFactory;
import Expressions.FactoryList;
import Expressions.Expression;

/**
 * Parses a string into an expression tree based on rules for arithmetic.
 * 
 * Due to the nature of the language being parsed, a recursive descent parser is
 * used http://en.wikipedia.org/wiki/Recursive_descent_parser
 * 
 * @author former student solution
 * @author Robert C. Duvall (added comments, exceptions, some functions)
 */
public class Parser {

	/**
	 * Converts given string into expression tree.
	 * 
	 * @param input
	 *            expression given in the language to be parsed
	 * @return expression tree representing the given formula
	 */
	public static Expression makeExpression(String input) {

		FactoryList explist = new FactoryList();
		List<ExpressionFactory> checker = explist.getList();
		for (ExpressionFactory exp : checker) {
			if (exp.isThisThing(input)) {
				return exp.parseExpression(input);
			}
		}
		throw new ParserException(
				"could not find an expression to match the input");
	}
	
	public static class VarMap2{
		public static Map<String, Expression> myMap = new TreeMap<String,Expression>();
		
		public static void setmap(String name, Expression expression){
				myMap.put(name, expression);
			}
		
		public static void clearmap(){
			myMap.clear();
		}
		
		public static Expression getexp(String name){
			if(myMap.containsKey(name)){
				return myMap.get(name);
			}
			else return null;
		}
	}
}
