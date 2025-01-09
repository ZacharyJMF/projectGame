package FindingCraig;

import nl.saxion.app.SaxionApp;
import nl.saxion.app.interaction.MouseEvent;

public class MainMenu {
    private boolean show = true;
    private int windowWidth = 1000;
    private int windowHeight = 1000;
    private String backgroundImage = "resources/mainMenu.jpeg";

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    public void draw() {
        // Draw the background image
        SaxionApp.drawImage(backgroundImage, 0, 0, windowWidth, windowHeight);

        // Calculate positions for the title and start button
        int titleX = windowWidth / 2 - 75; // Adjust the offset to center the title
        int titleY = windowHeight / 2 - 100;
        int buttonX = windowWidth / 2 - 50; // Adjust the offset to center the button
        int buttonY = windowHeight / 2;

        // Draw the title and start button
        SaxionApp.drawText("Finding Craig", titleX, titleY, 30);
        SaxionApp.drawRectangle(buttonX, buttonY, 100, 50); // Start button border
        SaxionApp.drawText("Start", buttonX + 25, buttonY + 25, 20); // Start button text
    }

    public void click(MouseEvent e) {
        if (e.isLeftMouseButton()) {
            int mouseX = e.getX();
            int mouseY = e.getY();
            int buttonX = windowWidth / 2 - 50; // Adjust the offset to center the button
            int buttonY = windowHeight / 2;

            if (mouseX >= buttonX && mouseX <= buttonX + 100 && mouseY >= buttonY && mouseY <= buttonY + 50) {
                show = false;
            }
        }
    }
}