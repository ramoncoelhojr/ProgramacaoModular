public class ComandoMoverPara extends Comando {
    @Override
    public void executar(Jogador jogador, String[] parametros) {
        if (parametros.length < 2) {
            System.out.println("Especifique o nome ou número da sala para onde deseja se mover.");
            return;
        }
        String nomeSalaDestino = parametros[1];
        Sala salaAtual = jogador.getSalaAtual();
        Porta portaEncontrada = null;

        for (Porta porta : salaAtual.getPortas()) {
            if (porta.getOutraSala(salaAtual).getNome().equalsIgnoreCase(nomeSalaDestino) ||
                    porta.getOutraSala(salaAtual).getNome().contains(nomeSalaDestino)) {
                portaEncontrada = porta;
                break;
            }
        }

        if (portaEncontrada != null) {
            if (portaEncontrada.estaAberta()) {
                jogador.definirSalaAtual(portaEncontrada.getOutraSala(salaAtual));
                System.out.println("Você se moveu para a sala: " + jogador.getSalaAtual().getNome());
            } else {
                System.out.println("A porta para " + nomeSalaDestino + " está trancada.");
            }
        } else {
            System.out.println("Não há uma porta para " + nomeSalaDestino + " nesta sala.");
        }
    }
}
