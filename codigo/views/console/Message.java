package mastermind_documentview.views.console;

public enum Message {
   MAIN_TITLE("----- M A S T E R M I N D -----\n\n"),
   WON("won!!!"),
   LOST("lost. The combination is "),
   RESULT("You've "),
   RESUME("¿RESUME? S/n"),
   ATTEMP("Attempt(s)"),
   PROPOSE("Propose a combination: "),
   WRONG_LENGTH("Wrong proposed combination length"),
   WRONG_COLORS("Wrong colors, they must be: rbygop"),
   VALID_COLORS("rbygop"),
   SECRET_COMBINATION_HIDDEN("xxxx"),
   EXCLAMATION(" !!!"),
   ARROW(" --> "),
   BLACKS_AND_WHITES("");

   private String message;
   
   Message(String message) {
       this.message = message;
   }   
   
   public void write() {    
     RenderDevice.getInstance().write(this.message);
   }
   public void writeln() {    
     RenderDevice.getInstance().writeln(this.message);
   }
   public void writeln(String extra) {    
     RenderDevice.getInstance().writeln(this.message + extra);
   }
   public void writeHeadAttempt(int index) {      
      RenderDevice.getInstance().writeln("\n" + index + " " + this.message);
   }
   public void write(int blacks, int whites) {     
     RenderDevice.getInstance().writeln(blacks + " blacks and " + whites + " whites");
   }         
   
   @Override
   public String toString() {
      return this.message;  
   }
}
