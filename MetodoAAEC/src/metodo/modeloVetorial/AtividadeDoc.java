
package metodo.modeloVetorial;

import java.util.ArrayList;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class AtividadeDoc implements Comparable<AtividadeDoc> {
    
    private Integer identificacao;
    private String nome;
    private ArrayList<Double> vetor = new ArrayList<>();
    private Double similaridade;
    
    public String getConteudo() {
        return ArquivoUtil.lerDocumentoPorIdentificacao(ModeloVetorial.DIRETORIO, identificacao);
    }
    
    public Integer frequenciaDaPalavraNoDocumento(String palavra) {
        return StringUtil.contarPalavrasEmTexto(getConteudo(), palavra);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Integer getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(Integer identificacao) {
        this.identificacao = identificacao;
    }

    public ArrayList<Double> getVetor() {
        return vetor;
    }

    public void setVetor(ArrayList<Double> vetor) {
        this.vetor = vetor;
    }

    public Double getSimilaridade() {
        return similaridade;
    }

    public void setSimilaridade(Double similaridade) {
        this.similaridade = similaridade;
    }
    
    @Override
    public String toString() {
        return getConteudo();
    }

    @Override
    public int compareTo(AtividadeDoc o) {
        if(getSimilaridade() > o.getSimilaridade()) {
            return -1;
        } else if(getSimilaridade() < o.getSimilaridade()) {
            return 1;
        } else {
            return 0;
        }
    }
    
}
