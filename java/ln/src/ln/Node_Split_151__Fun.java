// Generated by Haxe 4.1.3
package ln;

import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class Node_Split_151__Fun extends haxe.lang.Function
{
	public Node_Split_151__Fun()
	{
		//line 151 "/Users/lingdonghuang/proj/LN.pde/ln/Node.hx"
		super(2, 1);
	}
	
	
	public static ln.Node_Split_151__Fun __hx_current;
	
	@Override public double __hx_invoke2_f(double __fn_float1, java.lang.Object __fn_dyn1, double __fn_float2, java.lang.Object __fn_dyn2)
	{
		//line 151 "/Users/lingdonghuang/proj/LN.pde/ln/Node.hx"
		double b = ( (( __fn_dyn2 == haxe.lang.Runtime.undefined )) ? (((double) (__fn_float2) )) : (((double) (haxe.lang.Runtime.toDouble(__fn_dyn2)) )) );
		//line 151 "/Users/lingdonghuang/proj/LN.pde/ln/Node.hx"
		double a = ( (( __fn_dyn1 == haxe.lang.Runtime.undefined )) ? (((double) (__fn_float1) )) : (((double) (haxe.lang.Runtime.toDouble(__fn_dyn1)) )) );
		//line 151 "/Users/lingdonghuang/proj/LN.pde/ln/Node.hx"
		if (( a < b )) 
		{
			//line 151 "/Users/lingdonghuang/proj/LN.pde/ln/Node.hx"
			return ((double) (-1) );
		}
		else
		{
			//line 151 "/Users/lingdonghuang/proj/LN.pde/ln/Node.hx"
			if (( a > b )) 
			{
				//line 151 "/Users/lingdonghuang/proj/LN.pde/ln/Node.hx"
				return ((double) (1) );
			}
			else
			{
				//line 151 "/Users/lingdonghuang/proj/LN.pde/ln/Node.hx"
				return ((double) (0) );
			}
			
		}
		
	}
	
	
}


