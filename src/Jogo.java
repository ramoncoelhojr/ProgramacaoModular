import java.util.*;

public class Jogo {
    private Jogador jogador;
    private List<Sala> salas;
    private Map<String, Comando> comandos;
    private boolean estaExecutando;

    public Jogo() {
        inicializarJogo();
        estaExecutando = true;
    }

    private void inicializarJogo() {
        // Inicializar o jogador
        jogador = new Jogador();

        // Inicializar as salas
        salas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            salas.add(new Sala("Sala " + (i + 1)));
        }

        // Distribuir itens e Trolls aleatoriamente nas salas
        distribuirItensETrolls();

        // Definir comandos válidos
        comandos = new HashMap<>();
        comandos.put("view", new ComandoVisualizar());
        comandos.put("moveTo", new ComandoMoverPara());
        comandos.put("pickUp", new ComandoPegar());
        comandos.put("drop", new ComandoLargar());
        comandos.put("throwAxe", new ComandoArremessarMachado());

        // Definir a sala inicial do jogador
        jogador.definirSalaAtual(salas.get(0));
    }

    private void distribuirItensETrolls() {
        // Lógica para distribuir itens e Trolls nas salas
        Random rand = new Random();

        // Exemplo: distribuir alguns ouros e Trolls
        for (Sala sala : salas) {
            if (rand.nextBoolean()) {
                sala.adicionarItem(new Ouro(rand.nextInt(5) + 1)); // Adiciona entre 1 e 5 ouros
            }
            if (rand.nextBoolean()) {
                sala.adicionarTroll(new Troll("Troll" + rand.nextInt(100)));
            }
        }
    }

    public void executar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo ao Jogo de Aventura!");

        while (estaExecutando) {
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
        }

        // Verificar condições de fim do jogo, como saída encontrada ou jogador derrotado
        if (jogador.encontrouSaida()) {
            System.out.println("Parabéns, você encontrou a saída!");
            estaExecutando = false;
        }
    }
}


