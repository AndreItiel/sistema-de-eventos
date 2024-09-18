public class Pessoa {
    // Atributos comuns
    protected String nome;
    protected String registro;

    // Construtor
    public Pessoa(String nome, String registro) {
        this.nome = nome;
        this.registro = registro;
    }

    // Método comum de exibir detalhes
    public void exibirDetalhes() {
        System.out.println("Nome: " + nome);
        System.out.println("Registro: " + registro);
    }
}
