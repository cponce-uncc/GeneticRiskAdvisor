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
public class Parent {

    private int[] screeningResults = {0, 0, 0, 0};
    private String name;
    private boolean isFather;

    public Parent(boolean isFather) {
        this.isFather = isFather;
    }

    /**
     * Get the value of isFather
     *
     * @return the value of isFather
     */
    public boolean getIsFather() {
        return isFather;
    }

    /**
     * Set the value of isFather
     *
     * @param isFather new value of isFather
     */
    public void setIsFather(boolean isFather) {
        this.isFather = isFather;
    }

    /**
     * Get the value of screeningResults
     *
     * @return the value of screeningResults
     */
    public int[] getScreeningResults() {
        return screeningResults;
    }

    /**
     * Set the value of screeningResults
     *
     * @param screeningResults new value of screeningResults
     */
    public void setScreeningResults(int[] screeningResults) {
        this.screeningResults = screeningResults;
    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    public void setIndex(int index, int code) {
        this.screeningResults[index] = code;
    }

}
