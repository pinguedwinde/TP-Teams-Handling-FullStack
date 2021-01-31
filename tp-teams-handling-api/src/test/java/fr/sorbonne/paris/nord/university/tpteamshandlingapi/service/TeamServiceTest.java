package fr.sorbonne.paris.nord.university.tpteamshandlingapi.service;

import fr.sorbonne.paris.nord.university.tpteamshandlingapi.entity.TeamEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TeamServiceTest {
    @Autowired
    private TeamService teamService;

    @Test
    public void should_return_true_when_teams_is_not_null_and_not_empty(){
        //Given
        /*Nothing*/

        //When
        List<TeamEntity> teams = teamService.findAll();

        //Then
        assertThat(teams).isNotNull().isNotEmpty();

    }


    @Test
    public void should_return_team_man_united_when_teamEntity_is_man_united(){
        //Given
        TeamEntity expectedManUnited = new TeamEntity(5L, "Manchester United", "Les red devils");

        //When
        TeamEntity resultManUnited = teamService.findById(5L);

        //Then
        assertThat(expectedManUnited).isEqualTo(resultManUnited);
    }

    @Test
    public void should_return_id_greater_than_0_for_newTeamEntity(){
        //Given
        TeamEntity newTeamEntity = new TeamEntity("AS Yennega", "L'amazone du Faso");

        //When
        Long idResult = teamService.save(newTeamEntity).getId();

        //Then
        assertThat(idResult).isGreaterThan(0L);
    }

    @Test
    public void should_return_red_devils_forever_when_setting_and_updating_red_devils_forever(){
        //Giving
        TeamEntity teamEntity = teamService.findById(5L);
        teamEntity.setSlogan("Red devils forever");

        //When
        teamService.update(teamEntity);
        TeamEntity updatedTeamEntity = teamService.findById(5L);

        //Then
        assertThat(updatedTeamEntity.getSlogan()).isEqualTo("Red devils forever");
    }

    @Test
    public void should_return_true_when_delete_teamEntity(){
        //Giving

        //When
        boolean isDeleted = teamService.deleteById(1L);

        //Then
        assertThat(isDeleted).isTrue();
    }
}
