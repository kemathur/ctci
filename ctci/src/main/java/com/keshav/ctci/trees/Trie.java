package com.keshav.ctci.trees;


import com.keshav.ctci.hash.HashMap;
import com.keshav.ctci.list.StringBuilder;
import com.keshav.ctci.queue.Stack;
import com.keshav.ctci.util.KVPair;

public class Trie<T> {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode(' ');
    }

    public class TrieNode {
        char c;
        T val;
        HashMap<Character, TrieNode> childMap;

        public TrieNode(char c) {
            this.c = c;
            childMap = new HashMap<>();
        }

        private void insert(char x) {
            if (childMap.get(x) != null) return;
            childMap.put(x, new TrieNode(x)); 
        }

        public void put(String s, T val) {
            if (s.equals("")) return;
            char x = s.charAt(0);
            insert(x);
            if (s.length() > 1)
                childMap.get(x).put(s.substring(1), val);
            else
                childMap.get(x).val = val;
        }

        public T get(String s) {
            if (s.equals("")) return null;
            char x = s.charAt(0);
            if (childMap.get(x) != null) {
                return (s.length() > 1 ? childMap.get(x).get(s.substring(1)) : childMap.get(x).val);
            }
            return null;
        }

        public T delete(String s, Stack<Character> stack) {
            if (s.equals("")) return null;
            char x = s.charAt(0);
            TrieNode child = childMap.get(x);
            if (child == null) return null;
            T ret = null;
            if (s.length() > 1){
                ret = childMap.get(x).delete(s.substring(1), stack);
                Character ch = stack.pop();
                if (ch != null) {
                    TrieNode chx = childMap.get(ch);
                    if (chx.childMap.size() == 0 && chx.val == null) {
                        childMap.remove(ch);
                        stack.push(c);
                    }
                }
            }
            else if (child.val != null) {
                ret = child.val;
                child.val = null;
                if (child.childMap.size() == 0) {
                    childMap.remove(x);
                    stack.push(c);
                }
            }
            return ret;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("TrieNode{");
            builder.append("c=");
            builder.append(String.valueOf(c));
            builder.append(", val=");
            builder.append(String.valueOf(val));
//            builder.append("\n \t");
            builder.append(", childMap=");
            for (KVPair<Character, TrieNode> kv : childMap) {
                builder.append("(" + kv.key() + ", " + kv.value() + ")");
            }
//            builder.append("\n");
            builder.append("}");
            return  builder.toString();
        }
    }

    public void insert(char c) {
        root.insert(c);
    }

    public void put(String s, T val) {
        root.put(s, val);
    }

    public T get(String s) {
        return root.get(s);
    }

    public T delete(String s) {
        Stack<Character> stack = new Stack<>();
        return root.delete(s, stack);
    }

    @Override
    public String toString() {
        return "Trie{" +
                "root=" + root +
                '}';
    }

    public static void main(String args[]) {
        Trie<Integer> t = new Trie<>();
        t.put("abc", 0);
        t.put("abd", 1);
        t.put("abe", 2);
        t.put("bad", 3);
        t.put("bac", 4);
        t.put("bed", 5);
        t.put("bedding", 6);
        System.out.println(t.get("a"));
        System.out.println(t.get("abc"));
        System.out.println(t.get("abf"));
        System.out.println(t.delete("a"));
        System.out.println(t.delete("abc"));
        System.out.println(t.delete("abb"));
        System.out.println(t.delete("abd")); 
        // System.out.println(t.delete("abe"));
        System.out.println(t.delete("abc"));
        System.out.println(t.get("abe"));
        System.out.println(t.get("abc"));
        System.out.println(t);
    }
}
