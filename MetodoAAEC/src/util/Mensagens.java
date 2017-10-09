
package util;

import javax.swing.JOptionPane;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class Mensagens {

    public void bug(String mensagem){
        JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);   
    }
    
    public void sucesso(String mensagem){
        JOptionPane.showMessageDialog(null, mensagem, "Sucesso", JOptionPane.WARNING_MESSAGE);
    }
    
    public void aviso(String mensagem){
        JOptionPane.showMessageDialog(null, mensagem, "Aviso", JOptionPane.WARNING_MESSAGE);
    }

    public boolean confirmacao(String mensagem){
        int conf = JOptionPane.showConfirmDialog(null, mensagem, "Confirmação",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(conf == JOptionPane.YES_OPTION){
            return true;
        }else{
            return false;
        }
    }

    public String multiplaEscolha(String mensagem, String escolha[]){
        String resp = (String)JOptionPane.showInputDialog(null,
            mensagem, "Escolha", JOptionPane.QUESTION_MESSAGE,
            null,
            escolha, escolha[0]);
        return resp;
    }

    public String inserirDados(String mensagem){
        return (String) JOptionPane.showInputDialog(null, mensagem);
    }

}
