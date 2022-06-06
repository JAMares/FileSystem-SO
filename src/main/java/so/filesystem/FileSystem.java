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
    
    //Creates new file
    public void createFile(String name, String extension, String content){
        Files newFile = new Files(name,content,extension);
        newFile.writeFile(this.current.getName());
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

    //Creates new directory in actual directory
    public void createDirectory(String name){
        File directory = new File(this.current.getName() + "\\" + name);

        if (directory.mkdir() == true) { 
            //this.current = new Directory(this.current.getName() + "\\" + name);
			System.out.println("Directory" + this.current.getName() + " has been created successfully."); 
		} 
		else { 
			System.out.println("Directory cannot be created.\nIt already exists."); 
		} 
    }

    //Changes current directory
    public void changeMainDir(Directory directory){
        this.current = directory;
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
