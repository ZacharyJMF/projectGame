package FindingCraig;

import nl.saxion.app.SaxionApp;
import nl.saxion.app.interaction.MouseEvent;

import java.util.ArrayList;

public class SafeBox {
    private String safeboxImg = "resources/safe-box.png";
    private ArrayList<String> enteredNumbers = new ArrayList<>();
    private long clickTime;
    private int passcode = 250;
    private int[][] numpadBounds = {
            {545, 429, 50, 50, 1}, // 1
            {614, 429, 50, 50, 2}, // 2
            {682, 429, 50, 50, 3}, // 3
            {545, 511, 50, 50, 4}, // 4
            {614, 511, 50, 50, 5}, // 5
            {682, 511, 50, 50, 6}, // 6
            {545, 590, 50, 50, 7}, // 7
            {614, 590, 50, 50, 8}, // 8
            {682, 590, 50, 50, 9}, // 9
            {613, 669, 50, 50, 0}  // 0
    };

    public void init() {
        clickTime = 0;
        SaxionApp.drawImage(safeboxImg, 0, 0, 1000, 1000);
        SaxionApp.drawText("Entered Numbers:", 400, 100, 30);
    }

    public void draw() {
        SaxionApp.drawImage(safeboxImg, 0, 0, 1000, 1000);
        SaxionApp.drawText("Entered Numbers:", 400, 100, 30);
        String displayText = String.join("", enteredNumbers);
        SaxionApp.drawText(displayText, 400, 150, 40);
    }

    public void handleMouseEvent(MouseEvent mouseEvent) {
        long currentTime = System.currentTimeMillis();
        if (currentTime - clickTime > 300) {
            if (mouseEvent.isLeftMouseButton()) {
                double mouseX = mouseEvent.getX();
                double mouseY = mouseEvent.getY();

                for (int[] bound : numpadBounds) {
                    int x = bound[0];
                    int y = bound[1];
                    int width = bound[2];
                    int height = bound[3];
                    String number = String.valueOf(bound[4]);

                    if (mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height) {
                        enteredNumbers.add(number);
                    }
                    String displayText = String.join("", enteredNumbers);
                    SaxionApp.drawText(displayText, 400, 150, 40);

                    while (enteredNumbers.size() == 3) {
                        if (Integer.valueOf(displayText) == passcode) {
                            SaxionApp.clear();
                            SaxionApp.drawText("You passed this puzzle", 300, 500, 40);
                            break;
                        } else {
                            enteredNumbers.clear();
                            redraw();
                            break;
                        }
                    }
                }
            }
            clickTime = currentTime;
        }
    }

    private void redraw() {
        SaxionApp.clear();
        SaxionApp.drawImage(safeboxImg, 0, 0, 1000, 1000);
        SaxionApp.drawText("Entered Numbers:", 400, 100, 30);
    }
}