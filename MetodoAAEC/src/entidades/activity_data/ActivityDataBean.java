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
@Table(name = "activity_data")
public class ActivityDataBean implements Serializable {
    
    @Id
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "year_day")
    private Integer yearDay;
    
    @Column(name = "week_day")
    private Integer weekDay;
    
    @Column(name = "start_time")
    private Integer startTime;
    
    @Column(name = "activity_code")
    private Integer activityCode;
    
    @Column(name = "subcategory_index")
    private Integer subcategoryIndex;
    
    @Column(name = "end_time")
    private Integer endTime;
    
    @Column(name = "indicator")
    private Integer indicator;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYearDay() {
        return yearDay;
    }

    public void setYearDay(Integer yearDay) {
        this.yearDay = yearDay;
    }

    public Integer getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(Integer weekDay) {
        this.weekDay = weekDay;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getActivityCode() {
        return activityCode;
    }

    public void setActivityCode(Integer activityCode) {
        this.activityCode = activityCode;
    }

    public Integer getSubcategoryIndex() {
        return subcategoryIndex;
    }

    public void setSubcategoryIndex(Integer subcategoryIndex) {
        this.subcategoryIndex = subcategoryIndex;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public Integer getIndicator() {
        return indicator;
    }

    public void setIndicator(Integer indicator) {
        this.indicator = indicator;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.yearDay);
        hash = 23 * hash + Objects.hashCode(this.weekDay);
        hash = 23 * hash + Objects.hashCode(this.startTime);
        hash = 23 * hash + Objects.hashCode(this.activityCode);
        hash = 23 * hash + Objects.hashCode(this.subcategoryIndex);
        hash = 23 * hash + Objects.hashCode(this.endTime);
        hash = 23 * hash + Objects.hashCode(this.indicator);
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
        final ActivityDataBean other = (ActivityDataBean) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.yearDay, other.yearDay)) {
            return false;
        }
        if (!Objects.equals(this.weekDay, other.weekDay)) {
            return false;
        }
        if (!Objects.equals(this.startTime, other.startTime)) {
            return false;
        }
        if (!Objects.equals(this.activityCode, other.activityCode)) {
            return false;
        }
        if (!Objects.equals(this.subcategoryIndex, other.subcategoryIndex)) {
            return false;
        }
        if (!Objects.equals(this.endTime, other.endTime)) {
            return false;
        }
        if (!Objects.equals(this.indicator, other.indicator)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ActivityDataBean{" + "id=" + id + ", yearDay=" + yearDay + ", weekDay=" + weekDay + ", startTime=" + startTime + ", activityCode=" + activityCode + ", subcategoryIndex=" + subcategoryIndex + ", endTime=" + endTime + ", indicator=" + indicator + '}';
    }
    
}
