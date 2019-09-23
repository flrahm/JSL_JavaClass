size(725,725);
background(245);
noStroke();
fill(0);
rect(60,0,30,725);    //vertical line 1
rect(275,0,15,725);   //vertical line 2
rect(530,0,15,725);   //vertical line 3

rect(0,220,275,30);   //horizon line 1
rect(0,530,275,20);   //horizon line 2
rect(275,160,260,17);   //horizon line 3
rect(275,400,500,17);   //horizon line 4

fill(255,0,0);
rect(90,0,185,220);  //red color
fill(255,255,0);
rect(90,550,185,200);  //yellow color
fill(0);
rect(290,620,240,200);  //black color
fill(63,0,153);
rect(545,417,180,333);  //purple color

fill(255);
triangle(0,0,361,0,0,361);  //triangle LU (left upper)
triangle(360,0,725,0,725,380); //triangle RU
triangle(0,361,0,725,361,725); //triangle LD
triangle(361,725,725,725,725,350); //triangle RD