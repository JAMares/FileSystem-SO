/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.filesystem;

import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Aozhen
 */
public class Directory {
    private String name;
    private String route;
    private ArrayList<Files> files;
    private ArrayList<Directory> directories;

    public Directory(String name, String route) {
        this.name = name;
        this.directories = new ArrayList<>();
        this.files = new ArrayList<>();
        this.route = route;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
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
            System.out.println("Not directories found in " + this.getName());
            return;
        }
        for (int i = 0; i < this.directories.size(); i++){
            System.out.println(this.directories.get(i).getName());
            this.directories.get(i).viewDirectories(); //View directories of directories
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
            if (this.directories.get(i).getName().equals(name))
                return this.directories.get(i);
        }
        return null;
    }
    
    //Get file
    public Files findFile(String name){
        for (int i = 0; i < this.files.size(); i++){
            if (this.files.get(i).getName().equals(name))
                return this.files.get(i);
        }
        return null;
    }

    //Modify File
    public Files modifyFile(String name, String content){
        for (int i = 0; i < this.files.size(); i++){
            if (this.files.get(i).getName() == name);
            this.files.get(i).setContent(content);
            System.out.println("File modified");
            return this.files.get(i);
        }
        System.out.println("File not found");
        return null;
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
        //System.out.println("----------VIEW-----------");
        //directory.viewDirectories();
        this.directories.add(directory);

        System.out.println("----------FOUND DIRECTORY-----------");
        //Directory n = this.directories.get(directories.size()-1);
        //n.viewDirectories();
        this.viewDirectories();
    }

    //Add files
    public void addFiles(Files file){
        this.files.add(file);
    }
    
    public void generateTree(DefaultMutableTreeNode node){
        for(Directory dir: this.directories){
            DefaultMutableTreeNode child = new DefaultMutableTreeNode(dir);
            dir.generateTree(child);
            node.add(child);
        }
        for(Files file : this.files){
            DefaultMutableTreeNode child = new DefaultMutableTreeNode(file);
            node.add(child);
        }
    }
    
   //Find file or directory route
   public ArrayList<String> Find(String target){
       ArrayList<String> rutas = new ArrayList<>();
       if(!files.isEmpty()){
           for(Integer posFile = 0; posFile < files.size(); posFile++){
               Files file = files.get(posFile);
               String parse = "*" + file.getExtent();
               if(file.getName().equals(target) || parse.equals(target)){
                   rutas.add(file.getRoute());
               }
           }
       }
       if(!directories.isEmpty()){
           for(Integer posDir = 0; posDir < directories.size(); posDir++){
               Directory dir = directories.get(posDir);
               if(dir.getName().equals(target)){
                   rutas.add(route + "/" + dir.getName());
               }
               else{
                   rutas.addAll(dir.Find(target));
               }
           }
       }
       return rutas;
   }
   
   //Remove directory
   public void RemoveDir(){
       if(!files.isEmpty()){
           files.removeAll(files);
       }
       if(!directories.isEmpty()){
           for(int posDir = 0; posDir < directories.size(); posDir++){
               directories.get(posDir).RemoveDir();
           }
           directories.removeAll(directories);
       }
   }

   //Updates all routes
   public void UpdateRoutes(String pastRoute, String newRoute){
       this.setRoute((this.route).replace(pastRoute, newRoute) + this.name + "/");
       for(int i = 0; i < this.files.size(); i++){
           String routeFile = this.files.get(i).getRoute();
           this.files.get(i).setRoute((routeFile).replace(pastRoute, this.route));
       }
       for(int i = 0; i < this.directories.size(); i++){
           this.directories.get(i).UpdateRoutes(pastRoute, this.route);
       }
    }
   
    @Override
   public String toString(){
       return this.getName();
   }
   
}
