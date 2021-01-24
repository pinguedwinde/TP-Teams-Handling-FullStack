package fr.sorbonne.paris.nord.university.tpteamshandlingapi.mapper;

import fr.sorbonne.paris.nord.university.tpteamshandlingapi.dto.TeamDTO;
import fr.sorbonne.paris.nord.university.tpteamshandlingapi.entity.TeamEntity;
import org.springframework.stereotype.Component;

@Component
public class TeamMapper {


    public TeamEntity toEntity(TeamDTO teamDTO){
        TeamEntity teamEntity = new TeamEntity();
        teamEntity.setName(teamDTO.getName());
        teamEntity.setSlogan(teamDTO.getSlogan());
        return teamEntity;
    }

    public TeamDTO toDTO(TeamEntity teamEntity){
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setId(teamEntity.getId());
        teamDTO.setName(teamEntity.getName());
        teamDTO.setSlogan(teamEntity.getSlogan());
        return teamDTO;
    }

}
