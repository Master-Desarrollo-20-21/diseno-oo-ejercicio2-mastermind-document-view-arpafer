package mastermind_documentview.views;
import mastermind_documentview.models.Game;
import mastermind_documentview.views.ProposedCombinationView;
import mastermind_documentview.views.SecretCombinationView;

public class AttemptView {

    private Game game;
    ProposedCombinationView proposedCombinationView;
    
    public AttemptView(Game game) {
       this.game = game;    
    }
               
    public void interact() {
        this.proposedCombinationView = new ProposedCombinationView(this.game);
        while (!this.game.isProposedCombinationValid()) {
           proposedCombinationView.interact();         
        }
    }
    public void showAttemptCount(int countAttempt) {
        Message.ATTEMP.writeHeadAttempt(countAttempt);        
    }
    
    public void showResult(int countAttempt) {        
        this.proposedCombinationView.show(countAttempt);
        Message.ARROW.write();
        SecretCombinationView secretCombinationView = new SecretCombinationView(this.game);
        secretCombinationView.showMatchResult(countAttempt);
    }
}
