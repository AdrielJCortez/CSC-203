package streams;

import processing.core.*;

public class DrawPoints extends PApplet {

	public void settings() {
    size(500, 500);
	}
  
	public void setup() {
    	background(180);
    	noLoop();
  	}

  	public void draw() {

   	double x, y;
   
   	String[] lines = loadStrings("drawMe.txt");
  		for (int i=0; i < lines.length; i++){
      	if (lines[i].length() > 0 ) {
        		String[] words= lines[i].split(", ");
        		x = Double.parseDouble(words[0]);
        		y = Double.parseDouble(words[1]);
        		ellipse((int)x, (int)y, 1, 1);
      	}
  		}
  	}

  	public static void main(String args[]) {
      PApplet.main("streams.DrawPoints");
   }
}
