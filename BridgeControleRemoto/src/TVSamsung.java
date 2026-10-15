// Implementação concreta de uma TV Samsung.
public class TVSamsung implements ITV {

    // Liga a TV Samsung
    @Override
    public void ligar() {

        System.out.println(
                "TV Samsung ligada."
        );
    }

    // Desliga a TV Samsung
    @Override
    public void desligar() {

        System.out.println(
                "TV Samsung desligada."
        );
    }

    // Muda o canal da TV Samsung
    @Override
    public void mudarCanal(int canal) {

        System.out.println(
                "TV Samsung mudou para o canal "
                + canal + "."
        );
    }
}
