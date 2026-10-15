import java.util.Scanner;

public class App {
public static void main(String[] args) {

        Scanner teclado =
                new Scanner(System.in);

        // Cria o sistema antigo
        PagamentoAntigo pagamentoAntigo =
                new PagamentoAntigo();

        // Cria o Adapter.
        //
        // O sistema passa a trabalhar com
        // IPagamentoModerno, enquanto o Adapter
        // traduz as chamadas para PagamentoAntigo.
        IPagamentoModerno pagamento =
                new AdaptadorPagamento(
                        pagamentoAntigo
                );

        int opcao;

        do {

            System.out.println();
            System.out.println(
                    "======================================"
            );
            System.out.println(
                    "            PADRÃO ADAPTER"
            );
            System.out.println(
                    "======================================"
            );
            System.out.println();

            System.out.println(
                    "O padrão Adapter permite que classes"
            );
            System.out.println(
                    "com formas diferentes de funcionamento"
            );
            System.out.println(
                    "possam trabalhar juntas."
            );
            System.out.println();

            System.out.println(
                    "Neste exemplo, o sistema moderno aceita"
            );
            System.out.println(
                    "pagamentos em diferentes moedas."
            );
            System.out.println();

            System.out.println(
                    "O sistema antigo aceita somente reais."
            );
            System.out.println(
                    "O Adapter recebe a chamada moderna,"
            );
            System.out.println(
                    "converte quando necessário e chama"
            );
            System.out.println(
                    "o sistema antigo."
            );

            System.out.println();

            System.out.println(
                    "======================================"
            );
            System.out.println(
                    "1 - Pagamento em BRL"
            );
            System.out.println(
                    "2 - Pagamento em USD"
            );
            System.out.println(
                    "3 - Pagamento em EUR"
            );
            System.out.println(
                    "4 - Testar moeda não suportada"
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

                    System.out.println();

                    System.out.print(
                            "Digite o valor em BRL: "
                    );

                    double valorBRL =
                            teclado.nextDouble();

                    // O cliente utiliza somente
                    // o padrão moderno
                    pagamento.processarPagamento(
                            "BRL",
                            valorBRL
                    );

                    break;

                case 2:

                    System.out.println();

                    System.out.print(
                            "Digite o valor em USD: "
                    );

                    double valorUSD =
                            teclado.nextDouble();

                    // O Adapter realiza a conversão
                    // antes de chamar o sistema antigo
                    pagamento.processarPagamento(
                            "USD",
                            valorUSD
                    );

                    break;

                case 3:

                    System.out.println();

                    System.out.print(
                            "Digite o valor em EUR: "
                    );

                    double valorEUR =
                            teclado.nextDouble();

                    // O Adapter converte EUR
                    // para o formato esperado
                    pagamento.processarPagamento(
                            "EUR",
                            valorEUR
                    );

                    break;

                case 4:

                    System.out.println();

                    System.out.print(
                            "Digite o código da moeda: "
                    );

                    teclado.nextLine();

                    String moeda =
                            teclado.nextLine();

                    System.out.print(
                            "Digite o valor: "
                    );

                    double valor =
                            teclado.nextDouble();

                    // Permite demonstrar o comportamento
                    // quando o Adapter não conhece a moeda
                    pagamento.processarPagamento(
                            moeda,
                            valor
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
