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
@Table(name = "activities")
public class ActivitiesViewBean implements Serializable {
    
    @Id
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "code")
    private Integer acitivtyCode;
    
    @Column(name = "subcategory")
    private String subcategory;

    @Column(name = "start_time")
    private Integer startTime;
    
    @Column(name = "end_time")
    private Integer endTime;
    
    @Column(name = "interval")
    private Integer interval;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAcitivtyCode() {
        return acitivtyCode;
    }

    public void setAcitivtyCode(Integer acitivtyCode) {
        this.acitivtyCode = acitivtyCode;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.acitivtyCode);
        hash = 17 * hash + Objects.hashCode(this.subcategory);
        hash = 17 * hash + Objects.hashCode(this.startTime);
        hash = 17 * hash + Objects.hashCode(this.endTime);
        hash = 17 * hash + Objects.hashCode(this.interval);
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
        final ActivitiesViewBean other = (ActivitiesViewBean) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.acitivtyCode, other.acitivtyCode)) {
            return false;
        }
        if (!Objects.equals(this.subcategory, other.subcategory)) {
            return false;
        }
        if (!Objects.equals(this.startTime, other.startTime)) {
            return false;
        }
        if (!Objects.equals(this.endTime, other.endTime)) {
            return false;
        }
        if (!Objects.equals(this.interval, other.interval)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ActivitiesViewBean{" + "id=" + id + ", acitivtyCode=" + acitivtyCode + ", subcategory=" + subcategory + ", startTime=" + startTime + ", endTime=" + endTime + ", interval=" + interval + '}';
    }
    
}
