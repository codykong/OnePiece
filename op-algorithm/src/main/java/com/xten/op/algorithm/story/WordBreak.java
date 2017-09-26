package com.xten.op.algorithm.story;



import com.google.common.collect.Sets;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Description:
 * User: kongqingyu
 * Date: 2017/9/22
 */
public class WordBreak {



    public static void main(String[] args) {
        String word = "\"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\"";


        Set<String> dic = Sets.newHashSet("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");

        List<String> res = breaks(word,dic,0,new HashMap<>());
        System.out.println(res);
    }

    public static List<String> breaks(String word, Set<String> dic,int offset,Map<Integer,List<String>> wordMap){

        List<String> heads = new ArrayList<>();

        if (wordMap.get(offset)!=null){
            return wordMap.get(offset);
        }

        for(String d : dic){
            if (d.length()==0){
                continue;
            }
            int end = d.length()+offset;
            if (end<=word.length() && word.substring(offset,end).equals(d)){
                if (end<word.length()){
                    List<String> tail = breaks(word,dic,end,wordMap);
                    for (String p : tail){
                        heads.add( d+" "+p);
                    }
                }else {
                    heads.add(d);
                }
            }

        }

        wordMap.put(offset,heads);

        return heads;
    }


}
