public class Robot28 {
  private String DRE = "116049102";
  private String nome = "Bruno Pavese";
  private String estado = "STOP";
  private Move[] moves = { Move.DOWN, Move.LEFT, Move.UP, Move.RIGHT };
  private int i = 0;
  public int id, lr, cr, centerL, centerC, previousL, previousC, maxL, maxC;
  public GPS gps;

  public Robot28(int id, GPS gps) {
    this.id = id;
    this.gps = gps;
  }

  private void goCenter() {
    while (centerL != lr || centerC != cr) {
      if (lr != centerL) {
        if (lr != previousL && centerL == 0) {
          previousL = lr;
          gps.move(Move.DOWN);
        } else {
          maxL = previousL;
          centerL = previousL / 2 + 1;
          gps.move(Move.UP);
        }
      } else if (cr != centerC) {
        if (cr != previousC && centerC == 0) {
          previousC = cr;
          gps.move(Move.RIGHT);
        } else {
          maxC = previousC;
          centerC = previousC / 2 + 1;
          gps.move(Move.LEFT);
        }
      }
      lr = gps.getL(id);
      cr = gps.getC(id);
    }
  }

  public Move MOVE() {
    lr = gps.getL(id);
    cr = gps.getC(id);

    Move move = Move.DOWN;

    switch (estado) {
      case ("STOP"):
        move = Move.STOP;
        break;

      case ("GO_CENTER"):
        goCenter();
        estado = "STOP";
        move = Move.STOP;
        break;

      case ("CLOCKWISE"):
        if (lr == previousL && cr == previousC) {
          i = (i + 1) % moves.length;
        } else {
          previousC = cr;
          previousL = lr;
        }
        move = moves[i];
        break;

      case ("COUNTER_CW"):
        if (lr == previousL && cr == previousC) {
          i--;
          if (i < 0) {
            i = moves.length - 1;
          }
        } else {
          previousC = cr;
          previousL = lr;
        }
        move = moves[i];
        break;
    }

    System.out.println("\nl:" + lr + "  c:" + cr);
    System.out.println("move: " + move);
    return move;
  }

  public void print() {
    System.out.println("DRE: " + DRE + "\n" + "Nome: " + nome);
  }

  public void stop() {
    estado = "STOP";
  }

  public void clockwise() {
    estado = "CLOCKWISE";
  }

  public void counter_cw() {
    estado = "COUNTER_CW";
  }

  public void alternating() {
    estado = "ALTERNATING";
  }

  public void sweep() {
    estado = "SWEEP";
  }
}
