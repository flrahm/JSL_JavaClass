int h = 100;
float g = 0;
void setup() {
  size(500, 500);
  background(255);
  strokeWeight(2);
  stroke(200);
}
void draw() {
  background(255);
  if (mousePressed) {
    g = random(0, 33);
  }
  for (int a = 0; a < 10; a = a+1) {

    for (int i = 0; i < 3; i = i +1) {
      ellipse(50+200*i, g+ 0+h*a, 160+g, 160+g);
      ellipse(50+200*i, g+ 0+h*a, 130+g, 130+g);
      ellipse(50+200*i, g+ 0+h*a, 100+g, 100+g);
      ellipse(50+200*i, g+ 0+h*a, 70+g, 70+g);
      ellipse(50+200*i, g+ 0+h*a, 40+g, 40+g);
    } 
    for (int j = 0; j < 2; j = j +1) {
      ellipse(150+200*j, g+ 50+h*a, 160+g, 160+g);
      ellipse(150+200*j, g+ 50+h*a, 130+g, 130+g);
      ellipse(150+200*j, g+ 50+h*a, 100+g, 100+g);
      ellipse(150+200*j, g+ 50+h*a, 70+g, 70+g);
      ellipse(150+200*j, g+50+h*a, 40+g, 40+g);
    }
  }
}

