package com.chnu.moodleleadertest.test;

import android.util.Log;

import com.chnu.moodleleadertest.dao.Answer;
import com.chnu.moodleleadertest.dao.Result;
import com.chnu.moodleleadertest.data.Data;
import com.chnu.moodleleadertest.data.ResultObject;

import java.util.ArrayList;

/**
 * Created by a2881dante on 25.05.2017.
 */

public class MBTItest {

    public static void testing(ArrayList<Answer> answers){
        int size = answers.size();
        Result result = new Result();
        for(int i=0; i<Data.descriptors.length; i++){
            for(int j=0; j<Data.descriptors[i].getSymbols().length; j++){
                for(int k=0; k<Data.descriptors[i].getIdQ().length; k++){
                    if(Data.descriptors[i].getIdQ()[k]<size){
                        Answer answer = answers.get(Data.descriptors[i].getIdQ()[k]-1);
                        result.resValue[i][j] += (j==0)?answer.getA1():answer.getA2();
                    }
                }
            }
        }
        for(int i=0; i<Data.descriptors.length; i++){
            float sum = result.resValue[i][0]+result.resValue[i][1];
            Log.w("value", sum+" ");
            float temp = (((float)result.resValue[i][0])/sum)*100;
            result.resValue[i][0] = (int)temp;
            temp = (((float)result.resValue[i][1])/sum)*100;
            result.resValue[i][1] = (int)temp;
        }
        for(int i=0; i<Data.descriptors.length; i++){
            Log.w("value", result.resValue[i][0]+" "+result.resValue[i][1]);
        }
        String s = "";
        for(int i=0; i<Data.descriptors.length; i++){
            s = s + ((result.resValue[i][0]>result.resValue[i][1])
                    ?result.resKey[i][0]:result.resKey[i][1]);
        }
        Log.w("person-type", s);
        result.type = s;
        for(int i=0; i<Data.pages.length; i++){
            if(s.equals(Data.pages[i])){
                result.page = i;
            }
        }
        Log.w("page", result.page+"");
        ResultObject.result = result;
    }

}
