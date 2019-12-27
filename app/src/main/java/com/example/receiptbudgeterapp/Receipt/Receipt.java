package com.example.receiptbudgeterapp.Receipt;

import android.os.Parcel;
import android.os.Parcelable;

public class Receipt implements IReceipt, Parcelable
{
    private String mReceiptName;
    private String mReceiptCost;


    public Receipt()
    {

    }

    public String getReceiptCost()
    {
        mReceiptCost = "200";
        return mReceiptCost;
    }

    public String getReceiptName()
    {
        mReceiptName = "Receipt";
        return mReceiptName;
    }

    public static final Creator CREATOR = new Creator()
    {
        public Receipt createFromParcel(Parcel in)
        {
            return new Receipt(in);
        }

        public Receipt[] newArray(int size)
        {
            return new Receipt[size];
        }
    };


    public Receipt(Parcel in)
    {
        this.mReceiptName = in.readString();
        this.mReceiptCost = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(this.mReceiptCost);
        dest.writeString(this.mReceiptName);
    }

    @Override
    public int describeContents() {
        return 0;
    }

}
