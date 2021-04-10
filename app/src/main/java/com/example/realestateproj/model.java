package com.example.realestateproj;

public class model {
    private String mPropName;
    private String mPropDesc;
    private String mPropAddress;
    private String mPropPrice;
    private String mCountryCode;
    private String mImageUrl;
    private String mPropOwnerName;

    public String getmPropOwnerName() {
        return mPropOwnerName;
    }

    public void setmPropOwnerName(String mPropOwnerName) {
        this.mPropOwnerName = mPropOwnerName;
    }

    public String getmPropOwnerMail() {
        return mPropOwnerMail;
    }

    public void setmPropOwnerMail(String mPropOwnerMail) {
        this.mPropOwnerMail = mPropOwnerMail;
    }

    private String mPropOwnerMail;
    public model(){

    }
    public model(String name , String ImageUrl, String PropDesc, String PropAddress, String PropPrice, String CountryCode, String PropertyOwnerName,String PropertyOwnerMail ){

        if(name.trim().equals("")){
            name= "No Name";
        }
        mPropName=name;
        mPropDesc=PropDesc;
        mImageUrl=ImageUrl;
        mPropAddress =PropAddress;
        mPropPrice=PropPrice;
        mCountryCode=CountryCode;
        mPropOwnerName = PropertyOwnerName;
        mPropOwnerMail = PropertyOwnerMail;
    }

    public String getName(){
        return mPropName;
    }
    public void setName(String name){
        mPropName=name;
    }
    public String getPropDesc(){
        return mPropDesc;
    }
    public void setPropDesc(String PropDesc){
        mPropDesc=PropDesc;
    }
    public String getUrl(){
        return mImageUrl;
    }
    public void setUrl(String ImageUrl){
        mImageUrl=ImageUrl;
    }
    public String getAddress(){
        return mPropAddress; }
    public void setAddress(String PropAddress){ mPropAddress=PropAddress; }
    public String getPrice(){return mPropPrice;}
    public void setPrice(String PropPrice){
        mPropPrice= PropPrice;
    }
    public String getCCode(){
        return mCountryCode;
    }
    public void setCCode(String CountryCode){
        mCountryCode= CountryCode;
    }



}