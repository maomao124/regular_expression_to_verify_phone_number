import java.awt.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Project name(项目名称)：正则表达式验证电话号码
 * Package(包名): PACKAGE_NAME
 * Class(类名): test
 * Author(作者）: mao
 * Author QQ：1296193245
 * Date(创建日期)： 2021/11/4
 * Time(创建时间)： 21:35
 * Version(版本): 1.0
 * Description(描述)：
 * 电话号码包括固定电话和手机号码。其中固定电话是由区号和号码组成，区号是以 0 开头的，后面是 2~3 位数，
 * 因此在匹配区号的时候可以使用正则表达式0\d{2,3}。固定电话号码由 7~8 位数字组成，因此可以使用表达式\d{7,8}来进行匹配。
 * 固定电话的组合方式可能是“区号-号码”或者是“区号号码”，因此匹配固定电话号码时，可以使用“0\\d{2,3}[-]?\\d{7,8}|0\\d{2,3}\\s?\\d{7,8}”表达式。
 * 手机号码是 11 位数，并且以数字 1 开头。考虑到手机号码的特殊性，这里使用“13[0-9]\\d{8}|15[1089]\\d{8}”表达式进行匹配。
 * 该正则表达式验证以 13 或 15 开头的手机号码； 以 15 开头的电话号码，第 3 位数字只能是 1、0、8、9 中的一个。
 */

public class test
{
    public static void main(String[] args)
    {
        if (args.length == 0)
        {
            String regex = "0\\d{2,3}[-]?\\d{7,8}|0\\d{2,3}\\s?\\d{7,8}|13[0-9]\\d{8}|15[1089]\\d{8}|18\\d{9}||19\\d{9}";
            String phone = "";
            Scanner input = new Scanner(System.in);
            System.err.println("提示：输入-1结束循环");
            while (true)
            {
                System.out.println("请输入电话号码：");
                phone = input.next();
                if (!phone.equals("-1"))
                {
                    Pattern p = Pattern.compile(regex);
                    Matcher m = p.matcher(phone);
                    boolean result = m.matches();
                    if (result)
                    {
                        System.out.println("输入正确");
                    }
                    else
                    {
                        Toolkit.getDefaultToolkit().beep();
                        System.out.println("输入错误！！！");
                    }
                }
                else
                {
                    break;
                }
            }
            System.out.println("结束循环");
        }
        else
        {
            String regex = "0\\d{2,3}[-]?\\d{7,8}|0\\d{2,3}\\s?\\d{7,8}|13[0-9]\\d{8}|15[1089]\\d{8}|18\\d{9}||19\\d{9}";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(args[0]);
            boolean b1 = false;
            for (String s : args)
            {
                m.reset(s);
                b1 = m.matches();
                if (b1)
                {
                    System.out.println("电话号码 " + s + "  正确");
                }
                else
                {
                    System.out.println("电话号码 " + s + "  错误");
                }
            }
        }
    }
}
