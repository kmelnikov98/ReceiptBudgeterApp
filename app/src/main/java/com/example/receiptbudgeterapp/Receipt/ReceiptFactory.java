package com.example.receiptbudgeterapp.Receipt;

public class ReceiptFactory implements IReceiptFactory
{
    public IReceipt Create()
    {
        return new Receipt();
    }

    public IReceipt Create(String totalCost)
    {
        return new Receipt(totalCost);
    }

    public IReceipt Create(String totalCost, String receiptCount)
    {
        return new Receipt(totalCost, receiptCount);
    }
}
