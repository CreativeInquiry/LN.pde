package ln;
import ln.Ln.*;
import ln.Ln.Op;
import ln.Ln.Direction;
import ln.Ln.Axis;
class EmptyShape implements Shape{
  public function new ( ){
  }
  public function _clone (){
    return new EmptyShape();
  }
  public function Compile() : Void {
  }
  public function BoundingBox() : Box {
    return new Box(new Vector(),new Vector());
  }
  public function Contains(v:Vector, f:Float) : Bool {
    return false;
  }
  public function Intersect(r:Ray) : Hit {
    return NoHit;
  }
  public function Paths() : Paths {
    return null;
  }

}
