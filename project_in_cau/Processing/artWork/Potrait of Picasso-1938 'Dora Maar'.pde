size(800,780);
noStroke();
fill(0);
rect(400,0,800,800);

fill(0,65,30);
beginShape();
vertex(300,0);
vertex(500,0);
vertex(770,370);
vertex(680,680);
endShape(CLOSE);

curve(300,500,490,0,770,373,300,500);
curve(450,300,770,330,680,680,700,400);

quad(680,675,700,800,580,800,400,178);

fill(219,58,0);
beginShape();
vertex(670,680);
vertex(580,800);
vertex(400,800);
vertex(400,178);
endShape(CLOSE);
curve(550,730,669,680,578,800,548,730);

fill(219,151,0);
stroke(0);
strokeWeight(15);
arc(0,500,1230,1330,1.4*PI,2.5*PI,OPEN);

noStroke();
fill(255,255,0);
quad(0,0,260,0,480,800,0,800);
fill(0,180,219);
quad(306,160,480,850,480,90,450,50);

stroke(0);
strokeWeight(15);
noFill();
arc(0,500,1230,1330,1.4*PI,2.5*PI,OPEN);

fill(68,180,68);
noStroke();
beginShape();
vertex(220,0);
vertex(68,352);
vertex(230,405);
vertex(334,260);
vertex(260,0);
endShape(CLOSE);

strokeWeight(13);
stroke(0);
line(220,0,70,350);

bezier(70,350,55,400,100,520,230,400);

strokeWeight(13);
fill(255,255,126);
ellipse(450,260,230,140);
stroke(235,30,30);
strokeWeight(5);
ellipse(450,260,100,100);
fill(255,90,90);
ellipse(450,260,90,90);
fill(0);
noStroke();
ellipse(450,260,50,50);

fill(95,0,255);
noStroke();
quad(230,400,230,530,385,480,334,260);

fill(0,150,180);
triangle(230,530,477,530,385,480);

fill(219,192,0);
quad(253,580,300,800,465,800,430,650);

fill(217,65,200);
quad(405,550,250,580,320,630,430,650);

stroke(0);
strokeWeight(13);
line(230,400,230,530);
line(230,530,385,480);
line(385,480,334,260);

line(230,530,477,530);
line(477,530,385,480);

line(477,530,250,580);
line(250,580,320,630);
line(320,630,430,650);
line(430,650,400,540);    //405,550
point(410,540);

line(253,580,300,800);
line(430,650,465,800);

strokeWeight(16);
fill(0,84,230);
ellipse(340,800,200,120);

strokeWeight(13);
fill(235,235,116);
ellipse(255,160,90,90);
fill(0);
ellipse(255,160,30,30);

ellipse(145,150,15,15);
ellipse(610,260,20,20);

strokeWeight(3);
line(670,680,610,570);