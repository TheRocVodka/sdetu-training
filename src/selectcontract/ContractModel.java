/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selectcontract;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author C0373297
 */ 
class ContractModel {
    private SortedSet<String>originCityList;
    private ArrayList<Contract> theContracts;
        private ArrayList<Contract> theContractsAll;
    private int contractCounter;
    
     public ContractModel() throws FileNotFoundException, IOException{
         originCityList= new TreeSet();
         this.contractCounter=0;
         this.theContracts=new ArrayList<>();
     
         for(int i=0;i<theContracts.size();i++){
              originCityList.add(theContracts.get(i).getOriginCity());
              if(i==3){
                  originCityList.add("All");
              }
         }
        
        
         
         
         try{
             String filename="C:\\Users\\karnd\\Documents\\Downloads\\SelectContract\\contracts.txt";
FileReader fileReader ;
             fileReader = new FileReader(filename);
BufferedReader bufferedReader = new BufferedReader(fileReader);
String line;
while((line = bufferedReader.readLine()) != null) {

String[] tokens = line.split(",", 4);
String contractID = tokens[0];
String originCity = tokens[1]; 
String destCity = tokens[2]; 
String orderItem = tokens[3]; 
Contract dataContract = new Contract(contractID
, originCity 
, destCity 
, orderItem);
theContracts.add(dataContract); 

} 
fileReader.close();
 theContractsAll=new ArrayList<>(theContracts);
         }
catch (IOException ex) {
System.out .println(ex.getMessage());}
         
         
     
     
    
    
}
    
     
    
    public String[] getOriginCity(){
        String[]a;
        a=originCityList.toArray(new String[originCityList.size()]);
        return a;
    }
    
    public void updateContractList(String city){
        theContracts= new ArrayList<>(theContractsAll);
        if(city!="All"){
            theContracts.removeIf(s->!s.contains(city));
        }
        contractCounter=0;
    }
            
            
            
   public boolean foundContracts() {
if(theContracts.size()>0){
    return true;
}
else{
    return false;
}
}
public Contract getTheContract() {
 return theContracts.get(this.contractCounter);

}
public int getContractCount() {
    int a=theContracts.size();
return a;
} 

public int getCurrentContractNum() {

return contractCounter;
}
public void nextContract() {
    try{
          Contract c=theContracts.get(contractCounter+1);
          contractCounter=contractCounter+1;
    }catch(Exception e){
        System.out.println("nextContract=false");
    }
  
    
// .. increment contractCounter but only if doing so does not make it an invalid value …
}
public void prevContract() {
try{
          Contract c=theContracts.get(contractCounter-1);
          contractCounter=contractCounter-1;
    }catch(Exception e){
        System.out.println("prevContract=false");
    }
}




}

