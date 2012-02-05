package Expressions;
import model.RGBColor;

/**
 * An Expression represents a mathematical expression as a tree.
 * 
 * In this format, the internal nodes represent mathematical 
 * functions and the leaves represent constant values.
 *
 * @author former student solution
 * @author Robert C. Duvall (added comments, some code)
 */
public abstract class Expression
{ 
	
    public abstract RGBColor evaluate (double x, double y);
    
    public abstract boolean isVariable();
    
}
