// Decorador concreto que adiciona
// açúcar ao café existente
public class ComAcucar extends CafeDecorator {

    // Recebe o café que será decorado
    public ComAcucar(ICafe cafeBase) {

        super(cafeBase);
    }

    // Acrescenta açúcar à descrição
    @Override
    public String descrever() {

        return cafe.descrever()
                + ", com açúcar";
    }

    // Acrescenta o preço do açúcar
    @Override
    public double calcularPreco() {

        return cafe.calcularPreco()
                + 0.20;
    }
}