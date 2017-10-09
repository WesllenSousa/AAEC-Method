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
public class SensorsDaoImpl extends BaseDaoImpl<SensorsBean> implements SensorsDao {

    public SensorsDaoImpl() {
        super(SensorsBean.class);
    }
    
}
