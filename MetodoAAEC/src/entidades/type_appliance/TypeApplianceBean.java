/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades.type_appliance;

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
@Table(name = "type_appliance")
public class TypeApplianceBean implements Serializable {
    
    @Id
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "tipo")
    private Integer tipo;
    
    @Column(name = "class")
    private String classe;
    
    @Column(name = "presence_user")
    private String presenceUser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getPresenceUser() {
        return presenceUser;
    }

    public void setPresenceUser(String presenceUser) {
        this.presenceUser = presenceUser;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.tipo);
        hash = 53 * hash + Objects.hashCode(this.classe);
        hash = 53 * hash + Objects.hashCode(this.presenceUser);
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
        final TypeApplianceBean other = (TypeApplianceBean) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.classe, other.classe)) {
            return false;
        }
        if (!Objects.equals(this.presenceUser, other.presenceUser)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TypeApplianceBean{" + "id=" + id + ", tipo=" + tipo + ", classe=" + classe + ", presenceUser=" + presenceUser + '}';
    }
    
}
