// Classe que representa o objeto real
// que será protegido pelo Proxy
public class Cofre implements ICofre {

    // Abre o cofre real
    // Aqui não existe nenhuma validação de senha
    @Override
    public void abrir() {

        System.out.println(
                "Cofre aberto! Acesso aos valores liberado."
        );
    }
}
