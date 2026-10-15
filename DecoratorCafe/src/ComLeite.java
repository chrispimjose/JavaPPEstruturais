// Decorador concreto que adiciona
// leite ao café existente
public class ComLeite extends CafeDecorator {

    // Recebe o café que será decorado
    public ComLeite(ICafe cafeBase) {

        super(cafeBase);
    }

    // Acrescenta leite à descrição
    @Override
    public String descrever() {

        return cafe.descrever()
                + ", com leite";
    }

    // Acrescenta o preço do leite
    @Override
    public double calcularPreco() {

        return cafe.calcularPreco()
                + 0.50;
    }
}
