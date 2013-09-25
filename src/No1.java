/**
 * Created by Guanfu on 13-8-29.
 */
public class No1 {
    public static String weixianjiance(String[] weixianzifu, String jianceString) {
        //遍历危险字符数组，对比“对比字符串”中是否含有此字符，有则替换为“”

        for (String el : weixianzifu) {
            if (jianceString.contains(el)) {
                jianceString = jianceString.replace(el, "");

            }
        }
        return jianceString;

    }
}
