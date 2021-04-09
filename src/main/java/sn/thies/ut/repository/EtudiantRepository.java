package sn.thies.ut.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.thies.ut.modeles.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {

}
