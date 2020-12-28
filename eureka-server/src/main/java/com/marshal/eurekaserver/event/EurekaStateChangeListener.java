package com.marshal.eurekaserver.event;

import com.netflix.appinfo.InstanceInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.eureka.server.event.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName: EurekaStateListener
 * @Description: Eureka注册中心监听事件服务
 * @Author lixiao.yuan
 * @Date 2020/12/25 0025 17:37
 */
//@Component
//@ComponentScan
//public class EurekaEventListener {
//    private static final Logger logger = DAPTraceLoggerFactory.getLogger(EurekaEventListener.class);
//
//    @EventListener(condition = "#event.replication==false")
//    public void listen(EurekaInstanceCanceledEvent event) {
//        String msg = "服务" + event.getAppName() + "\n" + event.getServerId() + "已下线";
//        logger.info(msg);
//    }
//
//    @EventListener(condition = "#event.replication==false")
//    public void listen(EurekaInstanceRegisteredEvent event) {
//        InstanceInfo instanceInfo = event.getInstanceInfo();
//        String msg = "服务" + instanceInfo.getAppName() + "\n" + instanceInfo.getHostName() + ":" + instanceInfo.getPort() + " \nip: " + instanceInfo.getIPAddr() + "进行注册";
//        logger.info(msg);
//
//    }
//
//    @EventListener
//    public void listen(EurekaInstanceRenewedEvent event) {
//        logger.info("服务{}进行续约", event.getServerId() + "  " + event.getAppName());
//    }
//
//    @EventListener
//    public void listen(EurekaRegistryAvailableEvent event) {
//        logger.info("注册中心启动,{}", System.currentTimeMillis());
//    }
//
//    @EventListener
//    public void listen(EurekaServerStartedEvent event) {
//        logger.info("注册中心服务端启动,{}", System.currentTimeMillis());
//    }

//}

@Component
@ComponentScan
public class EurekaStateChangeListener {
    private static final Logger logger = LoggerFactory.getLogger(EurekaStateChangeListener.class);

    @EventListener
    public void listen(EurekaInstanceCanceledEvent event) {
        logger.info("ServerId:{} \t AppName:{}服务下线",event.getServerId(),event.getAppName());
//        System.err.println(event.getServerId() + "\t" + event.getAppName() + " 服务下线 ");
    }

    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event) {
        InstanceInfo instanceInfo = event.getInstanceInfo();
//        String msg = "服务" + instanceInfo.getAppName() + "\n" + instanceInfo.getHostName() + ":" + instanceInfo.getPort() + " \nip: " + instanceInfo.getIPAddr() + "进行注册";

        logger.info("AppName:{} \t{}:{}\t ip:{} 进行注册 ",instanceInfo.getAppName(),instanceInfo.getHostName(),instanceInfo.getPort(),instanceInfo.getIPAddr());
//        System.err.println(instanceInfo.getAppName() + " 进行注册 ");
    }

    @EventListener
    public void listen(EurekaInstanceRenewedEvent event) {
        logger.info("ServerId:{} \t AppName:{} 服务进行续约 ",event.getServerId(),event.getAppName());
//        System.err.println(event.getServerId() + "\t" + event.getAppName() + " 服务进行续约 ");
    }

    @EventListener
    public void listen(EurekaRegistryAvailableEvent event) {
        logger.info(" 注册中心启动 ");
//        System.err.println(" 注册中心启动 ");
    }

    @EventListener
    public void listen(EurekaServerStartedEvent event) {
        logger.info(" Eureka Server启动 ");
//        System.err.println("Eureka Server启动 ");
    }
}