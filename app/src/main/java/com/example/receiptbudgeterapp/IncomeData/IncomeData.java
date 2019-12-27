package com.example.receiptbudgeterapp.IncomeData;

import com.example.receiptbudgeterapp.Receipt.IReceipt;

import java.util.List;

public class IncomeData implements IIncomeData
{
    List<IReceipt> receiptList;

    public IncomeData()
    {

    }
    public double GetIncomeData()
    {
        return 37.48;
    }


}
