// Classe folha do padrão Composite.
// Representa um funcionário individual.
public class Funcionario
        implements IDepartamentoComponente {

    private String nome;

    // Construtor recebe o nome do funcionário
    public Funcionario(String nomeFuncionario) {

        this.nome = nomeFuncionario;
    }

    // Exibe o nome do funcionário
    @Override
    public void mostrarNome() {

        System.out.println(
                "Funcionário: " + nome
        );
    }
}