// Implementação concreta de uma TV Sony.
public class TVSony implements ITV {

    // Liga a TV Sony
    @Override
    public void ligar() {

        System.out.println(
                "TV Sony ligada."
        );
    }

    // Desliga a TV Sony
    @Override
    public void desligar() {

        System.out.println(
                "TV Sony desligada."
        );
    }

    // Muda o canal da TV Sony
    @Override
    public void mudarCanal(int canal) {

        System.out.println(
                "TV Sony mudou para o canal "
                + canal + "."
        );
    }
}
