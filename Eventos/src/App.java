import java.util.*;

public class App {
  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    int x;
    ArrayList<Pessoa> listaDePessoas = new ArrayList<>();

    do {
      System.out.print("Escolha uma das opções (0, -1, -2 ou -3): ");
      x = scanner.nextInt();
      scanner.nextLine();
      int id;
      String nome, descricao;

      switch (x) {

        case (0):
          System.out.print("Saindo...\n");
          break;
        case (-1):
          System.out.print("Cadastrar pessoa\n");

          System.out.print("ID: ");
          id = scanner.nextInt();
          scanner.nextLine();

          System.out.print("Nome: ");
          nome = scanner.nextLine();

          try {
            Pessoa pessoa = new Pessoa(nome, id);
            System.out.println(pessoa + " \u001B[32m cadastrada com sucesso!\u001B[0m\n");
            listaDePessoas.add(pessoa);
          } catch (IllegalArgumentException e) {
            System.out.println("\u001B[31mErro ao cadastrar pessoa: ID já está em uso\u001B[0m\n");
          }
          break;
        case (-2):
          System.out.print("Cadastrar evento\n");

          System.out.print("ID: ");
          id = scanner.nextInt();
          scanner.nextLine();

          System.out.print("Descrição: ");
          descricao = scanner.nextLine();

          try {
            Evento evento = new Evento(descricao, id, listaDePessoas);
            System.out.println(evento + " \u001B[32m Evento cadastrado com sucesso!\u001B[0m\n");
            listaDePessoas.clear();
          } catch (IllegalArgumentException e) {
            System.out.println("\u001B[31mErro ao cadastrar evento: ID já está em uso\u001B[0m\n");
          }
          break;
        case (-3):
          System.out.print("Listar pessoas\n");
          break;
      }
    } while (x != 0);
    scanner.close();
  }
}