package test;
import nl.saxion.app.SaxionApp;

public class ClickableObjects
{
    public int x,y,width,height;
    public String message;

    public ClickableObjects(int x, int y, int width, int height, String message) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.message = message;
    }

    public boolean isMe(int x, int y){
        System.out.println("Running is it me: ");
        if(x >= this.x && y >= this.y && x < this.x + width && y < this.y + height){
            return true;
        }else{
            return false;
        }
    }
    public void draw(){
        SaxionApp.drawRectangle(x,y,width,height);
    }

    @Override
    public String toString() {
        return message;
    }
}
