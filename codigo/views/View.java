/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind_documentview.views;

import mastermind_documentview.models.Game;
import mastermind_documentview.models.Message;

/**
 *
 * @author Antonio
 */
public class View {

    private AttemptView attemptView;        
    
    private Game game; 
    private final int NUM_ATTEMPTS = 10;
    
    public View(Game game) {
       this.game = game;
       this.attemptView = new AttemptView(game);              
    }

    public void show() {
        Message.MAIN_TITLE.writeln();
    }

    public void interact() {
        
        do {
            this.game.initAttempts();
            this.game.generateSecretCombination();
            int numAttempt = 0;                               
            do {      
                this.game.createNextAttempt();
                this.attemptView.showHead(numAttempt);             
                this.showAcumulatedResults(numAttempt);                
                this.attemptView.interact();
                numAttempt++;
            } while (!this.game.isWinnerAttempt(numAttempt - 1) && numAttempt < this.NUM_ATTEMPTS);            
            this.showResult(numAttempt);
        } while (this.wantOtherGame());
    }
    
    private boolean wantOtherGame() {
        RespondYesNoView respond = new RespondYesNoView();
        return respond.interact();
    }

    private void showResult(int numAttempt) {
        
        String result = "";
        if (this.game.isWinnerAttempt(numAttempt - 1))
            result = Message.WON.toString();
        else
            result = Message.LOST + this.game.getSecretCombination() + Message.EXCLAMATION;
                
        Message.RESULT.writeln(result);
    }

    private void showAcumulatedResults(int numAttempt) {
        for (int i = 0; i < numAttempt; i++) {            
            attemptView.showResult(i);                        
        }
    }
       
}
