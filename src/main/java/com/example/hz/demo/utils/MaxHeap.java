package com.example.hz.demo.utils;

public class MaxHeap {
    // 堆的存储结构 - 数组
    private int[] data;
    private int heapsize;
    //parent

    /**
     *
     * @param i 索引
     * @return
     */
    // 获取右结点的数组下标
    private int right(int i) {
        return (i + 1) << 1;
    }

    // 获取左结点的数组下标
    private int left(int i) {
        return ((i + 1) << 1) - 1;
    }

    // 将一个数组传入构造方法，并转换成一个小根堆
    public MaxHeap(int[] data) {
        this.data = data;
        heapsize = data.length;
        buildHeap();
    }

    // 将数组转换成最小堆
    private void buildHeap() {
        // 完全二叉树只有数组下标小于或等于 (data.length) / 2 - 1 的元素有孩子结点，遍历这些结点。
        // *比如上面的图中，数组有10个元素， (data.length) / 2 - 1的值为4，a[4]有孩子结点，但a[5]没有*
        for (int i = (data.length) / 2 - 1; i >= 0; i--) {
            // 对有孩子结点的元素heapify
            heapify(i);
        }
    }

    private void heapify(int i) {
        // 获取左右结点的数组下标
        int l = left(i);
        int r = right(i);

        // 这是一个临时变量，表示 跟结点、左结点、右结点中最小的值的结点的下标
        int largest = i;

        // 存在左结点，且左结点的值小于根结点的值
        if (l < heapsize && data[l] > data[i]) {
            largest = l;
        }

        // 存在右结点，且右结点的值小于以上比较的较小值
        if (r < heapsize && data[r] > data[largest]) {
            largest = r;
        }

        // 左右结点的值都大于根节点，直接return，不做任何操作
        if (i == largest) {
            return;
        }

        // 交换根节点和左右结点中最小的那个值，把根节点的值替换下去
        swap(i, largest);

        // 由于替换后左右子树会被影响，所以要对受影响的子树再进行heapify
        heapify(largest);
    }
    // 交换元素位置
    private void swap(int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    // 获取对中的最大的元素，根元素
    public int getRoot() {
        return data[0];
    }

    // 替换根元素，并重新heapify
    public void setRoot(int root) {
        data[0] = root;
        heapify(0);
    }

    public void heapSort(){
        buildHeap();
        for(int i=data.length-1;i>=1;i--){
            swap(0,i);
            heapsize--;
            heapify(0);

        }
    }

    public static void main(String[] args)
    {
        // 源数据
        int[] data = {56,275,12,6,45,478,41,1236,456,12,546,45};

// 获取Top5
        MaxHeap heap = new MaxHeap(data);
        heap.heapSort();



        for(int i=0;i<data.length;i++)
        {
            System.out.println(data[i]);
        }
    }
}


