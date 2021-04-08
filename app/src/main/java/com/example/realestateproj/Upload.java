package com.example.realestateproj;

public class Upload {
    private String mPropName;
    private String mPropDesc;
    private String mImageUrl;
    public Upload(String trim, String s){

    }
    public Upload(String name , String ImageUrl, String PropDesc){

        if(name.trim().equals("")){
            name= "No Name";
        }
        mPropName=name;

        mPropDesc=PropDesc;
        mImageUrl=ImageUrl;
    }

    public String getName(){
        return mPropName;
    }
    public void setName(String name){
        mPropName=name;
    }
    public String getDesc(){
        return mPropDesc;
    }
    public void setDesc(String PropDesc){
        mPropDesc=PropDesc;
    }
    public String getUrl(){
        return mImageUrl;
    }
    public void setUrl(String ImageUrl){
        mImageUrl=ImageUrl;
    }

}
