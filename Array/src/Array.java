public class Array<E> {

    private E[] data;
    private int size;

    //构造函数，传入数组的容量capacity构造Array
    public Array(int capacity) {
        data = (E[])new Object[capacity];
        size = 0;
    }

    //无参构造函数，默认数组的容量capacity=10
    public Array() {this(10);}

    // 获取数组容量
    public int getCapacity() {
        return data.length;
    }
    //获取数组中的元素个数
    public int getSize() {
        return size;
    }
    //判断数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //增
    public void add(int index, E e) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }

        if(size == data.length) {
            resize(2 * data.length);
        }

        for(int i = size; i > index; -- i)
            data[i] = data[i - 1];

        data[index] = e;

        size ++;
    }

    //头增
    public void addFirst(E e) {
        add(0,e);
    }
    //尾增
    public void addLast(E e) {
        add(size,e);
    }

    // 删
    public E remove(int index) {
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Index is illegal.");

        E ret = data[index];
        for(int i = index + 1 ; i < size; ++ i){
            data[i - 1] = data[i];
        }

        size --;
        data[size] = null;

        if(size == data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);
        return ret;
    }
    // 头删
    public E removeFirst() {
        return remove(0);
    }
    // 尾删
    public E removeLast() {
        return remove(size - 1);
    }
    // 指定元素删
    public void removeElement(E e) {
        if(contains(e)) {
            int index = find(e);
            if(index != -1)
                remove(index);
        }
    }

    // 改
    public void set(int index, E e) {
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        data[index] = e;
    }

    // 泛查
    public Boolean contains(E e) {
        for(int i = 0; i < size; ++ i) {
            if(data[i] == e) {
                return true;
            }
        }
        return false;
    }
    // 精查
    public int find(E e) {
        for(int i = 0; i < size; ++ i) {
            if(data[i] == e) {
                return i;
            }
        }
        return -1;
    }
    // 查返
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for(int i = 0; i < size; ++ i) {
            res.append(data[i]);
            if(i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }

    // 动态数组
    private void resize(int newCapacity) {

        E[] newData = (E[])new Object[newCapacity];
        for(int i = 0; i < size; ++ i) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
