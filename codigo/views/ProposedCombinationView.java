package mastermind_documentview.views;
import mastermind_documentview.models.Game;
import mastermind_documentview.utils.GestorIO;

public class ProposedCombinationView {

    private Game game;
    
    public ProposedCombinationView(Game game) {
        this.game = game;
    }
                    
    protected void show(int countAttempt) {
        GestorIO console = new GestorIO();
        console.out(this.game.getCombination(countAttempt));
    }
    protected void readInput() {
        GestorIO console = new GestorIO();
        String aux = console.inString();
        this.game.setProposedCombination(aux);
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
