/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades.activity_location;

import util.BaseDaoImpl;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class ActivityLocationDaoImpl extends BaseDaoImpl<ActivityLocationBean> implements ActivityLocationDao {

    public ActivityLocationDaoImpl() {
        super(ActivityLocationBean.class);
    }
    
}
