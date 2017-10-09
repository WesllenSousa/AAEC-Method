/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades.activity_data;

import java.util.ArrayList;
import org.hibernate.Query;
import util.BaseDaoImpl;
import util.Conexao;
import util.DaoException;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class ActivityDataDaoImpl extends BaseDaoImpl<ActivityDataBean> implements ActivityDataDao {

    public ActivityDataDaoImpl() {
        super(ActivityDataBean.class);
    }
    
    @Override
    public ArrayList<ActivityDataBean> listarAtividadeOrdenadaPorDia() throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT r FROM ActivityDataBean r ORDER BY r.yearDay");
            return (ArrayList<ActivityDataBean>) q.list();
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        }
    }
    
}
