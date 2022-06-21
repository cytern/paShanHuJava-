package dam.jsoup.updatereport.updatreport.linkList;

import io.swagger.models.auth.In;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ArrowsLink {
    private static HashMap<Integer,Integer> getMap () {
        HashMap<Integer, Integer> resultMap = new HashMap<>();
        resultMap.put(1,8);
        resultMap.put(2,3);
        resultMap.put(3,9);
        resultMap.put(4,4);
        resultMap.put(5,6);
        resultMap.put(6,5);
        resultMap.put(7,6);
        resultMap.put(8,1);
        resultMap.put(9,8);
        resultMap.put(10,6);
        resultMap.put(11,6);
        return resultMap;
    }

    public static void main(String[] args) {

        //先获取标准集
        HashMap<Integer, Integer> map = getMap();
//        Integer integer = follow_the_arrows_from(map, 2);
//        System.out.println("on loop of " + integer);
        longestSequences(map,5);
    }

    private static Integer follow_the_arrows_from (HashMap<Integer,Integer> map,Integer index) {
        //先遍历直到遇到重复节点 即出现循环  set里只存key
        HashSet<Integer> keys = new HashSet<>();
        keys.add(index);
        Integer key = index;
        int i = 1;
        while (true) {
            key = map.get(key);
            if (keys.contains(key)) {
                break;
            }
            keys.add(key);
            i = i + 1;
        }
        //这个时候得出的i 应该是最后一个循环的点的长度 如果最后一个key值就是index 那取出的值就是循环长度
        if (key.equals(index)) {
            return i;
        }else {
            return 0;
        }

    }

    private static void longestSequences(HashMap<Integer,Integer> sourceMap,Integer value) {

        List<HashSet<Integer>> thisWayLength = getThisWayLength(sourceMap, null, value);
        //打印一下list
        for (HashSet<Integer> set : thisWayLength) {
            for (Integer integer : set) {
                System.out.print(integer + " ->");
            }
            System.out.println("最终长度为  " + set.size());
        }
    }

    private static List<HashSet<Integer>> getThisWayLength(HashMap<Integer,Integer> sourceMap,List<HashSet<Integer>> sets,Integer value) {
        if (sets == null) {
            sets = new ArrayList<>();
            HashSet<Integer> set = new HashSet<>();
            sets.add(set);
        }
        //获取全部下一步可行的节点
        List<Integer> allValues = getAllValues(sourceMap, value);
        //如果没有下一步可行 就退出递归 得到最终的值
        if (allValues.size()<1) {
            return sets;
        }
        //把这一步的值加入到所有现行的值 但是需要考虑可能存在的循环点 如果循环的话就结束掉这个递归
        ArrayList<HashSet<Integer>> tempsSets = new ArrayList<>();
        for (Integer thisValue : allValues) {
            for (HashSet<Integer> set : sets) {
                if (set.contains(thisValue)) {
                    break;
                }else {
                    set.add(thisValue);
                    //进入下一次递归
                    tempsSets.add(set);
                    getThisWayLength(sourceMap,tempsSets,thisValue);
                }
            }
        }
        return tempsSets;

    }

    private static List<Integer> getAllValues(HashMap<Integer,Integer> sourceMap,Integer value) {
        ArrayList<Integer> values = new ArrayList<>();
        sourceMap.forEach( (k,v) -> {
            if (v.equals(value)) {
                values.add(k);
            }
        });
        return values;
    }
}
