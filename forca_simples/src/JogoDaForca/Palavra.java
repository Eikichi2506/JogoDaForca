package JogoDaForca;

public class Palavra {
    private String texto;
    private boolean[] letrasReveladas;

    public Palavra(String texto) {
        this.texto = texto;
        this.letrasReveladas = new boolean[texto.length()];
    }

    public boolean tentar(char letra) {
        boolean acertou = false;
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == letra) {
                letrasReveladas[i] = true;
                acertou = true;
            }
        }
        return acertou;
    }

    public boolean completa() {
        for (boolean b : letrasReveladas) {
            if (!b) return false;
        }
        return true;
    }

    public String mostrar() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < texto.length(); i++) {
            if (letrasReveladas[i]) {
                sb.append(texto.charAt(i)).append(" ");
            } else {
                sb.append("_ ");
            }
        }
        return sb.toString();
    }

    public String getTexto() {
        return texto;
    }
}

