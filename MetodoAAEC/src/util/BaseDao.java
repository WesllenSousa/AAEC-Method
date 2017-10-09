
package util;

import java.util.List;

/**
 *
 * @author Wesllen Sousa Lima
 */
public interface BaseDao<T> {
    public T inserir(T obj) throws DaoException;
    public T alterar(T obj) throws DaoException;
    public T selecionar(Integer id) throws DaoException;
    public Boolean excluir(T obj) throws DaoException;
    public List<T> listar() throws DaoException;
    public T insereOuAltera(T obj) throws DaoException;
}
