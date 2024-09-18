import java.util.ArrayList;

public class Palestrante extends Pessoa {
    private ArrayList<String> sessoes;

    public Palestrante(String nome, String registro) {
        super(nome, registro);
        this.sessoes = new ArrayList<>();
    }

    public void adicionarSessao(String sessao) {
        sessoes.add(sessao);
        System.out.println("Sessão adicionada ao palestrante " + nome + ": " + sessao);
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Sessões ministradas:");
        for (String sessao : sessoes) {
            System.out.println(" - " + sessao);
        }
    }
}
