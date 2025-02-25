public class DnD {

    public static int dn(int d) {
        return (int)(Math.random() * d + 1);
    }

    public static int percent() {
        return (int)(Math.random() * 100);
    }

    public static void main(String[] args) {

        int d100 = percent();
        int d20 = dn(20);
        int d10 = dn(10);
        int d8  = dn(8);

        System.out.println("d100 = " + d100);
        System.out.println("d20 = " + d20);
        System.out.println("d10 = " + d10);
        System.out.println("d8  = " + d8);
    }
}
