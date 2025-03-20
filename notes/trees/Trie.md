# Trie (prefix tree)

#trie 


Implementation example:

```java
public class Trie {
    class Node {
        private Node[] links = new Node[26];

        boolean contains(char ch) {
            return links[ch - 'a'] != null;
        }

        void put(char ch, Node node) {
            links[ch - 'a'] = node;
        }

        Node next(char ch) {
            return links[ch - 'a'];
        }
    }

    private Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for (char ch : word.toCharArray()) {
            if (!node.contains(ch)) {
                node.put(ch, new Node());
            }
            node = node.next(ch);
        }
    }

    public boolean startsWith(String prefix) {
        Node node = root;
        for (char ch : prefix.toCharArray()) {
            if (!node.contains(ch)) {
                return false;
            }
            node = node.next(ch);
        }
        return true;
    }
}
```