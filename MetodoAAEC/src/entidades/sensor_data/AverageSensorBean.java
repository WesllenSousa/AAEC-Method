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
@Table(name = "average_sensor")
public class AverageSensorBean implements Serializable {
    
    
    @Id
    @Column(name = "sensor_id")
    private Integer sensorId;
    
    @Column(name = "types")
    private String types;
    
    @Column(name = "average_interval")
    private Float averageInterval;

    public Integer getSensorId() {
        return sensorId;
    }

    public void setSensorId(Integer sensorId) {
        this.sensorId = sensorId;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public Float getAverageInterval() {
        return averageInterval;
    }

    public void setAverageInterval(Float averageInterval) {
        this.averageInterval = averageInterval;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.sensorId);
        hash = 37 * hash + Objects.hashCode(this.types);
        hash = 37 * hash + Objects.hashCode(this.averageInterval);
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
        final AverageSensorBean other = (AverageSensorBean) obj;
        if (!Objects.equals(this.sensorId, other.sensorId)) {
            return false;
        }
        if (!Objects.equals(this.types, other.types)) {
            return false;
        }
        if (!Objects.equals(this.averageInterval, other.averageInterval)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AverageSensorBean{" + "sensorId=" + sensorId + ", types=" + types + ", averageInterval=" + averageInterval + '}';
    }
      
}
