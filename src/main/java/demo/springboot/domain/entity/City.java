package demo.springboot.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class City {
    /**
     * 城市编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 描述
     */

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getcityName() {
        return cityName;
    }

    public void setcityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public City() {}

    public City(String cityName, String description) {
        this.cityName = cityName;
        this.description = description;
    }
}
