
import entidades.activity_data.ActivityDataBean;
import entidades.activity_data.ActivityDataDao;
import entidades.activity_data.ActivityDataDaoImpl;
import java.util.List;
import util.DaoException;


/**
 *
 * @author Wesllen Sousa Lima
 */
public class ConsumoAtividadeSubject1 {
    
    public static void main(String[] args) {
        ConsumoAtividadeSubject1 c = new ConsumoAtividadeSubject1();
        c.calcularConsumo();
    }
    
    public void calcularConsumo() {
        Integer cont = 0;
        for(ActivityDataBean atividade : listarAtividades()) {
            Integer intervalo = atividade.getEndTime() - atividade.getStartTime();
            
            cont++;
        }
        System.out.println(cont);
    }
    
    private List<ActivityDataBean> listarAtividades() {
        ActivityDataDao dao = new ActivityDataDaoImpl();
        try {
            return dao.listarAtividadeOrdenadaPorDia();
        } catch (DaoException ex) {
        }
        return null;
    }
    
}
