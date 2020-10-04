package ln;
import ln.Ln.*;
import ln.Ln.Op;
import ln.Ln.Direction;
import ln.Ln.Axis;

abstract Paths (Array<Path>){
  public function new(data:Array<Path>){
    this = data;
  }
  public function BoundingBox() : Box {
    var p = this;
    var box = p[0].BoundingBox();
    var _cvvol = p;
    for (_ in 0..._cvvol.length){
      var path = _cvvol[_];
      box = box.Extend(path.BoundingBox());
    }
    return box;
  }
  public function _raw() : Array<Path>{
    return this;
  }
  public function concat(other:Paths){
    return new Paths(this.concat(other._raw()));
  }
  public function Transform(matrix:Matrix) : Paths {
    var p = this;
    var result:Paths = new Paths([]);
    var _xdcfw = p;
    for (_ in 0..._xdcfw.length){
      var path = _xdcfw[_];
      result = result.concat(new Paths([path.Transform(matrix)]));
    }
    return result;
  }
  public function Chop(step:Float) : Paths {
    var p = this;
    var result:Paths = new Paths([]);
    var _ncdtf = p;
    for (_ in 0..._ncdtf.length){
      var path = _ncdtf[_];
      result = result.concat(new Paths([path.Chop(step)]));
    }
    return result;
  }
  public function Filter(f:Filter) : Paths {
    var p = this;
    var result:Paths = new Paths([]);
    var _zbfhq = p;
    for (_ in 0..._zbfhq.length){
      var path = _zbfhq[_];
      result = result.concat(path.Filter(f));
    }
    return result;
  }
  public function Simplify(threshold:Float) : Paths {
    var p = this;
    var result:Paths = new Paths([]);
    var _pcxdb = p;
    for (_ in 0..._pcxdb.length){
      var path = _pcxdb[_];
      result = result.concat(new Paths([path.Simplify(threshold)]));
    }
    return result;
  }
  public function Print() : Void {
    var p = this;
    var _dgrwx = p;
    for (_ in 0..._dgrwx.length){
      var path = _dgrwx[_];
      path.Print();
    }
  }
  public function String() : String {
    var p = this;
    var parts:Array<String> = [];
    var _bgbej = p;
    for (_ in 0..._bgbej.length){
      var path = _bgbej[_];
      parts = parts.concat([path.String()]);
    }
    return parts.join("\n");
  }
  public function ToSVG(width:Float, height:Float) : String {
    var p = this;
    var lines:Array<String> = [];
    lines.push('<svg width=\"${width}\" height=\"${height}\" version=\"1.1\" baseProfile=\"full\" xmlns=\"http://www.w3.org/2000/svg\">');
    lines.push('<g transform=\"translate(0,${height}) scale(1,-1)\">');
    var _ztlmi = p;
    for (_ in 0..._ztlmi.length){
      var path = _ztlmi[_];
      lines = lines.concat([path.ToSVG()]);
    }
    lines = lines.concat(["</g></svg>"]);
    return lines.join("\n");
  }
}
