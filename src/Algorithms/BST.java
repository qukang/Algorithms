package Algorithms;

import java.util.*;

/**
 * Created by Omeprazole on 2017/6/7.
 */
public class BST<Key extends Comparable<Key>, Value> {
    private Node root;
    private class Node{
        private Key key;
        private Value value;
        private Node left,right;
        private int N;

        public Node(Key key,Value value,int N){
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }

    public BST() {
    }

    public int size(){
        return size(root);
    }

    private int size(Node x){
        if(x==null){
            return 0;
        }else{
            return x.N;
        }
    }

    public Value get(Key key){
        return get(root,key);
    }


    private Value get(Node x, Key key){
        if(root==null){
            return null;
        }
        int cmp = key.compareTo(x.key);
        if(cmp>0) return get(x.right,key);
        else if(cmp<0) return get(x.left,key);
        else return x.value;
    }


    public void put(Key key,Value value){
        if (key == null) throw new IllegalArgumentException("calledput() with a null key");
        if (value == null) {
            delete(key);
            return;
        }
        root = put(root,key,value);
    }

    private Node put(Node x,Key key,Value value){
        if(x==null){
            return new Node(key,value,1);
        }
        int cmp = key.compareTo(x.key);
        if(cmp>0) x.right = put(x.right,key,value);
        else if(cmp<0) x.left = put(x.left,key,value);
        else{
            x.value = value;
        }
        x.N = size(x.left)+size(x.right)+1;
        return x;
    }

    public Key min(){
        return min(root).key;
    }

    private Node min(Node x){
        if(x.left==null) return x;
        return min(x.left);
    }

    public Key max(){
        return max(root).key;
    }

    private Node max(Node x){
        if(x.right==null) return x;
        return max(x.right);
    }


    public Key floor(Key key){
        Node x = floor(root,key);
        if(x==null){
            return null;
        }
        return x.key;
    }

    private Node floor(Node x,Key key){
        if(x==null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp==0) return x;
        if(cmp<0) return floor(x.left,key);
        Node t = floor(x.right,key);
        if(t!=null) return t;
        else return x;
    }

    public Key select(int k){
        if (k < 0 || k >= size()) {
            throw new IllegalArgumentException("called select() with invalid argument: " + k);
        }
        return select(root,k).key;
    }

    private Node select(Node x,int k){
        if(x==null) return null;
        int t = size(x.left);
        if(t<k) return select(x.right,k-t-1);
        else if(t>k) return select(x.left,k);
        else return x;
    }

    public int rank(Key key){
        return rank(root,key);
    }

    private int rank(Node x,Key key){
        if(x==null) return 0;
        int cmp = key.compareTo(x.key);
        if(cmp>0){
            return rank(x.right,key)+size(x.left)+1;
        }
        else if(cmp<0){
            return rank(x.left,key);
        }
        else{
            return size(x.left);
        }
    }

    public void deleteMin(){
        if(root ==null) return;
        root = deleteMin(root);
    }

    private Node deleteMin(Node x){
        if(x.left==null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left)+size(x.right)+1;
        return x;
    }

    public void delete(Key key){
        if (key == null) throw new IllegalArgumentException("called delete() with a null key");
        root = delete(root,key);
    }

    private Node delete(Node x,Key key){
        if(x==null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp<0){
            x.left = delete(x.left,key);
        }
        else if(cmp>0){
            x.right = delete(x.right,key);
        }
        else{
            if(x.left==null) return x.right;
            if(x.right==null) return x.left;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.N = size(x.left)+size(x.right)+1;
        return x;
    }

    public Iterable<Key> keys(){
        return keys(min(),max());
    }

    public Iterable<Key> keys(Key lo,Key hi){
        Queue<Key> queue = new LinkedList<>();
        keys(root,queue,lo,hi);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue,Key lo,Key hi){
        if(x==null) return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if(cmplo<0) keys(x.left,queue,lo,hi);
        if(cmplo<=0&&cmphi>0) queue.add(x.key);
        if(cmphi>0) keys(x.right,queue,lo,hi);
    }

    public static void main(String[] args){
        int N = 100;
        Set<Integer> set = new HashSet<>();
        BST<Integer,Integer> bst = new BST<>();
        for(int i = 0;i<N;i++){
            int v = (int)(Math.random()*100);
            if(!set.contains(v)){
                set.add(v);
                bst.put(v,v);
            }
        }
        int v = 0;
        for(int i = 0;i<N*N;i++){
            v = (int)(Math.random()*100);
            if(set.contains(v)){
                bst.delete(v);
                set.remove(v);
            }
            v = (int)(Math.random()*100);
            if(!set.contains(v)) {
                bst.put(v, v);
                set.add(v);
            }
        }
    }




}
