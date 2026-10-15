// Classe que representa uma árvore posicionada no mapa.
// Ela utiliza um TipoArvore compartilhado.
public class Arvore {

    // Flyweight compartilhado
    private TipoArvore tipo;

    // Dados extrínsecos.
    // Cada árvore possui sua própria posição.
    private int x;
    private int y;

    // Construtor recebe o tipo compartilhado
    // e a posição específica da árvore
    public Arvore(
            TipoArvore tipoArvore,
            int posX,
            int posY) {

        this.tipo = tipoArvore;
        this.x = posX;
        this.y = posY;
    }

    // Exibe a árvore utilizando o objeto compartilhado
    public void exibir() {

        tipo.exibir(x, y);
    }
}
