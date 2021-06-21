package br.com.zupacademy.giovanna.transacao.transacao;

import br.com.zupacademy.giovanna.transacao.cartao.Cartao;
import br.com.zupacademy.giovanna.transacao.estabelecimento.Estabelecimento;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transacao {

    @Id
    private String id;

    @NotNull
    @Column(nullable = false)
    private BigDecimal valor;

    @ManyToOne(cascade = CascadeType.ALL)
    private Estabelecimento estabelecimento;

    @ManyToOne(cascade = CascadeType.ALL)
    private Cartao cartao;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime efetivadaEm;

    @Deprecated
    public Transacao() {
    }

    public Transacao(String id, BigDecimal valor,
                     Estabelecimento estabelecimento,
                     Cartao cartao, LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }
}
