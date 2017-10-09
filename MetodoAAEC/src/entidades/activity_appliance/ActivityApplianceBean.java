/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades.activity_appliance;

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
@Table(name = "activity_appliance")
public class ActivityApplianceBean implements Serializable {
    
    @Id
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "activity")
    private Integer activity;
    
    @Column(name = "appliance")
    private Integer appliance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getActivity() {
        return activity;
    }

    public void setActivity(Integer activity) {
        this.activity = activity;
    }

    public Integer getAppliance() {
        return appliance;
    }

    public void setAppliance(Integer appliance) {
        this.appliance = appliance;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.activity);
        hash = 23 * hash + Objects.hashCode(this.appliance);
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
        final ActivityApplianceBean other = (ActivityApplianceBean) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.activity, other.activity)) {
            return false;
        }
        if (!Objects.equals(this.appliance, other.appliance)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ActivityApplianceBean{" + "id=" + id + ", activity=" + activity + ", appliance=" + appliance + '}';
    }

}
