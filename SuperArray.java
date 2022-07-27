public class SuperArray {

    //静态常量定义:
    public static final int theSmallOneIsInFront = 0;

    public static final int theBigOneIsInFront = 1;

    //成员变量定义:
    private int[] elements;

    private int currentIndex = -1;

    //构造器定义:
    public SuperArray(){
        elements = new int[10];
    }

    public SuperArray(int capacity){
        elements = new int[capacity];
    }

    //静态代码块定义:
    static {
        System.out.println("Welcome to use super array!");
    }

    //成员方法定义:
    //增:
    public void add(int data){
        currentIndex++;
        if (currentIndex > elements.length - 1){
            int[] temp;
            temp = new int[elements.length * 2];
            for (int i = 0; i < elements.length; i++) {
                temp[i] = elements[i];
            }
            elements = temp;
        }
        elements[currentIndex] = data;
    }

    //删:
    public void delete(int index){
        if (index < 0 || index > elements.length - 1){
            System.out.println("Index error(index == "+ index +"), can't delete.");
        } else{
            for (int i = index + 1; i < elements.length - 1; i++) {
                elements[i - 1] = elements[i];
            }
            currentIndex--;
        }
    }

    //改:
    public void set(int index, int data){
        if (index < 0 || index > elements.length - 1){
            System.out.println("Index error(index == "+ index +"), can't set.");
        } else{
            elements[index] = data;
        }
    }

    //查:
    public int select(int index){
        if (index < 0 || index > elements.length - 1){
            System.out.println("Index error(index == "+ index +"), can't delete.");
            return -404;
        } else{
            return elements[index];
        }
    }

    //长度:
    public int size(){
        return currentIndex - 1;
    }

    //数组转字符串:
    public String arrayToString(){
        String result = "[";
        for (int i = 0; i < currentIndex; i++) {
            result += elements[i] + ", ";
        }
        result = result.substring(0, result.length() - 1) + "]";
        return result;
    }

    //排序:
    public void sortAndOutput(int choose){
        int test;
        if (choose == 0){
            for (int i = 0; i < elements.length - 1; i++) {
                for (int j = 0; j < elements.length - 1; j++) {
                    if (elements[j] > elements[j + 1]){
                        test = elements[j];
                        elements[j] = elements[j + 1];
                        elements[j + 1] = test;
                    }
                }
            }
        } else if (choose == 1) {
            for (int i = 0; i < elements.length - 1; i++) {
                for (int j = 0; j < elements.length - 1; j++) {
                    if (elements[j] < elements[j + 1]){
                        test = elements[j];
                        elements[j] = elements[j + 1];
                        elements[j + 1] = test;
                    }
                }
            }
        }
        else{
            System.out.println("Parameter is error!");
        }
        for (int i = 0; i < elements.length; i++) {
            System.out.println(elements[i] + " ");
        }
    }

    //扩容:
    public void dilatation(int ExpandMultiple){
        int[] temp;
        temp = new int[elements.length * ExpandMultiple];
        for (int i = 0; i < elements.length; i++) {
            temp[i] = elements[i];
        }
        elements = temp;
    }

    //统计出现次数:
    public int OccurrenceNumber(int data){
        int frequency = 0;
        for (int i = 0; i < elements.length; i++) {
            if (data == elements[i]){
                frequency++;
            }
        }
        return frequency;
    }
}
