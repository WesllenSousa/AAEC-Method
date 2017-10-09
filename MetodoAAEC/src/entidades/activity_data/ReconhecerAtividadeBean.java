/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades.activity_data;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Wesllen Sousa Lima
 */

@Entity
@Table(name = "reconhecer_atividade")
public class ReconhecerAtividadeBean implements Serializable {
    
    @Id
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "heading")
    private String heading;
    
    @Column(name = "locations")
    private String locations;
    
    @Column(name = "subcategory")
    private String subcategory;
    
    @Column(name = "average_activity")
    private Float averageActivity;
    
    @Column(name = "average_sensor")
    private Float averageSensor;
    
    @Column(name = "location_id")
    private Integer locationId;
    
    @Column(name = "heading_id")
    private Integer headingId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getLocations() {
        return locations;
    }

    public void setLocations(String locations) {
        this.locations = locations;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public Float getAverageActivity() {
        return averageActivity;
    }

    public void setAverageActivity(Float averageActivity) {
        this.averageActivity = averageActivity;
    }

    public Float getAverageSensor() {
        return averageSensor;
    }

    public void setAverageSensor(Float averageSensor) {
        this.averageSensor = averageSensor;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Integer getHeadingId() {
        return headingId;
    }

    public void setHeadingId(Integer headingId) {
        this.headingId = headingId;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.heading);
        hash = 97 * hash + Objects.hashCode(this.locations);
        hash = 97 * hash + Objects.hashCode(this.subcategory);
        hash = 97 * hash + Objects.hashCode(this.averageActivity);
        hash = 97 * hash + Objects.hashCode(this.averageSensor);
        hash = 97 * hash + Objects.hashCode(this.locationId);
        hash = 97 * hash + Objects.hashCode(this.headingId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ReconhecerAtividadeBean other = (ReconhecerAtividadeBean) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.heading, other.heading)) {
            return false;
        }
        if (!Objects.equals(this.locations, other.locations)) {
            return false;
        }
        if (!Objects.equals(this.subcategory, other.subcategory)) {
            return false;
        }
        if (!Objects.equals(this.averageActivity, other.averageActivity)) {
            return false;
        }
        if (!Objects.equals(this.averageSensor, other.averageSensor)) {
            return false;
        }
        if (!Objects.equals(this.locationId, other.locationId)) {
            return false;
        }
        if (!Objects.equals(this.headingId, other.headingId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ReconhecerAtividadeBean{" + "heading=" + heading + ", locations=" + locations + ", subcategory=" + subcategory + ", averageActivity=" + averageActivity + ", averageSensor=" + averageSensor + ", locationId=" + locationId + ", headingId=" + headingId + '}';
    } 
    
}
