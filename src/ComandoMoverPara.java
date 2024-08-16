public class ComandoMoverPara extends Comando {
    @Override
    public void executar(Jogador jogador, String[] parametros) {
        if (parametros.length < 2) {
            System.out.println("Por favor, especifique a sala para onde deseja mover.");
            return;
        }

        String nomeSala = parametros[1];
        Sala salaAtual = jogador.getSalaAtual();

        for (Porta porta : salaAtual.getPortas()) {
            Sala salaDestino = porta.getOutraSala(salaAtual);
            if (salaDestino.getNome().equalsIgnoreCase(nomeSala)) {
                if (porta.abrir()) {
                    jogador.definirSalaAtual(salaDestino);
                    System.out.println("Você se moveu para " + salaDestino.getNome());
                    return;
                } else {
                    System.out.println("Você não pode passar por esta porta.");
                    return;
                }
            }
        }

        System.out.println("Não há uma porta para " + nomeSala + " nesta sala.");
    }
}
