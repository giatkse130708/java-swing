/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giatk.dtos;

/**
 *
 * @author Kha Gia
 */
public class Supplier {
    private String supCode;
    private String supName;
    private String supAddress;
    private boolean supColloborating;

    public Supplier(String supCode, String supName, String supAddress, boolean supColloborating) {
        this.supCode = supCode;
        this.supName = supName;
        this.supAddress = supAddress;
        this.supColloborating = supColloborating;
    }

    public Supplier(String supCode, String supName) {
        this.supCode = supCode;
        this.supName = supName;
    }
    

    public String getSupCode() {
        return supCode;
    }

    public void setSupCode(String supCode) {
        this.supCode = supCode;
    }

    public String getSupName() {
        return supName;
    }

    public void setSupName(String supName) {
        this.supName = supName;
    }

    public String getSupAddress() {
        return supAddress;
    }

    public void setSupAddress(String supAddress) {
        this.supAddress = supAddress;
    }

    public boolean isSupColloborating() {
        return supColloborating;
    }

    public void setSupColloborating(boolean supColloborating) {
        this.supColloborating = supColloborating;
    }
    
    
}
