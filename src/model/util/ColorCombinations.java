package model.util;

import model.RGBColor;


/**
 * Combine two colors by combining their components.
 * 
 * This is a separate class from color since it is just one set of
 * ways to combine colors, many may exist and we do not want to keep
 * modifying the RGBColor class.
 * 
 * @author Robert C. Duvall
 */
public class ColorCombinations
{
    /**
     * Combine two colors by adding their components.
     */
    public static RGBColor add (RGBColor left, RGBColor right)
    {
        return new RGBColor(left.getRed() + right.getRed(), 
                            left.getGreen() + right.getGreen(),
                            left.getBlue() + right.getBlue());
    }
    
    public static RGBColor mod(RGBColor left, RGBColor right)
    {
    	return new RGBColor(left.getRed()%right.getRed(),
    			left.getGreen() % right.getGreen(),
                left.getBlue() % right.getBlue());
    }
    public static RGBColor exp(RGBColor left, RGBColor right)
    {
    	return new RGBColor(Math.pow(left.getRed(),right.getRed()),
    			Math.pow(left.getGreen() ,right.getGreen()),
                Math.pow(left.getBlue() , right.getBlue()));
    }
    
    public static RGBColor neg(RGBColor left)
    {
    	return new RGBColor(-left.getRed(), -left.getGreen(),-left.getBlue());
    }
    
    public static RGBColor color(RGBColor first, RGBColor second, RGBColor third){
    	return new RGBColor(first.getRed(),second.getGreen(),third.getBlue());
    }

    /**
     * Combine two colors by subtracting their components.
     */
    public static RGBColor subtract (RGBColor left, RGBColor right)
    {
        return new RGBColor(left.getRed() - right.getRed(), 
                            left.getGreen() - right.getGreen(),
                            left.getBlue() - right.getBlue());
    }

    /**
     * Combine two colors by multiplying their components.
     */
    public static RGBColor multiply (RGBColor left, RGBColor right)
    {
        return new RGBColor(left.getRed() * right.getRed(), 
                            left.getGreen() * right.getGreen(),
                            left.getBlue() * right.getBlue());
    }

    /**
     * Combine two colors by dividing their components.
     */
    public static RGBColor divide (RGBColor left, RGBColor right)
    {
        return new RGBColor(left.getRed() / right.getRed(), 
                            left.getGreen() / right.getGreen(),
                            left.getBlue() / right.getBlue());
    }
}
