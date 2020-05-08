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
public class AutosomalRecessive extends GeneticDisease{

    public AutosomalRecessive(String diseaseType, String description, int index){
        super(diseaseType, description, index);
    }
    
    public int calculateCarrierRisk(Parent mother, Parent father) {
        int motherResults = mother.getScreeningResults()[this.getIndex()];
        int fatherResults = father.getScreeningResults()[this.getIndex()];

        if ((motherResults == 0) && (fatherResults == 0)){
            return 0;  // No possibility 
        }
        
        // Both carriers
        else if (((motherResults == 1) && (fatherResults == 1))
                || ((fatherResults == 1) && (motherResults == 1))){
            return 75;
        }
        
        // One carrier, one neither
        else if (((motherResults == 1) && (fatherResults == 0))
                || ((fatherResults == 1) && (motherResults == 0))){
            return 75;
        }
        
        // One affected, one carrier
        else if (((motherResults == 2) && (fatherResults == 1))
                || ((fatherResults == 2) && (motherResults == 1))){
            return 100;
        }
        
        // One affected, one neither
        else if (((motherResults == 2) && (fatherResults == 0))
                || ((fatherResults == 2) && (motherResults == 0))){
            return 100;
        }
        
        // Both affected
        else{
            return 100;
        }
    }
    
    @Override
    public int calculateAffectedRisk(Parent father, Parent mother){
        int motherResults = mother.getScreeningResults()[this.getIndex()];
        int fatherResults = father.getScreeningResults()[this.getIndex()];

        if ((motherResults == 0) && (fatherResults == 0)){
            return 0;  // No possibility 
        }
        
        // Both carriers
        else if (((motherResults == 1) && (fatherResults == 1))
                || ((fatherResults == 1) && (motherResults == 1))){
            return 25;
        }
        
        // One carrier, one neither
        else if (((motherResults == 1) && (fatherResults == 0))
                || ((fatherResults == 1) && (motherResults == 0))){
            return 0;
        }
        
        // One affected, one carrier
        else if (((motherResults == 2) && (fatherResults == 1))
                || ((fatherResults == 2) && (motherResults == 1))){
            return 50;
        }
        
        // One affected, one neither
        else if (((motherResults == 2) && (fatherResults == 0))
                || ((fatherResults == 2) && (motherResults == 0))){
            return 0;
        }
        
        // Both affected
        else{
            return 100;
        }
    }

    @Override
    public String diseaseReport(Parent father, Parent mother) {
        int affectedRisk = (this.calculateAffectedRisk(mother, father));
        int carrierRisk = (this.calculateCarrierRisk(mother, father));
        int fatherResults = (father.getScreeningResults()[this.getIndex()]);
        int motherResults = (father.getScreeningResults()[this.getIndex()]);
        String fatherName = father.getName();
        String motherName = mother.getName();
        String diseaseSummary = this.getDiseaseType() + " is " + this.getDescription() + ". ";
        String customReport;

        
        // Neither carriers
        if ((motherResults == 0) && (fatherResults == 0)){
            customReport = "Neither " + motherName + " or " + fatherName
                    + " are carriers for " + this.getDiseaseType() + ". There is no "
                    + "risk of your child being a carrier or affected by " 
                    + this.getDiseaseType() + ".";
        }
        
        // Both carriers
        else if ((motherResults == 1) && (fatherResults == 1)){
            customReport =  "Both " + motherName + " and " + fatherName
                    + " are carriers for " + this.getDiseaseType() + ". There is a "
                    + affectedRisk + "% chance risk of your child being affected by " 
                    + this.getDiseaseType() + " and a " + carrierRisk + "% risk" 
                    + " of your child being a carrier for " + this.getDiseaseType() + ".";
        }
        
        // Both affected
        else if ((motherResults == 2) && (fatherResults == 2)){
            customReport =  "Both " + motherName + " and " + fatherName
                    + " are affected by " + this.getDiseaseType() + ". There is a "
                    + affectedRisk + "% chance risk of your child being affected by " 
                    + this.getDiseaseType() + " and a " + carrierRisk + "% risk" 
                    + " of your child being a carrier for " + this.getDiseaseType() + ".";
        }
        
        // One carrier, one neither
        else if (((motherResults == 1) && (fatherResults == 0))
                || ((fatherResults == 1) && (motherResults == 0))){
            if (motherResults == 1){  // Mother is carrier
                customReport = mother.getName() + " is a carrier for " + this.getDiseaseType()
                        + " . There is no chance of your child being affected by " 
                        + this.getDiseaseType() + " but there is a " + carrierRisk 
                        + "chance of your child being a carrier for" + this.getDiseaseType() + " .";
            }
            else{  // Father is carrier
                customReport = father.getName() + " is a carrier for " + this.getDiseaseType()
                        + " . There is no chance of your child being affected by " 
                        + this.getDiseaseType() + " but there is a " + carrierRisk 
                        + "chance of your child being a carrier for" + this.getDiseaseType() + " .";
            }
        }
        
        // One affected, one carrier
        else if (((motherResults == 2) && (fatherResults == 1))
                || ((fatherResults == 2) && (motherResults == 1))){
            if (motherResults == 2){  // Mother affected, father carrier
                customReport = mother.getName() + " is affected by " + this.getDiseaseType()
                        + " and " + father.getName() + " is a carrier. This means that there"
                        + "is a " + affectedRisk + " of your child being affected by "
                        + this.getDiseaseType() + " and a " + carrierRisk + " chance "
                        + "of your child being a carrier";
            }
            else{
                customReport = father.getName() + " is affected by " + this.getDiseaseType()
                        + " and " + mother.getName() + " is a carrier. This means that there"
                        + "is a " + affectedRisk + " of your child being affected by "
                        + this.getDiseaseType() + " and a " + carrierRisk + " chance "
                        + "of your child being a carrier";
            }
        }
        
        // One affected, one neither
        else if (((motherResults == 2) && (fatherResults == 0))
                || ((fatherResults == 2) && (motherResults == 0))){
            if(motherResults == 2){  // Mother affected
                customReport = mother.getName() + " is affected by " + this.getDiseaseType()
                        + " but " + mother.getName() + " is neither affected or a carrier. This means that there"
                        + " is a " + affectedRisk + " of your child being affected by "
                        + this.getDiseaseType() + " and a " + carrierRisk + " chance "
                        + "of your child being a carrier";
            }
            else{ // Father affectedif(motherResults == 2){  // Mother affected
                customReport = father.getName() + " is affected by " + this.getDiseaseType()
                        + " but " + mother.getName() + " is neither affected or a carrier. This means that there"
                        + " is a " + affectedRisk + " of your child being affected by "
                        + this.getDiseaseType() + " and a " + carrierRisk + " chance "
                        + "of your child being a carrier";
            }
        }
        
        // Other conditional
        else{
            customReport = " ERROR";
        }
        
        return diseaseSummary + customReport;
    }
                                
}
       
