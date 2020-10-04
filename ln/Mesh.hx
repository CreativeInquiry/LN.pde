package ln;
import ln.Ln.*;
import ln.Ln.Op;
import ln.Ln.Direction;
import ln.Ln.Axis;

class Mesh implements Shape{
  public var Box : Box = null;
  public var Triangles : Array<Triangle> = [];
  public var Tree : Tree = null;
  public function new (_Box:Box=null,_Triangles:Array<Triangle>,_Tree:Tree=null ){
    this.Box = _Box;
    this.Triangles = _Triangles;
    this.Tree = _Tree;
  }
  public function _clone (){
    return new Mesh(this.Box,this.Triangles,this.Tree);
  }
  public function Compile() : Void {
    var m = this._clone();
    if (m.Tree==null){
      var shapes = [];
      var _juyfg = m.Triangles;
      for (i in 0..._juyfg.length){
        var triangle = _juyfg[i];
        shapes[i] = triangle;
      }
      m.Tree = NewTree(cast shapes);
    }
  }
  public function BoundingBox() : Box {
    var m = this._clone();
    return m.Box;
  }
  public function Contains(v:Vector, f:Float) : Bool {
    var m = this._clone();
    return false;
  }
  public function Intersect(r:Ray) : Hit {
    var m = this._clone();
    return m.Tree.Intersect(r);
  }
  public function Paths() : Paths {
    var m = this._clone();
    var result:Paths = null;
    var _ntazc = m.Triangles;
    for (_ in 0..._ntazc.length){
      var t = _ntazc[_];
      result = result.concat(t.Paths());
    }
    return result;
  }
  public function UpdateBoundingBox() : Void {
    var m = this._clone();
    m.Box = BoxForTriangles(m.Triangles);
  }
  public function UnitCube() : Void {
    var m = this._clone();
    m.FitInside(new Box(new Vector(),new Vector(1,1,1)),new Vector());
    m.MoveTo(new Vector(),new Vector(0.5,0.5,0.5));
  }
  public function MoveTo(position:Vector, anchor:Vector) : Void {
    var m = this._clone();
    var matrix = Translate(position.Sub(m.Box.Anchor(anchor)));
    m.Transform(matrix);
  }
  public function FitInside(box:Box, anchor:Vector) : Void {
    var m = this._clone();
    var scale = box.Size().Div(m.BoundingBox().Size()).MinComponent();
    var extra = box.Size().Sub(m.BoundingBox().Size().MulScalar(scale));
    var matrix = Identity();
    matrix = matrix.Translate(m.BoundingBox().Min.MulScalar(-1));
    matrix = matrix.Scale(new Vector(scale,scale,scale));
    matrix = matrix.Translate(box.Min.Add(extra.Mul(anchor)));
    m.Transform(matrix);
  }
  public function Transform(matrix:Matrix) : Void {
    var m = this._clone();
    var _ukkos = m.Triangles;
    for (_ in 0..._ukkos.length){
      var t = _ukkos[_];
      t.V1 = matrix.MulPosition(t.V1);
      t.V2 = matrix.MulPosition(t.V2);
      t.V3 = matrix.MulPosition(t.V3);
      t.UpdateBoundingBox();
    }
    m.UpdateBoundingBox();
    m.Tree = null;
  }

  public function Voxelize(size:Float) : Array<Cube> {
    var m = this._clone();
    var z1 = m.Box.Min.Z;
    var z2 = m.Box.Max.Z;
    var set = new Map<Vector,Bool>();
    var z = z1;
    while (z<=z2){
      var plane = new Plane(new Vector(0,0,z),new Vector(0,0,1));
      var paths = plane.IntersectMesh(m);
      var _gbzya = paths;
      for (_ in 0..._gbzya._raw().length){
        var path = _gbzya._raw()[_];
        var _uxiel = path;
        for (_1 in 0..._uxiel._raw().length){
          var v = _uxiel._raw()[_1];
          var x = Math.floor(v.X/size+0.5)*size;
          var y = Math.floor(v.Y/size+0.5)*size;
          var z = Math.floor(v.Z/size+0.5)*size;
          set[new Vector(x,y,z)] = true;
        }
      }
      z+=size;
    }
    var result:Array<Cube> = [];

    for (v=>b in set){
      var cube = NewCube(v.SubScalar(size/2),v.AddScalar(size/2));
      result = result.concat([cube]);
    }
    return result;
  }

}
