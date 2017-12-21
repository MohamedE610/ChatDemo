
package com.example.abdallah.chatdemo.Models.Clients;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Products implements Parcelable
{

    private List<ProductsDatum> productsData = null;
    public final static Creator<Products> CREATOR = new Creator<Products>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Products createFromParcel(Parcel in) {
            return new Products(in);
        }

        public Products[] newArray(int size) {
            return (new Products[size]);
        }

    }
    ;

    protected Products(Parcel in) {
        in.readList(this.productsData, (com.example.abdallah.chatdemo.Models.Clients.ProductsDatum.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Products() {
    }

    /**
     * 
     * @param productsData
     */
    public Products(List<ProductsDatum> productsData) {
        super();
        this.productsData = productsData;
    }

    public List<ProductsDatum> getProductsData() {
        return productsData;
    }

    public void setProductsData(List<ProductsDatum> productsData) {
        this.productsData = productsData;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(productsData);
    }

    public int describeContents() {
        return  0;
    }

}
