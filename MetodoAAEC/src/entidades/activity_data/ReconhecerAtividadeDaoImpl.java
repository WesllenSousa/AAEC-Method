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
public class ReconhecerAtividadeDaoImpl extends BaseDaoImpl<ReconhecerAtividadeBean> implements ReconhecerAtividadeDao {

    public ReconhecerAtividadeDaoImpl() {
        super(ReconhecerAtividadeBean.class);
    }

    @Override
    public ArrayList<ReconhecerAtividadeBean> listarAtividadePorCategoriaLocal(Integer idCategoria, Integer idLocal) throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT a FROM ReconhecerAtividadeBean a where a.headingId = :heading and a.locationId = :local");
            q.setParameter("heading", idCategoria);
            q.setParameter("local", idLocal);
            return (ArrayList<ReconhecerAtividadeBean>) q.list();
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        }
    }

    @Override
    public ArrayList<ReconhecerAtividadeBean> listarAtividadePorCategoriaLocal(String heading, String locations) throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT a FROM ReconhecerAtividadeBean a where a.heading = :heading and a.locations = :locations");
            q.setParameter("heading", heading);
            q.setParameter("locations", locations);
            return (ArrayList<ReconhecerAtividadeBean>) q.list();
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        }
    }
    
    @Override
    public ReconhecerAtividadeBean selecionarAtividadePorNomeLocal(String subcategory, String locations) throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT a FROM ReconhecerAtividadeBean a where a.subcategory = :subcategory and a.locations = :locations");
            q.setParameter("subcategory", subcategory);
            q.setParameter("locations", locations);
            return (ReconhecerAtividadeBean) q.uniqueResult();
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        }
    }
    
    @Override
    public ReconhecerAtividadeBean selecionarAtividadePorNome(String atividade) throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT a FROM ReconhecerAtividadeBean a where a.subcategory = :atividade");
            q.setParameter("atividade", atividade);
            return (ReconhecerAtividadeBean) q.uniqueResult();
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        }
    }
    
}
