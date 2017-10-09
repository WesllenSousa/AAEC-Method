/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades.sensor_data;

import util.BaseDaoImpl;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class LocalSensorDaoImpl extends BaseDaoImpl<LocalSensorBean> implements LocalSensorDao {

    public LocalSensorDaoImpl() {
        super(LocalSensorBean.class);
    }
    
}
