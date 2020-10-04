package ln;
import ln.Ln.*;
import ln.Ln.Op;
import ln.Ln.Direction;
import ln.Ln.Axis;


class Box {
  public var Min : Vector = null;
  public var Max : Vector = null;
  public function new (_Min:Vector=null,_Max:Vector=null ){
    this.Min = _Min;
    this.Max = _Max;
  }
  public function _clone (){
    return new Box(this.Min,this.Max);
  }
  public function Anchor(anchor:Vector) : Vector {
    var a = this._clone();
    return a.Min.Add(a.Size().Mul(anchor));
  }
  public function Center() : Vector {
    var a = this._clone();
    return a.Anchor(new Vector(0.5,0.5,0.5));
  }
  public function Size() : Vector {
    var a = this._clone();
    return a.Max.Sub(a.Min);
  }
  public function Contains(b:Vector) : Bool {
    var a = this._clone();
    return a.Min.X<=b.X&&a.Max.X>=b.X&&a.Min.Y<=b.Y&&a.Max.Y>=b.Y&&a.Min.Z<=b.Z&&a.Max.Z>=b.Z;
  }
  public function Extend(b:Box) : Box {
    var a = this._clone();
    return new Box(a.Min.Min(b.Min),a.Max.Max(b.Max));
  }
  public function Intersect(r:Ray) : Array<Dynamic> {
    var b = this._clone();
    var x1 = (b.Min.X-r.Origin.X)/r.Direction.X;
    var y1 = (b.Min.Y-r.Origin.Y)/r.Direction.Y;
    var z1 = (b.Min.Z-r.Origin.Z)/r.Direction.Z;
    var x2 = (b.Max.X-r.Origin.X)/r.Direction.X;
    var y2 = (b.Max.Y-r.Origin.Y)/r.Direction.Y;
    var z2 = (b.Max.Z-r.Origin.Z)/r.Direction.Z;
    if (x1>x2){
      var tmp = x1;
      x1 = x2;
      x2 = tmp;
    }
    if (y1>y2){
      var tmp = y1;
      y1 = y2;
      y2 = tmp;
    }
    if (z1>z2){
      var tmp = z1;
      z1 = z2;
      z1 = tmp;
    }
    var t1 = Math.max(Math.max(x1,y1),z1);
    var t2 = Math.min(Math.min(x2,y2),z2);
    var _wqxbl : Array<Dynamic> = [t1,t2];
    return _wqxbl;
  }
  public function Partition(axis:Axis, point:Float) : Array<Dynamic> {
    var b = this._clone();
    var left : Bool = false;
    var right : Bool = false;
    switch (axis) {
    case AxisX:
      left = b.Min.X<=point;
      right = b.Max.X>=point;
    case AxisY:
      left = b.Min.Y<=point;
      right = b.Max.Y>=point;
    case AxisZ:
      left = b.Min.Z<=point;
      right = b.Max.Z>=point;
    }
    var _afudq : Array<Dynamic> = [left,right];
    return _afudq;
  }

}
