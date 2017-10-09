/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades.week_day;

import util.BaseDaoImpl;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class WeekDayDaoImpl extends BaseDaoImpl<WeekDayBean> implements WeekDayDao {

    public WeekDayDaoImpl() {
        super(WeekDayBean.class);
    }
    
}
