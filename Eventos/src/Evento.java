import java.util.HashSet;
import java.util.Set;

public class Evento {
  public String descricao;
  public int id, ocorrencia;
  public Pessoa[] pessoasCadastradas = new Pessoa[0];
  private static Set<Integer> idsUsados = new HashSet<>();

  public Evento(String descricao, int id, Pessoa[] pessoasCadastradas) {
    if (idsUsados.contains(id)) {
      throw new IllegalArgumentException("ID já está em uso.");
    } else if (id <= 0) {
      throw new IllegalArgumentException("ID inválido.");
    }
    this.descricao = descricao;
    this.id = id;
    this.pessoasCadastradas = pessoasCadastradas;
    this.ocorrencia = 0;

    idsUsados.add(id);
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Evento [ID = ").append(id).append(", Descrição = ").append(descricao)
        .append(", Nº de ocorrências = ").append(ocorrencia).append("]\n");
    stringBuilder.append("Pessoas Cadastradas:\n");
    for (Pessoa pessoa : pessoasCadastradas) {
      stringBuilder.append("- ").append(pessoa).append("\n");
    }
    return stringBuilder.toString();
  }

  public void ocorre() {
    ocorrencia++;
  }
}