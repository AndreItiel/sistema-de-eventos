import java.util.ArrayList;

public class EventoLista {
    private ArrayList<Evento> eventos;

    public EventoLista() {
        this.eventos = new ArrayList<>();
    }

    // Criar e adicionar evento
    public void criarEvento(Evento evento) {
        eventos.add(evento);
        System.out.println("Evento '" + evento.nome + "' criado.");
    }

    // Listar todos os eventos
    public void listarEventos() {
        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento disponível.");
        } else {
            for (Evento evento : eventos) {
                evento.exibirDetalhes();
                System.out.println("--------------------");
            }
        }
    }

    // Excluir um evento
    public void excluirEvento(String nome) {
        for (int i = 0; i < eventos.size(); i++) {
            if (eventos.get(i).nome.equals(nome)) {
                eventos.remove(i);
                System.out.println("Evento '" + nome + "' removido.");
                return;
            }
        }
        System.out.println("Evento '" + nome + "' não encontrado.");
    }

    // Atualizar evento
    public void atualizarEvento(String nome, Evento novoEvento) {
        for (int i = 0; i < eventos.size(); i++) {
            if (eventos.get(i).nome.equals(nome)) {
                eventos.set(i, novoEvento);
                System.out.println("Evento '" + nome + "' atualizado.");
                return;
            }
        }
        System.out.println("Evento '" + nome + "' não encontrado.");
    }

    public ArrayList<Evento> getEventos() {
        return eventos;
    }

}
