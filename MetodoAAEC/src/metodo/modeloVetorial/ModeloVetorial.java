package metodo.modeloVetorial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import telas.Logs;
import telas.UmaAtividade;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class ModeloVetorial {
    
    public static String DIRETORIO = "activity_appliance.txt";
    public static char SEPARADOR = '#';
    
    private ArrayList<AtividadeDoc> atividades;
    private ArrayList<String> aparelhos;
    private HashMap<String, ArrayList<HashMap<Integer, Integer>>> listaInvertida; 
    private ArrayList<Double> coordenadaConsulta;
    
    private Integer qtdeDocumentos;
    
    private Logs logs;
    private UmaAtividade umaAtividade;
    
    public ModeloVetorial() {
    }
    
    public ModeloVetorial(Logs logs) {
        this.logs = logs;
    }
    
    public ModeloVetorial(UmaAtividade umaAtividade) {
        this.umaAtividade = umaAtividade;
    }

    public void inicar(ArrayList<String> aparelhos) {
        atividades = new ArrayList<>();
        listaInvertida = new HashMap<>();
        coordenadaConsulta = new ArrayList<>();
        
        this.aparelhos = aparelhos;
        
        //Faz uma varredura para descobrir os a quantidade de documentos na base de dados
        qtdeDocumentos = ArquivoUtil.contarAtividades(DIRETORIO);
        for(int i = 1; i <= qtdeDocumentos; i++) {
            AtividadeDoc atividade = new AtividadeDoc();
            atividade.setIdentificacao(i); 
            atividade.setNome(ArquivoUtil.recuperaNomeAtividade(DIRETORIO, i)); 
            atividades.add(atividade);  
        }
        
        //Criar lista invertida vazia com todas as palavras da consulta
        for(String palavra : aparelhos) {
            ArrayList<HashMap<Integer, Integer>> listaFrequencias = new ArrayList<>();
            listaInvertida.put(palavra, listaFrequencias);
        }
    }
    
    public void pesquisar() {
        //calcula o idf
        HashMap<String, Double> idfs = new HashMap<>();
        for(String palavra : aparelhos) {
            System.out.println(palavra);
            Integer qtdeDocumentosComPalavra = 0;
            for(AtividadeDoc atividade : atividades) {
                if(StringUtil.verificarPalavraEmDocumento(atividade.getConteudo(), palavra)) {             
                    qtdeDocumentosComPalavra++;
                }
            }  
            Double idf = 0.0;
            if(qtdeDocumentosComPalavra > 0) {
                Double r = (qtdeDocumentos * 1.0) / (qtdeDocumentosComPalavra * 1.0);
                idf = Math.log(r);
            }
            idfs.put(palavra, idf);
            mensagem("- Aparelho: "+palavra+", IDF: "+idf);
        }
        
        //Formar coordenadas de Documentos
        for(AtividadeDoc documento : atividades) {
            for(String palavra : aparelhos) {
                Integer frequencia = documento.frequenciaDaPalavraNoDocumento(palavra);
                Double idf = idfs.get(palavra);
                Double coordenada = idf * frequencia; 
                documento.getVetor().add(coordenada);
                if(frequencia > 0) {
                    adicionarLista(documento.getIdentificacao(), frequencia, palavra);
                }
            }
        }
        
        //Formar coordenada da consulta
        for(String palavra : aparelhos) {
            Integer frequencia = 1;//StringUtil.contarPalavrasEmTexto(consulta, palavra);
            Double idf = idfs.get(palavra);
            Double coordenada = idf * frequencia; 
            coordenadaConsulta.add(coordenada);
        }
        
        //Calcula similaridade 
        HashMap<Integer, Double> similaridades = new HashMap<>();
        Double normaConsulta = normaConsulta(coordenadaConsulta);
        for(AtividadeDoc documento : atividades) {
            Double acumulador = acumulador(documento, coordenadaConsulta);
            Double normaDocumento = normaDocumento(documento);
            Double similaridade = 0.0;
            if(normaDocumento != 0.0 && normaConsulta != 0) {
                similaridade = acumulador / (normaDocumento * normaConsulta);
            }
            documento.setSimilaridade(similaridade);
            similaridades.put(documento.getIdentificacao(), similaridade); 
        }
        Collections.sort(atividades);
    }
     
    /*
     * M�todos auxiliares
     */
    
    private void adicionarLista(Integer documentoIdentificacao, Integer frequencia, String palavra){
        ArrayList<HashMap<Integer, Integer>> listaFrequencias = listaInvertida.get(palavra);
        HashMap<Integer, Integer> mapa = new HashMap<>();
        mapa.put(documentoIdentificacao, frequencia);
        listaFrequencias.add(mapa);   
    }

    private Double acumulador(AtividadeDoc documento, ArrayList<Double> coordenadaConsulta) {
        Double acumulador = 0.0;
        int i = 0; 
        for(String palavra : aparelhos) {
            Double r = documento.getVetor().get(i) * coordenadaConsulta.get(i);
            acumulador += r;
            i++;
        }     
        return acumulador;
    }
    
    private Double normaDocumento(AtividadeDoc documento) {
        Double normaDocumento = 0.0;
        int i = 0; 
        for(String palavra : aparelhos) {
            Double r = Math.pow(documento.getVetor().get(i), 2);
            normaDocumento += r;
            i++;
        }
        normaDocumento = Math.sqrt(normaDocumento); //tratar o 0
        return normaDocumento;
    }
    
    private Double normaConsulta(ArrayList<Double> coordenadaConsulta) {
        Double normaConsulta = 0.0;
        int i = 0;
        for(String palavra : aparelhos) {
            Double r = Math.pow(coordenadaConsulta.get(i), 2);
            normaConsulta += r;
            i++;
        }
        normaConsulta = Math.sqrt(normaConsulta);
        return normaConsulta;
    }
    
    /*
     * Impress�es
     */
    
    public void imprimirListaInvertida() {
        mensagem("-----Lista Invertida-----");
        mensagem("(¨Atividade, Quantidade de Aparelhos)");
        for(String palavra : aparelhos) {
            mensagem("Palavra: "+palavra);
            for (HashMap<Integer, Integer> mapa : listaInvertida.get(palavra)) {
                for(AtividadeDoc documento : atividades) {
                    if(mapa.get(documento.getIdentificacao()) != null) {
                        mensagem("    ("+documento.getIdentificacao()+", "+mapa.get(documento.getIdentificacao())+")");
                    }
                }
            }
        }
    }
    
    public void imprimirVetores() {
        mensagem("-----Vetores das Atividades-----");
        for(AtividadeDoc documento : atividades) {
            for(Double v : documento.getVetor()) {
                if(v > 0) {
                    mensagem("("+documento.getIdentificacao()+") "+documento.getNome()+": "+documento.getVetor().toString());
                    break;
                }
            }
        }
        mensagem("-----Vetor da consulta-----");
        mensagem("Consulta: "+coordenadaConsulta.toString());
        mensagem("-----Similaridades-----");
        for(AtividadeDoc documento : atividades) {
            if(documento.getSimilaridade() > 0) {
                mensagem("Similaridade: "+documento.getSimilaridade()+" - Atividade: "+documento.getNome());
            }
        }
    }
    
    public void resultados() {
        mensagem("-----Resultado-----");
        for(AtividadeDoc documento : atividades) {
            if(documento.getSimilaridade() != 0) {
                mensagem("(" + documento.getIdentificacao() + ") " + documento.getNome() + " -> " + documento.getSimilaridade());
            }
        }
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
        ArrayList<String> aparelhos = StringUtil.desmontarTextoEmPalavras("ClothesIron HairDryer LightBedroom Straightener");
        ModeloVetorial modeloVetorial = new ModeloVetorial();
        modeloVetorial.inicar(aparelhos);
        modeloVetorial.pesquisar();
        modeloVetorial.imprimirListaInvertida();
        modeloVetorial.imprimirVetores();
        modeloVetorial.resultados();
    }
     
}
