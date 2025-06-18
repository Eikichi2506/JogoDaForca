package JogoDaForca;

import java.io.*;
import java.util.*;

public class Jogo {
    private List<String> palavras;
    private Palavra palavraSecreta;
    private int maxErros = 6;
    private Set<Character> tentativas = new HashSet<>();

    public Jogo(String arquivoPalavras) {
        this.palavras = carregarPalavras(arquivoPalavras);
    }

    public void iniciar(String nomeJogador) {
        if (palavras.isEmpty()) {
            System.out.println("Nenhuma palavra disponível.");
            return;
        }

        String sorteada = palavras.get(new Random().nextInt(palavras.size()));
        palavraSecreta = new Palavra(sorteada);

        Scanner scanner = new Scanner(System.in);
        int erros = 0;

        while (erros < maxErros && !palavraSecreta.completa()) {
            System.out.println("\nPalavra: " + palavraSecreta.mostrar());
            System.out.println("Tentativas: " + tentativas);
            System.out.println("Erros: " + erros + "/" + maxErros);
            System.out.print("Digite uma letra: ");
            char letra = scanner.nextLine().toLowerCase().charAt(0);

            if (tentativas.contains(letra)) {
                System.out.println("Você já tentou essa letra.");
                continue;
            }

            tentativas.add(letra);

            if (!palavraSecreta.tentar(letra)) {
                System.out.println("Letra incorreta!");
                erros++;
            } else {
                System.out.println("Boa!");
            }
        }

        if (palavraSecreta.completa()) {
            System.out.println("\nParabéns, " + nomeJogador + "! Você acertou a palavra: " + palavraSecreta.getTexto());
        } else {
            System.out.println("\nQue pena! A palavra era: " + palavraSecreta.getTexto());
        }
    }

    private List<String> carregarPalavras(String nomeArquivo) {
        List<String> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (!linha.trim().isEmpty()) {
                    lista.add(linha.trim().toLowerCase());
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return lista;
    }
}
