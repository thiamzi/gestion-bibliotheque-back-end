package sn.thies.ut.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import sn.thies.ut.modeles.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Integer>{
	Optional<UserModel> findByEmail(String email);

}
