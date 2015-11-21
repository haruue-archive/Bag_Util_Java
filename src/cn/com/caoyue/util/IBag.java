// * * * * * * * * * * * * * * * * * * * * * * * *
// * REDROCK-TEAM HOMEWORK 6 (20151107)          *
// * Level 3 - Bag                               *
// * Author:  Haruue Icymoon                     *
// * Website: http://www.caoyue.com.cn/          *
// * * * * * * * * * * * * * * * * * * * * * * * *

package cn.com.caoyue.util;

/**
 * 一个可包含重复元素的集合接口，正如其名称所暗示的，其模仿生活中常见的 bag 抽象。
 * @param <E> 此 bag 所维护的元素类型
 */
public interface IBag<E> {
    /**
     * 添加一个元素
     * @param e 要添加到 bag 中的元素
     */
    void add(E e);

    /**
     * 删除指定元素
     * @param e 要从 bag 删除的元素
     */
    void remove(E e);

    /**
     * 删除指定数量个指定元素
     * @param e 要从 bag 删除的元素
     * @param count 要删除的元素的数量
     */
    void remove(E e, int count);

    /**
     * 删除 bag 中的所有元素
     */
    void clear();

    /**
     * 检查 bag 是否为空
     * @return 为空则返回 true
     */
    boolean isEmpty();

    /**
     * 获取 Bag 中指定位置上的元素
     * @param index 元素在 bag 中的位置所对应的索引值
     * @return 获取的元素
     */
    E getIndex(int index);

    /**
     * 如果 bag 中包含指定的元素，则返回 true
     * @param o 指定的元素
     * @return 如果 bag 中包含指定的元素，则返回 true
     */
    boolean contains(E o);

    /**
     * 在 bag 中寻找指定的元素
     * @param o 要寻找的元素
     * @return 元素在 bag 中第一次出现的位置所对应的索引值，如果没有找到，返回负值
     */
    int indexOf(E o);

    /**
     * 从某一项开始，在 bag 中寻找指定的元素
     * @param o 要寻找的元素
     * @param startIndex 寻找的起始位置
     * @return 元素在 bag 中寻找起始位置之后第一次出现的位置所对应的索引值，如果没有找到，返回负值
     */
    int indexOf(E o, int startIndex);

    /**
     * 返回这个 bag 的容量，即可容纳元素的数量
     * @return 数组的容量，准确地说是这个 bag 在装满时最大索引值 + 1
     */
    int size();

    /**
     * 返回这个 bag 的大小，即所有非 null 元素的数量
     * @return 这个 bag 的大小，准确地说是最大的索引值 + 1
     */
    int length();
}
