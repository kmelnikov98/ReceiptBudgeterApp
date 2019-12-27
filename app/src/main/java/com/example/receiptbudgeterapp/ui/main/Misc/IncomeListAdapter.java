package com.example.receiptbudgeterapp.ui.main.Misc;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.receiptbudgeterapp.R;

public class IncomeListAdapter extends ArrayAdapter
{

    private final Activity context;     //to reference the Activity
    private final String[] nameArray;   //to store the list of countries
    private final String[] infoArray;   //to store the list of countries

    public IncomeListAdapter(Activity context, String[] nameArrayParam, String[] infoArrayParam)
    {
        super(context, R.layout.listview_row , nameArrayParam);
        this.context=context;
        this.nameArray = nameArrayParam;
        this.infoArray = infoArrayParam;
    }

    //getView is called after every single time setAdapter is called.
    public View getView(int position, View view, ViewGroup parent) //matches the properties namearray, infoarray to the listview_row style.
    {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.listview_row, null,true);

        //this code gets references to objects in the listview_row.xml file
        TextView nameTextField = (TextView) rowView.findViewById(R.id.nameTextViewID);
        TextView infoTextField = (TextView) rowView.findViewById(R.id.infoTextViewID);
        //this code sets the values of the objects to values from the arrays
        nameTextField.setText(nameArray[position]);
        infoTextField.setText(infoArray[position]);

        return rowView;
    }
}
