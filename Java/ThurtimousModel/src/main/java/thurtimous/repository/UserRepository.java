package thurtimous.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thurtimous.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {



}


