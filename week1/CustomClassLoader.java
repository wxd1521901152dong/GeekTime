
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * <h3>geek</h3>
 *
 * @classname:CustomClassLoader
 * @author:xiaodong
 * @date:2021-05-07 15:56:41
 * @description: 第一周作业:
 * 2.（必做）自定义一个 Classloader，加载一个 Hello.xlass 文件，执行 hello 方法，此文件内容是一个 Hello.class 文件所有字节（x=255-x）处理后的文件。文件群里提供。
 */
public class CustomClassLoader extends ClassLoader {

    private static final String className = "Hello";

    private static final String methodName = "hello";

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        CustomClassLoader customClassLoader = new CustomClassLoader();
        Class<?> clazz = customClassLoader.loadClass(className);
        Object o = clazz.getDeclaredConstructor().newInstance();
        Method method = clazz.getMethod(methodName);
        method.invoke(o);


    }

    @Override
    protected Class<?> findClass(String name) {

        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream( name + ".xlass");
        try {
            int length = inputStream.available();
            byte[] bytes = new byte[length];
            inputStream.read(bytes);
            byte[] classBytes = decode(bytes);
            return defineClass(name, classBytes, 0, classBytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private static byte[] decode(byte[] bytes) {

        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (255 - bytes[i]);
        }

        return bytes;
    }
}
