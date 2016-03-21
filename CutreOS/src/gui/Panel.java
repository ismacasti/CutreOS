/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package gui;

import cutreos.CutreOS;
import java.io.File;
import java.io.IOException;
import static java.util.Collections.list;
import java.util.LinkedList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;



/**
 *
 * @author Beto Garcia
 */
public class Panel extends javax.swing.JFrame {

    final JFileChooser fc = new JFileChooser();

    /**
     * Creates new form Panel
     */
    
    private CutreOS kernel;
    public Panel() {
        kernel = new CutreOS();
        initComponents();
    }

    
    private void updateData(){
        cutreos.Process running = kernel.getRunning();
        actualTime.setText(Integer.toString(kernel.getTime()));
        if(running == null){
            JOptionPane.showMessageDialog(Panel.this, "no running procceses.");
        }else{
           ActualTimeNameText.setText(running.getName());
           ActualTimeArriveText.setText(Integer.toString(running.getArriveTime()));
           ActualTimeAssignedCPUText.setText(Integer.toString(running.getRunning_time()));
           ActualTimeAgingText.setText("not implemented.");
           ActualTimeRemainingCPUText.setText(Integer.toString(running.getExpected_runtime()-running.getRunning_time()));
           ActualTimeRemainingQuantumText.setText("0");
        }

           
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        leftPanel = new javax.swing.JPanel();
        timePanel = new javax.swing.JPanel();
        AddFileButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        actualTime = new java.awt.TextField();
        currentProcessPanel = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        ActualTimeNameText = new javax.swing.JTextField();
        label2 = new java.awt.Label();
        ActualTimeArriveText = new javax.swing.JTextField();
        label3 = new java.awt.Label();
        ActualTimeAssignedCPUText = new javax.swing.JTextField();
        label4 = new java.awt.Label();
        ActualTimeAgingText = new javax.swing.JTextField();
        label6 = new java.awt.Label();
        ActualTimeRemainingCPUText = new javax.swing.JTextField();
        label7 = new java.awt.Label();
        ActualTimeRemainingQuantumText = new javax.swing.JTextField();
        pageExecuteChoice = new java.awt.Choice();
        tickButton = new javax.swing.JButton();
        centerPanel = new javax.swing.JPanel();
        pagesPanel = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        ActualProcessTable = new javax.swing.JTable();
        interruptPanel = new javax.swing.JPanel();
        interruptionChoice = new java.awt.Choice();
        interruptButton = new javax.swing.JButton();
        rightPanel = new javax.swing.JPanel();
        schedAlgoPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        CPUchangeAlgorithmButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        Spinner = new javax.swing.JSpinner();
        memAlgoPanel = new javax.swing.JPanel();
        MemorybitsResetNURButton = new javax.swing.JButton();
        MemorychangeAlgorithmButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        createProcessPanel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        NewProcessCreateButton = new javax.swing.JButton();
        newProcessNameText = new javax.swing.JTextField();
        newProcessPagesText = new javax.swing.JSpinner();
        newProcessTotalExecutionButton = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("OS Simulator™ CutreOS© · I ❤ OS");
        setBackground(new java.awt.Color(51, 51, 255));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        leftPanel.setName("Current process"); // NOI18N
        leftPanel.setRequestFocusEnabled(false);
        leftPanel.setLayout(new javax.swing.BoxLayout(leftPanel, javax.swing.BoxLayout.Y_AXIS));

        timePanel.setMinimumSize(null);
        timePanel.setPreferredSize(null);
        timePanel.setLayout(new java.awt.GridBagLayout());

        AddFileButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        AddFileButton.setText("Add File");
        AddFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddFileButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        timePanel.add(AddFileButton, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel1.setText("Actual Time");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        timePanel.add(jLabel1, gridBagConstraints);

        actualTime.setText("0");
        actualTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualTimeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        timePanel.add(actualTime, gridBagConstraints);

        leftPanel.add(timePanel);

        currentProcessPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Current process"));
        currentProcessPanel.setLayout(new java.awt.GridBagLayout());

        label1.setText("Name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        currentProcessPanel.add(label1, gridBagConstraints);

        ActualTimeNameText.setText("0");
        ActualTimeNameText.setPreferredSize(new java.awt.Dimension(40, 19));
        ActualTimeNameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualTimeNameTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        currentProcessPanel.add(ActualTimeNameText, gridBagConstraints);

        label2.setText("Arrive:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        currentProcessPanel.add(label2, gridBagConstraints);

        ActualTimeArriveText.setText("0");
        ActualTimeArriveText.setPreferredSize(new java.awt.Dimension(40, 19));
        ActualTimeArriveText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualTimeArriveTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        currentProcessPanel.add(ActualTimeArriveText, gridBagConstraints);

        label3.setText("Assigned CPU:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        currentProcessPanel.add(label3, gridBagConstraints);

        ActualTimeAssignedCPUText.setText("0");
        ActualTimeAssignedCPUText.setPreferredSize(new java.awt.Dimension(40, 19));
        ActualTimeAssignedCPUText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualTimeAssignedCPUTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        currentProcessPanel.add(ActualTimeAssignedCPUText, gridBagConstraints);

        label4.setText("Aging:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        currentProcessPanel.add(label4, gridBagConstraints);

        ActualTimeAgingText.setText("0");
        ActualTimeAgingText.setPreferredSize(new java.awt.Dimension(40, 19));
        ActualTimeAgingText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualTimeAgingTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        currentProcessPanel.add(ActualTimeAgingText, gridBagConstraints);

        label6.setText("Remaining CPU:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        currentProcessPanel.add(label6, gridBagConstraints);

        ActualTimeRemainingCPUText.setText("0");
        ActualTimeRemainingCPUText.setPreferredSize(new java.awt.Dimension(40, 19));
        ActualTimeRemainingCPUText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualTimeRemainingCPUTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        currentProcessPanel.add(ActualTimeRemainingCPUText, gridBagConstraints);

        label7.setText("Remaining Quantum");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        currentProcessPanel.add(label7, gridBagConstraints);
        label7.getAccessibleContext().setAccessibleName("Quantum Restante:");

        ActualTimeRemainingQuantumText.setText("0");
        ActualTimeRemainingQuantumText.setPreferredSize(new java.awt.Dimension(40, 19));
        ActualTimeRemainingQuantumText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualTimeRemainingQuantumTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        currentProcessPanel.add(ActualTimeRemainingQuantumText, gridBagConstraints);

        pageExecuteChoice.setPreferredSize(new java.awt.Dimension(200, 19));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        currentProcessPanel.add(pageExecuteChoice, gridBagConstraints);

        tickButton.setText("Tick!");
        tickButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tickButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(37, 32, 38, 0);
        currentProcessPanel.add(tickButton, gridBagConstraints);

        leftPanel.add(currentProcessPanel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(leftPanel, gridBagConstraints);

        centerPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        centerPanel.setLayout(new javax.swing.BoxLayout(centerPanel, javax.swing.BoxLayout.PAGE_AXIS));

        pagesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Current process page table"));

        ActualProcessTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "pag", "r", "arrive", "last access", "access", "NUR"
            }
        ));
        jScrollPane7.setViewportView(ActualProcessTable);
        if (ActualProcessTable.getColumnModel().getColumnCount() > 0) {
            ActualProcessTable.getColumnModel().getColumn(0).setHeaderValue("pag");
            ActualProcessTable.getColumnModel().getColumn(1).setHeaderValue("r");
            ActualProcessTable.getColumnModel().getColumn(2).setHeaderValue("arrive");
            ActualProcessTable.getColumnModel().getColumn(3).setHeaderValue("last access");
            ActualProcessTable.getColumnModel().getColumn(4).setHeaderValue("access");
            ActualProcessTable.getColumnModel().getColumn(5).setHeaderValue("NUR");
        }

        javax.swing.GroupLayout pagesPanelLayout = new javax.swing.GroupLayout(pagesPanel);
        pagesPanel.setLayout(pagesPanelLayout);
        pagesPanelLayout.setHorizontalGroup(
            pagesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pagesPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pagesPanelLayout.setVerticalGroup(
            pagesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pagesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(3138, Short.MAX_VALUE))
        );

        centerPanel.add(pagesPanel);

        interruptPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Interrupt request"));
        interruptPanel.add(interruptionChoice);

        interruptButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        interruptButton.setForeground(new java.awt.Color(255, 0, 153));
        interruptButton.setText("Interrupt");
        interruptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                interruptButtonActionPerformed(evt);
            }
        });
        interruptPanel.add(interruptButton);

        centerPanel.add(interruptPanel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(centerPanel, gridBagConstraints);

        rightPanel.setLayout(new javax.swing.BoxLayout(rightPanel, javax.swing.BoxLayout.PAGE_AXIS));

        schedAlgoPanel.setBackground(new java.awt.Color(204, 204, 204));
        schedAlgoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("CPU"));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Roud Robin");

        CPUchangeAlgorithmButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CPUchangeAlgorithmButton.setText("Change Algorithm");
        CPUchangeAlgorithmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpuChangeAlgorithm(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Quantum Temp");

        javax.swing.GroupLayout schedAlgoPanelLayout = new javax.swing.GroupLayout(schedAlgoPanel);
        schedAlgoPanel.setLayout(schedAlgoPanelLayout);
        schedAlgoPanelLayout.setHorizontalGroup(
            schedAlgoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(schedAlgoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(schedAlgoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(schedAlgoPanelLayout.createSequentialGroup()
                        .addGroup(schedAlgoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CPUchangeAlgorithmButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(schedAlgoPanelLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(schedAlgoPanelLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                        .addComponent(Spinner, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
        );
        schedAlgoPanelLayout.setVerticalGroup(
            schedAlgoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(schedAlgoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CPUchangeAlgorithmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(schedAlgoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(schedAlgoPanelLayout.createSequentialGroup()
                        .addComponent(Spinner)
                        .addGap(6, 6, 6))))
        );

        rightPanel.add(schedAlgoPanel);

        memAlgoPanel.setBackground(new java.awt.Color(204, 204, 204));
        memAlgoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Memory"));
        memAlgoPanel.setForeground(new java.awt.Color(204, 204, 204));

        MemorybitsResetNURButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        MemorybitsResetNURButton.setText("Bits Reset NUR");
        MemorybitsResetNURButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bitsReset(evt);
            }
        });

        MemorychangeAlgorithmButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        MemorychangeAlgorithmButton.setText("Change Algorithm");
        MemorychangeAlgorithmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeAlgorithm(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("NUR");

        javax.swing.GroupLayout memAlgoPanelLayout = new javax.swing.GroupLayout(memAlgoPanel);
        memAlgoPanel.setLayout(memAlgoPanelLayout);
        memAlgoPanelLayout.setHorizontalGroup(
            memAlgoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(memAlgoPanelLayout.createSequentialGroup()
                .addGroup(memAlgoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(memAlgoPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(memAlgoPanelLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(memAlgoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MemorybitsResetNURButton, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MemorychangeAlgorithmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        memAlgoPanelLayout.setVerticalGroup(
            memAlgoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(memAlgoPanelLayout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MemorychangeAlgorithmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(MemorybitsResetNURButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        rightPanel.add(memAlgoPanel);

        createProcessPanel.setBackground(new java.awt.Color(204, 204, 204));
        createProcessPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("New process"));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Name:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Total Execution:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Pages:");

        NewProcessCreateButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        NewProcessCreateButton.setText("Create:");
        NewProcessCreateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtom(evt);
            }
        });

        newProcessNameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newProcessNameTextActionPerformed(evt);
            }
        });

        newProcessTotalExecutionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newProcessTotalExecutionButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout createProcessPanelLayout = new javax.swing.GroupLayout(createProcessPanel);
        createProcessPanel.setLayout(createProcessPanelLayout);
        createProcessPanelLayout.setHorizontalGroup(
            createProcessPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createProcessPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(createProcessPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NewProcessCreateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(createProcessPanelLayout.createSequentialGroup()
                        .addGroup(createProcessPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10)
                            .addGroup(createProcessPanelLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(newProcessPagesText))
                            .addGroup(createProcessPanelLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(newProcessNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(newProcessTotalExecutionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 87, Short.MAX_VALUE)))
                .addContainerGap())
        );
        createProcessPanelLayout.setVerticalGroup(
            createProcessPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createProcessPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(createProcessPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(newProcessNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(createProcessPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(newProcessPagesText, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(createProcessPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(newProcessTotalExecutionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(NewProcessCreateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        rightPanel.add(createProcessPanel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        getContentPane().add(rightPanel, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void changeAlgorithm(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeAlgorithm
        // TODO add your handling code here:
    }//GEN-LAST:event_changeAlgorithm

    private void bitsReset(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bitsReset
        // TODO add your handling code here:
    }//GEN-LAST:event_bitsReset

    private void ActualTimeArriveTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualTimeArriveTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ActualTimeArriveTextActionPerformed

    private void ActualTimeAssignedCPUTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualTimeAssignedCPUTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ActualTimeAssignedCPUTextActionPerformed

    private void ActualTimeAgingTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualTimeAgingTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ActualTimeAgingTextActionPerformed

    private void ActualTimeRemainingCPUTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualTimeRemainingCPUTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ActualTimeRemainingCPUTextActionPerformed

    private void ActualTimeRemainingQuantumTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualTimeRemainingQuantumTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ActualTimeRemainingQuantumTextActionPerformed

    private void cpuChangeAlgorithm(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpuChangeAlgorithm
        // TODO add your handling code here:
    }//GEN-LAST:event_cpuChangeAlgorithm

    private void AddFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddFileButtonActionPerformed
        //the Add file button
        int returnVal = this.fc.showOpenDialog(Panel.this);
        
        if (returnVal == JFileChooser.APPROVE_OPTION){
            File file = fc.getSelectedFile();
            Parser parser = new Parser(file.getAbsolutePath());
            LinkedList<ProcessParsed> procs = null;
            
            try{
               procs = parser.parse();
            }catch (IOException e){
                System.out.println("Fuck");
                System.exit(-1);
            }
            int i = 0;
        for(ProcessParsed p: procs){
            i++;
            try{
                kernel.newProcess("Process " + Integer.toString(i), p.getArriveTime(), p.getEstimatedTime(), p.getNextState(), p.getPages() );
            }catch(cutreos.OSisFullException e){
                JOptionPane.showMessageDialog(Panel.this, "Operating system is full!\nProcess is not allowed to enter");
            }
        }
        this.updateData();
            
        }
    }//GEN-LAST:event_AddFileButtonActionPerformed

    private void interruptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_interruptButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_interruptButtonActionPerformed

    private void newProcessTotalExecutionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newProcessTotalExecutionButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newProcessTotalExecutionButtonActionPerformed

    private void newProcessNameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newProcessNameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newProcessNameTextActionPerformed

    private void createButtom(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtom
        // TODO add your handling code here:
    }//GEN-LAST:event_createButtom

    private void ActualTimeNameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualTimeNameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ActualTimeNameTextActionPerformed

    private void actualTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_actualTimeActionPerformed

    private void tickButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tickButtonActionPerformed
        kernel.tick();
        updateData();
    }//GEN-LAST:event_tickButtonActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Panel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ActualProcessTable;
    private javax.swing.JTextField ActualTimeAgingText;
    private javax.swing.JTextField ActualTimeArriveText;
    private javax.swing.JTextField ActualTimeAssignedCPUText;
    private javax.swing.JTextField ActualTimeNameText;
    private javax.swing.JTextField ActualTimeRemainingCPUText;
    private javax.swing.JTextField ActualTimeRemainingQuantumText;
    private javax.swing.JButton AddFileButton;
    private javax.swing.JButton CPUchangeAlgorithmButton;
    private javax.swing.JButton MemorybitsResetNURButton;
    private javax.swing.JButton MemorychangeAlgorithmButton;
    private javax.swing.JButton NewProcessCreateButton;
    private javax.swing.JSpinner Spinner;
    private java.awt.TextField actualTime;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JPanel createProcessPanel;
    private javax.swing.JPanel currentProcessPanel;
    private javax.swing.JButton interruptButton;
    private javax.swing.JPanel interruptPanel;
    private java.awt.Choice interruptionChoice;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane7;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label6;
    private java.awt.Label label7;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JPanel memAlgoPanel;
    private javax.swing.JTextField newProcessNameText;
    private javax.swing.JSpinner newProcessPagesText;
    private javax.swing.JTextField newProcessTotalExecutionButton;
    private java.awt.Choice pageExecuteChoice;
    private javax.swing.JPanel pagesPanel;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JPanel schedAlgoPanel;
    private javax.swing.JButton tickButton;
    private javax.swing.JPanel timePanel;
    // End of variables declaration//GEN-END:variables
}
