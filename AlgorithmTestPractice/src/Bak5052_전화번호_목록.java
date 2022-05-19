import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class TrieNode {
    //[변수]
    //자식 노드 맵
    private Map<Character, TrieNode> child = new HashMap<>();
    //마지막 글자인지 여부
    private boolean isLastChar;

    Map<Character, TrieNode> getChild() {
        return this.child;
    }

    boolean isLastChar() {
        return this.isLastChar;
    }

    void setLastChar(boolean lastChar) {
        this.isLastChar = lastChar;
    }
}

public class Bak5052_전화번호_목록 {
    public static int N;
    public static int M;
    public static TrieNode root = new TrieNode();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++) {
            M = Integer.parseInt(br.readLine());
            String numbers[] = new String[M];
            for(int j=0;j<M;j++) {
                String str = br.readLine();
                numbers[j] = str;
            }
            Arrays.sort(numbers);
            for(int j=0;j<M;j++) {
                insert(numbers[j]);
            }
            String isLast = "YES";
            for(int j=0;j<M;j++) {
                if(!contains(numbers[j])) {
                    isLast = "NO";
                    break;
                }
            }
            root = new TrieNode();
            sb.append(isLast + "\n");
        }
        System.out.println(sb);
    }
    public static void insert(String number) {
        TrieNode thisNode = root;
        for(int i=0;i<number.length();i++) {
            thisNode.setLastChar(false);
            thisNode = thisNode.getChild().computeIfAbsent(number.charAt(i), c-> new TrieNode());
        }
        thisNode.setLastChar(true);
    }
    public static boolean contains(String number) {
        TrieNode thisNode = root;
        for(int i=0;i<number.length();i++) {
            char word = number.charAt(i);
            TrieNode node = thisNode.getChild().get(word);
            if(node == null) {
                return false;
            }
            thisNode = node;
        }
        return thisNode.isLastChar();
    }
}
