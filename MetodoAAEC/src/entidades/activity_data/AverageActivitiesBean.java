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
@Table(name = "average_activities")
public class AverageActivitiesBean implements Serializable {
    
    @Id
    @Column(name = "code")
    private Integer activityCode;
    
    @Column(name = "heading")
    private String heading;
    
    @Column(name = "subcategory")
    private String subcategory;
    
    @Column(name = "average_interval")
    private Float averageInterval;

    public Integer getActivityCode() {
        return activityCode;
    }

    public void setActivityCode(Integer activityCode) {
        this.activityCode = activityCode;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public Float getAverageInterval() {
        return averageInterval;
    }

    public void setAverageInterval(Float averageInterval) {
        this.averageInterval = averageInterval;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.activityCode);
        hash = 59 * hash + Objects.hashCode(this.heading);
        hash = 59 * hash + Objects.hashCode(this.subcategory);
        hash = 59 * hash + Objects.hashCode(this.averageInterval);
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
        final AverageActivitiesBean other = (AverageActivitiesBean) obj;
        if (!Objects.equals(this.activityCode, other.activityCode)) {
            return false;
        }
        if (!Objects.equals(this.heading, other.heading)) {
            return false;
        }
        if (!Objects.equals(this.subcategory, other.subcategory)) {
            return false;
        }
        if (!Objects.equals(this.averageInterval, other.averageInterval)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ActivityApplianceViewDaoImpl{" + "activityCode=" + activityCode + ", heading=" + heading + ", subcategory=" + subcategory + ", averageInterval=" + averageInterval + '}';
    }
    
}
