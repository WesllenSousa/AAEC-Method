/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.classes;

import org.hibernate.Query;
import util.BaseDaoImpl;
import util.Conexao;
import util.DaoException;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class ClassesDaoImpl extends BaseDaoImpl<ClassesBean> implements ClassesDao {

    public ClassesDaoImpl() {
        super(ClassesBean.class);
    }

    @Override
    public ClassesBean selecionarClassePorCode(Integer code) throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT c FROM ClassesBean c WHERE c.code = :code");
            q.setParameter("code", code);
            return (ClassesBean) q.uniqueResult();
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        }
    }

}
