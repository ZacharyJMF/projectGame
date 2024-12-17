package FindingCraig;

import nl.saxion.app.SaxionApp;
import nl.saxion.app.interaction.GameLoop;
import nl.saxion.app.interaction.KeyboardEvent;
import nl.saxion.app.interaction.MouseEvent;

public class Template implements GameLoop {

    private int currentRoom;
    private static BackgroundScene[] rooms;
    private long clickTime;

    public static void main(String[] args) {
        SaxionApp.startGameLoop(new Template(), 1000, 1000, 40);
    }

    @Override
    public void init() {

    }

    @Override
    public void loop() {
        SaxionApp.clear();
    }

    @Override
    public void keyboardEvent(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void mouseEvent(MouseEvent mouseEvent) {


    }
}
