// https://github.com/fogleman/ln/blob/master/examples/function.go

import ln.*;

class Fun extends haxe.lang.Function{
  public Fun(){
    super(2,0);
  }
  @Override
  public double __hx_invoke2_f(double x, Object _, double y, Object __){
    return -1 / (x* x + y * y);
    // return math.Cos(x*y) * (x*x - y*y)
  }
}

Fun fun = new Fun();


void setup(){

  size(1024,1024);
  Scene scene = new Scene();
  Box box = new Box(new Vector(-2,-2,-4), new Vector(2,2,2));
  scene.Add(Ln.NewFunction(fun,box,Ln.Below));
  Vector eye = new Vector(3,0,3);
  Vector center = new Vector(1.1,0,0);
  Vector up = new Vector(0,0,1);
  
  haxe.root.Array<haxe.root.Array<Vector>> paths;
  paths = scene.Render(eye, center, up, width, height, 50, 0.1, 100, 0.01);
  
  String svg = ln._Paths.Paths_Impl_.ToSVG(paths,(double)width, (double)height);
  saveStrings(sketchPath("out.svg"),new String[]{svg});
  drawPaths(paths);
}

void drawPaths(haxe.root.Array<haxe.root.Array<Vector>> paths){
  noFill();
  for (int i = 0; i < paths.length; i++){
    beginShape();
    for (int j = 0; j < paths.__get(i).length; j++){
      Vector v = paths.__get(i).__get(j);
      vertex((float)v.X,height-(float)v.Y);
    }
    endShape();
  }  
}
