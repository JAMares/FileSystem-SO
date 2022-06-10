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

/**
 *
 * @author valev
 */
public class VirtualDisc {
    private Integer sectories;
    private Integer sectorSize;
    private ArrayList<String> data;
    private Integer empty; 
    
    public VirtualDisc(Integer sectories, Integer sectorSize) throws IOException{
        this.sectories = sectories;
        this.sectorSize = sectorSize;
        this.empty = sectories;
        this.data = new ArrayList();
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
    
    public void addContent(String content){
        ArrayList<String> peerSectors = new ArrayList<>();
        String contents = "0".repeat(this.sectorSize);
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

        if(this.empty >= peerSectors.size()){
            this.empty = this.empty - peerSectors.size();
            for(int i = 0; i < this.data.size(); i++){
                if(this.data.get(i).equals(contents)){
                    if(peerSectors.get(0).length() == this.sectorSize){
                        this.data.set(i, peerSectors.get(0));
                        if(peerSectors.size() == 1){
                            break;
                        } else{
                            peerSectors.remove(0);
                        }
                    } else{
                        this.data.set(i, peerSectors.get(0) + "0".repeat(this.sectorSize- peerSectors.get(0).length()));
                        break;
                    }
                }
            }
        } else{
            System.out.println("DISK IS FILL");
        }
        this.writeDisk();
    }
    
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
    }
    
    public void viewContent(){
        for(int i = 0; i < this.data.size(); i++){
            System.out.println(this.data.get(i));
        }
    }
}
