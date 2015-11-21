// * * * * * * * * * * * * * * * * * * * * * * * *
// * REDROCK-TEAM HOMEWORK 6 (20151107)          *
// * Level 3 - Bag                               *
// * Author:  Haruue Icymoon                     *
// * Website: http://www.caoyue.com.cn/          *
// * * * * * * * * * * * * * * * * * * * * * * * *

package cn.com.caoyue.util;

/**
 * 一个可包含重复元素的集合类，正如其名称所暗示的，其模仿生活中常见的 bag 抽象。
 * @param <E> 此 bag 所维护的元素类型
 */
public class Bag<E>
        implements IBag<E> {
    private Object[] bagArray;
    private int size;
    private int length = 0;

    /**
     * 构造一个初始大小为 size 的 bag
     *
     * @param size
     */
    public Bag(int size) {
        bagArray = new Object[size];
        this.size = size;
    }

    /**
     * 构造一个具有默认初始大小 10 的 bag
     */
    public Bag() {
        this(10);
    }

    /**
     * 添加一个元素
     *
     * @param e 要添加到 bag 中的元素
     */
    @Override
    public void add(E e) {
        if (length < size) {
            bagArray[length] = e;
            length++;
        } else {
            Object origArray[] = bagArray;
            bagArray = new Object[size+1];
            System.arraycopy(origArray, 0, bagArray, 0, size);
            bagArray[size] = e;
            size++;
            length = size;
        }
    }

    /**
     * 删除指定元素
     *
     * @param e 要从 bag 删除的元素
     */
    @Override
    public void remove(E e) {
        if (null == e) return;  //不能删除 null
        while (true) {
            int index = indexOf(e);
            if (index < 0) return;  //删除完所有 e 就退出循环
            bagArray[index] = bagArray[length-1];
            bagArray[length-1] = null;
            length--;
        }
    }

    /**
     * 删除指定数量个指定元素
     *
     * @param e     要从 bag 删除的元素
     * @param count 要删除的元素的数量
     */
    @Override
    public void remove(E e, int count) {
        if (null == e) return;
        while (true) {
            int index = indexOf(e);
            if (index < 0 || count <= 0) return;
            bagArray[index] = bagArray[length-1];
            bagArray[length-1] = null;
            length--;
        }
    }

    /**
     * 删除 bag 中的所有元素
     */
    @Override
    public void clear() {
        bagArray = new Object[size];
        length = 0;
    }

    /**
     * 检查 bag 是否为空
     *
     * @return 为空则返回 true
     */
    @Override
    public boolean isEmpty() {
        return (length == 0);
    }

    /**
     * 获取 Bag 中指定位置上的元素
     *
     * @param index 元素在 bag 中的位置所对应的索引值
     * @return 获取的元素
     */
    @Override
    public E getIndex(int index) {
        return (E)bagArray[index];
    }

    /**
     * 如果 bag 中包含指定的元素，则返回 true
     *
     * @param o 指定的元素
     * @return 如果 bag 中包含指定的元素，则返回 true
     */
    @Override
    public boolean contains(E o) {
        return (indexOf(o) != -1);
    }

    /**
     * 在 bag 中寻找指定的元素，相当于 indexOf(o, 0)
     *
     * 请注意，在对 bag 做出任何修改操作之后，请重新使用改方法来获取新的位置
     * @param o 要寻找的元素
     * @return 元素在 bag 中第一次出现的位置所对应的索引值，如果没有找到，返回负值
     */
    @Override
    public int indexOf(E o) {
        return indexOf(o, 0);
    }

    /**
     * 从某一项开始，在 bag 中寻找指定的元素
     *
     * 请注意，在对 bag 做出任何修改操作之后，请重新使用改方法来获取新的位置
     * @param o          要寻找的元素
     * @param startIndex 寻找的起始位置
     * @return 元素在 bag 中寻找起始位置之后第一次出现的位置所对应的索引值，如果没有找到，返回负值
     */
    @Override
    public int indexOf(E o, int startIndex) {
        for (int i = startIndex; i < length; i++) {
            if (bagArray[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 返回这个 bag 的容量，即可容纳元素的数量
     *
     * @return 数组的容量，准确地说是这个 bag 在装满时最大索引值 + 1
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * 返回这个 bag 的大小，即所有非 null 元素的数量
     *
     * @return 这个 bag 的大小，准确地说是最大的索引值 + 1
     */
    @Override
    public int length() {
        return length;
    }

    /**
     * 将该 bag 转换为字符串
     * @return 表示该 bag 的字符串
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < length; i++) {
            sb.append(bagArray[i].toString());
            if (i == length - 1)
                return sb.append(']').toString();
            sb.append(',').append(' ');
        }
        return sb.append("]").toString();
    }
}
