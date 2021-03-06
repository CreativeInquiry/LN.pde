// Generated by Haxe 4.1.3
package ln;

import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class ClipFilter extends haxe.lang.HxObject implements ln.Filter
{
	public ClipFilter(haxe.lang.EmptyObject empty)
	{
	}
	
	
	public ClipFilter(ln.Matrix _Matrix, ln.Vector _Eye, ln.Scene _Scene)
	{
		//line 13 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
		ln.ClipFilter.__hx_ctor_ln_ClipFilter(this, _Matrix, _Eye, _Scene);
	}
	
	
	protected static void __hx_ctor_ln_ClipFilter(ln.ClipFilter __hx_this, ln.Matrix _Matrix, ln.Vector _Eye, ln.Scene _Scene)
	{
		//line 12 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
		__hx_this.Scene = null;
		//line 11 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
		__hx_this.Eye = null;
		//line 10 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
		__hx_this.Matrix = null;
		//line 13 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
		{
			//line 14 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
			__hx_this.Matrix = _Matrix;
			//line 15 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
			__hx_this.Eye = _Eye;
			//line 16 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
			__hx_this.Scene = _Scene;
		}
		
	}
	
	
	public ln.Matrix Matrix;
	
	public ln.Vector Eye;
	
	public ln.Scene Scene;
	
	public ln.ClipFilter _clone()
	{
		//line 19 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
		return new ln.ClipFilter(this.Matrix, this.Eye, this.Scene);
	}
	
	
	public ln.FilterResult Filter(ln.Vector v)
	{
		//line 22 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
		ln.ClipFilter f = this;
		//line 23 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
		ln.Vector w = f.Matrix.MulPositionW(v);
		//line 24 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
		if ( ! (f.Scene.Visible(f.Eye, v)) ) 
		{
			//line 25 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
			return new ln.FilterResult(w, false);
		}
		
		//line 27 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
		if ( ! (ln.Ln.ClipBox.Contains(w)) ) 
		{
			//line 28 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
			return new ln.FilterResult(w, false);
		}
		
		//line 30 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
		return new ln.FilterResult(w, true);
	}
	
	
	@Override public java.lang.Object __hx_setField(java.lang.String field, java.lang.Object value, boolean handleProperties)
	{
		//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
		{
			//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
			boolean __temp_executeDef1 = true;
			//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
			if (( field != null )) 
			{
				//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
				switch (field.hashCode())
				{
					case 79702124:
					{
						//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
						if (field.equals("Scene")) 
						{
							//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
							__temp_executeDef1 = false;
							//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
							this.Scene = ((ln.Scene) (value) );
							//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
							return value;
						}
						
						//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
						break;
					}
					
					
					case -1997372447:
					{
						//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
						if (field.equals("Matrix")) 
						{
							//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
							__temp_executeDef1 = false;
							//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
							this.Matrix = ((ln.Matrix) (value) );
							//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
							return value;
						}
						
						//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
						break;
					}
					
					
					case 70161:
					{
						//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
						if (field.equals("Eye")) 
						{
							//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
							__temp_executeDef1 = false;
							//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
							this.Eye = ((ln.Vector) (value) );
							//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
							return value;
						}
						
						//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
			if (__temp_executeDef1) 
			{
				//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
				return super.__hx_setField(field, value, handleProperties);
			}
			else
			{
				//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_getField(java.lang.String field, boolean throwErrors, boolean isCheck, boolean handleProperties)
	{
		//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
		{
			//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
			boolean __temp_executeDef1 = true;
			//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
			if (( field != null )) 
			{
				//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
				switch (field.hashCode())
				{
					case 2104342424:
					{
						//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
						if (field.equals("Filter")) 
						{
							//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
							__temp_executeDef1 = false;
							//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "Filter")) );
						}
						
						//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
						break;
					}
					
					
					case -1997372447:
					{
						//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
						if (field.equals("Matrix")) 
						{
							//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
							__temp_executeDef1 = false;
							//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
							return this.Matrix;
						}
						
						//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
						break;
					}
					
					
					case -1480441762:
					{
						//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
						if (field.equals("_clone")) 
						{
							//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
							__temp_executeDef1 = false;
							//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "_clone")) );
						}
						
						//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
						break;
					}
					
					
					case 70161:
					{
						//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
						if (field.equals("Eye")) 
						{
							//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
							__temp_executeDef1 = false;
							//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
							return this.Eye;
						}
						
						//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
						break;
					}
					
					
					case 79702124:
					{
						//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
						if (field.equals("Scene")) 
						{
							//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
							__temp_executeDef1 = false;
							//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
							return this.Scene;
						}
						
						//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
			if (__temp_executeDef1) 
			{
				//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
				return super.__hx_getField(field, throwErrors, isCheck, handleProperties);
			}
			else
			{
				//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_invokeField(java.lang.String field, java.lang.Object[] dynargs)
	{
		//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
		{
			//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
			boolean __temp_executeDef1 = true;
			//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
			if (( field != null )) 
			{
				//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
				switch (field.hashCode())
				{
					case 2104342424:
					{
						//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
						if (field.equals("Filter")) 
						{
							//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
							__temp_executeDef1 = false;
							//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
							return this.Filter(((ln.Vector) (dynargs[0]) ));
						}
						
						//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
						break;
					}
					
					
					case -1480441762:
					{
						//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
						if (field.equals("_clone")) 
						{
							//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
							__temp_executeDef1 = false;
							//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
							return this._clone();
						}
						
						//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
			if (__temp_executeDef1) 
			{
				//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
				return super.__hx_invokeField(field, dynargs);
			}
			else
			{
				//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
		baseArr.push("Scene");
		//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
		baseArr.push("Eye");
		//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
		baseArr.push("Matrix");
		//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/ClipFilter.hx"
		super.__hx_getFields(baseArr);
	}
	
	
}


