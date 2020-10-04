package ln;
import ln.Ln.*;
import ln.Ln.Op;
import ln.Ln.Direction;
import ln.Ln.Axis;
class Sphere implements Shape{
  public var Center : Vector = null;
  public var Radius : Float = 0.0;
  public var Box : Box = null;
  public function new (_Center:Vector=null,_Radius:Float=0.0,_Box:Box=null ){
    this.Center = _Center;
    this.Radius = _Radius;
    this.Box = _Box;
  }
  public function _clone (){
    return new Sphere(this.Center,this.Radius,this.Box);
  }
  public function Compile() : Void {
    var s = this._clone();
  }
  public function BoundingBox() : Box {
    var s = this._clone();
    return s.Box;
  }
  public function Contains(v:Vector, f:Float) : Bool {
    var s = this._clone();
    return v.Sub(s.Center).Length()<=s.Radius+f;
  }
  public function Intersect(r:Ray) : Hit {
    var s = this._clone();
    var radius = s.Radius;
    var to = r.Origin.Sub(s.Center);
    var b = to.Dot(r.Direction);
    var c = to.Dot(to)-radius*radius;
    var d = b*b-c;
    if (d>0){
      d = Math.sqrt(d);
      var t1 = -b-d;
      if (t1>1e-2){
        return new Hit(s,t1);
      }
      var t2 = -b+d;
      if (t2>1e-2){
        return new Hit(s,t2);
      }
    }
    return NoHit;
  }
  public function Paths4() : Paths {
    var s = this._clone();
    var paths:Paths = new Paths([]);
    var seen:Array<Vector> = [];
    var radii:Array<Float> = [];
    var i = 0;
    while (i<140){
      var v:Vector = null;
      var m:Float = 0.0;
      while (true){
        v = RandomUnitVector();
        m = Math.random()*0.25+0.05;
        var ok = true;
        var _veplk = seen;
        for (i in 0..._veplk.length){
          var other = _veplk[i];
          var threshold = m+radii[i]+0.02;
          if (other.Sub(v).Length()<threshold){
            ok = false;
            break;
          }
        }
        if (ok){
          seen = seen.concat([v]);
          radii = radii.concat([m]);
          break;
        }
      }
      var p = v.Cross(RandomUnitVector()).Normalize();
      var q = p.Cross(v).Normalize();
      var n = Std.random(4)+1;
      var k = 0;
      while (k<n){
        var path:Path = new Path([]);
        var j = 0;
        while (j<=360){
          var a = Radians((cast j));
          var x = v;
          x = x.Add(p.MulScalar(Math.cos(a)*m));
          x = x.Add(q.MulScalar(Math.sin(a)*m));
          x = x.Normalize();
          x = x.MulScalar(s.Radius).Add(s.Center);
          path = path.concat(new Path([x]));
          j+=5;
        }
        paths = paths.concat(new Paths([path]));
        m*=0.75;
        k++;
      }
      i++;
    }
    return paths;
  }
  public function Paths3() : Paths {
    var s = this._clone();
    var paths:Paths = new Paths([]);
    var i = 0;
    while (i<20000){
      var v = RandomUnitVector();
      v = v.MulScalar(s.Radius).Add(s.Center);
      paths = paths.concat(new Paths([new Path([v,v])]));
      i++;
    }
    return paths;
  }
  public function Paths2() : Paths {
    var s = this._clone();
    var equator:Path = new Path([]);
    var lng = 0;
    while (lng<=360){
      var v = LatLngToXYZ(0,(cast lng),s.Radius);
      equator = equator.concat(new Path([v]));
      lng++;
    }
    var paths:Paths = new Paths([]);
    var i = 0;
    while (i<100){
      var m = Identity();
      var j = 0;
      while (j<3){
        var v = RandomUnitVector();
        m = m.Rotate(v,Math.random()*2*Math.PI);
        j++;
      }
      m = m.Translate(s.Center);
      paths = paths.concat(new Paths([equator.Transform(m)]));
      i++;
    }
    return paths;
  }
  public function Paths() : Paths {
    var s = this._clone();
    var paths:Paths = new Paths([]);
    var n = 10;
    var o = 10;
    var lat = -90+o;
    while (lat<=90-o){
      var path:Path = new Path([]);
      var lng = 0;
      while (lng<=360){
        var v = LatLngToXYZ((cast lat),(cast lng),s.Radius).Add(s.Center);
        path = path.concat(new Path([v]));
        lng++;
      }
      paths = paths.concat(new Paths([path]));
      lat+=n;
    }
    var lng = 0;
    while (lng<=360){
      var path:Path = new Path([]);
      var lat = -90+o;
      while (lat<=90-o){
        var v = LatLngToXYZ((cast lat),(cast lng),s.Radius).Add(s.Center);
        path = path.concat(new Path([v]));
        lat++;
      }
      paths = paths.concat(new Paths([path]));
      lng+=n;
    }
    return paths;
  }

}
