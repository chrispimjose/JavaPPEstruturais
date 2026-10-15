// Classe que representa a abstração
// do padrão Bridge.
public class ControleRemoto {

    // Referência para a implementação.
    // Esta associação funciona como a ponte
    // entre o controle e a TV.
    protected ITV tv;

    // Construtor recebe a TV que será controlada
    public ControleRemoto(ITV tvImplementada) {

        this.tv = tvImplementada;
    }

    // Solicita que a TV seja ligada
    public void ligarTV() {

        tv.ligar();
    }

    // Solicita que a TV seja desligada
    public void desligarTV() {

        tv.desligar();
    }

    // Solicita que a TV mude de canal
    public void selecionarCanal(int canal) {

        tv.mudarCanal(canal);
    }
}