package cn.hankin.net.pro.netty.base;

/**
 * @author hankin
 * @date 2020/7/23 13:32
 */
public class ReactorModel {

    /**
     * 传统I/O服务模型：
     *                                          ---------------------------------
     *              --------                   |        线程                    |
     *              |client|   ---请求--->     |     ------------------------   |
     *              --------                  |     |       Handler         |  |
     *                                        |     | read 业务处理 send     |  |
     *                                        ----------------------------------
     * 缺点：一个请求对应一个线程，支撑不了高并发
     *      没有事件就阻塞，浪费资源
     */

    /**
     *
     * Reactor模式：       多个client-> service Handler -> 工作线程池
     *  单Reactor单线程
     *  单Reactor多线程
     *  主从Reactor多线程
     *
     *
     *  单Reactor单线程：多个client ---请求----> Reactor(select dispatch)
     *                                         select --建立连接---> Acceptor(accept)
     *                                         dispatch --处理请求---> Handler(read 业务处理 send)
     *
     *
     * 单Reactor多线程：多个client ---请求----> Reactor(select dispatch)
     *                  Select --建立连接---> Acceptor(accept)
     *                  dispatch --处理请求---> Handler1(read send) ---分发---> worker线程池(分配线程处理业务)--结果->Handler1
     *                  dispatch --处理请求---> Handler2(read send) ---分发---> worker线程池(分配线程处理业务)--结果->Handler1
     *                  dispatch --处理请求---> Handler3(read send) ---分发---> worker线程池(分配线程处理业务)--结果->Handler1
     *
     *
     * 主从Reactor多线程:多个client ---请求----> Reactor主线程(select dispatch)--建立连接---> Acceptor(accept)
     *              Reactor主线程---分配连接--->SubReactor1--加入连接队列监听-->处理事件--->Handler1(read send) ---分发---> worker线程池(分配线程处理业务)--结果->Handler1
     *              Reactor主线程---分配连接--->SubReactor2--加入连接队列监听-->处理事件--->Handler2(read send) ---分发---> worker线程池(分配线程处理业务)--结果->Handler2
     *              Reactor主线程---分配连接--->SubReactor3--加入连接队列监听-->处理事件--->Handler3(read send) ---分发---> worker线程池(分配线程处理业务)--结果->Handler3
     */
}
