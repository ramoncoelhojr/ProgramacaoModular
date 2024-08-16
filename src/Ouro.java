public class Ouro extends Item {
    private int quantidade;

    public Ouro(int quantidade) {
        super("Ouro");
        this.quantidade = quantidade;
    }

    public int getQuantidade() {

        return quantidade;
    }
}
