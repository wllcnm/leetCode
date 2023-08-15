package org.example.xhs;

import java.util.*;

public class Test2 {
    /*
    *
    * 小红书有一个推荐系统，可以根据用户搜索的关键词推荐用户希望获取的内容。

现在给定小红的搜索记录（记录为分词后的结果），我们认为当一个单词出现的次数不少于3次时，该单词为“用户期望搜索的单词”，即称为关键词。请你根据小红的记录，输出小红的用户画像对应的所有关键词。
    * */

    /*
    * 输入描述
一行字符串，仅由小写字母和空格组成。代表小红的搜索记录。

字符串长度不超过100000。

输出描述
小红所有的关键词。每行输出一个。你需要按照搜索频次从高到低输出。频次相同的，你需要按字典序升序输出。*/
    /*
    *
    * 样例输入
kou red game red ok who game red karaoke yukari kou red red nani kou can koukou ongakugame game
样例输出
red
game
kou*/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] strings = s.split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        for(Map.Entry<String,Integer> entry:map.entrySet()){

        }
        for (String string : strings) {
            if (!map.containsKey(string)) {
                map.put(string, 1);
            } else {
                map.put(string, map.get(string) + 1);
            }
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.removeIf(entry -> entry.getValue() < 3);
        list.sort((e1, e2) -> {
            if (e1.getValue().equals(e2.getValue())) {
                return e1.getKey().compareTo(e2.getKey());
            }
            return e2.getValue().compareTo(e1.getValue());
        });
        for (Map.Entry<String, Integer> l:list){
            System.out.println(l.getKey());
        }


    }
}
