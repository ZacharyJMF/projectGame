package Armin;

import Zack.Rooms;
import Zack.SceneClicking;
import nl.saxion.app.SaxionApp;
import nl.saxion.app.interaction.GameLoop;
import nl.saxion.app.interaction.KeyboardEvent;
import nl.saxion.app.interaction.MouseEvent;

import java.util.ArrayList;

public class doubleClick implements GameLoop {

    private Rooms rooms;
    private SceneClicking sceneClicking;
    private safeBox safeBox;
    private String previousImage = "/right.jpeg";


    public static void main(String[] args) {

        SaxionApp.startGameLoop(new doubleClick(), 1000, 1000, 40);
    }


    @Override
    public void init() {
        rooms = new Rooms();
        sceneClicking = new SceneClicking(rooms, 0);
        long clickTime = 0;
        safeBox = new safeBox();
        safeBox.redraw();
    }

    @Override
    public void loop() {
        rooms.getRoom(sceneClicking.getCurrentRoom()).draw();

    }

    @Override
    public void keyboardEvent(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void mouseEvent(MouseEvent mouseEvent) {
        if (mouseEvent.isRightMouseButton()){
            SaxionApp.clear();
            SaxionApp.drawImage(previousImage, 1000, 1000);
        }else {
            sceneClicking.handleMouseEvent(mouseEvent);
            safeBox.handleMouseEvent(mouseEvent);
        }
    }

}
