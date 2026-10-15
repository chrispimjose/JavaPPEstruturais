import java.util.Scanner;

public class App {
public static void main(String[] args) {

        Scanner teclado =
                new Scanner(System.in);

        // ------------------------------------------------
        // Criação da estrutura da empresa
        // ------------------------------------------------

        // Funcionários individuais
        Funcionario ana =
                new Funcionario("Ana");

        Funcionario joao =
                new Funcionario("João");

        Funcionario pedro =
                new Funcionario("Pedro");

        Funcionario maria =
                new Funcionario("Maria");

        // Departamento de Infraestrutura
        Departamento infraestrutura =
                new Departamento(
                        "Infraestrutura"
                );

        infraestrutura.adicionar(
                pedro
        );

        // Departamento de TI
        Departamento ti =
                new Departamento("TI");

        ti.adicionar(ana);

        ti.adicionar(joao);

        // Um departamento pode conter
        // outro departamento
        ti.adicionar(infraestrutura);

        // Departamento de RH
        Departamento rh =
                new Departamento("RH");

        rh.adicionar(maria);

        // Departamento principal da empresa
        Departamento empresa =
                new Departamento(
                        "Empresa XYZ"
                );

        // A empresa contém os departamentos
        // de TI e RH
        empresa.adicionar(ti);

        empresa.adicionar(rh);

        int opcao;

        do {

            System.out.println();
            System.out.println(
                    "======================================"
            );
            System.out.println(
                    "           PADRÃO COMPOSITE"
            );
            System.out.println(
                    "======================================"
            );
            System.out.println();

            System.out.println(
                    "O padrão Composite permite organizar"
            );
            System.out.println(
                    "objetos individuais e grupos de objetos"
            );
            System.out.println(
                    "em uma estrutura hierárquica."
            );
            System.out.println();

            System.out.println(
                    "Neste exemplo, funcionários são folhas"
            );
            System.out.println(
                    "e departamentos podem conter funcionários"
            );
            System.out.println(
                    "ou outros departamentos."
            );
            System.out.println();

            System.out.println(
                    "Todos implementam o mesmo componente,"
            );
            System.out.println(
                    "permitindo tratá-los de forma semelhante."
            );

            System.out.println();

            System.out.println(
                    "======================================"
            );
            System.out.println(
                    "1 - Mostrar funcionário individual"
            );
            System.out.println(
                    "2 - Mostrar Departamento de Infraestrutura"
            );
            System.out.println(
                    "3 - Mostrar Departamento de TI"
            );
            System.out.println(
                    "4 - Mostrar Departamento de RH"
            );
            System.out.println(
                    "5 - Mostrar toda a Empresa"
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
                            "===== COMPONENTE FOLHA ====="
                    );

                    // Funcionario é uma folha
                    // da estrutura Composite
                    ana.mostrarNome();

                    break;

                case 2:

                    System.out.println();
                    System.out.println(
                            "===== INFRAESTRUTURA ====="
                    );

                    // Mostra o departamento
                    // e seus componentes
                    infraestrutura.mostrarNome();

                    break;

                case 3:

                    System.out.println();
                    System.out.println(
                            "===== DEPARTAMENTO DE TI ====="
                    );

                    // TI possui funcionários
                    // e também um subdepartamento
                    ti.mostrarNome();

                    break;

                case 4:

                    System.out.println();
                    System.out.println(
                            "===== DEPARTAMENTO DE RH ====="
                    );

                    rh.mostrarNome();

                    break;

                case 5:

                    System.out.println();
                    System.out.println(
                            "===== ESTRUTURA DA EMPRESA ====="
                    );

                    // A chamada começa no objeto principal.
                    // Cada departamento percorre
                    // automaticamente seus componentes.
                    empresa.mostrarNome();

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
