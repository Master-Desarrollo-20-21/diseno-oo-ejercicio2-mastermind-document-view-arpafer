package mastermind_documentview.views.console;
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
        String respond = RenderDevice.getInstance().readRespond(message);
        this.respondYes = respond.equals("S") || respond.equals("s");            
    }
}
