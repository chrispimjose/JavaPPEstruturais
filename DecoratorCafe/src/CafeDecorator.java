// Classe abstrata que serve como base
// para todos os decoradores do café
public abstract class CafeDecorator
        implements ICafe {

    // Guarda o café que será decorado
    protected ICafe cafe;

    // Construtor recebe o café que será
    // envolvido pelo decorador
    public CafeDecorator(ICafe cafeBase) {

        this.cafe = cafeBase;
    }

    // Delega a descrição para o objeto decorado
    @Override
    public String descrever() {

        return cafe.descrever();
    }

    // Delega o cálculo do preço
    // para o objeto decorado
    @Override
    public double calcularPreco() {

        return cafe.calcularPreco();
    }
}