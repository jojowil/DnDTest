import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class DnDGame {

    public static void stats(int g, int p) {
        System.out.println("\nGoblin HP: " + g + "  Player HP: " + p + "\n");
    }

    public static void backstory() throws FileNotFoundException {
        Scanner infile = new Scanner(new FileReader("backstory.txt"));
        while (infile.hasNext()) {
            String line = infile.nextLine();
            System.out.println(line);
        }
        infile.close();
    }

    public static void menu() {
        System.out.println("Commands:");
        System.out.println("Attack");
        System.out.println("Run");
        System.out.println("Use");
        System.out.println("Quit! I'm done!");
        System.out.print("Enter a command: ");
    }

    // Hey, this is our keyboard!
    static Scanner kb = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {

        int gHP = 7, pHP = 12;
        int gAC = 15, pAC = 15;

        String input;
        backstory();
        stats(gHP,pHP);
        menu();
        while (kb.hasNext()) {
            input = kb.nextLine().toUpperCase();
            char c = input.charAt(0);

            if ( c == 'Q') {
                System.out.println("Goodbye...");
                System.exit(0);
            }
            // We're attacking! Yay!
            else if (c == 'A') {
                // player gets d20 + STR modifier
                int toHit = DnD.dn(20) + 1;
                if (toHit >= gAC) {
                    System.out.println("You HIT!");
                    int damage = DnD.dn(8) + 1;
                    gHP = gHP - damage;
                } else
                    System.out.println("Oh no! You MISSED!");
            } else if (c == 'R') {

            } else if (c == 'U') {

            } else
                System.out.println("\n\"" + input + "\" is not a valid choice.\n");

            // how did the monster fair? Dead or attacking?
            if (gHP <= 0) {
                System.out.println("You did it! You won!");
                System.exit(0);
            } else {
                int toHit = DnD.dn(20) + 4;
                if (toHit >= pAC) {
                    int damage = DnD.dn(6) + 2;
                    System.out.println("They HIT you (Ouch!) for " + damage + " points!");
                    pHP = pHP - damage;
                } else
                    System.out.println("Phew! They MISSED!");
            }

            // How did we fair? Are we dead yet?
            if (pHP <= 0) {
                System.out.println("Oh well. Better luck next time...");
                System.exit(0);
            }

            stats(gHP, pHP);
            menu();
        }
    }
}
