public class Utils {
    // Método para pausar o jogo por 2 segundos
    public static void pausar(int milissegundos) {
        try {
            Thread.sleep(milissegundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Erro ao pausar o jogo.");
        }
    }


    public static void limparTela() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    // Método para pausar e limpar
    public static void pausarELimpar() {
        pausar(2000);
        limparTela();
    }

    public static void pausarELimpar(int a) {
        pausar(a);
        limparTela();
    }
}
