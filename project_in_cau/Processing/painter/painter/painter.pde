void setup()
{ 
  background(255);
  size(700, 600);
}

int color_R;
int color_G;
int color_B;
int sizeOfpen;

int indicator;



void draw()
{
  noStroke();
  fill(170);
  rect(0, 0, 100, 600); //button bar line




  /////////////////color//////////////////////////////
  noStroke();
  fill(255, 0, 0);
  rect(10, 300, 30, 30); 
  if (mousePressed&&mouseX>10&&mouseY>300&&mouseX<40&&mouseY<330) 
  { 
    color_R = 255;  
    color_G = 0; 
    color_B = 0;
  }   

  fill(255, 255, 0);
  rect(10, 340, 30, 30);   
  if (mousePressed&&mouseX>10&&mouseY>340&&mouseX<40&&mouseY<370) 
  { 
    color_R = 255;  
    color_G = 255; 
    color_B = 0;
  } 

  fill(255, 185, 0);
  rect(10, 380, 30, 30);
  if (mousePressed&&mouseX>10&&mouseY>380&&mouseX<40&&mouseY<410) 
  { 
    color_R = 255;  
    color_G = 185; 
    color_B = 0;
  } 

  fill(171, 242, 0);
  rect(10, 420, 30, 30);
  if (mousePressed&&mouseX>10&&mouseY>420&&mouseX<40&&mouseY<450) 
  { 
    color_R = 171;  
    color_G = 242; 
    color_B = 0;
  } 

  fill(0, 215, 255);
  rect(10, 460, 30, 30);
  if (mousePressed&&mouseX>10&&mouseY>460&&mouseX<40&&mouseY<490) 
  { 
    color_R = 0; 
    color_G = 215; 
    color_B = 255;
  } 

  fill(0, 0, 255);
  rect(10, 500, 30, 30);
  if (mousePressed&&mouseX>10&&mouseY>500&&mouseX<40&&mouseY<530) 
  { 
    color_R = 0; 
    color_G = 0; 
    color_B = 255;
  } 

  fill(255, 0, 125);
  rect(10, 540, 30, 30);
  if (mousePressed&&mouseX>10&&mouseY>540&&mouseX<40&&mouseY<570) 
  { 
    color_R = 255;  
    color_G = 0; 
    color_B = 125;
  } 

  fill(0, 0, 0);
  rect(50, 300, 30, 30); 
  if (mousePressed&&mouseX>50&&mouseY>300&&mouseX<80&&mouseY<330) 
  { 
    color_R = 0;  
    color_G = 0; 
    color_B = 0;
  } 

  fill(255, 255, 255);
  rect(50, 540, 30, 30);
  if (mousePressed&&mouseX>50&&mouseY>540&&mouseX<80&&mouseY<570) 
  { 
    color_R = 255;  
    color_G = 255; 
    color_B = 255;
  }   
  ///////////////////////////////

  //////////////// pen size/////////////
  stroke(0);
  strokeWeight(1);
  fill(0);
  ellipse(65, 355, 5, 5);
  ellipse(65, 395, 8, 8);
  ellipse(65, 435, 11, 11);
  ellipse(65, 475, 14, 14);
  ellipse(65, 515, 17, 17);

  noFill();  
  rect(50, 340, 30, 30); 
  if (mousePressed&&mouseX>50&&mouseY>340&&mouseX<80&&mouseY<370) 
  {
    sizeOfpen=10;
  }


  rect(50, 380, 30, 30); 
  if (mousePressed&&mouseX>50&&mouseY>380&&mouseX<80&&mouseY<410) 
  {
    sizeOfpen=15;
  }

  rect(50, 420, 30, 30); 
  if (mousePressed&&mouseX>50&&mouseY>420&&mouseX<80&&mouseY<450) 
  {
    sizeOfpen=20;
  }  

  rect(50, 460, 30, 30); 
  if (mousePressed&&mouseX>50&&mouseY>460&&mouseX<80&&mouseY<490) 
  {
    sizeOfpen=25;
  } 

  rect(50, 500, 30, 30); 
  if (mousePressed&&mouseX>50&&mouseY>500&&mouseX<80&&mouseY<530) 
  {
    sizeOfpen=40;
  } 
  ////////////////////////////////////////

  //////////////////////pen///////////////////////

  rect(10, 10, 30, 30);
  arc(25, 20, 20, 8, 1.5*PI, 2.5*PI);
  line(25, 15, 25, 33);
  if (mousePressed&&mouseX>10&&mouseY>10&&mouseX<40&&mouseY<40) 
  {
    indicator=1;
  }
  if (indicator ==1)
  {
    strokeWeight(2);
    rect(10, 10, 30, 30);
    arc(25, 20, 20, 8, 1.5*PI, 2.5*PI);
    line(25, 15, 25, 33);
    strokeWeight(1);
  }
  //////////////
  
   /////////////save////
  rect(10, 50, 30, 30);
  bezier(35,55,0,55,55,75,20,75);
  
  if (mousePressed&&mouseX>10&&mouseY>50&&mouseX<40&&mouseY<80) 
  {
    indicator =2;

    if (indicator ==2)
  {
    strokeWeight(2);
  rect(10, 50, 30, 30);
  bezier(35,55,0,55,55,75,20,75);
    strokeWeight(1);
  }
    
  }

   if(indicator==2)
   {
     save("image.png");
     indicator=1;
   }
  


  


  ///////////eraser/////
  fill(255);
  rect(50, 10, 30, 30);
  noFill();
  if (mousePressed&&mouseX>50&&mouseY>10&&mouseX<80&&mouseY<40) 
  {
   noStroke();
    fill(255); 
    rect(100, 0, 600, 600);
  }

  ///////////////////////////    

 


  ////////////////////////start pen/////////////
  if (indicator==1)
  {
    noStroke();
    fill(color_R, color_G, color_B);

    if (mousePressed)
    {
      ellipse(mouseX, mouseY, sizeOfpen, sizeOfpen);
    }
  } else
  {
    noFill();
    noStroke();
  }
/////////////////////


}