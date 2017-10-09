/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades.appliances;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Wesllen Sousa Lima
 */

@Entity
@Table(name = "appliances")
public class AppliancesBean implements Serializable {
    
    @Id
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "consumption_on")
    private Float consumptionOn;
    
    @Column(name = "consumption_standby")
    private Float consumptionStandby;
    
    @Column(name = "model")
    private String model;
    
    @Column(name = "on_off_standby")
    @Enumerated(EnumType.ORDINAL)
    private EnumLigarDesligar status;
    
    @Column(name = "priority")
    private Integer priority;

    @Column(name = "type_appliance")
    @Enumerated(EnumType.ORDINAL)
    private EnumTypeAppliance typeAppliance;
    
    @Column(name = "tempo_tipo2")
    private Integer tempoTipo2;

    @Transient
    private Float consumo_on;
    
    @Transient
    private Float consumo_standby;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getConsumptionOn() {
        return consumptionOn;
    }

    public void setConsumptionOn(Float consumptionOn) {
        this.consumptionOn = consumptionOn;
    }

    public Float getConsumptionStandby() {
        return consumptionStandby;
    }

    public void setConsumptionStandby(Float consumptionStandby) {
        this.consumptionStandby = consumptionStandby;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public EnumLigarDesligar getStatus() {
        return status;
    }

    public void setStatus(EnumLigarDesligar status) {
        this.status = status;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public EnumTypeAppliance getTypeAppliance() {
        return typeAppliance;
    }

    public void setTypeAppliance(EnumTypeAppliance typeAppliance) {
        this.typeAppliance = typeAppliance;
    }

    public Integer getTempoTipo2() {
        return tempoTipo2;
    }

    public void setTempoTipo2(Integer tempoTipo2) {
        this.tempoTipo2 = tempoTipo2;
    }

    public Float getConsumo_on() {
        return consumo_on;
    }

    public void setConsumo_on(Float consumo_on) {
        this.consumo_on = consumo_on;
    }

    public Float getConsumo_standby() {
        return consumo_standby;
    }

    public void setConsumo_standby(Float consumo_standby) {
        this.consumo_standby = consumo_standby;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.name);
        hash = 83 * hash + Objects.hashCode(this.consumptionOn);
        hash = 83 * hash + Objects.hashCode(this.consumptionStandby);
        hash = 83 * hash + Objects.hashCode(this.model);
        hash = 83 * hash + Objects.hashCode(this.status);
        hash = 83 * hash + Objects.hashCode(this.priority);
        hash = 83 * hash + Objects.hashCode(this.typeAppliance);
        hash = 83 * hash + Objects.hashCode(this.tempoTipo2);
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
        final AppliancesBean other = (AppliancesBean) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.consumptionOn, other.consumptionOn)) {
            return false;
        }
        if (!Objects.equals(this.consumptionStandby, other.consumptionStandby)) {
            return false;
        }
        if (!Objects.equals(this.model, other.model)) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        if (!Objects.equals(this.priority, other.priority)) {
            return false;
        }
        if (this.typeAppliance != other.typeAppliance) {
            return false;
        }
        if (!Objects.equals(this.tempoTipo2, other.tempoTipo2)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return name;
    }
    
}
