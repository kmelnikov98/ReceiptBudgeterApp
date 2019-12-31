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

    public Receipt(String totalCost)
    {
        mReceiptCost = totalCost;
    }

    public Receipt(String totalCost, String receiptCount)
    {
        mReceiptCost = totalCost;
        mReceiptName = "Receipt " + receiptCount;
    }


    public String getReceiptCost()
    {
        return mReceiptCost;
    }

    public String getReceiptName()
    {
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
