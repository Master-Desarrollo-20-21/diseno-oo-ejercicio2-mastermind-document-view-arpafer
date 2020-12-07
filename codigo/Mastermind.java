/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind_documentview;

import mastermind_documentview.models.Game;
import mastermind_documentview.views.View;

/**
 *
 * @author Antonio
 */
public class Mastermind {
    
    private Game game;
    private View view;
    
    public Mastermind() {
       
        this.game = new Game();
        this.view = new View(game);
    }

    public void play() {
        
        this.view.show();
        this.view.interact();
    }    
    
    public static void main(String[] args) {
        // TODO code application logic here       
        Mastermind mastermind = new Mastermind();
        mastermind.play();               
    }    
}
