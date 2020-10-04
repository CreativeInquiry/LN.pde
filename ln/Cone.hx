package ln;
import ln.Ln.*;
import ln.Ln.Op;
import ln.Ln.Direction;
import ln.Ln.Axis;

class Cone implements Shape{
  public var Radius : Float = 0.0;
  public var Height : Float = 0.0;
  public function new (_Radius:Float=0.0,_Height:Float=0.0 ){
    this.Radius = _Radius;
    this.Height = _Height;
  }
  public function _clone (){
    return new Cone(this.Radius,this.Height);
  }
  public function Compile() : Void {
    var c = this._clone();
  }
  public function BoundingBox() : Box {
    var c = this._clone();
    var r = c.Radius;
    return new Box(new Vector(-r,-r,0),new Vector(r,r,c.Height));
  }
  public function Contains(v:Vector, f:Float) : Bool {
    var c = this._clone();
    return false;
  }
  public function Intersect(ray:Ray) : Hit {
    var shape = this._clone();
    var o = ray.Origin;
    var d = ray.Direction;
    var r = shape.Radius;
    var h = shape.Height;
    var k = r/h;
    k = k*k;
    var a = d.X*d.X+d.Y*d.Y-k*d.Z*d.Z;
    var b = 2*(d.X*o.X+d.Y*o.Y-k*d.Z*(o.Z-h));
    var c = o.X*o.X+o.Y*o.Y-k*(o.Z-h)*(o.Z-h);
    var q = b*b-4*a*c;
    if (q<=0){
      return NoHit;
    }
    var s = Math.sqrt(q);
    var t0 = (-b+s)/(2*a);
    var t1 = (-b-s)/(2*a);
    if (t0>t1){
      var _gswzg = t0;
      var _qixnd = t1;
      t1 = _gswzg;
      t0 = _qixnd;
    }
    if (t0>1e-6){
      var p = ray.Position(t0);
      if (p.Z>0&&p.Z<h){
        return new Hit(shape,t0);
      }
    }
    if (t1>1e-6){
      var p = ray.Position(t1);
      if (p.Z>0&&p.Z<h){
        return new Hit(shape,t1);
      }
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
      result = result.concat(new Paths([new Path([new Vector(x,y,0),new Vector(0,0,c.Height)])]));
      a+=30;
    }
    return result;
  }

}
