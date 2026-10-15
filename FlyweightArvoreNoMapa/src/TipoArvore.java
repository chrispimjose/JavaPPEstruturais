// Classe Flyweight.
// Armazena os dados intrínsecos, ou seja,
// os dados que podem ser compartilhados entre várias árvores.
public class TipoArvore {

    // Nome do tipo da árvore
    private String nome;

    // Cor da árvore
    private String cor;

    // Construtor recebe os dados compartilhados
    public TipoArvore(
            String nomeArvore,
            String corArvore) {

        this.nome = nomeArvore;
        this.cor = corArvore;
    }

    // Exibe a árvore utilizando também
    // os dados extrínsecos recebidos
    public void exibir(int x, int y) {

        System.out.println(
                "Árvore: " + nome
                + " | Cor: " + cor
                + " | Posição: (" + x + ", " + y + ")"
        );
    }
}