package backgroundTemplate;

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

        // Room switching array
        roomSwitching = new ArrayList<>();
        roomSwitching.add(new ClickableObjects(935,500,65,65, "nextRoom"));
        roomSwitching.add(new ClickableObjects(0,500,65,65, "previousRoom"));
        // Props array
        props = new ArrayList<>();
//        props.add(new ClickableObjects(900,900,50,50, "propOne"));
//        props.add(new ClickableObjects(200,900,50,50, "propTwo"));
//        props.add(new ClickableObjects(700,500,50,50, "propThree"));
//        props.add(new ClickableObjects(300,500,50,50, "propFour"));
    }

    // Method to add props
    public void clickablePropLocation(int x, int y, int width, int height, String message){
        props.add(new ClickableObjects(x,y,width,height,message));
    }

    // Drawing the room images
    public void draw(){
        SaxionApp.drawImage(background,0,0,width,height);
        for (ClickableObjects clickableObject : roomSwitching) {
            clickableObject.draw();
        }
        for (ClickableObjects clickableObject : props) {
            clickableObject.draw();
        }
    }

    // Getting user input clicks
    public String getClick(int x, int y){
        for (ClickableObjects clickableObject : roomSwitching) {
            if(clickableObject.isMe(x,y)){
                return clickableObject.toString();
            }
        }
        for (ClickableObjects clickableObject : props) {
            if(clickableObject.isMe(x,y)){
                return clickableObject.toString();
            }
        }
        return "";
    }
}



