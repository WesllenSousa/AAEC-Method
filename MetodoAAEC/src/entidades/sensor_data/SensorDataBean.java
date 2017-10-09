/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades.sensor_data;

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
@Table(name = "sensor_data")
public class SensorDataBean implements Serializable {
    
    @Id
    @Column(name = "id")
    private Integer id;
   
    @Column(name = "year_day")
    private Integer yearDay;
    
    @Column(name = "week_day")
    private Integer weekDay;
    
    @Column(name = "activation")
    private Integer activation;
    
    @Column(name = "desactivation")
    private Integer desactivation;
    
    @Column(name = "interval")
    private Integer interval;
    
    @Column(name = "sensor_id")
    private Integer sensorId;
    
    @Column(name = "location")
    private Integer location;
    
    @Column(name = "type")
    private Integer type;

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

    public Integer getActivation() {
        return activation;
    }

    public void setActivation(Integer activation) {
        this.activation = activation;
    }

    public Integer getDesactivation() {
        return desactivation;
    }

    public void setDesactivation(Integer desactivation) {
        this.desactivation = desactivation;
    }

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    public Integer getSensorId() {
        return sensorId;
    }

    public void setSensorId(Integer sensorId) {
        this.sensorId = sensorId;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.yearDay);
        hash = 23 * hash + Objects.hashCode(this.weekDay);
        hash = 23 * hash + Objects.hashCode(this.activation);
        hash = 23 * hash + Objects.hashCode(this.desactivation);
        hash = 23 * hash + Objects.hashCode(this.interval);
        hash = 23 * hash + Objects.hashCode(this.sensorId);
        hash = 23 * hash + Objects.hashCode(this.location);
        hash = 23 * hash + Objects.hashCode(this.type);
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
        final SensorDataBean other = (SensorDataBean) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.yearDay, other.yearDay)) {
            return false;
        }
        if (!Objects.equals(this.weekDay, other.weekDay)) {
            return false;
        }
        if (!Objects.equals(this.activation, other.activation)) {
            return false;
        }
        if (!Objects.equals(this.desactivation, other.desactivation)) {
            return false;
        }
        if (!Objects.equals(this.interval, other.interval)) {
            return false;
        }
        if (!Objects.equals(this.sensorId, other.sensorId)) {
            return false;
        }
        if (!Objects.equals(this.location, other.location)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SensorDataBean{" + "interval=" + interval + ", sensorId=" + sensorId + ", location=" + location + ", type=" + type + '}';
    }
    
}
