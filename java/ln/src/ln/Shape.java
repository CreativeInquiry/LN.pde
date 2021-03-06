// Generated by Haxe 4.1.3
package ln;

import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public interface Shape extends haxe.lang.IHxObject
{
	void Compile();
	
	ln.Box BoundingBox();
	
	boolean Contains(ln.Vector v, double f);
	
	ln.Hit Intersect(ln.Ray r);
	
	haxe.root.Array<haxe.root.Array<ln.Vector>> Paths();
	
}


