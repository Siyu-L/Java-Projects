import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner console = new Scanner(System.in);
    /**
     * int next keeps for loop running for as long as user doesn't enter -1
     */
    int next = 1;
    for (int j = 1; next > 0; j++) {
      /**
       * choose your character's HP and name
       */
      System.out.println("Game: " + j);
      System.out.println("Choose your HP: (1 - 5)");
      int hp1 = console.nextInt();
      while (!(hp1 > 0 && hp1 < 6)) {
        System.out.println("Invalid Number: (1 - 5)");
        hp1 = console.nextInt();
      }
      System.out.println("Choose your character's name: ");
      String name1 = console.next();
      /**
       * choose opponent character's HP
       */
      System.out.println("Choose your opponents HP: (1 - 5)");
      int hp2 = console.nextInt();

      while (!(hp2 > 0 && hp2 < 6)) {
        System.out.println("Invalid Number: (1 - 5)");
        hp2 = console.nextInt();
      }
      /**
       * ) * creates new Actions object, initializing yours and opponent characters
       */
      Actions act = new Actions(hp1, hp2, name1);
      /**
       * while loop runs as long as both health is greater than 0
       * 
       */
      while (act.getYourHealth() > 0 && act.getOpponentHealth() > 0) {
        System.out.println("Round: " + act.getRound());
        System.out.println("Attack (1), Defend(2), Charge(3)");
        act.choose();
      }
      /**
       * whoever's health is greater than 0 at the end of the while loop wins
       */
      if (act.getYourHealth() > act.getOpponentHealth()) {
        System.out.println(act.getYourName() + " won!");
      } else {
        System.out.println("Your opponent won!");
      }
      /**
       * restarts game or ends game
       */
      System.out.println("Next Round (-1 if no): ");
      act.resetRound();
      next = console.nextInt();
      System.out.println("");

    }
    console.close();
  }

}
