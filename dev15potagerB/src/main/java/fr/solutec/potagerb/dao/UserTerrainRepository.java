package fr.solutec.potagerb.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.potagerb.entities.UserTerrain;

public interface UserTerrainRepository extends CrudRepository<UserTerrain, Long> {

	
	public void deleteByTerrainId(Long id);
	
	public List<UserTerrain> findByTerrainId(Long id);
	
	
	@Query("DELETE FROM UserTerrain UT WHERE UT.terrain.id=?1")
	@Transactional
	@Modifying
	public void supprTerrain(Long id);
	
	@Query("SELECT COUNT(user.id) FROM UserTerrain WHERE terrain.id=?1 ")
	public int countUserOfTerrain(Long id);
	
}	