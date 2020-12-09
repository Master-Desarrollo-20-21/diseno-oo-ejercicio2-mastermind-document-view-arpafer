package mastermind_documentview.views;
import mastermind_documentview.utils.GestorIO;

public class RespondYesNoView {
              
    private boolean respondYes;
    
    public RespondYesNoView() {
        this.respondYes = false;
    }
    public boolean affirmative() {
        return this.respondYes;
    }
    public void interact(String message) {
        GestorIO console = new GestorIO();        
        console.out(message);
        String respond = console.inString();
        this.respondYes = respond.equals("S") || respond.equals("s");            
    }
}
