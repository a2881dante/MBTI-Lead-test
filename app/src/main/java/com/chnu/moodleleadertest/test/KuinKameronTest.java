package com.chnu.moodleleadertest.test;

import com.chnu.moodleleadertest.data.ResultObject;

/**
 * Created by a2881dante on 30.09.2017.
 */

public class KuinKameronTest {

    public static final int TYPE_LEADER = 0;
    public static final int TYPE_EMPLOY = 1;

    public static final String[] NAMES_CULTURE = {"Клан", "Адхократия", "Рынок", "Бюрократия"};
    public static final String[] NAMES_AXES = {"Гибкость и дискретност"
            , "Стабильность и контроль"
            , "Внутрений фокус и интеграция"
            , "Внешняя направленость и дефференция"};

    public static int[] getCultures(int type){
        int[] res = new int[4];
        if(type==TYPE_LEADER){
            res[0] = (ResultObject.result.resValue[0][1]+ResultObject.result.resValue[1][1]
                    +ResultObject.result.resValue[2][1]+ResultObject.result.resValue[3][0])/4;
            res[1] = (ResultObject.result.resValue[0][0]+ResultObject.result.resValue[1][1]
                    +ResultObject.result.resValue[2][1]+ResultObject.result.resValue[3][1])/4;
            res[2] = (ResultObject.result.resValue[0][0]+ResultObject.result.resValue[1][0]
                    +ResultObject.result.resValue[2][0]+ResultObject.result.resValue[3][1])/4;
            res[3] = (ResultObject.result.resValue[0][1]+ResultObject.result.resValue[1][0]
                    +ResultObject.result.resValue[2][1]+ResultObject.result.resValue[3][0])/4;
        }else if(type==TYPE_EMPLOY){
            res[0] = (ResultObject.result.resValue[0][1]+ResultObject.result.resValue[1][1]
                    +ResultObject.result.resValue[2][1]+ResultObject.result.resValue[3][0])/4;
            res[1] = (ResultObject.result.resValue[0][1]+ResultObject.result.resValue[1][1]
                    +ResultObject.result.resValue[2][1]+ResultObject.result.resValue[3][1])/4;
            res[2] = (ResultObject.result.resValue[0][0]+ResultObject.result.resValue[1][0]
                    +ResultObject.result.resValue[2][0]+ResultObject.result.resValue[3][1])/4;
            res[3] = (ResultObject.result.resValue[0][0]+ResultObject.result.resValue[1][0]
                    +ResultObject.result.resValue[2][0]+ResultObject.result.resValue[3][0])/4;
        }
        return res;
    }

    public static int[] getAxes(int type){
        int[] res = new int[4];
        if(type==TYPE_LEADER){
            res[0] = (ResultObject.result.resValue[1][1]+ResultObject.result.resValue[2][1])/2;
            res[1] = (ResultObject.result.resValue[1][0]+ResultObject.result.resValue[2][0])/2;
            res[2] = (ResultObject.result.resValue[0][1]+ResultObject.result.resValue[3][0])/2;
            res[3] = (ResultObject.result.resValue[0][0]+ResultObject.result.resValue[3][1])/2;
        }else if(type==TYPE_EMPLOY){
            res[0] = (ResultObject.result.resValue[0][1]+ResultObject.result.resValue[2][1])/2;
            res[1] = (ResultObject.result.resValue[0][0]+ResultObject.result.resValue[2][0])/2;
            res[2] = (ResultObject.result.resValue[1][1]+ResultObject.result.resValue[3][0])/2;
            res[3] = (ResultObject.result.resValue[1][0]+ResultObject.result.resValue[3][1])/2;
        }
        return res;
    }

    public static String getMainCulture(int type){
        int[] arr = getCultures(type);
        int max = arr[0];
        int index = 0;
        for(int i=1; i<arr.length; i++){
            if(arr[i]>max){
                max = arr[i];
                index = i;
            }
        }
        return NAMES_CULTURE[index];
    }

}
