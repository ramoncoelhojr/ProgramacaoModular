public class ComandoDestrancarPorta extends Comando {
    @Override
    public void executar(Jogador jogador, String[] parametros) {
        if (parametros.length < 2) {
            System.out.println("Por favor, especifique a porta que deseja destrancar.");
            return;
        }

        String nomeChave = parametros[1];
        Sala salaAtual = jogador.getSalaAtual();

        Chave chave = null;
        for (Item item : jogador.getInventario()) {
            if (item instanceof Chave && item.getNome().equalsIgnoreCase(nomeChave)) {
                chave = (Chave) item;
                break;
            }
        }

        if (chave == null) {
            System.out.println("Você não tem a chave necessária.");
            return;
        }

        for (Porta porta : salaAtual.getPortas()) {
            if (porta.destrancar(chave)) {
                System.out.println("Você destrancou a porta.");
                return;
            }
        }

        System.out.println("Nenhuma porta nesta sala pode ser destrancada com esta chave.");
    }
}
