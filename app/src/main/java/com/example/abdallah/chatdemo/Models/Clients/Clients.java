
package com.example.abdallah.chatdemo.Models.Clients;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Clients implements Parcelable
{

    private List<ClientsDatum> clientsData = null;
    public final static Creator<Clients> CREATOR = new Creator<Clients>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Clients createFromParcel(Parcel in) {
            return new Clients(in);
        }

        public Clients[] newArray(int size) {
            return (new Clients[size]);
        }

    }
    ;

    protected Clients(Parcel in) {
        in.readList(this.clientsData, (com.example.abdallah.chatdemo.Models.Clients.ClientsDatum.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Clients() {
    }

    /**
     * 
     * @param clientsData
     */
    public Clients(List<ClientsDatum> clientsData) {
        super();
        this.clientsData = clientsData;
    }

    public List<ClientsDatum> getClientsData() {
        return clientsData;
    }

    public void setClientsData(List<ClientsDatum> clientsData) {
        this.clientsData = clientsData;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(clientsData);
    }

    public int describeContents() {
        return  0;
    }

}
