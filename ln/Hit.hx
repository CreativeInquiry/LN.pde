package ln;
import ln.Ln.*;
import ln.Ln.Op;
import ln.Ln.Direction;
import ln.Ln.Axis;
class Hit {
  public var Shape : Shape = null;
  public var T : Float = 0.0;
  public function new (_Shape:Shape=null,_T:Float=0.0 ){
    this.Shape = _Shape;
    this.T = _T;
  }
  public function _clone (){
    return new Hit(this.Shape,this.T);
  }
  public function Ok() : Bool {
    var hit = this._clone();
    return hit.T<INF;
  }
  public function Min(b:Hit) : Hit {
    var a = this._clone();
    if (a.T<=b.T){
      return a;
    }
    return b;
  }
  public function Max(b:Hit) : Hit {
    var a = this._clone();
    if (a.T>b.T){
      return a;
    }
    return b;
  }

}
