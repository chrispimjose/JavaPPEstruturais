import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        // Fábrica responsável por armazenar
        // e reutilizar os objetos Flyweight
        FabricaArvores fabrica =
                new FabricaArvores();

        // Lista das árvores posicionadas no mapa
        ArrayList<Arvore> arvores =
                new ArrayList<Arvore>();

        int opcao;

        do {

            System.out.println();
            System.out.println(
                    "======================================"
            );
            System.out.println(
                    "           PADRÃO FLYWEIGHT"
            );
            System.out.println(
                    "======================================"
            );

            System.out.println();

            System.out.println(
                    "O padrão Flyweight permite compartilhar"
            );
            System.out.println(
                    "objetos que possuem dados iguais,"
            );
            System.out.println(
                    "reduzindo o consumo de memória."
            );

            System.out.println();

            System.out.println(
                    "Neste exemplo, o objeto TipoArvore"
            );
            System.out.println(
                    "é compartilhado entre várias árvores."
            );

            System.out.println();

            System.out.println(
                    "Nome e cor são dados compartilhados,"
            );
            System.out.println(
                    "enquanto X e Y pertencem a cada árvore."
            );

            System.out.println();

            System.out.println(
                    "======================================"
            );
            System.out.println(
                    "1 - Adicionar Carvalho"
            );
            System.out.println(
                    "    (reutiliza o Flyweight Carvalho)"
            );
            System.out.println(
                    "2 - Adicionar Pinheiro"
            );
            System.out.println(
                    "    (reutiliza o Flyweight Pinheiro)"
            );
            System.out.println(
                    "3 - Exibir árvores no mapa"
            );
            System.out.println(
                    "4 - Demonstrar compartilhamento Flyweight"
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
                            "Digite a posição X: "
                    );

                    int xCarvalho = teclado.nextInt();

                    System.out.print(
                            "Digite a posição Y: "
                    );

                    int yCarvalho = teclado.nextInt();

                    // Solicita o Flyweight Carvalho.
                    // Se já existir, será reutilizado.
                    TipoArvore carvalho =
                            fabrica.obterTipoArvore(
                                    "Carvalho",
                                    "Verde"
                            );

                    // Cria uma nova árvore,
                    // mas reutiliza o TipoArvore
                    Arvore novaArvoreCarvalho =
                            new Arvore(
                                    carvalho,
                                    xCarvalho,
                                    yCarvalho
                            );

                    arvores.add(
                            novaArvoreCarvalho
                    );

                    System.out.println();
                    System.out.println(
                            "Carvalho adicionado ao mapa."
                    );

                    System.out.println(
                            "O TipoArvore Carvalho foi obtido"
                    );

                    System.out.println(
                            "pela fábrica Flyweight."
                    );

                    break;

                case 2:

                    System.out.println();

                    System.out.print(
                            "Digite a posição X: "
                    );

                    int xPinheiro = teclado.nextInt();

                    System.out.print(
                            "Digite a posição Y: "
                    );

                    int yPinheiro = teclado.nextInt();

                    // Solicita o Flyweight Pinheiro.
                    // Se já existir, será reutilizado.
                    TipoArvore pinheiro =
                            fabrica.obterTipoArvore(
                                    "Pinheiro",
                                    "Verde Escuro"
                            );

                    // Cria uma nova árvore,
                    // mas reutiliza o TipoArvore
                    Arvore novaArvorePinheiro =
                            new Arvore(
                                    pinheiro,
                                    xPinheiro,
                                    yPinheiro
                            );

                    arvores.add(
                            novaArvorePinheiro
                    );

                    System.out.println();
                    System.out.println(
                            "Pinheiro adicionado ao mapa."
                    );

                    System.out.println(
                            "O TipoArvore Pinheiro foi obtido"
                    );

                    System.out.println(
                            "pela fábrica Flyweight."
                    );

                    break;

                case 3:

                    System.out.println();
                    System.out.println(
                            "===== ÁRVORES NO MAPA ====="
                    );

                    if (arvores.isEmpty()) {

                        System.out.println(
                                "Nenhuma árvore foi adicionada."
                        );

                    } else {

                        // Cada árvore possui sua posição,
                        // mas pode compartilhar o mesmo TipoArvore
                        for (Arvore arvore : arvores) {

                            arvore.exibir();
                        }
                    }

                    break;

                case 4:

                    System.out.println();
                    System.out.println(
                            "===== PADRÃO FLYWEIGHT ====="
                    );

                    System.out.println();

                    System.out.println(
                            "Árvores existentes no mapa: "
                            + arvores.size()
                    );

                    System.out.println(
                            "Objetos TipoArvore criados: "
                            + fabrica.getQuantidadeTipos()
                    );

                    System.out.println();

                    System.out.println(
                            "O número de árvores pode ser maior"
                    );

                    System.out.println(
                            "que o número de tipos criados porque"
                    );

                    System.out.println(
                            "os objetos TipoArvore são compartilhados."
                    );

                    System.out.println();

                    System.out.println(
                            "Exemplo:"
                    );

                    System.out.println(
                            "10 Carvalhos podem compartilhar"
                    );

                    System.out.println(
                            "apenas 1 objeto TipoArvore Carvalho."
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
