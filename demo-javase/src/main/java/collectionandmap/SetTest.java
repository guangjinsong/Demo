package collectionandmap;

import org.junit.Test;

import java.util.*;

/**
 * @author sgj
 * @create 2023-06-15 9:00
 */
public class SetTest {
    // 字典序输出
    @Test
    public void test01() {
        Set set = new TreeSet();
        set.add("CC");
        set.add("BB");
        set.add("AA");
        for (Object o: set) {
            System.out.println(o);
        }
    }

    @Test
    public void test02() {
        TreeSet set = new TreeSet();
        User u1 = new User(1, "1");
        User u2 = new User(2, "2");
        User u3 = new User(3, "3");
        set.add(u1);
        set.add(u2);
        set.add(u3);
        System.out.println(set.toString());
    }

    @Test
    public void test03() {
        Map map = new HashMap();
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");
        Set set = map.keySet();
        Collection values = map.values();
        Set entrySet = map.entrySet();
        System.out.println(set);
        System.out.println(values);
        System.out.println(entrySet);
    }
}
class User implements Comparable{
    int age;
    String name;

    public User() {
    }

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        if (this == o) {
            return 0;
        }
        if (o instanceof User) {
            User u = (User)o;
            return this.age - u.age;
        }
        throw new RuntimeException("类型不匹配");
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

