package com.example.receiptbudgeterapp.ui.main.ui.finance;
import androidx.lifecycle.ViewModel;

import com.example.receiptbudgeterapp.Receipt.IReceipt;
import com.example.receiptbudgeterapp.Receipt.IReceiptFactory;
import com.example.receiptbudgeterapp.Receipt.ReceiptFactory;

import java.util.ArrayList;

public class FinanceViewModel extends ViewModel
{
    public ArrayList<IReceipt> receiptList;
    private IReceipt mFinanceData;
    private IReceiptFactory mFinanceDataFactory;

    public FinanceViewModel() //here data is saved on app destruction(some local file)
            //from there, we pass to fragment, and fragment calls adapter(assuming data is not null)
    {
        receiptList = new ArrayList<>();
        mFinanceDataFactory = new ReceiptFactory();
    }


    public ArrayList<IReceipt> GetList()
    {
        return receiptList;
    }

    public void SetList(ArrayList<IReceipt> list)
    {
        if(list != null)
        {
            receiptList = list;
        }
    }
}