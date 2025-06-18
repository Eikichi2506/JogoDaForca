package JogoDaForca;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Jogo jogo = new Jogo("src/JogoDaForca/palavras.txt");

        System.out.println("=== JOGO DA FORCA ===");
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        jogo.iniciar(nome);
    }
}