package ln;
import ln.Ln.*;
import ln.Ln.Op;
import ln.Ln.Direction;
import ln.Ln.Axis;
class Ray {
  public var Origin : Vector = null;
  public var Direction : Vector = null;
  public function new (_Origin:Vector=null,_Direction:Vector=null ){
    this.Origin = _Origin;
    this.Direction = _Direction;
  }
  public function _clone (){
    return new Ray(this.Origin,this.Direction);
  }
  public function Position(t:Float) : Vector {
    var r = this._clone();
    return r.Origin.Add(r.Direction.MulScalar(t));
  }

}
