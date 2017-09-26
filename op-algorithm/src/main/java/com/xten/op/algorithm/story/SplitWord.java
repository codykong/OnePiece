package com.xten.op.algorithm.story;

import com.google.common.collect.Sets;

import java.util.*;

/**
 * Description:
 * User: kongqingyu
 * Date: 2017/9/13
 */
public class SplitWord {

    public static List<String> wordBreak(String s, Set<String> wordDict) {
        int maxLength = 0;
        for ( String dic : wordDict) {

            if (dic.length() > maxLength){
                maxLength = dic.length();
            }
        }


        List<String> res = new ArrayList<>();

        for (int i = s.length()-1 ; i>=0 ; i--){

        }

        return res;



    }

    public static void main(String[] args) {
        String s =  "lintcode" ;
        Set<String> wordDict = Sets.newHashSet("lint","code","a");
        System.out.println(checkWordBreak(s,wordDict));
    }

    /**
     * 单词切分

     给出一个字符串s和一个词典，判断字符串s是否可以被空格切分成一个或多个出现在字典中的单词。

     样例

     s = "lintcode"

     dict = ["lint","code"]

     返回 true 因为"lintcode"可以被空格切分成"lint code"
     http://www.cnblogs.com/theskulls/p/5312837.html
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean checkWordBreak(String s, Set<String> wordDict) {

        boolean[] res = new boolean[s.length()+1];
        res[0] = true;

        for (int i =0; i< s.length();i++){
            if(!res[i]){
                continue;
            }
            for (String w : wordDict){
                int end = i+w.length();

                if (end > s.length()){
                    continue;
                }
                if (s.substring(i,end).equals(w)){
                    if(end == s.length()){
                        return true;
                    }

                    res[end] = true;

                }
            }

        }

        return res[s.length()];


    }


}
