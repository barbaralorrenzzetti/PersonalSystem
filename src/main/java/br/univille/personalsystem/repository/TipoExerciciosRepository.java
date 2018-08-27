package br.univille.personalsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.personalsystem.model.TipoExercicios;
@Repository
public interface TipoExerciciosRepository extends JpaRepository<TipoExercicios, Long>{ 

}
