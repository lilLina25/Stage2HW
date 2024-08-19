import MyCustomArrayList.MyCustomArrayList;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MyCustomArrayList<Integer> numList = new MyCustomArrayList();
        MyCustomArrayList<String> strList = new MyCustomArrayList();

        //Method add();
        numList.add(2);//Вывод: [2]
        numList.add(4);//Вывод: [2, 4]
        numList.add(10);//Вывод: [2, 4, 10]

        strList.add("Maria");//Вывод: [Maria]
        strList.add("Anna");//Вывод: [Maria, Anna]
        strList.add("Elena");//Вывод: [Maria, Anna, Elena]

        //Method add(int index, E element)
        numList.add(2, 33); //Вывод:[2, 4, 33, 10]
        //  numList.add(5, 33); //Вывод: Index 5, size 4
        strList.add(3,"Olga");//Вывод: [Maria, Anna, Elena, Olga]
        //  strList.add(5,"Olga");//Вывод: Index 5, size 4

        //Method clear()
        numList.clear();//Вывод: []
        strList.clear();//Вывод: []

        //Method isEmpty()
        System.out.println(numList.isEmpty());//Вывод: true
        System.out.println(strList.isEmpty());//Вывод: true

        //Method addAll(Collection<? extends E> c)
        List<Integer> nums = new ArrayList<>();
        List<String> strs = new ArrayList<>();
        nums.add(2);
        nums.add(24);
        nums.add(21);
        nums.add(5);
        strs.add("Lilia");
        strs.add("Natalia");
        strs.add("Viktoria");
        strs.add("Anastasia");

        numList.addAll(nums);//Вывод: [2, 24, 21, 5]
        strList.addAll(strs);//Вывод: [Lilia, Natalia, Viktoria, Anastasia]

        //Method get(int index)
        System.out.println(numList.get(0));//Вывод: 2
        System.out.println(strList.get(3));//Вывод: Anastasia
        //System.out.println(strList.get(5));//Вывод: Index 5, size 4

        //Method isEmpty()
        System.out.println(numList.isEmpty());//Вывод: false
        System.out.println(strList.isEmpty());//Вывод: false

        //Method remove(int index)
        numList.remove(2);//Вывод: [2, 24, 5]
        strList.remove(1);//Вывод: [Lilia, Viktoria, Anastasia]

        //Method remove(Object o)
        strList.remove("Lilia");//Вывод: [Viktoria, Anastasia]

        //Method sort(Comparator<? super E> c)
        numList.add(3);
        numList.add(15);
        numList.add(43);
        numList.add(19);
        numList.add(7);
        strList.add("Lilia");
        strList.add("Viktoria");
        strList.add("Maria");
        strList.add("Anna");
        strList.add("Elena");
        //Before sort
        System.out.println(numList.getList());//Вывод: [2, 24, 5, 3, 15, 43, 19, 7]
        System.out.println(strList.getList());//Вывод: [Viktoria, Anastasia, Lilia, Viktoria, Maria, Anna, Elena]

        numList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        strList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        //After sort
        System.out.println(numList.getList());//Вывод: [2, 3, 5, 7, 15, 19, 24, 43]
        System.out.println(strList.getList());//Вывод: [Anastasia, Anna, Elena, Lilia, Maria, Viktoria, Viktoria]
    }
}