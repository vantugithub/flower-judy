package demo.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.demo.entity.Role;
import demo.demo.entity.RoleName;
import demo.demo.entity.User;



@Repository
public interface RoleRepository  extends JpaRepository<Role,Long>{
	Optional<Role> findByName(RoleName name);
	List<User> findUsersByName(RoleName name);
}
