package ln;
import ln.Ln.*;
import ln.Ln.Op;
import ln.Ln.Direction;
import ln.Ln.Axis;
class Tree {
  public var Box : Box = null;
  public var Root : Node = null;
  public function new (_Box:Box=null,_Root:Node=null ){
    this.Box = _Box;
    this.Root = _Root;
  }
  public function _clone (){
    return new Tree(this.Box,this.Root);
  }
  public function Intersect(r:Ray) : Hit {
    var tree = this;
    var _gwfin : Array<Dynamic> = tree.Box.Intersect(r);
    var tmin = _gwfin[0];
    var tmax = _gwfin[1];
    if (tmax<tmin||tmax<0){
      return NoHit;
    }
    return tree.Root.Intersect(r,tmin,tmax);
  }

}
