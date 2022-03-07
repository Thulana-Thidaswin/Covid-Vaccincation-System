import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Patient {
    static Scanner input = new Scanner(System.in);
    private String age=" ";
    private String city = " ";
    private String nIC = " ";
    private String vACC=" ";
    private String name=" ";
    private String sName=" ";
    private String vac=" ";
    static int vStock = 20;
    static String boothnumber;
    /* The getters and setters are the same from task 3*/

    public Patient(String ptAge, String ptCity, String ptnIC,String ptvACC,String name, String sName,String vType) {
        
        this.age = ptAge;
        this.city = ptCity;
        this.nIC = ptnIC;
        this.vACC=ptvACC;
        this.name = name;
        this.sName = sName;
        this.vac=vType;
    }
    public Patient() {
    }
    public void setage(String ptAge) {
        this.age=ptAge;
    }
    public void setcity(String ptCity) {
        this.city=ptCity;
    }
    public void setnic(String ptnIC) {
        this.nIC=ptnIC;
    }
    public void setvacc(String ptvACC) {
        this.vACC=ptvACC;
    }
    public void setname(String name) {
        this.name=name;
    }
    public void setVac(String vType) {
        this.vac=vType;
    }
    public void setSname(String sName) {
        this.sName=sName;
    }    
    public String getage(){
        return age;
    }
    public String getcity(){
        return city;
    }
    public String getnic(){
        return nIC;
    }
    public String getvacc(){
        return vACC;
    }
    public String getname(){
        return name;
    }
    public String getSname(){
        return sName;
    }
    public String getVac(){
        return vac;
    }
}