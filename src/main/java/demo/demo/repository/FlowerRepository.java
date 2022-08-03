package demo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.demo.entity.Flowers;

@Repository
public interface FlowerRepository extends JpaRepository<Flowers, Integer>{
	
}
