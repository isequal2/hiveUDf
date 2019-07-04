package com.healthedge.hivecustomudf;

import org.apache.hadoop.hive.ql.exec.UDF;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class temp  extends UDF{

    Set<String> toRemove = new HashSet<String>();

    public Map<String, String > evaluate(Map<String, String > map) {

        toRemove.clear();
        for(String s : map.keySet()) {
            if (map.get(s) ==null) {

                toRemove.add(s);
            }
        }

        for(String s : toRemove) {
            map.remove(s);
        }
        return map;
    }
}
