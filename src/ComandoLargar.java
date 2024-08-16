public class ComandoLargar extends Comando {
    @Override
    public void executar(Jogador jogador, String[] parametros) {
        if (parametros.length < 2) {
            System.out.println("Por favor, especifique o item que deseja largar.");
            return;
        }

        String nomeItem = parametros[1];

        for (Item item : jogador.getInventario()) {
            if (item.getNome().equalsIgnoreCase(nomeItem)) {
                jogador.removerItem(item);
                jogador.getSalaAtual().adicionarItem(item);
                return;
            }
        }

        System.out.println("Item " + nomeItem + " não está no seu inventário.");
    }
}
