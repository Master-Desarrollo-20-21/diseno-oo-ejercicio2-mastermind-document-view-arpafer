package mastermind_documentview;

import mastermind_documentview.models.Game;
import mastermind_documentview.views.console.ConsoleView;

public class ConsoleMastermind {
    
    private Game game;
    private ConsoleView view;
    
    public ConsoleMastermind() {       
        this.game = new Game();
        this.view = new ConsoleView(game);
    }

    public void play() {                
        this.view.interact();
    }    
    
    public static void main(String[] args) {            
        ConsoleMastermind mastermind = new ConsoleMastermind();
        mastermind.play();               
    }    
}
