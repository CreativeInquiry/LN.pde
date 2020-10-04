package ln;
import ln.Ln.*;
import ln.Ln.Op;
import ln.Ln.Direction;
import ln.Ln.Axis;

abstract Path (Array<Vector>){
  public function new(data:Array<Vector>){
    this = data;
  }
  public function _raw():Array<Vector>{
    return this;
  }
  public function BoundingBox() : Box {
    var p = this;
    var box = new Box(p[0],p[0]);
    var _cdvok = p;
    for (_ in 0..._cdvok.length){
      var v = _cdvok[_];
      box = box.Extend(new Box(v,v));
    }
    return box;
  }
  public function concat(other:Path){
    return new Path(this.concat(other._raw()));
  }
  public function Transform(matrix:Matrix) : Path {
    var p = this;
    var result:Path = new Path([]);
    var _exqql = p;
    for (_ in 0..._exqql.length){
      var v = _exqql[_];
      result = result.concat(new Path([matrix.MulPosition(v)]));
    }
    return result;
  }
  public function Chop(step:Float) : Path {
    var p = this;
    var result:Path = new Path([]);
    var i = 0;
    while (i<(p).length-1){
      var a = p[i];
      var b = p[i+1];
      var v = b.Sub(a);
      var l = v.Length();
      if (i==0){
        result = result.concat(new Path([a]));
      }
      var d = step;
      while (d<l){
        result = result.concat(new Path([a.Add(v.MulScalar(d/l))]));
        d+=step;
      }
      result = result.concat(new Path([b]));
      i++;
    }
    return result;
  }
  public function Filter(f:Filter) : Paths {
    var p = this;
    var result:Paths = new Paths([]);
    var path:Path = new Path([]);
    var _sbbcu = p;
    for (_ in 0..._sbbcu.length){
      var v = _sbbcu[_];
      var _ymuir : Array<Dynamic> = f.Filter(v);
      var v = _ymuir[0];
      var ok = _ymuir[1];
      if (ok){
        path = path.concat(new Path([v]));
      }
      else{
        if ((path)._raw().length>1){
          result = result.concat(new Paths([path]));
        }
        path = new Path([]);
      }
    }
    if ((path)._raw().length>1){
      result = result.concat(new Paths([path]));
    }
    return result;
  }
  public function Simplify(threshold:Float) : Path {
    var p = this;
    if ((p).length<3){
      return new Path(p);
    }
    var a = p[0];
    var b = p[(p).length-1];
    var index = -1;
    var distance = 0.0;
    var i = 1;
    while (i<(p).length-1){
      var d = p[i].SegmentDistance(a,b);
      if (d>distance){
        index = i;
        distance = d;
      }
      i++;
    }
    if (distance>threshold){
      var r1 = new Path(p.slice(0,index+1)).Simplify(threshold);
      var r2 = new Path(p.slice(index)).Simplify(threshold);
      return new Path(r1._raw().slice(0,(r1)._raw().length-1).concat(r2._raw()));
    }
    else{
      return new Path([a,b]);
    }
  }
  public function Print() : Void {
    var p = this;
    var _wiifh = p;
    for (_ in 0..._wiifh.length){
      var v = _wiifh[_];
      trace('${v.X},${v.Y};');
    }
    trace("");
  }
  public function String() : String {
    var p = this;
    var parts:Array<String> = [];
    var _arugh = p;
    for (_ in 0..._arugh.length){
      var v = _arugh[_];
      parts = parts.concat(['${v.X},${v.Y}']);
    }
    return parts.join(";");
  }
  public function ToSVG() : String {
    var p = this;
    var coords:Array<String> = [];
    var _pjwzf = p;
    for (_ in 0..._pjwzf.length){
      var v = _pjwzf[_];
      coords = coords.concat(['${v.X},${v.Y}']);
    }
    var points = coords.join(" ");
    return '<polyline stroke=\"black\" fill=\"none\" points=\"${points}\" />';
  }

}
