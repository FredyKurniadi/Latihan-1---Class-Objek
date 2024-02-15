class Node {
  private String value;
  private Node next;

  public Node(String value) {
      this.value = value;
      this.next = null;
  }

  public String getValue() {
      return value;
  }

  public void setValue(String value) {
      this.value = value;
  }

  public Node getNext() {
      return next;
  }

  public void setNext(Node next) {
      this.next = next;
  }
}

class LinkedList {
  private Node head;

  public LinkedList() {
      this.head = null;
  }

  public void addLast(String value) {
      Node newNode = new Node(value);
      if (head == null) {
          head = newNode;
      } else {
          Node current = head;
          while (current.getNext() != null) {
              current = current.getNext();
          }
          current.setNext(newNode);
      }
  }

  public Node getHead() {
      return head;
  }
}

class Hero {
  private static int count = 0;
  private String name;
  private int damage;
  private int health;
  private int defense;
  private int kill;
  private int slayed;
  private int assist;

  public Hero(String name, int damage, int health, int defense) {
      this.name = name;
      this.damage = damage;
      this.health = health;
      this.defense = defense;
      this.kill = 0;
      this.slayed = 0;
      this.assist = 0;
  }

  public void addPlayer() {
      System.out.println("Hero " + name + " berhasil dibuat");
      count++;
      System.out.println("Jumlah player yang terbentuk ada " + count);
  }

  // Getter and setter methods
  public String getName() {
      return name;
  }

  public void setName(String name) {
      this.name = name;
  }

  public int getDamage() {
      return damage;
  }

  public void setDamage(int damage) {
      this.damage = damage;
  }

  public int getHealth() {
      return health;
  }

  public void setHealth(int health) {
      this.health = health;
  }

  public int getDefense() {
      return defense;
  }

  public void setDefense(int defense) {
      this.defense = defense;
  }

  public void attack(Hero enemy) {
      System.out.println(name + " attack " + enemy.getName());
      enemy.attacked(this);
  }

  public void attacked(Hero attacker) {
      System.out.println(name + " attacked by " + attacker.getName());
  }
}

class Team {
  private String color;
  private LinkedList players;
  private int playerCount;

  public Team(String color) {
      this.color = color;
      this.players = new LinkedList();
      this.playerCount = 0;
  }

  public void addPlayer(String name) {
      players.addLast(name);
      playerCount++;
  }

  public void printTeam() {
      if (playerCount == 5) {
          System.out.println("\nTim " + color + ":");
          Node current = players.getHead();
          for (int i = 0; i < 5; i++) {
              System.out.println((i + 1) + ". " + current.getValue());
              current = current.getNext();
          }
      }
  }
}

public class Main {
  private static Team teamRed;
  private static Team teamBlue;
  private static Hero[] player;

  private static void createGame(String[] names, int[] damages, int[] healths, int[] defenses, String[] groups) {
      teamRed = new Team("red");
      teamBlue = new Team("blue");
      player = new Hero[10];
      for (int i = 0; i < 10; i++) {
          player[i] = new Hero(names[i], damages[i], healths[i], defenses[i]);
          player[i].addPlayer();
          if (groups[i].equals("red")) {
              teamRed.addPlayer(player[i].getName());
          } else {
              teamBlue.addPlayer(player[i].getName());
          }
      }

      teamRed.printTeam();
      teamBlue.printTeam();
  }

  public static void main(String[] args) {
      String[] names = {"Fredy", "Salwa", "Carrisa", "Zahra", "Rafif", "Alnez", "Nadia", "Aslim", "Ichsan", "Faruq"};
      int[] damages = {5, 7, 3, 6, 2, 5, 3, 8, 6, 10};
      int[] healths = {100, 150, 80, 50, 70, 60, 70, 120, 100, 90};
      int[] defenses = {5, 8, 3, 6, 4, 8, 5, 6, 3, 9};
      String[] groups = {"red", "red", "red", "red", "red", "blue", "blue", "blue", "blue", "blue"};

      createGame(names, damages, healths, defenses, groups);

      System.out.println();
      player[0].attack(player[1]);
  }
}
