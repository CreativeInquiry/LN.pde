// Generated by Haxe 4.1.3
package ln;

import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class Hit extends haxe.lang.HxObject
{
	public Hit(haxe.lang.EmptyObject empty)
	{
	}
	
	
	public Hit(ln.Shape _Shape, java.lang.Object _T)
	{
		//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
		ln.Hit.__hx_ctor_ln_Hit(this, _Shape, _T);
	}
	
	
	protected static void __hx_ctor_ln_Hit(ln.Hit __hx_this, ln.Shape _Shape, java.lang.Object _T)
	{
		//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
		__hx_this.T = 0.0;
		//line 7 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
		__hx_this.Shape = null;
		//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
		{
			//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
			double _T1 = ( (haxe.lang.Runtime.eq(_T, null)) ? (0.0) : (((double) (haxe.lang.Runtime.toDouble(_T)) )) );
			//line 10 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
			__hx_this.Shape = _Shape;
			//line 11 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
			__hx_this.T = _T1;
		}
		
	}
	
	
	public ln.Shape Shape;
	
	public double T;
	
	public ln.Hit _clone()
	{
		//line 14 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
		return new ln.Hit(this.Shape, this.T);
	}
	
	
	public boolean Ok()
	{
		//line 17 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
		ln.Hit hit = this._clone();
		//line 18 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
		return ( hit.T < ln.Ln.INF );
	}
	
	
	public ln.Hit Min(ln.Hit b)
	{
		//line 21 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
		ln.Hit a = this._clone();
		//line 22 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
		if (( a.T <= b.T )) 
		{
			//line 23 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
			return a;
		}
		
		//line 25 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
		return b;
	}
	
	
	public ln.Hit Max(ln.Hit b)
	{
		//line 28 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
		ln.Hit a = this._clone();
		//line 29 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
		if (( a.T > b.T )) 
		{
			//line 30 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
			return a;
		}
		
		//line 32 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
		return b;
	}
	
	
	@Override public double __hx_setField_f(java.lang.String field, double value, boolean handleProperties)
	{
		//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
		{
			//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
			boolean __temp_executeDef1 = true;
			//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
			if (( field != null )) 
			{
				//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
				switch (field.hashCode())
				{
					case 84:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
						if (field.equals("T")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
							this.T = ((double) (value) );
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
							return value;
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
			if (__temp_executeDef1) 
			{
				//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
				return super.__hx_setField_f(field, value, handleProperties);
			}
			else
			{
				//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_setField(java.lang.String field, java.lang.Object value, boolean handleProperties)
	{
		//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
		{
			//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
			boolean __temp_executeDef1 = true;
			//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
			if (( field != null )) 
			{
				//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
				switch (field.hashCode())
				{
					case 84:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
						if (field.equals("T")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
							this.T = ((double) (haxe.lang.Runtime.toDouble(value)) );
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
							return value;
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
						break;
					}
					
					
					case 79847297:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
						if (field.equals("Shape")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
							this.Shape = ((ln.Shape) (value) );
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
							return value;
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
			if (__temp_executeDef1) 
			{
				//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
				return super.__hx_setField(field, value, handleProperties);
			}
			else
			{
				//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_getField(java.lang.String field, boolean throwErrors, boolean isCheck, boolean handleProperties)
	{
		//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
		{
			//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
			boolean __temp_executeDef1 = true;
			//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
			if (( field != null )) 
			{
				//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
				switch (field.hashCode())
				{
					case 77124:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
						if (field.equals("Max")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "Max")) );
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
						break;
					}
					
					
					case 79847297:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
						if (field.equals("Shape")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
							return this.Shape;
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
						break;
					}
					
					
					case 77362:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
						if (field.equals("Min")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "Min")) );
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
						break;
					}
					
					
					case 84:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
						if (field.equals("T")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
							return this.T;
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
						break;
					}
					
					
					case 2556:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
						if (field.equals("Ok")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "Ok")) );
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
						break;
					}
					
					
					case -1480441762:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
						if (field.equals("_clone")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "_clone")) );
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
			if (__temp_executeDef1) 
			{
				//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
				return super.__hx_getField(field, throwErrors, isCheck, handleProperties);
			}
			else
			{
				//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public double __hx_getField_f(java.lang.String field, boolean throwErrors, boolean handleProperties)
	{
		//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
		{
			//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
			boolean __temp_executeDef1 = true;
			//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
			if (( field != null )) 
			{
				//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
				switch (field.hashCode())
				{
					case 84:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
						if (field.equals("T")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
							return this.T;
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
			if (__temp_executeDef1) 
			{
				//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
				return super.__hx_getField_f(field, throwErrors, handleProperties);
			}
			else
			{
				//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_invokeField(java.lang.String field, java.lang.Object[] dynargs)
	{
		//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
		{
			//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
			boolean __temp_executeDef1 = true;
			//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
			if (( field != null )) 
			{
				//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
				switch (field.hashCode())
				{
					case 77124:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
						if (field.equals("Max")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
							return this.Max(((ln.Hit) (dynargs[0]) ));
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
						break;
					}
					
					
					case -1480441762:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
						if (field.equals("_clone")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
							return this._clone();
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
						break;
					}
					
					
					case 77362:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
						if (field.equals("Min")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
							return this.Min(((ln.Hit) (dynargs[0]) ));
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
						break;
					}
					
					
					case 2556:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
						if (field.equals("Ok")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
							return this.Ok();
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
			if (__temp_executeDef1) 
			{
				//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
				return super.__hx_invokeField(field, dynargs);
			}
			else
			{
				//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
		baseArr.push("T");
		//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
		baseArr.push("Shape");
		//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Hit.hx"
		super.__hx_getFields(baseArr);
	}
	
	
}


