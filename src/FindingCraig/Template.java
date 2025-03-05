package FindingCraig;

import nl.saxion.app.SaxionApp;
import nl.saxion.app.interaction.GameLoop;
import nl.saxion.app.interaction.KeyboardEvent;
import nl.saxion.app.interaction.MouseEvent;

public class Template implements GameLoop {

    private Rooms rooms;
    private SceneClicking sceneClicking;
    private SafeBox safeBox; // Add SafeBox instance

    public static void main(String[] args) {
        SaxionApp.startGameLoop(new Template(), 1000, 1000, 40);
    }

    @Override
    public void init() {
        rooms = new Rooms();
        sceneClicking = new SceneClicking(rooms, 0);
        safeBox = new SafeBox(); // Initialize SafeBox
        safeBox.init(); // Initialize SafeBox
    }

    @Override
    public void loop() {
        SaxionApp.clear();
        rooms.getRoom(sceneClicking.getCurrentRoom()).draw();
        safeBox.draw(); // Draw SafeBox
    }

    @Override
    public void keyboardEvent(KeyboardEvent keyboardEvent) {
        // Handle keyboard events if needed
    }

    @Override
    public void mouseEvent(MouseEvent mouseEvent) {
        sceneClicking.handleMouseEvent(mouseEvent);
        safeBox.handleMouseEvent(mouseEvent); // Handle mouse events for SafeBox
    }
}