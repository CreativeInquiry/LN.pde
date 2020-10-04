package ln;
import ln.Ln.*;
import ln.Ln.Op;
import ln.Ln.Direction;
import ln.Ln.Axis;

class OutlineCylinder extends Cylinder implements Shape {
  public var Eye : Vector = null;
  public var Up : Vector = null;
  public function new (_Radius:Float=0.0,_Z0:Float=0.0,_Z1:Float=0.0,_Eye:Vector=null,_Up:Vector=null ){
    super(_Radius,_Z0,_Z1);
    this.Eye = _Eye;
    this.Up = _Up;
  }
  public override function _clone (){
    return new OutlineCylinder(this.Radius,this.Z0,this.Z1,this.Eye,this.Up);
  }
  public override function Paths() : Paths {
    var c = this._clone();
    var center = new Vector(0,0,c.Z0);
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
    center = new Vector(0,0,c.Z1);
    hyp = center.Sub(c.Eye).Length();
    opp = c.Radius;
    theta = Math.asin(opp/hyp);
    adj = opp/Math.tan(theta);
    d = Math.cos(theta)*adj;
    w = center.Sub(c.Eye).Normalize();
    u = w.Cross(c.Up).Normalize();
    var c1 = c.Eye.Add(w.MulScalar(d));
    var a1 = c1.Add(u.MulScalar(c.Radius*1.01));
    var b1 = c1.Add(u.MulScalar(-c.Radius*1.01));
    var p0 : Path = new Path([]);
    var p1 : Path = new Path([]);
    var a = 0;
    while (a<360){
      var x = c.Radius*Math.cos(Radians((cast a)));
      var y = c.Radius*Math.sin(Radians((cast a)));
      p0 = p0.concat(new Path([new Vector(x,y,c.Z0)]));
      p1 = p1.concat(new Path([new Vector(x,y,c.Z1)]));
      a++;
    }
    return new Paths([p0,p1,
      new Path([new Vector(a0.X,a0.Y,c.Z0),new Vector(a1.X,a1.Y,c.Z1)]),
      new Path([new Vector(b0.X,b0.Y,c.Z0),new Vector(b1.X,b1.Y,c.Z1)])
    ]);
  }

}
