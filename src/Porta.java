public class Porta {
    private Sala sala1;
    private Sala sala2;
    private boolean estaAberta;
    private boolean estaTrancada;
    private Chave chaveNecessaria;

    public Porta(Sala sala1, Sala sala2) {
        this.sala1 = sala1;
        this.sala2 = sala2;
        this.estaAberta = true;
        this.estaTrancada = false;
        this.chaveNecessaria = null;
    }

    public Porta(Sala sala1, Sala sala2, Chave chaveNecessaria) {
        this.sala1 = sala1;
        this.sala2 = sala2;
        this.estaAberta = false;
        this.estaTrancada = true;
        this.chaveNecessaria = chaveNecessaria;
    }

    public Sala getOutraSala(Sala atual) {
        if (atual.equals(sala1)) {
            return sala2;
        } else if (atual.equals(sala2)) {
            return sala1;
        } else {
            return null;
        }
    }

    public boolean abrir() {
        if (estaTrancada) {
            System.out.println("A porta está trancada. Você precisa de uma chave para abrir.");
            return false;
        }
        estaAberta = true;
        System.out.println("Você abriu a porta.");
        return true;
    }

    public boolean destrancar(Chave chave) {
        if (chaveNecessaria != null && chave.equals(chaveNecessaria)) {
            estaTrancada = false;
            System.out.println("Você destrancou a porta.");
            return true;
        }
        System.out.println("A chave não serve para esta porta.");
        return false;
    }

    public boolean estaAberta() {
        return estaAberta;
    }

    public boolean estaTrancada() {
        return estaTrancada;
    }
}
