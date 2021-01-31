package fr.sorbonne.paris.nord.university.tpteamshandlingapi.controller;

import fr.sorbonne.paris.nord.university.tpteamshandlingapi.dto.TeamDTO;
import fr.sorbonne.paris.nord.university.tpteamshandlingapi.entity.TeamEntity;
import fr.sorbonne.paris.nord.university.tpteamshandlingapi.mapper.TeamMapper;
import fr.sorbonne.paris.nord.university.tpteamshandlingapi.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TeamController {

    private final TeamService teamService;
    private final TeamMapper teamMapper;

    @Autowired
    public TeamController(TeamService teamService, TeamMapper teamMapper){
        this.teamService = teamService;
        this.teamMapper = teamMapper;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/teams")
    public ResponseEntity<Object> getTeams(){
        List<TeamDTO> teams = teamService
                .findAll()
                .stream()
                .map(teamMapper::toDTO)
                .collect(Collectors.toList());
        if(!teams.isEmpty()){
            return new ResponseEntity<>(teams, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Teams does not exist", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/teams/{id}")
    public ResponseEntity<Object> getTeamById(@PathVariable("id") Long id){
        TeamDTO teamDTO = teamMapper.toDTO(teamService.findById(id));
        if(teamDTO != null){
            return new ResponseEntity<>(teamDTO, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Teams with ID " + id + " has been not found", HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping (value = "/teams")
    public ResponseEntity<TeamDTO> createTeam(@RequestBody TeamDTO teamDTO){
        TeamDTO savedTeamDTO = teamMapper.toDTO(teamService.save(teamMapper.toEntity(teamDTO)));
        Long id = savedTeamDTO.getId();
        if(id != 0){
            return new ResponseEntity<>(savedTeamDTO, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(savedTeamDTO, HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping ("/teams/{id}")
    public ResponseEntity<TeamDTO> updateTeam(@RequestBody TeamDTO teamDTO){
        TeamEntity updatedTeam = teamService.update(teamMapper.toEntity(teamDTO));
        if(updatedTeam != null){
            return new ResponseEntity<>(teamMapper.toDTO(updatedTeam), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(teamDTO, HttpStatus.NOT_FOUND);
        }

    }


    @DeleteMapping("/teams/{id}")
    public ResponseEntity<TeamDTO> deleteTeam(@PathVariable("id") Long id){
        TeamDTO teamDTO = teamMapper.toDTO(teamService.findById(id));
        if(teamService.deleteById(id)){
            return new ResponseEntity<>(teamDTO, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(teamDTO, HttpStatus.NOT_FOUND);
        }
    }



}
