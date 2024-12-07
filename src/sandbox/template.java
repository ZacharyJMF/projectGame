package sandbox;

import nl.saxion.app.SaxionApp;
import nl.saxion.app.interaction.GameLoop;
import nl.saxion.app.interaction.KeyboardEvent;
import nl.saxion.app.interaction.MouseEvent;

public class template implements GameLoop {

    public static void main(String[] args) {
        SaxionApp.startGameLoop(new playgroundTest.BasicGame(), 1000, 1000, 40);
    }

    // Examples room images
    private static backgroundTemplate r1;
    private static backgroundTemplate r2;
    private static backgroundTemplate r3;
    private static backgroundTemplate r4;

    @Override
    public void init() {
        r1=new backgroundTemplate("resources/1.png");
        r2=new backgroundTemplate("resources/2.png");
        r3=new backgroundTemplate("resources/3.png");
        r4=new backgroundTemplate("resources/bat.jpeg");
    }

    @Override
    public void loop() {
        SaxionApp.clear();
        r1.draw();
    }

    @Override
    public void keyboardEvent(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void mouseEvent(MouseEvent mouseEvent) {

    }
}
