package MD;

import nl.saxion.app.SaxionApp;

import nl.saxion.app.interaction.MouseEvent;

public class MainMenu {
    boolean show=true;

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }
    public void draw(){
        SaxionApp.drawText("Finding Game", 350, 200, 30);
        SaxionApp.drawRectangle(350, 250, 100, 50); // Start button border
        SaxionApp.drawText("Start", 375, 275, 20);
    }
    public void click(MouseEvent e){
        if(e.isLeftMouseButton()){
            show=false;
        }
    }
}
