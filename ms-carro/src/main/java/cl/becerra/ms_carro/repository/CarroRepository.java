package cl.becerra.ms_carro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.becerra.ms_carro.entity.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro,Integer>{

    List<Carro> findByUsuarioId(int usuarioId);


}
