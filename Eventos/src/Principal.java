import java.util.Scanner;

public class Principal {
  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    int x;
    int[] eventosAcontecidos = new int[0];
    Pessoa[] listaDePessoas = new Pessoa[0];
    Pessoa[] todasPessoas = new Pessoa[0];
    Evento[] todosEventos = new Evento[0];

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
            listaDePessoas = adicionaPessoaNoArray(listaDePessoas, pessoa);
            todasPessoas = adicionaPessoaNoArray(todasPessoas, pessoa);
          } catch (IllegalArgumentException e) {
            System.out.println("\u001B[31mErro ao cadastrar pessoa: " + e.getMessage() + "\u001B[0m\n");
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
            listaDePessoas = new Pessoa[0];
            todosEventos = adicionaEventoNoArray(todosEventos, evento);
          } catch (IllegalArgumentException e) {
            System.out.println("\u001B[31mErro ao cadastrar evento: " + e.getMessage() + "\u001B[0m\n");
          }
          break;
        case (-3):
          System.out.print("Listar pessoas\n");
          for (int i = 0; i < todasPessoas.length; i++) {
            Pessoa pessoa = todasPessoas[i];
            System.out.println("Eventos em que " + pessoa.nome + " de ID " + pessoa.id + " participa:");
            for (int j = 0; j < todosEventos.length; j++) {
              System.out.println(todosEventos[j].descricao);
            }
            System.out.println("\n");
          }
          break;
        default:
          if (x < 0) {
            break;
          } else {
            Evento eventoEncontrado = null;
            for (Evento evento : todosEventos) {
              if (evento.id == x) {
                eventoEncontrado = evento;
                break;
              }
            }
            if (eventoEncontrado != null) {
              int[] novoArray = new int[eventosAcontecidos.length + 1];
              novoArray[0] = x;
              for (int i = 0; i < eventosAcontecidos.length; i++) {
                novoArray[i + 1] = eventosAcontecidos[i];
              }
              eventosAcontecidos = novoArray;
              eventoEncontrado.ocorre();
              System.out.println("\u001B[32mAconteceu um evento: \u001B[0m\n" + eventoEncontrado);
            } else {
              System.out.println("Evento com ID " + x + "\u001B[31m não encontrado\u001B[0m");
            }
            imprimirEventosAcontecidos(eventosAcontecidos);
            break;
          }
      }
    } while (x != 0);
    scanner.close();
  }

  private static Pessoa[] adicionaPessoaNoArray(Pessoa[] array, Pessoa pessoa) {
    Pessoa[] arrayAux = new Pessoa[array.length + 1];
    for (int i = 0; i < array.length; i++) {
      arrayAux[i] = array[i];
    }
    arrayAux[array.length] = pessoa;
    return arrayAux;
  }

  private static Evento[] adicionaEventoNoArray(Evento[] array, Evento evento) {
    Evento[] arrayAux = new Evento[array.length + 1];
    for (int i = 0; i < array.length; i++) {
      arrayAux[i] = array[i];
    }
    arrayAux[array.length] = evento;
    return arrayAux;
  }

  private static void imprimirEventosAcontecidos(int[] eventosAcontecidos) {
    System.out.println("Eventos Acontecidos:");
    for (int id : eventosAcontecidos) {
      System.out.print(id + " ");
    }
    System.out.println("\n");

  }
}