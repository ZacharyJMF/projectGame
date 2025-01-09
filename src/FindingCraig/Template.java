package FindingCraig;

import nl.saxion.app.SaxionApp;
import nl.saxion.app.interaction.GameLoop;
import nl.saxion.app.interaction.KeyboardEvent;
import nl.saxion.app.interaction.MouseEvent;

public class Template implements GameLoop {

    private Rooms rooms;
    private SceneClicking sceneClicking;
    private SafeBox safeBox;
    private MainMenu mainMenu;
    private boolean gameStarted = false;
    private boolean showSafeBox = false;

    public static void main(String[] args) {
        SaxionApp.startGameLoop(new Template(), 1000, 1000, 40);
    }

    @Override
    public void init() {
        rooms = new Rooms();
        sceneClicking = new SceneClicking(rooms, 0);
        mainMenu = new MainMenu();
    }

    @Override
    public void loop() {
        SaxionApp.clear();
        if (mainMenu.isShow()) {
            mainMenu.draw();
        } else {
            if (!gameStarted) {
                gameStarted = true;
            }
            if (showSafeBox) {
                safeBox.draw();
            } else {
                rooms.getRoom(sceneClicking.getCurrentRoom()).draw();
            }
        }
    }

    @Override
    public void keyboardEvent(KeyboardEvent keyboardEvent) {
        // Handle keyboard events if needed
    }

    @Override
    public void mouseEvent(MouseEvent mouseEvent) {
        if (mainMenu.isShow()) {
            mainMenu.click(mouseEvent);
        } else {
            if (showSafeBox) {
                safeBox.handleMouseEvent(mouseEvent);
            } else {
                // Call mouseEvent in SceneClicking
                sceneClicking.handleMouseEvent(mouseEvent);

                // Check if a prop triggers a puzzle
                int currentRoom = sceneClicking.getCurrentRoom();
                String puzzleType = rooms.getPuzzleType(currentRoom, mouseEvent.getX(), mouseEvent.getY());
                if ("prop 1 in room 1".equals(puzzleType)) {
                    safeBox = new SafeBox();
                    safeBox.init();
                    showSafeBox = true;
                }
            }
        }
    }
}