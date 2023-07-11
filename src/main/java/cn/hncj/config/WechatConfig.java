package cn.hncj.config;

import cn.hncj.pojo.BirthDay;
import cn.hncj.pojo.User;

import java.util.ArrayList;
import java.util.List;

public class WechatConfig {
    /**
     * 你的微信的APPID
     * appId
     */
    public static final String VxAppId = "wxbcaa702690ed94cb";

    /**
     * 你的微信的密钥
     * appSecret
     */
    public static final String VxAppSecret = "30c122ba5fb55d72c931fd04b40e6fe8";

    public static final List<User> userList = new ArrayList<>();

    /**
     * 配置用户信息
     *
     *如果要多个人的话，就复制这个一遍，然后填写里面的内容。这里默认两个人,大伙应该是两个人吧（笑）
     *如果开启了master模式，除第一个用户外，其他用户只需要填写微信号
     * 要计算几个日期，就写几个new BirthDay,第一个在模板中是{{birthDay.DATA}}，第二个是{{birthDay1.DATA}}，第三个是{{birthDay2.DATA}}以此类推
     * new BirthDay()里面的参数分别代表：
     * 1. [年]，日期里面的数字，填正常的数字就行了.比如1就是1，不要填01
     * 2. [月]
     * 3. [日]
     * 4. [是否是农历(true 为农历、false 为公历)]
     * 5. [是否统计天数(true 为统计，false 为倒计时)]
     * 6. [倒计时到0天提示信息(如果类型为统计可以不填)]
     * 注意：每个用户信息的最后一项不需要加逗号！！！
     */
    static {
        userList.add(getUser(
                "oRJys6V5C3AE_kwJLexChsIQKKIw", //扫码关注你的测试号以后，测试平台会出现TA的微信号
                "iDxv1_kGZPjXa-eHOSGOAUJRZmVfnvKY9vWPP-alH18", //要给这个人发送的模板ID
                "壮壮同学", //咋称呼这个人
                "上海市普陀区", //这个人的详细地址
                "上海市", //这个人在的城市
                new BirthDay(1998,6,13,true,false,"大壮生日快乐！！"),
                new BirthDay(1998,7,12,true,false,"宝贝生日快乐哦~~"),
                new BirthDay(2024,3,24,false,false,"周年快乐！！！"),
                new BirthDay(2019,3,24,false,true)
        ));

//        userList.add(getUser(
//                "这个人扫码后的微信号",
//                "微信消息模板ID",
//                "小秦同学",
//                "上海市青浦区",
//                "上海",
//                new BirthDay(1998,7,12,true,false,"宝贝~生日快乐！！"),
//                new BirthDay(1998,6,13,true,false,"大壮生日快乐啦~~"),
//                new BirthDay(2024,3,24,false,false,"周年快乐！！！"),
//                new BirthDay(2019,3,24,false,true)
//        ));


    }

    private static User getUser(String vx, String templateId, String username, String address, String city, BirthDay... birthDays){
        User user=new User();
        user.setVx(vx);
        user.setUserName(username);
        user.setBirthDays(birthDays);
        user.setAddress(address);
        user.setCity(city);
        user.setTemplateId(templateId);
        return user;
    }
    private static User getUser(String vx, String templateId, String username, BirthDay... birthDays){
        return getUser(vx,templateId,username,null,null,birthDays);
    }
    private static User getUser(String vx, String templateId, BirthDay... birthDays){
        return getUser(vx,templateId,null,null,null,birthDays);
    }
    private static User getUser(String vx,BirthDay... birthDays){
        return getUser(vx,null,null,null,null,birthDays);
    }


}

//
//	  哈喽早上好,{{userName.DATA}}！
//	  今天是{{date.DATA}} 星期{{week.DATA}}
//    我们在一起的{{birthDay3.DATA}}天啦
//    你的生日还有{{birthDay1.DATA}}天
//    我的生日还有{{birthDay.DATA}}天
//    距离我们下一次纪念日还有{{birthDay2.DATA}}天
//    日出时间{{sunrise.DATA}},日落时间{{sunset.DATA}}
//    今天白天{{weatherDay.DATA}},温度{{temperatureDay.DATA}}℃,今天晚上{{weatherNight.DATA}},温度{{temperatureNight.DATA}}℃
//    明天白天{{weatherDay1.DATA}},温度{{temperatureDay1.DATA}}℃,明天晚上{{weatherNight1.DATA}},温度{{temperatureNight1.DATA}}℃
//    后天白天{{weatherDay1.DATA}},温度{{temperatureDay3.DATA}}℃,后天晚上{{weatherNight2.DATA}},温度{{temperatureNight2.DATA}}℃
//    注意事项:{{otherInfo.DATA}}
//
//    最后，今天要开心哦！
