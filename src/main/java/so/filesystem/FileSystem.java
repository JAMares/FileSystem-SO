/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.filesystem;
import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

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
        this.root = new Directory("root", "root/");
        this.current = root;
    }
    
    //Creates Virtual Disk
    /*public void createVD(Integer sectories, Integer sectorSize) throws IOException{
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
    }*/

    //Add new directories
    public Directory createDirectory(String name){
        if (current.findDir(name) == null){
            Directory newDirec = new Directory(name, current.getRoute() + name + "/");
            current.addDirectory(newDirec);
            return newDirec;
        }
        return null;
    }

    //Add new files
    public Files createFile(String name, String extension, String content){
        if(current.findFile(name) == null){
            Files newFile = new Files(name,content,extension, current.getRoute() + name + extension);
            current.addFiles(newFile);
            return newFile;            
        }
        return null;
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

    //Modifies file
    public void modifyFile(String name, String newContent){
        this.current.modifyFile(name,newContent);
    }
    
    
    //Show file properties
    public void showFileProperties(Files file){
        System.out.println("Name: " + file.getName());
        System.out.println("Extent: " + file.getExtent());
        
        LocalDateTime creation = file.getCreation();
        LocalDateTime modification = file.getModification();
        DateTimeFormatter formatC = DateTimeFormatter.ISO_DATE;
        DateTimeFormatter formatM = DateTimeFormatter.ISO_DATE;
        String creationString = creation.format(formatC);
        String modificationString = modification.format(formatM);
        
        System.out.println("Creation: " + creationString);
        System.out.println("Modification: " + modificationString);
        System.out.println("Size: " + file.getContent().length());
    }
    
    //Show file content
    public void showFileContent(Files file){
        System.out.println("Content: " + file.getContent());
    }
    
    //Find route list
    public ArrayList<String> FindRouteList(String target){
        ArrayList<String> directions = new ArrayList<>();
        directions.addAll(root.Find(target));
        System.out.println("Rutas encontradas"); //Mensaje de prueba
        for(int pos = 0; pos < directions.size(); pos++){
            System.out.println(directions.get(pos));
        }
        return directions;
    }
    
    //Parse the route to get the roadmap
    public ArrayList<String> parserRoute(String route){
        String[] dirs = route.split("/");
        ArrayList<String> road = new ArrayList<>(Arrays.asList(dirs));
        return road;
    }
    
    //Find the file by roadmap
    public Files findFileRoute(ArrayList<String> roadmap){
        roadmap.remove(0);
        Directory road = root;
        System.out.println(roadmap.size());
        while(!roadmap.isEmpty()){
            if(roadmap.size() == 1){
                for(int pos = 0; pos < road.getFiles().size(); pos++){
                    Files file = road.getFiles().get(pos);
                    String name = file.getName() + file.getExtent();
                    if(name.equals(roadmap.get(0))){
                        return file;
                    }
                }
            } else {
                road = road.findDir(roadmap.get(0));
                roadmap.remove(0);
            }
        }
        return null;
    }
    
    //Find the Directory by roadmap
    public Directory findDirRoute(ArrayList<String> roadmap){
        if(roadmap.size() == 1)
            return root;
        roadmap.remove(0);
        Directory road = root;
        while(!roadmap.isEmpty()){
            if(roadmap.size() == 1){
                Directory dir = road.findDir(roadmap.get(0));
                if(dir != null)
                    return dir;
            } else {
                road = road.findDir(roadmap.get(0));
                roadmap.remove(0);
            }
        }
        return null;
    }
    
    //Remove File or Dir
    public void ReMove(String target, boolean isDir){
        if(isDir){
            for(int pos = 0; pos < current.getDirectories().size(); pos++){
                Directory dir = current.getDirectories().get(pos);
                if(dir.getName().equals(target)){
                    dir.RemoveDir();
                    current.getDirectories().remove(pos);
                    break;
                }
            }
        }
        else {
            for(int pos = 0; pos < current.getFiles().size(); pos++){
                Files file = current.getFiles().get(pos);
                if(file.getName().equals(target)){
                    current.getFiles().remove(pos);
                    file.setContent(null);
                    break;
                }
            }
        }
    }
    
    private boolean sameRoute(ArrayList<String> origin, ArrayList<String> goal){
        int originSize = origin.size();
        int goalSize = goal.size();
        if(originSize != goalSize)
            return false;
        else{
            for(int pos = 0; pos < originSize-1; pos++){
                if(!origin.get(pos).equals(goal.get(pos)))
                    return false;
            }
        }
        return true;
    }
    
    public void Move(String routeOrigin, String routeGoal, boolean isDir){
        ArrayList<String> originRoad = parserRoute(routeOrigin);
        ArrayList<String> goalRoad = parserRoute(routeGoal);
        ArrayList<String> setRoute = parserRoute(routeGoal);

        
        System.out.println("Hizo el parseo");
        
        int originSize = originRoad.size();
        int goalSize = goalRoad.size();
        Directory tmpDir = current;
        
            
        if(!isDir){
            ArrayList<String> copyRoad = new ArrayList<>();
            copyRoad.addAll(originRoad);
            Files old = findFileRoute(copyRoad);
            
            String[] oldName = goalRoad.get(goalSize-1).split("\\.");
            String newName = oldName[0];
            
            if(sameRoute(originRoad, goalRoad)){//Rename      
                goalRoad.remove(goalSize-1);
                System.out.println("Entro en File/Rename");
                
                if(goalRoad.size() > 1){
                    this.current = findDirRoute(goalRoad);
                    this.current.addFiles(old);
                    this.current = tmpDir;
                }
                else {
                    this.current.addFiles(old);
                }   
            } 
            else {      
                goalRoad.remove(goalSize-1);
                System.out.println("Entro en File/Move");
                this.current = findDirRoute(goalRoad);
                this.current.addFiles(old);
                originRoad.remove(originSize-1);
                this.current = findDirRoute(originRoad);
                this.current = tmpDir;   
            }
            old.setName(newName);
            old.setRoute(routeGoal.split("\\.")[0] + old.getExtent());
        }
        else{
            ArrayList<String> copyRoad = new ArrayList<>();
            copyRoad.addAll(originRoad);
            
            System.out.println("Entro en Dir/Move");
            Directory dirOrigin = findDirRoute( copyRoad);
            Directory dirGoal = findDirRoute(goalRoad);
            dirOrigin.UpdateRoutes(dirOrigin.getRoute(),dirGoal.getRoute());
            dirGoal.addDirectory(dirOrigin);
            this.current = findDirRoute(originRoad);
            this.current = tmpDir;
        }
        
    }
    
} 
