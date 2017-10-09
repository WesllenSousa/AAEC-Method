
package metodo.distanciaEuclidiana;

import entidades.activity_data.ReconhecerAtividadeBean;
import entidades.activity_data.ReconhecerAtividadeDao;
import entidades.activity_data.ReconhecerAtividadeDaoImpl;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import telas.Logs;
import telas.UmaAtividade;
import util.DaoException;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class DistanciaEuclidiana {
    
    private Logs logs;
    private UmaAtividade umaAtividade;
    
    public DistanciaEuclidiana() {
    }
    
    public DistanciaEuclidiana(Logs logs) {
        this.logs = logs;
    }
    
    public DistanciaEuclidiana(UmaAtividade umaAtividade) {
        this.umaAtividade = umaAtividade;
    }
    
    public ReconhecerAtividadeBean reconhecerAtividade(ArrayList<ReconhecerAtividadeBean> atividades, Integer distanciaAtualSensor) {
        Float menorDistancia = -1.0f;
        ReconhecerAtividadeBean atividadeReconhecida = null; 
        mensagem("Atividades: distancia "+distanciaAtualSensor);
        for(ReconhecerAtividadeBean atv : atividades) {
            Float distancia = Math.abs(distanciaAtualSensor - atv.getAverageActivity()); 
            mensagem(atv.getSubcategory() + ", Distancia atividade: "+atv.getAverageActivity()+", distancia: " + distancia);
            if(menorDistancia == -1) {
                menorDistancia = distancia; 
                atividadeReconhecida = atv;
            } else if(distancia < menorDistancia) {
                menorDistancia = distancia;
                atividadeReconhecida = atv;
            }
        }
        return atividadeReconhecida;
    }
    
    private void mensagem(String msg) {
        System.out.println(msg);
        if (logs != null) {
            Logs.ta_texto.setText(Logs.ta_texto.getText() + msg + "\n");
        } else if(umaAtividade != null) {
            UmaAtividade.ta_texto.setText(UmaAtividade.ta_texto.getText() + msg + "\n");
        }
    }
    
    public static void main(String[] args) {
        ArrayList<ReconhecerAtividadeBean> atividades = null;
        ReconhecerAtividadeDao dao = new ReconhecerAtividadeDaoImpl();
        try {
            atividades = dao.listarAtividadePorCategoriaLocal("Cooking", "Kitchen");
        } catch (DaoException ex) {
            Logger.getLogger(DistanciaEuclidiana.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        DistanciaEuclidiana d = new DistanciaEuclidiana();
        ReconhecerAtividadeBean atividade = d.reconhecerAtividade(atividades, 543);
        if(atividade != null) {
            System.out.println(">>Atividade reconhecida: "+atividade.getSubcategory()+ ", local: "+atividade.getLocations());
        }
        System.exit(0);
    }
    
}
