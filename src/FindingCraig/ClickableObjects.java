package FindingCraig;

import nl.saxion.app.SaxionApp;
import nl.saxion.app.canvas.drawable.Image;

import java.awt.*;

public class ClickableObjects {
    public int x,y,width,height;
    public String message;
    private Image lImage;
    private Image rImage;

    public ClickableObjects(int x, int y, int width, int height, String message) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.message = message;
    }

    // Checks if coordinates are withing bounds of clickable object
    public boolean isMe(int x, int y){
        return x >= this.x && y >= this.y && x < this.x + width && y < this.y + height;
    }

    // Drawing clickable object location
    // Make invisible and display image when clicked on
    public void drawSwitches(){
        SaxionApp.setFill(Color.yellow);
        SaxionApp.drawRectangle(x,y,width,height);
    }
    public void drawProps(){
        SaxionApp.setFill(Color.black);
        SaxionApp.drawRectangle(x,y,width,height);
    }

    @Override
    public String toString() {
        return message;
    }
}
