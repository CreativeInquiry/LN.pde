//https://github.com/fogleman/ln/blob/master/examples/beads.go

import ln.*;
import ln._Paths.*;

void setup(){
  size(760,630);
  randomSeed(1211);
  Vector eye = new Vector(8, 8, 8);
  Vector center = new Vector(0, 0, 0);
  Vector up = new Vector(0, 0, 1);
  Scene scene = new Scene();
  for (int a = 0; a < 5; a++ ){
    int n = 200;
    float[] xs = LowPassNoise(n, 0.3, 4);
    float[] ys = LowPassNoise(n, 0.3, 4);
    float[] zs = LowPassNoise(n, 0.3, 4);
    float[] ss = LowPassNoise(n, 0.3, 4);
    Vector position = new Vector(0,0,0);
    for (int i = 0; i < n; i++ ){
      OutlineSphere sphere = Ln.NewOutlineSphere(eye, up, position, 0.1);
      scene.Add(sphere);
      float s = (ss[i]+1)/2*0.1 + 0.01;
      Vector v = new Vector(xs[i], ys[i], zs[i]).Normalize().MulScalar(s);
      position = position.Add(v);
    }
  }
  float fovy = 50.0;
  haxe.root.Array<haxe.root.Array<Vector>> paths;
  paths = scene.Render(eye, center, up, width, height, fovy, 0.1, 100, 0.5);
  String svg = Paths_Impl_.ToSVG(paths,(double)width, (double)height);
  saveStrings(sketchPath("out.svg"),new String[]{svg});
  
  drawPaths(paths);
}

float[] Normalize(float[] values, float a, float b)  {
  float[] result = new float[values.length];
  float lo = values[0];
  float hi = values[0];
  for (float x : values) {
    lo = min(lo, x);
    hi = max(hi, x);
  }
  for (int i = 0; i < values.length; i++) {
    float x = values[i];
    float p = (x - lo) / (hi - lo);
    result[i] = a + p*(b-a);
  }
  return result;
}


float[] LowPass(float[] values, float alpha){
  float[] result = new float[values.length];
  float y = 0;
  for (int i = 0; i < values.length; i++){
    y -= alpha * (y - values[i]);
    result[i] = y;
  }
  return result;
}

float[] LowPassNoise(int n, float alpha, int iterations){
  float[] result = new float[n];
  for (int i = 0; i < result.length; i++){
    result[i] = random(1);
  }
  for (int i = 0; i < iterations; i++){
    result = LowPass(result,alpha);
  }
  result = Normalize(result,-1,1);
  return result;
  
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
