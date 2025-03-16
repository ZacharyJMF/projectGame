package Zack;

import nl.saxion.app.SaxionApp;
import java.awt.Color;

public class ClickableObjects {
    public int x, y, width, height;
    public String message;
    private String imagePath; // Path to the image file

    public ClickableObjects(int x, int y, int width, int height, String message, String imagePath) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.message = message;
        this.imagePath = imagePath; // Store the image path
    }

    // Checks if coordinates are within bounds of clickable object
    public boolean isMe(int x, int y) {
        return x >= this.x && y >= this.y && x < this.x + width && y < this.y + height;
    }

    // Drawing clickable object location (for room-switching buttons)
    public void drawSwitches() {
        if (imagePath != null) {
            // Draw the image directly
            SaxionApp.drawImage(imagePath, x, y, width, height);
        } else {
            // Fallback to a yellow rectangle
            SaxionApp.setFill(Color.yellow);
            SaxionApp.drawRectangle(x, y, width, height);
        }
    }

    // Drawing clickable object location (for props)
    public void drawProps() {
        // Skip drawing for "nextRoom" and "previousRoom" messages
        if (!message.equals("nextRoom") && !message.equals("previousRoom")) {
            SaxionApp.setFill(Color.black); // Default color for props
            SaxionApp.drawRectangle(x, y, width, height);
        }
    }

    @Override
    public String toString() {
        return message;
    }
}