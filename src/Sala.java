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
    }

    public void removerItem(Item item) {
        itens.remove(item);
        System.out.println("Você pegou o item:" + item.getNome()+".");
    }

    public void adicionarTroll(Troll troll) {
        trolls.add(troll);

    }

    public void removerTroll(Troll troll) {
        trolls.remove(troll);
        System.out.println("Troll " + troll.getNome() + " foi morto!.");
    }

    public void adicionarPorta(Porta porta) {
        portas.add(porta);

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
