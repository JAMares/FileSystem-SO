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

    //Get files
    public ArrayList<Files> getFiles() {
        return this.files;
    }
    
    //Get directories
    public ArrayList<Directory> getDirectories() {
        return this.directories;
    }
}
