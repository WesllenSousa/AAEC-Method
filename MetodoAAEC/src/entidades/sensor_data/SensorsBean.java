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
@Table(name = "sensors")
public class SensorsBean implements Serializable {
    
    @Id
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "day")
    private String day;
    
    @Column(name = "sensor_id")
    private Integer sensorId;
    
    @Column(name = "locations")
    private String locations;
    
    @Column(name = "types")
    private String types;
    
    @Column(name = "activation")
    private Integer activation;
    
    @Column(name = "desactivation")
    private Integer desactivation;
    
    @Column(name = "interval")
    private Integer interval;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Integer getSensorId() {
        return sensorId;
    }

    public void setSensorId(Integer sensorId) {
        this.sensorId = sensorId;
    }

    public String getLocations() {
        return locations;
    }

    public void setLocations(String locations) {
        this.locations = locations;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.day);
        hash = 23 * hash + Objects.hashCode(this.sensorId);
        hash = 23 * hash + Objects.hashCode(this.locations);
        hash = 23 * hash + Objects.hashCode(this.types);
        hash = 23 * hash + Objects.hashCode(this.activation);
        hash = 23 * hash + Objects.hashCode(this.desactivation);
        hash = 23 * hash + Objects.hashCode(this.interval);
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
        final SensorsBean other = (SensorsBean) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.day, other.day)) {
            return false;
        }
        if (!Objects.equals(this.sensorId, other.sensorId)) {
            return false;
        }
        if (!Objects.equals(this.locations, other.locations)) {
            return false;
        }
        if (!Objects.equals(this.types, other.types)) {
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
        return true;
    }

    @Override
    public String toString() {
        return "SensorsBean{" + "id=" + id + ", sensorId=" + sensorId + ", locations=" + locations + ", types=" + types + '}';
    }
    
}
