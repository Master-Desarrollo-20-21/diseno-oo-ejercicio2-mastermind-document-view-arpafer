/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind_documentview.models;

/**
 *
 * @author Antonio
 */
public class Game {

    private final int NUM_ATTEMPTS = 10;
    private Attempt[] attempts;
    private SecretCombination secretCombination;    
    private int attemptIndex;
    
    public Game() {            
        this.initAttempts();
    }    
    public int countHits(int index) {
        return this.secretCombination.countHits(this.attempts[index].getCombinationObject());
    }

    public int countMiddleHits(int index) {
        return this.secretCombination.countMiddleHits(this.attempts[index].getCombinationObject());
    }
    
    public void setProposedCombinationAs(String combination) {
        assert(combination != null);
        this.attempts[this.attemptIndex].setProposedCombination(combination);
    }

    public void generateSecretCombination() {
        this.secretCombination.generate();
    }
            
    public String getSecretCombination() {
        return this.secretCombination.getCombination();
    }

    public boolean isWinnerAttempt(int index) {
        return this.attempts[index].winner();
    }
    
    public void createNextAttempt() {
        this.attemptIndex++;
        this.attempts[this.attemptIndex] = new Attempt(this.secretCombination);        
    }

    public int getProposedCombinationLength() {
        return this.attempts[this.attemptIndex].getCombinationAsString().length();
    }

    public void setProposedCombinationAsValid() {
        
        this.attempts[this.attemptIndex].setProposedCombinationAsValid();
    }

    public String getCombination(int index) {
        return this.attempts[index].getCombinationAsString();
    }
    public String getCurrentCombination() {
        return this.attempts[this.attemptIndex].getCombinationAsString();
    }

    public void setProposedCombinationAsNotValid() {
        this.attempts[this.attemptIndex].setProposedCombinationAsNotValid();
    }

    public void initAttempts() {
        this.attempts = new Attempt[this.NUM_ATTEMPTS];
        this.secretCombination = new SecretCombination();   
        this.attemptIndex = -1;
    }
}
