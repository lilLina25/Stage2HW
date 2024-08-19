package MyCustomArrayList;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class MyCustomArrayList<E> {
    QuickSort quickSort = new QuickSort();
    //Дефолтный размер
    private static final int DEFAULT_CAPACITY = 10;
    private Object list [];
    private int size = 0;
    //Пустой лист
    private static final Object[] DEFAULTCAPACITY_EMPTY_LIST = {};
    //Создание пустого листа дефолтно
    public MyCustomArrayList(){
        this.list = DEFAULTCAPACITY_EMPTY_LIST;
    }
    //Создание пустого листа с заданым размером
    public MyCustomArrayList(int size){
        this.list = new Object[size];
    }
    //Увеличение листа
    private Object[] grow() {
        int oldCapacity = list.length;
        if (oldCapacity > 0 || list != DEFAULTCAPACITY_EMPTY_LIST) {
            int newCapacity = (int) (oldCapacity * 1.5 + 1);
            return list = Arrays.copyOf(list, newCapacity);
        } else {
            return list = new Object[Math.max(DEFAULT_CAPACITY, 1)];
        }
    }
    //Перемещение элементов по листу
    private Object[] createSupportList(boolean flag){
        Object[] elementData;
        if(flag){
            elementData = new Object[size+1];

        }else{
            elementData = new Object[size];
        }
        System.arraycopy(list, 0,
                elementData, 0, size);
        return elementData;
    }
    //Добавление элемента в лист
    public void add(E element) {
        if(this.list.length == 0 || size == list.length){
            this.list = grow();
        }
        list[size++] = element;
    }
    //Добавление элемента в лист по индексу, flag = true
    public void add(int index, E element) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
        if (size == this.list.length)
            this.list = grow();
        Object[] elementData = createSupportList(true);

        for(int i = elementData.length-1; i>index; i--){
            elementData[i] = elementData[i-1];
        }
        elementData[index] = element;

        list = elementData;
        size++;
    }
    //Ошибка переполнения листа
    private String outOfBoundsMsg(int i){
        return "Index " + i + ", size " + size;
    }
    //Добавление нескольких элементов в лист
    public Object[] addAll(Collection<? extends E> c) {
        Object[] a = c.toArray();
        Object[] elementData = new Object[a.length];
        System.arraycopy(a, 0, elementData, 0, a.length);

        list = elementData;
        size = list.length;
        return list;
    }
    //Очистка листа
    public void clear() {
        list = DEFAULTCAPACITY_EMPTY_LIST;
        size = 0;
    }
    //Получение элемента по индексу
    public E get(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
        return (E) list[index];
    }
    //Проверка на пустой лист
    public boolean isEmpty() {
        return size == 0;
    }
    //Удаление по индексу flag = false
    public E remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
        Object[] elementData = createSupportList(false);
        for(int i = index; i<elementData.length-1; i++){
            elementData[i] = elementData[i+1];
        }
        list = elementData;
        size--;
        return (E) list;
    }
    //Удаление первого в списке
    public boolean remove(Object o) {
        Object[] elementData = createSupportList(false);

        int index = -1;
        for(int i = 0; i<size; i++){
            if(list[i].equals(o)){
                index = i;
                break;
            }
        }
        if(index == -1){
            return false;
        }
        for(int i = index; i<elementData.length-1; i++){
            elementData[i] = elementData[i+1];
        }
        list = elementData;
        size--;
        return true;
    }
    //Сортировка
    public void sort(Comparator<? super E> comparator) {
        quickSort.quickSort((E[])list, 0, size-1, comparator);
    }
    //Вывод готового листа
    public Object getList(){
        Object[] elementData = createSupportList(false);
        list = elementData;
        return Arrays.toString(list);
    }
}