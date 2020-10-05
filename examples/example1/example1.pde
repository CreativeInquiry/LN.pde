// https://github.com/fogleman/ln/blob/master/examples/example1.go

import ln.*;

Shape cube(float x, float y, float z){
  float size = 0.5;
  Vector v = new Vector(x,y,z);
  return Ln.NewCube(v.SubScalar(size),v.AddScalar(size));
}

void setup(){
  size(960,600);
  Scene scene = new Scene();
  for (int x = -2; x <= 2; x++){
    for (int y = -2; y <= 2; y++){
      float z = random(1);
      scene.Add(cube(x,y,z));
      
    }
    
  }
  Vector eye = new Vector(6,5,3);
  Vector center = new Vector(0,0,0);
  Vector up = new Vector(0,0,1);
  float fovy = 30;
  haxe.root.Array<haxe.root.Array<Vector>> paths;
  paths = scene.Render(eye, center, up, width, height, fovy, 0.1, 100, 0.01);
  
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
