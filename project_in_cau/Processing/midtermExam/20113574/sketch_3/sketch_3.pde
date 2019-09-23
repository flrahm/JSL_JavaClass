// can move 1 point, not 5

float px1, px2, px3, px4, px5;
float py1, py2, py3, py4, py5;
float mx, my;
int a = 0;
int b = 0;
int c = 0;
int d = 0;
int e = 0;

void setup() {
  size(600, 600);
  px1 = 250*cos(2*PI*0.0)+300;
  px2 = 250*cos(2*PI*0.2)+300;
  px3 = 250*cos(2*PI*0.4)+300;
  px4 = 250*cos(2*PI*0.6)+300;
  px5 = 250*cos(2*PI*0.8)+300;

  py1 = 250*sin(2*PI*0.0)+300;
  py2 = 250*sin(2*PI*0.2)+300;
  py3 = 250*sin(2*PI*0.4)+300;
  py4 = 250*sin(2*PI*0.6)+300;
  py5 = 250*sin(2*PI*0.8)+300;
}



void draw() {
  background(255);
  mx = mouseX;
  my = mouseY; 
  if (mousePressed&&mx<px1+50&&mx>px1-50&&my<py1+50&&mx>py1-50)
  {
    a = 1;

    if (a==1&&mousePressed) {
      fill(255, 255, 0);
      ellipse(px1, py1, 30, 30);
      ellipse(mx, my, 10, 10);
      noFill();
      px1 = mouseX;
      py1 = mouseY;
      a = 0;
      noFill();
    }
  }




  strokeWeight(5);
  stroke(0);

  line(px1, py1, px3, py3);
  line(px3, py3, px5, py5);
  line(px5, py5, px2, py2);
  line(px2, py2, px4, py4);
  line(px4, py4, px1, py1);
  ellipse(px1, py1, 10, 10);
  ellipse(px2, py2, 10, 10);
  ellipse(px3, py3, 10, 10);
  ellipse(px4, py4, 10, 10);
  ellipse(px5, py5, 10, 10);
}

