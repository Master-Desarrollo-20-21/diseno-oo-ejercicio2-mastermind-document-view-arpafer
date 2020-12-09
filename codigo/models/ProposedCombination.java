package mastermind_documentview.models;

public class ProposedCombination extends Combination {
                
    private boolean valid;

    public ProposedCombination() {
        this.valid = false;
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
