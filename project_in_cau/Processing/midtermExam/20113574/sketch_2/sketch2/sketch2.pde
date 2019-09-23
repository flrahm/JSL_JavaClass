size(600, 500);
background(0);
noFill();
strokeWeight(5);
stroke(255);
triangle(300, 100, 150, 400, 450, 400);


for (int a =0; a<50; a=a+5)
{
  int r1 = 255; 
 int g1 = 0 + 5*a; 
  stroke(r1,g1,0,150);
  strokeWeight(2);
  line(350,200,550,250+0.2*a);
}

for (int b =0; b<50; b=b+5)
{
  int r2 = 255-5*b; 
 int g2 = 255; 
  stroke(r2,g2,0,150);
  strokeWeight(2);
  line(350,200,550,260+0.2*b);
}

for (int b =0; b<50; b=b+5)
{ 
 int g3 = 255-5*b;
 int b3 = 5*b; 
  stroke(0,g3,b3,150);
  strokeWeight(1);
  line(350,200,550,270+0.2*b);
}

strokeWeight(10);
stroke(255,255,255,200);
line(50,350,230,230);

for (int a =0; a<25; a=a+5)
{
  int rr2 = 255-10*a; 
 int gg2 = 255; 
  stroke(rr2,gg2,0,150);
  strokeWeight(1);
  line(235,225,350,203+0.1*a);
}

for (int b =0; b<25; b=b+5)
{
  int rr1 = 255; 
 int gg1 = 0 + 10*b; 
  stroke(rr1,gg1,0,150);
  strokeWeight(2);
  line(235,225,350,200+0.1*b);
}

for (int b =0; b<25; b=b+5)
{
  int gg3 = 255; 
 int bb3= 0 + 10*b; 
  stroke(0,gg3,bb3,150);
  strokeWeight(2);
  line(235,225,350,205+0.1*b);
}
