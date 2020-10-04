package ln;
typedef Axis = Int;
typedef Direction = Int;
typedef Op = Int;

class Ln{
  //package ln;
  //typedef Axis = Int;
  public static inline var AxisNone = 0;
  public static inline var AxisX = 1;
  public static inline var AxisY = 2;
  public static inline var AxisZ = 3;
  //package ln;
  public static function BoxForShapes(shapes:Array<Shape>) : Box {
    if ((shapes).length==0){
      return new Box();
    }
    var box = shapes[0].BoundingBox();
    var _xxdzt = shapes;
    for (_ in 0..._xxdzt.length){
      var shape = _xxdzt[_];
      box = box.Extend(shape.BoundingBox());
    }
    return box;
  }
  public static function BoxForTriangles(shapes:Array<Triangle>) : Box {
    if ((shapes).length==0){
      return new Box();
    }
    var box = shapes[0].BoundingBox();
    var _lywfo = shapes;
    for (_ in 0..._lywfo.length){
      var shape = _lywfo[_];
      box = box.Extend(shape.BoundingBox());
    }
    return box;
  }
  public static function BoxForVectors(vectors:Array<Vector>) : Box {
    if ((vectors).length==0){
      return new Box();
    }
    var min = vectors[0];
    var max = vectors[0];
    var _hblbg = vectors;
    for (_ in 0..._hblbg.length){
      var v = _hblbg[_];
      min = min.Min(v);
      max = max.Max(v);
    }
    return new Box(min,max);
  }
  //package ln;
  public static var INF = 1e9;
  public static var EPS = 1e-9;
  //package ln;
  public static function NewCone(radius:Float, height:Float) : Cone {
    return /*&*/new Cone(radius,height);
  }
  public static function NewOutlineCone(eye:Vector, up:Vector, radius:Float, height:Float) : OutlineCone {
    // var cone = NewCone(radius,height);
    return /*&*/new OutlineCone(radius,height,eye,up);
  }
  public static function NewTransformedOutlineCone(eye:Vector, up:Vector, v0:Vector, v1:Vector, radius:Float) : Shape {
    var d = v1.Sub(v0);
    var z = d.Length();
    var a = Math.acos(d.Normalize().Dot(up));
    var m = Translate(v0);
    if (a!=0){
      var u = d.Cross(up).Normalize();
      m = Rotate(u,a).Translate(v0);
    }
    var c = NewOutlineCone(m.Inverse().MulPosition(eye),up,radius,z);
    return NewTransformedShape(c,m);
  }
  //package ln;
  //typedef Op = Int;
  public static inline var Intersection:Op = 0;
  public static inline var Difference = 1;
  public static function NewBooleanShape(op:Op, shapes:Array<Shape>) : Shape {
    if ((shapes).length==0){
      return /*&*/new EmptyShape();
    }
    var shape = shapes[0];
    var i = 1;
    while (i<(shapes).length){
      shape = /*&*/new BooleanShape(op,shape,shapes[i]);
      i++;
    }
    return shape;
  }
  public static function NewIntersection(shapes:Array<Shape>) : Shape {
    return NewBooleanShape(Intersection,shapes);
  }
  public static function NewDifference(shapes:Array<Shape>) : Shape {
    return NewBooleanShape(Difference,shapes);
  }
  //package ln;
  public static function NewCube(min:Vector, max:Vector) : Cube {
    var box = new Box(min,max);
    return /*&*/new Cube(min,max,box);
  }
  //package ln;
  public static function NewCylinder(radius:Float, z0:Float, z1:Float) : Cylinder {
    return /*&*/new Cylinder(radius,z0,z1);
  }
  public static function NewOutlineCylinder(eye:Vector, up:Vector, radius:Float, z0:Float, z1:Float) : OutlineCylinder {
    // var cylinder = NewCylinder(radius,z0,z1);
    return /*&*/new OutlineCylinder(/***/radius,z0,z1,eye,up);
  }
  public static function NewTransformedOutlineCylinder(eye:Vector, up:Vector, v0:Vector, v1:Vector, radius:Float) : Shape {
    var d = v1.Sub(v0);
    var z = d.Length();
    var a = Math.acos(d.Normalize().Dot(up));
    var m = Translate(v0);
    if (a!=0){
      var u = d.Cross(up).Normalize();
      m = Rotate(u,a).Translate(v0);
    }
    var c = NewOutlineCylinder(m.Inverse().MulPosition(eye),up,radius,0,z);
    return NewTransformedShape(c,m);
  }
  //package ln;
  public static var ClipBox = new Box(new Vector(-1,-1,-1),new Vector(1,1,1));
  //package ln;
  //typedef Direction = Int;
  public static var Above:Direction = 0;
  public static var Below = 1;
  public static function NewFunction(_function:Float->Float->Float, box:Box, direction:Direction) : Shape {
    return /*&*/new Function(_function,box,direction);
  }
  //package ln;
  public static var NoHit = new Hit(null,INF);
  //package ln;
  public static function Identity() : Matrix {
    return new Matrix(1,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1);
  }
  public static function Translate(v:Vector) : Matrix {
    return new Matrix(1,0,0,v.X,0,1,0,v.Y,0,0,1,v.Z,0,0,0,1);
  }
  public static function Scale(v:Vector) : Matrix {
    return new Matrix(v.X,0,0,0,0,v.Y,0,0,0,0,v.Z,0,0,0,0,1);
  }
  public static function Rotate(v:Vector, a:Float) : Matrix {
    v = v.Normalize();
    var s = Math.sin(a);
    var c = Math.cos(a);
    var m = 1-c;
    return new Matrix(m*v.X*v.X+c,m*v.X*v.Y+v.Z*s,m*v.Z*v.X-v.Y*s,0,m*v.X*v.Y-v.Z*s,m*v.Y*v.Y+c,m*v.Y*v.Z+v.X*s,0,m*v.Z*v.X+v.Y*s,m*v.Y*v.Z-v.X*s,m*v.Z*v.Z+c,0,0,0,0,1);
  }
  public static function Frustum(l:Float, r:Float, b:Float, t:Float, n:Float, f:Float) : Matrix {
    var t1 = 2*n;
    var t2 = r-l;
    var t3 = t-b;
    var t4 = f-n;
    return new Matrix(t1/t2,0,(r+l)/t2,0,0,t1/t3,(t+b)/t3,0,0,0,(-f-n)/t4,(-t1*f)/t4,0,0,-1,0);
  }
  public static function Orthographic(l:Float, r:Float, b:Float, t:Float, n:Float, f:Float) : Matrix {
    return new Matrix(2/(r-l),0,0,-(r+l)/(r-l),0,2/(t-b),0,-(t+b)/(t-b),0,0,-2/(f-n),-(f+n)/(f-n),0,0,0,1);
  }
  public static function Perspective(fovy:Float, aspect:Float, near:Float, far:Float) : Matrix {
    var ymax = near*Math.tan(fovy*Math.PI/360);
    var xmax = ymax*aspect;
    return Frustum(-xmax,xmax,-ymax,ymax,near,far);
  }
  public static function LookAt(eye:Vector, center:Vector, up:Vector) : Matrix {
    up = up.Normalize();
    var f = center.Sub(eye).Normalize();
    var s = f.Cross(up).Normalize();
    var u = s.Cross(f).Normalize();
    var m = new Matrix(s.X,u.X,-f.X,eye.X,s.Y,u.Y,-f.Y,eye.Y,s.Z,u.Z,-f.Z,eye.Z,0,0,0,1);
    return m.Inverse();
  }
  //package ln;
  public static function NewMesh(triangles:Array<Triangle>) : Mesh {
    var box = BoxForTriangles(triangles);
    return /*&*/new Mesh(box,triangles,null);
  }
  //package ln;
  //import bufio;
  //import os;
  //import strconv;
  //import strings;
  public static function parseIndex(value:String, length:Int) : Int {
    var n = Std.parseInt(value);
    if (n<0){
      n+=length;
    }
    return n;
  }
  public static inline function StringFields(line:String){
    return line.split(" ").map(StringTools.trim);
  }
  public static function LoadOBJ(objstr:String) : Mesh {
    var vs = [];
    var triangles:Array<Triangle> = [];
    var lines = objstr.split("\n");
    for (line in lines){
      var fields = StringFields(line);
      if ((fields).length==0){
        continue;
      }
      var keyword = fields[0];
      var args = fields.slice(1);
      switch (keyword) {
      case "v":
        var f = ParseFloats(args);
        var v = new Vector(f[0],f[1],f[2]);
        vs = vs.concat([v]);
      case "f":
        var fvs = [];
        var _wpaaa = args;
        for (i in 0..._wpaaa.length){
          var arg = _wpaaa[i];
          var vertex = (arg+"//").split("/");
          fvs[i] = parseIndex(vertex[0],(vs).length);
        }
        var i = 1;
        while (i<(fvs).length-1){
          var i1 = 0;
          var i2 = i;
          var i3 = i+1;
          var t = NewTriangle(vs[fvs[i1]],vs[fvs[i2]],vs[fvs[i3]]);
          triangles = triangles.concat([t]);
          i++;
        }
      }
    }
    return NewMesh(triangles);
  }
  //package ln;
  //import fmt;
  //import io.ioutil;
  //import strings;
  //typedef Path = Array<Vector>;
  //typedef Paths = Array<Path>;
  //package ln;
  //package ln;
  //package ln;
  //package ln;
  public static function NewTransformedShape(s:Shape, m:Matrix) : Shape {
    return /*&*/new TransformedShape(s,m,m.Inverse());
  }
  //package ln;
  //import math;
  //import math.rand;
  public static function NewSphere(center:Vector, radius:Float) : Sphere {
    var min = new Vector(center.X-radius,center.Y-radius,center.Z-radius);
    var max = new Vector(center.X+radius,center.Y+radius,center.Z+radius);
    var box = new Box(min,max);
    return /*&*/new Sphere(center,radius,box);
  }
  public static function LatLngToXYZ(lat:Float, lng:Float, radius:Float) : Vector {
    lat = Radians(lat);
    lng = Radians(lng);
    var x = radius*Math.cos(lat)*Math.cos(lng);
    var y = radius*Math.cos(lat)*Math.sin(lng);
    var z = radius*Math.sin(lat);
    return new Vector(x,y,z);
  }
  public static function NewOutlineSphere(eye:Vector, up:Vector, center:Vector, radius:Float) : OutlineSphere {
    // var sphere = NewSphere(center,radius);
    return /*&*/new OutlineSphere(center,radius,eye,up);
  }
  //package ln;
  //import bufio;
  //import encoding.binary;
  //import fmt;
  //import os;
  //import strings;

