package leetcode.may_challenge.week2;

import java.util.ArrayList;

public class Trie {

    public static void main(String[] args) {
        Trie obj = new Trie();
         obj.insert("apple");
         boolean param_2 = obj.search("apple");
         boolean param_3 = obj.startsWith("app");

         System.out.println(param_2 + ":"+param_3);
    }

    class TrieNode{
        char data;
        ArrayList<TrieNode> children;
        
        boolean isEnd;
        
        public TrieNode(char data){
            this.data = data;
            isEnd=false;
            children = new ArrayList<>(26);
            for(int i=0;i<26;i++){
                children.add(null);
            }
        }
        
        public TrieNode(){
            data = '\0';
            isEnd=false;
            children = new ArrayList<>(26);
            for(int i=0;i<26;i++){
                children.add(null);
            }
        }
    }
    
    TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        int length = word.length();
        for(int i=0;i<length;i++){
            int idx = word.charAt(i) - 'a';
            if(node.children.get(idx) == null){
                node.children.set(idx,new TrieNode(word.charAt(i)));
            }
            node = node.children.get(idx);
        }
        node.isEnd = true;
    }
    
    private TrieNode searchPrefix(String word){
        TrieNode node = root;
        int length = word.length();
        for(int i=0;i<length;i++){
            int idx = word.charAt(i) - 'a';
            if(node.children.get(idx) == null){
                return null;
            }
            node = node.children.get(idx);
        }
        return node;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}
