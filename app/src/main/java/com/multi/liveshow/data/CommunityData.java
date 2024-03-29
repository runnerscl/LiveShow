package com.multi.liveshow.data;

import com.multi.liveshow.R;

import java.util.ArrayList;
import java.util.List;


public class CommunityData {

    private static List<String> desList = new ArrayList<>();

    private static List<String> longDesList = new ArrayList<>();

    private static List<String> nickList = new ArrayList<>();

    private static List<Integer> headList = new ArrayList<>();

    private static List<List<Integer>> lists = new ArrayList<>();


    public static List<String> getDesList() {
        desList.clear();
        desList.add("不曾遇见的遇见总是那么惊喜");
        desList.add("没有伞的孩子,必须努力奔跑");
        desList.add("13823169140");
        desList.add("感觉几句话就能解释的事儿为什么别人就能长篇大论的越说越复杂");
        desList.add("溜了,溜了，再见!");
        desList.add("我OK的");
        desList.add("看花开花落，看世间繁华");
        desList.add("可以喜欢我一下吗，我很乖的");

        return desList;
    }


    public static List<String> getLongDesList() {
        longDesList.clear();

        longDesList.add("小酒窝 长睫毛 是你最美的记号" +
                "我每天睡不着 想念你的微笑" +
                "你不知道 你对我多么重要" +
                "有了你 生命完整的刚好" +
                "小酒窝 长睫毛 迷人的无可救药" +
                "我放慢了步调 感觉像是喝醉了" +
                "终于找到 心有灵犀的美好" +
                "一辈子暖暖的好 我永远爱你到老");
        longDesList.add("你看那云上草长莺飞" +
                "绽放着明天红色的花蕊" +
                "成长于苍茫茫的异乡" +
                "回首依然望见故乡月亮" +
                "黑夜给了我黑色眼睛" +
                "我却用它去寻找光明" +
                "汗水凝结成时光胶囊" +
                "独自在这命运里拓荒");

        longDesList.add("我跨上沙漠之舟" +
                "背上烟斗和沙漏" +
                "手里还握着一壶烈酒" +
                "漫长古道悠悠" +
                "说不尽喜怒哀愁" +
                "只有那骆驼奔忙依旧");

        longDesList.add("穿过落雁修竹 看过月升日暮" +
                "你说有一日总会名扬天下实现你抱负" +
                "那时低头替你剑穗缠着新流苏" +
                "心愿未听清楚");

        longDesList.add("曾经对上的瞬间，难道是一种错觉" +
                "那些流逝了的就永远都不会复现");

        longDesList.add("怅然入梦 梦几月 醒几年" +
                "往事凄艳 用情浅 两手缘" +
                "鹧鸪清怨 听得见 飞不回堂前" +
                "旧楹联红褪墨残谁来揭");

        longDesList.add("我总是轻描淡写告诉你我的愿望" +
                "也给你千言万语都说不尽的目光" +
                "这世界总有人在忙忙碌碌寻宝藏" +
                "却误了浮世骄阳 也错过人间万象");

        longDesList.add("想要的东西其实不多，我也可以选择都不说");

        return longDesList;
    }


    public static List<String> getNickList() {
        nickList.clear();

        nickList.add("梦想的天空分外蓝");
        nickList.add("胭竹");
        nickList.add("开心快乐每一天");
        nickList.add("寒冬夜行人");
        nickList.add("温暖似阳光");
        nickList.add(".");
        nickList.add("半糖");
        nickList.add("嗯。");
        return nickList;
    }

    public static List<Integer> getHeadList() {
        headList.clear();

        headList.add(R.mipmap.ting);
        headList.add(R.mipmap.yanzhu);
        headList.add(R.mipmap.lila);
        headList.add(R.mipmap.zhangcheng);
        headList.add(R.mipmap.huzhao);
        headList.add(R.mipmap.head);
        headList.add(R.mipmap.wen);
        headList.add(R.mipmap.nieqian);

        return headList;
    }


    public static List<List<Integer>> getLists() {

        lists.clear();

        List<Integer> tingList = new ArrayList<>();
        tingList.add(R.mipmap.ting1);
        tingList.add(R.mipmap.ting2);
        tingList.add(R.mipmap.ting3);

        List<Integer> yanzhuList = new ArrayList<>();
        yanzhuList.add(R.mipmap.yanzhu1);
        yanzhuList.add(R.mipmap.yanzhu2);
        yanzhuList.add(R.mipmap.yanzhu3);
        yanzhuList.add(R.mipmap.yanzhu4);
        yanzhuList.add(R.mipmap.yanzhu5);

        List<Integer> lilaList = new ArrayList<>();
        lilaList.add(R.mipmap.lila1);
        lilaList.add(R.mipmap.lila2);

        List<Integer> zhangchengList = new ArrayList<>();
        zhangchengList.add(R.mipmap.zhangcheng1);
        zhangchengList.add(R.mipmap.zhangcheng2);
        zhangchengList.add(R.mipmap.zhangcheng3);
        zhangchengList.add(R.mipmap.zhangcheng4);
        zhangchengList.add(R.mipmap.zhangcheng5);
        zhangchengList.add(R.mipmap.zhangcheng6);
        zhangchengList.add(R.mipmap.zhangcheng7);
        zhangchengList.add(R.mipmap.zhangcheng8);
        zhangchengList.add(R.mipmap.zhangcheng9);

        List<Integer> huzhaoList = new ArrayList<>();
        huzhaoList.add(R.mipmap.huzhao1);
        huzhaoList.add(R.mipmap.huzhao2);
        huzhaoList.add(R.mipmap.huzhao3);
        huzhaoList.add(R.mipmap.huzhao4);

        List<Integer> list = new ArrayList<>();
        list.add(R.mipmap.sea);

        List<Integer> wenList = new ArrayList<>();
        wenList.add(R.mipmap.wen);
        wenList.add(R.mipmap.wen);
        wenList.add(R.mipmap.wen);
        wenList.add(R.mipmap.wen);
        wenList.add(R.mipmap.wen);
        wenList.add(R.mipmap.wen);

        List<Integer> nieqianList = new ArrayList<>();
        nieqianList.add(R.mipmap.nieqian1);
        nieqianList.add(R.mipmap.nieqian2);
        nieqianList.add(R.mipmap.nieqian3);

        lists.add(tingList);
        lists.add(yanzhuList);
        lists.add(lilaList);
        lists.add(zhangchengList);
        lists.add(huzhaoList);
        lists.add(list);
        lists.add(wenList);
        lists.add(nieqianList);

        return lists;
    }


    public static void clear() {
        headList.clear();
        desList.clear();
        nickList.clear();
        lists.clear();
    }

}
