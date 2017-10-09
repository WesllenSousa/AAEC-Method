package metodo.consumo;

import entidades.activity_data.ReconhecerAtividadeBean;
import entidades.activity_data.ReconhecerAtividadeDao;
import entidades.activity_data.ReconhecerAtividadeDaoImpl;
import entidades.appliances.AppliancesBean;
import entidades.appliances.AppliancesDao;
import entidades.appliances.AppliancesDaoImpl;
import entidades.appliances.EnumLigarDesligar;
import java.util.ArrayList;
import metodo.modeloVetorial.RelacaoAtividadeAparelhos;
import metodo.algoritmos.Algoritmos;
import metodo.modeloVetorial.ArquivoUtil;
import metodo.modeloVetorial.ModeloVetorial;
import metodo.modeloVetorial.RanqueamentoAparelhos;
import metodo.modeloVetorial.StringUtil;
import telas.Logs;
import telas.UmaAtividade;
import util.DaoException;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class MontaTuplaConsumoAtividades {

    private Logs logs;
    private UmaAtividade telaUmaAtividade;

    public MontaTuplaConsumoAtividades() {

    }

    public MontaTuplaConsumoAtividades(Logs logs) {
        this.logs = logs;
    }

    public MontaTuplaConsumoAtividades(UmaAtividade umaAtividade) {
        this.telaUmaAtividade = umaAtividade;
    }

    public ArrayList<ConsumoTupla> umaAtividade(String atividade, String local, Integer minutos, Boolean horarioPico, Boolean dia) {
        ArrayList<ConsumoTupla> tabelaConsumo = new ArrayList<>();

        try {
            ReconhecerAtividadeDao dao = new ReconhecerAtividadeDaoImpl();

            //Ligar todos os aparelhos;
            AppliancesDao d = new AppliancesDaoImpl();
            for (AppliancesBean a : d.listar()) {
                a.setStatus(EnumLigarDesligar.LIGADO);
                d.alterar(a);
            }

            //Obtem atividade
            RelacaoAtividadeAparelhos a1 = new RelacaoAtividadeAparelhos();
            ReconhecerAtividadeBean reconhecerAtividade = dao.selecionarAtividadePorNomeLocal(atividade, local);
            a1.setReconhecerAtividadeBean(reconhecerAtividade);

            //Obtem aparelhos relacionados
            String linha = ArquivoUtil.lerDocumentoPorAtividade(ModeloVetorial.DIRETORIO, a1.getReconhecerAtividadeBean().getSubcategory());
            a1.setAparelhosString(StringUtil.desmontarTextoEmPalavras(linha));

            //Faz o ranqueamento dos aparelhos
            RanqueamentoAparelhos r1 = new RanqueamentoAparelhos(a1, telaUmaAtividade);
            r1.fazerRanqueamento();
            a1.setRanqueamento(r1);

            //Executa algoritmos de recomendação
            Algoritmos ag1 = new Algoritmos(telaUmaAtividade);
            ag1.algoritmo1_presencaUsuario(a1);
            ag1.algoritmo2_horario(a1, horarioPico, dia);

            //Calcula o consumo total dos aparelhos relacionados
            ConsumoAtividades c1 = new ConsumoAtividades(null);
            a1.setAparelhos(c1.obtemAparelhosBanco(a1.getAparelhosString()));
            Float segundos = minutos * 60.0f;
            a1 = c1.calcularConsumoTotalTodasAtividades(a1, segundos);

            //Popula classe com resultado
            ConsumoTupla ct1 = new ConsumoTupla();
            ct1 = c1.consumoTodosAparelhosRelacionados(a1, ct1);
            ct1 = c1.consumoAparelhosLigados(a1, ct1);
            tabelaConsumo.add(ct1);

            mensagem("Consumo sem método AAEC: "+ct1.getTotalConsumoSemMetodoON() + 
                    "\n Watts - Consumo com método AAEC: " + ct1.getTotalConsumoComMetodoON() + " Watts");

            return tabelaConsumo;

        } catch (DaoException ex) {
        }
        return null;
    }

    private void mensagem(String msg) {
        System.out.println(msg);
        if (logs != null) {
            Logs.ta_texto.setText(Logs.ta_texto.getText() + msg + "\n");
        } else if (telaUmaAtividade != null) {
            UmaAtividade.ta_texto.setText(UmaAtividade.ta_texto.getText() + msg + "\n");
        }
    }

    public static void main(String[] args) {
        MontaTuplaConsumoAtividades t = new MontaTuplaConsumoAtividades();
        ArrayList<ConsumoTupla> tupla = t.umaAtividade(
                "Doinglaundry",
                "Kitchen",
                30,
                true,
                false);
        System.out.println(tupla);
    }

}
