package br.com.alura.screenmatch.excecao;

public class ErroConversaodeAno extends RuntimeException {
    private String mensagem;
    public ErroConversaodeAno(String mensagem){
    this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
