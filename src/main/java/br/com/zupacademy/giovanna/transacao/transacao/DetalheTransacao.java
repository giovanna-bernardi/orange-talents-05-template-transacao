package br.com.zupacademy.giovanna.transacao.transacao;

import br.com.zupacademy.giovanna.transacao.cartao.DetalheCartao;
import br.com.zupacademy.giovanna.transacao.estabelecimento.DetalheEstabelecimento;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class DetalheTransacao {
    private String id;
    private BigDecimal valor;
    private DetalheEstabelecimento estabelecimento;
    private DetalheCartao cartao;
    private LocalDateTime efetivadaEm;

    public DetalheTransacao(Transacao transacao) {
        this.id = transacao.getId();
        this.valor = transacao.getValor();
        this.estabelecimento = new DetalheEstabelecimento(transacao.getEstabelecimento());
        this.cartao = new DetalheCartao(transacao.getCartao());
        this.efetivadaEm = transacao.getEfetivadaEm();
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public DetalheEstabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public DetalheCartao getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}
