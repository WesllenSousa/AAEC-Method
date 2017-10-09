/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades.locations;

import util.BaseDaoImpl;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class LocationsDaoImpl extends BaseDaoImpl<LocationsBean> implements LocationsDao {

    public LocationsDaoImpl() {
        super(LocationsBean.class);
    }
    
}
