/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades.types;

import util.BaseDaoImpl;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class TypesDaoImpl extends BaseDaoImpl<TypesBean> implements TypesDao {

    public TypesDaoImpl() {
        super(TypesBean.class);
    }
    
}
