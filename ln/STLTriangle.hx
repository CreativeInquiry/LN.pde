package ln;
import ln.Ln.*;
import ln.Ln.Op;
import ln.Ln.Direction;
import ln.Ln.Axis;
class STLTriangle {
  public var V1 : Array<Float> = [];
  public var V2 : Array<Float> = [];
  public var V3 : Array<Float> = [];
  public function new (_V1:Array<Float>,_V2:Array<Float>,_V3:Array<Float>){
    this.V1 = _V1;
    this.V2 = _V2;
    this.V3 = _V3;
  }
  public function _clone (){
    return new STLTriangle(this.V1,this.V2,this.V3);
  }

}
