import java.util.ArrayList;
import java.util.List;

public class Jogador {
    private Sala salaAtual;
    private final List<Item> inventario;
    private int quantidadeOuro;

    public Jogador() {
        this.inventario = new ArrayList<>();
        this.quantidadeOuro = 0;
    }

    public Sala getSalaAtual() {
        return salaAtual;
    }

    public void definirSalaAtual(Sala sala) {
        this.salaAtual = sala;
    }

    public List<Item> getInventario() {
        return inventario;
    }

    public int getQuantidadeOuro() {
        return quantidadeOuro;
    }

    public void adicionarOuro(int quantidade) {
        quantidadeOuro += quantidade;
        System.out.println("Você coletou " + quantidade + " peças de ouro.");
    }

    public void removerOuro(int quantidade) {
        quantidadeOuro -= quantidade;
        System.out.println("Você perdeu " + quantidade + " peças de ouro.");
    }

    public boolean adicionarItem(Item item) {
        if (inventario.size() < 10) { // Supondo que o inventário tem capacidade máxima de 10 itens
            inventario.add(item);
            System.out.println("Você pegou um(a) " + item.getNome() + ".");
            return true;
        } else {
            System.out.println("Seu inventário está cheio!");
            return false;
        }
    }

    public boolean removerItem(Item item) {
        if (inventario.remove(item)) {
            System.out.println("Você largou um(a) " + item.getNome() + ".");
            return true;
        } else {
            System.out.println("Você não tem esse item.");
            return false;
        }
    }

    public boolean encontrouSaida() {
        // Implementar lógica para verificar se o jogador encontrou a saída
        // Exemplo simples: verifica se a sala atual é a última sala
        return salaAtual.isSaida();
    }

    public void exibirInventario() {
        System.out.println("Inventário:");
        for (Item item : inventario) {
            System.out.println("- " + item.getNome());
        }
    }
}
