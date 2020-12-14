package mastermind_documentview.views.graphics;
import mastermind_documentview.views.console.*;
import mastermind_documentview.models.Game;
import mastermind_documentview.utils.GestorIO;

public class ProposedCombinationView {

    private Game game;
    
    public ProposedCombinationView(Game game) {
        this.game = game;
    }
                    
    protected void show(int countAttempt) {      
      RenderDevice.getInstance().write(this.game.getCombination(countAttempt));
    }
    protected void readInput() {
      String combination = RenderDevice.getInstance().read();
      this.game.setProposedCombination(combination);
    }
    public void interact() {        
        Message.PROPOSE.write();
        this.readInput();                     
        this.game.setProposedCombinationAsValid();
        if (this.game.getProposedCombinationLength() == this.game.getMaxCombinationLength()) {
            for (int i = 0; i < this.game.getMaxCombinationLength(); i++) {
                String currentCombination = this.game.getCurrentCombination().substring(i, i + 1);
                if (!this.validColors(currentCombination)) {
                    Message.WRONG_COLORS.writeln();
                    this.game.setProposedCombinationAsNotValid();                    
                    return;
                }
            }
        } else {
            Message.WRONG_LENGTH.writeln();
            this.game.setProposedCombinationAsNotValid();                
        }                
    }
    private boolean validColors(String combination) {
        return Message.VALID_COLORS.toString().contains(combination);
    }
}
