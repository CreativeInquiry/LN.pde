package ln;
import ln.Ln.*;
import ln.Ln.Op;
import ln.Ln.Direction;
import ln.Ln.Axis;
class STLHeader {
  public var _0 : Array<Int> = [];
  public var Count : Int = 0;
  public function new (__0:Array<Int>,_Count:Int=0 ){
    this._0 = __0;
    this.Count = _Count;
  }
  public function _clone (){
    return new STLHeader(this._0,this.Count);
  }

}
