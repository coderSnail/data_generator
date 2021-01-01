package com.zj.utils;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class GenerateUtil {
    // 手机号前缀
    final static String[] TEL_PREFIX = {"134", "135", "136", "137", "138", "139", "147", "150", "151", "152",
            "157", "158", "159", "165", "172", "178", "182", "183", "184", "187", "188", "198",
            "130", "131", "132", "145", "155", "156", "166", "171", "175", "176", "185", "186",
            "133", "149", "153", "173", "177", "180", "181", "189", "199"};
    // 姓氏
    final static String SURNAME_LIST = "李王张刘陈杨赵黄周吴徐孙胡朱高林何郭马罗梁宋郑谢韩唐冯于董萧程曹袁邓许傅沈曾彭吕" +
            "苏卢蒋蔡贾丁魏薛叶阎余潘杜戴夏钟汪田任姜范方石姚谭廖邹熊金陆郝孔白崔康毛邱秦江史顾侯邵孟龙万段雷钱汤尹黎易常武乔" +
            "贺赖龚文庞樊兰殷施陶洪翟安颜倪严牛温芦季俞章鲁葛伍韦申尤毕聂丛焦向柳邢骆岳齐尚梅莫庄辛管祝左涂谷祁时舒耿牟卜路詹" +
            "关苗凌费纪靳盛童欧甄项曲成游阳裴席卫查屈鲍位覃霍翁隋植甘";
    // 名字
    final static String NAME_LIST = "明国华建文平志伟东海强晓生光林小民永杰军波成荣新峰刚家龙德庆斌辉良玉俊立浩天宏子金健" +
            "一忠洪江福祥中正振勇耀春大宁亮宇兴宝少剑云学仁涛瑞飞鹏安亚泽世汉达卫利胜敏群松克清长嘉红山贤阳乐锋智青跃元南武广" +
            "思雄锦威启昌铭维义宗英凯鸿森超坚旭政传康继翔远力进泉茂毅富博霖顺信凡豪树和恩向道川彬柏磊敬书鸣芳培全炳基冠晖京欣" +
            "廷哲保秋君劲栋仲权奇礼楠炜友年震鑫雷兵万星骏伦绍麟雨行才希彦兆贵源有景升惠臣慧开章润高佳虎根诚夫声冬奎扬双坤镇楚" +
            "水铁喜之迪泰方同滨邦先聪朝善非恒晋汝丹为晨乃秀岩辰洋然厚灿卓轩帆若连勋祖锡吉崇钧田石奕发洲彪钢运伯满庭申湘皓承梓" +
            "雪孟其潮冰怀鲁裕翰征谦航士尧标洁城寿枫革纯风化逸腾岳银鹤琳显焕来心凤睿勤延凌昊西羽百捷定琦圣佩麒虹如靖日咏会久昕" +
            "黎桂玮燕可越彤雁孝宪萌颖艺夏桐月瑜沛杨钰兰怡灵淇美琪亦晶舒菁真涵爽雅爱依静棋宜男蔚芝菲露娜珊雯淑曼萍珠诗璇琴素梅" +
            "玲蕾艳紫珍丽仪梦倩伊茜妍碧芬儿岚婷菊妮媛莲娟";

    /**
     * 生成测试数据 - 手机号
     *
     * @return 手机号
     */
    public static String genTel() {
        String numbers = "1234567890";
        Random random = new Random();

        StringBuilder tel = new StringBuilder(TEL_PREFIX[random.nextInt(TEL_PREFIX.length)]);
        for (int i = 0; i < 8; i++) {
            tel.append(numbers.charAt(random.nextInt(numbers.length())));
        }
        return tel.toString();
    }

    /**
     * 生成测试数据 - 性别
     *
     * @return 性别
     */
    public static String genSex() {
        int i = new Random().nextInt(2);
        return i == 0 ? "男" : "女";
    }

    /**
     * 生成测试数据 - 年龄
     * 默认 0 - 100, 不包含 100
     *
     * @return 年龄
     */
    public static int genAge() {
        return new Random().nextInt(100);
    }


    /**
     * 生成测试数据 - 年龄
     *
     * @param min 最小年龄 包含在内
     * @param max 最大年龄 不包含在内
     * @return 年龄
     */
    public static int genAge(int min, int max) {
        // 如果 min >= max, 将 min 和 max 的值互换
        if (min >= max) {
            int temp = min;
            min = max;
            max = temp;
        }

        return min + new Random().nextInt(max - min);
    }

    /**
     * 生成随机 UUID
     *
     * @return 随机 UUID
     */
    public static String genUUID() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }

    /**
     * 生成中文名
     *
     * @return 两字或者三字的中文名
     */
    public static String genChineseName() {
        Random random = new Random();

        // 姓氏
        String surName = String.valueOf(SURNAME_LIST.charAt(random.nextInt(SURNAME_LIST.length())));
        // 名字( 2字 或者 3字)
        String name;
        if (random.nextInt(2) == 0) {
            // 2 字
            name = String.valueOf(NAME_LIST.charAt(random.nextInt(NAME_LIST.length())));
        } else {
            // 3 字
            name = String.valueOf(NAME_LIST.charAt(random.nextInt(NAME_LIST.length()))) + String.valueOf(NAME_LIST.charAt(random.nextInt(NAME_LIST.length())));
        }
        return surName + name;
    }

    /**
     * 根据截止日期和范围生成随机时间
     *
     * @param range   截止日期前的日期范围 (天数)
     * @param endDate 截止日期
     * @return 随机日期
     */
    public static Date genRandomDate(int range, Date endDate) {
        // 当前时间
        long end = endDate.getTime();
        int random = new Random().nextInt(range * 86400);
        return new Date(end - 1000 * (long) random);
    }

    /**
     * 根据日期范围生成随机时间 (当前日期之前)
     *
     * @param range 生成日期的范围 (天数)
     * @return 随机日期
     */
    public static Date genRandomDate(int range) {
        return genRandomDate(range, new Date());
    }
}
