package br.com.zupacademy.giovanna.transacao.compra;

import br.com.zupacademy.giovanna.transacao.cartao.Cartao;
import br.com.zupacademy.giovanna.transacao.cartao.CartaoRepository;
import br.com.zupacademy.giovanna.transacao.handler.ErrorResponse;
import br.com.zupacademy.giovanna.transacao.transacao.DetalheTransacao;
import br.com.zupacademy.giovanna.transacao.transacao.Transacao;
import br.com.zupacademy.giovanna.transacao.transacao.TransacaoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CompraController {

    private final TransacaoRepository transacaoRepository;
    private final CartaoRepository cartaoRepository;

    public CompraController(TransacaoRepository transacaoRepository,
                            CartaoRepository cartaoRepository) {
        this.transacaoRepository = transacaoRepository;
        this.cartaoRepository = cartaoRepository;
    }

    @GetMapping("/cartoes/{id}")
    ResponseEntity<?> buscaUltimasCompras(@PathVariable String id){
        Optional<Cartao> cartaoOptional = cartaoRepository.findById(id);
        if(cartaoOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("id", "Cartão não encontrado"));
        }
        List<Transacao> ultimas10Compras = transacaoRepository.findTop10ByCartaoIdOrderByEfetivadaEmDesc(id);
        return ResponseEntity.ok(ultimas10Compras.stream().map(DetalheTransacao::new));
    }
}
