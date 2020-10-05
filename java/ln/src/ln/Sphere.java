// Generated by Haxe 4.1.3
package ln;

import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class Sphere extends haxe.lang.HxObject implements ln.Shape
{
	public Sphere(haxe.lang.EmptyObject empty)
	{
	}
	
	
	public Sphere(ln.Vector _Center, java.lang.Object _Radius, ln.Box _Box)
	{
		//line 10 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		ln.Sphere.__hx_ctor_ln_Sphere(this, _Center, _Radius, _Box);
	}
	
	
	protected static void __hx_ctor_ln_Sphere(ln.Sphere __hx_this, ln.Vector _Center, java.lang.Object _Radius, ln.Box _Box)
	{
		//line 9 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		__hx_this.Box = null;
		//line 8 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		__hx_this.Radius = 0.0;
		//line 7 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		__hx_this.Center = null;
		//line 10 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		{
			//line 10 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			double _Radius1 = ( (haxe.lang.Runtime.eq(_Radius, null)) ? (0.0) : (((double) (haxe.lang.Runtime.toDouble(_Radius)) )) );
			//line 11 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			__hx_this.Center = _Center;
			//line 12 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			__hx_this.Radius = _Radius1;
			//line 13 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			__hx_this.Box = _Box;
		}
		
	}
	
	
	public ln.Vector Center;
	
	public double Radius;
	
	public ln.Box Box;
	
	public ln.Sphere _clone()
	{
		//line 16 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		return new ln.Sphere(this.Center, this.Radius, this.Box);
	}
	
	
	public void Compile()
	{
		//line 19 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		ln.Sphere s = this._clone();
	}
	
	
	public ln.Box BoundingBox()
	{
		//line 22 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		ln.Sphere s = this._clone();
		//line 23 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		return s.Box;
	}
	
	
	public boolean Contains(ln.Vector v, double f)
	{
		//line 26 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		ln.Sphere s = this._clone();
		//line 27 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		return ( v.Sub(s.Center).Length() <= ( s.Radius + f ) );
	}
	
	
	public ln.Hit Intersect(ln.Ray r)
	{
		//line 30 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		ln.Sphere s = this._clone();
		//line 31 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		double radius = s.Radius;
		//line 32 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		ln.Vector to = r.Origin.Sub(s.Center);
		//line 33 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		double b = to.Dot(r.Direction);
		//line 34 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		double c = ( to.Dot(to) - ( radius * radius ) );
		//line 35 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		double d = ( ( b * b ) - c );
		//line 36 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		if (( d > 0 )) 
		{
			//line 37 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			d = java.lang.Math.sqrt(d);
			//line 38 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			double t1 = (  - (b)  - d );
			//line 39 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			if (( t1 > 1e-2 )) 
			{
				//line 40 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
				return new ln.Hit(s, t1);
			}
			
			//line 42 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			double t2 = (  - (b)  + d );
			//line 43 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			if (( t2 > 1e-2 )) 
			{
				//line 44 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
				return new ln.Hit(s, t2);
			}
			
		}
		
		//line 47 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		return ln.Ln.NoHit;
	}
	
	
	public haxe.root.Array<haxe.root.Array<ln.Vector>> Paths4()
	{
		//line 50 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		ln.Sphere s = this._clone();
		//line 51 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		haxe.root.Array<haxe.root.Array<ln.Vector>> paths = ln._Paths.Paths_Impl_._new(new haxe.root.Array<haxe.root.Array<ln.Vector>>(new haxe.root.Array[]{}));
		//line 52 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		haxe.root.Array<ln.Vector> seen = new haxe.root.Array<ln.Vector>(new ln.Vector[]{});
		//line 53 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		haxe.root.Array<java.lang.Object> radii = new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{});
		//line 54 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		int i = 0;
		//line 55 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		while (( i < 140 ))
		{
			//line 56 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			ln.Vector v = null;
			//line 57 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			double m = 0.0;
			//line 58 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			while (true)
			{
				//line 59 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
				v = ln.Ln.RandomUnitVector();
				//line 60 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
				m = ( ( java.lang.Math.random() * 0.25 ) + 0.05 );
				//line 61 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
				boolean ok = true;
				//line 62 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
				haxe.root.Array<ln.Vector> _veplk = seen;
				//line 63 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
				{
					//line 63 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
					int _g = 0;
					//line 63 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
					int _g1 = _veplk.length;
					//line 63 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
					while (( _g < _g1 ))
					{
						//line 63 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						int i1 = _g++;
						//line 64 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						ln.Vector other = _veplk.__get(i1);
						//line 65 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						double threshold = ( ( m + ((double) (haxe.lang.Runtime.toDouble(radii.__get(i1))) ) ) + 0.02 );
						//line 66 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						if (( other.Sub(v).Length() < threshold )) 
						{
							//line 67 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							ok = false;
							//line 68 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							break;
						}
						
					}
					
				}
				
				//line 71 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
				if (ok) 
				{
					//line 72 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
					seen = seen.concat(new haxe.root.Array<ln.Vector>(new ln.Vector[]{v}));
					//line 73 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
					radii = ((haxe.root.Array<java.lang.Object>) (((haxe.root.Array) (radii.concat(((haxe.root.Array<java.lang.Object>) (((haxe.root.Array) (new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (m) )})) )) ))) )) );
					//line 74 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
					break;
				}
				
			}
			
			//line 77 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			ln.Vector p = v.Cross(ln.Ln.RandomUnitVector()).Normalize();
			//line 78 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			ln.Vector q = p.Cross(v).Normalize();
			//line 79 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			int n = ( haxe.root.Std.random(4) + 1 );
			//line 80 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			int k = 0;
			//line 81 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			while (( k < n ))
			{
				//line 82 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
				haxe.root.Array<ln.Vector> path = ln._Path.Path_Impl_._new(new haxe.root.Array<ln.Vector>(new ln.Vector[]{}));
				//line 83 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
				int j = 0;
				//line 84 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
				while (( j <= 360 ))
				{
					//line 85 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
					double a = ln.Ln.Radians(((double) (j) ));
					//line 86 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
					ln.Vector x = v;
					//line 87 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
					x = x.Add(p.MulScalar(( java.lang.Math.cos(a) * m )));
					//line 88 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
					x = x.Add(q.MulScalar(( java.lang.Math.sin(a) * m )));
					//line 89 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
					x = x.Normalize();
					//line 90 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
					x = x.MulScalar(s.Radius).Add(s.Center);
					//line 91 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
					path = ln._Path.Path_Impl_.concat(path, ln._Path.Path_Impl_._new(new haxe.root.Array<ln.Vector>(new ln.Vector[]{x})));
					//line 92 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
					j += 5;
				}
				
				//line 94 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
				paths = ln._Paths.Paths_Impl_.concat(paths, ln._Paths.Paths_Impl_._new(new haxe.root.Array<haxe.root.Array<ln.Vector>>(new haxe.root.Array[]{path})));
				//line 95 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
				m *= 0.75;
				//line 96 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
				 ++ k;
			}
			
			//line 98 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			 ++ i;
		}
		
		//line 100 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		return paths;
	}
	
	
	public haxe.root.Array<haxe.root.Array<ln.Vector>> Paths3()
	{
		//line 103 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		ln.Sphere s = this._clone();
		//line 104 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		haxe.root.Array<haxe.root.Array<ln.Vector>> paths = ln._Paths.Paths_Impl_._new(new haxe.root.Array<haxe.root.Array<ln.Vector>>(new haxe.root.Array[]{}));
		//line 105 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		int i = 0;
		//line 106 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		while (( i < 20000 ))
		{
			//line 107 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			ln.Vector v = ln.Ln.RandomUnitVector();
			//line 108 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			v = v.MulScalar(s.Radius).Add(s.Center);
			//line 109 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			paths = ln._Paths.Paths_Impl_.concat(paths, ln._Paths.Paths_Impl_._new(new haxe.root.Array<haxe.root.Array<ln.Vector>>(new haxe.root.Array[]{ln._Path.Path_Impl_._new(new haxe.root.Array<ln.Vector>(new ln.Vector[]{v, v}))})));
			//line 110 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			 ++ i;
		}
		
		//line 112 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		return paths;
	}
	
	
	public haxe.root.Array<haxe.root.Array<ln.Vector>> Paths2()
	{
		//line 115 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		ln.Sphere s = this._clone();
		//line 116 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		haxe.root.Array<ln.Vector> equator = ln._Path.Path_Impl_._new(new haxe.root.Array<ln.Vector>(new ln.Vector[]{}));
		//line 117 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		int lng = 0;
		//line 118 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		while (( lng <= 360 ))
		{
			//line 119 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			ln.Vector v = ln.Ln.LatLngToXYZ(((double) (0) ), ((double) (lng) ), s.Radius);
			//line 120 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			equator = ln._Path.Path_Impl_.concat(equator, ln._Path.Path_Impl_._new(new haxe.root.Array<ln.Vector>(new ln.Vector[]{v})));
			//line 121 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			 ++ lng;
		}
		
		//line 123 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		haxe.root.Array<haxe.root.Array<ln.Vector>> paths = ln._Paths.Paths_Impl_._new(new haxe.root.Array<haxe.root.Array<ln.Vector>>(new haxe.root.Array[]{}));
		//line 124 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		int i = 0;
		//line 125 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		while (( i < 100 ))
		{
			//line 126 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			ln.Matrix m = ln.Ln.Identity();
			//line 127 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			int j = 0;
			//line 128 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			while (( j < 3 ))
			{
				//line 129 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
				ln.Vector v1 = ln.Ln.RandomUnitVector();
				//line 130 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
				m = m.Rotate(v1, ( ( java.lang.Math.random() * 2 ) * java.lang.Math.PI ));
				//line 131 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
				 ++ j;
			}
			
			//line 133 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			m = m.Translate(s.Center);
			//line 134 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			paths = ln._Paths.Paths_Impl_.concat(paths, ln._Paths.Paths_Impl_._new(new haxe.root.Array<haxe.root.Array<ln.Vector>>(new haxe.root.Array[]{ln._Path.Path_Impl_.Transform(equator, m)})));
			//line 135 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			 ++ i;
		}
		
		//line 137 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		return paths;
	}
	
	
	public haxe.root.Array<haxe.root.Array<ln.Vector>> Paths()
	{
		//line 140 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		ln.Sphere s = this._clone();
		//line 141 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		haxe.root.Array<haxe.root.Array<ln.Vector>> paths = ln._Paths.Paths_Impl_._new(new haxe.root.Array<haxe.root.Array<ln.Vector>>(new haxe.root.Array[]{}));
		//line 142 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		int n = 10;
		//line 143 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		int o = 10;
		//line 144 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		int lat = ( -90 + o );
		//line 145 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		while (( lat <= ( 90 - o ) ))
		{
			//line 146 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			haxe.root.Array<ln.Vector> path = ln._Path.Path_Impl_._new(new haxe.root.Array<ln.Vector>(new ln.Vector[]{}));
			//line 147 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			int lng = 0;
			//line 148 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			while (( lng <= 360 ))
			{
				//line 149 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
				ln.Vector v = ln.Ln.LatLngToXYZ(((double) (lat) ), ((double) (lng) ), s.Radius).Add(s.Center);
				//line 150 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
				path = ln._Path.Path_Impl_.concat(path, ln._Path.Path_Impl_._new(new haxe.root.Array<ln.Vector>(new ln.Vector[]{v})));
				//line 151 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
				 ++ lng;
			}
			
			//line 153 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			paths = ln._Paths.Paths_Impl_.concat(paths, ln._Paths.Paths_Impl_._new(new haxe.root.Array<haxe.root.Array<ln.Vector>>(new haxe.root.Array[]{path})));
			//line 154 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			lat += n;
		}
		
		//line 156 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		int lng1 = 0;
		//line 157 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		while (( lng1 <= 360 ))
		{
			//line 158 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			haxe.root.Array<ln.Vector> path1 = ln._Path.Path_Impl_._new(new haxe.root.Array<ln.Vector>(new ln.Vector[]{}));
			//line 159 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			int lat1 = ( -90 + o );
			//line 160 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			while (( lat1 <= ( 90 - o ) ))
			{
				//line 161 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
				ln.Vector v1 = ln.Ln.LatLngToXYZ(((double) (lat1) ), ((double) (lng1) ), s.Radius).Add(s.Center);
				//line 162 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
				path1 = ln._Path.Path_Impl_.concat(path1, ln._Path.Path_Impl_._new(new haxe.root.Array<ln.Vector>(new ln.Vector[]{v1})));
				//line 163 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
				 ++ lat1;
			}
			
			//line 165 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			paths = ln._Paths.Paths_Impl_.concat(paths, ln._Paths.Paths_Impl_._new(new haxe.root.Array<haxe.root.Array<ln.Vector>>(new haxe.root.Array[]{path1})));
			//line 166 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			lng1 += n;
		}
		
		//line 168 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		return paths;
	}
	
	
	@Override public double __hx_setField_f(java.lang.String field, double value, boolean handleProperties)
	{
		//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		{
			//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			boolean __temp_executeDef1 = true;
			//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			if (( field != null )) 
			{
				//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
				switch (field.hashCode())
				{
					case -1854711630:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						if (field.equals("Radius")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							this.Radius = ((double) (value) );
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							return value;
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			if (__temp_executeDef1) 
			{
				//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
				return super.__hx_setField_f(field, value, handleProperties);
			}
			else
			{
				//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_setField(java.lang.String field, java.lang.Object value, boolean handleProperties)
	{
		//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		{
			//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			boolean __temp_executeDef1 = true;
			//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			if (( field != null )) 
			{
				//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
				switch (field.hashCode())
				{
					case 66987:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						if (field.equals("Box")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							this.Box = ((ln.Box) (value) );
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							return value;
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						break;
					}
					
					
					case 2014820469:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						if (field.equals("Center")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							this.Center = ((ln.Vector) (value) );
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							return value;
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						break;
					}
					
					
					case -1854711630:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						if (field.equals("Radius")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							this.Radius = ((double) (haxe.lang.Runtime.toDouble(value)) );
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							return value;
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			if (__temp_executeDef1) 
			{
				//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
				return super.__hx_setField(field, value, handleProperties);
			}
			else
			{
				//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_getField(java.lang.String field, boolean throwErrors, boolean isCheck, boolean handleProperties)
	{
		//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		{
			//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			boolean __temp_executeDef1 = true;
			//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			if (( field != null )) 
			{
				//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
				switch (field.hashCode())
				{
					case 76886222:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						if (field.equals("Paths")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "Paths")) );
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						break;
					}
					
					
					case 2014820469:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						if (field.equals("Center")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							return this.Center;
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						break;
					}
					
					
					case -1911494364:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						if (field.equals("Paths2")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "Paths2")) );
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						break;
					}
					
					
					case -1854711630:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						if (field.equals("Radius")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							return this.Radius;
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						break;
					}
					
					
					case -1911494363:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						if (field.equals("Paths3")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "Paths3")) );
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						break;
					}
					
					
					case 66987:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						if (field.equals("Box")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							return this.Box;
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						break;
					}
					
					
					case -1911494362:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						if (field.equals("Paths4")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "Paths4")) );
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						break;
					}
					
					
					case -1480441762:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						if (field.equals("_clone")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "_clone")) );
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						break;
					}
					
					
					case -1787984641:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						if (field.equals("Intersect")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "Intersect")) );
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						break;
					}
					
					
					case -1679822317:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						if (field.equals("Compile")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "Compile")) );
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						break;
					}
					
					
					case -502801857:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						if (field.equals("Contains")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "Contains")) );
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						break;
					}
					
					
					case 405804391:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						if (field.equals("BoundingBox")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "BoundingBox")) );
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			if (__temp_executeDef1) 
			{
				//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
				return super.__hx_getField(field, throwErrors, isCheck, handleProperties);
			}
			else
			{
				//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public double __hx_getField_f(java.lang.String field, boolean throwErrors, boolean handleProperties)
	{
		//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		{
			//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			boolean __temp_executeDef1 = true;
			//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			if (( field != null )) 
			{
				//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
				switch (field.hashCode())
				{
					case -1854711630:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						if (field.equals("Radius")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							return this.Radius;
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			if (__temp_executeDef1) 
			{
				//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
				return super.__hx_getField_f(field, throwErrors, handleProperties);
			}
			else
			{
				//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_invokeField(java.lang.String field, java.lang.Object[] dynargs)
	{
		//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		{
			//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			boolean __temp_executeDef1 = true;
			//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			if (( field != null )) 
			{
				//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
				switch (field.hashCode())
				{
					case 76886222:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						if (field.equals("Paths")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							return this.Paths();
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						break;
					}
					
					
					case -1480441762:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						if (field.equals("_clone")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							return this._clone();
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						break;
					}
					
					
					case -1911494364:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						if (field.equals("Paths2")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							return this.Paths2();
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						break;
					}
					
					
					case -1679822317:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						if (field.equals("Compile")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							this.Compile();
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						break;
					}
					
					
					case -1911494363:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						if (field.equals("Paths3")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							return this.Paths3();
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						break;
					}
					
					
					case 405804391:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						if (field.equals("BoundingBox")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							return this.BoundingBox();
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						break;
					}
					
					
					case -1911494362:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						if (field.equals("Paths4")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							return this.Paths4();
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						break;
					}
					
					
					case -502801857:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						if (field.equals("Contains")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							return this.Contains(((ln.Vector) (dynargs[0]) ), ((double) (haxe.lang.Runtime.toDouble(dynargs[1])) ));
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						break;
					}
					
					
					case -1787984641:
					{
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						if (field.equals("Intersect")) 
						{
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							__temp_executeDef1 = false;
							//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
							return this.Intersect(((ln.Ray) (dynargs[0]) ));
						}
						
						//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
			if (__temp_executeDef1) 
			{
				//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
				return super.__hx_invokeField(field, dynargs);
			}
			
		}
		
		//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		return null;
	}
	
	
	@Override public void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		baseArr.push("Box");
		//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		baseArr.push("Radius");
		//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		baseArr.push("Center");
		//line 6 "/Users/lingdonghuang/proj/LN.pde/ln/Sphere.hx"
		super.__hx_getFields(baseArr);
	}
	
	
}


