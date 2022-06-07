/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.filesystem;
import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.ArrayList;

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
    
    //Creates Virtual Disk
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

    //Add new directories
    public void createDirectory(String name){
        Directory newDirec = new Directory(name);
        current.addDirectory(newDirec);
    }

    //Add new files
    public void createFile(String name, String extension, String content){
        Files newFile = new Files(name,content,extension);
        current.addFiles(newFile);
    }

    //Changes current directory
    public void changeMainDir(String name){
        Directory newCurrent = this.current.findDir(name);
        if (newCurrent != null){
            this.current = newCurrent;
            System.out.println("Directory changed.\nThe new directory is: " + name);
            return;
        }
        System.out.println("Directory cannot be changed.");
    }

    //Gets current directory files
    public ArrayList<Directory> getDirectories() {
        return this.current.getDirectories();
    }

    //Gets current directory directories
    public ArrayList<Files> getFiles() {
        return this.current.getFiles();
    }
    
} 
