package ln;
import ln.Ln.*;
import ln.Ln.Op;
import ln.Ln.Direction;
import ln.Ln.Axis;
class Cube implements Shape{
  public var Min : Vector = null;
  public var Max : Vector = null;
  public var Box : Box = null;
  public function new (_Min:Vector=null,_Max:Vector=null,_Box:Box=null ){
    this.Min = _Min;
    this.Max = _Max;
    this.Box = _Box;
  }
  public function _clone (){
    return new Cube(this.Min,this.Max,this.Box);
  }
  public function Compile() : Void {
    var c = this._clone();
  }
  public function BoundingBox() : Box {
    var c = this._clone();
    return c.Box;
  }
  public function Contains(v:Vector, f:Float) : Bool {
    var c = this._clone();
    if (v.X<c.Min.X-f||v.X>c.Max.X+f){
      return false;
    }
    if (v.Y<c.Min.Y-f||v.Y>c.Max.Y+f){
      return false;
    }
    if (v.Z<c.Min.Z-f||v.Z>c.Max.Z+f){
      return false;
    }
    return true;
  }
  public function Intersect(r:Ray) : Hit {
    var c = this._clone();
    var n = c.Min.Sub(r.Origin).Div(r.Direction);
    var f = c.Max.Sub(r.Origin).Div(r.Direction);
    var _gpxcj = n.Min(f);
    var _xyyyx = n.Max(f);
    n = _gpxcj;
    f = _xyyyx;
    var t0 = Math.max(Math.max(n.X,n.Y),n.Z);
    var t1 = Math.min(Math.min(f.X,f.Y),f.Z);
    if (t0<1e-3&&t1>1e-3){
      return new Hit(c,t1);
    }
    if (t0>=1e-3&&t0<t1){
      return new Hit(c,t0);
    }
    return NoHit;
  }
  public function Paths() : Paths {
    var c = this._clone();
    var x1 = c.Min.X;
    var y1 = c.Min.Y;
    var z1 = c.Min.Z;
    var x2 = c.Max.X;
    var y2 = c.Max.Y;
    var z2 = c.Max.Z;
    var paths = new Paths([
      new Path([new Vector(x1,y1,z1),new Vector(x1,y1,z2)]),
      new Path([new Vector(x1,y1,z1),new Vector(x1,y2,z1)]),
      new Path([new Vector(x1,y1,z1),new Vector(x2,y1,z1)]),
      new Path([new Vector(x1,y1,z2),new Vector(x1,y2,z2)]),
      new Path([new Vector(x1,y1,z2),new Vector(x2,y1,z2)]),
      new Path([new Vector(x1,y2,z1),new Vector(x1,y2,z2)]),
      new Path([new Vector(x1,y2,z1),new Vector(x2,y2,z1)]),
      new Path([new Vector(x1,y2,z2),new Vector(x2,y2,z2)]),
      new Path([new Vector(x2,y1,z1),new Vector(x2,y1,z2)]),
      new Path([new Vector(x2,y1,z1),new Vector(x2,y2,z1)]),
      new Path([new Vector(x2,y1,z2),new Vector(x2,y2,z2)]),
      new Path([new Vector(x2,y2,z1),new Vector(x2,y2,z2)])
    ]);
    return paths;
    paths = new Paths(paths._raw().slice(0,0));
    var i = 0;
    while (i<=10){
      var p = (cast i)/10;
      var x : Float = 0.0;
      var y : Float = 0.0;
      x = x1+(x2-x1)*p;
      y = y1+(y2-y1)*p;
      paths = paths.concat(new Paths([new Path([new Vector(x,y1,z1),new Vector(x,y1,z2)])]));
      paths = paths.concat(new Paths([new Path([new Vector(x,y2,z1),new Vector(x,y2,z2)])]));
      paths = paths.concat(new Paths([new Path([new Vector(x1,y,z1),new Vector(x1,y,z2)])]));
      paths = paths.concat(new Paths([new Path([new Vector(x2,y,z1),new Vector(x2,y,z2)])]));
      i++;
    }
    return paths;
  }

}
