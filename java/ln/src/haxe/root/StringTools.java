// Generated by Haxe 4.1.3
package haxe.root;

import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class StringTools extends haxe.lang.HxObject
{
	public StringTools(haxe.lang.EmptyObject empty)
	{
	}
	
	
	public StringTools()
	{
		//line 38 "/usr/local/lib/haxe/std/StringTools.hx"
		haxe.root.StringTools.__hx_ctor__StringTools(this);
	}
	
	
	protected static void __hx_ctor__StringTools(haxe.root.StringTools __hx_this)
	{
	}
	
	
	public static boolean isSpace(java.lang.String s, int pos)
	{
		//line 284 "/usr/local/lib/haxe/std/StringTools.hx"
		java.lang.Object c = haxe.lang.StringExt.charCodeAt(s, pos);
		//line 285 "/usr/local/lib/haxe/std/StringTools.hx"
		if ( ! ((( ( ((int) (haxe.lang.Runtime.toInt(c)) ) > 8 ) && ( ((int) (haxe.lang.Runtime.toInt(c)) ) < 14 ) ))) ) 
		{
			//line 285 "/usr/local/lib/haxe/std/StringTools.hx"
			return haxe.lang.Runtime.eq(c, 32);
		}
		else
		{
			//line 285 "/usr/local/lib/haxe/std/StringTools.hx"
			return true;
		}
		
	}
	
	
	public static java.lang.String ltrim(java.lang.String s)
	{
		//line 301 "/usr/local/lib/haxe/std/StringTools.hx"
		int l = s.length();
		//line 302 "/usr/local/lib/haxe/std/StringTools.hx"
		int r = 0;
		//line 303 "/usr/local/lib/haxe/std/StringTools.hx"
		while (( ( r < l ) && haxe.root.StringTools.isSpace(s, r) ))
		{
			//line 304 "/usr/local/lib/haxe/std/StringTools.hx"
			 ++ r;
		}
		
		//line 306 "/usr/local/lib/haxe/std/StringTools.hx"
		if (( r > 0 )) 
		{
			//line 307 "/usr/local/lib/haxe/std/StringTools.hx"
			return haxe.lang.StringExt.substr(s, r, ( l - r ));
		}
		else
		{
			//line 309 "/usr/local/lib/haxe/std/StringTools.hx"
			return s;
		}
		
	}
	
	
	public static java.lang.String trim(java.lang.String s)
	{
		//line 348 "/usr/local/lib/haxe/std/StringTools.hx"
		return ((java.lang.String) (((java.lang.Object) (s) )) ).trim();
	}
	
	
}

