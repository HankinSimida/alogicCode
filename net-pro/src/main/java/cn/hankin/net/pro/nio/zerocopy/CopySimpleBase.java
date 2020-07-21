package cn.hankin.net.pro.nio.zerocopy;

/**
 * @author hankin
 * @date 2020/7/21 13:06
 */
public class CopySimpleBase {
    /**
     * 零拷贝：没有CPU的拷贝
     *
     * 传统拷贝流程：四次拷贝 3从切换
     *
     *【User space】          ----CPU Copy-->user buffer ----CPU Copy-------
     *                       |                                             |
     *【Kernel space】  Kernel buffer                                 Socket buffer
     *                      /\                                            |
     *                      | <---DMA copy                                | <---DMA copy
     *                  Hard driver                                  protocol engine
     *
     *
     * DMA:(direct memory access):内存直接拷贝（不使用CPU）
     */



    /**
     * mmap优化：内存映射，文件映射到内核buffer，同时用户空间共享内核空间数据  拷贝3次 状态切换3次
     *
     *【User space】          ----shard-->user buffer
     *                       |
     *【Kernel space】  Kernel buffer  <-----CPU Copy------------Socket buffer
     *                      /\                                            |
     *                      | <---DMA copy                                | <---DMA copy
     *                  Hard driver                                  protocol engine
     *
     *
     * */


    /**
     * sendFile优化：Linux2.1提供sendFile函数
     * 原理：数据不经过用户态直接从内核buffer到socket buffer
     *
     *  3次拷贝 2次切换
     *
     *【Kernel space】  Kernel buffer<---------CPU Copy------------->Socket buffer
     *                      /\                                            |
     *                      | <---DMA copy                                | <---DMA copy
     *                  Hard driver                                  protocol engine
     *
     *
     */

    /**
     * sendFile优化2：Linux2.4对sendFile优化
     *                               --------------DMA copy-------------------------------------------
     *                              |                                                                |
     * 【Kernel space】        Kernel buffer---cpu copy desc(少部分数据)--->Socket buffer--DMA copy-->|
     *                            /\                                                                |
     *                            | <---DMA copy                                                    | <---DMA copy
     *                        Hard driver                                                       protocol engine
     *
     * 2次拷贝 均为DMA拷贝，虽然有一次CPU拷贝 但是数据量极少可忽略
     * 2次上下文切换
     *
     */

    /**
     *
     * mmap（内存映射）：适合小数据读写，3次上下文切换 3次拷贝 不能避免CPU拷贝
     * sendFile:适合大文件传输 2次上下文切换 2次拷贝
     */





























}
