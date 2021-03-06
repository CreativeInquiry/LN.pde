// Generated by Haxe 4.1.3
package ln;

import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class Function extends haxe.lang.HxObject implements ln.Shape
{
	public Function(haxe.lang.EmptyObject empty)
	{
	}
	
	
	public Function(haxe.lang.Function _Function, ln.Box _Box, java.lang.Object _Direction)
	{
		//line 10 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
		ln.Function.__hx_ctor_ln_Function(this, _Function, _Box, _Direction);
	}
	
	
	protected static void __hx_ctor_ln_Function(ln.Function __hx_this, haxe.lang.Function _Function, ln.Box _Box, java.lang.Object _Direction)
	{
		//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
		__hx_this.Box = null;
		//line 7 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
		__hx_this.Function = null;
		//line 10 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
		{
			//line 10 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
			int _Direction1 = ( (haxe.lang.Runtime.eq(_Direction, null)) ? (0) : (((int) (haxe.lang.Runtime.toInt(_Direction)) )) );
			//line 11 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
			__hx_this.Function = _Function;
			//line 12 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
			__hx_this.Box = _Box;
			//line 13 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
			__hx_this.Direction = _Direction1;
		}
		
	}
	
	
	public haxe.lang.Function Function;
	
	public ln.Box Box;
	
	public int Direction;
	
	public ln.Function _clone()
	{
		//line 16 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
		return new ln.Function(this.Function, this.Box, this.Direction);
	}
	
	
	public void Compile()
	{
		//line 19 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
		ln.Function f = this._clone();
	}
	
	
	public ln.Box BoundingBox()
	{
		//line 22 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
		ln.Function f = this._clone();
		//line 23 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
		return f.Box;
	}
	
	
	public boolean Contains(ln.Vector v, double eps)
	{
		//line 26 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
		ln.Function f = this._clone();
		//line 27 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
		if (( f.Direction == ln.Ln.Below )) 
		{
			//line 28 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
			return ( v.Z < ((double) (f.Function.__hx_invoke2_f(v.X, haxe.lang.Runtime.undefined, v.Y, haxe.lang.Runtime.undefined)) ) );
		}
		else
		{
			//line 31 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
			return ( v.Z > ((double) (f.Function.__hx_invoke2_f(v.X, haxe.lang.Runtime.undefined, v.Y, haxe.lang.Runtime.undefined)) ) );
		}
		
	}
	
	
	public ln.Hit Intersect(ln.Ray ray)
	{
		//line 35 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
		ln.Function f = this._clone();
		//line 36 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
		double step = 0.015625;
		//line 37 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
		boolean sign = f.Contains(ray.Position(step), ((double) (0) ));
		//line 38 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
		double t = step;
		//line 39 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
		while (( t < 10 ))
		{
			//line 40 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
			ln.Vector v = ray.Position(t);
			//line 41 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
			if (( ( f.Contains(v, ((double) (0) )) != sign ) && f.Box.Contains(v) )) 
			{
				//line 42 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
				return new ln.Hit(f, t);
			}
			
			//line 44 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
			t += step;
		}
		
		//line 46 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
		return ln.Ln.NoHit;
	}
	
	
	public haxe.root.Array<haxe.root.Array<ln.Vector>> Paths3()
	{
		//line 49 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
		ln.Function f = this._clone();
		//line 50 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
		haxe.root.Array<ln.Vector> path = ln._Path.Path_Impl_._new(new haxe.root.Array<ln.Vector>(new ln.Vector[]{}));
		//line 51 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
		int n = 10000;
		//line 52 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
		int i = 0;
		//line 53 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
		while (( i < n ))
		{
			//line 54 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
			double t = ( ((double) (i) ) / n );
			//line 55 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
			double r = ( 8 - ( java.lang.Math.pow(t, 0.1) * 8 ) );
			//line 56 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
			double x = ( java.lang.Math.cos(ln.Ln.Radians(( ( ( t * 2 ) * java.lang.Math.PI ) * 3000 ))) * r );
			//line 57 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
			double y = ( java.lang.Math.sin(ln.Ln.Radians(( ( ( t * 2 ) * java.lang.Math.PI ) * 3000 ))) * r );
			//line 58 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
			double z = ((double) (f.Function.__hx_invoke2_f(x, haxe.lang.Runtime.undefined, y, haxe.lang.Runtime.undefined)) );
			//line 59 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
			z = java.lang.Math.min(z, f.Box.Max.Z);
			//line 60 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
			z = java.lang.Math.max(z, f.Box.Min.Z);
			//line 61 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
			path = ln._Path.Path_Impl_.concat(path, ln._Path.Path_Impl_._new(new haxe.root.Array<ln.Vector>(new ln.Vector[]{new ln.Vector(x, y, z)})));
			//line 62 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
			 ++ i;
		}
		
		//line 64 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
		return ln._Paths.Paths_Impl_._new(new haxe.root.Array<haxe.root.Array<ln.Vector>>(new haxe.root.Array[]{path}));
	}
	
	
	public haxe.root.Array<haxe.root.Array<ln.Vector>> Paths()
	{
		//line 68 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
		ln.Function f = this._clone();
		//line 69 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
		haxe.root.Array<haxe.root.Array<ln.Vector>> paths = ln._Paths.Paths_Impl_._new(new haxe.root.Array<haxe.root.Array<ln.Vector>>(new haxe.root.Array[]{}));
		//line 70 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
		double fine = 0.00390625;
		//line 71 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
		int a = 0;
		//line 72 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
		while (( a < 360 ))
		{
			//line 74 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
			haxe.root.Array<ln.Vector> path = ln._Path.Path_Impl_._new(new haxe.root.Array<ln.Vector>(new ln.Vector[]{}));
			//line 75 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
			double r = 0.0;
			//line 76 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
			while (( r <= 8.0 ))
			{
				//line 77 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
				double x = ( java.lang.Math.cos(ln.Ln.Radians(((double) (a) ))) * r );
				//line 78 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
				double y = ( java.lang.Math.sin(ln.Ln.Radians(((double) (a) ))) * r );
				//line 79 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
				double z = ((double) (f.Function.__hx_invoke2_f(x, haxe.lang.Runtime.undefined, y, haxe.lang.Runtime.undefined)) );
				//line 80 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
				double o =  - (java.lang.Math.pow( - (z) , 1.4)) ;
				//line 81 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
				x = ( java.lang.Math.cos(( ln.Ln.Radians(((double) (a) )) - o )) * r );
				//line 82 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
				y = ( java.lang.Math.sin(( ln.Ln.Radians(((double) (a) )) - o )) * r );
				//line 83 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
				z = java.lang.Math.min(z, f.Box.Max.Z);
				//line 84 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
				z = java.lang.Math.max(z, f.Box.Min.Z);
				//line 85 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
				path = ln._Path.Path_Impl_.concat(path, ln._Path.Path_Impl_._new(new haxe.root.Array<ln.Vector>(new ln.Vector[]{new ln.Vector(x, y, z)})));
				//line 86 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
				r += fine;
			}
			
			//line 88 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
			paths = ln._Paths.Paths_Impl_.concat(paths, ln._Paths.Paths_Impl_._new(new haxe.root.Array<haxe.root.Array<ln.Vector>>(new haxe.root.Array[]{path})));
			//line 89 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
			a += 5;
		}
		
		//line 91 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
		return paths;
	}
	
	
	public haxe.root.Array<haxe.root.Array<ln.Vector>> Paths1()
	{
		//line 94 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
		ln.Function f = this._clone();
		//line 95 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
		haxe.root.Array<haxe.root.Array<ln.Vector>> paths = ln._Paths.Paths_Impl_._new(new haxe.root.Array<haxe.root.Array<ln.Vector>>(new haxe.root.Array[]{}));
		//line 96 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
		double step = 0.125;
		//line 97 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
		double fine = 0.015625;
		//line 98 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
		double x = f.Box.Min.X;
		//line 99 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
		while (( x <= f.Box.Max.X ))
		{
			//line 100 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
			haxe.root.Array<ln.Vector> path = ln._Path.Path_Impl_._new(new haxe.root.Array<ln.Vector>(new ln.Vector[]{}));
			//line 101 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
			double y = f.Box.Min.Y;
			//line 102 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
			while (( y <= f.Box.Max.Y ))
			{
				//line 103 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
				double z = ((double) (f.Function.__hx_invoke2_f(x, haxe.lang.Runtime.undefined, y, haxe.lang.Runtime.undefined)) );
				//line 104 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
				z = java.lang.Math.min(z, f.Box.Max.Z);
				//line 105 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
				z = java.lang.Math.max(z, f.Box.Min.Z);
				//line 106 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
				path = ln._Path.Path_Impl_.concat(path, ln._Path.Path_Impl_._new(new haxe.root.Array<ln.Vector>(new ln.Vector[]{new ln.Vector(x, y, z)})));
				//line 107 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
				y += fine;
			}
			
			//line 109 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
			paths = ln._Paths.Paths_Impl_.concat(paths, ln._Paths.Paths_Impl_._new(new haxe.root.Array<haxe.root.Array<ln.Vector>>(new haxe.root.Array[]{path})));
			//line 110 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
			x += step;
		}
		
		//line 112 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
		double y1 = f.Box.Min.Y;
		//line 113 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
		while (( y1 <= f.Box.Max.Y ))
		{
			//line 114 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
			haxe.root.Array<ln.Vector> path1 = ln._Path.Path_Impl_._new(new haxe.root.Array<ln.Vector>(new ln.Vector[]{}));
			//line 115 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
			double x1 = f.Box.Min.X;
			//line 116 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
			while (( x1 <= f.Box.Max.X ))
			{
				//line 117 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
				double z1 = ((double) (f.Function.__hx_invoke2_f(x1, haxe.lang.Runtime.undefined, y1, haxe.lang.Runtime.undefined)) );
				//line 118 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
				z1 = java.lang.Math.min(z1, f.Box.Max.Z);
				//line 119 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
				z1 = java.lang.Math.max(z1, f.Box.Min.Z);
				//line 120 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
				path1 = ln._Path.Path_Impl_.concat(path1, ln._Path.Path_Impl_._new(new haxe.root.Array<ln.Vector>(new ln.Vector[]{new ln.Vector(x1, y1, z1)})));
				//line 121 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
				x1 += fine;
			}
			
			//line 123 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
			paths = ln._Paths.Paths_Impl_.concat(paths, ln._Paths.Paths_Impl_._new(new haxe.root.Array<haxe.root.Array<ln.Vector>>(new haxe.root.Array[]{path1})));
			//line 124 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
			y1 += step;
		}
		
		//line 126 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
		return paths;
	}
	
	
	@Override public double __hx_setField_f(java.lang.String field, double value, boolean handleProperties)
	{
		//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
		{
			//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
			boolean __temp_executeDef1 = true;
			//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
			if (( field != null )) 
			{
				//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
				switch (field.hashCode())
				{
					case 1041377119:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
						if (field.equals("Direction")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
							this.Direction = ((int) (value) );
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
							return value;
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
			if (__temp_executeDef1) 
			{
				//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
				return super.__hx_setField_f(field, value, handleProperties);
			}
			else
			{
				//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_setField(java.lang.String field, java.lang.Object value, boolean handleProperties)
	{
		//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
		{
			//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
			boolean __temp_executeDef1 = true;
			//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
			if (( field != null )) 
			{
				//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
				switch (field.hashCode())
				{
					case 1041377119:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
						if (field.equals("Direction")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
							this.Direction = ((int) (haxe.lang.Runtime.toInt(value)) );
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
							return value;
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
						break;
					}
					
					
					case 1445582840:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
						if (field.equals("Function")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
							this.Function = ((haxe.lang.Function) (value) );
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
							return value;
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
						break;
					}
					
					
					case 66987:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
						if (field.equals("Box")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
							this.Box = ((ln.Box) (value) );
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
							return value;
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
			if (__temp_executeDef1) 
			{
				//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
				return super.__hx_setField(field, value, handleProperties);
			}
			else
			{
				//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_getField(java.lang.String field, boolean throwErrors, boolean isCheck, boolean handleProperties)
	{
		//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
		{
			//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
			boolean __temp_executeDef1 = true;
			//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
			if (( field != null )) 
			{
				//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
				switch (field.hashCode())
				{
					case -1911494365:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
						if (field.equals("Paths1")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "Paths1")) );
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
						break;
					}
					
					
					case 1445582840:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
						if (field.equals("Function")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
							return this.Function;
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
						break;
					}
					
					
					case 76886222:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
						if (field.equals("Paths")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "Paths")) );
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
						break;
					}
					
					
					case 66987:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
						if (field.equals("Box")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
							return this.Box;
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
						break;
					}
					
					
					case -1911494363:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
						if (field.equals("Paths3")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "Paths3")) );
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
						break;
					}
					
					
					case 1041377119:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
						if (field.equals("Direction")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
							return this.Direction;
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
						break;
					}
					
					
					case -1787984641:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
						if (field.equals("Intersect")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "Intersect")) );
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
						break;
					}
					
					
					case -1480441762:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
						if (field.equals("_clone")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "_clone")) );
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
						break;
					}
					
					
					case -502801857:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
						if (field.equals("Contains")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "Contains")) );
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
						break;
					}
					
					
					case -1679822317:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
						if (field.equals("Compile")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "Compile")) );
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
						break;
					}
					
					
					case 405804391:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
						if (field.equals("BoundingBox")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "BoundingBox")) );
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
			if (__temp_executeDef1) 
			{
				//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
				return super.__hx_getField(field, throwErrors, isCheck, handleProperties);
			}
			else
			{
				//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public double __hx_getField_f(java.lang.String field, boolean throwErrors, boolean handleProperties)
	{
		//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
		{
			//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
			boolean __temp_executeDef1 = true;
			//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
			if (( field != null )) 
			{
				//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
				switch (field.hashCode())
				{
					case 1041377119:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
						if (field.equals("Direction")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
							return ((double) (this.Direction) );
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
			if (__temp_executeDef1) 
			{
				//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
				return super.__hx_getField_f(field, throwErrors, handleProperties);
			}
			else
			{
				//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_invokeField(java.lang.String field, java.lang.Object[] dynargs)
	{
		//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
		{
			//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
			boolean __temp_executeDef1 = true;
			//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
			if (( field != null )) 
			{
				//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
				switch (field.hashCode())
				{
					case -1911494365:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
						if (field.equals("Paths1")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
							return this.Paths1();
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
						break;
					}
					
					
					case -1480441762:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
						if (field.equals("_clone")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
							return this._clone();
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
						break;
					}
					
					
					case 76886222:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
						if (field.equals("Paths")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
							return this.Paths();
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
						break;
					}
					
					
					case -1679822317:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
						if (field.equals("Compile")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
							this.Compile();
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
						break;
					}
					
					
					case -1911494363:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
						if (field.equals("Paths3")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
							return this.Paths3();
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
						break;
					}
					
					
					case 405804391:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
						if (field.equals("BoundingBox")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
							return this.BoundingBox();
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
						break;
					}
					
					
					case -1787984641:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
						if (field.equals("Intersect")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
							return this.Intersect(((ln.Ray) (dynargs[0]) ));
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
						break;
					}
					
					
					case -502801857:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
						if (field.equals("Contains")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
							return this.Contains(((ln.Vector) (dynargs[0]) ), ((double) (haxe.lang.Runtime.toDouble(dynargs[1])) ));
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
			if (__temp_executeDef1) 
			{
				//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
				return super.__hx_invokeField(field, dynargs);
			}
			
		}
		
		//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
		return null;
	}
	
	
	@Override public void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
		baseArr.push("Direction");
		//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
		baseArr.push("Box");
		//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
		baseArr.push("Function");
		//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Function.hx"
		super.__hx_getFields(baseArr);
	}
	
	
}


