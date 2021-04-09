package sn.thies.ut.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.thies.ut.modeles.Emprunt;


public interface EmpruntRepository extends JpaRepository<Emprunt, Integer>{

}
