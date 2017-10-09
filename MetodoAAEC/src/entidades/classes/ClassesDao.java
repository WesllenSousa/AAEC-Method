/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades.classes;

import util.BaseDao;
import util.DaoException;

/**
 *
 * @author Wesllen Sousa Lima
 */
public interface ClassesDao extends BaseDao<ClassesBean> {
    
    public ClassesBean selecionarClassePorCode(Integer code) throws DaoException;
    
}
