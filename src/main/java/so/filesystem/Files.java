/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.filesystem;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author Aozhen
 */
public class Files {
    private String name;
    private String content;
    private String extent;
    private ArrayList<Integer> sectors;
    private LocalDateTime creation;
    private LocalDateTime modification;
    
    
   
    public Files(String name, String content, String extent) {
        this.name = name;
        this.content = content;
        this.extent = extent;
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
    
    public void writeFile(String currentDir){
        File newFile = new File(currentDir + "\\" + this.name + this.extent);
        try {
            newFile.createNewFile();
            FileWriter writer = new FileWriter(newFile);
            writer.write(this.content);
            writer.close();
            System.out.println("File " + this.name + this.extent + " has been created");
        } catch (Exception e) {
            System.out.println("File " + this.name + this.extent + " cannot be created");
        }
    }
    
}
