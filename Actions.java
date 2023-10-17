import java.util.Scanner;

public class Actions {
  /**
   * your's and opponent's characters
   */
  private Character yours;
  private Character opponent;
  /**
   * value representing the number of rounds
   */
  private static int round = 1;
  /**
   * values representing actions chosen by you and opponent
   */
  private int choice1;
  private int choice2;

  /**
   * Actions constructor
   * initializes yours and opponent
   * 
   * @param a your character's HP
   * @param b opponent's HP
   * @param n your character's name
   */
  public Actions(int a, int b, String n) {
    yours = new Character(a, n);
    opponent = new Character(b, "opponent");
  }

  /**
   * you and opponent choose action
   * 
   * @see #attack()
   * @see #defend()
   * @see #charge()
   */
  public void choose() {
    round++;
    System.out.print("Choose your move: ");
    Scanner scan = new Scanner(System.in);
    choice1 = scan.nextInt();
    while (!(choice1 > 0 && choice1 < 4)) {
      System.out.println("Invalid move");
      System.out.println("Attack (1), Defend(2), Charge(3)");
      choice1 = scan.nextInt();
    }
    if (opponent.getCharge() == 0) {
      choice2 = 3;
    } else {
      choice2 = (int) (Math.random() * 3) + 1;
    }

    if (choice1 == 1) {
      attack();
    } else if (choice1 == 2) {
      defend();
    } else {
      charge();
    }
    yours.print();
    opponent.eprint();
  }

  /**
   * you attack the enemy, decreases charge by 1
   * you can only attack if your charge is greater than 0
   * if enemy attacks or defends, no damage is taken
   */
  public void attack() {
    if (yours.getCharge() == 0) {
      System.out.println("Charge before you can attack");

    } else if (!(choice2 != 2 || yours.getCharge() == 0)) {
      yours.minusCharge();
      System.out.println("Enemy defended attack, no damage was taken, charge reduced");

    } else if (choice2 == 1 && yours.getCharge() != 0) {
      yours.minusCharge();
      System.out.println("You and the enemy attacked, no damage was taken, charge reduced for both.");
      opponent.minusCharge();

    } else if (choice2 == 3 && yours.getCharge() != 0) {
      opponent.damage();
      yours.minusCharge();
      opponent.addCharge();
      System.out.println("Enemy took damage +1.");
    }
  }

  /**
   * you charge, increasing charge by 1
   * each charge allows you to attack once
   */
  public void charge() {
    if (choice2 == 1) {
      opponent.minusCharge();
      yours.damage();
      yours.addCharge();
      System.out.println("You took damage -1, charge +1");

    } else if (choice2 == 2) {
      yours.addCharge();
      System.out.println("Enemy defended nothing, charge +1");
    } else if (choice2 == 3) {
      yours.addCharge();
      opponent.addCharge();
      System.out.println("No damage taken, charge +1 for both.");
    }
  }

  /**
   * you defend, nullifying opponent's attack
   */
  public void defend() {
    if (choice2 == 1) {
      if (opponent.getCharge() != 0) {
        opponent.minusCharge();
        System.out.println("You defended the enemy attack, enemy charge -1");
      }

    } else if (choice2 == 3) {
      opponent.addCharge();
      System.out.println("You defended nothing, enemy charge +1");

    } else if (choice2 == 2) {
      System.out.println("No damage taken");
    }
  }

  /**
   * returns your character's HP
   * 
   * @return yours.getHP() the HP for your character
   */
  public int getYourHealth() {
    return yours.getHp();
  }

  /**
   * returns opponent character's HP
   * 
   * @return opponent.getHP() the HP for opponent character
   */
  public int getOpponentHealth() {
    return opponent.getHp();
  }

  /**
   * returns your character's name
   * 
   * @return yours.getName() the name for your character
   */
  public String getYourName() {
    return yours.getName();
  }

  /**
   * returns the number of rounds since start of the game
   * 
   * @return round the number of turns
   */
  public int getRound() {
    return round;
  }

  /**
   * resets round to 1, signaling the restart of the game
   */
  public void resetRound() {
    round = 1;
  }
}
