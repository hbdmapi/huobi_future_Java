package com.huobi.future.wss;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.huobi.wss.handle.WssNotificationHandle;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URISyntaxException;
import java.util.List;

public class WssNotificationSubTest {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private String host="api.hbdm.com";
    private String url="/swap-notification";//注意地址上一定要带上"/"。
    //private String URL = "wss://api.hbdm.com/notification";//订单推送访问地址.更换请求的域名时，需将WssNotificationHandle类中的addAuth()方法里面的域名也一起替换掉。
    WssNotificationHandle wssNotificationHandle = new WssNotificationHandle( host , url , "", "");


    @Test
    public void test1() throws URISyntaxException, InterruptedException {
        List<String> channels = Lists.newArrayList();
        channels.add("positions.btc");
        channels.add("accounts.btc");
        wssNotificationHandle.sub(channels, response -> {
            logger.info("用户收到的数据===============:{}", JSON.toJSON(response));
        });
        Thread.sleep(Integer.MAX_VALUE);
    }


}
