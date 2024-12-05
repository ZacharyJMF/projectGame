package playgroundTest.batmove;

import nl.saxion.app.SaxionApp;
import nl.saxion.app.interaction.GameLoop;
import nl.saxion.app.interaction.KeyboardEvent;
import nl.saxion.app.interaction.MouseEvent;

public class BasicGame implements GameLoop {

    public Bat bat;
    public static void main(String[] args) {
        SaxionApp.startGameLoop(new BasicGame(), 1000, 1000, 40);
    }

    @Override
    public void init() {
        bat = new Bat();
        bat.x=100;
        bat.y=100;
        bat.filename="resources/bat.jpeg";
    }

    @Override
    public void loop() {
        SaxionApp.clear();
        bat.draw();
    }

    @Override
    public void keyboardEvent(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void mouseEvent(MouseEvent mouseEvent) {

    }
}






