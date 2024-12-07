package MainMenu;

import nl.saxion.app.SaxionApp;
import nl.saxion.app.interaction.GameLoop;
import nl.saxion.app.interaction.KeyboardEvent;
import nl.saxion.app.interaction.MouseEvent;

import java.awt.*;

public class BasicGame implements GameLoop {

    private boolean startGame = false;

    public static void main(String[] args) {
        SaxionApp.startGameLoop(new BasicGame(), 800, 600, 30);
    }


    public void processInput(MouseEvent mouseEvent) {
        if (!startGame && mouseEvent.isLeftClicked()) {
            int mouseX = mouseEvent.getX();
            int mouseY = mouseEvent.getY();
            if (mouseX >= 350 && mouseX <= 450 && mouseY >= 250 && mouseY <= 300) {
                startGame = true;
            }
        }
    }


    public void update() {
        // Game logic goes here
    }


    public void render() {
        SaxionApp.clear();

        if (!startGame) {
            SaxionApp.drawText("Finding Game", 350, 200, 30, Color.BLACK);
            SaxionApp.drawRectangle(350, 250, 100, 50, Color.BLACK); // Start button border
            SaxionApp.drawText("Start", 375, 275, 20, Color.WHITE); // Start button text
        } else {
            SaxionApp.drawText("Game is running...", 300, 300, 30, Color.BLACK);
        }
    }

    @Override
    public void init() {

    }

    @Override
    public void loop() {

    }

    @Override
    public void keyboardEvent(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void mouseEvent(MouseEvent mouseEvent) {

    }
}
