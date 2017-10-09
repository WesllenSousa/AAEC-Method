
package telas.tabelas;

import metodo.consumo.ConsumoTupla;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Wesllen Sousa Lima      
 */
public class ConsumoTableModel extends AbstractTableModel {

    private ArrayList linhas = null;
    private String[] colunas = {"CODE","ATIVIDADE", "Consumo-W", "Consumo-W-AAEC", "Consumo-W-STANDBY", "Consumo-W-STANDBY-AAEC"};

    public ConsumoTableModel(ArrayList<ConsumoTupla> dados) {
        setLinhas(dados);
    }

    public String[] getColunas() {
        return colunas;
    }

    public ArrayList<ConsumoTupla> getLinhas() {
        return linhas;
    }

    public void setColunas(String[] strings) {
        colunas = strings;
    }

    private void setLinhas(ArrayList<ConsumoTupla> list) {
        linhas = list;
    }

    //Retorna o numero de colunas no modelo
    //@see javax.swing.table.TableModel#getColumnCount()
    @Override
    public int getColumnCount() {
        return getColunas().length;
    }

    //Retorna o numero de linhas existentes no modelo
    //@see javax.swing.table.TableModel#getRowCount()
    @Override
    public int getRowCount() {
        return getLinhas().size();
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ConsumoTupla bean = (ConsumoTupla) linhas.get(rowIndex);
        if (columnIndex != -1) {
            switch (columnIndex) {
                case 0:
                    return (rowIndex+1);
                case 1:
                    return bean.getAtividade();
                case 2:
                    return bean.getTotalConsumoSemMetodoON();
                case 3:
                    return bean.getTotalConsumoComMetodoON();
                case 4:
                    return bean.getTotalConsumoSemMetodoSTANDBY();
                case 5:
                    return bean.getTotalConsumoComMetodoSTANDBY();
            }
        } else if (columnIndex == -1) {
            return bean;
        }
        return null;
    }
    
}
