
package metodo.modeloVetorial;

import entidades.activity_data.ReconhecerAtividadeBean;
import entidades.appliances.AppliancesBean;
import java.util.ArrayList;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class RelacaoAtividadeAparelhos {
    
    private ReconhecerAtividadeBean reconhecerAtividadeBean;
    private ArrayList<AppliancesBean> aparelhos;
    private ArrayList<String> aparelhosString;
    private RanqueamentoAparelhos ranqueamento;
              
    public ReconhecerAtividadeBean getReconhecerAtividadeBean() {
        return reconhecerAtividadeBean;
    }

    public void setReconhecerAtividadeBean(ReconhecerAtividadeBean reconhecerAtividadeBean) {
        this.reconhecerAtividadeBean = reconhecerAtividadeBean;
    }

    public ArrayList<AppliancesBean> getAparelhos() {
        return aparelhos;
    }

    public void setAparelhos(ArrayList<AppliancesBean> aparelhos) {
        this.aparelhos = aparelhos;
    }

    public RanqueamentoAparelhos getRanqueamento() {
        return ranqueamento;
    }

    public void setRanqueamento(RanqueamentoAparelhos ranqueamento) {
        this.ranqueamento = ranqueamento;
    }

    public ArrayList<String> getAparelhosString() {
        return aparelhosString;
    }

    public void setAparelhosString(ArrayList<String> aparelhosString) {
        this.aparelhosString = aparelhosString;
    }
      
    @Override
    public String toString() {
        return reconhecerAtividadeBean.getSubcategory();
    }
    
}
