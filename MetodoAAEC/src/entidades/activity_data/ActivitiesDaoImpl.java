/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades.activity_data;

import util.BaseDaoImpl;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class ActivitiesDaoImpl extends BaseDaoImpl<ActivitiesViewBean> implements ActivitiesViewDao {

    public ActivitiesDaoImpl() {
        super(ActivitiesViewBean.class);
    }
    
}
