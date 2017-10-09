/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades.appliances;

import java.util.ArrayList;
import org.hibernate.Query;
import util.BaseDaoImpl;
import util.Conexao;
import util.DaoException;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class AppliancesDaoImpl extends BaseDaoImpl<AppliancesBean> implements AppliancesDao {

    public AppliancesDaoImpl() {
        super(AppliancesBean.class);
    }

    @Override
    public AppliancesBean selecionarAparelhoPorNome(String name) throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT a FROM AppliancesBean a WHERE a.name = :name");
            q.setParameter("name", name);
            return (AppliancesBean) q.uniqueResult();
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        }
    }
    
    @Override
    public ArrayList<AppliancesBean> listarAparelhoTipo1e2() throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT a FROM AppliancesBean a WHERE a.typeAppliance BETWEEN 1 and 2");
            return (ArrayList<AppliancesBean>) q.list();
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        }
    }
    
    @Override
    public ArrayList<AppliancesBean> listarAparelhoTipo4e5() throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT a FROM AppliancesBean a WHERE a.typeAppliance BETWEEN 4 and 5");
            return (ArrayList<AppliancesBean>) q.list();
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        }
    }
    
    @Override
    public ArrayList<AppliancesBean> listarAparelhoTipo6() throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT a FROM AppliancesBean a WHERE a.typeAppliance = 6");
            return (ArrayList<AppliancesBean>) q.list();
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        }
    }
    
}
