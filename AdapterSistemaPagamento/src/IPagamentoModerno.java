// Interface moderna esperada pelo sistema atual.
public interface IPagamentoModerno {

    // Processa um pagamento informando
    // a moeda e o valor.
    void processarPagamento(
            String moeda,
            double valor
    );
}