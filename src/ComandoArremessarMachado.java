public class ComandoArremessarMachado extends Comando {
    @Override
    public void executar(Jogador jogador, String[] parametros) {
        Sala salaAtual = jogador.getSalaAtual();

        if (parametros.length < 2) {
            System.out.println("Por favor, especifique o troll que deseja atacar.");
            return;
        }

        String nomeTroll = parametros[1];

        for (Troll troll : salaAtual.getTrolls()) {
            if (troll.getNome().equalsIgnoreCase(nomeTroll)) {
                System.out.println("Você arremessou o machado no " + troll.getNome() + "!");
                salaAtual.removerTroll(troll);
                Utils.pausarELimpar();
                return;
            }
        }

        System.out.println("Troll " + nomeTroll + " não encontrado na sala.");
        Utils.pausarELimpar();
    }
}
