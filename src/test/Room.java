import nl.saxion.app.SaxionApp;

import java.util.ArrayList;

public class Room {
    String background;
    ArrayList<ClickableObjects> clickable;
    int width,height;

    public Room(String background) {
        this.background = background;
        width=1000;
        height=1000;
        clickable = new ArrayList<>();
        clickable.add(new ClickableObjects(650,463,100,100,"Test"));

    }
    public void draw(){
        SaxionApp.drawImage(background,0,0,width,height);
        for (ClickableObjects clickableObject : clickable) {
            clickableObject.draw();
        }
    }
    public String getClick(int x, int y){
        System.out.println("Get click runing");
        for (ClickableObjects clickableObject : clickable) {
            if(clickableObject.isMe(x,y)){
                return clickableObject.toString();
            }
        }
        return "";
    }
}
