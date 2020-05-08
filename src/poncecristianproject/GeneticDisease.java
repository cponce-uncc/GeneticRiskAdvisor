/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poncecristianproject;

/**
 *
 * @author cristian_ponce
 * PLEASE READ: While creating this project, I realized that several adjustments 
 * had to be made to the project. The calculateRisk() method takes in two parents
 * as its parameters. A mistake was made in the UML (RiskAssessment constructor
 * took in two Parent arguments when none were used as fields). This approach creates
 * the risk assessments (objects) based on the disease type recessive/dominant, and then uses
 * the calculateRisk method of each assessment object. It is necessary that the classes
 * be separate, as the risk is calculated differently based on whether the disease
 * is dominant or recessive. No changes were made to the parent class, except the
 * use of the class by the RiskAssesment abstract class. The class containing the main
 * method was renamed to start.java.
 */
public abstract class GeneticDisease {
    private String diseaseType;
    private String description;
    private boolean atRisk;
    private int index;  // Field not originally included in UML, notes position of screening results in ArrayList

    public GeneticDisease(String diseaseType, String description, int index) {
        this.diseaseType = diseaseType;
        this.description = description;
        this.index = index;
    }

    /**
     * Get the value of diseaseType
     *
     * @return the value of diseaseType
     */
    public String getDiseaseType() {
        return diseaseType;
    }

    /**
     * Get the value of description
     *
     * @return the value of description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Get the value of atRisk
     *
     * @return the value of atRisk
     */
    public boolean isAtRisk() {
        return atRisk;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    
    /**
     * Set the value of atRisk
     *
     * @param atRisk new value of atRisk
     */
    public void setAtRisk(boolean atRisk) {
        this.atRisk = atRisk;
    }

    /**
     * Set the value of description
     *
     * @param description new value of description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Set the value of diseaseType
     *
     * @param diseaseType new value of diseaseType
     */
    public void setDiseaseType(String diseaseType) {
        this.diseaseType = diseaseType;
    }
    
    public abstract int calculateAffectedRisk(Parent father, Parent mother);
    
    public abstract String diseaseReport(Parent father, Parent mother);

}
