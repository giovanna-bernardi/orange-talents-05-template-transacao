package br.com.zupacademy.giovanna.transacao.cartao;

public class DetalheCartao {
    private String id;
    private String email;

    public DetalheCartao(Cartao cartao) {
        this.id = cartao.getId();
        this.email = cartao.getEmail();
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
