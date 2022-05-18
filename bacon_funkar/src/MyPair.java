public class MyPair {

    private MyNode key;
    private Integer value;

    MyPair(MyNode key, Integer value){
        this.key = key;
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public MyNode getKey() {
        return key;
    }
}
