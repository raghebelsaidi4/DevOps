package com.ragheb;

import java.util.ArrayList;
import java.util.List;

public class ListProcessor {
    public int getFilteredListCount(List<Integer> data){
        System.out.println("getFilteredListCount");
        ArrayList<Integer> list = new ArrayList<>(data);
        for (Integer i : data){
            if (i % 2 == 0){
                list.add(i);
            }
        }
        System.out.println(list);
        return list.size();
    }
}
