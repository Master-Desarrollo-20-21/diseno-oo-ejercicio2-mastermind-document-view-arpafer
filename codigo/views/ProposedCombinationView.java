/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind_documentview.views;

import mastermind_documentview.models.Game;
import mastermind_documentview.utiles.GestorIO;
import mastermind_documentview.models.Message;

/**
 *
 * @author Antonio
 */
public class ProposedCombinationView {

    private Game game;
    
    public ProposedCombinationView(Game game) {
        this.game = game;
    }
                    
    protected void show(int indexAttempt) {
        GestorIO console = new GestorIO();
        console.out(this.game.getCombination(indexAttempt));
    }
    protected void readInput() {
        GestorIO console = new GestorIO();
        String aux = console.inString();
        this.game.setProposedCombinationAs(aux);
    }
    public boolean interact() {        
        Message.PROPOSE.write();
        this.readInput();
        boolean valid = true;                
        this.game.setProposedCombinationAsValid();
        if (this.game.getProposedCombinationLength() == 4) {
            for (int i = 0; i < this.game.getProposedCombinationLength(); i++) {
                String aux = this.game.getCurrentCombination().substring(i, i + 1);
                if (!Message.VALID_COLORS.toString().contains(aux)) {
                    Message.WRONG_COLORS.writeln();
                    this.game.setProposedCombinationAsNotValid();
                    valid = false;
                    break;
                }
            }
        } else {
            Message.WRONG_LENGTH.writeln();
             this.game.setProposedCombinationAsNotValid();    
            valid = false;
        }        
        return valid;
    }
}
