package com.example.receiptbudgeterapp.ui.main.Misc;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.receiptbudgeterapp.R;
import com.example.receiptbudgeterapp.Receipt.IReceipt;
import com.example.receiptbudgeterapp.Receipt.ReceiptViewHolder;

import java.util.ArrayList;
import java.util.List;

public class ReceiptListAdapter extends ArrayAdapter
{

    private final Activity context;     //to reference the Activity
    private List <IReceipt> mReceiptList;

    public ReceiptListAdapter(Activity context, ArrayList<IReceipt> receiptList)
    {
        super(context, R.layout.financelist_layout, receiptList);
        this.context=context;
        this.mReceiptList = receiptList;
    }
    //the remove button would go in here,
    public View getView(final int position, View view, ViewGroup parent) //matches the properties namearray, infoarray to the listview_row style.
    {
        ReceiptViewHolder viewHolder = new ReceiptViewHolder();
        IReceipt receipt = mReceiptList.get(position);
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.financelist_layout, null,true);

        //this code gets references to objects in the listview_row.xml file
        Button deleteBtn = (Button)rowView.findViewById(R.id.ReceiptDeleteButtonID);
        viewHolder.receiptName = (TextView) rowView.findViewById(R.id.ReceiptNameID);
        viewHolder.receiptCost = (TextView) rowView.findViewById(R.id.ReceiptCostID);
        //this code sets the values of the objects to values from the arrays
        viewHolder.receiptName.setText(receipt.getReceiptName());
        viewHolder.receiptCost.setText(receipt.getReceiptCost());

        deleteBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //do something
                mReceiptList.remove(mReceiptList.get(position)); //or some other task
                notifyDataSetChanged();
            }
        });

        return rowView;
    }
}
