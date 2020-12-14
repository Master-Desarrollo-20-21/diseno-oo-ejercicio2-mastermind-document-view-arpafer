package mastermind_documentview.views.console;
import mastermind_documentview.models.Game;

public class SecretCombinationView  {
    private Game game;
    
    public SecretCombinationView(Game game) {
       this.game = game;    
    }
    
    public void showEncoded() {
        Message.SECRET_COMBINATION_HIDDEN.writeln();
    }
    
    public void showMatchResult(int countAttempt) {
        int blacks = this.game.countHits(countAttempt);
        int whites = this.game.countMiddleHits(countAttempt);        
        Message.BLACKS_AND_WHITES.write(blacks, whites);
    }
}
