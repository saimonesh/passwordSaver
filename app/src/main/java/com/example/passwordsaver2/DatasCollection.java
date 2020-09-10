package com.example.passwordsaver2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DatasCollection {
    private static Map<String,DATA> dataCollection =
             Collections.synchronizedMap(new HashMap<String,DATA>());


    public static boolean addData(DATA data) {
        try {
            data.ID=generateID();
            dataCollection.put(data.ID,data);
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    private static String generateID() {
        return String.valueOf(Long.valueOf(DatasCollection.getTotal()+1));
    }

    public static int getTotal()
    {
       return dataCollection.size();
    }
    public static DATA getDATA(String id) throws Exception {
        if(dataCollection.size()>0 && id!=null)
        {
            if(dataCollection.get(id)!=null)
            {
                return dataCollection.get(id);
            }
        }
        return null;
    }
    public static DATA getDATA(long id) throws Exception
    {
        return getDATA(String.valueOf(id));
    }
    public static Map getDATA()
    {
      return  dataCollection;
    }
}
