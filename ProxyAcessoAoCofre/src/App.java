import java.util.Scanner;

public class App {
 public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int opcao;

        do {

            System.out.println();
            System.out.println(
                    "======================================"
            );
            System.out.println(
                    "            PADRÃO PROXY"
            );
            System.out.println(
                    "======================================"
            );
            System.out.println();

            System.out.println(
                    "O padrão Proxy utiliza um objeto"
            );
            System.out.println(
                    "intermediário para controlar o acesso"
            );
            System.out.println(
                    "a outro objeto."
            );

            System.out.println();

            System.out.println(
                    "O Proxy pode validar permissões,"
            );
            System.out.println(
                    "controlar acessos e decidir quando"
            );
            System.out.println(
                    "o objeto real será criado."
            );

            System.out.println();

            System.out.println(
                    "======================================"
            );
            System.out.println(
                    "1 - Tentar abrir o cofre"
            );
            System.out.println(
                    "0 - Sair"
            );
            System.out.println(
                    "======================================"
            );

            System.out.print(
                    "Escolha uma opção: "
            );

            opcao = teclado.nextInt();
            teclado.nextLine();

            switch (opcao) {

                case 1:

                    System.out.println();

                    System.out.print(
                            "Digite a senha do cofre: "
                    );

                    String senha = teclado.nextLine();

                    // O programa trabalha com a interface ICofre
                    // e não diretamente com o Cofre real
                    ICofre cofre =
                            new CofreProxy(senha);

                    // Solicita a abertura do cofre
                    // O Proxy decide se o acesso será permitido
                    cofre.abrir();

                    break;

                case 0:

                    System.out.println();
                    System.out.println(
                            "Programa encerrado."
                    );

                    break;

                default:

                    System.out.println();
                    System.out.println(
                            "Opção inválida."
                    );
            }

        } while (opcao != 0);

        teclado.close();
    }
}
