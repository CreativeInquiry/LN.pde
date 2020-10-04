package ln;
import ln.Ln.*;
import ln.Ln.Op;
import ln.Ln.Direction;
import ln.Ln.Axis;
class TransformedShape implements Shape{
  public var Shape : Shape = null;
  public var Matrix : Matrix = null;
  public var Inverse : Matrix = null;
  public function new (_Shape:Shape=null,_Matrix:Matrix=null,_Inverse:Matrix=null ){
    this.Shape = _Shape;
    this.Matrix = _Matrix;
    this.Inverse = _Inverse;
  }
  public function Compile(){
    Shape.Compile();
  }
  public function _clone (){
    return new TransformedShape(this.Shape,this.Matrix,this.Inverse);
  }
  public function BoundingBox() : Box {
    var s = this._clone();
    return s.Matrix.MulBox(s.Shape.BoundingBox());
  }
  public function Contains(v:Vector, f:Float) : Bool {
    var s = this._clone();
    return s.Shape.Contains(s.Inverse.MulPosition(v),f);
  }
  public function Intersect(r:Ray) : Hit {
    var s = this._clone();
    return s.Shape.Intersect(s.Inverse.MulRay(r));
  }
  public function Paths() : Paths {
    var s = this._clone();
    return s.Shape.Paths().Transform(s.Matrix);
  }

}
