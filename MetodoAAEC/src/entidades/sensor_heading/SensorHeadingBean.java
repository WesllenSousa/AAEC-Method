/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades.sensor_heading;

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
@Table(name = "sensor_heading")
public class SensorHeadingBean implements Serializable {
    
    @Id
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "sensor_id")
    private Integer sensorId;
    
    @Column(name = "heading_id")
    private Integer headingId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSensorId() {
        return sensorId;
    }

    public void setSensorId(Integer sensorId) {
        this.sensorId = sensorId;
    }

    public Integer getHeadingId() {
        return headingId;
    }

    public void setHeadingId(Integer headingId) {
        this.headingId = headingId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + Objects.hashCode(this.sensorId);
        hash = 41 * hash + Objects.hashCode(this.headingId);
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
        final SensorHeadingBean other = (SensorHeadingBean) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.sensorId, other.sensorId)) {
            return false;
        }
        if (!Objects.equals(this.headingId, other.headingId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SensorHeadingActivityBean{" + "id=" + id + ", sensorId=" + sensorId + ", headingId=" + headingId + '}';
    }
    
}
