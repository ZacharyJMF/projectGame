package test;
import nl.saxion.app.SaxionApp;

import nl.saxion.app.interaction.GameLoop;
import nl.saxion.app.interaction.KeyboardEvent;
import nl.saxion.app.interaction.MouseEvent;

import java.awt.*;

public class BasicGame implements GameLoop {

    public static void main(String[] args) {
        SaxionApp.startGameLoop(new BasicGame(), 1000, 1000, 40);
    }

    private static Room r1;
    private static final String img2 = "basicGame/2.png";
    //private static final String img3 = "basicGame/3.png";

//    coordinates and size for flower

//    coordinates and size for light


    @Override
    public void init() {
        r1= new Room("resources/1.png");

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
        int mouseX = mouseEvent.getX();
        int mouseY = mouseEvent.getY();
        String position = String.format("the position of the object: X: %d and Y: %d", mouseX,mouseY);
        String output=r1.getClick(mouseX,mouseY);
        System.out.println("Output of click: "+output);
        System.out.println(position);

        // Display text of position
//        SaxionApp.setFill(Color.white);
//        SaxionApp.drawRectangle(0,0,1000,200);
//        SaxionApp.setTextDrawingColor(Color.black);
//        SaxionApp.drawText(position,10,10,20);
        SaxionApp.setFill(Color.RED);
        SaxionApp.drawRectangle(mouseX - 50 ,mouseY - 50 , 100,100);
    }


}






