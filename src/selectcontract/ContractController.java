/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selectcontract;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 *
 * @author C0373297
 */
class ContractController {
private ContractView theView;
private ContractModel theModel;


public ContractController(ContractView theView,ContractModel theModel){
this.theView.addcomboBoxListener(new ComboListner());
this.theView=theView;    
this.theModel=theModel;
this.theView.addPrevListener(new PrevButtonListener());
this.theView.addBidListener(new BidButtonListener());
this.theView.addNextListener(new NextButtonListener());
setUpDisplay();
}
private void setUpDisplay(){
    try{
        
        if(theModel.foundContracts()){
            Contract c;
            c = theModel.getTheContract();
             theView.setContractID(c.getContractID());
        theView.setDestCity(c.getDestCity());
        theView.setOriginCity(c.getOriginCity());
        theView.setOrderItem(c.OrderItem());
        String s=c.OrderItem();
            String x=String.valueOf(s);
        theView.updateContractViewPanel(theModel.getCurrentContractNum(),theModel.getContractCount());
        }
        else{
               theView.setContractID("???");
        theView.setDestCity("???");
        theView.setOriginCity("???");
        theView.setOrderItem("???");
        }
        
    } catch (Error ex){
        System.out.println(ex);
        theView.displayErrorMessage("ERROR: There was a problem setting the contract .\n");
    }
}
class PrevButtonListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
        if(theModel.getCurrentContractNum()==0){
            return;
        }
        try{
            theModel.prevContract();
            
        }catch(Exception ex){
            System.out.println(ex);
            theView.displayErrorMessage("Error: There is a problem setting a previous contact.");
        }
        setUpDisplay();
    }
    
    
}
class NextButtonListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
        if(theModel.getCurrentContractNum()==0){
           
        }
        try{
            
            theModel.nextContract();
            
        }catch(Exception ex){
            System.out.println(ex);
            theView.displayErrorMessage("Error: There is a problem setting a next contact.");
        }
        setUpDisplay();
    }
    
    
}

class ComboListner implements ItemListener{
   

        @Override
        public void itemStateChanged(ItemEvent e) {
            System.out.println(e.getItem().toString());
            if(e.getStateChange()==ItemEvent.SELECTED){
                String selectedCity=e.getItem().toString();
                System.out.println(selectedCity);
                theModel.updateContractList(selectedCity);
                setUpDisplay();
            }
        }
    }




class BidButtonListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
        if(theModel.getCurrentContractNum()==0){
            return;
        }
        try{
            
            
        }catch(Exception ex){
            System.out.println(ex);
            theView.displayErrorMessage("Error: There is a problem setting a bid contact.");
        }
        setUpDisplay();
    }
    
    
}

//made this method

}
