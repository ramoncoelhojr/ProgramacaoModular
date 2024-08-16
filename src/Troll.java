public class Troll {
    private String nome;

    public Troll(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }


    public void atacar(Jogador jogador) {
        System.out.println(nome + " atacou o jogador!");

    }
}
