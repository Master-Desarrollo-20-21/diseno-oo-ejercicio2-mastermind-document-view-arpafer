/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind_documentview.models;

import java.util.Random;

/**
 *
 * @author Antonio
 */
public class SecretCombination extends Combination {
    
    private final String[] colors = {"r", "b", "y", "g", "o", "p"};
    private final int MAX_SIZE_COMBINATION = 4;

    public void generate() {        
        Random r = new Random();
        while (this.getCombination().length() < MAX_SIZE_COMBINATION) {
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
        for (int i = 0; i < MAX_SIZE_COMBINATION; i++) {
            if (this.equalsCaracters(proposedCombination, i, i)) {
                numBlacks++;                
            }
        }
        return numBlacks;
    }

    public int countMiddleHits(ProposedCombination proposedCombination) {
        assert(proposedCombination != null);
        int numWhites = 0;
        
        for (int i = 0; i < MAX_SIZE_COMBINATION; i++) {
            for (int j = 0; j < MAX_SIZE_COMBINATION; j++) {
                if (i != j && this.equalsCaracters(proposedCombination, i, j)) {
                    numWhites++;
                }
            }
        }
        return numWhites;
    }

    public boolean match(ProposedCombination proposedCombination) {
        assert(proposedCombination != null);
        return this.countHits(proposedCombination) == this.MAX_SIZE_COMBINATION;
    }
}
