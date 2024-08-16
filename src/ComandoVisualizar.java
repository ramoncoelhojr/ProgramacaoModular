public class ComandoVisualizar extends Comando {
    @Override
    public void executar(Jogador jogador, String[] parametros) {
        Sala salaAtual = jogador.getSalaAtual();
        System.out.println("Você está na sala: " + salaAtual.getNome());

        System.out.println("Itens na sala:");
        for (Item item : salaAtual.getItens()) {
            System.out.println("- " + item.getNome());
        }

        System.out.println("Trolls na sala:");
        for (Troll troll : salaAtual.getTrolls()) {
            System.out.println("- " + troll.getNome());
        }

        System.out.println("Portas disponíveis:");
        for (Porta porta : salaAtual.getPortas()) {
            Sala outraSala = porta.getOutraSala(salaAtual);
            System.out.println("- Porta para " + outraSala.getNome() + " (Aberta: " + porta.estaAberta() + ")");
        }
    Utils.pausarELimpar(6000);
    }
}
