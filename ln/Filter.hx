package ln;
import ln.Ln.*;
import ln.Ln.Op;
import ln.Ln.Direction;
import ln.Ln.Axis;
class FilterResult{
  public var x : Vector;
  public var y : Bool;
  public function new(x:Vector,y:Bool){
    this.x = x;
    this.y = y;
  }
}
interface Filter {
  public function Filter(v:Vector):FilterResult;
}
