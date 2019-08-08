## 雪花算法
snowflake是Twitter开源的分布式ID生成算法，结果是一个long型的ID。其核心思想是：使用41bit作为毫秒数，10bit作为机器的ID（5个bit是数据中心，5个bit的机器ID），12bit作为毫秒内的流水号（意味着每个节点在每毫秒可以产生 4096 个 ID），最后还有一个符号位，永远是0。

![snowflake](/Users/chenyuan/Documents/project/collect/Leanning/Leanning-utils/src/main/resources/img/snowflake.png)


- 0-1：符号为：默认为0
- 2-42：

