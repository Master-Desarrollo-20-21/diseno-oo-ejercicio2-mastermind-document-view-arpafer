package mastermind_documentview.views;
import mastermind_documentview.utils.GestorIO;

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
      GestorIO console = new GestorIO();
      console.out(this.message);
   }
   public void writeln() {
       GestorIO console = new GestorIO();
       console.out(this.message + "\n");
   }
   public void writeln(String extra) {
       GestorIO console = new GestorIO();
       console.out(this.message + extra + "\n");
   }
   public void writeHeadAttempt(int index) {
       GestorIO console = new GestorIO();
       console.out("\n" + index + " " + this.message + "\n");
   }
   public void write(int blacks, int whites) {
       GestorIO console = new GestorIO();
       console.out(blacks + " blacks and " + whites + " whites\n");
   }         
   
   @Override
   public String toString() {
      return this.message;  
   }
}
