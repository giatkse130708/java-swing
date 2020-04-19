/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giatk.dtos;

import java.sql.Date;

/**
 *
 * @author Kha Gia
 */
public class Stock {
    private int ID;
    private String name;
    private String address;
    private String dateAvailable;
    private String Note;

    public Stock(int ID, String name, String address, String dateAvailable, String Note) {
        this.ID = ID;
        this.name = name;
        this.address = address;
        this.dateAvailable = dateAvailable;
        this.Note = Note;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateAvailable() {
        return dateAvailable;
    }

    public void setDateAvailable(String dateAvailable) {
        this.dateAvailable = dateAvailable;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }
    
    
}
