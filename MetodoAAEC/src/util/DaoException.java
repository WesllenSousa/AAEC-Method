

package util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 *
 * @author Wesllen Sousa Lima
 */

public class DaoException extends Exception {

    public DaoException(String arg0) {
        super(arg0);
    }

    public DaoException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    public DaoException(Throwable arg0) {
        super(arg0);
    }
    
    private static String obterErroCompleto(Exception ex) {
        String erro = ex.toString()+"\n";
        StringWriter sw = new StringWriter();
        new Throwable("").printStackTrace(new PrintWriter(sw));
        erro += sw.toString();
        return erro;
    }

}
