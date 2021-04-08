package com.example.realestateproj;

public class Upload {
    String Description,PropName, purl;
    public Upload(String trim, String s){

    }
    public Upload(String PropName, String Description,String purl){

        if(PropName.trim().equals("")){
            PropName= "No Name";
        }
        this.Description=Description;
        this.PropName=PropName;
        this.purl=purl;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    public String getPropName() {
        return PropName;
    }

    public void setPropName(String PropName) {
        this.PropName = PropName;
    }
    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }

}
