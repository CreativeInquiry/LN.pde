import ln.*;
import ln._Paths.*;

void setup(){
  size(1024,1024);
  
  // create a scene and add a single cube
  Scene scene =  new Scene();
  scene.Add(Ln.NewCube(new Vector(-1,-1,-1),new Vector(1,1,1)));
  //scene.Add(Ln.NewCube(new Vector(-2,-1,-1),new Vector(1,1,1)));
  
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

  for (int i = 0; i < paths.length; i++){
    beginShape();
    for (int j = 0; j < paths.__get(i).length; j++){
      Vector v = paths.__get(i).__get(j);
      vertex((float)v.X,height-(float)v.Y);
    }
    endShape();
  }
}
