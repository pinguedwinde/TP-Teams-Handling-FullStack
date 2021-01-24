package fr.sorbonne.paris.nord.university.tpteamshandlingapi.entity;

import javax.persistence.*;
import java.util.Objects;


@Entity(name = "TeamEntity")
@Access(AccessType.FIELD)
@Table(name = "team")
public class TeamEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name ="slogan")
    private String slogan;

    public TeamEntity() {
    }

    public TeamEntity(long id, String name, String slogan) {
        this.id = id;
        this.name = name;
        this.slogan = slogan;
    }

    public TeamEntity(String name, String slogan) {
        this.name = name;
        this.slogan = slogan;
    }

    public Long getId() {
        return id;
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
        if (!(o instanceof TeamEntity)) return false;
        TeamEntity that = (TeamEntity) o;
        return getId() == that.getId() && getName().equals(that.getName()) && getSlogan().equals(that.getSlogan());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSlogan());
    }

    @Override
    public String toString() {
        return "TeamEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", slogan='" + slogan + '\'' +
                '}';
    }
}
