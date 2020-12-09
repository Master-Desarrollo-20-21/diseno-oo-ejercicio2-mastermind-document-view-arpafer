package mastermind_documentview.models;

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
    
    public void setProposedCombinationAsNotValid() {
        this.proposedCombination.setAsNotValid();
    }

    public String getCombination() {
        return this.proposedCombination.getCombination();
    }
       
    public boolean isProposedCombinationValid() {
        return this.proposedCombination.isValid();
    }

    public ProposedCombination getProposedCombination() {
        return this.proposedCombination;
    }
   
}
