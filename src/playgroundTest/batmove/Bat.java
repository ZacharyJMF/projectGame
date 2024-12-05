package playgroundTest.batmove;

import nl.saxion.app.SaxionApp;

public class Bat {
    public int x,y;
    public String filename;

    public void draw(){
        SaxionApp.drawImage(filename, x,y,100, 100);
    }
}
