/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodo.consumo;

import entidades.appliances.AppliancesBean;
import entidades.appliances.AppliancesDao;
import entidades.appliances.AppliancesDaoImpl;
import entidades.appliances.EnumLigarDesligar;
import entidades.appliances.EnumTypeAppliance;
import java.util.ArrayList;
import metodo.modeloVetorial.RelacaoAtividadeAparelhos;
import telas.Logs;
import util.DaoException;
import util.NumeroUtil;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class ConsumoAtividades {

    private final Logs logs;
    private final Float TAXA = 0.27f;

    public ConsumoAtividades(Logs logs) {
        this.logs = logs;
    }

    public RelacaoAtividadeAparelhos calcularConsumoTotalTodasAtividades(RelacaoAtividadeAparelhos atividadeAparelhos, Float segundos) throws DaoException {
        for (AppliancesBean aparelho : atividadeAparelhos.getAparelhos()) {
            if (aparelho.getTypeAppliance() == EnumTypeAppliance.SIM_CRONOMETRADO) {
                segundos = aparelho.getTempoTipo2() * 60f;
            }

            Float wh_on = aparelho.getConsumptionOn() * (segundos / 3600);
            Float wh_standby = aparelho.getConsumptionStandby() * (segundos / 3600);
            Float kwh_on = wh_on / 1000;
            Float kwh_standby = wh_standby / 1000;

            aparelho.setConsumo_on(wh_on);
            aparelho.setConsumo_standby(wh_standby);
        }

        return atividadeAparelhos;
    }

    public ConsumoTupla consumoTodosAparelhosRelacionados(RelacaoAtividadeAparelhos atividadeAparelhos, ConsumoTupla consumo) {
        mensagem("--------------------------------Processamento SEM o métodod AAEC-----------------------------------");
        mensagem("Atividade: (" + atividadeAparelhos.getReconhecerAtividadeBean().getId() + ") " + atividadeAparelhos.getReconhecerAtividadeBean().getSubcategory()
                + ", Local: " + atividadeAparelhos.getReconhecerAtividadeBean().getLocations() + ", tempo: " + atividadeAparelhos.getReconhecerAtividadeBean().getAverageActivity());
        mensagem("-");

        Float total_on = 0.0f, total_standby = 0.0f;
        for (AppliancesBean aparelho : atividadeAparelhos.getAparelhos()) {      
            total_on += aparelho.getConsumo_on();
            total_standby += aparelho.getConsumo_standby();
            
            mensagem("(" + aparelho.getId() + ") Aparelho: " + aparelho.getName() + ", Modelo: " + aparelho.getModel());
            mensagem("  Consumo (kWh): ON = " + aparelho.getConsumo_on() + " kWh, STANDBY: " + aparelho.getConsumo_standby() + " kWh");
        }
        mensagem(" -- Total: ON: " + total_on + " kWh = " + (TAXA * total_on) + "$, STANDBY: " + total_standby + " kWh = " + (TAXA * total_standby) + "$");

        if (consumo != null) {
            consumo.setAtividade(atividadeAparelhos.getReconhecerAtividadeBean().getSubcategory());
            consumo.setTotalConsumoSemMetodoON(NumeroUtil.formataDecimal2Casas(total_on));
            consumo.setTotalConsumoSemMetodoSTANDBY(NumeroUtil.formataDecimal2Casas(total_standby));
        }
        return consumo;
    }

    public ConsumoTupla consumoAparelhosLigados(RelacaoAtividadeAparelhos atividadeAparelhos, ConsumoTupla consumo) {
        mensagem("-----------------------------Processamento COM o método AAEC---------------------------------");
        mensagem("Atividade: (" + atividadeAparelhos.getReconhecerAtividadeBean().getId() + ") " + atividadeAparelhos.getReconhecerAtividadeBean().getSubcategory()
                + ", Local: " + atividadeAparelhos.getReconhecerAtividadeBean().getLocations() + ", tempo: " + atividadeAparelhos.getReconhecerAtividadeBean().getAverageActivity());
        mensagem("-");

        Float total_on = 0.0f, total_standby = 0.0f;
        for (AppliancesBean aparelho : atividadeAparelhos.getAparelhos()) {
            try {
                AppliancesDao dao = new AppliancesDaoImpl();
                AppliancesBean a = dao.selecionar(aparelho.getId());

                if (a.getStatus() == EnumLigarDesligar.LIGADO) {
                    total_on += aparelho.getConsumo_on();
                    total_standby += aparelho.getConsumo_standby();
                    mensagem("(" + aparelho.getId() + ") Aparelho: " + aparelho.getName() + ", Modelo: " + aparelho.getModel());
                    mensagem("  -- Consumo ON: = " + aparelho.getConsumo_on() + " kWh, STANDBY: " + aparelho.getConsumo_standby() + " kWh");
                }
            } catch (DaoException ex) {
            }
        }
        mensagem(" -- Total: ON: " + total_on + " kWh = " + (TAXA * total_on) + "$, STANDBY: " + total_standby + " kWh = " + (TAXA * total_standby) + "$");

        if (consumo != null) {
            consumo.setTotalConsumoComMetodoON(NumeroUtil.formataDecimal2Casas(total_on));
            consumo.setTotalConsumoComMetodoSTANDBY(NumeroUtil.formataDecimal2Casas(total_standby));
        }
        return consumo;
    }

    public ArrayList<AppliancesBean> obtemAparelhosBanco(ArrayList<String> aparelhosString) {
        //Buscar aparelhos relacionados aquela atividade       
        ArrayList<AppliancesBean> aparelhos = new ArrayList<>();
        AppliancesDao dao1 = new AppliancesDaoImpl();
        for (String a : aparelhosString) {
            AppliancesBean aparelho;
            try {
                aparelho = dao1.selecionarAparelhoPorNome(a);
                aparelhos.add(aparelho);
            } catch (DaoException ex) {
            }
        }
        return aparelhos;
    }

    private void mensagem(String msg) {
        System.out.println(msg);
        if (logs != null) {
            Logs.ta_texto.setText(Logs.ta_texto.getText() + msg + "\n");
        }
    }

}
