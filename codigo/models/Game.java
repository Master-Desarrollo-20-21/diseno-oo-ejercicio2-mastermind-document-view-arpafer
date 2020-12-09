package mastermind_documentview.models;

public class Game {

    private final int NUM_ATTEMPTS = 10;
    private Attempt[] attempts;
    private SecretCombination secretCombination;    
    private int countAttempt;
        
    public void init() {
        this.attempts = new Attempt[this.NUM_ATTEMPTS];
        this.secretCombination = new SecretCombination();   
        this.secretCombination.generate();
        this.countAttempt = 0;
    }
     
    public int countHits(int countAttempt) {
        return this.secretCombination.countHits(this.attempts[countAttempt].getProposedCombination());
    }

    public int countMiddleHits(int countAttempt) {
        return this.secretCombination.countMiddleHits(this.attempts[countAttempt].getProposedCombination());
    }
    
    public void setProposedCombination(String combination) {
        assert(combination != null);
        this.attempts[this.countAttempt].setProposedCombination(combination);
    }
              
    public String getSecretCombination() {
        return this.secretCombination.getCombination();
    }

    public boolean isWinnerAttempt(int countAttempt) {
        return this.attempts[countAttempt].winner();
    }
    
    public void createAttempt() {        
        assert(this.countAttempt < this.NUM_ATTEMPTS);
        this.attempts[this.countAttempt] = new Attempt(this.secretCombination);            
    }
    public void incrementAttempt() {
        this.countAttempt++;
    }
    
    public int getCountAttempt() {
        return this.countAttempt;
    }

    public int getProposedCombinationLength() {
        return this.attempts[this.countAttempt].getCombination().length();
    }

    public void setProposedCombinationAsValid() {        
        this.attempts[this.countAttempt].setProposedCombinationAsValid();
    }

    public void setProposedCombinationAsNotValid() {
        this.attempts[this.countAttempt].setProposedCombinationAsNotValid();
    }
    public boolean isProposedCombinationValid() {        
        return this.attempts[this.countAttempt].isProposedCombinationValid();        
    }
     
    public String getCombination(int countAttempt) {
        return this.attempts[countAttempt].getCombination();
    }
    public String getCurrentCombination() {
        return this.attempts[this.countAttempt].getCombination();
    }
      
    public boolean terminated() {       
        return this.attempts[this.countAttempt - 1].winner() || this.countAttempt >= this.NUM_ATTEMPTS;
    }

    public int getMaxCombinationLength() {
        return Combination.MAX_LENGTH;
    }   
}
