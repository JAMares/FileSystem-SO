/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.filesystem;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Aozhen
 */
public class Files {
    private String name;
    private String content;
    private String extent;
    private String route;
    private ArrayList<Integer> sectors;
    private LocalDateTime creation;
    private LocalDateTime modification;

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }
    
    public Files(String name, String content, String extent, String route) {
        this.name = name;
        this.content = content;
        this.extent = extent;
        this.route = route;
        this.creation = LocalDateTime.now();
        this.modification = LocalDateTime.now();
        this.sectors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getExtent() {
        return extent;
    }

    public void setExtent(String extent) {
        this.extent = extent;
    }

    public ArrayList<Integer> getSectors() {
        return sectors;
    }

    public void setSectors(ArrayList<Integer> sectors) {
        this.sectors = sectors;
    }

    public LocalDateTime getCreation() {
        return creation;
    }

    public void setCreation(LocalDateTime creation) {
        this.creation = creation;
    }

    public LocalDateTime getModification() {
        return modification;
    }

    public void setModification(LocalDateTime modification) {
        this.modification = modification;
    }
    
    //Write in a file
    public void writeFile(String content){
        this.modification = LocalDateTime.now();
        this.content = content;
    }

    //Read current file
    public String readFile(){
        return this.content;
    }
    
    @Override
    public String toString(){
        return this.getName()+this.getExtent();
    }
    
}
