package mastermind_documentview.views.graphics;
import javax.swing.JFrame;
import mastermind_documentview.views.console.*;
import mastermind_documentview.models.Game;

public class GraphicsView extends JFrame {

    private Game game;
    private AttemptView attemptView;                   
    
    public GraphicsView(Game game) {
       this.game = game;
       this.attemptView = new AttemptView(game);                     
    }
   
    public void interact() {        
        Message.MAIN_TITLE.writeln();
        SecretCombinationView secretCombinationView = new SecretCombinationView(game);        
        do {
            this.game.init();   
            this.attemptView.showAttemptCount(this.game.getCountAttempt());             
            secretCombinationView.showEncoded();
            do {                                                    
                this.game.createAttempt();
                this.attemptView.interact();                
                this.attemptView.showAttemptCount(this.game.getCountAttempt() + 1);             
                secretCombinationView.showEncoded();
                this.game.incrementAttempt();
                this.showAcumulatedResults(this.game.getCountAttempt());                  
            } while (!this.game.terminated());            
            this.showGameResult(this.game.getCountAttempt());
        } while (this.resume());
    }
    
    private boolean resume() {
        RespondYesNoView respond = new RespondYesNoView();
        respond.interact(Message.RESUME.toString());
        return respond.affirmative();
    }

    private void showGameResult(int numAttempt) {        
        String result = "";
        if (this.game.isWinnerAttempt(numAttempt - 1)) {
            result = Message.WON.toString();
        } else {
            result = Message.LOST + this.game.getSecretCombination() + Message.EXCLAMATION;
        }                
        Message.RESULT.writeln(result);
    }

    private void showAcumulatedResults(int numAttempt) {
        for (int i = 0; i < numAttempt; i++) {            
            attemptView.showResult(i);                        
        }
    }
       
}
