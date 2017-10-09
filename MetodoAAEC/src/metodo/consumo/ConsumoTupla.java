/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodo.consumo;

import java.util.Objects;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class ConsumoTupla {

    private String atividade;
    private String totalConsumoSemMetodoON;
    private String totalConsumoComMetodoON;
    private String totalConsumoSemMetodoSTANDBY;
    private String totalConsumoComMetodoSTANDBY;

    public String getAtividade() {
        return atividade;
    }

    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }

    public String getTotalConsumoSemMetodoON() {
        return totalConsumoSemMetodoON;
    }

    public void setTotalConsumoSemMetodoON(String totalConsumoSemMetodoON) {
        this.totalConsumoSemMetodoON = totalConsumoSemMetodoON;
    }

    public String getTotalConsumoComMetodoON() {
        return totalConsumoComMetodoON;
    }

    public void setTotalConsumoComMetodoON(String totalConsumoComMetodoON) {
        this.totalConsumoComMetodoON = totalConsumoComMetodoON;
    }

    public String getTotalConsumoSemMetodoSTANDBY() {
        return totalConsumoSemMetodoSTANDBY;
    }

    public void setTotalConsumoSemMetodoSTANDBY(String totalConsumoSemMetodoSTANDBY) {
        this.totalConsumoSemMetodoSTANDBY = totalConsumoSemMetodoSTANDBY;
    }

    public String getTotalConsumoComMetodoSTANDBY() {
        return totalConsumoComMetodoSTANDBY;
    }

    public void setTotalConsumoComMetodoSTANDBY(String totalConsumoComMetodoOSTANDBY) {
        this.totalConsumoComMetodoSTANDBY = totalConsumoComMetodoOSTANDBY;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.atividade);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ConsumoTupla other = (ConsumoTupla) obj;
        if (!Objects.equals(this.atividade, other.atividade)) {
            return false;
        }
        return true;
    }

}
