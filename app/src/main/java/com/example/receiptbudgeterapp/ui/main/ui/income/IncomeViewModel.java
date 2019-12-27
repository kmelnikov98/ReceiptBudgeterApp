package com.example.receiptbudgeterapp.ui.main.ui.income;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.receiptbudgeterapp.IncomeData.IIncomeData;
import com.example.receiptbudgeterapp.IncomeData.IIncomeDataFactory;
import com.example.receiptbudgeterapp.IncomeData.IncomeDataFactory;

import java.util.ArrayList;

public class IncomeViewModel extends ViewModel
{
    public ArrayList <IIncomeData> list;
    private MutableLiveData<String> mText;
    private IIncomeData m_incomeData;
    private IIncomeDataFactory m_incomeDataFactory;

    public IncomeViewModel()
    {
        list = new ArrayList<IIncomeData>();
        m_incomeDataFactory = new IncomeDataFactory();
        m_incomeData = m_incomeDataFactory.Create();
        mText = new MutableLiveData<>();
        mText.setValue(String.valueOf(m_incomeData.GetIncomeData()));
    }

    //save user data in viewmodel, after they changed it in the app; list creation/factory creation
    //is not done inside viewmodel. Seems likes the list/listView is worked from inside the fragment?


    public IIncomeData AddValue()
    {
        return m_incomeDataFactory.Create();
    }
    public LiveData<String> getText() { return mText; }
}