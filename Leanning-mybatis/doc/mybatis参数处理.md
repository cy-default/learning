

###### 单个参数:

```
mybatis不会做任何处理,任何参数名都可以#{sadfadsafs}
#{参数名}: 取出参数值.
```

###### 多个参数:

```
mybatis会做特殊处理.
  多个参数会被封装成一个map
		 key: param1...paramN, 或者参数的索引 0,1
		 value: 传入的参数值
  #{}就是从map中获取值

mybatis3.4.x之后, jdk1.8 多参数默认支持参数名查询

```

###### 命名参数:

```
明确指定封装参数值时map的key; @Param("id")
  多个参数会被封装成一个map,
  	key: 使用@Param注解指定的值
  	value: 参数值
  #{指定的key}取出对应的参数值
  
```

###### POJO:

```
如果多个参数正好时我们业务逻辑的数据模型, 我们就可以直接穿入pojo:
#{属性名}: 取出传入的pojo的属性值
```

###### Map:

```
如果多个参数不是业务模型中的数据, 没有对应的pojo,为了方便, 我们也可以传入map
#{key}: 取出map中对应的值
```



## 思考

```java
// jdk1.8/mybatis3.4
Employee getEmp(Integer id, String lastName);
//  取值: id ===>#{id}  lastName ===>#{lastName}

Employee getEmp(@param("id")Integer id, @param("lastName")String lastName);
//  取值: id ===>#{id}  lastName ===>#{lastName}

// 特别注意: 如果是Collection(List, Set)类型或者是数组, 也会特殊处理,
// 把传入的list或者数组封装在map中.
// 	key: Collection(collection),如果是List还是可以使用这个key(list)
//			  数组(array)
Employee getEmp(List<Integer> ids);
//  取值: 取出第一个id的值: #{list[0]}

```



## 参数处理源码

```java
/* 
Mybatis_03_MapperTests 
		--> MapperProxy 
			--> MapperMethod 
				--> method.convertArgsToSqlCommandParam(args)
					--> paramNameResolver.getNamedParams(args);
*/


// getEmpByIdAndLastName(Integer id, String lastName);
// ParamNameResolver 解析参数封装map
// names --> map --> {0:"id", 1:"lastName"} 构造器的时候就确定好了
  确定流程:
     1: 获取每个标了param注解的参数的@param的值; id, lastName: 赋值给name;
     2: 每次解析一个参数给map中保存信息, (key: 参数索引, value: name的值)
        name的值:
					标注了param注解: 注解的值
          没有标注:
							1:全局配置: useActualParamName(jdk1.8): name=参数名
              2:name = map.size(); 相当于当前元素的索引
     {0:"id", 1:"lastName"}

 public Object getNamedParams(Object[] args) {
    final int paramCount = names.size();
   	// 1:参数为null直接返回
    if (args == null || paramCount == 0) {
      return null;
      
    // 2:如果只有一个元素,并且没有param注解: 直接拿取: args[0]; 单个参数直接返回
    } else if (!hasParamAnnotation && paramCount == 1) {
      return args[names.firstKey()];
      
    // 3:多个参数或者有Param标注
    } else {
      final Map<String, Object> param = new ParamMap<>();
      int i = 0;
      
      // 4: 遍历names集合:{0:"id", 1:"lastName"}
      for (Map.Entry<Integer, String> entry : names.entrySet()) {
        
        // names集合中的value作为key, names集合的key又作为取值的参数args
        // {id:arg[0], lastName:arg[1]}
        param.put(entry.getValue(), args[entry.getKey()]);
        
        // 额外的将每一个参数也保存到map中, 使用新的key:param1, param2, ...
        // add generic param names (param1, param2, ...)
        final String genericParamName = GENERIC_NAME_PREFIX + String.valueOf(i + 1);
        // ensure not to overwrite parameter named with @Param
        if (!names.containsValue(genericParamName)) {
          param.put(genericParamName, args[entry.getKey()]);
        }
        i++;
      }
      return param;
    }
  }
```



## 参数值获取

```
#{} 以预编译的形式,将参数设置到sql语句中:PreparedStatement;规避SQL注入
	更丰富的用法:
		规定参数的一些规则:
		javaType, jdbcType, mode(存储过程), numericScale, resultMap, typeHandler, jdbcTypeName, expression(未来准备支持的功能)
		
		jdbcType通常要在某种特定的条件下被设置:
				在我们数据为null的时候, 有些数据库可能不能识别mybatis的默认处理. 比如oracle(报错): jdbcType OTHER: 无效的类型; 因为mybatis对所有的null都映射的是原生jdbc的OTHER类型. oracle无法处理.
		
${} 取出的值直接拼接在SQL语句中, 无法防止SQL注入
```











