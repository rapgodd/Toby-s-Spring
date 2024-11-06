package com.giyeon.hellospring;

import java.util.Collections;
import java.util.List;

public class Sort {

    public List<String> sortList(List<String> list){
        Collections.sort(list, (o1,o2)->o1.length()-o2.length());
        return list;
    }

    public static void main(String[] args) {



    }

}
