import java.util.ArrayList;
import java.util.List;

public class Sala {
    private String nome;
    private List<Item> itens;
    private List<Troll> trolls;
    private List<Porta> portas;
    private boolean isSaida;

    public Sala(String nome) {
        this.nome = nome;
        this.itens = new ArrayList<>();
        this.trolls = new ArrayList<>();
        this.portas = new ArrayList<>();
        this.isSaida = false;
    }

    public String getNome() {
        return nome;
    }

    public List<Item> getItens() {
        return itens;
    }

    public List<Troll> getTrolls() {
        return trolls;
    }

    public void adicionarItem(Item item) {
        itens.add(item);
        System.out.println("Item " + item.getNome() + " adicionado à sala " + nome + ".");
    }

    public void removerItem(Item item) {
        itens.remove(item);
        System.out.println("Item " + item.getNome() + " removido da sala " + nome + ".");
    }

    public void adicionarTroll(Troll troll) {
        trolls.add(troll);
        System.out.println("Troll " + troll.getNome() + " adicionado à sala " + nome + ".");
    }

    public void removerTroll(Troll troll) {
        trolls.remove(troll);
        System.out.println("Troll " + troll.getNome() + " removido da sala " + nome + ".");
    }

    public void adicionarPorta(Porta porta) {
        portas.add(porta);
        System.out.println("Porta adicionada à sala " + nome + ".");
    }

    public List<Porta> getPortas() {
        return portas;
    }

    public boolean isSaida() {
        return isSaida;
    }

    public void definirSaida(boolean isSaida) {
        this.isSaida = isSaida;
    }
}
