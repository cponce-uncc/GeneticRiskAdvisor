/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poncecristianproject;

import java.awt.Color;
import java.util.*;

/**
 *
 * @author cristian_ponce
 */
public class ResultsFrame extends javax.swing.JFrame {

    private Parent father;
    private Parent mother;
    ArrayList<GeneticDisease> diseaseList = new ArrayList<>();

    /**
     * Creates new form resultsFrame
     *
     * @param father
     * @param mother
     */

    public ResultsFrame() {
    }

    public ResultsFrame(Parent father, Parent mother) {
        initComponents();

        // Assign mother and father objects as class members
        this.father = father;
        this.mother = mother;

        // Name survey based on parent names
        frameTitle.setText("Results for " + father.getName() + " & " + mother.getName());

        // Create disease assessments
        AutosomalDominant huntingtonDisease = new AutosomalDominant("Huntington's Disease",
                "a disorder which involves the progressive degeneration of nerve cells in the brain", 0);
        diseaseList.add(huntingtonDisease);
        AutosomalDominant marfanSyndrome = new AutosomalDominant("Marfan Syndrome",
                "a disorder that impacts connective tissue", 1);
        diseaseList.add(marfanSyndrome);
        AutosomalRecessive taysachDisease = new AutosomalRecessive("Taysach's Disease",
                "a disorder which results in the destruction of nerve cells located in the brain and spinal cord", 2);
        diseaseList.add(taysachDisease);
        AutosomalRecessive cysticFibrosis = new AutosomalRecessive("Cystic Fibrosis",
                "a disorder which causes the body to create mucus, which damages the lungs and digestive system", 3);
        diseaseList.add(cysticFibrosis);

        //Assess risk of each disease
        int huntingtonRisk = huntingtonDisease.calculateAffectedRisk(father, mother);
        int marfanRisk = marfanSyndrome.calculateAffectedRisk(father, mother);
        int taysachRisk = taysachDisease.calculateAffectedRisk(father, mother);
        int cysticRisk = cysticFibrosis.calculateAffectedRisk(father, mother);
        int taysachCarrierRisk = taysachDisease.calculateCarrierRisk(father, mother);
        int cysticCarrierRisk = cysticFibrosis.calculateCarrierRisk(father, mother);

        // Assign labels to each risk number
        huntingtonRiskLabel.setText(huntingtonRisk + "%");
        marfanRiskLabel.setText(marfanRisk + "%");
        taysachRiskLabel.setText(taysachRisk + "%");
        cysticRiskLabel.setText(cysticRisk + "%");

        // Set background color and text color based off of risk
        // Huntington Disease
        if (huntingtonRisk < 25) {
            huntingtonPanel.setBackground(Color.green);
            huntingtonRiskDescription.setText("No risk!");
            huntingtonInfoButton.setVisible(false);
        } else if ((huntingtonRisk >= 25) && (huntingtonRisk < 50)) {
            huntingtonPanel.setBackground(Color.ORANGE);
            huntingtonRiskDescription.setText("Moderate risk");
            huntingtonInfoButton.setEnabled(true);
            huntingtonInfoButton.setVisible(true);

        } else {
            huntingtonPanel.setBackground(Color.red);
            huntingtonRiskDescription.setText("High risk");
            huntingtonInfoButton.setEnabled(true);
            huntingtonInfoButton.setVisible(true);
        }

        // Marfan Syndrome
        if (marfanRisk < 25) {
            marfanPanel.setBackground(Color.green);
            marfanRiskDescription.setText("No risk!");
            marfanInfoButton.setVisible(false);
        } else if ((marfanRisk >= 25) && (marfanRisk < 50)) {
            marfanPanel.setBackground(Color.ORANGE);
            marfanRiskDescription.setText("Moderate risk");
            marfanInfoButton.setEnabled(true);
            marfanInfoButton.setVisible(true);

        } else {
            marfanPanel.setBackground(Color.red);
            marfanRiskDescription.setText("High risk");
            marfanInfoButton.setEnabled(true);
            marfanInfoButton.setVisible(true);
        }

        // Tay-Sach's Disease
        if (taysachRisk < 25) {
            taysachPanel.setBackground(Color.green);
            taysachRiskDescription.setText("No risk, " + taysachCarrierRisk + "% carrier");
            taysachInfoButton.setVisible(false);
        } else if ((taysachRisk >= 25) && (taysachRisk < 50)) {
            taysachPanel.setBackground(Color.ORANGE);
            taysachRiskDescription.setText("Moderate risk, " + taysachCarrierRisk + "% carrier");
            taysachInfoButton.setEnabled(true);
            taysachInfoButton.setVisible(true);

        } else {
            taysachPanel.setBackground(Color.red);
            taysachRiskDescription.setText("High risk, " + taysachCarrierRisk + "% carrier");
            taysachInfoButton.setEnabled(true);
            taysachInfoButton.setVisible(true);
        }

        // Cystic Fibrosis
        if (cysticRisk < 25) {
            cysticPanel.setBackground(Color.green);
            cysticRiskDescription.setText("No risk, " + cysticCarrierRisk + "% carrier");
            cysticInfoButton.setVisible(false);
        } else if ((cysticRisk >= 25) && (cysticRisk < 50)) {
            cysticPanel.setBackground(Color.ORANGE);
            cysticRiskDescription.setText("Moderate risk, " + cysticCarrierRisk + "% carrier");
            cysticInfoButton.setEnabled(true);
            cysticInfoButton.setVisible(true);

        } else {
            cysticPanel.setBackground(Color.red);
            cysticRiskDescription.setText("High risk, " + cysticCarrierRisk + "% carrier");
            cysticInfoButton.setEnabled(true);
            cysticInfoButton.setVisible(true);
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

        backgroundPanel = new javax.swing.JPanel();
        frameTitle = new javax.swing.JLabel();
        huntingtonPanel = new javax.swing.JPanel();
        huntingtonRiskLabel = new javax.swing.JLabel();
        huntingtonRiskDescription = new javax.swing.JLabel();
        huntingtonInfoButton = new javax.swing.JButton();
        huntingtonRiskDescription2 = new javax.swing.JLabel();
        taysachPanel = new javax.swing.JPanel();
        taysachDescriptionLabel2 = new javax.swing.JLabel();
        taysachRiskLabel = new javax.swing.JLabel();
        taysachInfoButton = new javax.swing.JButton();
        taysachRiskDescription = new javax.swing.JLabel();
        marfanPanel = new javax.swing.JPanel();
        marfanRiskLabel = new javax.swing.JLabel();
        marfanRiskDescription = new javax.swing.JLabel();
        marfanInfoButton = new javax.swing.JButton();
        marfanRiskDescription2 = new javax.swing.JLabel();
        cysticPanel = new javax.swing.JPanel();
        cysticRiskDescription2 = new javax.swing.JLabel();
        cysticRiskLabel = new javax.swing.JLabel();
        cysticRiskDescription = new javax.swing.JLabel();
        cysticInfoButton = new javax.swing.JButton();
        descriptionLabel = new javax.swing.JLabel();
        huntingtonLabel = new javax.swing.JLabel();
        marfanLabel = new javax.swing.JLabel();
        newSurveyButton = new javax.swing.JButton();
        exitProgramButton = new javax.swing.JButton();
        descriptionLabel2 = new javax.swing.JLabel();
        taysachLabel = new javax.swing.JLabel();
        cysticLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        backgroundPanel.setBackground(new java.awt.Color(153, 153, 255));
        backgroundPanel.setForeground(new java.awt.Color(153, 153, 255));

        frameTitle.setFont(new java.awt.Font("Lao Sangam MN", 0, 24)); // NOI18N
        frameTitle.setForeground(new java.awt.Color(255, 255, 255));
        frameTitle.setText("Survey Results");

        huntingtonPanel.setBackground(new java.awt.Color(204, 204, 255));

        huntingtonRiskLabel.setFont(new java.awt.Font("Lao Sangam MN", 0, 70)); // NOI18N
        huntingtonRiskLabel.setForeground(new java.awt.Color(255, 255, 255));
        huntingtonRiskLabel.setText("0%");

        huntingtonRiskDescription.setFont(new java.awt.Font("Lao Sangam MN", 0, 13)); // NOI18N
        huntingtonRiskDescription.setForeground(new java.awt.Color(255, 255, 255));
        huntingtonRiskDescription.setText("No risk! ");

        huntingtonInfoButton.setFont(new java.awt.Font("Lao Sangam MN", 0, 13)); // NOI18N
        huntingtonInfoButton.setText("More Info");
        huntingtonInfoButton.setEnabled(false);
        huntingtonInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                huntingtonInfoButtonActionPerformed(evt);
            }
        });

        huntingtonRiskDescription2.setFont(new java.awt.Font("Lao Sangam MN", 0, 13)); // NOI18N
        huntingtonRiskDescription2.setForeground(new java.awt.Color(255, 255, 255));
        huntingtonRiskDescription2.setText("Affected Risk:");

        javax.swing.GroupLayout huntingtonPanelLayout = new javax.swing.GroupLayout(huntingtonPanel);
        huntingtonPanel.setLayout(huntingtonPanelLayout);
        huntingtonPanelLayout.setHorizontalGroup(
            huntingtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(huntingtonPanelLayout.createSequentialGroup()
                .addGroup(huntingtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(huntingtonPanelLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(huntingtonRiskDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(26, 26, 26)
                        .addComponent(huntingtonInfoButton))
                    .addGroup(huntingtonPanelLayout.createSequentialGroup()
                        .addGroup(huntingtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(huntingtonPanelLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(huntingtonRiskLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(huntingtonPanelLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(huntingtonRiskDescription2)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        huntingtonPanelLayout.setVerticalGroup(
            huntingtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(huntingtonPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(huntingtonRiskDescription2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(huntingtonRiskLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(huntingtonRiskDescription)
                .addGap(14, 14, 14))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, huntingtonPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(huntingtonInfoButton))
        );

        taysachPanel.setBackground(new java.awt.Color(204, 204, 255));

        taysachDescriptionLabel2.setFont(new java.awt.Font("Lao Sangam MN", 0, 13)); // NOI18N
        taysachDescriptionLabel2.setForeground(new java.awt.Color(255, 255, 255));
        taysachDescriptionLabel2.setText("Affected Risk:");

        taysachRiskLabel.setFont(new java.awt.Font("Lao Sangam MN", 0, 70)); // NOI18N
        taysachRiskLabel.setForeground(new java.awt.Color(255, 255, 255));
        taysachRiskLabel.setText("0%");

        taysachInfoButton.setFont(new java.awt.Font("Lao Sangam MN", 0, 13)); // NOI18N
        taysachInfoButton.setText("More Info");
        taysachInfoButton.setEnabled(false);
        taysachInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taysachInfoButtonActionPerformed(evt);
            }
        });

        taysachRiskDescription.setFont(new java.awt.Font("Lao Sangam MN", 0, 13)); // NOI18N
        taysachRiskDescription.setForeground(new java.awt.Color(255, 255, 255));
        taysachRiskDescription.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        taysachRiskDescription.setText("No risk!");

        javax.swing.GroupLayout taysachPanelLayout = new javax.swing.GroupLayout(taysachPanel);
        taysachPanel.setLayout(taysachPanelLayout);
        taysachPanelLayout.setHorizontalGroup(
            taysachPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(taysachPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(taysachPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(taysachPanelLayout.createSequentialGroup()
                        .addGap(0, 24, Short.MAX_VALUE)
                        .addComponent(taysachRiskDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(taysachInfoButton))
                    .addGroup(taysachPanelLayout.createSequentialGroup()
                        .addGroup(taysachPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(taysachRiskLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(taysachPanelLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(taysachDescriptionLabel2)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        taysachPanelLayout.setVerticalGroup(
            taysachPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(taysachPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(taysachDescriptionLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(taysachRiskLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(taysachPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(taysachPanelLayout.createSequentialGroup()
                        .addGap(0, 6, Short.MAX_VALUE)
                        .addComponent(taysachInfoButton))
                    .addGroup(taysachPanelLayout.createSequentialGroup()
                        .addComponent(taysachRiskDescription)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        marfanPanel.setBackground(new java.awt.Color(204, 204, 255));

        marfanRiskLabel.setFont(new java.awt.Font("Lao Sangam MN", 0, 70)); // NOI18N
        marfanRiskLabel.setForeground(new java.awt.Color(255, 255, 255));
        marfanRiskLabel.setText("0%");

        marfanRiskDescription.setFont(new java.awt.Font("Lao Sangam MN", 0, 13)); // NOI18N
        marfanRiskDescription.setForeground(new java.awt.Color(255, 255, 255));
        marfanRiskDescription.setText("No risk!");

        marfanInfoButton.setFont(new java.awt.Font("Lao Sangam MN", 0, 13)); // NOI18N
        marfanInfoButton.setText("More Info");
        marfanInfoButton.setEnabled(false);
        marfanInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marfanInfoButtonActionPerformed(evt);
            }
        });

        marfanRiskDescription2.setFont(new java.awt.Font("Lao Sangam MN", 0, 13)); // NOI18N
        marfanRiskDescription2.setForeground(new java.awt.Color(255, 255, 255));
        marfanRiskDescription2.setText("Affected Risk:");

        javax.swing.GroupLayout marfanPanelLayout = new javax.swing.GroupLayout(marfanPanel);
        marfanPanel.setLayout(marfanPanelLayout);
        marfanPanelLayout.setHorizontalGroup(
            marfanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, marfanPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(marfanRiskDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(marfanInfoButton))
            .addGroup(marfanPanelLayout.createSequentialGroup()
                .addGroup(marfanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(marfanPanelLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(marfanRiskDescription2))
                    .addGroup(marfanPanelLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(marfanRiskLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        marfanPanelLayout.setVerticalGroup(
            marfanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(marfanPanelLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(marfanRiskDescription2)
                .addGroup(marfanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(marfanPanelLayout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(marfanInfoButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, marfanPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(marfanRiskLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(marfanRiskDescription)
                        .addGap(16, 16, 16))))
        );

        cysticPanel.setBackground(new java.awt.Color(204, 204, 255));

        cysticRiskDescription2.setFont(new java.awt.Font("Lao Sangam MN", 0, 13)); // NOI18N
        cysticRiskDescription2.setForeground(new java.awt.Color(255, 255, 255));
        cysticRiskDescription2.setText("Affected Risk:");

        cysticRiskLabel.setFont(new java.awt.Font("Lao Sangam MN", 0, 70)); // NOI18N
        cysticRiskLabel.setForeground(new java.awt.Color(255, 255, 255));
        cysticRiskLabel.setText("0%");

        cysticRiskDescription.setFont(new java.awt.Font("Lao Sangam MN", 0, 13)); // NOI18N
        cysticRiskDescription.setForeground(new java.awt.Color(255, 255, 255));
        cysticRiskDescription.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cysticRiskDescription.setText("No risk!");

        cysticInfoButton.setFont(new java.awt.Font("Lao Sangam MN", 0, 13)); // NOI18N
        cysticInfoButton.setText("More Info");
        cysticInfoButton.setEnabled(false);
        cysticInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cysticInfoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cysticPanelLayout = new javax.swing.GroupLayout(cysticPanel);
        cysticPanel.setLayout(cysticPanelLayout);
        cysticPanelLayout.setHorizontalGroup(
            cysticPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cysticPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(cysticRiskDescription2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(cysticPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(cysticPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cysticPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cysticRiskDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cysticInfoButton))
                    .addGroup(cysticPanelLayout.createSequentialGroup()
                        .addComponent(cysticRiskLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        cysticPanelLayout.setVerticalGroup(
            cysticPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cysticPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(cysticRiskDescription2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cysticRiskLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cysticPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cysticPanelLayout.createSequentialGroup()
                        .addComponent(cysticRiskDescription)
                        .addContainerGap(18, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cysticPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cysticInfoButton))))
        );

        descriptionLabel.setFont(new java.awt.Font("Lao Sangam MN", 0, 13)); // NOI18N
        descriptionLabel.setForeground(new java.awt.Color(255, 255, 255));
        descriptionLabel.setText("The following information reflects the probability of your child being impacted.");

        huntingtonLabel.setFont(new java.awt.Font("Lao Sangam MN", 0, 13)); // NOI18N
        huntingtonLabel.setForeground(new java.awt.Color(255, 255, 255));
        huntingtonLabel.setText("Huntington's Disease (Autosomal Dominant)");

        marfanLabel.setFont(new java.awt.Font("Lao Sangam MN", 0, 13)); // NOI18N
        marfanLabel.setForeground(new java.awt.Color(255, 255, 255));
        marfanLabel.setText("Marfan Syndrome (Autosomal Dominant)");

        newSurveyButton.setFont(new java.awt.Font("Lao Sangam MN", 0, 13)); // NOI18N
        newSurveyButton.setText("New Survey ->");
        newSurveyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newSurveyButtonActionPerformed(evt);
            }
        });

        exitProgramButton.setFont(new java.awt.Font("Lao Sangam MN", 0, 13)); // NOI18N
        exitProgramButton.setText("Exit Program");
        exitProgramButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitProgramButtonActionPerformed(evt);
            }
        });

        descriptionLabel2.setFont(new java.awt.Font("Lao Sangam MN", 0, 13)); // NOI18N
        descriptionLabel2.setForeground(new java.awt.Color(255, 255, 255));
        descriptionLabel2.setText("Please note that for AD disorders, only the risk of the child being affected is shown.");

        taysachLabel.setFont(new java.awt.Font("Lao Sangam MN", 0, 13)); // NOI18N
        taysachLabel.setForeground(new java.awt.Color(255, 255, 255));
        taysachLabel.setText("Tay-Sach's Disease (Autosomal Recessive)");

        cysticLabel.setFont(new java.awt.Font("Lao Sangam MN", 0, 13)); // NOI18N
        cysticLabel.setForeground(new java.awt.Color(255, 255, 255));
        cysticLabel.setText("Cystic Fibrosis (Autosomal Recessive)");

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exitProgramButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newSurveyButton)
                .addContainerGap())
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descriptionLabel2)
                            .addComponent(marfanLabel)
                            .addComponent(huntingtonLabel))
                        .addGap(0, 308, Short.MAX_VALUE))
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(backgroundPanelLayout.createSequentialGroup()
                                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(marfanPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(huntingtonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(42, 42, 42)
                                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cysticLabel)
                                    .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(taysachLabel)
                                        .addComponent(cysticPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(taysachPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(frameTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(descriptionLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(frameTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descriptionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descriptionLabel2)
                .addGap(27, 27, 27)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(huntingtonLabel)
                    .addComponent(taysachLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(taysachPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(huntingtonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(marfanLabel)
                    .addComponent(cysticLabel))
                .addGap(5, 5, 5)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cysticPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(marfanPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newSurveyButton)
                    .addComponent(exitProgramButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void huntingtonInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_huntingtonInfoButtonActionPerformed
        // TODO add your handling code here:
        InfoFrame huntingtonInfo = new InfoFrame(this.father, this.mother, this.diseaseList.get(0));
        huntingtonInfo.setVisible(true);
    }//GEN-LAST:event_huntingtonInfoButtonActionPerformed

    private void marfanInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marfanInfoButtonActionPerformed
        InfoFrame marfanInfo = new InfoFrame(this.father, this.mother, this.diseaseList.get(1));
        marfanInfo.setVisible(true);
    }//GEN-LAST:event_marfanInfoButtonActionPerformed

    private void newSurveyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newSurveyButtonActionPerformed
        this.mother = null;
        this.father = null;
        Parent newMother = new Parent(false);
        Parent newFather = new Parent(true);

        SurveyFrame newFrame = new SurveyFrame(newFather, newMother, true);
        newFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_newSurveyButtonActionPerformed

    private void exitProgramButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitProgramButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
        //System.exit(0); Disabled for harness code
    }//GEN-LAST:event_exitProgramButtonActionPerformed

    private void taysachInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taysachInfoButtonActionPerformed
        // TODO add your handling code here:
        InfoFrame taysachInfo = new InfoFrame(this.father, this.mother, this.diseaseList.get(2));
        taysachInfo.setVisible(true);
    }//GEN-LAST:event_taysachInfoButtonActionPerformed

    private void cysticInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cysticInfoButtonActionPerformed
        // TODO add your handling code here:
        InfoFrame cysticInfo = new InfoFrame(this.father, this.mother, this.diseaseList.get(3));
        cysticInfo.setVisible(true);
    }//GEN-LAST:event_cysticInfoButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JButton cysticInfoButton;
    private javax.swing.JLabel cysticLabel;
    private javax.swing.JPanel cysticPanel;
    private javax.swing.JLabel cysticRiskDescription;
    private javax.swing.JLabel cysticRiskDescription2;
    private javax.swing.JLabel cysticRiskLabel;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JLabel descriptionLabel2;
    private javax.swing.JButton exitProgramButton;
    private javax.swing.JLabel frameTitle;
    private javax.swing.JButton huntingtonInfoButton;
    private javax.swing.JLabel huntingtonLabel;
    private javax.swing.JPanel huntingtonPanel;
    private javax.swing.JLabel huntingtonRiskDescription;
    private javax.swing.JLabel huntingtonRiskDescription2;
    private javax.swing.JLabel huntingtonRiskLabel;
    private javax.swing.JButton marfanInfoButton;
    private javax.swing.JLabel marfanLabel;
    private javax.swing.JPanel marfanPanel;
    private javax.swing.JLabel marfanRiskDescription;
    private javax.swing.JLabel marfanRiskDescription2;
    private javax.swing.JLabel marfanRiskLabel;
    private javax.swing.JButton newSurveyButton;
    private javax.swing.JLabel taysachDescriptionLabel2;
    private javax.swing.JButton taysachInfoButton;
    private javax.swing.JLabel taysachLabel;
    private javax.swing.JPanel taysachPanel;
    private javax.swing.JLabel taysachRiskDescription;
    private javax.swing.JLabel taysachRiskLabel;
    // End of variables declaration//GEN-END:variables

}
