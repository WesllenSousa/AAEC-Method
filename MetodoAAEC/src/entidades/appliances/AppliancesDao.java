/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades.appliances;

import java.util.ArrayList;
import util.BaseDao;
import util.DaoException;

/**
 *
 * @author Wesllen Sousa Lima
 */
public interface AppliancesDao extends BaseDao<AppliancesBean> {
    
    public AppliancesBean selecionarAparelhoPorNome(String name) throws DaoException;
    public ArrayList<AppliancesBean> listarAparelhoTipo1e2() throws DaoException;
    public ArrayList<AppliancesBean> listarAparelhoTipo4e5() throws DaoException;
    public ArrayList<AppliancesBean> listarAparelhoTipo6() throws DaoException;
    
}     
