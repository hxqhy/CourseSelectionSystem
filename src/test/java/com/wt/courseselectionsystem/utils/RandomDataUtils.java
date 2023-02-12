package com.wt.courseselectionsystem.utils;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author lixin
 */
public class RandomDataUtils {

    /**
     * 姓氏
     */
    private static final String[] surname = {
            "张", "杨", "王", "刘", "马", "朱", "赵", "钱", "孙", "黎", "李",
            "何", "郑", "高", "吴", "宋", "沙", "丁", "周", "朱", "黄",
    };

    private static final String[] boyName = {
            "建军", "清云", "永辉", "广志", "贵", "海", "云", "胜利", "强",
            "晓明", "宝华", "春秋", "中书", "京", "万", "星", "小东", "有义",
            "大壮", "东", "小龙", "小虎", "盛", "亮", "勇", "咏", "秋生", "磊",
            "华强", "杰"
    };

    private static final String[] girlName = {
            "小英", "小美", "敏", "小妹", "梅梅", "慧", "丽", "秀", "娜娜", "秋水",
            "秋菊", "菲菲", "晶晶", "小满", "玛丽", "妙妙", "若英", "翠翠", "娜", "紫",
            "瑶", "秀娟", "玉萍", "小凤", "洁", "芸", "月", "悦", "巧", "乔乔"
    };

    /**
     * 生成姓名
     *
     * @param gender 性别 0：女；1：男；
     * @return ...
     */
    public static String generateName(int gender) {
        return choice(surname) + (gender == 1 ? choice(boyName) : choice(girlName));
    }

    public static String choice(String[] strings) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return strings[random.nextInt(strings.length)];
    }

    public static int generateGender() {
        return ThreadLocalRandom.current().nextInt(2);
    }

    public static String randomDigit() {
        return String.valueOf(ThreadLocalRandom.current().nextInt(10));
    }
}
