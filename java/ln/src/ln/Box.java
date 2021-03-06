// Generated by Haxe 4.1.3
package ln;

import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class Box extends haxe.lang.HxObject
{
	public Box(haxe.lang.EmptyObject empty)
	{
	}
	
	
	public Box(ln.Vector _Min, ln.Vector _Max)
	{
		//line 11 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
		ln.Box.__hx_ctor_ln_Box(this, _Min, _Max);
	}
	
	
	protected static void __hx_ctor_ln_Box(ln.Box __hx_this, ln.Vector _Min, ln.Vector _Max)
	{
		//line 10 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
		__hx_this.Max = null;
		//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
		__hx_this.Min = null;
		//line 11 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
		{
			//line 12 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
			__hx_this.Min = _Min;
			//line 13 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
			__hx_this.Max = _Max;
		}
		
	}
	
	
	public ln.Vector Min;
	
	public ln.Vector Max;
	
	public ln.Box _clone()
	{
		//line 16 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
		return new ln.Box(this.Min, this.Max);
	}
	
	
	public ln.Vector Anchor(ln.Vector anchor)
	{
		//line 19 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
		ln.Box a = this._clone();
		//line 20 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
		return a.Min.Add(a.Size().Mul(anchor));
	}
	
	
	public ln.Vector Center()
	{
		//line 23 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
		ln.Box a = this._clone();
		//line 24 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
		return a.Anchor(new ln.Vector(0.5, 0.5, 0.5));
	}
	
	
	public ln.Vector Size()
	{
		//line 27 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
		ln.Box a = this._clone();
		//line 28 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
		return a.Max.Sub(a.Min);
	}
	
	
	public boolean Contains(ln.Vector b)
	{
		//line 31 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
		ln.Box a = this._clone();
		//line 32 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
		if (( ( ( ( ( a.Min.X <= b.X ) && ( a.Max.X >= b.X ) ) && ( a.Min.Y <= b.Y ) ) && ( a.Max.Y >= b.Y ) ) && ( a.Min.Z <= b.Z ) )) 
		{
			//line 32 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
			return ( a.Max.Z >= b.Z );
		}
		else
		{
			//line 32 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
			return false;
		}
		
	}
	
	
	public ln.Box Extend(ln.Box b)
	{
		//line 35 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
		ln.Box a = this._clone();
		//line 36 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
		return new ln.Box(a.Min.Min(b.Min), a.Max.Max(b.Max));
	}
	
	
	public haxe.root.Array Intersect(ln.Ray r)
	{
		//line 39 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
		ln.Box b = this._clone();
		//line 40 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
		double x1 = ( (( b.Min.X - r.Origin.X )) / r.Direction.X );
		//line 41 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
		double y1 = ( (( b.Min.Y - r.Origin.Y )) / r.Direction.Y );
		//line 42 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
		double z1 = ( (( b.Min.Z - r.Origin.Z )) / r.Direction.Z );
		//line 43 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
		double x2 = ( (( b.Max.X - r.Origin.X )) / r.Direction.X );
		//line 44 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
		double y2 = ( (( b.Max.Y - r.Origin.Y )) / r.Direction.Y );
		//line 45 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
		double z2 = ( (( b.Max.Z - r.Origin.Z )) / r.Direction.Z );
		//line 46 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
		if (( x1 > x2 )) 
		{
			//line 47 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
			double tmp = x1;
			//line 48 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
			x1 = x2;
			//line 49 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
			x2 = tmp;
		}
		
		//line 51 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
		if (( y1 > y2 )) 
		{
			//line 52 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
			double tmp1 = y1;
			//line 53 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
			y1 = y2;
			//line 54 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
			y2 = tmp1;
		}
		
		//line 56 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
		if (( z1 > z2 )) 
		{
			//line 57 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
			double tmp2 = z1;
			//line 58 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
			z1 = z2;
			//line 59 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
			z1 = tmp2;
		}
		
		//line 61 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
		double t1 = java.lang.Math.max(java.lang.Math.max(x1, y1), z1);
		//line 62 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
		double t2 = java.lang.Math.min(java.lang.Math.min(x2, y2), z2);
		//line 63 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
		haxe.root.Array _wqxbl = new haxe.root.Array(new java.lang.Object[]{t1, t2});
		//line 64 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
		return _wqxbl;
	}
	
	
	public haxe.root.Array Partition(int axis, double point)
	{
		//line 67 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
		ln.Box b = this._clone();
		//line 68 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
		boolean left = false;
		//line 69 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
		boolean right = false;
		//line 70 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
		switch (axis)
		{
			case 1:
			{
				//line 72 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
				left = ( b.Min.X <= point );
				//line 73 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
				right = ( b.Max.X >= point );
				//line 71 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
				break;
			}
			
			
			case 2:
			{
				//line 75 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
				left = ( b.Min.Y <= point );
				//line 76 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
				right = ( b.Max.Y >= point );
				//line 74 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
				break;
			}
			
			
			case 3:
			{
				//line 78 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
				left = ( b.Min.Z <= point );
				//line 79 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
				right = ( b.Max.Z >= point );
				//line 77 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
				break;
			}
			
			
		}
		
		//line 81 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
		haxe.root.Array _afudq = new haxe.root.Array(new java.lang.Object[]{left, right});
		//line 82 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
		return _afudq;
	}
	
	
	@Override public java.lang.Object __hx_setField(java.lang.String field, java.lang.Object value, boolean handleProperties)
	{
		//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
		{
			//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
			boolean __temp_executeDef1 = true;
			//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
			if (( field != null )) 
			{
				//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
				switch (field.hashCode())
				{
					case 77124:
					{
						//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
						if (field.equals("Max")) 
						{
							//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
							__temp_executeDef1 = false;
							//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
							this.Max = ((ln.Vector) (value) );
							//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
							return value;
						}
						
						//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
						break;
					}
					
					
					case 77362:
					{
						//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
						if (field.equals("Min")) 
						{
							//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
							__temp_executeDef1 = false;
							//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
							this.Min = ((ln.Vector) (value) );
							//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
							return value;
						}
						
						//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
			if (__temp_executeDef1) 
			{
				//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
				return super.__hx_setField(field, value, handleProperties);
			}
			else
			{
				//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_getField(java.lang.String field, boolean throwErrors, boolean isCheck, boolean handleProperties)
	{
		//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
		{
			//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
			boolean __temp_executeDef1 = true;
			//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
			if (( field != null )) 
			{
				//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
				switch (field.hashCode())
				{
					case 204157642:
					{
						//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
						if (field.equals("Partition")) 
						{
							//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
							__temp_executeDef1 = false;
							//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "Partition")) );
						}
						
						//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
						break;
					}
					
					
					case 77362:
					{
						//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
						if (field.equals("Min")) 
						{
							//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
							__temp_executeDef1 = false;
							//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
							return this.Min;
						}
						
						//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
						break;
					}
					
					
					case -1787984641:
					{
						//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
						if (field.equals("Intersect")) 
						{
							//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
							__temp_executeDef1 = false;
							//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "Intersect")) );
						}
						
						//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
						break;
					}
					
					
					case 77124:
					{
						//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
						if (field.equals("Max")) 
						{
							//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
							__temp_executeDef1 = false;
							//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
							return this.Max;
						}
						
						//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
						break;
					}
					
					
					case 2089790266:
					{
						//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
						if (field.equals("Extend")) 
						{
							//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
							__temp_executeDef1 = false;
							//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "Extend")) );
						}
						
						//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
						break;
					}
					
					
					case -1480441762:
					{
						//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
						if (field.equals("_clone")) 
						{
							//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
							__temp_executeDef1 = false;
							//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "_clone")) );
						}
						
						//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
						break;
					}
					
					
					case -502801857:
					{
						//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
						if (field.equals("Contains")) 
						{
							//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
							__temp_executeDef1 = false;
							//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "Contains")) );
						}
						
						//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
						break;
					}
					
					
					case 1965534933:
					{
						//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
						if (field.equals("Anchor")) 
						{
							//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
							__temp_executeDef1 = false;
							//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "Anchor")) );
						}
						
						//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
						break;
					}
					
					
					case 2577441:
					{
						//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
						if (field.equals("Size")) 
						{
							//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
							__temp_executeDef1 = false;
							//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "Size")) );
						}
						
						//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
						break;
					}
					
					
					case 2014820469:
					{
						//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
						if (field.equals("Center")) 
						{
							//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
							__temp_executeDef1 = false;
							//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "Center")) );
						}
						
						//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
			if (__temp_executeDef1) 
			{
				//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
				return super.__hx_getField(field, throwErrors, isCheck, handleProperties);
			}
			else
			{
				//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_invokeField(java.lang.String field, java.lang.Object[] dynargs)
	{
		//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
		{
			//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
			boolean __temp_executeDef1 = true;
			//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
			if (( field != null )) 
			{
				//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
				switch (field.hashCode())
				{
					case 204157642:
					{
						//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
						if (field.equals("Partition")) 
						{
							//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
							__temp_executeDef1 = false;
							//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
							return this.Partition(((int) (haxe.lang.Runtime.toInt(dynargs[0])) ), ((double) (haxe.lang.Runtime.toDouble(dynargs[1])) ));
						}
						
						//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
						break;
					}
					
					
					case -1480441762:
					{
						//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
						if (field.equals("_clone")) 
						{
							//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
							__temp_executeDef1 = false;
							//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
							return this._clone();
						}
						
						//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
						break;
					}
					
					
					case -1787984641:
					{
						//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
						if (field.equals("Intersect")) 
						{
							//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
							__temp_executeDef1 = false;
							//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
							return this.Intersect(((ln.Ray) (dynargs[0]) ));
						}
						
						//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
						break;
					}
					
					
					case 1965534933:
					{
						//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
						if (field.equals("Anchor")) 
						{
							//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
							__temp_executeDef1 = false;
							//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
							return this.Anchor(((ln.Vector) (dynargs[0]) ));
						}
						
						//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
						break;
					}
					
					
					case 2089790266:
					{
						//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
						if (field.equals("Extend")) 
						{
							//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
							__temp_executeDef1 = false;
							//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
							return this.Extend(((ln.Box) (dynargs[0]) ));
						}
						
						//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
						break;
					}
					
					
					case 2014820469:
					{
						//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
						if (field.equals("Center")) 
						{
							//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
							__temp_executeDef1 = false;
							//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
							return this.Center();
						}
						
						//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
						break;
					}
					
					
					case -502801857:
					{
						//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
						if (field.equals("Contains")) 
						{
							//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
							__temp_executeDef1 = false;
							//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
							return this.Contains(((ln.Vector) (dynargs[0]) ));
						}
						
						//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
						break;
					}
					
					
					case 2577441:
					{
						//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
						if (field.equals("Size")) 
						{
							//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
							__temp_executeDef1 = false;
							//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
							return this.Size();
						}
						
						//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
			if (__temp_executeDef1) 
			{
				//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
				return super.__hx_invokeField(field, dynargs);
			}
			else
			{
				//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
		baseArr.push("Max");
		//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
		baseArr.push("Min");
		//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Box.hx"
		super.__hx_getFields(baseArr);
	}
	
	
}


