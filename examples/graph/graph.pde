//https://github.com/fogleman/ln/blob/master/examples/graph.go

import ln.*;
import ln._Paths.*;

void render(int frame) {
  float cx = cos(radians(float(frame)));
  float cy = sin(radians(float(frame)));
  Scene scene = new Scene();
  Vector eye = new Vector(cx, cy, 0).MulScalar(8);
  Vector center = new Vector(0, 0, 0);
  Vector up = new Vector(0, 0, 1);

  Vector[] nodes = new Vector[]{
    new Vector(1.047, -0.000, -1.312),
    new Vector(-0.208, -0.000, -1.790),
    new Vector(2.176, 0.000, -2.246),
    new Vector(1.285, -0.001, 0.016),
    new Vector(-1.276, -0.000, -0.971),
    new Vector(-0.384, 0.000, -2.993),
    new Vector(-2.629, -0.000, -1.533),
    new Vector(-1.098, -0.000, 0.402),
    new Vector(0.193, 0.005, 0.911),
    new Vector(-1.934, -0.000, 1.444),
    new Vector(2.428, -0.000, 0.437),
    new Vector(0.068, -0.000, 2.286),
    new Vector(-1.251, -0.000, 2.560),
    new Vector(1.161, -0.000, 3.261),
    new Vector(1.800, 0.001, -3.269),
    new Vector(2.783, 0.890, -2.082),
    new Vector(2.783, -0.889, -2.083),
    new Vector(-2.570, -0.000, -2.622),
    new Vector(-3.162, -0.890, -1.198),
    new Vector(-3.162, 0.889, -1.198),
    new Vector(-1.679, 0.000, 3.552),
    new Vector(1.432, -1.028, 3.503),
    new Vector(2.024, 0.513, 2.839),
    new Vector(0.839, 0.513, 4.167),
    // new Vector(0.000000, 0.000000, 0.000000),
    // new Vector(0.000000, 0.000000, 1.089000),
    // new Vector(1.026719, 0.000000, -0.363000),
    // new Vector(-0.513360, -0.889165, -0.363000),
    // new Vector(-0.513360, 0.889165, -0.363000),
    //
    // new Vector(0, 0, 0),
    // new Vector(-1, 0, 0),
    // new Vector(1, 0, 0),
    // new Vector(0, 1, 0),
    // new Vector(0, -1, 0),
    // new Vector(0, 0, 1),
    // new Vector(0, 0, -1),
    //
    // new Vector(-1, 1, 1),
    // new Vector(-1, 1, -1),
    // new Vector(-1, -1, 1),
    // new Vector(-1, -1, -1),
    // new Vector(1, 1, 1),
    // new Vector(1, 1, -1),
    // new Vector(1, -1, 1),
    // new Vector(1, -1, -1),
  };

  int[][] edges = new int[][]{
    {0, 1},
    {0, 2},
    {0, 3},
    {1, 4},
    {1, 5},
    {2, 14},
    {2, 15},
    {2, 16},
    {3, 8},
    {3, 10},
    {4, 6},
    {4, 7},
    {6, 17},
    {6, 18},
    {6, 19},
    {7, 8},
    {7, 9},
    {8, 11},
    {9, 12},
    {11, 12},
    {11, 13},
    {12, 20},
    {13, 21},
    {13, 22},
    {13, 23},
  };

  for (Vector v : nodes) {
    scene.Add(Ln.NewOutlineSphere(eye, up, v, 0.333));
  }

  // for _, v0 := range nodes {
  //   for _, v1 := range nodes {
  //     if v0 == v1 {
  //       continue
  //     }
  for (int[] edge : edges) {
    Vector v0 = nodes[edge[0]];
    Vector v1 = nodes[edge[1]];
    Vector d = v1.Sub(v0);
    double z = d.Length();
    Vector u = d.Cross(up).Normalize();
    float a = acos((float)d.Normalize().Dot(up));
    Matrix m = Ln.Translate(v0);
    if (a != 0) {
      m = Ln.Rotate(u, a).Translate(v0);
    }
    OutlineCylinder c = Ln.NewOutlineCylinder(m.Inverse().MulPosition(eye), up, 0.1, 0, z);
    scene.Add(Ln.NewTransformedShape(c, m));
  }
  // }

  haxe.root.Array<haxe.root.Array<Vector>> paths;
  paths = scene.Render(eye, center, up, width, height, 60, 0.1, 100, 0.01);
  
  String svg = Paths_Impl_.ToSVG(paths,(double)width, (double)height);
  saveStrings(sketchPath(String.format("out%03d.png", frame)),new String[]{svg});
  
  drawPaths(paths);
 
}

void setup() {
  size(750,750);
}

void draw(){
  background(255);
  render(frameCount);
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
