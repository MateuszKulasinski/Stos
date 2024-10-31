package RPN;

import Stos.Stack;

public class RPN {
    private Stack stack;
    private String ciag;

    public RPN() {
        stack = new Stack();
    }

    public void setCiag(String ciag) {
        this.ciag = ciag;
    }

    public boolean czyLiczba(String znak) {
        try {
            Integer.parseInt(znak);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean czyOperacja(String znak) {
        if (znak.equals("+") || znak.equals("-") || znak.equals("*")) {
            return true;
        }
        return false;
    }

    public int oblicz() {
        if (ciag == null){
            throw new RuntimeException("Ciąg jest pusty");
        }
        String[] znaki = ciag.split("\\s+");
        int el1;
        int el2;
        for (int i = 0; i < znaki.length; i++) {
            if (czyLiczba(znaki[i])) {
                stack.push(znaki[i]);
            } else if (czyOperacja(znaki[i])) {
                if (znaki[i].equals("+")) {
                    el2 = Integer.parseInt(stack.pop());
                    el1 = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(el1 + el2));
                } else if (znaki[i].equals("-")) {
                    el2 = Integer.parseInt(stack.pop());
                    el1 = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(el1 - el2));
                } else if (znaki[i].equals("*")) {
                    el2 = Integer.parseInt(stack.pop());
                    el1 = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(el1 * el2));
                }
            }
            else {
                throw new RuntimeException("Znak nie jest liczbą ani operacją");
            }
            if (czyLiczba(znaki[i]) && i == znaki.length - 1) {
                throw new RuntimeException("Znak na końcu nie może być liczbą");
            }
        }
        if (stack.getStos().length > 1){
            throw new RuntimeException("Za długi ciąg liczb");
        }
        return Integer.parseInt(stack.peek());
    }
}
