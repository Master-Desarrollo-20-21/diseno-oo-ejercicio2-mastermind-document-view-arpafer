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
public class Attempt {    
    private SecretCombination secretCombination;
    private ProposedCombination proposedCombination;

    public Attempt(SecretCombination secretCombination) {        
        this.secretCombination = secretCombination;
        this.proposedCombination = new ProposedCombination();
    }

    public boolean winner() {
        return this.secretCombination.match(this.proposedCombination);
    }        

    public void setProposedCombination(String combination) {
        assert(combination != null);
        this.proposedCombination.set(combination);
    }

    public void setProposedCombinationAsValid() {
        this.proposedCombination.setAsValid();
    }

    public String getCombinationAsString() {
        return this.proposedCombination.getCombination();
    }

    public void setProposedCombinationAsNotValid() {
        this.proposedCombination.setAsNotValid();
    }

    public ProposedCombination getCombinationObject() {
        return this.proposedCombination;
    }
   
}
