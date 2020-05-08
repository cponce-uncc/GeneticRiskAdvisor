/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poncecristianproject;

/**
 *
 * @author cristian_ponce
 */
public class AutosomalDominant extends GeneticDisease {

    public AutosomalDominant(String diseaseType, String description, int index) {
        super(diseaseType, description, index);
    }

    @Override
    public int calculateAffectedRisk(Parent mother, Parent father) {
        int motherResults = mother.getScreeningResults()[this.getIndex()];
        int fatherResults = father.getScreeningResults()[this.getIndex()];

        // No carriers
        if ((motherResults == 0) && (fatherResults == 0)) {
            return 0;  // No possibility 
        } // One affected
        else if (((motherResults == 2) && (fatherResults == 0))
                || ((fatherResults == 2) && (motherResults == 0))) {
            return 50;
        } // Both affected
        else {
            return 75;
        }
    }

    @Override
    public String diseaseReport(Parent father, Parent mother) {
        int affectedRisk = (this.calculateAffectedRisk(mother, father));
        int fatherResults = (father.getScreeningResults()[this.getIndex()]);
        int motherResults = (father.getScreeningResults()[this.getIndex()]);
        String fatherName = father.getName();
        String motherName = mother.getName();
        String diseaseSummary = this.getDiseaseType() + " is " + this.getDescription() + ". ";
        String customReport;

        // Neither carriers
        if ((motherResults == 0) && (fatherResults == 0)) {
            customReport = "Neither " + motherName + " or " + fatherName
                    + " are carriers for " + this.getDiseaseType() + ". There is no "
                    + "risk of your child being a carrier or affected by "
                    + this.getDiseaseType() + ".";
        } // Both affected
        else if ((motherResults == 2) && (fatherResults == 2)) {
            customReport = "Both " + motherName + " and " + fatherName
                    + " are affected by " + this.getDiseaseType() + ". There is a "
                    + affectedRisk + "% chance risk of your child being affected by "
                    + this.getDiseaseType() + ".";
        } // One affected, one neither
        else if (((motherResults == 2) && (fatherResults == 0))
                || ((fatherResults == 2) && (motherResults == 0))) {
            if (motherResults == 2) {  // Mother affected
                customReport = mother.getName() + " is affected by " + this.getDiseaseType()
                        + " but " + mother.getName() + " is neither affected or a carrier. This means that there"
                        + " is a " + affectedRisk + " of your child being affected by "
                        + this.getDiseaseType() + ".";
            } else { // Father affectedif(motherResults == 2){  // Mother affected
                customReport = father.getName() + " is affected by " + this.getDiseaseType()
                        + " but " + mother.getName() + " is neither affected or a carrier. This means that there"
                        + " is a " + affectedRisk + " of your child being affected by "
                        + this.getDiseaseType() + ".";
            }
        } // Other conditional
        else {
            customReport = " ERROR";
        }

        return diseaseSummary + customReport;
    }

}
