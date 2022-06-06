/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.filesystem;
import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors

/**
 *
 * @author Aozhen
 */
public class FileSystem {
    private Directory root;
    private Directory current;
    private Integer sectories;
    private Integer sectorSize;

    public Directory getRoot() {
        return root;
    }

    public void setRoot(Directory root) {
        this.root = root;
    }

    public Directory getCurrent() {
        return current;
    }

    public void setCurrent(Directory current) {
        this.current = current;
    }

    public Integer getSectories() {
        return sectories;
    }

    public void setSectories(Integer sectories) {
        this.sectories = sectories;
    }

    public Integer getSectorSize() {
        return sectorSize;
    }

    public void setSectorSize(Integer sectorSize) {
        this.sectorSize = sectorSize;
    }

    public FileSystem() {
        this.root = new Directory("root");
        this.current = root;
    }
    
    public void createVD(Integer sectories, Integer sectorSize) throws IOException{
        this.sectories = sectories;
        this.sectorSize = sectorSize;
        File disk = new File("disk.txt");
        try {
            disk.createNewFile();
            FileWriter writer = new FileWriter(disk);
            for(Integer i = 0; i < sectorSize*sectories; i++){
                writer.write("0");
            }
            writer.close();
        } catch (Exception e) {
        }
    }
    
    public static void main(String args[]) throws IOException{
        FileSystem system = new FileSystem();
        system.createVD(3, 4);
    }
    
} 
