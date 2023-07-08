package com.tek.algo.characters.test;

import com.tek.algo.characters.data.RandomDataGenerator;
import com.tek.algo.characters.sitbesides.RemoveSitbesidesBaseFunction;
import com.tek.algo.characters.sitbesides.RemoveSitbesidesByDoublePointer;
import com.tek.algo.characters.sitbesides.RemoveSitbesidesInterface;
import com.tek.algo.characters.util.FunctionUtil;

public class SitBesidesAlgoTest {

    /**
     * with replace operator while remove
     * @return
     */
    public static Double globalTestOfDoublePointerWithReplaceFunction(){
        Integer counts = 1000;
        Integer errors  = 0;
        RemoveSitbesidesInterface basic = new RemoveSitbesidesBaseFunction();
        RemoveSitbesidesInterface doublePointer = new RemoveSitbesidesByDoublePointer();

        for (int i = 0; i < counts; i++) {
            String str = RandomDataGenerator.getRandomString(5,20);
            basic.valid(str, FunctionUtil.validFunction);
            doublePointer.valid(str,FunctionUtil.validFunction);

            String b = basic.process(str,FunctionUtil.replaceFunction,(printa,printb,printc)->{return null;});
            String d = doublePointer.process(str,FunctionUtil.replaceFunction,(printa,printb,printc)->{return null;});
            if(b.compareTo(d)!=0){
                System.out.println("globalTestOfDoublePointerWithReplaceFunction error");
                System.out.println("replace - oringinal string: " + str);
                System.out.println("replace - basic: " +b);
                System.out.println("replace - double pointre: " + d);
                System.out.println("---------------------");
                errors++;
            }
        }
        return (double)((counts - errors)/counts);
    }

    /**
     * just remove
     * @return
     */
    public static Double globalTestOfDoublePointer(){
        Integer counts = 1000;
        Integer errors  = 0;
        RemoveSitbesidesInterface basic = new RemoveSitbesidesBaseFunction();
        RemoveSitbesidesInterface doublePointer = new RemoveSitbesidesByDoublePointer();
        for (int i = 0; i < counts; i++) {
            String str = RandomDataGenerator.getRandomString(5,20);
            basic.valid(str, FunctionUtil.validFunction);
            doublePointer.valid(str,FunctionUtil.validFunction);


            String b = basic.process(str,FunctionUtil.normalFunction,(printa,printb,printc)->{return null;});
            String d = doublePointer.process(str,FunctionUtil.normalFunction,(printa,printb,printc)->{return null;});
            if(b.compareTo(d)!=0){
                System.out.println("remove - globalTestOfDoublePointer error");
                System.out.println("remove - oringinal string: " + str);
                System.out.println("remove - basic: " +b);
                System.out.println("remove - double pointre: " + d);
                System.out.println("---------------------");
                errors++;
            }
        }
        return (double)((counts - errors)/counts);
    }

    public static void main(String[] args) {

        Double result = globalTestOfDoublePointer();
        System.out.println(" globalTestOfDoublePointer pass rate：" + result);

        Double result2 = globalTestOfDoublePointerWithReplaceFunction();
        System.out.println(" globalTestOfDoublePointer pass rate：" + result2);
    }
}
