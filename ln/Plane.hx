package ln;
import ln.Ln.*;
import ln.Ln.Op;
import ln.Ln.Direction;
import ln.Ln.Axis;
class Plane {
  public var Point : Vector = null;
  public var Normal : Vector = null;
  public function new (_Point:Vector=null,_Normal:Vector=null ){
    this.Point = _Point;
    this.Normal = _Normal;
  }
  public function _clone (){
    return new Plane(this.Point,this.Normal);
  }
  public function IntersectSegment(v0:Vector, v1:Vector) : Array<Dynamic> {
    var p = this._clone();
    var u = v1.Sub(v0);
    var w = v0.Sub(p.Point);
    var d = p.Normal.Dot(u);
    var n = -p.Normal.Dot(w);
    if (d>-EPS&&d<EPS){
      var _rqucs : Array<Dynamic> = [new Vector(),false];
      return _rqucs;
    }
    var t = n/d;
    if (t<0||t>1){
      var _sxgpk : Array<Dynamic> = [new Vector(),false];
      return _sxgpk;
    }
    var v = v0.Add(u.MulScalar(t));
    var _bpapg : Array<Dynamic> = [v,true];
    return _bpapg;
  }
  public function IntersectTriangle(t:Triangle) : Array<Dynamic> {
    var p = this._clone();
    var _xpabx : Array<Dynamic> = p.IntersectSegment(t.V1,t.V2);
    var v1 = _xpabx[0];
    var ok1 = _xpabx[1];
    var _ewobt : Array<Dynamic> = p.IntersectSegment(t.V2,t.V3);
    var v2 = _ewobt[0];
    var ok2 = _ewobt[1];
    var _wjduk : Array<Dynamic> = p.IntersectSegment(t.V3,t.V1);
    var v3 = _wjduk[0];
    var ok3 = _wjduk[1];
    if (ok1&&ok2){
      var _hvbgm : Array<Dynamic> = [v1,v2,true];
      return _hvbgm;
    }
    if (ok1&&ok3){
      var _rksae : Array<Dynamic> = [v1,v3,true];
      return _rksae;
    }
    if (ok2&&ok3){
      var _xgvzu : Array<Dynamic> = [v2,v3,true];
      return _xgvzu;
    }
    var _bgfau : Array<Dynamic> = [new Vector(),new Vector(),false];
    return _bgfau;
  }
  public function IntersectMesh(m:Mesh) : Paths {
    var p = this._clone();
    var result:Paths = null;
    var _onzfo = m.Triangles;
    for (_ in 0..._onzfo.length){
      var t = _onzfo[_];
      var _zqjiu : Array<Dynamic> = p.IntersectTriangle(t);
      var v1 = _zqjiu[0];
      var v2 = _zqjiu[1];
      var ok = _zqjiu[2];
      if (ok){
        result = result.concat(new Paths([new Path([v1,v2])]));
      }
    }
    return result;
  }

}
