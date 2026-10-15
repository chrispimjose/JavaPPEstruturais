// Subsistema responsável pelo preparo da pizza
public class Cozinha {

    // Prepara a massa da pizza
    public void prepararMassa() {

        System.out.println(
                "Preparando a massa da pizza."
        );
    }

    // Adiciona os ingredientes de acordo
    // com o sabor solicitado pelo cliente
    public void adicionarIngredientes(
            String sabor) {

        System.out.println(
                "Adicionando ingredientes para pizza de "
                + sabor + "."
        );
    }
}
