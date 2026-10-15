// Classe Adapter.
//
// Ela adapta o sistema PagamentoAntigo
// para que possa ser utilizado através
// de IPagamentoModerno.
public class AdaptadorPagamento
        implements IPagamentoModerno {

    // Referência para o sistema antigo
    private PagamentoAntigo pagamentoAntigo;

    // Construtor recebe o objeto que
    // será adaptado
    public AdaptadorPagamento(
            PagamentoAntigo pagamento) {

        this.pagamentoAntigo = pagamento;
    }

    // Implementa o método esperado
    // pelo sistema moderno
    @Override
    public void processarPagamento(
            String moeda,
            double valor) {

        double valorEmReais;

        // O Adapter recebe a chamada
        // no formato moderno e traduz
        // para o formato entendido
        // pelo sistema antigo.
        switch (moeda.toUpperCase()) {

            case "BRL":

                // O sistema antigo já trabalha
                // diretamente com reais
                pagamentoAntigo.processarEmReais(
                        valor
                );

                break;

            case "USD":

                // Cotação fictícia para
                // fins didáticos:
                // 1 USD = 6 BRL
                valorEmReais =
                        valor * 6;

                System.out.printf(
                        "Convertendo USD %.2f para R$ %.2f...%n",
                        valor,
                        valorEmReais
                );

                pagamentoAntigo.processarEmReais(
                        valorEmReais
                );

                break;

            case "EUR":

                // Cotação fictícia para
                // fins didáticos:
                // 1 EUR = 7 BRL
                valorEmReais =
                        valor * 7;

                System.out.printf(
                        "Convertendo EUR %.2f para R$ %.2f...%n",
                        valor,
                        valorEmReais
                );

                pagamentoAntigo.processarEmReais(
                        valorEmReais
                );

                break;

            default:

                System.out.println(
                        "Moeda não suportada pelo adaptador."
                );

                break;
        }
    }
}