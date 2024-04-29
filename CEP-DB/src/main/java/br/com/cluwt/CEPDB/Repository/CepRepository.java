package br.com.cluwt.CEPDB.Repository;

import br.com.cluwt.CEPDB.Models.Cep;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CepRepository extends JpaRepository<Cep, Long> {

    Cep findByCep(String cep);

    List<Cep> findByLogradouroContaining(String logradouro);

    List<Cep> findByBairroContaining(String bairro);

    List<Cep> findByLocalidadeContaining(String localidade);

    List<Cep> findByUf(String uf);
}
