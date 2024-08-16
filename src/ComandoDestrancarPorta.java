public class ComandoDestrancarPorta extends Comando {
    @Override
    public void executar(Jogador jogador, String[] parametros) {
        if (parametros.length < 2) {
            System.out.println("Por favor, especifique a porta que deseja destrancar.");
            return;
        }

        String nomeSalaDestino = parametros[1];
        Sala salaAtual = jogador.getSalaAtual();

        boolean possuiChave = false;

        // Verifica se o jogador tem uma chave no inventário
        for (Item item : jogador.getInventario()) {
            if (item instanceof Chave) {
                possuiChave = true;
                break;
            }
        }

        if (!possuiChave) {
            System.out.println("Você não tem uma chave.");
            return;
        }

        for (Porta porta : salaAtual.getPortas()) {
            Sala outraSala = porta.getOutraSala(salaAtual);
            if (outraSala.getNome().equalsIgnoreCase(nomeSalaDestino)) {
                if (porta.destrancar()) {
                    System.out.println("Porta destrancada! Você pode agora mover para " + nomeSalaDestino);
                } else {
                    System.out.println("Não foi possível destrancar a porta para " + nomeSalaDestino);
                }
                return;
            }
        }

        System.out.println("Não há uma porta para " + nomeSalaDestino + " nesta sala.");
    }
}
