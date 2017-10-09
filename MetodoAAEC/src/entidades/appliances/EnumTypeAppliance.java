
package entidades.appliances;

import java.io.Serializable;

/**
 *
 * @author Wesllen Sousa Lima
 */
public enum EnumTypeAppliance implements Serializable{
    
    SOLUCAO_ERRO_HIBERNATE(0, "SOLUCAO_ERRO_HIBERNATE"),
    SIM_NAOCRONOMETRADO(1, "SIM_NAOCRONOMETRADO"),
    SIM_CRONOMETRADO(2, "SIM_CRONOMETRADO"),
    SIM_INSTANTANEOS(3, "SIM_INSTANTANEOS"),
    NAO_CRONOMETRADO(4, "NAO_CRONOMETRADO"),
    NAO_NAOCRONOMETRADO(5, "NAO_NAOCRONOMETRADO"),
    CONTINUO(6, "CONTINUO");
    
    private Integer ordem;
    private String descricao;
    
    private EnumTypeAppliance(Integer ordem, String descricao){
        this.ordem = ordem;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getOrdem() {
        return ordem;
    }

    public void setOrdem(Integer ordem) {
        this.ordem = ordem;
    }
    
    @Override
    public String toString() {
        return this.descricao;
    }
    
    public static EnumTypeAppliance parse(int ordem) {  
         EnumTypeAppliance enumn = null;   
         for (EnumTypeAppliance item : EnumTypeAppliance.values()) {  
             if (item.getOrdem() == ordem) {  
                 enumn = item;  
                 break;  
             }  
         }  
         return enumn;  
     }
    
}
