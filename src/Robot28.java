public class Robot28 {
  private String DRE = "116049102";
  private String nome = "Bruno Pavese";
  private String estado = "GO_CENTER";
  public int id, lr, cr, centerC, centerL, previousC, previousL;
  public GPS gps;

  public Robot28(int id, GPS gps) {
    this.id = id;
    this.gps = gps;

    System.out.println("C: " + gps.getC(id));
    goCenter();

  }

  private void goCenter() {
    System.out.println("centerC: " + centerC);

    lr = gps.getL(this.id);
    cr = gps.getC(this.id);
    while (centerL != lr || centerC != cr) {
      if (lr != centerL) {
        if (lr != previousL && centerL == 0) {
          previousL = lr;
          this.gps.move(Move.DOWN);
        } else {
          centerL = previousL / 2 + 1;
          this.gps.move(Move.UP);
        }
      } else if (cr != centerC) {
        if (cr != previousC && centerC == 0) {
          previousC = cr;
          this.gps.move(Move.RIGHT);
        } else {
          centerC = previousC / 2 + 1;
          this.gps.move(Move.LEFT);
        }
      }
      lr = gps.getL(this.id);
      cr = gps.getC(this.id);
    }
    System.out.println("centerC: " + centerC);
  }

  public Move MOVE() {
    Move move = Move.DOWN;
    lr = gps.getL(this.id);
    cr = gps.getC(this.id);

    switch (estado) {
      case ("STOP"):
        move = Move.STOP;
        break;

      case ("GO_CENTER"):
        if (lr == centerL && cr == centerC) {
          estado = "STOP";
          System.out.println("l:" + lr + "  c:" + cr);
          move = Move.STOP;
        } else if (lr != centerL) {
          if (lr != previousL && centerL == 0) {
            previousL = lr;
          } else {
            centerL = previousL / 2 + 1;
            move = Move.UP;
          }
        } else if (cr != centerC) {
          if (cr != previousC && centerC == 0) {
            previousC = cr;
            move = Move.RIGHT;
          } else {
            centerC = previousC / 2 + 1;
            move = Move.LEFT;
          }
        }
        break;

      case ("CLOCKWISE"):
        if (lr != previousL) {
          previousL = lr;
        } else {
          move = Move.LEFT;
        }
        break;
    }

    System.out.println("l:" + lr + "  c:" + cr);
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
