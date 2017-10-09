
package metodo.modeloVetorial;

import java.util.ArrayList;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class StringUtil {
    
    public static ArrayList<String> desmontarTextoEmPalavras(String texto) {
        ArrayList<String> palavras = new ArrayList<>();
        String p = "";
        for(int i = 0; i < texto.length(); i++) {
            if(texto.charAt(i) != ' ') {
                p += texto.charAt(i);
            } else {
                palavras.add(p);
                p = "";
            }
        }
        if(!p.equals("")) {
            palavras.add(p);
        }
        return palavras;
    }
    
    public static Boolean verificarPalavraEmDocumento(String conteudo, String palavra) {
        String p = ""; 
        for(int i = 0; i < conteudo.length(); i++) {
            if(conteudo.charAt(i) != ' ') {
                p += conteudo.charAt(i);
            } else {
                if(p.equals(palavra)) {
                    return true;
                }
                p = "";
            }
        }
        if(p.equals(palavra) || p.equals(palavra+"\n")) {
            return true;
        }
        return false;
    }
    
    public static Integer contarPalavrasEmTexto(String documento, String termo) {
        Integer qtdeDocumentosComPalavra = 0;
        String p = "";
        for(int i = 0; i < documento.length(); i++) {
            if(documento.charAt(i) != ' ') {
                p += documento.charAt(i);
            } else {
                if(p.equals(termo)) {
                    qtdeDocumentosComPalavra++;
                }
                p = "";
            }
        }
        if(p.equals(termo) || p.equals(termo+"\n")) {
            qtdeDocumentosComPalavra++;
        }
        return qtdeDocumentosComPalavra;
    }
    
}
