import jdk.jshell.execution.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Random;

public class Main {
    private Jogador jogador;
    private List<Sala> salas;
    private Map<String, Comando> comandos;
    private boolean emExecucao;

    public static void main(String[] args) {
        Main Jogo = new Main();
        Jogo.inicializarJogo();
        Jogo.executar();
    }

    public Main() {
        inicializarJogo();
        emExecucao = true;
    }


    private void inicializarJogo() {
        jogador = new Jogador();

        salas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            salas.add(new Sala("Sala " + (i + 1)));
        }

        conectarSalas();
        distribuirItensETrolls();

        comandos = new HashMap<>();
        comandos.put("visualizar", new ComandoVisualizar());
        comandos.put("moverPara", new ComandoMoverPara());
        comandos.put("pegar", new ComandoPegar());
        comandos.put("largar", new ComandoLargar());
        comandos.put("arremessarMachado", new ComandoArremessarMachado());
        comandos.put("ajuda", new ComandoAjuda());
        comandos.put("ComandoDestrancarPorta", new ComandoDestrancarPorta());

        jogador.definirSalaAtual(salas.getFirst());
    }

    private void conectarSalas() {

        Chave chaveGenerica = new Chave("Chave Genérica");

        Porta porta1 = new Porta(salas.get(0), salas.get(1), false); // Porta aberta
        Porta porta2 = new Porta(salas.get(1), salas.get(2), true);  // Porta trancada

        salas.get(0).adicionarPorta(porta1);
        salas.get(1).adicionarPorta(porta1);
        salas.get(1).adicionarPorta(porta2);
        salas.get(2).adicionarPorta(porta2);


        salas.get(0).adicionarItem(chaveGenerica);


        salas.getLast().definirSaida(true);
    }

    private void distribuirItensETrolls() {
        // Lógica para distribuir itens e trolls nas salas
        Random rand = new Random();

        for (Sala sala : salas) {
            if (rand.nextBoolean()) {
                sala.adicionarItem(new Ouro(rand.nextInt(5) + 1)); // Adiciona entre 1 e 5 ouros
            }
            if (rand.nextBoolean()) {
                sala.adicionarTroll(new Troll("Troll" + rand.nextInt(100)));
            }
        }
    }

    private void executar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo ao Adventure Game!");

        while (emExecucao) {
            System.out.println("Digite ajuda para visualizar os comandos disponíveis");
            System.out.print("Jogador> ");
            String entrada = scanner.nextLine();
            processarComando(entrada);
        }

        scanner.close();
    }

    private void processarComando(String entrada) {
        String[] partes = entrada.split(" ");
        String nomeComando = partes[0];

        Comando comando = comandos.get(nomeComando);
        if (comando != null) {
            comando.executar(jogador, partes);
        } else {
            System.out.println("Comando inválido.");
            Utils.pausarELimpar();

        }

        // Verificar condições de fim do jogo, como saída encontrada ou jogador derrotado
        if (jogador.encontrouSaida()) {
            System.out.println("Parabéns, você encontrou a saída!");
            Utils.pausarELimpar();
            emExecucao = false;
        }
    }
}
