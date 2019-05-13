/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selectcontract;

/**
 *
 * @author C0373297
 */
public class Contract  {
    private String contractID, originCity, destCity,orderItem;
    public static final int NUMBER_OF_CONTRACT_ATTRIBUTES = 4;
    public static final int INDEX_OF_CONTRACT_ID = 0;
    public static final int INDEX_OF_CONTRACT_CITY = 1;
    public static final int INDEX_OF_DEST_CITY = 2;
    public static final int INDEX_OF_CONTRACT_ITEM = 3; 
    
    public Contract(String contractID,String originCity,String destCity,String orderItem){
        this.contractID=contractID;
        this.originCity=originCity;
        this.destCity=destCity;
        this.orderItem=orderItem;
    }
    
    public String getContractID(){
        return this.contractID;
    }
    public String getOriginCity(){
        return this.originCity;
    }
    public String getDestCity(){
        return this.destCity;
    }
    public String OrderItem(){
        return this.orderItem;
    }

    boolean contains(String city) {
        if(city==originCity){
            return true;
        }
        else{
            return false;
        }
    }

}
