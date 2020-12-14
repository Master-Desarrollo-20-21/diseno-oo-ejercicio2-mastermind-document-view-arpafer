package mastermind_documentview;

import mastermind_documentview.models.Game;
import mastermind_documentview.views.graphics.GraphicsView;

public class GraphicsMastermind {
    
    private Game game;
    private GraphicsView view;
    
    public GraphicsMastermind() {       
        this.game = new Game();
        this.view = new GraphicsView(game);
    }

    public void play() {                
        this.view.interact();
    }    
    
    public static void main(String[] args) {            
        GraphicsMastermind mastermind = new GraphicsMastermind();
        mastermind.play();               
    }    
}
