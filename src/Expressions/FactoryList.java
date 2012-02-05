package Expressions;

import java.util.ArrayList;
import java.util.List;


/**
 * ExpressionList represents a storage place for all types of Expressions.
 * constituents of the list are not functional Expressions.
 * @author ntc2
 *
 */

public class FactoryList {
	private List <ExpressionFactory> myList;
	
	public FactoryList(){
		myList = new ArrayList <ExpressionFactory>();
		myList.add(new AxisExpression.AxisFactory());
		myList.add(new VarExpression.VarFactory());
		myList.add(new NumExpression.NumFactory());
		myList.add(new AddExpression.AddFactory());
		myList.add(new ColorExpression.ColorFactory());
		myList.add(new DivExpression.DivFactory());
		myList.add(new ExponentExpression.ExpFactory());
		myList.add(new ModExpression.ModFactory());
		myList.add(new MultExpression.MultFactory());
		myList.add(new NegExpression.NegFactory());
		myList.add(new SubExpression.SubFactory());	
		myList.add(new RandExpression.RandomFactory());
		myList.add(new FloorExpression.FloorFactory());
		myList.add(new CeilingExpression.CeilingFactory());
		myList.add(new AbsExpression.AbsFactory());
		myList.add(new ClampExpression.ClampFactory());
		myList.add(new WrapExpression.WrapFactory());
		myList.add(new SinExpression.SinFactory());
		myList.add(new CosExpression.CosFactory());
		myList.add(new TanExpression.TanFactory());
		myList.add(new ArctanExpression.ArctanFactory());
		myList.add(new LogExpression.LogFactory());
		myList.add(new RgbToYCrCbExpression.RgbToYCrCbFactory());
		myList.add(new YCrCbToRGBExpression.YCrCbToRGBFactory());
		myList.add(new PerlinColorExpression.PerlinColorFactory());
		myList.add(new PerlinColorExpression.PerlinColorFactory());
		myList.add(new LetExpression.LetFactory());
	}
	
	public  List<ExpressionFactory> getList(){
		return myList;
	}

}
