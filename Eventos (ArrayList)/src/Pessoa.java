import java.util.HashSet;
import java.util.Set;

public class Pessoa {
  private String nome;
  private int id;
  private static Set<Integer> idsUsados = new HashSet<>();

  public Pessoa(String nome, int id) {
    if (idsUsados.contains(id)) {
      throw new IllegalArgumentException("ID já está em uso.");
    }
    this.nome = nome;
    this.id = id;
    
    idsUsados.add(id);
  }

  @Override
  public String toString() {
    return "Pessoa [Nome = " + nome + ", ID = " + id + "]";
  }
}