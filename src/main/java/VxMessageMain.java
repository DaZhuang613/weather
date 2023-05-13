import cn.hncj.config.WechatConfig;
import cn.hncj.pojo.User;
import cn.hncj.service.MessageService;
import cn.hncj.utils.ThreadPoolUtil;
import cn.hutool.core.collection.CollectionUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.TimeZone;

/**
 * github action对私有项目每个月有2000分钟的免费额度
 */
@Slf4j
public class  VxMessageMain {

    public static void main(String[] args) {
        long star = System.currentTimeMillis();
        try {
            TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
            MessageService messageService = new MessageService();
            List<User> userList =   WechatConfig.userList;
            if(CollectionUtil.isNotEmpty(userList)){
                for (int i = 0; i < userList.size(); i++) {
                    messageService.sendMessage(userList.get(i));
                    if(i != userList.size()){
                        try {
                            Thread.sleep(1234);
                        } catch (InterruptedException e) {
                            //do nothing
                        }
                    }
                }
            }
        }finally {
            ThreadPoolUtil.pool.shutdown();
            long end = System.currentTimeMillis();
            log.info("程序结束，耗时：{} ms",end-star);
        }
    }
}
