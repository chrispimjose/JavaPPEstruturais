// Classe Proxy responsável por controlar
// o acesso ao objeto Cofre
public class CofreProxy implements ICofre {

    // Referência ao objeto real
    private Cofre cofreReal;

    // Senha correta utilizada no exemplo
    private String senhaCorreta;

    // Senha informada pelo usuário
    private String senhaFornecida;

    // Construtor recebe a senha digitada
    public CofreProxy(String senha) {

        this.senhaFornecida = senha;

        // Senha fixa utilizada apenas
        // para fins didáticos
        this.senhaCorreta = "1234";
    }

    // Controla o acesso ao cofre real
    @Override
    public void abrir() {

        // Verifica se a senha informada está correta
        if (senhaFornecida.equals(senhaCorreta)) {

            // O cofre real somente será criado
            // quando o acesso for autorizado
            // Esse comportamento é chamado de Lazy Loading
            if (cofreReal == null) {

                cofreReal = new Cofre();
            }

            // Após a validação, o Proxy permite
            // o acesso ao objeto real
            cofreReal.abrir();

        } else {

            // Caso a senha esteja incorreta,
            // o Proxy bloqueia o acesso
            System.out.println(
                    "Senha incorreta! Acesso negado."
            );
        }
    }
}