public class Hello {

    public static void main(String[] args) {
        int a = 1;
        float b = 2.1f;
        long c = 3L;
        if (a*b > b) {
            System.out.println("a*b大于b, 值为：" + a*b);
        } else {
            System.out.println("a*b小于b, 值为：" + a*b);
        }
        System.out.println("a+b的值为" + (a + b));
        System.out.println("a-b的值为" + (a - b));
        System.out.println("c/a的值为" + (c / a));

        for (int i = 0; i < c; i++) {
            b++;
            System.out.println("第i次，b的值为 " + b);
        }


    }
}
字节码指令分析
将main形参中的args参数放到局部变量表中索引为0的位置
 0 iconst_1
将常量a的值1压倒操作数栈中
 1 istore_1
将常量a的值1出栈装入局部变量表索引为1的位置
 2 ldc #7 <2.1>
将b的值压到操作数栈中(接收 8 位参数)
 4 fstore_2
将b的值出栈装入局部变量表索引为2的位置
 5 ldc2_w #8 <3>
将c的值压到操作数栈中(接收两个 8 位参数)
 8 lstore_3
将c的值出栈装入局部变量表索引为3的位置
 9 iload_1
将局部变量表索引为1的值从局部变量表取出压栈
 10 i2f
将int类型常量a转换为float类型
 11 fload_2
将局部变量表索引为2的值从局部变量表取出压栈
 12 fmul
a和b进行乘法操作
 13 fload_2
将局部变量表索引为2的值从局部变量表取出压栈
 14 fcmpl	
比较两个元素的大小，并将结果放入操作数栈
 15 ifle 49 (+34)
If条件判断，当栈顶元素小于等于0时跳转到else语句上
 18 getstatic #10 <java/lang/System.out>
获取system类的out属性值
 21 new #16 <java/lang/StringBuilder>
New一个stringbuilder到操作数栈
 24 dup
复制
 25 invokespecial #18 <java/lang/StringBuilder.<init>>
执行StringBuilder的构造器方法
 28 ldc #19 <a*b大于b, 值为：>
加<a*b大于b, 值为：>压入操作数栈
 30 invokevirtual #21 <java/lang/StringBuilder.append>
执行StringBuilder的append方法
 33 iload_1
将局部变量表中索引为1的值压入操作数栈
 34 i2f
Int转float
 35 fload_2
将局部变量表中索引为2的值压入操作数栈
 36 fmul
进行乘法
 37 invokevirtual #25 <java/lang/StringBuilder.append>
执行append方法
 40 invokevirtual #28 <java/lang/StringBuilder.toString>
执行toString方法
 43 invokevirtual #32 <java/io/PrintStream.println>
执行pringln方法
 46 goto 77 (+31)
跳到第77行
 49 getstatic #10 <java/lang/System.out>
获取system类的out属性值
 52 new #16 <java/lang/StringBuilder>
NewStringBuilder
 55 dup
复制
 56 invokespecial #18 <java/lang/StringBuilder.<init>>
调StringBuilder的构造器方法
 59 ldc #38 <a*b小于b, 值为：>
加载常量到操作数栈
 61 invokevirtual #21 <java/lang/StringBuilder.append>
执行append方法
 64 iload_1
将局部变量表索引为1的值取出放到操作数栈
 65 i2f
Int转float
 66 fload_2
将局部变量表索引为2的值取出放到操作数栈
 67 fmul
相乘
 68 invokevirtual #25 <java/lang/StringBuilder.append>
略
 71 invokevirtual #28 <java/lang/StringBuilder.toString>
略
 74 invokevirtual #32 <java/io/PrintStream.println>
略
 77 getstatic #10 <java/lang/System.out>
略
 80 new #16 <java/lang/StringBuilder>
略
 83 dup
略
 84 invokespecial #18 <java/lang/StringBuilder.<init>>
略
 87 ldc #40 <a+b的值为>
略
 89 invokevirtual #21 <java/lang/StringBuilder.append>
略
 92 iload_1
略
 93 i2f
略
 94 fload_2
略
 95 fadd
加法运算
 96 invokevirtual #25 <java/lang/StringBuilder.append>
略
 99 invokevirtual #28 <java/lang/StringBuilder.toString>
略
102 invokevirtual #32 <java/io/PrintStream.println>
略
105 getstatic #10 <java/lang/System.out>
略
108 new #16 <java/lang/StringBuilder>
略
111 dup
略
112 invokespecial #18 <java/lang/StringBuilder.<init>>
略
115 ldc #42 <a-b的值为>
略
117 invokevirtual #21 <java/lang/StringBuilder.append>
略
120 iload_1
略
121 i2f
略
122 fload_2
略
123 fsub
略
124 invokevirtual #25 <java/lang/StringBuilder.append>
略
127 invokevirtual #28 <java/lang/StringBuilder.toString>
略
130 invokevirtual #32 <java/io/PrintStream.println>
略
133 getstatic #10 <java/lang/System.out>
略
136 new #16 <java/lang/StringBuilder>
139 dup
140 invokespecial #18 <java/lang/StringBuilder.<init>>
143 ldc #44 <c/a的值为>
145 invokevirtual #21 <java/lang/StringBuilder.append>
148 lload_3
149 iload_1
150 i2l
151 ldiv
152 invokevirtual #46 <java/lang/StringBuilder.append>
155 invokevirtual #28 <java/lang/StringBuilder.toString>
158 invokevirtual #32 <java/io/PrintStream.println>
161 iconst_0
162 istore 5
164 iload 5
166 i2l
167 lload_3
168 lcmp
169 ifge 207 (+38)
172 fload_2
173 fconst_1
174 fadd
175 fstore_2
176 getstatic #10 <java/lang/System.out>
179 new #16 <java/lang/StringBuilder>
182 dup
183 invokespecial #18 <java/lang/StringBuilder.<init>>
186 ldc #49 <第i次，b的值为 >
188 invokevirtual #21 <java/lang/StringBuilder.append>
191 fload_2
192 invokevirtual #25 <java/lang/StringBuilder.append>
195 invokevirtual #28 <java/lang/StringBuilder.toString>
198 invokevirtual #32 <java/io/PrintStream.println>
201 iinc 5 by 1
204 goto 164 (-40)
207 return