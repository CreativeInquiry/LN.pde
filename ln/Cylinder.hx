package ln;
import ln.Ln.*;
import ln.Ln.Op;
import ln.Ln.Direction;
import ln.Ln.Axis;

class Cylinder implements Shape{
  public var Radius : Float = 0.0;
  public var Z0 : Float = 0.0;
  public var Z1 : Float = 0.0;
  public function new (_Radius:Float=0.0,_Z0:Float=0.0,_Z1:Float=0.0 ){
    this.Radius = _Radius;
    this.Z0 = _Z0;
    this.Z1 = _Z1;
  }
  public function _clone (){
    return new Cylinder(this.Radius,this.Z0,this.Z1);
  }
  public function Compile() : Void {
    var c = this._clone();
  }
  public function BoundingBox() : Box {
    var c = this._clone();
    var r = c.Radius;
    return new Box(new Vector(-r,-r,c.Z0),new Vector(r,r,c.Z1));
  }
  public function Contains(v:Vector, f:Float) : Bool {
    var c = this._clone();
    var xy = new Vector(v.X,v.Y,0);
    if (xy.Length()>c.Radius+f){
      return false;
    }
    return v.Z>=c.Z0-f&&v.Z<=c.Z1+f;
  }
  public function Intersect(ray:Ray) : Hit {
    var shape = this._clone();
    var r = shape.Radius;
    var o = ray.Origin;
    var d = ray.Direction;
    var a = d.X*d.X+d.Y*d.Y;
    var b = 2*o.X*d.X+2*o.Y*d.Y;
    var c = o.X*o.X+o.Y*o.Y-r*r;
    var q = b*b-4*a*c;
    if (q<0){
      return NoHit;
    }
    var s = Math.sqrt(q);
    var t0 = (-b+s)/(2*a);
    var t1 = (-b-s)/(2*a);
    if (t0>t1){
      var _qppxt = t0;
      var _tuiak = t1;
      t1 = _qppxt;
      t0 = _tuiak;
    }
    var z0 = o.Z+t0*d.Z;
    var z1 = o.Z+t1*d.Z;
    if (t0>1e-6&&shape.Z0<z0&&z0<shape.Z1){
      return new Hit(shape,t0);
    }
    if (t1>1e-6&&shape.Z0<z1&&z1<shape.Z1){
      return new Hit(shape,t1);
    }
    return NoHit;
  }
  public function Paths() : Paths {
    var c = this._clone();
    var result:Paths = new Paths([]);
    var a = 0;
    while (a<360){
      var x = c.Radius*Math.cos(Radians((cast a)));
      var y = c.Radius*Math.sin(Radians((cast a)));
      result = result.concat(new Paths([new Path([new Vector(x,y,c.Z0),new Vector(x,y,c.Z1)])]));
      a+=10;
    }
    return result;
  }

}
