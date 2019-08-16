package com.rm13.util;

import lombok.Data;

import java.util.List;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-08-15
 */
@Data
public class Ob {
    private String element;
    private String activityId;
    private Long subActivityId;
    private String locationUuid;
    private String optUuid;
    private List<String> issuedIdList;
}
