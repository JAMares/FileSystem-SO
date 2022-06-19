/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.filesystem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

/**
 *
 * @author valev
 */
public class VirtualDisc {
    private Integer sectories;
    private Integer sectorSize;
    private ArrayList<String> data;
    private Integer empty; 
    Map<Files, ArrayList<Integer>> map;
    
    public VirtualDisc(Integer sectories, Integer sectorSize) throws IOException{
        this.sectories = sectories;
        this.sectorSize = sectorSize;
        this.empty = sectories;
        this.data = new ArrayList<>();
        this.map = new HashMap<Files, ArrayList<Integer>>();
        File disk = new File("disk.txt");
        try {
            disk.createNewFile();
            FileWriter writer = new FileWriter(disk);
            for(Integer i = 0; i < sectories; i++){
                String arrayData = "";
                for(Integer j = 0; j < sectorSize; j++){
                    arrayData = arrayData + "0";
                    writer.write("0");
                }
                this.data.add(arrayData);
            }
            writer.close();
        } catch (Exception e) {
        }
    }

    public ArrayList<String> classify(String content){
        ArrayList<String> peerSectors = new ArrayList<>();
        while (content != ""){
            if(this.sectorSize < content.length()){
                peerSectors.add(content.substring(0,this.sectorSize));
                content = content.substring(this.sectorSize,content.length());
            }
            else{
                 peerSectors.add(content);
                 content = "";
            }
        }
        return peerSectors;
    }
    
    public boolean addContent(String content, Files file){
        ArrayList<String> peerSectors = new ArrayList<>();
        peerSectors = classify(content);
        String contents = "0".repeat(this.sectorSize);
        ArrayList<Integer> indexes = new ArrayList<>();

        if(this.empty >= peerSectors.size()){
            this.empty = this.empty - peerSectors.size();

            for(int i = 0; i < this.data.size(); i++){
                if(this.data.get(i).equals(contents)){
                    if(peerSectors.get(0).length() == this.sectorSize){
                        this.data.set(i, peerSectors.get(0));
                        indexes.add(i);

                        if(peerSectors.size() == 1){ //last sector
                            break;
                        } else{
                            peerSectors.remove(0); //remove from array
                        }
                    } else{
                        this.data.set(i, peerSectors.get(0) + "0".repeat(this.sectorSize- peerSectors.get(0).length()));
                        indexes.add(i);
                        break;
                    }
                }
            }

        } else{
            return false;
        }
        this.map.put(file, indexes);
        this.writeDisk();
        return true;
    }
    
    //writes in disk
    public void writeDisk(){
        File disk = new File("disk.txt");
        try {
            disk.createNewFile();
            FileWriter writer = new FileWriter(disk);
            for(Integer i = 0; this.data.size() > i; i++){
                writer.write(this.data.get(i));
            }
            writer.close();
        } catch (Exception e) {
        }
        //viewContent();
    }
    
    //View Virtual disk content
    public void viewContent(){
        for(int i = 0; i < this.data.size(); i++){
            System.out.println(this.data.get(i));
        }
    }

    public void replaceSameSize(ArrayList<String> peerSectors, ArrayList<Integer> indexes, Files file){
        int count = 0;
        while(indexes.size() != count){
            if(peerSectors.get(0).length() == this.sectorSize){
                this.data.set(indexes.get(count), peerSectors.get(0));
                if(peerSectors.size() == 1){
                    break;
                }
                peerSectors.remove(0);
            }
            else{
                this.data.set(indexes.get(count), peerSectors.get(0) + "0".repeat(this.sectorSize- peerSectors.get(0).length()));
                break;
            }
            count = count + 1;
        }
    }

    //Modify File
    public boolean replaceData(Files file, String newInsertion){
        ArrayList<String> peerSectors = new ArrayList<>();
        peerSectors = classify(newInsertion);
        String contents = "0".repeat(this.sectorSize);
        ArrayList<Integer> indexes = new ArrayList<>();
        indexes = map.get(file);

        if(peerSectors.size() == indexes.size()){
            //Insert in actual indexes
            replaceSameSize(peerSectors, indexes, file);
            file.setContent(newInsertion);
        }
        else{
            if(peerSectors.size() > indexes.size() && this.empty >= (peerSectors.size() - indexes.size())){
                file.setContent(newInsertion);
                this.empty = this.empty - (peerSectors.size() - indexes.size());

                //Insert in actual indexes
                replaceSameSize(peerSectors, indexes, file);

                //Find new indexes
                for(int i = 0; i < this.data.size(); i++){
                    if(this.data.get(i).equals(contents)){
                        if(peerSectors.get(0).length() == this.sectorSize){
                            this.data.set(i, peerSectors.get(0));
                            indexes.add(i);

                            if(peerSectors.size() == 1){ //last sector
                                break;
                            } else{
                                peerSectors.remove(0); //remove from array
                            }
                        } else{
                            this.data.set(i, peerSectors.get(0) + "0".repeat(this.sectorSize- peerSectors.get(0).length()));
                            indexes.add(i);
                            break;
                        }
                    }
                }

                this.map.replace(file, indexes);
            }
            else if(peerSectors.size() < indexes.size() && this.empty >= (peerSectors.size() - indexes.size())){
                file.setContent(newInsertion);
                for(int i = indexes.size()-1; i+1 > peerSectors.size(); i--){
                    data.set(indexes.get(i), contents);
                    indexes.remove(i);
                }
                replaceSameSize(peerSectors, indexes, file);
            }
            else{
                return false;
            }
        }
        this.writeDisk();
        return true;
    }

    //Delete from disk
    public void deleteFile(Files file){
        String contents = "0".repeat(this.sectorSize);
        ArrayList<Integer> indexes = new ArrayList<>();
        for (Iterator<Map.Entry<Files, ArrayList<Integer>>> entries = map.entrySet().iterator(); entries.hasNext(); ) {
            Map.Entry<Files, ArrayList<Integer>> entry = entries.next();
            if(entry.getKey().getName() == file.getName() && entry.getKey().getRoute() == file.getRoute()){
                indexes = entry.getValue();
                break;
            }
	}
        while(indexes.size() != 0){
            data.set(indexes.get(0), contents);

            if(indexes.size() == 1){
                break;
            }
            indexes.remove(0);
        }
        this.map.remove(file);
        this.writeDisk();
    }
   
    
}