  public static function LoadSTL(stlstr:String) : Mesh {
    trace("Loading STL (ASCII)");

    var vertexes:Array<Vector> = [];
    var lines = stlstr.split("\n");
    for (line in lines){
      var fields = StringFields(line);
      if ((fields).length==4&&fields[0]=="vertex"){
        var f = ParseFloats(fields.slice(1));
        var v = new Vector(f[0],f[1],f[2]);
        vertexes = vertexes.concat([v]);
      }
    }
    var triangles:Array<Triangle> = [];
    var i = 0;
    while (i<(vertexes).length){
      var t = new Triangle();
      t.V1 = vertexes[i+0];
      t.V2 = vertexes[i+1];
      t.V3 = vertexes[i+2];
      t.UpdateBoundingBox();
      triangles = triangles.concat([/*&*/t]);
      i+=3;
    }

    return NewMesh(triangles);
  }
  //package ln;
  //import math;
  //import sort;
  public static function NewTree(shapes:Array<Shape>) : Tree {
    var box = BoxForShapes(shapes);
    var node = NewNode(shapes);
    node.Split(0);
    return /*&*/new Tree(box,node);
  }
  public static function NewNode(shapes:Array<Shape>) : Node {
    return /*&*/new Node(AxisNone,0,shapes,null,null);
  }
  //package ln;
  public static function NewTriangle(v1:Vector, v2:Vector, v3:Vector) : Triangle {
    var t = new Triangle();
    t.V1 = v1;
    t.V2 = v2;
    t.V3 = v3;
    t.UpdateBoundingBox();
    return /*&*/t;
  }
  //package ln;
  //import math;
  //import strconv;
  public static function Radians(degrees:Float) : Float {
    return degrees*Math.PI/180;
  }
  public static function Degrees(radians:Float) : Float {
    return radians*180/Math.PI;
  }
  public static function Median(items:Array<Float>) : Float {
    var n = (items).length;
    if (n==0){
      return 0;
    }
    else if (n%2==1){
      return items[Std.int(n/2)];
    }
    else{
      var a = items[Std.int(n/2-1)];
      var b = items[Std.int(n/2)];
      return (a+b)/2;
    }
  }
  public static function ParseFloats(items:Array<String>) : Array<Float> {
    var result = [];
    var _bbwdk = items;
    for (i in 0..._bbwdk.length){
      var item = _bbwdk[i];
      result[i] = Std.parseFloat(item);
    }
    return result;
  }
  //package ln;
  //import math;
  //import math.rand;
  public static function RandomUnitVector() : Vector {
    while (true){
      var x = Math.random()*2-1;
      var y = Math.random()*2-1;
      var z = Math.random()*2-1;
      if (x*x+y*y+z*z>1){
        continue;
      }
      return new Vector(x,y,z).Normalize();
    }
  }
  
}