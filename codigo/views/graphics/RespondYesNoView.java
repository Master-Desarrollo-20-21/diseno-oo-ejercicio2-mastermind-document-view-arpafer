package mastermind_documentview.views.graphics;
import javax.swing.JOptionPane;
import mastermind_documentview.views.console.*;
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
      this.respondYes = (JOptionPane.showConfirmDialog(null, message, message, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);      
    }
}
