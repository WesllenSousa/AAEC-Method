
package metodo.modeloVetorial;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class ArquivoUtil {
    
    public static ArrayList<String> lerDocumento(String diretorio) {
        ArrayList<String> documentos = new ArrayList<>();
        String documento = "";
        String linha;
        try {
            FileReader reader = new FileReader(new File(diretorio));
            BufferedReader buffer = new BufferedReader(reader);
            while((linha = buffer.readLine()) != null){
                if(linha.charAt(0) == ModeloVetorial.SEPARADOR) {
                    documentos.add(documento);
                    documento = "";
                } else {
                    documento += linha;
                }    
            }
        } catch (IOException ex) {
            System.out.println(ex);
        } 
        return documentos;
    }
    
    public static String lerDocumentoPorIdentificacao(String diretorio, Integer identificacao) {
        Integer cont = 0;
        String documento = "";
        String linha;
        try {
            FileReader reader = new FileReader(new File(diretorio));
            BufferedReader buffer = new BufferedReader(reader);
            while((linha = buffer.readLine()) != null){
                if(linha.charAt(0) == ModeloVetorial.SEPARADOR) {
                    cont++;
                } else {
                    if(cont == identificacao) {
                        documento += linha;
                    } else if(cont > identificacao) {
                        break;
                    }
                }    
            }
        } catch (IOException ex) {
            System.out.println(ex);
        } 
        return documento;
    }
    
    public static String lerDocumentoPorAtividade(String diretorio, String atividade) {
        String linha;
        try {
            FileReader reader = new FileReader(new File(diretorio)); 
            BufferedReader buffer = new BufferedReader(reader);         
            while((linha = buffer.readLine()) != null){
                if(linha.trim().equals(atividade)) {
                    return buffer.readLine();
                } 
            }
        } catch (IOException ex) {
            System.out.println(ex);
        } 
        return null;
    }
    
    public static Integer contarAtividades(String diretorio) {
        Integer cont = 0;
        String linha;
        try {
            FileReader reader = new FileReader(new File(diretorio));
            BufferedReader buffer = new BufferedReader(reader);
            while((linha = buffer.readLine()) != null){
                if(linha.charAt(0) == ModeloVetorial.SEPARADOR) {
                    cont++;
                }  
            }
        } catch (IOException ex) {
            System.out.println(ex);
        } 
        return cont;
    }
    
    public static String recuperaNomeAtividade(String diretorio, Integer i) {
        Integer cont = 0;
        String linha;
        try {
            FileReader reader = new FileReader(new File(diretorio));
            BufferedReader buffer = new BufferedReader(reader);
            while((linha = buffer.readLine()) != null){
                if(linha.charAt(0) == ModeloVetorial.SEPARADOR) {
                    cont++;
                }  
                if(cont == i){
                    return buffer.readLine();
                }
            }
        } catch (IOException ex) {
            System.out.println(ex);
        } 
        return null;
    }
    
}
