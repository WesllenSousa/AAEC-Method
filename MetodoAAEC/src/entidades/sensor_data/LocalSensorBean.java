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
@Table(name = "local_sensor")
public class LocalSensorBean implements Serializable {
    
    @Id
    @Column(name = "sensor_id")
    private Integer sensorId;
    
    @Column(name = "locations")
    private String locations;
    
    @Column(name = "types")
    private String types;

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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.sensorId);
        hash = 59 * hash + Objects.hashCode(this.locations);
        hash = 59 * hash + Objects.hashCode(this.types);
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
        final LocalSensorBean other = (LocalSensorBean) obj;
        if (!Objects.equals(this.sensorId, other.sensorId)) {
            return false;
        }
        if (!Objects.equals(this.locations, other.locations)) {
            return false;
        }
        if (!Objects.equals(this.types, other.types)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LocalSensorBean{" + "sensorId=" + sensorId + ", locations=" + locations + ", types=" + types + '}';
    }
    
}
