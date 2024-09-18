import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EventoLista eventoLista = new EventoLista();
        ArrayList<Palestrante> palestrantes = new ArrayList<>();
        ArrayList<Participante> participantes = new ArrayList<>();

        boolean continuar = true;

        while (continuar) {
            System.out.println("Menu:");
            System.out.println("1. Criar Evento");
            System.out.println("2. Listar Eventos");
            System.out.println("3. Excluir Evento");
            System.out.println("4. Registrar Palestrante");
            System.out.println("5. Registrar Participante");
            System.out.println("6. Adicionar Palestrante ao Evento");
            System.out.println("7. Adicionar Participante ao Evento");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1:
                    System.out.println("Criando um novo evento:");
                    System.out.print("Nome do evento: ");
                    String nomeEvento = scanner.nextLine();
                    System.out.print("Descrição do evento: ");
                    String descricaoEvento = scanner.nextLine();
                    System.out.print("Horário do evento: ");
                    String horarioEvento = scanner.nextLine();
                    System.out.print("Capacidade do evento: ");
                    int capacidadeEvento = scanner.nextInt();
                    scanner.nextLine(); // Consumir nova linha

                    Evento novoEvento = new Evento(nomeEvento, descricaoEvento, horarioEvento, capacidadeEvento);
                    eventoLista.criarEvento(novoEvento);
                    break;

                case 2:
                    System.out.println("Lista de eventos:");
                    eventoLista.listarEventos();
                    break;

                case 3:
                    System.out.print("Digite o nome do evento que deseja excluir: ");
                    String nomeExcluir = scanner.nextLine();
                    eventoLista.excluirEvento(nomeExcluir);
                    break;

                case 4:
                    System.out.println("Registrando um novo palestrante:");
                    System.out.print("Nome do palestrante: ");
                    String nomePalestrante = scanner.nextLine();
                    System.out.print("Registro do palestrante: ");
                    String registroPalestrante = scanner.nextLine();

                    Palestrante novoPalestrante = new Palestrante(nomePalestrante, registroPalestrante);
                    palestrantes.add(novoPalestrante);
                    System.out.println("Palestrante registrado com sucesso.");
                    break;

                case 5:
                    System.out.println("Registrando um novo participante:");
                    System.out.print("Nome do participante: ");
                    String nomeParticipante = scanner.nextLine();
                    System.out.print("Registro do participante: ");
                    String registroParticipante = scanner.nextLine();

                    Participante novoParticipante = new Participante(nomeParticipante, registroParticipante);
                    participantes.add(novoParticipante);
                    System.out.println("Participante registrado com sucesso.");
                    break;

                case 6:
                    if (palestrantes.isEmpty()) {
                        System.out.println("Nenhum palestrante registrado.");
                        break;
                    }
                    System.out.print("Digite o nome do evento ao qual deseja adicionar o palestrante: ");
                    String eventoPalestrante = scanner.nextLine();

                    Evento eventoSelecionadoPalestrante = buscarEventoPorNome(eventoLista, eventoPalestrante);
                    if (eventoSelecionadoPalestrante != null) {
                        System.out.println("Selecione um palestrante pelo número:");
                        for (int i = 0; i < palestrantes.size(); i++) {
                            System.out.println((i + 1) + ". " + palestrantes.get(i).nome);
                        }
                        int escolhaPalestrante = scanner.nextInt();
                        scanner.nextLine(); // Consumir nova linha

                        if (escolhaPalestrante > 0 && escolhaPalestrante <= palestrantes.size()) {
                            Palestrante palestranteSelecionado = palestrantes.get(escolhaPalestrante - 1);
                            eventoSelecionadoPalestrante.adicionarPalestrante(palestranteSelecionado);
                        } else {
                            System.out.println("Escolha inválida.");
                        }
                    } else {
                        System.out.println("Evento não encontrado.");
                    }
                    break;

                case 7:
                    if (participantes.isEmpty()) {
                        System.out.println("Nenhum participante registrado.");
                        break;
                    }
                    System.out.print("Digite o nome do evento ao qual deseja adicionar o participante: ");
                    String eventoParticipante = scanner.nextLine();

                    Evento eventoSelecionadoParticipante = buscarEventoPorNome(eventoLista, eventoParticipante);
                    if (eventoSelecionadoParticipante != null) {
                        System.out.println("Selecione um participante pelo número:");
                        for (int i = 0; i < participantes.size(); i++) {
                            System.out.println((i + 1) + ". " + participantes.get(i).nome);
                        }
                        int escolhaParticipante = scanner.nextInt();
                        scanner.nextLine(); // Consumir nova linha

                        if (escolhaParticipante > 0 && escolhaParticipante <= participantes.size()) {
                            Participante participanteSelecionado = participantes.get(escolhaParticipante - 1);
                            eventoSelecionadoParticipante.adicionarParticipante(participanteSelecionado);
                        } else {
                            System.out.println("Escolha inválida.");
                        }
                    } else {
                        System.out.println("Evento não encontrado.");
                    }
                    break;

                case 8:
                    System.out.println("Saindo do sistema...");
                    continuar = false;
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }

    // Função auxiliar para buscar evento por nome
    public static Evento buscarEventoPorNome(EventoLista eventoLista, String nomeEvento) {
        for (Evento evento : eventoLista.getEventos()) {
            if (evento.getNome().equals(nomeEvento)) {
                return evento;
            }
        }
        return null;
    }
}
