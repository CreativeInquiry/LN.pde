package ln;
import ln.Ln.*;
import ln.Ln.Op;
import ln.Ln.Direction;
import ln.Ln.Axis;
class OutlineSphere extends Sphere implements Shape {

  public var Eye : Vector = null;
  public var Up : Vector = null;
  public function new (_Center:Vector=null,_Radius:Float=0.0,_Box:Box=null,_Eye:Vector=null,_Up:Vector=null ){
    super(_Center,_Radius,_Box);
    this.Eye = _Eye;
    this.Up = _Up;
  }
  public override function _clone (){
    return new OutlineSphere(this.Center,this.Radius,this.Box,this.Eye,this.Up);
  }
  public override function Paths() : Paths {
    var s = this;
    var path:Path = new Path([]);
    var center = s.Center;
    var radius = s.Radius;
    var hyp = center.Sub(s.Eye).Length();
    var opp = radius;
    var theta = Math.asin(opp/hyp);
    var adj = opp/Math.tan(theta);
    var d = Math.cos(theta)*adj;
    var r = Math.sin(theta)*adj;
    var w = center.Sub(s.Eye).Normalize();
    var u = w.Cross(s.Up).Normalize();
    var v = w.Cross(u).Normalize();
    var c = s.Eye.Add(w.MulScalar(d));
    var i = 0;
    while (i<=360){
      var a = Radians((cast i));
      var p = c;
      p = p.Add(u.MulScalar(Math.cos(a)*r));
      p = p.Add(v.MulScalar(Math.sin(a)*r));
      path = path.concat(new Path([p]));
      i++;
    }
    return new Paths([path]);
  }

}
