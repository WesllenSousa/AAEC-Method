import entidades.appliances.AppliancesBean;
import entidades.appliances.AppliancesDao;
import entidades.appliances.AppliancesDaoImpl;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DaoException;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class TesteBanco {

    public static void main(String[] args) {

        AppliancesDao dao = new AppliancesDaoImpl();

        try {
            List<AppliancesBean> lista = dao.listar();
            for(AppliancesBean aparelho : lista) {
                System.out.println("Consumo: "+aparelho.getName()+", Consumo: "+ aparelho.getConsumptionOn());
            }
        } catch (DaoException ex) {
            Logger.getLogger(TesteBanco.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
