package mastermind_documentview.views.console;
import mastermind_documentview.models.Game;

public class AttemptView {
    
    private Game game;
    private ProposedCombinationView proposedCombinationView;
    
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
