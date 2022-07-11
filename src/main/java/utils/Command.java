//package utils;
//
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//import java.util.List;
//import java.util.Scanner;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//public class Command {
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        Class fun=
//        FunctionUtilsTest t=new FunctionUtilsTest();
//        List<Method> methods = Stream.of(fun.getDeclaredMethods())
//                .filter(m->!m.getName().equals("setUp"))
//                .filter(m->!m.getName().contains("lambda"))
//                .collect(Collectors.toList());
//        t.setUp();
//        while(true){
//            for(int i=0;i<methods.size();i++){
//                System.out.println(i+1+".\t"+methods.get(i).getName());
//            }
//            System.out.println("Please Choose the test case you wish to execute.");
//            int nos= scanner.nextInt();
//            Method m=methods.get(nos-1);
//            m.setAccessible(true);
//            try {
//                m.invoke(t);
//            } catch (IllegalAccessException e) {
//                throw new RuntimeException(e);
//            } catch (InvocationTargetException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//}
