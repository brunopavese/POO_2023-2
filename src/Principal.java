public class Principal {
    public static void main(String args[]) {
        GPS g1 = new GPS();
        Robot28 r1 = new Robot28(1, g1);
        int i = 0;
        r1.counter_cw();
        while (true) {
            Move m1 = r1.MOVE();
            if (m1 == Move.STOP)
                break;
            g1.move(m1);
            i++;
        }
        r1.print();
        System.out.print("\nFim\n");
    }
}
