
package entidades.appliances;

import java.io.Serializable;

/**
 *
 * @author Wesllen Sousa Lima
 */
public enum EnumLigarDesligar implements Serializable{
    
    LIGADO(0, "Ligado"),
    DESLIGADO(1, "Desligado"),
    STANDBY(2, "Standby");
    
    private Integer ordem;
    private String descricao;
    
    private EnumLigarDesligar(Integer ordem, String descricao){
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
    
    public static EnumLigarDesligar parse(int ordem) {  
         EnumLigarDesligar enumn = null;   
         for (EnumLigarDesligar item : EnumLigarDesligar.values()) {  
             if (item.getOrdem() == ordem) {  
                 enumn = item;  
                 break;  
             }  
         }  
         return enumn;  
     }
    
}
