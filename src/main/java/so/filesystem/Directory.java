/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.filesystem;

import java.util.ArrayList;

/**
 *
 * @author Aozhen
 */
public class Directory {
    private String name;
    private ArrayList<Files> files;
    private ArrayList<Directory> directories;

    public Directory(String name) {
        this.name = name;
        this.directories = new ArrayList<>();
        this.files = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFiles(ArrayList<Files> files) {
        this.files = files;
    }

    public void setDirectories(ArrayList<Directory> directories) {
        this.directories = directories;
    }

    //View directories
    public void viewDirectories(){
        if (this.directories.size() == 0){
            System.out.println("Not directories found.");
            return;
        }
        for (int i = 0; i < this.directories.size(); i++){
            System.out.println(this.directories.get(i).getName());
        }
    }

    //View files
    public void viewFiles(){
        if (this.files.size() == 0){
            System.out.println("Not files found.");
            return;
        }
        for (int i = 0; i < this.files.size(); i++){
            System.out.println(this.files.get(i).getName()  + ": "
            + this.files.get(i).getContent());
        }
    }

    //Get directory
    public Directory findDir(String name){
        for (int i = 0; i < this.directories.size(); i++){
            if (this.directories.get(i).getName() == name);
            return this.directories.get(i);
        }
        return null;
    }

    //Get File
    public void modifyFile(String name, String content){
        for (int i = 0; i < this.files.size(); i++){
            if (this.files.get(i).getName() == name);
            this.files.get(i).setContent(content);
            System.out.println("File modified");
            return;
        }
        System.out.println("File not found");
    }

    //Get files
    public ArrayList<Files> getFiles() {
        this.viewFiles();
        return this.files;
    }
    
    //Get directories
    public ArrayList<Directory> getDirectories() {
        this.viewDirectories();
        return this.directories;
    }

    //Add directories
    public void addDirectory(Directory directory){
        this.directories.add(directory);
    }

    //Add files
    public void addFiles(Files file){
        this.files.add(file);
    }
}
