package com.duduanan.leetcode;


public class Trie {
    class Node {
        Node[] children;
        boolean isWord;
        public Node(){
            children = new Node[26];
            isWord = false;
        }
    }
    Node root;
    public Trie() {
        root = new Node();
    }
    public void insert(String word) {
        Node node = this.root;
        for(char c : word.toCharArray()) {
            int idex = c - 'a';
            if(node.children[idex] == null){
                node.children[idex] = new Node();
            }
            node = node.children[idex];
        }
        node.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node = this.root;
        for(char c : word.toCharArray()){
            int idx = c - 'a';
            if(node.children[idx] == null) return false;
            node = node.children[idx];
        }
        return node.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node node = this.root;
        for(char c: prefix.toCharArray()){
            int idx = c - 'a';
            if(node.children[idx] == null) return false;
            node = node.children[idx];
        }
        return true;
    }
}
