package ln;
import ln.Ln.*;
import ln.Ln.Op;
import ln.Ln.Direction;
import ln.Ln.Axis;

class Node {
  public var Axis : Axis;
  public var Point : Float = 0.0;
  public var Shapes : Array<Shape> = [];
  public var Left : Node = null;
  public var Right : Node = null;
  public function new (_Axis:Axis=null,_Point:Float=0.0,_Shapes:Array<Shape>,_Left:Node=null,_Right:Node=null ){
    this.Axis = _Axis;
    this.Point = _Point;
    this.Shapes = _Shapes;
    this.Left = _Left;
    this.Right = _Right;
  }
  public function _clone (){
    return new Node(this.Axis,this.Point,this.Shapes,this.Left,this.Right);
  }
  public function Intersect(r:Ray, tmin:Float, tmax:Float) : Hit {
    var node = this._clone();
    var tsplit:Float = 0.0;
    var leftFirst:Bool = false;
    switch (node.Axis) {
    case AxisNone:
      return node.IntersectShapes(r);
    case AxisX:
      tsplit = (node.Point-r.Origin.X)/r.Direction.X;
      leftFirst = (r.Origin.X<node.Point)||(r.Origin.X==node.Point&&r.Direction.X<=0);
    case AxisY:
      tsplit = (node.Point-r.Origin.Y)/r.Direction.Y;
      leftFirst = (r.Origin.Y<node.Point)||(r.Origin.Y==node.Point&&r.Direction.Y<=0);
    case AxisZ:
      tsplit = (node.Point-r.Origin.Z)/r.Direction.Z;
      leftFirst = (r.Origin.Z<node.Point)||(r.Origin.Z==node.Point&&r.Direction.Z<=0);
    }
    var first : Node = null;
    var second : Node = null;
    if (leftFirst){
      first = node.Left;
      second = node.Right;
    }
    else{
      first = node.Right;
      second = node.Left;
    }
    if (tsplit>tmax||tsplit<=0){
      return first.Intersect(r,tmin,tmax);
    }
    else if (tsplit<tmin){
      return second.Intersect(r,tmin,tmax);
    }
    else{
      var h1 = first.Intersect(r,tmin,tsplit);
      if (h1.T<=tsplit){
        return h1;
      }
      var h2 = second.Intersect(r,tsplit,Math.min(tmax,h1.T));
      if (h1.T<=h2.T){
        return h1;
      }
      else{
        return h2;
      }
    }
  }
  public function IntersectShapes(r:Ray) : Hit {
    var node = this._clone();
    var hit = NoHit;
    var _iuvqe = node.Shapes;
    for (_ in 0..._iuvqe.length){
      var shape = _iuvqe[_];
      var h = shape.Intersect(r);
      if (h.T<hit.T){
        hit = h;
      }
    }
    return hit;
  }
  public function PartitionScore(axis:Axis, point:Float) : Int {
    var node = this._clone();
    var left = 0;
    var right = 0;
    var _nvzky = node.Shapes;
    for (_ in 0..._nvzky.length){
      var shape = _nvzky[_];
      var box = shape.BoundingBox();
      var _ndsmo : Array<Dynamic> = box.Partition(axis,point);
      var l = _ndsmo[0];
      var r = _ndsmo[1];
      if (l){
        left++;
      }
      if (r){
        right++;
      }
    }
    if (left>=right){
      return left;
    }
    else{
      return right;
    }
  }
  public function Partition(size:Int, axis:Axis, point:Float) : Array<Dynamic> {
    var node = this._clone();
    var left : Array<Shape> = [];
    var right : Array<Shape> = [];
    left = [];
    right = [];
    var _zvmyf = node.Shapes;
    for (_ in 0..._zvmyf.length){
      var shape = _zvmyf[_];
      var box = shape.BoundingBox();
      var _kghax : Array<Dynamic> = box.Partition(axis,point);
      var l = _kghax[0];
      var r = _kghax[1];
      if (l){
        left = left.concat([shape]);
      }
      if (r){
        right = right.concat([shape]);
      }
    }
    var _fzwts : Array<Dynamic> = [left,right];
    return _fzwts;
  }
  public function Split(depth:Int) : Void {
    var node = this._clone();
    if ((node.Shapes).length<8){
      return ;
    }
    var xs = [];
    var ys = [];
    var zs = [];
    var _hhmne = node.Shapes;
    for (_ in 0..._hhmne.length){
      var shape = _hhmne[_];
      var box = shape.BoundingBox();
      xs = xs.concat([box.Min.X]);
      xs = xs.concat([box.Max.X]);
      ys = ys.concat([box.Min.Y]);
      ys = ys.concat([box.Max.Y]);
      zs = zs.concat([box.Min.Z]);
      zs = zs.concat([box.Max.Z]);
    }
    xs.sort((a, b) -> a<b?-1:(a>b?1:0));
    ys.sort((a, b) -> a<b?-1:(a>b?1:0));
    zs.sort((a, b) -> a<b?-1:(a>b?1:0));
    var mx = Median(xs);
    var my = Median(ys);
    var mz = Median(zs);
    var best = (cast (cast (node.Shapes).length)*0.85);
    var bestAxis = AxisNone;
    var bestPoint = 0.0;
    var sx = node.PartitionScore(AxisX,mx);
    if (sx<best){
      best = sx;
      bestAxis = AxisX;
      bestPoint = mx;
    }
    var sy = node.PartitionScore(AxisY,my);
    if (sy<best){
      best = sy;
      bestAxis = AxisY;
      bestPoint = my;
    }
    var sz = node.PartitionScore(AxisZ,mz);
    if (sz<best){
      best = sz;
      bestAxis = AxisZ;
      bestPoint = mz;
    }
    if (bestAxis==AxisNone){
      return ;
    }
    var _odxxe : Array<Dynamic> = node.Partition(best,bestAxis,bestPoint);
    var l = _odxxe[0];
    var r = _odxxe[1];
    node.Axis = bestAxis;
    node.Point = bestPoint;
    node.Left = NewNode(l);
    node.Right = NewNode(r);
    node.Left.Split(depth+1);
    node.Right.Split(depth+1);
    node.Shapes = null;
  }

}
