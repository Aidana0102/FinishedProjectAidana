package com.example.projectaidana.models;

public enum GKPO {
    TYPE0(""),
    TYPE("125001"),
    TYPE2("125002"),
    TYPE3("125005"),
    TYPE4("125006");

 private  String displayValue;

 private GKPO(String displayValue){
     this.displayValue=displayValue;
 }

 public  String getDisplayValue(){
     return  displayValue;
 }




  private String gkpo;

    public String getGkpo() {
        return gkpo;
    }

    public void setGkpo(String gkpo) {
        this.gkpo = gkpo;
    }

}
