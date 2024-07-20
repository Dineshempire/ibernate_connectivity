package Task_1;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "county")
public class County {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "county_seq")
    @SequenceGenerator(name = "county_seq", sequenceName = "county_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    @OneToMany(mappedBy = "county", cascade = CascadeType.ALL)
    private Set<Ward> wards;

    // Getters and setters
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

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Set<Ward> getWards() {
        return wards;
    }

    public void setWards(Set<Ward> wards) {
        this.wards = wards;
    }
}
