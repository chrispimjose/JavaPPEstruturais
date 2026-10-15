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
                    "            PADRÃO BRIDGE"
            );
            System.out.println(
                    "======================================"
            );
            System.out.println();

            System.out.println(
                    "O padrão Bridge separa a abstração"
            );
            System.out.println(
                    "da sua implementação, permitindo que"
            );
            System.out.println(
                    "as duas evoluam de forma independente."
            );
            System.out.println();

            System.out.println(
                    "Neste exemplo, os controles remotos"
            );
            System.out.println(
                    "representam a abstração e as TVs"
            );
            System.out.println(
                    "representam as implementações."
            );
            System.out.println();

            System.out.println(
                    "Assim, diferentes controles podem"
            );
            System.out.println(
                    "funcionar com diferentes modelos de TV."
            );

            System.out.println();

            System.out.println(
                    "======================================"
            );
            System.out.println(
                    "1 - Controle básico + TV Samsung"
            );
            System.out.println(
                    "2 - Controle básico + TV Sony"
            );
            System.out.println(
                    "3 - Controle avançado + TV Samsung"
            );
            System.out.println(
                    "4 - Controle avançado + TV Sony"
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
                    System.out.println(
                            "===== CONTROLE BÁSICO + SAMSUNG ====="
                    );

                    // Cria a implementação
                    ITV tvSamsung =
                            new TVSamsung();

                    // Liga a abstração à implementação
                    ControleRemoto controleSamsung =
                            new ControleRemoto(
                                    tvSamsung
                            );

                    controleSamsung.ligarTV();

                    controleSamsung.selecionarCanal(
                            5
                    );

                    controleSamsung.desligarTV();

                    break;

                case 2:

                    System.out.println();
                    System.out.println(
                            "===== CONTROLE BÁSICO + SONY ====="
                    );

                    // Cria a implementação
                    ITV tvSony =
                            new TVSony();

                    // O mesmo controle pode trabalhar
                    // com outra implementação
                    ControleRemoto controleSony =
                            new ControleRemoto(
                                    tvSony
                            );

                    controleSony.ligarTV();

                    controleSony.selecionarCanal(
                            7
                    );

                    controleSony.desligarTV();

                    break;

                case 3:

                    System.out.println();
                    System.out.println(
                            "===== CONTROLE AVANÇADO + SAMSUNG ====="
                    );

                    ITV samsung =
                            new TVSamsung();

                    // Utiliza a abstração refinada
                    // com uma TV Samsung
                    ControleAvancado avancadoSamsung =
                            new ControleAvancado(
                                    samsung
                            );

                    avancadoSamsung.ligarTV();

                    avancadoSamsung.selecionarCanal(
                            10
                    );

                    avancadoSamsung.ajustarVolume(
                            4
                    );

                    avancadoSamsung.desligarTV();

                    break;

                case 4:

                    System.out.println();
                    System.out.println(
                            "===== CONTROLE AVANÇADO + SONY ====="
                    );

                    ITV sony =
                            new TVSony();

                    // A mesma abstração refinada
                    // também funciona com outra TV
                    ControleAvancado avancadoSony =
                            new ControleAvancado(
                                    sony
                            );

                    avancadoSony.ligarTV();

                    avancadoSony.selecionarCanal(
                            12
                    );

                    avancadoSony.ajustarVolume(
                            6
                    );

                    avancadoSony.desligarTV();

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
