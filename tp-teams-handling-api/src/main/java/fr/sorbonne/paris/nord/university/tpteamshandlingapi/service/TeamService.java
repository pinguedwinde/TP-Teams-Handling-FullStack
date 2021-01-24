package fr.sorbonne.paris.nord.university.tpteamshandlingapi.service;

import fr.sorbonne.paris.nord.university.tpteamshandlingapi.entity.TeamEntity;
import fr.sorbonne.paris.nord.university.tpteamshandlingapi.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class TeamService {
    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<TeamEntity> findAll(){
        return teamRepository.findAll();
    }

    public TeamEntity findById(Long id){
        try {
            return teamRepository.findById(id).orElseThrow();
        }catch (NoSuchElementException e){
            return null;
        }
    }

    public TeamEntity findByName(String name){
        return teamRepository.findByName(name);
    }


    public TeamEntity save(TeamEntity teamEntity){
        return teamRepository.save(teamEntity);
    }

    public TeamEntity update(TeamEntity teamEntity){
        return teamRepository.save(teamEntity);
    }

    public boolean deleteById(Long id){
        teamRepository.deleteById(id);
        TeamEntity teamEntity = this.findById(id);
        if(teamEntity == null){
            return true;
        }else{
            return false;
        }
    }

}
