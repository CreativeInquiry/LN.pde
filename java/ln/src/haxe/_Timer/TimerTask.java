// Generated by Haxe 4.1.3
package haxe._Timer;

import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class TimerTask extends java.util.TimerTask
{
	public TimerTask(haxe.Timer timer)
	{
		//line 200 "/usr/local/lib/haxe/std/haxe/Timer.hx"
		super();
		//line 201 "/usr/local/lib/haxe/std/haxe/Timer.hx"
		this.timer = timer;
	}
	
	
	public haxe.Timer timer;
	
	@Override public void run()
	{
		//line 205 "/usr/local/lib/haxe/std/haxe/Timer.hx"
		this.timer.run.__hx_invoke0_o();
	}
	
	
}

