package algorithm;

import java.util.*;

public class GoogleProblem {
    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList();
        List<Integer> list1 = new ArrayList();
        list1.add(4);
        list1.add(10);
        list1.add(15);
        list1.add(24);
        list1.add(26);
        List<Integer> list2 = new ArrayList();
        list2.add(0);
        list2.add(9);
        list2.add(12);
        list2.add(20);
        List<Integer> list3 = new ArrayList();
        list3.add(5);
        list3.add(18);
        list3.add(22);
        list3.add(30);
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        Result result = findCoveringRange(lists);
        System.out.println(result.startRange + ", " + result.endRange);

    }

    public static Result findCoveringRange(List<List<Integer>> lists) {
        Result result = null;
        int start = -1, end = -1;
        int rDiff = Integer.MAX_VALUE;
        int k = lists.size();
        PriorityQueue<Data> pQueue = new PriorityQueue();
        SortedSet<Data> entries = new TreeSet();
        Map<Integer, Data> listNoAndEntry = new HashMap<Integer, Data>();
        for (int i = 0; i < k; i++)
            pQueue.add(new Data(lists.get(i).remove(0), i));
        while (!pQueue.isEmpty()) {
            Data minData = pQueue.remove();
            if (lists.get(minData.listNo).size() > 0)
                pQueue.add(new Data(lists.get(minData.listNo).remove(0),
                        minData.listNo));
            if (listNoAndEntry.size() == k) {
                Data first = entries.first();
                if ((entries.last().data - first.data) + 1 < rDiff) {
                    start = first.data;
                    end = entries.last().data;
                }
                entries.remove(first);
                listNoAndEntry.remove(first.listNo);
            }
            if (listNoAndEntry.containsKey(minData.listNo))
                entries.remove(listNoAndEntry.remove(minData.listNo));
            listNoAndEntry.put(minData.listNo, minData);
            entries.add(minData);
        }
        if (listNoAndEntry.size() == k) {
            Data first = entries.first();
            if ((entries.last().data - first.data) + 1 < rDiff) {
                start = first.data;
                end = entries.last().data;
            }
            entries.remove(first);
            listNoAndEntry.remove(first.listNo);
        }
        result = new Result(start, end);
        return result;
    }

    // Longest Substring Which Contains 2 Unique Characters
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
            if (map.size() > 2) {

                max = Math.max(max, i - start);
                while (map.size() > 2) {
                    char t = s.charAt(start);
                    int count = map.get(t);
                    if (count > 1) {
                        map.put(t, count - 1);
                    } else {
                        map.remove(t);
                    }
                    start++;
                }
            }
        }
        max = Math.max(max, s.length() - start);
        return max;
    }
}

class Result {
    public final int startRange, endRange;

    public Result(int startRange, int endRange) {
        this.startRange = startRange;
        this.endRange = endRange;
    }
}

class Data implements Comparable<Data> {
    public final int data;
    public final int listNo;

    public Data(int data, int listNo) {
        this.data = data;
        this.listNo = listNo;
    }

    @Override
    public int compareTo(Data o) {
        return data - o.data;

    }
}
