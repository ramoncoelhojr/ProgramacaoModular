import jdk.jshell.execution.Util;

public class ComandoPegar extends Comando {
    @Override
    public void executar(Jogador jogador, String[] parametros) {
        if (parametros.length < 2) {
            System.out.println("Por favor, especifique o item que deseja pegar.");
            return;
        }

        String nomeItem = parametros[1];
        Sala salaAtual = jogador.getSalaAtual();

        for (Item item : salaAtual.getItens()) {
            if (item.getNome().equalsIgnoreCase(nomeItem)) {
                if (jogador.adicionarItem(item)) {
                    salaAtual.removerItem(item);
                }
                return;
            }
        }

        System.out.println("Item " + nomeItem + " não encontrado na sala.");
        Utils.pausarELimpar();
    }
}
