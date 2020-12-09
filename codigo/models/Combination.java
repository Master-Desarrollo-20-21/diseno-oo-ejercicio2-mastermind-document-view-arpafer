package mastermind_documentview.models;

public abstract class Combination {

    public static int MAX_LENGTH = 4;
    
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

    protected void setAs(String combination) {
        this.combination = combination;
    }       
}
