package ln;
import ln.Ln.*;
import ln.Ln.Op;
import ln.Ln.Direction;
import ln.Ln.Axis;
class Matrix {
  public var x00 : Float = 0.0;
  public var x01 : Float = 0.0;
  public var x02 : Float = 0.0;
  public var x03 : Float = 0.0;
  public var x10 : Float = 0.0;
  public var x11 : Float = 0.0;
  public var x12 : Float = 0.0;
  public var x13 : Float = 0.0;
  public var x20 : Float = 0.0;
  public var x21 : Float = 0.0;
  public var x22 : Float = 0.0;
  public var x23 : Float = 0.0;
  public var x30 : Float = 0.0;
  public var x31 : Float = 0.0;
  public var x32 : Float = 0.0;
  public var x33 : Float = 0.0;
  public function new (_x00:Float=0.0,_x01:Float=0.0,_x02:Float=0.0,_x03:Float=0.0,_x10:Float=0.0,_x11:Float=0.0,_x12:Float=0.0,_x13:Float=0.0,_x20:Float=0.0,_x21:Float=0.0,_x22:Float=0.0,_x23:Float=0.0,_x30:Float=0.0,_x31:Float=0.0,_x32:Float=0.0,_x33:Float=0.0 ){
    this.x00 = _x00;
    this.x01 = _x01;
    this.x02 = _x02;
    this.x03 = _x03;
    this.x10 = _x10;
    this.x11 = _x11;
    this.x12 = _x12;
    this.x13 = _x13;
    this.x20 = _x20;
    this.x21 = _x21;
    this.x22 = _x22;
    this.x23 = _x23;
    this.x30 = _x30;
    this.x31 = _x31;
    this.x32 = _x32;
    this.x33 = _x33;
  }
  public function _clone (){
    return new Matrix(this.x00,this.x01,this.x02,this.x03,this.x10,this.x11,this.x12,this.x13,this.x20,this.x21,this.x22,this.x23,this.x30,this.x31,this.x32,this.x33);
  }
  public function Translate(v:Vector) : Matrix {
    var m = this._clone();
    return Ln.Translate(v).Mul(m);
  }
  public function Scale(v:Vector) : Matrix {
    var m = this._clone();
    return Ln.Scale(v).Mul(m);
  }
  public function Rotate(v:Vector, a:Float) : Matrix {
    var m = this._clone();
    return Ln.Rotate(v,a).Mul(m);
  }
  public function Frustum(l:Float, r:Float, b:Float, t:Float, n:Float, f:Float) : Matrix {
    var m = this._clone();
    return Ln.Frustum(l,r,b,t,n,f).Mul(m);
  }
  public function Orthographic(l:Float, r:Float, b:Float, t:Float, n:Float, f:Float) : Matrix {
    var m = this._clone();
    return Ln.Orthographic(l,r,b,t,n,f).Mul(m);
  }
  public function Perspective(fovy:Float, aspect:Float, near:Float, far:Float) : Matrix {
    var m = this._clone();
    return Ln.Perspective(fovy,aspect,near,far).Mul(m);
  }
  public function Mul(b:Matrix) : Matrix {
    var a = this._clone();
    var m = new Matrix();
    m.x00 = a.x00*b.x00+a.x01*b.x10+a.x02*b.x20+a.x03*b.x30;
    m.x10 = a.x10*b.x00+a.x11*b.x10+a.x12*b.x20+a.x13*b.x30;
    m.x20 = a.x20*b.x00+a.x21*b.x10+a.x22*b.x20+a.x23*b.x30;
    m.x30 = a.x30*b.x00+a.x31*b.x10+a.x32*b.x20+a.x33*b.x30;
    m.x01 = a.x00*b.x01+a.x01*b.x11+a.x02*b.x21+a.x03*b.x31;
    m.x11 = a.x10*b.x01+a.x11*b.x11+a.x12*b.x21+a.x13*b.x31;
    m.x21 = a.x20*b.x01+a.x21*b.x11+a.x22*b.x21+a.x23*b.x31;
    m.x31 = a.x30*b.x01+a.x31*b.x11+a.x32*b.x21+a.x33*b.x31;
    m.x02 = a.x00*b.x02+a.x01*b.x12+a.x02*b.x22+a.x03*b.x32;
    m.x12 = a.x10*b.x02+a.x11*b.x12+a.x12*b.x22+a.x13*b.x32;
    m.x22 = a.x20*b.x02+a.x21*b.x12+a.x22*b.x22+a.x23*b.x32;
    m.x32 = a.x30*b.x02+a.x31*b.x12+a.x32*b.x22+a.x33*b.x32;
    m.x03 = a.x00*b.x03+a.x01*b.x13+a.x02*b.x23+a.x03*b.x33;
    m.x13 = a.x10*b.x03+a.x11*b.x13+a.x12*b.x23+a.x13*b.x33;
    m.x23 = a.x20*b.x03+a.x21*b.x13+a.x22*b.x23+a.x23*b.x33;
    m.x33 = a.x30*b.x03+a.x31*b.x13+a.x32*b.x23+a.x33*b.x33;
    return m;
  }
  public function MulPosition(b:Vector) : Vector {
    var a = this._clone();
    var x = a.x00*b.X+a.x01*b.Y+a.x02*b.Z+a.x03;
    var y = a.x10*b.X+a.x11*b.Y+a.x12*b.Z+a.x13;
    var z = a.x20*b.X+a.x21*b.Y+a.x22*b.Z+a.x23;
    return new Vector(x,y,z);
  }
  public function MulPositionW(b:Vector) : Vector {
    var a = this._clone();
    var x = a.x00*b.X+a.x01*b.Y+a.x02*b.Z+a.x03;
    var y = a.x10*b.X+a.x11*b.Y+a.x12*b.Z+a.x13;
    var z = a.x20*b.X+a.x21*b.Y+a.x22*b.Z+a.x23;
    var w = a.x30*b.X+a.x31*b.Y+a.x32*b.Z+a.x33;
    return new Vector(x/w,y/w,z/w);
  }
  public function MulDirection(b:Vector) : Vector {
    var a = this._clone();
    var x = a.x00*b.X+a.x01*b.Y+a.x02*b.Z;
    var y = a.x10*b.X+a.x11*b.Y+a.x12*b.Z;
    var z = a.x20*b.X+a.x21*b.Y+a.x22*b.Z;
    return new Vector(x,y,z).Normalize();
  }
  public function MulRay(b:Ray) : Ray {
    var a = this._clone();
    return new Ray(a.MulPosition(b.Origin),a.MulDirection(b.Direction));
  }
  public function MulBox(box:Box) : Box {
    var a = this._clone();
    var r = new Vector(a.x00,a.x10,a.x20);
    var u = new Vector(a.x01,a.x11,a.x21);
    var b = new Vector(a.x02,a.x12,a.x22);
    var t = new Vector(a.x03,a.x13,a.x23);
    var xa = r.MulScalar(box.Min.X);
    var xb = r.MulScalar(box.Max.X);
    var ya = u.MulScalar(box.Min.Y);
    var yb = u.MulScalar(box.Max.Y);
    var za = b.MulScalar(box.Min.Z);
    var zb = b.MulScalar(box.Max.Z);
    var _mnrwe = xa.Min(xb) ;
    var _eggju = xa.Max(xb);
    xa = _mnrwe;
    xb = _eggju;
    var _krrqh = ya.Min(yb);
    var _vcwgu = ya.Max(yb);
    ya = _krrqh;
    yb = _vcwgu;
    var _dgtft = za.Min(zb);
    var _gckwv = za.Max(zb);
    za = _dgtft;
    zb = _gckwv;
    var min = xa.Add(ya).Add(za).Add(t);
    var max = xb.Add(yb).Add(zb).Add(t);
    return new Box(min,max);
  }
  public function Transpose() : Matrix {
    var a = this._clone();
    return new Matrix(a.x00,a.x10,a.x20,a.x30,a.x01,a.x11,a.x21,a.x31,a.x02,a.x12,a.x22,a.x32,a.x03,a.x13,a.x23,a.x33);
  }
  public function Determinant() : Float {
    var a = this._clone();
    return (a.x00*a.x11*a.x22*a.x33-a.x00*a.x11*a.x23*a.x32+a.x00*a.x12*a.x23*a.x31-a.x00*a.x12*a.x21*a.x33+a.x00*a.x13*a.x21*a.x32-a.x00*a.x13*a.x22*a.x31-a.x01*a.x12*a.x23*a.x30+a.x01*a.x12*a.x20*a.x33-a.x01*a.x13*a.x20*a.x32+a.x01*a.x13*a.x22*a.x30-a.x01*a.x10*a.x22*a.x33+a.x01*a.x10*a.x23*a.x32+a.x02*a.x13*a.x20*a.x31-a.x02*a.x13*a.x21*a.x30+a.x02*a.x10*a.x21*a.x33-a.x02*a.x10*a.x23*a.x31+a.x02*a.x11*a.x23*a.x30-a.x02*a.x11*a.x20*a.x33-a.x03*a.x10*a.x21*a.x32+a.x03*a.x10*a.x22*a.x31-a.x03*a.x11*a.x22*a.x30+a.x03*a.x11*a.x20*a.x32-a.x03*a.x12*a.x20*a.x31+a.x03*a.x12*a.x21*a.x30);
  }
  public function Inverse() : Matrix {
    var a = this._clone();
    var m = new Matrix();
    var d = a.Determinant();
    m.x00 = (a.x12*a.x23*a.x31-a.x13*a.x22*a.x31+a.x13*a.x21*a.x32-a.x11*a.x23*a.x32-a.x12*a.x21*a.x33+a.x11*a.x22*a.x33)/d;
    m.x01 = (a.x03*a.x22*a.x31-a.x02*a.x23*a.x31-a.x03*a.x21*a.x32+a.x01*a.x23*a.x32+a.x02*a.x21*a.x33-a.x01*a.x22*a.x33)/d;
    m.x02 = (a.x02*a.x13*a.x31-a.x03*a.x12*a.x31+a.x03*a.x11*a.x32-a.x01*a.x13*a.x32-a.x02*a.x11*a.x33+a.x01*a.x12*a.x33)/d;
    m.x03 = (a.x03*a.x12*a.x21-a.x02*a.x13*a.x21-a.x03*a.x11*a.x22+a.x01*a.x13*a.x22+a.x02*a.x11*a.x23-a.x01*a.x12*a.x23)/d;
    m.x10 = (a.x13*a.x22*a.x30-a.x12*a.x23*a.x30-a.x13*a.x20*a.x32+a.x10*a.x23*a.x32+a.x12*a.x20*a.x33-a.x10*a.x22*a.x33)/d;
    m.x11 = (a.x02*a.x23*a.x30-a.x03*a.x22*a.x30+a.x03*a.x20*a.x32-a.x00*a.x23*a.x32-a.x02*a.x20*a.x33+a.x00*a.x22*a.x33)/d;
    m.x12 = (a.x03*a.x12*a.x30-a.x02*a.x13*a.x30-a.x03*a.x10*a.x32+a.x00*a.x13*a.x32+a.x02*a.x10*a.x33-a.x00*a.x12*a.x33)/d;
    m.x13 = (a.x02*a.x13*a.x20-a.x03*a.x12*a.x20+a.x03*a.x10*a.x22-a.x00*a.x13*a.x22-a.x02*a.x10*a.x23+a.x00*a.x12*a.x23)/d;
    m.x20 = (a.x11*a.x23*a.x30-a.x13*a.x21*a.x30+a.x13*a.x20*a.x31-a.x10*a.x23*a.x31-a.x11*a.x20*a.x33+a.x10*a.x21*a.x33)/d;
    m.x21 = (a.x03*a.x21*a.x30-a.x01*a.x23*a.x30-a.x03*a.x20*a.x31+a.x00*a.x23*a.x31+a.x01*a.x20*a.x33-a.x00*a.x21*a.x33)/d;
    m.x22 = (a.x01*a.x13*a.x30-a.x03*a.x11*a.x30+a.x03*a.x10*a.x31-a.x00*a.x13*a.x31-a.x01*a.x10*a.x33+a.x00*a.x11*a.x33)/d;
    m.x23 = (a.x03*a.x11*a.x20-a.x01*a.x13*a.x20-a.x03*a.x10*a.x21+a.x00*a.x13*a.x21+a.x01*a.x10*a.x23-a.x00*a.x11*a.x23)/d;
    m.x30 = (a.x12*a.x21*a.x30-a.x11*a.x22*a.x30-a.x12*a.x20*a.x31+a.x10*a.x22*a.x31+a.x11*a.x20*a.x32-a.x10*a.x21*a.x32)/d;
    m.x31 = (a.x01*a.x22*a.x30-a.x02*a.x21*a.x30+a.x02*a.x20*a.x31-a.x00*a.x22*a.x31-a.x01*a.x20*a.x32+a.x00*a.x21*a.x32)/d;
    m.x32 = (a.x02*a.x11*a.x30-a.x01*a.x12*a.x30-a.x02*a.x10*a.x31+a.x00*a.x12*a.x31+a.x01*a.x10*a.x32-a.x00*a.x11*a.x32)/d;
    m.x33 = (a.x01*a.x12*a.x20-a.x02*a.x11*a.x20+a.x02*a.x10*a.x21-a.x00*a.x12*a.x21-a.x01*a.x10*a.x22+a.x00*a.x11*a.x22)/d;
    return m;
  }

}
