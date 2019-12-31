package com.example.receiptbudgeterapp.Receipt;

public interface IReceiptFactory
{
    IReceipt Create();

    IReceipt Create(String totalCost);

    IReceipt Create(String totalCost, String receiptCount);
}
