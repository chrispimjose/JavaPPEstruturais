import java.util.HashMap;
import java.util.Map;

// Fábrica responsável por criar e reutilizar
// os objetos Flyweight.
public class FabricaArvores {

    // Armazena os tipos de árvores já criados.
    // A chave identifica cada combinação de nome e cor.
    private Map<String, TipoArvore> tipos =
            new HashMap<String, TipoArvore>();

    // Retorna um TipoArvore existente ou cria um novo
    // caso ainda não exista na fábrica.
    public TipoArvore obterTipoArvore(
            String nome,
            String cor) {

        // Cria uma chave única para o tipo da árvore
        String chave = nome + "-" + cor;

        // Verifica se o tipo ainda não existe
        if (!tipos.containsKey(chave)) {

            // Cria um novo objeto Flyweight
            TipoArvore novoTipo =
                    new TipoArvore(nome, cor);

            // Guarda o objeto para reutilização futura
            tipos.put(chave, novoTipo);

            System.out.println(
                    "Criando novo tipo de árvore: "
                    + nome
            );

        } else {

            System.out.println(
                    "Reutilizando tipo de árvore: "
                    + nome
            );
        }

        // Retorna o objeto compartilhado
        return tipos.get(chave);
    }

    // Retorna a quantidade de objetos Flyweight
    // realmente criados pela fábrica
    public int getQuantidadeTipos() {

        return tipos.size();
    }
}
