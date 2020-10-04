package ln;
import ln.Ln.*;
import ln.Ln.Op;
import ln.Ln.Direction;
import ln.Ln.Axis;
class Function implements Shape{
  public var Function : Float->Float->Float = null;
  public var Box : Box = null;
  public var Direction : Direction;
  public function new (_Function:Float->Float->Float=null,_Box:Box=null,_Direction:Direction=0){
    this.Function = _Function;
    this.Box = _Box;
    this.Direction = _Direction;
  }
  public function _clone (){
    return new Function(this.Function,this.Box,this.Direction);
  }
  public function Compile() : Void {
    var f = this._clone();
  }
  public function BoundingBox() : Box {
    var f = this._clone();
    return f.Box;
  }
  public function Contains(v:Vector, eps:Float) : Bool {
    var f = this._clone();
    if (f.Direction==Below){
      return v.Z<f.Function(v.X,v.Y);
    }
    else{
      return v.Z>f.Function(v.X,v.Y);
    }
  }
  public function Intersect(ray:Ray) : Hit {
    var f = this._clone();
    var step = 1.0/64;
    var sign = f.Contains(ray.Position(step),0);
    var t = step;
    while (t<10){
      var v = ray.Position(t);
      if (f.Contains(v,0)!=sign&&f.Box.Contains(v)){
        return new Hit(f,t);
      }
      t+=step;
    }
    return NoHit;
  }
  public function Paths3() : Paths {
    var f = this._clone();
    var path:Path = null;
    var n = 10000;
    var i = 0;
    while (i<n){
      var t = (cast i)/(cast n);
      var r = 8-Math.pow(t,0.1)*8;
      var x = Math.cos(Radians(t*2*Math.PI*3000))*r;
      var y = Math.sin(Radians(t*2*Math.PI*3000))*r;
      var z = f.Function(x,y);
      z = Math.min(z,f.Box.Max.Z);
      z = Math.max(z,f.Box.Min.Z);
      path = path.concat(new Path([new Vector(x,y,z)]));
      i++;
    }
    return new Paths([path]);
  }
  public function Paths() : Paths {
    var f = this._clone();
    var paths:Paths = null;
    var fine = 1.0/256;
    var a = 0;
    while (a<360){
      var path:Path = null;
      var r = 0.0;
      while (r<=8.0){
        var x = Math.cos(Radians((cast a)))*r;
        var y = Math.sin(Radians((cast a)))*r;
        var z = f.Function(x,y);
        var o = -Math.pow(-z,1.4);
        x = Math.cos(Radians((cast a))-o)*r;
        y = Math.sin(Radians((cast a))-o)*r;
        z = Math.min(z,f.Box.Max.Z);
        z = Math.max(z,f.Box.Min.Z);
        path = path.concat(new Path([new Vector(x,y,z)]));
        r+=fine;
      }
      paths = paths.concat(new Paths([path]));
      a+=5;
    }
    return paths;
  }
  public function Paths1() : Paths {
    var f = this._clone();
    var paths:Paths = null;
    var step = 1.0/8;
    var fine = 1.0/64;
    var x = f.Box.Min.X;
    while (x<=f.Box.Max.X){
      var path:Path = null;
      var y = f.Box.Min.Y;
      while (y<=f.Box.Max.Y){
        var z = f.Function(x,y);
        z = Math.min(z,f.Box.Max.Z);
        z = Math.max(z,f.Box.Min.Z);
        path = path.concat(new Path([new Vector(x,y,z)]));
        y+=fine;
      }
      paths = paths.concat(new Paths([path]));
      x+=step;
    }
    var y = f.Box.Min.Y;
    while (y<=f.Box.Max.Y){
      var path:Path = null;
      var x = f.Box.Min.X;
      while (x<=f.Box.Max.X){
        var z = f.Function(x,y);
        z = Math.min(z,f.Box.Max.Z);
        z = Math.max(z,f.Box.Min.Z);
        path = path.concat(new Path([new Vector(x,y,z)]));
        x+=fine;
      }
      paths = paths.concat(new Paths([path]));
      y+=step;
    }
    return paths;
  }

}
