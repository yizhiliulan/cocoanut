package com.blueprint.stone.elasticsearch;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;


/**
 * ClassName:GetConnection Date: 2018年3月20日 下午8:12:07
 *
 * @author xbq
 * @version
 * @since JDK 1.8
 */
public class GetConnection {

    public final static String HOST = "127.0.0.1";
    // http请求的端口是9200，客户端是9300
    public final static int PORT = 9300;

    public static TransportClient client = null;

    /**
     * getConnection:(获取es连接).
     * @author xbq Date:2018年3月21日上午11:52:02
     * @return
     * @throws Exception
     */
    @SuppressWarnings({"resource", "unchecked"})
    public static TransportClient getConnection() throws Exception {
        // 设置集群名称
        Settings settings = Settings.builder().put("cluster.name", "my-application").build();
        // 创建client
         client = new PreBuiltTransportClient(settings)
                .addTransportAddresses(new InetSocketTransportAddress(InetAddress.getByName(HOST), 9300));

        //client.close();
        return client;
    }

    public static void main(String[] args) throws Exception {
        TransportClient client = getConnection();
        System.out.println("client==" + client.toString());
    }
}