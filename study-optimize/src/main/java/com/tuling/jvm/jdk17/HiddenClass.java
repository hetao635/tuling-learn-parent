package com.tuling.jvm.jdk17;

import org.junit.Test;

import java.io.IOException;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

/**
 * 隐藏类
 */
public class HiddenClass {

    public String sayHello(String name){
        return "hello:" + name;
    }

    public static void printHello(String name) {
        System.out.printf("""
                    hello, \s 
                    hello, HillenClass \s
                """ + name);
    }

    @Test
    public void printHiddenClassBytesInBase64(){
        String classpath = "D:/HiddenClass.class";
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(classpath));
            System.out.println(Base64.getEncoder().encodeToString(bytes));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testInvokeHiddenClass() throws Throwable {
        String classInfo = "yv66vgAAAD0AOAoAAgADBwAEDAAFAAYBABBqYXZhL2xhbmcvT2JqZWN0AQAGPGluaXQ+AQADKClWEgAAAAgMAAkACgEAF21ha2VDb25jYXRXaXRoQ29uc3RhbnRzAQAmKExqYXZhL2xhbmcvU3RyaW5nOylMamF2YS9sYW5nL1N0cmluZzsJAAwADQcADgwADwAQAQAQamF2YS9sYW5nL1N5c3RlbQEAA291dAEAFUxqYXZhL2lvL1ByaW50U3RyZWFtOxIAAQAICgATABQHABUMABYAFwEAE2phdmEvaW8vUHJpbnRTdHJlYW0BAAZwcmludGYBADwoTGphdmEvbGFuZy9TdHJpbmc7W0xqYXZhL2xhbmcvT2JqZWN0OylMamF2YS9pby9QcmludFN0cmVhbTsHABkBACBjb20vdHVsaW5nL2p2bS9qZGsxNy9IaWRkZW5DbGFzcwEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBABJMb2NhbFZhcmlhYmxlVGFibGUBAAR0aGlzAQAiTGNvbS90dWxpbmcvanZtL2pkazE3L0hpZGRlbkNsYXNzOwEACHNheUhlbGxvAQAEbmFtZQEAEkxqYXZhL2xhbmcvU3RyaW5nOwEAEE1ldGhvZFBhcmFtZXRlcnMBAApwcmludEhlbGxvAQAVKExqYXZhL2xhbmcvU3RyaW5nOylWAQAKU291cmNlRmlsZQEAEEhpZGRlbkNsYXNzLmphdmEBABBCb290c3RyYXBNZXRob2RzDwYAKQoAKgArBwAsDAAJAC0BACRqYXZhL2xhbmcvaW52b2tlL1N0cmluZ0NvbmNhdEZhY3RvcnkBAJgoTGphdmEvbGFuZy9pbnZva2UvTWV0aG9kSGFuZGxlcyRMb29rdXA7TGphdmEvbGFuZy9TdHJpbmc7TGphdmEvbGFuZy9pbnZva2UvTWV0aG9kVHlwZTtMamF2YS9sYW5nL1N0cmluZztbTGphdmEvbGFuZy9PYmplY3Q7KUxqYXZhL2xhbmcvaW52b2tlL0NhbGxTaXRlOwgALwEAB2hlbGxvOgEIADEBACcgICAgaGVsbG8sICAKICAgIGhlbGxvLCBIaWxsZW5DbGFzcyAgCgEBAAxJbm5lckNsYXNzZXMHADQBACVqYXZhL2xhbmcvaW52b2tlL01ldGhvZEhhbmRsZXMkTG9va3VwBwA2AQAeamF2YS9sYW5nL2ludm9rZS9NZXRob2RIYW5kbGVzAQAGTG9va3VwACEAGAACAAAAAAADAAEABQAGAAEAGgAAAC8AAQABAAAABSq3AAGxAAAAAgAbAAAABgABAAAABgAcAAAADAABAAAABQAdAB4AAAABAB8ACgACABoAAAA7AAEAAgAAAAcrugAHAACwAAAAAgAbAAAABgABAAAACQAcAAAAFgACAAAABwAdAB4AAAAAAAcAIAAhAAEAIgAAAAUBACAAAAAJACMAJAACABoAAABAAAMAAQAAABKyAAsqugARAAADvQACtgASV7EAAAACABsAAAAKAAIAAAANABEAEQAcAAAADAABAAAAEgAgACEAAAAiAAAABQEAIAAAAAMAJQAAAAIAJgAnAAAADgACACgAAQAuACgAAQAwADIAAAAKAAEAMwA1ADcAGQ==";
        byte[] classInBytes = Base64.getDecoder().decode(classInfo);
        Class<?> proxy = MethodHandles.lookup()
                .defineHiddenClass(classInBytes, true, MethodHandles.Lookup.ClassOption.NESTMATE)
                .lookupClass();

        // 输出类名
        System.out.println(proxy.getName());
        // 输出类有哪些函数
        for (Method method : proxy.getDeclaredMethods()) {
            System.out.println(method.getName());
        }
        // 2. 调用对应的方法
        MethodHandle mhPrintHello = MethodHandles.lookup().findStatic(proxy, "printHello", MethodType.methodType(void.class, String.class));
        mhPrintHello.invokeExact("loulan");
        Object proxyObj = proxy.getConstructors()[0].newInstance();
        MethodHandle mhSayHello = MethodHandles.lookup().findVirtual(proxy, "sayHello", MethodType.methodType(String.class, String.class));
        System.out.println(mhSayHello.invoke(proxyObj, "loulan"));
    }
    
}
