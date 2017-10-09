package telas;

import entidades.classes.ClassesBean;
import entidades.classes.ClassesDao;
import entidades.classes.ClassesDaoImpl;
import entidades.locations.LocationsBean;
import entidades.locations.LocationsDao;
import entidades.locations.LocationsDaoImpl;
import java.util.ArrayList;
import metodo.consumo.ConsumoTupla;
import metodo.consumo.MontaTuplaConsumoAtividades;
import util.DaoException;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class UmaAtividade extends javax.swing.JDialog {

    private ArrayList<ConsumoTupla> consumoTuplas = new ArrayList<>();

    public UmaAtividade(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        preencherAtividades();
        preencherLocais();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tf_minutos = new javax.swing.JTextField();
        rd_dia = new javax.swing.JRadioButton();
        rd_noite = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        rd_sim = new javax.swing.JRadioButton();
        rd_nao = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_texto = new javax.swing.JTextArea();
        bt_calcular = new javax.swing.JButton();
        bt_tabela = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cb_atividade = new javax.swing.JComboBox();
        cb_local = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Atividade:");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("minutos:");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Turno:");

        buttonGroup1.add(rd_dia);
        rd_dia.setSelected(true);
        rd_dia.setText("Dia");

        buttonGroup1.add(rd_noite);
        rd_noite.setText("Noite");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Horário de Pico:");

        buttonGroup2.add(rd_sim);
        rd_sim.setText("Sim");

        buttonGroup2.add(rd_nao);
        rd_nao.setSelected(true);
        rd_nao.setText("Não");

        ta_texto.setColumns(20);
        ta_texto.setRows(5);
        jScrollPane1.setViewportView(ta_texto);

        bt_calcular.setText("Calcular Consumo");
        bt_calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_calcularActionPerformed(evt);
            }
        });

        bt_tabela.setText("Ver Tabela");
        bt_tabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_tabelaActionPerformed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Local:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(bt_calcular, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_tabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_minutos)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rd_dia)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rd_noite))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rd_sim)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rd_nao)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cb_atividade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_local, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cb_atividade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cb_local, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tf_minutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(rd_dia)
                    .addComponent(rd_noite))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rd_sim)
                    .addComponent(rd_nao)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_calcular)
                    .addComponent(bt_tabela))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_calcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_calcularActionPerformed
        ta_texto.setText("");

        Boolean dia = true;
        if (rd_dia.isSelected()) {
            dia = true;
        } else if (rd_noite.isSelected()) {
            dia = false;
        }

        Boolean hPico = false;
        if (rd_sim.isSelected()) {
            hPico = true;
        } else if (rd_nao.isSelected()) {
            hPico = false;
        }

        MontaTuplaConsumoAtividades t = new MontaTuplaConsumoAtividades(this);
        consumoTuplas = t.umaAtividade(
                cb_atividade.getSelectedItem().toString(),
                cb_local.getSelectedItem().toString(),
                Integer.parseInt(tf_minutos.getText().trim()),
                hPico,
                dia);
    }//GEN-LAST:event_bt_calcularActionPerformed

    private void bt_tabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_tabelaActionPerformed
        if (consumoTuplas != null) {
            TabelaConsumo dialog = new TabelaConsumo(null, true, consumoTuplas);
            dialog.setVisible(true);
        }
    }//GEN-LAST:event_bt_tabelaActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                UmaAtividade dialog = new UmaAtividade(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_calcular;
    private javax.swing.JButton bt_tabela;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox cb_atividade;
    private javax.swing.JComboBox cb_local;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rd_dia;
    private javax.swing.JRadioButton rd_nao;
    private javax.swing.JRadioButton rd_noite;
    private javax.swing.JRadioButton rd_sim;
    public static javax.swing.JTextArea ta_texto;
    private javax.swing.JTextField tf_minutos;
    // End of variables declaration//GEN-END:variables

    private void preencherAtividades() {
        for (ClassesBean bean : listarClasses()) {
            cb_atividade.addItem(bean);
        }
    }

    private void preencherLocais() {
        for (LocationsBean bean : listarLocais()) {
            cb_local.addItem(bean);
        }
    }

    private ArrayList<ClassesBean> listarClasses() {
        ClassesDao dao = new ClassesDaoImpl();
        try {
            return (ArrayList<ClassesBean>) dao.listar();
        } catch (DaoException ex) {
        }
        return null;
    }

    private ArrayList<LocationsBean> listarLocais() {
        LocationsDao dao = new LocationsDaoImpl();
        try {
            return (ArrayList<LocationsBean>) dao.listar();
        } catch (DaoException ex) {
        }
        return null;
    }

}
