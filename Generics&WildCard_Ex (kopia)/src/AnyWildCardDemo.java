public class AnyWildCardDemo {
    public static void main(String[] args) {
        GenericStack<Integer> intStack = new GenericStack<>();
        intStack.push(1);
        intStack.push(2);
        intStack.push(-2);

        print(intStack);
    }

    //man vill kunna använda den här funktionen på vilken typ av generisk stack som helst
    public static void print(GenericStack<?> stack){
        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }
}
