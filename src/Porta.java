public class Porta {
    private Sala sala1;
    private Sala sala2;
    private boolean estaAberta;
    private boolean estaTrancada;

    public Porta(Sala sala1, Sala sala2, boolean estaTrancada) {
        this.sala1 = sala1;
        this.sala2 = sala2;
        this.estaAberta = !estaTrancada;
        this.estaTrancada = estaTrancada;
    }

    public Sala getOutraSala(Sala atual) {
        return atual.equals(sala1) ? sala2 : sala1;
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

    public boolean destrancar() {
        if (estaTrancada) {
            estaTrancada = false;
            estaAberta = true;
            System.out.println("Você destrancou a porta.");
            return true;
        }
        System.out.println("A porta já está aberta.");
        return false;
    }

    public boolean estaAberta() {
        return estaAberta;
    }

    public boolean estaTrancada() {
        return estaTrancada;
    }
}
