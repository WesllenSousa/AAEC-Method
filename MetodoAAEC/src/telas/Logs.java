package telas;

import metodo.consumo.ConsumoAtividades;
import entidades.activity_data.ReconhecerAtividadeBean;
import entidades.activity_data.ReconhecerAtividadeDao;
import entidades.activity_data.ReconhecerAtividadeDaoImpl;
import entidades.appliances.AppliancesBean;
import entidades.appliances.AppliancesDao;
import entidades.appliances.AppliancesDaoImpl;
import entidades.appliances.EnumLigarDesligar;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import metodo.modeloVetorial.RelacaoAtividadeAparelhos;
import metodo.algoritmos.Algoritmos;
import metodo.modeloVetorial.ArquivoUtil;
import metodo.modeloVetorial.ModeloVetorial;
import metodo.modeloVetorial.RanqueamentoAparelhos;
import metodo.modeloVetorial.StringUtil;
import metodo.consumo.ConsumoTupla;
import util.DaoException;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class Logs extends javax.swing.JFrame {

    private final ArrayList<ConsumoTupla> consumoTupla = new ArrayList<>();

    public Logs() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo_turno = new javax.swing.ButtonGroup();
        grupo_horarioPico = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_texto = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        bt_consumo = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        bt_porAtividade = new javax.swing.JButton();
        bt_modeloVetorial = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        rd_dia = new javax.swing.JRadioButton();
        rd_noite = new javax.swing.JRadioButton();
        rd_horarioPicoNao = new javax.swing.JRadioButton();
        rd_horarioPicoSim = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ta_texto.setColumns(20);
        ta_texto.setRows(5);
        jScrollPane1.setViewportView(ta_texto);

        bt_consumo.setText("Consumo de Todas Atividades");
        bt_consumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_consumoActionPerformed(evt);
            }
        });

        jButton2.setText("Tabela do Consumo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        bt_porAtividade.setText("Uma Atividade");
        bt_porAtividade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_porAtividadeActionPerformed(evt);
            }
        });

        bt_modeloVetorial.setText("Modelo Vetorial");
        bt_modeloVetorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_modeloVetorialActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Turno:");

        grupo_turno.add(rd_dia);
        rd_dia.setSelected(true);
        rd_dia.setText("Dia");

        grupo_turno.add(rd_noite);
        rd_noite.setText("Noite");

        grupo_horarioPico.add(rd_horarioPicoNao);
        rd_horarioPicoNao.setSelected(true);
        rd_horarioPicoNao.setText("Não");

        grupo_horarioPico.add(rd_horarioPicoSim);
        rd_horarioPicoSim.setText("Sim");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Horário de Pico:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_porAtividade, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_modeloVetorial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_consumo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rd_horarioPicoSim)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rd_horarioPicoNao))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rd_dia)
                                .addGap(4, 4, 4)
                                .addComponent(rd_noite)))
                        .addGap(0, 34, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(rd_dia)
                    .addComponent(rd_noite))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rd_horarioPicoSim)
                    .addComponent(rd_horarioPicoNao)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_consumo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_porAtividade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_modeloVetorial)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
        );

        setBounds(0, 0, 895, 800);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_consumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_consumoActionPerformed
        ta_texto.setText("");
        ReconhecerAtividadeDao dao = new ReconhecerAtividadeDaoImpl();
        consumoTupla.clear();
        
        Boolean horarioPico = false;
        if (rd_horarioPicoSim.isSelected()) {
            horarioPico = true;
        } else if (rd_horarioPicoNao.isSelected()) {
            horarioPico = false;
        }
        
        Boolean dia = true;
        if (rd_dia.isSelected()) {
            dia = true;
        } else if (rd_noite.isSelected()) {
            dia = false;
        }

        try {
            //Percorrer todas as atividades
            mensagem("Iniciando...");
            for (ReconhecerAtividadeBean atividade : dao.listar()) {
                AppliancesDao d = new AppliancesDaoImpl();
                for (AppliancesBean a : d.listar()) {
                    a.setStatus(EnumLigarDesligar.LIGADO);
                    d.alterar(a);
                }

                //Obtem atividade
                RelacaoAtividadeAparelhos atividadeAparelhos = new RelacaoAtividadeAparelhos();
                atividadeAparelhos.setReconhecerAtividadeBean(atividade);

                //Obtem aparelhos relacionados
                String linha = ArquivoUtil.lerDocumentoPorAtividade(ModeloVetorial.DIRETORIO, atividade.getSubcategory());
                atividadeAparelhos.setAparelhosString(StringUtil.desmontarTextoEmPalavras(linha));

                //Faz o ranqueamento dos aparelhos        
                RanqueamentoAparelhos ranqueamento = new RanqueamentoAparelhos(atividadeAparelhos, this);
                ranqueamento.fazerRanqueamento();
                atividadeAparelhos.setRanqueamento(ranqueamento);

                //Executa algoritmos de recomendação
                Algoritmos algoritmos = new Algoritmos(this);
                algoritmos.algoritmo1_presencaUsuario(atividadeAparelhos);
                algoritmos.algoritmo2_horario(atividadeAparelhos, horarioPico, dia);
                
                //Calcula o consumo dos aparelhos relacionados
                ConsumoAtividades c = new ConsumoAtividades(this);
                atividadeAparelhos.setAparelhos(c.obtemAparelhosBanco(atividadeAparelhos.getAparelhosString()));
                Float segundos = atividadeAparelhos.getReconhecerAtividadeBean().getAverageActivity();
                atividadeAparelhos = c.calcularConsumoTotalTodasAtividades(atividadeAparelhos, segundos); 

                //Popula classe com resultado
                ConsumoTupla tuplaConsumo = new ConsumoTupla();
                tuplaConsumo = c.consumoTodosAparelhosRelacionados(atividadeAparelhos, tuplaConsumo);
                tuplaConsumo = c.consumoAparelhosLigados(atividadeAparelhos, tuplaConsumo);

                consumoTupla.add(tuplaConsumo);
            }
        } catch (DaoException ex) {
            Logger.getLogger(RanqueamentoAparelhos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bt_consumoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (consumoTupla != null) {
            TabelaConsumo dialog = new TabelaConsumo(this, true, consumoTupla);
            dialog.setVisible(true);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void bt_porAtividadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_porAtividadeActionPerformed
        UmaAtividade dialog = new UmaAtividade(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_bt_porAtividadeActionPerformed

    private void bt_modeloVetorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_modeloVetorialActionPerformed
        ArrayList<String> aparelhos = StringUtil.desmontarTextoEmPalavras("Batedeira Churrasqueira ExaustorDeCozinha FacaEletrica FogaoEletrico LampadaKitchen Liquidificador Microondas PanelaEletrica");
        ModeloVetorial modeloVetorial = new ModeloVetorial(this);
        modeloVetorial.inicar(aparelhos);
        modeloVetorial.pesquisar();
        modeloVetorial.imprimirListaInvertida();
        modeloVetorial.imprimirVetores();
        modeloVetorial.resultados();
    }//GEN-LAST:event_bt_modeloVetorialActionPerformed

    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Logs().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_consumo;
    private javax.swing.JButton bt_modeloVetorial;
    private javax.swing.JButton bt_porAtividade;
    private javax.swing.ButtonGroup grupo_horarioPico;
    private javax.swing.ButtonGroup grupo_turno;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton rd_dia;
    private javax.swing.JRadioButton rd_horarioPicoNao;
    private javax.swing.JRadioButton rd_horarioPicoSim;
    private javax.swing.JRadioButton rd_noite;
    public static javax.swing.JTextArea ta_texto;
    // End of variables declaration//GEN-END:variables

    private void mensagem(String msg) {
        Logs.ta_texto.setText(Logs.ta_texto.getText() + msg + "\n");
    }

}
