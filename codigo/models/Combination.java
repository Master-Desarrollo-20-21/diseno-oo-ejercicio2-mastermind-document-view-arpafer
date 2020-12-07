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
public abstract class Combination {
    
    private String combination;
    
    protected Combination() {
        this.combination = new String();
        this.combination = "";
    }    
    
    protected String getCombination() {
        return this.combination;
    }
    protected void addColor(String color) {
        this.combination += color;
    }

    protected void setAs(String inString) {
        this.combination = inString;
    }       
}
