## PageHelper最佳实践(重要！！！！！)
   
> https://mp.weixin.qq.com/s/ClbMDlBwVPjnpb_rkcQnmg


#### 1. doSelectPageInfo是什么?
答: doSelectPageInfo是PageHelper.startPage()函数返回的默认Page实例内置的函数,该函数可以用以Lambda的形式通过额外的Function来进行查询而不需要再进行多余的PageInfo与List转换,而doSelectPageInfo的参数则是PageHelper内置的Function(ISelect)接口用以达到转换PageInfo的目的

