import java.util.ArrayList;

public class Evento {
    protected String nome;
    protected String descricao;
    protected String horario;
    protected int capacidade;
    private ArrayList<Palestrante> palestrantes;
    private ArrayList<Participante> participantes;

    public Evento(String nome, String descricao, String horario, int capacidade) {
        this.nome = nome;
        this.descricao = descricao;
        this.horario = horario;
        this.capacidade = capacidade;
        this.palestrantes = new ArrayList<>();
        this.participantes = new ArrayList<>();
    }

    // Adicionar palestrante ao evento
    public void adicionarPalestrante(Palestrante palestrante) {
        palestrantes.add(palestrante);
        System.out.println("Palestrante '" + palestrante.nome + "' adicionado ao evento '" + nome + "'.");
    }

    // Adicionar participante ao evento
    public void adicionarParticipante(Participante participante) {
        if (participantes.size() < capacidade) {
            participantes.add(participante);
            System.out.println("Participante '" + participante.nome + "' inscrito no evento '" + nome + "'.");
        } else {
            System.out.println("Capacidade máxima atingida no evento '" + nome + "'.");
        }
    }

    // Exibir detalhes do evento, incluindo palestrantes e participantes
    public void exibirDetalhes() {
        System.out.println("Evento: " + nome);
        System.out.println("Descrição: " + descricao);
        System.out.println("Horário: " + horario);
        System.out.println("Capacidade: " + capacidade);
        System.out.println("Palestrantes:");
        for (Palestrante palestrante : palestrantes) {
            palestrante.exibirDetalhes();
        }
        System.out.println("Participantes:");
        for (Participante participante : participantes) {
            participante.exibirDetalhes();
        }
    }

    public Object getNome() {
        return nome;
    }

    public void setNome(Object nome) {
        this.nome = nome.toString();
    }
}
