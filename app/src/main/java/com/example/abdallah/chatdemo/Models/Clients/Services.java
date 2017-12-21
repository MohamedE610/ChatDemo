
package com.example.abdallah.chatdemo.Models.Clients;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Services implements Parcelable
{

    private List<ServicesDatum> servicesData = null;
    public final static Creator<Services> CREATOR = new Creator<Services>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Services createFromParcel(Parcel in) {
            return new Services(in);
        }

        public Services[] newArray(int size) {
            return (new Services[size]);
        }

    }
    ;

    protected Services(Parcel in) {
        in.readList(this.servicesData, (com.example.abdallah.chatdemo.Models.Clients.ServicesDatum.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Services() {
    }

    /**
     * 
     * @param servicesData
     */
    public Services(List<ServicesDatum> servicesData) {
        super();
        this.servicesData = servicesData;
    }

    public List<ServicesDatum> getServicesData() {
        return servicesData;
    }

    public void setServicesData(List<ServicesDatum> servicesData) {
        this.servicesData = servicesData;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(servicesData);
    }

    public int describeContents() {
        return  0;
    }

}
