package ln;
import ln.Ln.*;
import ln.Ln.Op;
import ln.Ln.Direction;
import ln.Ln.Axis;

class BooleanShape implements Shape implements Filter{
  public var Op : Op;
  public var A : Shape = null;
  public var B : Shape = null;
  public function new (_Op:Op=null,_A:Shape=null,_B:Shape=null ){
    this.Op = _Op;
    this.A = _A;
    this.B = _B;
  }
  public function _clone (){
    return new BooleanShape(this.Op,this.A,this.B);
  }
  public function Compile() : Void {
    var s = this._clone();
  }
  public function BoundingBox() : Box {
    var s = this._clone();
    var a = s.A.BoundingBox();
    var b = s.B.BoundingBox();
    return a.Extend(b);
  }
  public function Contains(v:Vector, f:Float) : Bool {
    var s = this._clone();
    f = 1e-3;
    switch (s.Op) {
    case Intersection:
      return s.A.Contains(v,f)&&s.B.Contains(v,f);
    case Difference:
      return s.A.Contains(v,f)&&!s.B.Contains(v,-f);
    }
    return false;
  }
  public function Intersect(r:Ray) : Hit {
    var s = this._clone();
    var h1 = s.A.Intersect(r);
    var h2 = s.B.Intersect(r);
    var h = h1.Min(h2);
    var v = r.Position(h.T);
    if (!h.Ok()||s.Contains(v,0)){
      return h;
    }
    return s.Intersect(new Ray(r.Position(h.T+0.01),r.Direction));
  }
  public function Paths() : Paths {
    var s = this._clone();
    var p = s.A.Paths();
    p = p.concat(s.B.Paths());
    return p.Chop(0.01).Filter(s);
  }
  public function Filter(v:Vector) : Array<Dynamic> {
    var s = this._clone();
    var _pmkdy : Array<Dynamic> = [v,s.Contains(v,0)];
    return _pmkdy;
  }

}
