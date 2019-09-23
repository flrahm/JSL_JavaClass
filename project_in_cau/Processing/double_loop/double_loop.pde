float a;
int b;
int c;
void setup() {
  size(500, 500);
}

void draw() {
  if (mousePressed) {
    background(0);
  } else {
    background(255);
  }
  translate(250, 250);

  for (int i = 0; i < 200; i+=10) {
    float x = sin((i-a)) * mouseX;
    float y = sin((i+a)) * x;

    for (float n = 0; n<10; n=n+1) {
      noFill();
      if (mousePressed) {
        b = 255;
        c = 125;
      } else { 
        b = 0;
        c = 255;
      }
      float e = mouseY/2;
      stroke(e, b, e-20*n, c);
      strokeWeight(2);
      float d = 5+2*n;
      ellipse(x, y, d, d);
      ellipse(-x, -y, d, d);
      ellipse(-y, -x, d, d);
      ellipse(y, x, d, d);
      ellipse(x+y, y+x, d, d);
      ellipse(-x-y, -y-x, d, d);
      ellipse(x-y, y-x, d, d);
      ellipse(-x+y, x-y, d, d);
    }
  }
  a = a+ 0.025;
}