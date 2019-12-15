package com.srv.app;

import org.springframework.boot.SpringApplication;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        Integer[] ar = {1,4,3,5,6,2};
        Map<String,Integer> map = new HashMap<>();

        for(int i=0;i<ar.length;i++)
        {
            if(ar[i]==2)
            {
                map.put("H",ar[i]);
                ar[i] =-1;
                for(int j=0;j<ar.length;j++)
                {
                    if(ar[j] == 3 || ar[j] == 2 || ar[j] ==1 )
                    map.put("h",ar[i]);
                }
            }
//            else if(ar[i].equals(""))
        }

        System.out.println(map.get("H")+""+map.get("h"));
    }

}
