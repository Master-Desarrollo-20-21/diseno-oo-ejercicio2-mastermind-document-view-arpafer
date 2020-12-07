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
public class SecretCombinationView  {
    private Game game;
    
    public SecretCombinationView(Game game) {
       this.game = game;    
    }
    
    protected void show() {
        Message.HIDDEN_VIEW.writeln();
    }
    
    public void showResult(int indexAttempt) {
        int blacks = this.game.countHits(indexAttempt);
        int whites = this.game.countMiddleHits(indexAttempt);        
        Message.BLACKS_AND_WHITES.write(blacks, whites);
    }
}
