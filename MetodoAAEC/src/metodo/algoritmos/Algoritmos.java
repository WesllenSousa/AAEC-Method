/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodo.algoritmos;

import entidades.activity_data.ReconhecerAtividadeBean;
import entidades.activity_data.ReconhecerAtividadeDao;
import entidades.activity_data.ReconhecerAtividadeDaoImpl;
import entidades.appliances.AppliancesBean;
import entidades.appliances.AppliancesDao;
import entidades.appliances.AppliancesDaoImpl;
import entidades.appliances.EnumLigarDesligar;
import entidades.appliances.EnumTypeAppliance;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import metodo.arvoreDecisao.ArvoreDecisao;
import metodo.modeloVetorial.RelacaoAtividadeAparelhos;
import metodo.distanciaEuclidiana.DistanciaEuclidiana;
import metodo.modeloVetorial.ArquivoUtil;
import metodo.modeloVetorial.ModeloVetorial;
import metodo.modeloVetorial.RanqueamentoAparelhos;
import metodo.modeloVetorial.StringUtil;
import telas.Logs;
import telas.UmaAtividade;
import util.DaoException;
import util.Mensagens;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class Algoritmos {

    private final AppliancesDao dao;
    private final Mensagens msg;
    private Logs logs;
    private UmaAtividade umaAtividade;

    public Algoritmos() {
        dao = new AppliancesDaoImpl();
        msg = new Mensagens();
    }
    
    public Algoritmos(Logs logs) {
        dao = new AppliancesDaoImpl();
        msg = new Mensagens();
        this.logs = logs;
    }
    
    public Algoritmos(UmaAtividade umaAtividade) {
        dao = new AppliancesDaoImpl();
        msg = new Mensagens();
        this.umaAtividade = umaAtividade;
    }

    public void algoritmo1_presencaUsuario(RelacaoAtividadeAparelhos atividadeAparelhos) throws DaoException {
        Set<String> chaves = atividadeAparelhos.getRanqueamento().getRank().keySet();
        List<AppliancesBean> aparelhos = dao.listarAparelhoTipo1e2();

        for (AppliancesBean aparelho : aparelhos) {
            //Verificar se o aparelho não estar relacionado com nenhuma atividade em execução
            Float rank = 0.0f;
            if (chaves.contains(aparelho.getName())) {
                rank = atividadeAparelhos.getRanqueamento().getRank().get(aparelho.getName());
            }
            rank = rank * 100;
            
            if (rank >= 50.0) {
                mensagem("Aparelho: "+aparelho+", Tipo: "+aparelho.getTypeAppliance().getOrdem()+", Rank: "+rank+"");
                if (aparelho.getTypeAppliance() == EnumTypeAppliance.SIM_NAOCRONOMETRADO) {
                    if (aparelho.getStatus() == EnumLigarDesligar.DESLIGADO || aparelho.getStatus() == EnumLigarDesligar.STANDBY) {
                        aparelho.setStatus(EnumLigarDesligar.LIGADO);
                        //mensagem("  Aparelho ligado.");
                    }
                } else if (aparelho.getTypeAppliance() == EnumTypeAppliance.SIM_CRONOMETRADO) {
                    if (aparelho.getStatus() == EnumLigarDesligar.DESLIGADO || aparelho.getStatus() == EnumLigarDesligar.STANDBY) {
                        aparelho.setStatus(EnumLigarDesligar.LIGADO);
                        //mensagem("  Aparelho ligado e programado para desligar em: "+aparelho.getTempoTipo2());
                        //programar horario de desligamento
                    }
                }
            } else if (rank > 0 && rank < 50) {
                mensagem("Aparelho: "+aparelho+", Tipo: "+aparelho.getTypeAppliance().getOrdem()+", Rank: "+rank+"");
                aparelho.setStatus(EnumLigarDesligar.DESLIGADO);
                //mensagem("  Relacionamento fraco: Aparelho desligado.");
                if (aparelho.getTypeAppliance() == EnumTypeAppliance.SIM_NAOCRONOMETRADO) {
//                    if(msg.confirmacao("Foi detectado relacionamento fraco do dispositivo elétrico "+aparelho+" na atividade "+atividadeAparelhos+", \n"
//                            + "Você deseja que este aparelho fica ligado?")){
//                        aparelho.setStatus(EnumLigarDesligar.LIGADO); 
//                    } else {
//                        aparelho.setStatus(EnumLigarDesligar.DESLIGADO); 
//                    }
                } else if (aparelho.getTypeAppliance() == EnumTypeAppliance.SIM_CRONOMETRADO) {
//                    if(msg.confirmacao("Foi detectado relacionamento fraco do dispositivo elétrico "+aparelho+" na atividade "+atividadeAparelhos+", \n"
//                            + "Você deseja que este aparelho fica ligado?")){
//                        aparelho.setStatus(EnumLigarDesligar.LIGADO); 
//                    } else {
//                        aparelho.setStatus(EnumLigarDesligar.DESLIGADO); 
//                    }
                }

            } else if (rank == 0) {
                //mensagem("Aparelho: "+aparelho+", Tipo: "+aparelho.getTypeAppliance().getOrdem()+", Rank: "+rank+"");
                //mensagem("  O aparelho não está relacionado com a atividade, desligado.");
                if (aparelho.getTypeAppliance() == EnumTypeAppliance.SIM_NAOCRONOMETRADO) {
                    if (aparelho.getStatus() == EnumLigarDesligar.LIGADO || aparelho.getStatus() == EnumLigarDesligar.STANDBY) {
                        aparelho.setStatus(EnumLigarDesligar.DESLIGADO);
                    }
                } else if (aparelho.getTypeAppliance() == EnumTypeAppliance.SIM_CRONOMETRADO) {
                    if (aparelho.getStatus() == EnumLigarDesligar.LIGADO || aparelho.getStatus() == EnumLigarDesligar.STANDBY) {
                        //Espera o tempo de desligadmento para desligar
                        aparelho.setStatus(EnumLigarDesligar.DESLIGADO);
                    }
                }
            }

            dao.alterar(aparelho);
        }

        //Fazer o código para identificar o término da atividade
    }

    public void algoritmo2_horario(RelacaoAtividadeAparelhos atividadeAparelhos, Boolean horarioPico, Boolean dia) throws DaoException {
        Set<String> chaves = atividadeAparelhos.getRanqueamento().getRank().keySet();
        
        List<AppliancesBean> aparelhos = dao.listarAparelhoTipo4e5();
        for (AppliancesBean aparelho : aparelhos) {
            //Verificar se o aparelho não estar relacionado com nenhuma atividade em execução
            Float rank = 0.0f;
            if (chaves.contains(aparelho.getName())) {
                rank = atividadeAparelhos.getRanqueamento().getRank().get(aparelho.getName());
            }
            rank = rank * 100;
            //mensagem("Aparelho: "+aparelho+", Tipo: "+aparelho.getTypeAppliance()+", Rank: "+rank+"");
            
            if(rank <= 30) {
                mensagem("Aparelho: "+aparelho+", Tipo: "+aparelho.getTypeAppliance().getOrdem()+", Rank: "+rank+"");
                aparelho.setStatus(EnumLigarDesligar.DESLIGADO);
                dao.alterar(aparelho);
//                    if(msg.confirmacao("Foi detectado relacionamento fraco do dispositivo elétrico "+aparelho+" na atividade "+atividadeAparelhos+", \n"
//                            + "Você deseja que este aparelho fica ligado?")){
//                        aparelho.setStatus(EnumLigarDesligar.LIGADO); 
//                    } else {
//                        aparelho.setStatus(EnumLigarDesligar.DESLIGADO); 
//                    }
            }       
            
            if (horarioPico) {
                if (aparelho.getStatus() == EnumLigarDesligar.LIGADO) {
                    //mensagem("Recomendado usar aparelho fora do horario de pico: " + aparelho);
                    aparelho.setStatus(EnumLigarDesligar.DESLIGADO); 
//                    if(msg.confirmacao("É recomendado que o "+aparelho+" seja executado fora do horário de pico, \n"
//                            + "Deseja desligar o aparelho?")){
//                        aparelho.setStatus(EnumLigarDesligar.LIGADO); 
//                    }
                    dao.alterar(aparelho);
                }
            }
        }
        aparelhos = dao.listarAparelhoTipo1e2();
        for (AppliancesBean aparelho : aparelhos) {
            if (dia) {
                //Luminaria
                if (aparelho.getName().indexOf("Lampada") > -1 && aparelho.getStatus() == EnumLigarDesligar.LIGADO) {
                    //mensagem("Apagando lampada por estar de dia: " + aparelho);
                    aparelho.setStatus(EnumLigarDesligar.DESLIGADO);
                    dao.alterar(aparelho);
                }
            }
        }
    }

    public void algoritmo3(RelacaoAtividadeAparelhos atividade) throws DaoException {
        List<AppliancesBean> aparelhos = dao.listarAparelhoTipo6();
        for (AppliancesBean aparelho : aparelhos) {
            //verificar especificacoes de fabrica dos aparelhos
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

        String local = "Kitchen";
        Integer tempoSensor = 543;

        try {
            //Ligar todos os aparelhos;
            AppliancesDao dq = new AppliancesDaoImpl();
            for (AppliancesBean a : dq.listar()) {
                a.setStatus(EnumLigarDesligar.LIGADO);
                dq.alterar(a);
            }
            
            System.out.println("Criando modelo...");
            ArvoreDecisao arvoreDecisao = new ArvoreDecisao("dados_arvore.arff");
            arvoreDecisao.lerDados();
            System.out.println("Reconhecendo categoria de atividade...");
            String categoria = arvoreDecisao.reconhecerCategoriaAtividade(2, 2, 70, 94);

            ReconhecerAtividadeDao dao = new ReconhecerAtividadeDaoImpl();
            ArrayList<ReconhecerAtividadeBean> atividades = dao.listarAtividadePorCategoriaLocal(categoria, local);

            System.out.println("Calculando a distancia euclidiana...");
            DistanciaEuclidiana d = new DistanciaEuclidiana();
            ReconhecerAtividadeBean atividadeReconhecida = d.reconhecerAtividade(atividades, tempoSensor);
            if (atividadeReconhecida != null) {
                System.out.println("Atividade reconhecida: " + atividadeReconhecida.getSubcategory() + ", local: " + atividadeReconhecida.getLocations());
            }

            RelacaoAtividadeAparelhos atividadeAparelhos = new RelacaoAtividadeAparelhos();
            atividadeAparelhos.setReconhecerAtividadeBean(atividadeReconhecida);

            String linha = ArquivoUtil.lerDocumentoPorAtividade(ModeloVetorial.DIRETORIO, atividadeReconhecida.getSubcategory());
            atividadeAparelhos.setAparelhosString(StringUtil.desmontarTextoEmPalavras(linha));

            System.out.println("Fazendo ranqueamento dos aparelhos...");
            RanqueamentoAparelhos ranqueamento = new RanqueamentoAparelhos(atividadeAparelhos);
            ranqueamento.fazerRanqueamento();
            atividadeAparelhos.setRanqueamento(ranqueamento);

            System.out.println("Aplicando no modelo vetorial...");
            ModeloVetorial modeloVetorial = new ModeloVetorial();
            modeloVetorial.inicar(ranqueamento.getAtividade().getAparelhosString());
            modeloVetorial.pesquisar();
            modeloVetorial.imprimirVetores();
            modeloVetorial.imprimirListaInvertida();
            modeloVetorial.resultados();

            System.out.println("Aplicando nos algoritmos...");
            Algoritmos algoritmos = new Algoritmos();
            algoritmos.algoritmo1_presencaUsuario(atividadeAparelhos);
            algoritmos.algoritmo2_horario(atividadeAparelhos, true, true);
            algoritmos.algoritmo3(atividadeAparelhos);

            System.out.println("Fim");
        } catch (DaoException ex) {
            Logger.getLogger(Algoritmos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Algoritmos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
