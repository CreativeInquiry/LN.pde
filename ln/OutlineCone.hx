package ln;
import haxe.display.Display.Define;
import ln.Ln.*;
import ln.Ln.Op;
import ln.Ln.Direction;
import ln.Ln.Axis;
class OutlineCone extends Cone implements Shape{
  public var Eye : Vector = null;
  public var Up : Vector = null;
  public function new (_Radius:Float=0.0,_Height:Float=0.0,_Eye:Vector=null,_Up:Vector=null ){
    super(_Radius,_Height);
    this.Eye = _Eye;
    this.Up = _Up;
  }
  public override function _clone (){
    return new OutlineCone(this.Radius,this.Height,this.Eye,this.Up);
  }
  public override function Paths() : Paths {
    var c = this._clone();
    var center = new Vector(0,0,0);
    var hyp = center.Sub(c.Eye).Length();
    var opp = c.Radius;
    var theta = Math.asin(opp/hyp);
    var adj = opp/Math.tan(theta);
    var d = Math.cos(theta)*adj;
    var w = center.Sub(c.Eye).Normalize();
    var u = w.Cross(c.Up).Normalize();
    var c0 = c.Eye.Add(w.MulScalar(d));
    var a0 = c0.Add(u.MulScalar(c.Radius*1.01));
    var b0 = c0.Add(u.MulScalar(-c.Radius*1.01));
    var p0:Path = new Path([]);
    var a = 0;
    while (a<360){
      var x = c.Radius*Math.cos(Radians((cast a)));
      var y = c.Radius*Math.sin(Radians((cast a)));
      p0 = p0.concat(new Path([new Vector(x,y,0)]));
      a++;
    }
    return new Paths([
      p0,
      new Path([new Vector(a0.X,a0.Y,0),new Vector(0,0,c.Height)]),
      new Path([new Vector(b0.X,b0.Y,0),new Vector(0,0,c.Height)])
    ]);
  }

}
