package sn.thies.ut.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.thies.ut.modeles.Livre;

public interface LivreRepository extends JpaRepository<Livre, Integer>{
}
