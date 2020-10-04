package ln;
import ln.Ln.*;
import ln.Ln.Op;
import ln.Ln.Direction;
import ln.Ln.Axis;
class Triangle implements Shape{
  public var V1 : Vector = null;
  public var V2 : Vector = null;
  public var V3 : Vector = null;
  public var Box : Box = null;
  public function new (_V1:Vector=null,_V2:Vector=null,_V3:Vector=null,_Box:Box=null ){
    this.V1 = _V1;
    this.V2 = _V2;
    this.V3 = _V3;
    this.Box = _Box;
  }
  public function _clone (){
    return new Triangle(this.V1,this.V2,this.V3,this.Box);
  }
  public function UpdateBoundingBox() : Void {
    var t = this._clone();
    var min = t.V1.Min(t.V2).Min(t.V3);
    var max = t.V1.Max(t.V2).Max(t.V3);
    t.Box = new Box(min,max);
  }
  public function Compile() : Void {
    var t = this._clone();
  }
  public function BoundingBox() : Box {
    var t = this._clone();
    return t.Box;
  }
  public function Contains(v:Vector, f:Float) : Bool {
    var t = this._clone();
    return false;
  }
  public function Intersect(r:Ray) : Hit {
    var t = this._clone();
    var e1x = t.V2.X-t.V1.X;
    var e1y = t.V2.Y-t.V1.Y;
    var e1z = t.V2.Z-t.V1.Z;
    var e2x = t.V3.X-t.V1.X;
    var e2y = t.V3.Y-t.V1.Y;
    var e2z = t.V3.Z-t.V1.Z;
    var px = r.Direction.Y*e2z-r.Direction.Z*e2y;
    var py = r.Direction.Z*e2x-r.Direction.X*e2z;
    var pz = r.Direction.X*e2y-r.Direction.Y*e2x;
    var det = e1x*px+e1y*py+e1z*pz;
    if (det>-EPS&&det<EPS){
      return NoHit;
    }
    var inv = 1/det;
    var tx = r.Origin.X-t.V1.X;
    var ty = r.Origin.Y-t.V1.Y;
    var tz = r.Origin.Z-t.V1.Z;
    var u = (tx*px+ty*py+tz*pz)*inv;
    if (u<0||u>1){
      return NoHit;
    }
    var qx = ty*e1z-tz*e1y;
    var qy = tz*e1x-tx*e1z;
    var qz = tx*e1y-ty*e1x;
    var v = (r.Direction.X*qx+r.Direction.Y*qy+r.Direction.Z*qz)*inv;
    if (v<0||u+v>1){
      return NoHit;
    }
    var d = (e2x*qx+e2y*qy+e2z*qz)*inv;
    if (d<EPS){
      return NoHit;
    }
    return new Hit(t,d);
  }
  public function Paths() : Paths {
    var t = this._clone();
    return new Paths([new Path([t.V1,t.V2]),new Path([t.V2,t.V3]),new Path([t.V3,t.V1])]);
  }

}
