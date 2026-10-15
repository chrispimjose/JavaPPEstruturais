// Classe concreta que representa o café simples
public class CafeSimples implements ICafe {

    // Retorna a descrição do café simples
    @Override
    public String descrever() {

        return "Café simples";
    }

    // Retorna o preço base do café
    @Override
    public double calcularPreco() {

        return 2.00;
    }
}
