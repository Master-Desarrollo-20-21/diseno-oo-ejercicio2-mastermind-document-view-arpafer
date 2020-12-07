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
public class ProposedCombination extends Combination {
                
    private boolean valid;

    public ProposedCombination() {
        this.valid = true;
    }

    public ProposedCombination(String aux) {
        this.setAs(aux);
    }
           
    public void set(String combination) {
        this.setAs(combination);
    }
    public String ToString() {
        return this.getCombination();
    }

    public boolean isValid() {
        return this.valid;
    }

    public void setAsValid() {
        this.valid = true;
    }

    public void setAsNotValid() {
        this.valid = false;
    }
}
