import java.util.ArrayList;
import java.util.List;

/**
 * @author sirius
 * @since 2019/05/15
 */
public class GenericsDemo {
    public static void main(String[] args) {
//        List arrayList = new ArrayList();
//        arrayList.add("aaaa");
//        arrayList.add(100);
//
//        for (int i = 0; i < arrayList.size(); i++) {
//            String item = (String) arrayList.get(i);
//            System.out.println("泛型测试: item = " + item);
//        }
//        List<String> stringArrayList = new ArrayList<String>();
//        List<Integer> integerArrayList = new ArrayList<Integer>();
//
//        Class classStringArrayList = stringArrayList.getClass();
//        Class classIntegerArrayList = integerArrayList.getClass();
//
//        if(classStringArrayList.equals(classIntegerArrayList)){
//            System.out.println("泛型测试: 类型相同");
//        }
//
//        MyGeneric<String, Integer> myGeneric = new MyGeneric<>("haha", 1234);
//        System.out.println(myGeneric.getKey());
//        System.out.println(myGeneric.getValue());
//        MyGeneric<String, Integer> myGeneric1 = new MyGeneric<>("haha", 1234);
//        MyGeneric<String, Number> myGeneric2 = new MyGeneric<>("haha", 1234);
//        showKeyValue1(myGeneric1);
//        showKeyValue1(myGeneric2);
    }
//
//    public static void showKeyValue1(MyGeneric<String, ?> obj) {
//        System.out.println(obj.getValue());
//    }
    public <T> T genericMethod(Class<T> tClass) throws InstantiationException, IllegalAccessException {
        T instance = tClass.newInstance();
        return instance;
    }
}

//class MyGeneric<K, V> {
//    private K key;
//    private V value;
//
//    public MyGeneric(K key, V value) {
//        this.key = key;
//        this.value = value;
//    }
//
//    public K getKey() {
//        return key;
//    }
//
//    public V getValue() {
//        return value;
//    }
//}

//interface Generator<T> {
//    T next();
//}
//
//class FruitGenerator<T> implements Generator<T> {
//    @Override
//    public T next() {
//        return null;
//    }
//}

//class FruitGenerator implements Generator<String> {
//
//    @Override
//    public String next() {
//        return null;
//    }
//}

