// Generated by Haxe 4.1.3
package ln;

import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class Plane extends haxe.lang.HxObject
{
	public Plane(haxe.lang.EmptyObject empty)
	{
	}
	
	
	public Plane(ln.Vector _Point, ln.Vector _Normal)
	{
		//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
		ln.Plane.__hx_ctor_ln_Plane(this, _Point, _Normal);
	}
	
	
	protected static void __hx_ctor_ln_Plane(ln.Plane __hx_this, ln.Vector _Point, ln.Vector _Normal)
	{
		//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
		__hx_this.Normal = null;
		//line 7 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
		__hx_this.Point = null;
		//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
		{
			//line 10 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
			__hx_this.Point = _Point;
			//line 11 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
			__hx_this.Normal = _Normal;
		}
		
	}
	
	
	public ln.Vector Point;
	
	public ln.Vector Normal;
	
	public ln.Plane _clone()
	{
		//line 14 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
		return new ln.Plane(this.Point, this.Normal);
	}
	
	
	public haxe.root.Array IntersectSegment(ln.Vector v0, ln.Vector v1)
	{
		//line 17 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
		ln.Plane p = this._clone();
		//line 18 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
		ln.Vector u = v1.Sub(v0);
		//line 19 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
		ln.Vector w = v0.Sub(p.Point);
		//line 20 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
		double d = p.Normal.Dot(u);
		//line 21 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
		double n =  - (p.Normal.Dot(w)) ;
		//line 22 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
		if (( ( d >  - (ln.Ln.EPS)  ) && ( d < ln.Ln.EPS ) )) 
		{
			//line 23 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
			haxe.root.Array _rqucs = new haxe.root.Array(new java.lang.Object[]{new ln.Vector(null, null, null), false});
			//line 24 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
			return _rqucs;
		}
		
		//line 26 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
		double t = ( n / d );
		//line 27 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
		if (( ( t < 0 ) || ( t > 1 ) )) 
		{
			//line 28 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
			haxe.root.Array _sxgpk = new haxe.root.Array(new java.lang.Object[]{new ln.Vector(null, null, null), false});
			//line 29 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
			return _sxgpk;
		}
		
		//line 31 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
		ln.Vector v = v0.Add(u.MulScalar(t));
		//line 32 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
		haxe.root.Array _bpapg = new haxe.root.Array(new java.lang.Object[]{v, true});
		//line 33 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
		return _bpapg;
	}
	
	
	public haxe.root.Array IntersectTriangle(ln.Triangle t)
	{
		//line 36 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
		ln.Plane p = this._clone();
		//line 37 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
		haxe.root.Array _xpabx = p.IntersectSegment(t.V1, t.V2);
		//line 38 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
		java.lang.Object v1 = _xpabx.__get(0);
		//line 39 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
		boolean ok1 = haxe.lang.Runtime.toBool(((java.lang.Boolean) (_xpabx.__get(1)) ));
		//line 40 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
		haxe.root.Array _ewobt = p.IntersectSegment(t.V2, t.V3);
		//line 41 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
		java.lang.Object v2 = _ewobt.__get(0);
		//line 42 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
		boolean ok2 = haxe.lang.Runtime.toBool(((java.lang.Boolean) (_ewobt.__get(1)) ));
		//line 43 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
		haxe.root.Array _wjduk = p.IntersectSegment(t.V3, t.V1);
		//line 44 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
		java.lang.Object v3 = _wjduk.__get(0);
		//line 45 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
		boolean ok3 = haxe.lang.Runtime.toBool(((java.lang.Boolean) (_wjduk.__get(1)) ));
		//line 46 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
		if (( ok1 && ok2 )) 
		{
			//line 47 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
			haxe.root.Array _hvbgm = new haxe.root.Array(new java.lang.Object[]{v1, v2, true});
			//line 48 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
			return _hvbgm;
		}
		
		//line 50 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
		if (( ok1 && ok3 )) 
		{
			//line 51 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
			haxe.root.Array _rksae = new haxe.root.Array(new java.lang.Object[]{v1, v3, true});
			//line 52 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
			return _rksae;
		}
		
		//line 54 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
		if (( ok2 && ok3 )) 
		{
			//line 55 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
			haxe.root.Array _xgvzu = new haxe.root.Array(new java.lang.Object[]{v2, v3, true});
			//line 56 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
			return _xgvzu;
		}
		
		//line 58 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
		haxe.root.Array _bgfau = new haxe.root.Array(new java.lang.Object[]{new ln.Vector(null, null, null), new ln.Vector(null, null, null), false});
		//line 59 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
		return _bgfau;
	}
	
	
	public haxe.root.Array<haxe.root.Array<ln.Vector>> IntersectMesh(ln.Mesh m)
	{
		//line 62 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
		ln.Plane p = this._clone();
		//line 63 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
		haxe.root.Array<haxe.root.Array<ln.Vector>> result = null;
		//line 64 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
		haxe.root.Array<ln.Triangle> _onzfo = m.Triangles;
		//line 65 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
		{
			//line 65 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
			int _g = 0;
			//line 65 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
			int _g1 = _onzfo.length;
			//line 65 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
			while (( _g < _g1 ))
			{
				//line 65 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
				int _1 = _g++;
				//line 66 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
				ln.Triangle t = _onzfo.__get(_1);
				//line 67 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
				haxe.root.Array _zqjiu = p.IntersectTriangle(t);
				//line 68 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
				ln.Vector v1 = ((ln.Vector) (_zqjiu.__get(0)) );
				//line 69 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
				ln.Vector v2 = ((ln.Vector) (_zqjiu.__get(1)) );
				//line 70 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
				boolean ok = haxe.lang.Runtime.toBool(((java.lang.Boolean) (_zqjiu.__get(2)) ));
				//line 71 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
				if (ok) 
				{
					//line 72 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
					result = ln._Paths.Paths_Impl_.concat(result, ln._Paths.Paths_Impl_._new(new haxe.root.Array<haxe.root.Array<ln.Vector>>(new haxe.root.Array[]{ln._Path.Path_Impl_._new(new haxe.root.Array<ln.Vector>(new ln.Vector[]{v1, v2}))})));
				}
				
			}
			
		}
		
		//line 75 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
		return result;
	}
	
	
	@Override public java.lang.Object __hx_setField(java.lang.String field, java.lang.Object value, boolean handleProperties)
	{
		//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
		{
			//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
			boolean __temp_executeDef1 = true;
			//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
			if (( field != null )) 
			{
				//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
				switch (field.hashCode())
				{
					case -1955878649:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
						if (field.equals("Normal")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
							this.Normal = ((ln.Vector) (value) );
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
							return value;
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
						break;
					}
					
					
					case 77292912:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
						if (field.equals("Point")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
							this.Point = ((ln.Vector) (value) );
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
							return value;
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
			if (__temp_executeDef1) 
			{
				//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
				return super.__hx_setField(field, value, handleProperties);
			}
			else
			{
				//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_getField(java.lang.String field, boolean throwErrors, boolean isCheck, boolean handleProperties)
	{
		//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
		{
			//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
			boolean __temp_executeDef1 = true;
			//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
			if (( field != null )) 
			{
				//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
				switch (field.hashCode())
				{
					case 1765373836:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
						if (field.equals("IntersectMesh")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "IntersectMesh")) );
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
						break;
					}
					
					
					case 77292912:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
						if (field.equals("Point")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
							return this.Point;
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
						break;
					}
					
					
					case 787776551:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
						if (field.equals("IntersectTriangle")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "IntersectTriangle")) );
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
						break;
					}
					
					
					case -1955878649:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
						if (field.equals("Normal")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
							return this.Normal;
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
						break;
					}
					
					
					case 1396630836:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
						if (field.equals("IntersectSegment")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "IntersectSegment")) );
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
						break;
					}
					
					
					case -1480441762:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
						if (field.equals("_clone")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "_clone")) );
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
			if (__temp_executeDef1) 
			{
				//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
				return super.__hx_getField(field, throwErrors, isCheck, handleProperties);
			}
			else
			{
				//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_invokeField(java.lang.String field, java.lang.Object[] dynargs)
	{
		//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
		{
			//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
			boolean __temp_executeDef1 = true;
			//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
			if (( field != null )) 
			{
				//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
				switch (field.hashCode())
				{
					case 1765373836:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
						if (field.equals("IntersectMesh")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
							return this.IntersectMesh(((ln.Mesh) (dynargs[0]) ));
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
						break;
					}
					
					
					case -1480441762:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
						if (field.equals("_clone")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
							return this._clone();
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
						break;
					}
					
					
					case 787776551:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
						if (field.equals("IntersectTriangle")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
							return this.IntersectTriangle(((ln.Triangle) (dynargs[0]) ));
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
						break;
					}
					
					
					case 1396630836:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
						if (field.equals("IntersectSegment")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
							return this.IntersectSegment(((ln.Vector) (dynargs[0]) ), ((ln.Vector) (dynargs[1]) ));
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
			if (__temp_executeDef1) 
			{
				//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
				return super.__hx_invokeField(field, dynargs);
			}
			else
			{
				//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
		baseArr.push("Normal");
		//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
		baseArr.push("Point");
		//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Plane.hx"
		super.__hx_getFields(baseArr);
	}
	
	
}


