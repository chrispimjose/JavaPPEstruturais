import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner teclado =
                new Scanner(System.in);

        // Cria a fachada da pizzaria.
        // O cliente utilizará somente este objeto
        // para acessar todo o processo.
        PizzariaFacade pizzaria =
                new PizzariaFacade();

        int opcao;

        do {

            System.out.println();
            System.out.println(
                    "======================================"
            );
            System.out.println(
                    "            PADRÃO FACADE"
            );
            System.out.println(
                    "======================================"
            );
            System.out.println();

            System.out.println(
                    "O padrão Facade fornece uma acesso"
            );
            System.out.println(
                    "simples para acessar um conjunto de"
            );
            System.out.println(
                    "classes e subsistemas mais complexos."
            );
            System.out.println();

            System.out.println(
                    "Neste exemplo, o cliente não precisa"
            );
            System.out.println(
                    "controlar diretamente a cozinha, o forno"
            );
            System.out.println(
                    "e a entrega."
            );
            System.out.println();

            System.out.println(
                    "A classe PizzariaFacade coordena"
            );
            System.out.println(
                    "todo o processo através de um único método."
            );

            System.out.println();

            System.out.println(
                    "======================================"
            );
            System.out.println(
                    "1 - Pedir Pizza de Mussarela"
            );
            System.out.println(
                    "2 - Pedir Pizza de Calabresa"
            );
            System.out.println(
                    "3 - Pedir outro sabor"
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

                    // O cliente chama somente a fachada.
                    // A fachada executa todos os subsistemas.
                    pizzaria.fazerPedido(
                            "Mussarela"
                    );

                    break;

                case 2:

                    // Novamente, todo o processo é
                    // simplificado pela fachada.
                    pizzaria.fazerPedido(
                            "Calabresa"
                    );

                    break;

                case 3:

                    System.out.println();

                    System.out.print(
                            "Digite o sabor da pizza: "
                    );

                    String sabor =
                            teclado.nextLine();

                    // O cliente informa apenas o sabor.
                    // A fachada coordena todo o restante.
                    pizzaria.fazerPedido(
                            sabor
                    );

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
