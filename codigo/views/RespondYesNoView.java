/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind_documentview.views;

import mastermind_documentview.utiles.GestorIO;
import mastermind_documentview.models.Message;

/**
 *
 * @author Antonio
 */
public class RespondYesNoView {
       
    RespondYesNoView() {
        
    }
    
    public boolean interact() {
        GestorIO console = new GestorIO();
        Message.RESUME.write();
        String respond = console.inString();
        if (respond.equals("S") || respond.equals("s"))
            return true;
        else 
            return false;
    }
}
