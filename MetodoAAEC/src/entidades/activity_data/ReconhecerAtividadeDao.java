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
public interface ReconhecerAtividadeDao extends BaseDao<ReconhecerAtividadeBean> {
    
    public ArrayList<ReconhecerAtividadeBean> listarAtividadePorCategoriaLocal(Integer idCategoria, Integer idLocal) throws DaoException;
    public ArrayList<ReconhecerAtividadeBean> listarAtividadePorCategoriaLocal(String heading, String locations) throws DaoException;
    public ReconhecerAtividadeBean selecionarAtividadePorNome(String atividade) throws DaoException;
    public ReconhecerAtividadeBean selecionarAtividadePorNomeLocal(String subcategory, String locations) throws DaoException;
    
}
