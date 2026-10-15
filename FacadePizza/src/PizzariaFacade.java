// Classe Facade.
// Ela fornece um acesso simples para o cliente,
// escondendo a complexidade dos vários subsistemas.
public class PizzariaFacade {

    // Referências aos subsistemas
    private Cozinha cozinha;
    private Forno forno;
    private Entrega entrega;

    // Construtor inicializa todos os subsistemas
    public PizzariaFacade() {

        cozinha = new Cozinha();

        forno = new Forno();

        entrega = new Entrega();
    }

    // Método simples utilizado pelo cliente
    // para realizar todo o processo do pedido
    public void fazerPedido(
            String sabor) {

        System.out.println();
        System.out.println(
                "Processando pedido de pizza de "
                + sabor + ":"
        );

        // Passo 1 - prepara a massa
        cozinha.prepararMassa();

        // Passo 2 - adiciona os ingredientes
        cozinha.adicionarIngredientes(
                sabor
        );

        // Passo 3 - assa a pizza
        forno.assarPizza();

        // Passo 4 - realiza a entrega
        entrega.entregarPizza();

        System.out.println(
                "Pedido concluído!"
        );
    }
}