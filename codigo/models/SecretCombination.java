package mastermind_documentview.models;

import java.util.Random;

public class SecretCombination extends Combination {
    
    private final String[] colors = {"r", "b", "y", "g", "o", "p"};    

    public void generate() {        
        Random r = new Random();
        while (this.getCombination().length() < Combination.MAX_LENGTH) {
            int indexColor = r.nextInt(6);
            if (!this.getCombination().contains(colors[indexColor]))
               this.addColor(colors[indexColor]);
        }
    }
     
    public String get() {
        return this.getCombination();
    }
   
    private boolean equalsCaracters(ProposedCombination proposedCombination, int i, int j) {
        assert(proposedCombination != null);
        return this.getCombination().substring(i, i + 1).equals(proposedCombination.getCombination().substring(j, j + 1));
    }

    public int countHits(ProposedCombination proposedCombination) {
        assert(proposedCombination != null);        
        int numBlacks = 0;
        for (int i = 0; i < Combination.MAX_LENGTH; i++) {
            if (this.equalsCaracters(proposedCombination, i, i)) {
                numBlacks++;                
            }
        }
        return numBlacks;
    }

    public int countMiddleHits(ProposedCombination proposedCombination) {
        assert(proposedCombination != null);
        int numWhites = 0;        
        for (int i = 0; i < Combination.MAX_LENGTH; i++) {
            for (int j = 0; j < Combination.MAX_LENGTH; j++) {
                if (i != j && this.equalsCaracters(proposedCombination, i, j)) {
                    numWhites++;
                }
            }
        }
        return numWhites;
    }

    public boolean match(ProposedCombination proposedCombination) {
        assert(proposedCombination != null && proposedCombination.getCombination() != null && proposedCombination.getCombination() != "");
        return this.countHits(proposedCombination) == Combination.MAX_LENGTH;
    }
}
