package mastermind_documentview;

import mastermind_documentview.models.Game;
import mastermind_documentview.views.View;

public class Mastermind {
    
    private Game game;
    private View view;
    
    public Mastermind() {       
        this.game = new Game();
        this.view = new View(game);
    }

    public void play() {                
        this.view.interact();
    }    
    
    public static void main(String[] args) {            
        Mastermind mastermind = new Mastermind();
        mastermind.play();               
    }    
}
