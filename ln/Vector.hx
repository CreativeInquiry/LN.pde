package ln;
import ln.Ln.*;
import ln.Ln.Op;
import ln.Ln.Direction;
import ln.Ln.Axis;
class Vector {
  public var X : Float = 0.0;
  public var Y : Float = 0.0;
  public var Z : Float = 0.0;
  public function new (_X:Float=0.0,_Y:Float=0.0,_Z:Float=0.0 ){
    this.X = _X;
    this.Y = _Y;
    this.Z = _Z;
  }
  public function _clone (){
    return new Vector(this.X,this.Y,this.Z);
  }
  public function Length() : Float {
    var a = this._clone();
    return Math.sqrt(a.X*a.X+a.Y*a.Y+a.Z*a.Z);
  }
  public function Distance(b:Vector) : Float {
    var a = this._clone();
    return a.Sub(b).Length();
  }
  public function LengthSquared() : Float {
    var a = this._clone();
    return a.X*a.X+a.Y*a.Y+a.Z*a.Z;
  }
  public function DistanceSquared(b:Vector) : Float {
    var a = this._clone();
    return a.Sub(b).LengthSquared();
  }
  public function Dot(b:Vector) : Float {
    var a = this._clone();
    return a.X*b.X+a.Y*b.Y+a.Z*b.Z;
  }
  public function Cross(b:Vector) : Vector {
    var a = this._clone();
    var x = a.Y*b.Z-a.Z*b.Y;
    var y = a.Z*b.X-a.X*b.Z;
    var z = a.X*b.Y-a.Y*b.X;
    return new Vector(x,y,z);
  }
  public function Normalize() : Vector {
    var a = this._clone();
    var d = a.Length();
    return new Vector(a.X/d,a.Y/d,a.Z/d);
  }
  public function Add(b:Vector) : Vector {
    var a = this._clone();
    return new Vector(a.X+b.X,a.Y+b.Y,a.Z+b.Z);
  }
  public function Sub(b:Vector) : Vector {
    var a = this._clone();
    return new Vector(a.X-b.X,a.Y-b.Y,a.Z-b.Z);
  }
  public function Mul(b:Vector) : Vector {
    var a = this._clone();
    return new Vector(a.X*b.X,a.Y*b.Y,a.Z*b.Z);
  }
  public function Div(b:Vector) : Vector {
    var a = this._clone();
    return new Vector(a.X/b.X,a.Y/b.Y,a.Z/b.Z);
  }
  public function AddScalar(b:Float) : Vector {
    var a = this._clone();
    return new Vector(a.X+b,a.Y+b,a.Z+b);
  }
  public function SubScalar(b:Float) : Vector {
    var a = this._clone();
    return new Vector(a.X-b,a.Y-b,a.Z-b);
  }
  public function MulScalar(b:Float) : Vector {
    var a = this._clone();
    return new Vector(a.X*b,a.Y*b,a.Z*b);
  }
  public function DivScalar(b:Float) : Vector {
    var a = this._clone();
    return new Vector(a.X/b,a.Y/b,a.Z/b);
  }
  public function Min(b:Vector) : Vector {
    var a = this._clone();
    return new Vector(Math.min(a.X,b.X),Math.min(a.Y,b.Y),Math.min(a.Z,b.Z));
  }
  public function Max(b:Vector) : Vector {
    var a = this._clone();
    return new Vector(Math.max(a.X,b.X),Math.max(a.Y,b.Y),Math.max(a.Z,b.Z));
  }
  public function MinAxis() : Vector {
    var a = this._clone();
    var x = Math.abs(a.X);
    var y = Math.abs(a.Y);
    var z = Math.abs(a.Z);
    if (x<=y&&x<=z){
      return new Vector(1,0,0);
    }
    else if (y<=x&&y<=z){
      return new Vector(0,1,0);
    }
    return new Vector(0,0,1);
  }
  public function MinComponent() : Float {
    var a = this._clone();
    return Math.min(Math.min(a.X,a.Y),a.Z);
  }
  public function SegmentDistance(v:Vector, w:Vector) : Float {
    var p = this._clone();
    var l2 = v.DistanceSquared(w);
    if (l2==0){
      return p.Distance(v);
    }
    var t = p.Sub(v).Dot(w.Sub(v))/l2;
    if (t<0){
      return p.Distance(v);
    }
    if (t>1){
      return p.Distance(w);
    }
    return v.Add(w.Sub(v).MulScalar(t)).Distance(p);
  }

}
