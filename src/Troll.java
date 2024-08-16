public class Troll {
    private String nome;

    public Troll(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    // Método para simular ataque do troll
    public void atacar(Jogador jogador) {
        System.out.println(nome + " atacou o jogador!");
        // Lógica de ataque ao jogador pode ser implementada aqui
    }
}
