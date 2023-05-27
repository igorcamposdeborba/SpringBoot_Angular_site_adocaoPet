package com.adocao.pet.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.adocao.pet.entities.Ong;

//Repository com métodos pré-implementados que se comunicam com o banco de dados
public interface OngRepository extends JpaRepository<Ong, Integer> {

}
