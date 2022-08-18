# 分页
主要采用的ORM框架为MyBatis-Plus,如果你对MyBatis-Plus不够了解，可访问[MyBatis-Plus官网](https://baomidou.com/)进行了解。

这里采用的分页是MyBatis-Plus封装的，拿来即用，流程如下：
XML编写:
```
<select id="selectPageList" resultType="xx.xx.XXVO"
            parameterType="xx.xx.XXReqDTO">
        SELECT
        	id,
            name
        FROM
        x_table
        <where>
            <if test="param.name != null and param.name!=''">
                and name LIKE concat('%',#{param.name},'%')
            </if>
            <if test="param.orderCon != null and param.orderCon!='' and param.sortCon != null and param.sortCon!=''">
                order by ${param.orderCon} ${param.sortCon}
            </if>
        </where>
    </select>

```


DAO编写:
```
 /**
     * 分页列表查询
     *
     * @param page
     * @param reqDTO
     * @return
     */
    IPage<XXVO> selectPageList(Page page, @Param("param") XXReqDTO reqDTO);


```

Service编写:
```
  /**
     * 列表分页查询
     *
     * @param reqDTO
     * @return
     */
    IPage<XXVO> queryPageList(XXReqDTO reqDTO);

```

ServiceImpl编写:
```
@Override
    public IPage<XXVO> queryPageList(XXDTO reqDTO) {
        Page<XXVO> page = new Page<>(reqDTO.getPageNum(), reqDTO.getPageSize());
        return XXMapper.selectPageList(page, reqDTO);
    }

```

关于MyBatis-Plus分页的更多信息，访问如下地址:
https://baomidou.com/guide/page.html

源代码示例:
https://github.com/developers-youcong/yc-framework/tree/main/yc-example/yc-example-page