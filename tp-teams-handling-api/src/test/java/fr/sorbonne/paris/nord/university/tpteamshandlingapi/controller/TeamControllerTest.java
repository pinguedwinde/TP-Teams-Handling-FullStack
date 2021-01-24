package fr.sorbonne.paris.nord.university.tpteamshandlingapi.controller;

import fr.sorbonne.paris.nord.university.tpteamshandlingapi.entity.TeamEntity;
import fr.sorbonne.paris.nord.university.tpteamshandlingapi.mapper.TeamMapper;
import fr.sorbonne.paris.nord.university.tpteamshandlingapi.service.TeamService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TeamControllerTest {

    @Mock
    private TeamService teamService;
    @Autowired
    TeamMapper teamMapper;

    private final TeamEntity mockTeam1 = new TeamEntity(1L,"Pouloupoukou1", "Poussiere1");
    private final TeamEntity mockTeam2 = new TeamEntity(2L,"Pouloupoukou2", "Poussiere2");
    private final TeamEntity mockTeam3 = new TeamEntity(3L,"Pouloupoukou3", "Poussiere3");

    List<TeamEntity> mockTeams = List.of(mockTeam1, mockTeam2, mockTeam3);

    @BeforeEach
    public void initialiseRestAssuredMockMvcStandalone() {
        //RestAssuredMockMvc.standaloneSetup(teamController);
        RestAssuredMockMvc.standaloneSetup(new TeamController(teamService,teamMapper));
    }

    @Test
    public void should_return_200_when_request_get_teams(){
        when(teamService.findAll()).thenReturn(mockTeams);

        given()
                .when()
                .get("teams")
                .then()
                .statusCode(200);
    }

    @Test
    public void should_return_200_when_request_get_team_by_id_1(){
        when(teamService.findById(1L)).thenReturn(mockTeam1);

        given()
                .when()
                .get("teams/{id}", 1L)
                .then()
                .statusCode(200);
    }

    @Test
    public void should_return_200_when_request_create_team(){

        when(teamService.save(Mockito.any())).thenReturn(mockTeam1);

        given()
                .contentType("application/json")
                .body(teamMapper.toDTO(mockTeam1))
                .when()
                .post("teams")
                .then()
                .statusCode(200);
    }

    @Test
    public void should_return_200_when_request_update_team(){
        when(teamService.findById(1L)).thenReturn(mockTeam1);
        when(teamService.save(Mockito.any())).thenReturn(mockTeam1);

        given()
                .contentType("application/json")
                .body(teamMapper.toDTO(mockTeam1))
                .when()
                .put("teams/{id}", 1L)
                .then()
                .statusCode(200);
    }

    @Test
    public void should_return_200_when_request_delete_team(){
        when(teamService.findById(1L)).thenReturn(mockTeam1);
        when(teamService.deleteById(Mockito.any())).thenReturn(true);

        given()
                .when()
                .delete("teams/{id}", 1L)
                .then()
                .statusCode(200);
    }

}
