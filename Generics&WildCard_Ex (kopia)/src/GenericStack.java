import java.util.ArrayList;
public class GenericStack <T> {
    private ArrayList<T> list = new ArrayList<>();

    GenericStack(){}

    int getSize(){
        return list.size();
    }
    T peek(){
        return list.get(getSize()-1);
    }
    T pop(){
        T o = list.remove(getSize() - 1);
        return o;
    }
    void push(T obj){
        list.add(obj);
    }
    boolean isEmpty(){
        return list.isEmpty();
    }
    @Override
    public String toString() {
        return "Stack: " + list.toString();
    }
}
