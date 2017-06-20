/**
 * Created by qukan on 2017/6/7.
 */
public class RedBlackBST<Key extends Comparable<Key>,Value> {
    private Node root;

    private static final boolean BLACK = false;

    private static final boolean RED = true;

    private class Node{
        private Key key;
        private Value value;
        private Node left,right;
        private int N;
        private boolean color;

        public Node(Key key,Value value,int N, boolean color){
            this.key = key;
            this.value = value;
            this.N = N;
            this.color = color;
        }
    }

    private boolean isRed(Node x){
        if(x==null) return false;
        return x.color;
    }

    private Node rotateLeft(Node h){
        if(h==null) return null;
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.left)+size(h.right)+1;
        return x;
    }

    private Node rotateRight(Node h){
        if(h==null) return null;
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.left)+size(h.right)+1;
        return x;
    }

    private void filpColors(Node h){
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
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
        root = put(root,key,value);
        root.color = BLACK;
    }

    public Node put(Node h,Key key,Value value){
        if(h==null){
            return new Node(key,value,1,BLACK);
        }
        int cmp = key.compareTo(h.key);
        if(cmp>0){
            h.right = put(h.right,key,value);
        }
        else if(cmp<0){
            h.left = put(h.left,key,value);
        }
        else{
            h.value = value;
        }
        h.N = size(h.left)+size(h.right)+1;
        if(isRed(h.right)&&!isRed(h.left)){
            h = rotateLeft(h);
        }
        if(isRed(h.left)&&isRed(h.left.left)){
            h = rotateRight(h);
        }
        if(isRed(h.left)&&isRed(h.right)){
            filpColors(h);
        }
        h.N = size(h.left)+size(h.right)+1;
        return h;
    }

}
