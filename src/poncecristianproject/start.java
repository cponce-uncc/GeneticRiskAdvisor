/*
HOMEWORK FIVE SUBMISSION

Major Task One: Create parent class 

Major Task Two: Create the concrete classes to extend the GeneticDisease class
and the methods necessary to calculate risk, specific to the type of disease

Major Task Three: Create a survey that passes the results back into the parent objects

Major Task Four: Define a method within the concrete class extensions of GeneticDisease
(AutosomalDominant + AutosomalRecessive) to generate a custom message based on
the disease, the parent names, and the risk of the child being impacted

Major Task Five: Design an info screen that reacts to the level of risk for each disease,
and shows more information to prospective parents if their child is at risk
of being a carrier or affected by the disease

 */
package poncecristianproject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author cristian_ponce
 */
public class start {

    public static void main(String[] args) {
        // Initialize ArrayList to hold parent objects
        ArrayList<Parent> parentList = new ArrayList<>();

        // Initialize genetic disease list, create sample disease list used in GUI for user
        ArrayList<GeneticDisease> diseaseList = new ArrayList<>();
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

        Scanner sc = new Scanner(System.in);  // Create Scanner object

        boolean runProgram = true;
        while (runProgram) {
            // Display switch statment menu to user
            System.out.println(""); // Seperating line
            System.out.println("Please select from the following menu of options, by typing a number:");
            System.out.println("\t 1. Launch GUI with clean models");
            System.out.println("\t 2. Enter screening results and create parent object");
            System.out.println("\t 3. Analyze risk of genetic diseases (Risk assessment must be taken first)");
            System.out.println("\t 4. Add new genetic disease");
            System.out.println("\t 5. Exit Genetic Risk Advisor.");

            int num = -1;

            while (num == -1) {
                try {
                    num = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("Please enter a number.");
                    sc.nextLine();  // Clear scanner
                }
            }

            sc.nextLine(); // Clear scanner
            switch (num) {

                case 1:  // Launch GUI with clean models
                    Parent guiFather = new Parent(true);  // Creates father, a parent object
                    Parent guiMother = new Parent(false);  // Creates mother, a parent object
                    IntroFrame program = new IntroFrame(guiFather, guiMother);  // Creates the intro frame using the parents as models
                    program.setVisible(true); // Sets frame to visible
                    break;

                case 2: // Take risk assessment
                    boolean isFather = false;
                    int[] surveyResults = new int[diseaseList.size()];
                    String userResponse = " ";
                    String parentName = " ";

                    // Get parent name
                    while (parentName.compareTo(" ") == 0) {
                        System.out.println("What is your name?");
                        parentName = sc.nextLine();
                    }

                    // Get parent gender
                    while (userResponse.compareTo(" ") == 0) {
                        try {
                            System.out.println("Are you male? (y/n)");
                            userResponse = sc.nextLine();
                            if (userResponse.compareTo("y") == 0) {
                                isFather = true;
                            } else {
                                isFather = false;
                            }
                        } catch (Exception e) {
                            System.out.println("Please enter a letter");
                            System.out.println(e.getMessage());
                        }
                    }

                    // Get all survey results for parent
                    int diseaseIndex = 0;
                    while (diseaseIndex != diseaseList.size()) {
                        try {
                            for (GeneticDisease disease : diseaseList) {
                                if (disease instanceof AutosomalRecessive) {
                                    System.out.println("Are you a carrier (1), "
                                            + "affected (2), or neither (0) by "
                                            + disease.getDiseaseType() + "?");
                                    surveyResults[diseaseIndex] = sc.nextInt();
                                } else {
                                    System.out.println("Are you affected (2), "
                                            + "not affected (0) by "
                                            + disease.getDiseaseType() + "?");
                                    surveyResults[diseaseIndex] = sc.nextInt();
                                }
                                diseaseIndex += 1;
                            }
                        } catch (Exception e) {
                            System.out.println("Please enter a number");
                            sc.nextLine(); // Clear scaner
                            diseaseIndex = 0; // Reset disease index
                        }
                    }

                    Parent newParent = new Parent(isFather);
                    newParent.setName(parentName);
                    newParent.setScreeningResults(surveyResults);
                    parentList.add(newParent);
                    System.out.println("Survey complete, object creation successful!");
                    sc.nextLine(); // Clear scanner from nextInt
                    break;

                case 3:
                    try {
                        boolean motherFound = false;
                        boolean fatherFound = false;
                        Parent mother = null;
                        Parent father = null;

                        // Get names from user
                        System.out.println("Please enter the name of the mother: ");
                        String motherName = sc.nextLine();
                        System.out.println("Please enter the name of the father: ");
                        String fatherName = sc.nextLine();

                        // Check to make sure name is contained
                        for (Parent parent : parentList) {
                            if (parent.getName().compareTo(motherName) == 0) {
                                motherFound = true;
                                mother = parent;
                            }
                            if (parent.getName().compareTo(fatherName) == 0) {
                                fatherFound = true;
                                father = parent;
                            }
                        }

                        // Print results if available
                        if ((fatherFound) && (motherFound)) {
                            System.out.println("\t\t-----ANALYSIS RESULTS-----\t\t");
                            for (GeneticDisease disease : diseaseList) {
                                System.out.println("- " + disease.diseaseReport(father, mother) + "\n");
                            }
                            break;
                        } else {
                            System.out.println(motherName + " or " + fatherName
                                    + " not created yet.");
                            break;
                        }

                    } catch (Exception e) {
                        System.out.println("Please enter a name");
                        sc.nextLine(); // Clear scanner
                    }

                    for (GeneticDisease disease : diseaseList) {
                    }
                    break;

                case 4:
                    try {
                        System.out.println("Please enter the name of the disease");
                        String diseaseName = sc.nextLine();

                        System.out.println("Please enter a description of this disease");
                        String diseaseDescription = sc.nextLine();

                        // Create object based off of type
                        System.out.println("Is the disease autodominant (y/n)");
                        String userAnswer = sc.nextLine();
                        if (userAnswer.compareTo("y") == 0) {
                            AutosomalDominant newDisease = new AutosomalDominant(diseaseName,
                                    diseaseDescription, diseaseList.size());
                            diseaseList.add(newDisease);
                        } else {
                            AutosomalRecessive newDisease = new AutosomalRecessive(diseaseName,
                                    diseaseDescription, diseaseList.size());
                            diseaseList.add(newDisease);
                        }
                    } catch (Exception e) {
                        System.out.println("Please enter a string");
                        sc.nextLine(); // Clear scanner
                    }
                    break;

                case 5:  // Exit program
                    System.out.println("Thank you for using Genetic Risk Advisor!");
                    runProgram = false;
                    break;

                default:  // Error message for invalid choice
                    System.out.println("Sorry, but you need to enter a 1, 2, 3, 4, or 5");
                    break;
            }
        }
    }
}
