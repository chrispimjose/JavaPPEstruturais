import java.util.Scanner;

public class App {
public static void main(String[] args) {

        Scanner teclado =
                new Scanner(System.in);

        int opcao;

        do {

            System.out.println();
            System.out.println(
                    "======================================"
            );
            System.out.println(
                    "           PADRÃO DECORATOR"
            );
            System.out.println(
                    "======================================"
            );
            System.out.println();

            System.out.println(
                    "O padrão Decorator permite adicionar"
            );
            System.out.println(
                    "novas características a um objeto"
            );
            System.out.println(
                    "sem modificar sua classe original."
            );
            System.out.println();

            System.out.println(
                    "Neste exemplo, partimos de um café"
            );
            System.out.println(
                    "simples e adicionamos leite e açúcar"
            );
            System.out.println(
                    "através de objetos decoradores."
            );
            System.out.println();

            System.out.println(
                    "Cada decorador envolve o objeto anterior"
            );
            System.out.println(
                    "e acrescenta uma nova responsabilidade."
            );

            System.out.println();

            System.out.println(
                    "======================================"
            );
            System.out.println(
                    "1 - Café simples"
            );
            System.out.println(
                    "2 - Café com leite"
            );
            System.out.println(
                    "3 - Café com açúcar"
            );
            System.out.println(
                    "4 - Café com leite e açúcar"
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

            switch (opcao) {

                case 1:

                    // Cria somente o componente base
                    ICafe cafeSimples =
                            new CafeSimples();

                    mostrarPedido(
                            cafeSimples
                    );

                    break;

                case 2:

                    // Cria o café simples
                    // e o envolve com o decorador ComLeite
                    ICafe cafeComLeite =
                            new ComLeite(
                                    new CafeSimples()
                            );

                    mostrarPedido(
                            cafeComLeite
                    );

                    break;

                case 3:

                    // Cria o café simples
                    // e o envolve com o decorador ComAcucar
                    ICafe cafeComAcucar =
                            new ComAcucar(
                                    new CafeSimples()
                            );

                    mostrarPedido(
                            cafeComAcucar
                    );

                    break;

                case 4:

                    // Os decoradores podem ser combinados.
                    // Primeiro o café recebe leite.
                    // Depois recebe açúcar.
                    ICafe cafeCompleto =
                            new ComAcucar(
                                    new ComLeite(
                                            new CafeSimples()
                                    )
                            );

                    mostrarPedido(
                            cafeCompleto
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

    // Exibe a descrição e o preço
    // do café recebido
    public static void mostrarPedido(
            ICafe cafe) {

        System.out.println();
        System.out.println(
                "===== PEDIDO ====="
        );

        System.out.println(
                cafe.descrever()
        );

        System.out.printf(
                "Preço: R$ %.2f%n",
                cafe.calcularPreco()
        );
    }
}
