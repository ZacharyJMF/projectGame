package Zack;

import nl.saxion.app.SaxionApp;
import java.util.ArrayList;

public class BackgroundScene {

    String background;
    ArrayList<ClickableObjects> roomSwitching;
    ArrayList<ClickableObjects> props;
    int width,height;

    public BackgroundScene(String background) {
        this.background = background;
        width=1000;
        height=1000;

        // Props array
        props = new ArrayList<>();
        // Room switching array
        roomSwitching = new ArrayList<>();
        roomSwitching.add(new ClickableObjects(935,500,65,65, "nextRoom"));
        roomSwitching.add(new ClickableObjects(0,500,65,65, "previousRoom"));
    }

    // Method to add props from Template
    public void clickablePropLocation(int x, int y, int width, int height, String message){
        props.add(new ClickableObjects(x,y,width,height,message));
    }

    // Drawing everything
    public void draw(){
        SaxionApp.drawImage(background,0,0,width,height); // Drawing the background
        for (ClickableObjects clickableObject : roomSwitching) { // Drawing the room switch
            clickableObject.drawSwitches();
        }
        for (ClickableObjects clickableObject : props) { // Drawing the props
            clickableObject.drawProps();
        }
    }

    // User input clicks
    public String getClick(int x, int y){
        for (ClickableObjects clickableObject : roomSwitching) { // Click input for the room switching
            if(clickableObject.isMe(x,y)){
                return clickableObject.toString();
            }
        }
        for (ClickableObjects clickableObject : props) { // Click input for the props
            if(clickableObject.isMe(x,y)){
                return clickableObject.toString();
            }
        }
        return "";
    }
}



