package br.com.estudo.estudo.repository;

import br.com.estudo.estudo.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface H2Repository extends JpaRepository<UserData,Long> {

    List<UserData> findAll();

    List<UserData> findByNome(String nome);
}
