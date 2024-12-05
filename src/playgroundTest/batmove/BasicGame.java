package playgroundTest.batmove;

import nl.saxion.app.SaxionApp;
import nl.saxion.app.interaction.GameLoop;
import nl.saxion.app.interaction.KeyboardEvent;
import nl.saxion.app.interaction.MouseEvent;

import java.util.ArrayList;

public class BasicGame implements GameLoop {

    public Bat bat;
    public static void main(String[] args) {
        SaxionApp.startGameLoop(new BasicGame(), 1000, 1000, 40);
    }

    ArrayList<Bat> bats;
    @Override
    public void init() {
        bat = new Bat();
        bat.x=100;
        bat.y=100;
        bat.filename="resources/bat.jpeg";
        bats=new ArrayList<Bat>();
    }

    @Override
    public void loop() {
        SaxionApp.clear();
        bat.draw();

        for (Bat bat : bats) {
            SaxionApp.drawImage(bat.filename, bat.x,bat.y, 100, 100);
        }
    }

    @Override
    public void keyboardEvent(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.isKeyPressed()){
            if (keyboardEvent.getKeyCode() == KeyboardEvent.VK_D){
                bat.x+=10;
            }
            else if (keyboardEvent.getKeyCode() == KeyboardEvent.VK_A){
                bat.x-=10;
            }
            if (keyboardEvent.getKeyCode() == KeyboardEvent.VK_W){
                bat.y-=10;
            }
            if (keyboardEvent.getKeyCode() == KeyboardEvent.VK_S){
                bat.y+=10;
            }
        }
    }

    @Override
    public void mouseEvent(MouseEvent mouseEvent) {
        if(mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()){
            bat.x=mouseEvent.getX();
            bat.y=mouseEvent.getY();
            bats.add(bat);
        }
    }
}






