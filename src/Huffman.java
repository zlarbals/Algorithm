import java.util.*;

public class Huffman {

    private class node implements Comparable<node> {
        char character;
        int frequency;

        node left;
        node right;

        public node(char c, int fr) {
            this.character = c;
            this.frequency = fr;
            this.left = null;
            this.right = null;
        }

        public node(char c, int fr, node l, node r) {
            this.character = c;
            this.frequency = fr;
            this.left = l;
            this.right = r;
        }

        @Override
        public int compareTo(node node) {
            return this.frequency - node.frequency;
        }
    }

    public void doHuffman(String text) {
        node temp1, temp2, sum;
        PriorityQueue<node> priorityQueue;
        priorityQueue = classifyText(text);
        node head = null;

        while (priorityQueue.size() > 1) {
            temp1 = priorityQueue.poll();
            temp2 = priorityQueue.poll();

            sum = new node('*', temp1.frequency + temp2.frequency, temp1, temp2);

            head = sum;
            priorityQueue.add(sum);
        }

        print(head, "");
    }

    private PriorityQueue<node> classifyText(String text) {
        int temp;
        int[] charFrequency = new int[26];
        PriorityQueue<node> priorityQueue = new PriorityQueue<node>();

        for (int i = 0; i < text.length(); i++) {
            temp = text.charAt(i) - 97;
            //대문자 모두 소문자로 처리.
            if(temp<0)
                temp+=32;

            charFrequency[temp]++;
        }

        for (int i = 0; i < 26; i++) {
            if (charFrequency[i] != 0)
                priorityQueue.add(new node((char) (i + 97), charFrequency[i]));
        }

        return priorityQueue;

    }

    private void print(node head, String codeWord) {
        if (head.character != '*')
            System.out.println(head.character + " = " + codeWord);

        if (head.left != null)
            print(head.left, codeWord + "0");

        if (head.right != null)
            print(head.right, codeWord + "1");
    }
}
