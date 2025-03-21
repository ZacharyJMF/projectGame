package Zack;

import nl.saxion.app.SaxionApp;
import nl.saxion.app.interaction.GameLoop;
import nl.saxion.app.interaction.KeyboardEvent;
import nl.saxion.app.interaction.MouseEvent;

public class Template implements GameLoop {

    private Rooms rooms;
    private SceneClicking sceneClicking;

    public static void main(String[] args) {
        SaxionApp.startGameLoop(new Template(), 1000, 1000, 40);
    }

    @Override
    public void init() {
        rooms = new Rooms();
        sceneClicking = new SceneClicking(rooms, 0);
    }

    @Override
    public void loop() {
        SaxionApp.clear();
        rooms.getRoom(sceneClicking.getCurrentRoom()).draw();
    }

    @Override
    public void keyboardEvent(KeyboardEvent keyboardEvent) {
        // Handle keyboard events if needed
    }

    @Override
    public void mouseEvent(MouseEvent mouseEvent) {
        sceneClicking.handleMouseEvent(mouseEvent);
        int mouseX = mouseEvent.getX();
        int mouseY = mouseEvent.getY();
        System.out.println("Mouse clicked at: (" + mouseX + ", " + mouseY + ")");
    }
}