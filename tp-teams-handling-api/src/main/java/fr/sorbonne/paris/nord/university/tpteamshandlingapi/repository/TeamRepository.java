package fr.sorbonne.paris.nord.university.tpteamshandlingapi.repository;

import fr.sorbonne.paris.nord.university.tpteamshandlingapi.entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TeamRepository extends JpaRepository<TeamEntity, Long> {

    /**
    public List<TeamEntity> findAll();
    public TeamEntity findById(Long id);
    public Long save(TeamEntity teamEntity);
    public void update(TeamEntity teamEntity);
    public void deleteById(Long id);
    */


    @Query("SELECT team FROM TeamEntity team WHERE team.name = :name")
    TeamEntity findByName(String name);


}
