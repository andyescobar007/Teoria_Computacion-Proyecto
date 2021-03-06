/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Main.MenuPrincipal;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ANDY ESCOBAR
 */
public class JF_Convert extends javax.swing.JFrame {

    /**
     * Creates new form JF_Convert
     */
    private String[] state;
    private ArrayList<String>newEstadosDFA;
    NFA_E nfae;
    
    public JF_Convert() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        mainPanel = new javax.swing.JPanel();
        pnlAFD = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtStates = new javax.swing.JTextField();
        txtAlfabeto = new javax.swing.JTextField();
        txtEstadosFinales = new javax.swing.JTextField();
        txtEstadoInicial = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnCrearDFA = new javax.swing.JButton();
        ckLog = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        btnGenerar = new javax.swing.JButton();
        txtStatecount = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableNFA = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableDFA = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        ckbEvaluaSubString = new javax.swing.JCheckBox();
        txtDescripcion = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        mainPanel.setLayout(new java.awt.CardLayout());

        pnlAFD.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("Entradas");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setText("Q");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setText("Σ");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel4.setText("F");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel5.setText("s");

        txtStates.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtStates.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtStatesKeyReleased(evt);
            }
        });

        txtAlfabeto.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txtEstadosFinales.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txtEstadoInicial.setEditable(false);
        txtEstadoInicial.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setBackground(new java.awt.Color(255, 255, 255));
        jTable1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        btnCrearDFA.setBackground(new java.awt.Color(255, 255, 255));
        btnCrearDFA.setText("Crear DFA");
        btnCrearDFA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearDFAActionPerformed(evt);
            }
        });

        ckLog.setBackground(new java.awt.Color(255, 255, 255));
        ckLog.setText("Log");
        ckLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckLogActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(ckLog, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCrearDFA)))
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrearDFA)
                    .addComponent(ckLog))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel6.setText("Tabla de Transicion");

        btnGenerar.setBackground(new java.awt.Color(255, 255, 255));
        btnGenerar.setText("Generar");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        txtStatecount.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtStatecount.setText(" ");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new java.awt.CardLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("AFND"));

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));

        tableNFA.setBackground(new java.awt.Color(255, 255, 255));
        tableNFA.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tableNFA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tableNFA);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("AFD"));

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 255));

        tableDFA.setBackground(new java.awt.Color(255, 255, 255));
        tableDFA.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tableDFA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tableDFA);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel7.setText("Descripcion");

        ckbEvaluaSubString.setBackground(new java.awt.Color(255, 255, 255));
        ckbEvaluaSubString.setText("Evalua SubString");

        txtDescripcion.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        btnGuardar.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ckbEvaluaSubString)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(1, 1, 1)
                .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ckbEvaluaSubString)
                .addGap(18, 18, 18)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel6, "card2");

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jTable4.setBackground(new java.awt.Color(255, 255, 255));
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable4);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1056, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel7, "card3");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("X");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlAFDLayout = new javax.swing.GroupLayout(pnlAFD);
        pnlAFD.setLayout(pnlAFDLayout);
        pnlAFDLayout.setHorizontalGroup(
            pnlAFDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAFDLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnlAFDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAFDLayout.createSequentialGroup()
                        .addGroup(pnlAFDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(pnlAFDLayout.createSequentialGroup()
                                .addGroup(pnlAFDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlAFDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEstadoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlAFDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtEstadosFinales, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlAFDLayout.createSequentialGroup()
                                .addGroup(pnlAFDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlAFDLayout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAFDLayout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(9, 9, 9)))
                                .addGroup(pnlAFDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtAlfabeto, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                                    .addComponent(txtStates))))
                        .addGap(49, 49, 49)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnlAFDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlAFDLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(pnlAFDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addGroup(pnlAFDLayout.createSequentialGroup()
                                        .addGroup(pnlAFDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE))
                                        .addGap(241, 241, 241)
                                        .addComponent(txtStatecount, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAFDLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(250, 250, 250))))
                    .addGroup(pnlAFDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlAFDLayout.setVerticalGroup(
            pnlAFDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAFDLayout.createSequentialGroup()
                .addGroup(pnlAFDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAFDLayout.createSequentialGroup()
                        .addGroup(pnlAFDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlAFDLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel1))
                            .addGroup(pnlAFDLayout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(jLabel6))
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(pnlAFDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlAFDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlAFDLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(pnlAFDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(txtStates, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtStatecount))
                                .addGap(14, 14, 14)
                                .addGroup(pnlAFDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(jLabel3)
                                    .addComponent(txtAlfabeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlAFDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(jLabel4)
                                    .addComponent(txtEstadosFinales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pnlAFDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(txtEstadoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(27, 27, 27)
                                .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlAFDLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlAFDLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        mainPanel.add(pnlAFD, "card2");

        jPanel1.add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 16, 1210, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1234, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
       generarTabla();
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void txtStatesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStatesKeyReleased
        state=txtStates.getText().split(",");
        txtEstadoInicial.setText(getEstadoInicial());
    }//GEN-LAST:event_txtStatesKeyReleased

    private void btnCrearDFAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearDFAActionPerformed
        getTransiciones();
       
        nfae.getCerraduraEpsilion();
        generarLog();
        generarNFA();
        generarDFA();
               
        
    }//GEN-LAST:event_btnCrearDFAActionPerformed

    private void ckLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckLogActionPerformed
        if(ckLog.isSelected()){
            changePanel(jPanel5, jPanel7);
        }else{
            changePanel(jPanel5, jPanel6);
        }
    }//GEN-LAST:event_ckLogActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardarDFA();
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
      new MenuPrincipal().setVisible(true);
      this.dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_Convert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new JF_Convert().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearDFA;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JCheckBox ckLog;
    private javax.swing.JCheckBox ckbEvaluaSubString;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable4;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel pnlAFD;
    private javax.swing.JTable tableDFA;
    private javax.swing.JTable tableNFA;
    private javax.swing.JTextField txtAlfabeto;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtEstadoInicial;
    private javax.swing.JTextField txtEstadosFinales;
    private javax.swing.JLabel txtStatecount;
    private javax.swing.JTextField txtStates;
    // End of variables declaration//GEN-END:variables

    
     private void changePanel(JPanel parent,JPanel son){
        parent.removeAll();
        parent.add(son);
        parent.repaint();
        parent.revalidate();
    
    }
    private String[] getEstados(){
        return state;
    }
    
    private String[] getAlfabeto(){
        return ("Ɛ,"+txtAlfabeto.getText()).split(",");
    }
    private String[] getEstadosAceptacion(){
        return txtEstadosFinales.getText().split(",");
    }
    private String getEstadoInicial(){
        return getEstados()[0];
    }
    
    private void generarTabla(){
        DefaultTableModel modelo= new DefaultTableModel();
       
        modelo.addColumn("STATE");
        for (String caracter : getAlfabeto()) {
            modelo.addColumn(caracter);
        }
        Object rows[]= new Object[getAlfabeto().length+1];
        for (String estado : getEstados()) {
            modelo.addRow(new Object[]{estado});
        }      
        jTable1.setModel(modelo);
    }
    
    private ArrayList<Transicion> getTransiciones(){
        ArrayList<Transicion> transiciones=new ArrayList<>();
        int columnas=jTable1.getColumnCount();
        int filas=jTable1.getModel().getRowCount();
        for (int i = 0; i < filas; i++) {
            for (int j = 1; j < columnas; j++){
                String values[]=new String[3];
                values[0]=jTable1.getValueAt(i,0).toString();
                values[1]=jTable1.getColumnName(j);
                
                if(jTable1.getValueAt(i,j)==null || jTable1.getValueAt(i, j).toString().replaceAll(" ","").length()==0){
                    jTable1.setValueAt("ø", i, j);
                }
                values[2]=jTable1.getValueAt(i,j).toString();
                
                transiciones.add(new Transicion(values[0], values[1], values[2]));
            }
        }
        
        Transicion transitions[]= new Transicion[transiciones.size()];
        for (int i = 0; i < transiciones.size(); i++) {
            transitions[i] = transiciones.get(i);
            
        }
       nfae=new NFA_E(getEstadoInicial(), getEstadosAceptacion(), getEstados(),transitions,getAlfabeto());
       
        return transiciones;
    }
    
    private void generarLog(){
        DefaultTableModel modelo=new DefaultTableModel();
        modelo.addColumn(nfae.getCerraduraEpsilion()[0].getInput());
        
     
        for(String colum:getAlfabeto()){
            if(!colum.equals(nfae.epsilon)){
                modelo.addColumn(nfae.transicion(colum));
            }
        }
        for(String colum:getAlfabeto()){
            if(!colum.equals(nfae.epsilon)){
                modelo.addColumn(nfae.cerradura(colum));
            }
        }
        
        int columns=modelo.getColumnCount();
        Object[]row=new Object[columns];
        int cont=0;
        for (String stat: getEstados()) {
            for (int i = 0; i < columns; i++) {
              row[i]=nfae.obtenerTransicion(stat,modelo.getColumnName(i)).getNewState();
              cont++;
            }
            modelo.addRow(row);
        }
        jTable4.setModel(modelo);       
    }
    
     private void generarNFA(){
        DefaultTableModel modelo=new DefaultTableModel();
        modelo.addColumn("Estados");
        
        for(String colum:nfae.alfabeto){
            if(!colum.equals(nfae.epsilon)){
                modelo.addColumn(colum);
            }
        }
      
        int columns=modelo.getColumnCount();
        Object[]row=new Object[columns];
        
        for (String stat: getEstados()) {
            row[0]=stat;
            for (int i = 1; i < columns; i++) {
              row[i]=nfae.obtenerTransicion(stat,nfae.transicion(modelo.getColumnName(i))).getNewState();
            
            }
            modelo.addRow(row);
        }
        tableNFA.setModel(modelo);       
    }

    private void generarDFA(){
    DefaultTableModel modelo=new DefaultTableModel();
        modelo.addColumn("Estados");
        newEstadosDFA=new ArrayList<>();
        for(String colum:nfae.alfabeto){
            if(!colum.equals(nfae.epsilon)){
                modelo.addColumn(colum);
            }
        }
        for(String estado:nfae.getEstadosDFA()){
            modelo.addRow(new Object[]{estado});
        }
        for (int i = 0; i < modelo.getRowCount(); i++) {
            for (int j = 1; j < modelo.getColumnCount(); j++) {
                modelo.setValueAt(nfae.getTrasicionDFA( modelo.getValueAt(i,0).toString() ,modelo.getColumnName(j)).getNewState(), i,j);
            }
            
        }
       
       
        
        tableDFA.setModel(modelo);
    }

    private String existaNuevosEstados(JTable table) {
       
        int columnas=table.getColumnCount();
        int filas=table.getRowCount();
        for (int i = 0; i < filas; i++) {
            for (int j = 1; j < columnas; j++) {
                if(table.getValueAt(i,j)!=null){
                    
                    if(isNuevoEstado(table.getValueAt(i,j).toString())){
                        newEstadosDFA.add(table.getValueAt(i,j).toString());
                        return table.getValueAt(i,j).toString();
                    }
                }else{
                    return null;
                }
            }
        }
        return null;
    }

    private boolean isNuevoEstado(String value){
        for (String st:newEstadosDFA) {
            String tempState=st;
            if(tempState.equals(value)){
                return false;
            }else if(tempState.length()==value.length()){
                int cont=0;
                for(String s:value.split(",")){
                    if(tempState.contains(s)){
                        cont++;
                    }
                }
                System.out.println(cont);
                if(cont!=value.split(",").length){   
                    return true;
                }
            }else{
                return true;
            }
        }
        return true;
    }
    
    
    
    public void guardarDFA(){
        String temp_descripcion=txtDescripcion.getText();
        boolean temp_subString=ckbEvaluaSubString.isSelected();
        DFA dfa=nfae.getDFA();
        Manager_DFA manager_DFA=new Manager_DFA(new JsonFile("DFAs"));
        manager_DFA.addNewDFA(temp_descripcion, temp_subString,dfa);
        if(manager_DFA.findDFA(temp_descripcion)!=null){
            JOptionPane.showMessageDialog(null,"EL Automata AFD ha sido guardado exitosamente");
        }
    }
}
