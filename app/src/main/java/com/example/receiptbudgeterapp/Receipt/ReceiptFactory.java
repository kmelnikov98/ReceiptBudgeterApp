package com.example.receiptbudgeterapp.Receipt;

public class ReceiptFactory implements IReceiptFactory
{
    public IReceipt Create()
    {
        return new Receipt();
    }
}
