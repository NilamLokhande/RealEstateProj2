package com.example.realestateproj;

public class Upload {
    private String mPropName;
    private String mPropDesc;
    private String mPropAddress;
    private String mPropPrice;
    private String mCountryCode;
    private String mImageUrl;
    private String mPropOwnerName;
    private String mPropOwnerMail;
    public Upload(String propName, String url, String description, String address, String price, String countrycode, String propownername, String propownermail,  String trim, String s){

    }
    public Upload(String name , String ImageUrl, String PropDesc, String PropAddress, String PropPrice, String CountryCode, String PropertyOwnerName,String PropertyOwnerMail ){

        if(name.trim().equals("")){
            name= "No Name";
        }
        mPropName=name;

        mPropDesc=PropDesc;
        mImageUrl=ImageUrl;
        mPropAddress =PropAddress;
        mPropPrice=PropPrice;
        mCountryCode=CountryCode;
        mPropOwnerName= PropertyOwnerName;
        mPropOwnerMail= PropertyOwnerMail;
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
    public String getPropOwnerName(){ return mPropOwnerName;}
    public void  setPropOwnerName(String PropertyOwnerName){ mPropOwnerName= PropertyOwnerName;}
    public String getPropOwnerMail(){ return mPropOwnerMail;}
    public void  setPropOwnerMail(String PropertyOwnerMail){ mPropOwnerMail= PropertyOwnerMail;}




}
