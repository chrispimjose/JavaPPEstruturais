import java.util.ArrayList;
import java.util.List;

// Classe Composite.
// Pode armazenar funcionários e também
// outros departamentos.
public class Departamento
        implements IDepartamentoComponente {

    private String nome;

    // Lista que armazena os componentes.
    // Cada componente pode ser um funcionário
    // ou outro departamento.
    private List<IDepartamentoComponente> componentes;

    // Construtor recebe o nome do departamento
    public Departamento(String nomeDepartamento) {

        this.nome = nomeDepartamento;

        componentes =
                new ArrayList<IDepartamentoComponente>();
    }

    // Adiciona um componente ao departamento.
    //
    // Como Funcionario e Departamento implementam
    // IDepartamentoComponente, este método pode
    // receber os dois tipos de objetos.
    //
    // Isso permite criar uma estrutura em árvore.
    public void adicionar(
            IDepartamentoComponente componente) {

        componentes.add(componente);
    }

    // Remove um componente do departamento
    public void remover(
            IDepartamentoComponente componente) {

        componentes.remove(componente);
    }

    // Exibe o departamento e todos
    // os componentes que estão dentro dele.
    @Override
    public void mostrarNome() {

        System.out.println(
                "Departamento: " + nome
        );

        // Cada componente executa o mesmo método.
        // Se for funcionário, mostra o funcionário.
        // Se for departamento, percorre novamente
        // seus próprios componentes.
        for (IDepartamentoComponente componente
                : componentes) {

            componente.mostrarNome();
        }
    }
}
