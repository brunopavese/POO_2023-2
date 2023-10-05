import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Evento {
  public String descricao;
  public int id, ocorrencia;
  public ArrayList<Pessoa> pessoasCadastradas = new ArrayList<>();
  private static Set<Integer> idsUsados = new HashSet<>();

  public Evento(String descricao, int id, ArrayList<Pessoa> pessoasCadastradas) {
    if (idsUsados.contains(id)) {
      throw new IllegalArgumentException("ID já está em uso.");
    }
    this.descricao = descricao;
    this.id = id;
    this.pessoasCadastradas = pessoasCadastradas;

    idsUsados.add(id);
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Evento [ID = ").append(id).append(", Descrição = ").append(descricao).append("]\n");
    stringBuilder.append("Pessoas Cadastradas:\n");
    for (Pessoa pessoa : pessoasCadastradas) {
      stringBuilder.append("- ").append(pessoa).append("\n");
    }
    return stringBuilder.toString();
  }
}