package br.com.zupacademy.giovanna.transacao.transacao;

import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.stereotype.Component;

@Component
public class ListenerDeTransacao {

    private final TransacaoRepository transacaoRepository;

    public ListenerDeTransacao(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    @Bean
    JsonMessageConverter jsonMessageConverter() {
        return new JsonMessageConverter();
    }

    @KafkaListener(topics = "${spring.kafka.topic.transactions}", groupId = "${spring.kafka.consumer.group-id}")
    public void ouvir(EventoDeTransacao evento) {
        System.out.println(evento);
        transacaoRepository.save(evento.toModel());
    }
}
