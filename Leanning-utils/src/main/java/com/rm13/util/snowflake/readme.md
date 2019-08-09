## 雪花算法
snowflake是Twitter开源的分布式ID生成算法，结果是一个long型的ID。其核心思想是：使用41bit作为毫秒数，10bit作为机器的ID（5个bit是数据中心，5个bit的机器ID），12bit作为毫秒内的流水号（意味着每个节点在每毫秒可以产生 4096 个 ID），最后还有一个符号位，永远是0。

![snowflake](/Users/chenyuan/Documents/project/collect/Leanning/Leanning-utils/src/main/resources/img/snowflake.png)

优点：全局唯一性，并发高，性能好，易恢复，易扩展

缺点：收时钟回拨影响

##
1）第1位：符号位，0表示正数，1表示负数，发号器第一位默认为0

2）第2-42位：时间戳，精确到毫秒

3）第43-52位：机器ID（机房ID+服务器ID）

4）第53-64位：序列号，自增长，支持同一个节点1ms可产生4096个ID



