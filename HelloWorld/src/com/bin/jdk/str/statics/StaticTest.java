package com.bin.jdk.str.statics;

 
/**
 * �ڳ�������ʱ������ʵ����������ĳ����������ԣ����봴����ʵ������<br>
 * ���е�ʵ�������Żᱻ����ռ䣬����ʹ�����ʵ����������̬����������ĳ<br>
 * ��ʵ�����󣬶��������࣬����Ҳ��Ϊ�������ֻҪ�������������ֽ��룬<br>
 * ���ô����κ�ʵ�����󣬾�̬�����ͻᱻ����ռ䣬��̬�����Ϳ��Ա�ʹ���ˡ�<br>
 * ��֮��ʵ���������봴�������ſ���ͨ�����������ʹ�ã���̬���������<br>
 * ֱ��ʹ�����������á����磬��������ĳ������۴������ٸ�ʵ������<br>
 * ��Զ��ֻ������һ��<code>staticInt</code>����������ÿ����һ��ʵ������<br>
 * ���<code>staticInt</code>�ͻ��1�����ǣ�ÿ����һ��ʵ�����󣬾ͻ����һ��<code>random</code>��<br>
 * �����ܷ�����<code>random</code>������ÿ��<code>random</code>��ֵ��ֻ�Լ���1�Ρ�<br>
 *  
 */
public class StaticTest {

    private static int staticInt = 2;
    private int random = 2;
    
    public StaticTest() {
        staticInt++;
        random++;
        System.out.println("staticInt = "+staticInt+"  random = "+random);
    }

    public static void main(String[] args) {
        StaticTest test = new StaticTest();
        StaticTest test2 = new StaticTest();
    }
}