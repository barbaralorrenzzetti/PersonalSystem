package br.univille.personalsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.univille.personalsystem.model.Exercicios;

public interface ExerciciosRepository extends JpaRepository<Exercicios, Long> {

}
