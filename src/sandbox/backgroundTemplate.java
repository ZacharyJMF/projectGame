package sandbox;

import nl.saxion.app.SaxionApp;
import test.ClickableObjects;

import java.util.ArrayList;

public class backgroundTemplate {

    String background;
    ArrayList<ClickableObjects> clickable;
    int width,height;
    public backgroundTemplate(String background) {
        this.background = background;
        width=1000;
        height=1000;

        // If user clicked within box perimeter, output text
        clickable = new ArrayList<>();
        clickable.add(new ClickableObjects(650,463,100,100, "AAAAAAAAAAA"));

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



