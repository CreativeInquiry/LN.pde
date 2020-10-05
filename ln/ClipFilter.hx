package ln;
import haxe.xml.Access;
import ln.Filter.FilterResult;
import ln.Ln.*;
import ln.Ln.Op;
import ln.Ln.Direction;
import ln.Ln.Axis;

class ClipFilter implements Filter{
  public var Matrix : Matrix = null;
  public var Eye : Vector = null;
  public var Scene : Scene = null;
  public function new (_Matrix:Matrix=null,_Eye:Vector=null,_Scene:Scene=null ){
    this.Matrix = _Matrix;
    this.Eye = _Eye;
    this.Scene = _Scene;
  }
  public function _clone (){
    return new ClipFilter(this.Matrix,this.Eye,this.Scene);
  }
  public function Filter(v:Vector) : FilterResult {
    var f = this;//._clone();
    var w = f.Matrix.MulPositionW(v);
    if (!f.Scene.Visible(f.Eye,v)){
      return new FilterResult(w,false);
    }
    if (!ClipBox.Contains(w)){
      return new FilterResult(w,false);
    }
    return new FilterResult(w,true);
  }

}
