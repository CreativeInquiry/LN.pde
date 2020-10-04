package ln;
import ln.Ln.*;
import ln.Ln.Op;
import ln.Ln.Direction;
import ln.Ln.Axis;
class Scene {
  public var Shapes : Array<Shape> = [];
  public var Tree : Tree = null;
  public function new (){
  }

  public function Compile() : Void {
    var s = this;
    var _fjilh = s.Shapes;
    for (_ in 0..._fjilh.length){
      var shape = _fjilh[_];
      shape.Compile();
    }
    if (s.Tree==null){
      s.Tree = NewTree(s.Shapes);
    }
  }
  public function Add(shape:Shape) : Void {
    var s = this;
    s.Shapes = s.Shapes.concat([shape]);
  }
  public function Intersect(r:Ray) : Hit {
    var s = this;
    return s.Tree.Intersect(r);
  }
  public function Visible(eye:Vector, point:Vector) : Bool {
    var s = this;
    var v = eye.Sub(point);
    var r = new Ray(point,v.Normalize());
    var hit = s.Intersect(r);
  
    return hit.T>=v.Length();
  }
  public function Paths() : Paths {
    var s = this;
    var result:Paths = new Paths([]);
    var _rddsn = s.Shapes;
    for (_ in 0..._rddsn.length){
      var shape = _rddsn[_];
      result = result.concat(shape.Paths());
    }
    return result;
  }
  public function Render(eye:Vector, center:Vector, up:Vector, width:Float, height:Float, fovy:Float, near:Float, far:Float, step:Float) : Paths {
    var s = this;
    var aspect = width/height;
    var matrix = LookAt(eye,center,up);
    matrix = matrix.Perspective(fovy,aspect,near,far);
    return s.RenderWithMatrix(matrix,eye,width,height,step);
  }
  public function RenderWithMatrix(matrix:Matrix, eye:Vector, width:Float, height:Float, step:Float) : Paths {
    var s = this;
    s.Compile();
    var paths = s.Paths();
    if (step>0){
      paths = paths.Chop(step);
    }
    paths = paths.Filter(/*&*/new ClipFilter(matrix,eye,s));
    if (step>0){
      paths = paths.Simplify(1e-6);
    }

    matrix = Translate(new Vector(1,1,0)).Scale(new Vector(width/2,height/2,0));
    paths = paths.Transform(matrix);
    return paths;
  }

}
