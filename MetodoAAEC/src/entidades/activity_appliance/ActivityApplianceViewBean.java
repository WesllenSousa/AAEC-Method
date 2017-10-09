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
@Table(name = "activity_appliance_view")
public class ActivityApplianceViewBean implements Serializable {
    
    @Id
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "activity")
    private String activity;
    
    @Column(name = "appliance")
    private String appliance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getAppliance() {
        return appliance;
    }

    public void setAppliance(String appliance) {
        this.appliance = appliance;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.activity);
        hash = 89 * hash + Objects.hashCode(this.appliance);
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
        final ActivityApplianceViewBean other = (ActivityApplianceViewBean) obj;
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
        return "ActivityApplianceViewBean{" + "id=" + id + ", activity=" + activity + ", appliance=" + appliance + '}';
    }
        
}
