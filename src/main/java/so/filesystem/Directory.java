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

    public ArrayList<Files> getFiles() {
        return files;
    }

    public void setFiles(ArrayList<Files> files) {
        this.files = files;
    }

    public ArrayList<Directory> getDirectories() {
        return directories;
    }

    public void setDirectories(ArrayList<Directory> directories) {
        this.directories = directories;
    }
    
    
    
}
