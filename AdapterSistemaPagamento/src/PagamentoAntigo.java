// Classe que representa o sistema antigo.
//
// Esse sistema possui uma limitação:
// ele processa pagamentos apenas em reais.
public class PagamentoAntigo {

    // Método disponível no sistema antigo
    public void processarEmReais(
            double valor) {

        System.out.printf(
                "Pagamento de R$ %.2f processado no sistema antigo.%n",
                valor
        );
    }
}
