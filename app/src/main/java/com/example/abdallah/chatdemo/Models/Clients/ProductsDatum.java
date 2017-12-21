
package com.example.abdallah.chatdemo.Models.Clients;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ProductsDatum implements Parcelable
{

    private Integer id;
    private String arName;
    private String enName;
    private String arDescription;
    private String enDescription;
    private String logo;
    public final static Creator<ProductsDatum> CREATOR = new Creator<ProductsDatum>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ProductsDatum createFromParcel(Parcel in) {
            return new ProductsDatum(in);
        }

        public ProductsDatum[] newArray(int size) {
            return (new ProductsDatum[size]);
        }

    }
    ;

    protected ProductsDatum(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.arName = ((String) in.readValue((String.class.getClassLoader())));
        this.enName = ((String) in.readValue((String.class.getClassLoader())));
        this.arDescription = ((String) in.readValue((String.class.getClassLoader())));
        this.enDescription = ((String) in.readValue((String.class.getClassLoader())));
        this.logo = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public ProductsDatum() {
    }

    /**
     * 
     * @param id
     * @param logo
     * @param enDescription
     * @param enName
     * @param arName
     * @param arDescription
     */
    public ProductsDatum(Integer id, String arName, String enName, String arDescription, String enDescription, String logo) {
        super();
        this.id = id;
        this.arName = arName;
        this.enName = enName;
        this.arDescription = arDescription;
        this.enDescription = enDescription;
        this.logo = logo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArName() {
        return arName;
    }

    public void setArName(String arName) {
        this.arName = arName;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getArDescription() {
        return arDescription;
    }

    public void setArDescription(String arDescription) {
        this.arDescription = arDescription;
    }

    public String getEnDescription() {
        return enDescription;
    }

    public void setEnDescription(String enDescription) {
        this.enDescription = enDescription;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(arName);
        dest.writeValue(enName);
        dest.writeValue(arDescription);
        dest.writeValue(enDescription);
        dest.writeValue(logo);
    }

    public int describeContents() {
        return  0;
    }

}
