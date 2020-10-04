import ln.*;
import ln._Paths.*;

void setup(){
  size(1024,1024);
  
  // create a scene and add a single cube
  Scene scene =  new Scene();
  
  haxe.root.Array<Shape> group0 = new haxe.root.Array<Shape>();
  group0.push(Ln.NewSphere(new Vector(0,0,0), 1));
  group0.push(Ln.NewCube(new Vector(-0.8, -0.8, -0.8), new Vector(0.8, 0.8, 0.8)));
  Shape shape0 = Ln.NewIntersection(group0);
  
  haxe.root.Array<Shape> group1 = new haxe.root.Array<Shape>();
  group1.push(shape0);
  group1.push(Ln.NewCylinder(0.4, -2, 2));
  group1.push(Ln.NewTransformedShape(Ln.NewCylinder(0.4, -2, 2), Ln.Rotate(new Vector(1, 0, 0), Ln.Radians(90))));
  group1.push(Ln.NewTransformedShape(Ln.NewCylinder(0.4, -2, 2), Ln.Rotate(new Vector(0, 1, 0), Ln.Radians(90))));
  
  Shape shape = Ln.NewDifference(group1);
  
  scene.Add(shape);
  
  // define camera parameters
  Vector eye = new Vector(4, 3, 2);    // camera position
  Vector center = new Vector(0, 0, 0); // camera looks at
  Vector up = new Vector(0, 0, 1);     // up direction

  // define rendering parameters
  float fovy = 50.0;     // vertical field of view, degrees
  float znear = 0.1;     // near z plane
  float zfar = 10.0;     // far z plane
  float step = 0.01;     // how finely to chop the paths for visibility testing

  // compute 2D paths that depict the 3D scene
  haxe.root.Array<haxe.root.Array<Vector>> paths;
  paths =  scene.Render(eye, center, up, width, height, fovy, znear, zfar, step);

  // save the paths as an svg
  String svg = Paths_Impl_.ToSVG(paths,(double)width, (double)height);
  saveStrings(sketchPath("out.svg"),new String[]{svg});

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
