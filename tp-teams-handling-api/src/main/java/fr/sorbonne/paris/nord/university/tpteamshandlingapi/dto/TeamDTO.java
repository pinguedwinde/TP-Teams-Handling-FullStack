package fr.sorbonne.paris.nord.university.tpteamshandlingapi.dto;

import java.util.Objects;

public class TeamDTO {

    private Long id;
    private String name;
    private String slogan;

    public TeamDTO() {
    }

    public TeamDTO(Long id, String name, String slogan) {
        this.id = id;
        this.name = name;
        this.slogan = slogan;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TeamDTO)) return false;
        TeamDTO teamDTO = (TeamDTO) o;
        return Objects.equals(getId(), teamDTO.getId()) && Objects.equals(getName(), teamDTO.getName()) && Objects.equals(getSlogan(), teamDTO.getSlogan());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSlogan());
    }

    @Override
    public String toString() {
        return "TeamDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", slogan='" + slogan + '\'' +
                '}';
    }
}
