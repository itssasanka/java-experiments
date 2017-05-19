package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sasanka on 5/19/17.
 */
public class LRUCache {
    private int size;
    private ArrayList<Integer> list;
    private HashMap<Integer, Integer> map;

    public LRUCache(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public List<Integer> getList() {
        return list;
    }

    public Map<Integer, Integer> getMap() {
        return map;
    }

    public boolean isFull(){
        return this.list.size() == size;
    }

    public void insert(Integer val){
        if (isFull()) {
            
        }
    }




}
