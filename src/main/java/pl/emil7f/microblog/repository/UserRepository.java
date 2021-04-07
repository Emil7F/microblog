package pl.emil7f.microblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.emil7f.microblog.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
