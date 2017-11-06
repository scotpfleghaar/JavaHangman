import java.util.*;

public class Prompter {
    private Game game;

    public Prompter(Game game) {
        this.game = game;
    }

    public boolean promptForGuess() {
        Scanner scanner = new Scanner(System.in);
        boolean isHit = false;
        boolean isAccepted = false;

        do {
            System.out.print("Enter a letter:  ");
            String guessInput = scanner.nextLine();
            try {
                isHit = game.applyGuess(guessInput);
                isAccepted = true;
            } catch(IllegalArgumentException iae){
                System.out.printf("%s, please try again.", iae.getMessage());
            }
        } while(!isAccepted);
        return isHit;
    }

    public void displayProgress() {
        System.out.printf("You have %d tries left to solve: %s%n", game.getRemainingTries(), game.getCurrentProgress());
    }
    public void displayOutcome(){
        if(game.isWon()){
            System.out.printf("Congrats you with with %d tries remaining%n",game.getRemainingTries());
        } else {
            System.out.printf("Bummer, the word was %s %n", game.getAnswer());

        }
    }

}
