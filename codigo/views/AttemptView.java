/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind_documentview.views;

import mastermind_documentview.models.Game;
import mastermind_documentview.models.Message;
import mastermind_documentview.views.ProposedCombinationView;
import mastermind_documentview.views.SecretCombinationView;

/**
 *
 * @author Antonio
 */
public class AttemptView {

    private Game game;
    ProposedCombinationView proposedCombinationView;
    
    public AttemptView(Game game) {
       this.game = game;    
    }
               
    public void interact() {
        this.proposedCombinationView = new ProposedCombinationView(this.game);
        while (!proposedCombinationView.interact()) {

        }        
    }
    public void showHead(int index) {
        Message.ATTEMP.writeHeadAttempt(index);
        SecretCombinationView secretCombinationView = new SecretCombinationView(this.game);        
        secretCombinationView.show();
    }
    
    public void showResult(int index) {        
        this.proposedCombinationView.show(index);
        Message.ARROW.write();
        SecretCombinationView secretCombinationView = new SecretCombinationView(this.game);
        secretCombinationView.showResult(index);
    }
}
