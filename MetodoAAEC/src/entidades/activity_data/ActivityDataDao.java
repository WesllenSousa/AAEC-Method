/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades.activity_data;

import java.util.ArrayList;
import util.BaseDao;
import util.DaoException;

/**
 *
 * @author Wesllen Sousa Lima
 */
public interface ActivityDataDao extends BaseDao<ActivityDataBean>{
    
    public ArrayList<ActivityDataBean> listarAtividadeOrdenadaPorDia() throws DaoException;
    
}
