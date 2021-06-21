package br.com.zupacademy.giovanna.transacao.transacao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends PagingAndSortingRepository<Transacao, Long> {
}
