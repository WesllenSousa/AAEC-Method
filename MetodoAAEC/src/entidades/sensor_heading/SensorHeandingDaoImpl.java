/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades.sensor_heading;

import util.BaseDaoImpl;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class SensorHeandingDaoImpl extends BaseDaoImpl<SensorHeadingBean> implements SensorHeadingDao {

    public SensorHeandingDaoImpl() {
        super(SensorHeadingBean.class);
    }
    
}
