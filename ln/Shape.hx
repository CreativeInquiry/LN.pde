package ln;
import ln.Ln.*;
import ln.Ln.Op;
import ln.Ln.Direction;
import ln.Ln.Axis;
interface Shape {
  public function Compile() : Void;
  public function BoundingBox() : Box;
  public function Contains(v:Vector,f:Float) : Bool;
  public function Intersect(r:Ray):Hit;
  public function Paths():Paths; 
}
