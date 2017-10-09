
package metodo.modeloVetorial;

import entidades.activity_data.ReconhecerAtividadeBean;
import entidades.activity_data.ReconhecerAtividadeDao;
import entidades.activity_data.ReconhecerAtividadeDaoImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import static metodo.modeloVetorial.ModeloVetorial.DIRETORIO;
import telas.Logs;
import telas.UmaAtividade;
import util.DaoException;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class RanqueamentoAparelhos {
    
    private ArrayList<AtividadeDoc> atividades; 
    private HashMap<String,Float> rank;
     
    private Integer qtdeAtividades;
    private RelacaoAtividadeAparelhos atividade;
    private Logs logs;
    private UmaAtividade umaAtividade;
    
    public RanqueamentoAparelhos(RelacaoAtividadeAparelhos atividade) {
        this.atividade = atividade;
        atividades = new ArrayList<>(); 
        rank = new HashMap<>();
    }
    
    public RanqueamentoAparelhos(RelacaoAtividadeAparelhos atividade, Logs logs) {
        this.atividade = atividade;
        atividades = new ArrayList<>(); 
        rank = new HashMap<>();
        this.logs = logs;
    }
    
    public RanqueamentoAparelhos(RelacaoAtividadeAparelhos atividade, UmaAtividade umaAtividade) {
        this.atividade = atividade;
        atividades = new ArrayList<>(); 
        rank = new HashMap<>();
        this.umaAtividade = umaAtividade;
    }
    
    public void fazerRanqueamento() {
        mensagem("Atividade: "+atividade.getReconhecerAtividadeBean().getSubcategory());
        //Faz uma varredura para descobrir os a quantidade de documentos na base de dados
        qtdeAtividades = ArquivoUtil.contarAtividades(DIRETORIO);
        for(int i = 1; i <= qtdeAtividades; i++) { 
            AtividadeDoc atvd = new AtividadeDoc();
            atvd.setIdentificacao(i);  
            atvd.setNome(ArquivoUtil.recuperaNomeAtividade(DIRETORIO, i)); 
            //System.out.println(atvd.getConteudo());
            atividades.add(atvd);
        }
        //System.out.println(atividade.getAparelhosString());
        
        //Calcular frequencia dos aparelhos
        for(String aparelho : atividade.getAparelhosString()) {
            Integer cont = 0;
            for(AtividadeDoc atividadeDoc : atividades) {
                Integer freq = atividadeDoc.frequenciaDaPalavraNoDocumento(aparelho);     
                //System.out.println(aparelho + " -> "+atividadeDoc.getNome() + " freq: "+freq);   
                if(freq > 0) {
                    cont += 1;  
                }
            }
            //mensagem("----------------------");
            Float frequencia = 0.0f;
            if(cont != 0) {
                frequencia = 1 / Float.parseFloat(cont.toString());
            } 
            mensagem("--> Aparelho: "+aparelho+", Frequência: "+frequencia);
            rank.put(aparelho, frequencia);
        }
        
        //Normalização
        Set<String> aparelhos = rank.keySet(); 
        Float maiorFrequencia = 0.0f;
        for(String aparelho : aparelhos) {
            if(rank.get(aparelho) > maiorFrequencia) { 
                maiorFrequencia = rank.get(aparelho); 
            }
        }
        System.out.println("Maior frequencia: "+maiorFrequencia);
        for(String aparelho : aparelhos) {
            Float normalizacao = rank.get(aparelho) / maiorFrequencia;
            rank.put(aparelho, normalizacao); 
        }
        imprimir();
    }

    public HashMap<String, Float> getRank() {
        return rank;
    }   

    public RelacaoAtividadeAparelhos getAtividade() {
        return atividade;
    }
      
    public void imprimir() {
        mensagem("Ranqueamento");
        Set<String> chaves = rank.keySet();
        for(String aparelho : chaves) { 
            mensagem(" "+aparelho + ": "+rank.get(aparelho)); 
        }
    }
    
    private void mensagem(String msg) {
        System.out.println(msg);
        if(logs != null) {
            Logs.ta_texto.setText(Logs.ta_texto.getText()+msg+"\n");
        } else if(umaAtividade != null) {
            UmaAtividade.ta_texto.setText(UmaAtividade.ta_texto.getText()+msg+"\n");
        }
    }
    
    public static void main(String[] args) {
        ReconhecerAtividadeDao dao = new ReconhecerAtividadeDaoImpl();
        ReconhecerAtividadeBean atividade = null;
        try {
            atividade = dao.selecionarAtividadePorNome("Doinglaundry");
        } catch (DaoException ex) {
            Logger.getLogger(RanqueamentoAparelhos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(atividade != null) {
            RelacaoAtividadeAparelhos atividadeAparelhos = new RelacaoAtividadeAparelhos();
            atividadeAparelhos.setReconhecerAtividadeBean(atividade);

            String linha = ArquivoUtil.lerDocumentoPorAtividade(ModeloVetorial.DIRETORIO, atividade.getSubcategory());
            atividadeAparelhos.setAparelhosString(StringUtil.desmontarTextoEmPalavras(linha));

            RanqueamentoAparelhos r = new RanqueamentoAparelhos(atividadeAparelhos);
            r.fazerRanqueamento();

            atividadeAparelhos.setRanqueamento(r); 
        }
        
        System.out.println("Fim!!");
    }
    
}
