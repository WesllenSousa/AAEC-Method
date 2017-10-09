package util;

import java.util.List;
import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Wesllen Sousa Lima
 */

public class BaseDaoImpl<T> implements BaseDao<T> {

    protected Session session = null;
    private Class classe = null;

    public BaseDaoImpl(Class classe) {
        this.classe = classe;
    }

    @Override
    public T inserir(T obj) throws DaoException {
        Transaction transaction = null;
        try {
            this.session = Conexao.getSession();
            transaction = this.session.beginTransaction();
            this.session.save(obj);//insert do Hibernate
            transaction.commit();
            return obj;
        } catch (Exception e) {
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (HibernateException h) {
                    System.out.println(h.getMessage());
                }
            }
            throw new DaoException(e);
        } finally {
            if (this.session != null) {
                try {
                    Conexao.closeSession();
                } catch (HibernateException h) {
                    System.out.println(h.getMessage());
                }
            }
        }
    }

    @Override
    public T alterar(T obj) throws DaoException {
        Transaction transaction = null;
        try {
            this.session = Conexao.getSession();
            transaction = this.session.beginTransaction();
            this.session.update(obj);
            transaction.commit();
            return obj;
        } catch (Exception e) {
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (HibernateException h) {
                    System.out.println(h.getMessage());
                }
            }
            throw new DaoException(e);
        } finally {
            if (this.session != null) {
                try {
                    Conexao.closeSession();
                } catch (HibernateException h) {
                    System.out.println(h.getMessage());
                }
            }
        }
    }

    @Override
    public Boolean excluir(T obj) throws DaoException {
        Transaction transaction = null;
        try {
            this.session = Conexao.getSession();
            transaction = this.session.beginTransaction();
            this.session.delete(obj);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (HibernateException h) {
                    System.out.println(h.getMessage());
                }
            }
            throw new DaoException(e);
        } finally {
            if (this.session != null) {
                try {
                    Conexao.closeSession();
                } catch (HibernateException h) {
                    System.out.println(h.getMessage());
                }
            }
        }
    }

    @Override
    public List<T> listar() throws DaoException {
        try {
            this.session = Conexao.getSession();
            List objs = this.session.createQuery("from " + classe.getName()).list();
            return objs;
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            if (this.session != null) {
                try {
                    Conexao.closeSession();
                } catch (HibernateException h) {
                    System.out.println(h.getMessage());
                }
            }
        }
    }

    //Fechar a conexão na camada de visualização
    //depois que consumir todos os recursos do objeto;
    @Override
    public T selecionar(Integer pk) throws DaoException {        
        try {
            this.session = Conexao.getSession();            
            Object obj = this.session.load(classe, pk);            
            return (T) obj;
        } catch (Exception e) {   
            throw new DaoException(e);
        } 
    }

    @Override
    public T insereOuAltera(T obj) throws DaoException {
        Transaction transaction = null;
        try {
            this.session = Conexao.getSession();
            transaction = this.session.beginTransaction();
            this.session.saveOrUpdate(obj);//insert do Hibernate
            transaction.commit();
            return obj;
        } catch (Exception e) {
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (HibernateException h) {
                    System.out.println(h.getMessage());
                }
            }
            System.out.println(e);
            throw new DaoException(e);
        } finally {
            if (this.session != null) {
                try {
                    Conexao.closeSession();
                } catch (HibernateException h) {
                    System.out.println(h.getMessage());
                }
            }
        }
    }
    
}
