// Abstração refinada do padrão Bridge.
// Acrescenta novas funcionalidades
// ao controle remoto.
public class ControleAvancado
        extends ControleRemoto {

    // Recebe a implementação da TV
    // e envia para a classe pai
    public ControleAvancado(
            ITV tvImplementada) {

        super(tvImplementada);
    }

    // Funcionalidade adicional
    // disponível no controle avançado
    public void ajustarVolume(int volume) {

        System.out.println(
                "Volume ajustado para "
                + volume
                + " no controle avançado."
        );
    }
}
