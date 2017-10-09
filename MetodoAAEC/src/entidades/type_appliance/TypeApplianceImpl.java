/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades.type_appliance;

import util.BaseDaoImpl;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class TypeApplianceImpl extends BaseDaoImpl<TypeApplianceBean> implements TypeApplianceDao {

    public TypeApplianceImpl() {
        super(TypeApplianceBean.class);
    }
    
}
