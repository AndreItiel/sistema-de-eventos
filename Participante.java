public class Participante extends Pessoa {
    private String historico;
    private String preferencia;
    private String palestraInscrita;

    public Participante(String nome, String registro) {
        super(nome, registro);
        this.historico = "";
        this.preferencia = "";
        this.palestraInscrita = "";
    }

    public void inscreverPalestra(String palestra) {
        this.palestraInscrita = palestra;
        System.out.println("Participante '" + nome + "' inscrito na palestra: " + palestra);
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Palestra inscrita: " + palestraInscrita);
    }
}
