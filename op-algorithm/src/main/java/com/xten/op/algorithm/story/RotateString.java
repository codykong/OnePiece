package com.xten.op.algorithm.story;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Description: http://www.lintcode.com/zh-cn/problem/rotate-words/
 * User: kongqingyu
 * Date: 2017/9/18
 */
public class RotateString {

    public static void main(String[] args) {

        List<String> words = Lists.newArrayList("picture", "turepic", "icturep", "word", "ordw", "lint");
        int count = countRotateWords(words);
        int newCount = countRotateWordsBySubstring(words);
        System.out.println(count+","+newCount);
    }

    /*
     * 暴力破解法：解析所有的单词的循环单次进行暴力筛选，时间复杂度：n*n*k  k 为字符的长度
     * @param words: A list of words
     * @return: Return how many different rotate words
     */
    public static int countRotateWords(List<String> words) {
        // Write your code here
        boolean[] checked = new boolean[words.size()];
        int count = 0;
        int i = 0;
        while (i < words.size()){

            if(!checked[i]){
                count++;
                checked[i] = true;

                String w = words.get(i);
                for (int j = 0 ;j < w.length() ;j++){
                    String newWord = w.substring(j,w.length())+w.substring(0,j);

                    for (int x = i+1; x<words.size();x++){
                        if (newWord.equals(words.get(x))){
                            checked[x] = true;
                        }
                    }
                }
            }

            i++;


        }

        return count;

    }

    /**
     * 循环单词只要保证 该词在两个循环单次内，且长度一致就可以了，时间复杂度为：n*n
     * 如：比如单词是picture，串接后的单词就是picturepicture，turepic和icturep都是picturepicture的子串，因此都是picture的循环单词。
     * @param words
     * @return
     */
    public static int countRotateWordsBySubstring(List<String> words) {
        // Write your code here
        boolean[] checked = new boolean[words.size()];
        int count = 0;
        int i = 0;
        while (i < words.size()){

            if(!checked[i]){
                count++;
                checked[i] = true;

                String w = words.get(i);
                String totalW = w+w;
                for (int x = i+1; x<words.size();x++){
                    if (totalW.contains(words.get(x)) && w.length() == words.get(x).length()){
                        checked[x] = true;
                    }

                }

            }

            i++;


        }

        return count;

    }


}
