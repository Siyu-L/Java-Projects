public class Character {
  /**
   * values representing character's hp, charge, and name
   */
  private int hp;
  private int charge;
  private String name;

  /**
   * character constructor
   * Creates a new character with health a and charge 0
   * 
   * @param a the character's HP
   * @param n the character's name
   */
  public Character(int a, String n) {
    for (int x = 0; x < a; x++) {
      hp++;
    }
    name = "Player " + n.substring(0, 2);
    charge = 0;
  }

  /**
   * decreases character HP by 1
   */
  public void damage() {
    hp--;

  }

  /**
   * return the HP
   * 
   * @return HP of this Character object
   */
  public int getHp() {
    return hp;
  }

  /**
   * return the name
   * 
   * @return name of this Character object
   */
  public String getName() {
    return name;
  }

  /**
   * increases character charge by 1
   */
  public void addCharge() {
    charge++;
  }

  /**
   * decreases character charge by 1
   */
  public void minusCharge() {
    charge--;

  }

  /**
   * returns the charge
   * 
   * @return charge of this Character object
   */
  public int getCharge() {
    return charge;
  }

  /**
   * prints out your character's name, HP, and charge
   */
  public void print() {
    System.out.println(name + " HP: " + getHp());
    System.out.println(name + " charge: " + getCharge());
  }

  /**
   * prints out opponent character's HP and charge
   */
  public void eprint() {
    System.out.println("Your opponent HP: " + getHp());
    System.out.println("Your opponent charge: " + getCharge());
    System.out.println("");
  }
}
