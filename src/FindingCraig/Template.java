package FindingCraig;

import Zack.Rooms;
import Zack.SceneClicking;
import nl.saxion.app.SaxionApp;
import nl.saxion.app.interaction.GameLoop;
import nl.saxion.app.interaction.KeyboardEvent;
import nl.saxion.app.interaction.MouseEvent;

import java.util.ArrayList;

public class Template implements GameLoop {

    private Rooms rooms;
    private SceneClicking sceneClicking;
    private safeBox safeBox;


    public static void main(String[] args) {

        SaxionApp.startGameLoop(new Template(), 1000, 1000, 40);
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
//        rooms.getRoom(sceneClicking.getCurrentRoom()).draw();

    }

    @Override
    public void keyboardEvent(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void mouseEvent(MouseEvent mouseEvent) {
        // Call mouseEvent in SceneClicking
        sceneClicking.handleMouseEvent(mouseEvent);
        safeBox.handleMouseEvent(mouseEvent);

    }

}
