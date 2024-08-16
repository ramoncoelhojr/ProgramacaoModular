public class ComandoAjuda extends Comando {
    @Override
    public void executar(Jogador jogador, String[] parametros) {
        System.out.println("Comandos disponíveis:");
        System.out.println("- visualizar: Mostra a sala atual, itens, trolls e portas.");
        System.out.println("- moverPara [nome da sala]: Move para a sala especificada.");
        System.out.println("- pegar [nome do item]: Pega um item da sala.");
        System.out.println("- largar [nome do item]: Larga um item do inventário.");
        System.out.println("- arremessarMachado [nome do troll]: Arremessa um machado em um troll.");
        System.out.println("- destrancarPorta [nome da chave]: Destranca uma porta usando uma chave.");
        System.out.println("- ajuda: Mostra esta lista de comandos.");
    }
}
