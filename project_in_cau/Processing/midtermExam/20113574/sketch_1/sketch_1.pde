void setup() {
  size(1000, 1000);
}



void draw() {
  float x = random(0, width);
  float y = random(0, height);
  noStroke();
  fill(random(0, 255), random(0, 255), random(0, 255), random(0, 255));
  rect(x, y, random(0, 300), random(0, 300));
}

