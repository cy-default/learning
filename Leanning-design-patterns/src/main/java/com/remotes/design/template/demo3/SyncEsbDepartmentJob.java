package com.remotes.design.template.demo3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 同步失效的部门信息
 *
 * @author wang.pengfei
 * @date 2020/4/29 11:15
 */
@Slf4j
@Component
public class SyncEsbDepartmentJob {

    /*
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EsbDepartmentMapper esbDepartmentMapper;

    @Value("${esb.syn.department.url}")
    private String esbSynDepartmentUrl;

    // 同步生效的部门
    @Scheduled(cron = "0 0 1 * * ?")
    @RedisLocked(key = "ENABLED_DEPT", expire = 1000 * 60, timeout = 100)
    public void synEnabledDepartment() {
        Map<String, Object> queryParam = new LinkedHashMap<>();
        long count = count();
        if (count > 0) {
            queryParam.put("lastModifyDate", LocalDateUtil.format(LocalDate.now(), "yyyy-MM-dd"));
        }
        queryParam.put("status", "A");
        execute(queryParam);
    }

    // 同步失效的部门
    @Scheduled(cron = "0 0 2 * * ?")
    @RedisLocked(key = "DISABLED_DEPT", expire = 1000 * 60, timeout = 100)
    public void synDisabledDepartment() {
        Map<String, Object> queryParam = new LinkedHashMap<>();
        queryParam.put("lastModifyDate", LocalDateUtil.format(LocalDate.now(), "yyyy-MM-dd"));
        queryParam.put("status", "I");
        execute(queryParam);
    }

    private void execute(Map<String, Object> queryParam) {
        SyncEsbBaseJob job = new SyncEsbBaseJob(esbSynDepartmentUrl, restTemplate, queryParam) {
            @Override
            public void handle(List dataList) {
                dataList.forEach(e -> saveOrUpdateDept(JsonUtil.fromJson(JsonUtil.toJson(e), EsbDepartmentDTO.class)));
            }
        };
        job.execute();
    }

    @Transactional(rollbackFor = Exception.class)
    public void saveOrUpdateDept(EsbDepartmentDTO esbDepartmentDTO) {
        if ("I".equalsIgnoreCase(esbDepartmentDTO.getDeptStatus())) {
            EsbDepartmentExample example = new EsbDepartmentExample();
            example.createCriteria().andDeptCodeEqualTo(esbDepartmentDTO.getDeptCode());
            int res = esbDepartmentMapper.deleteByExample(example);
            log.info("同步部门信息已失效, deptCode:{}, 删除:{}", esbDepartmentDTO.getDeptCode(), res);
            return;
        }

        EsbDepartment esbDepartment = BeanUtils.copyProperties(esbDepartmentDTO, EsbDepartment.class);
        if (esbDepartmentDTO.getLastModifyDate() == null) {
            esbDepartment.setUpdateTime(LocalDateTime.now());
        } else {
            String modifyDate = esbDepartmentDTO.getLastModifyDate().trim().replaceAll("  ", " ");
            esbDepartment.setUpdateTime(LocalDateUtil.parseTime(modifyDate, CommonConstants.FORMAT_LOCAL_DATE_TIME));
        }

        EsbDepartmentExample example = new EsbDepartmentExample();
        example.createCriteria().andDeptCodeEqualTo(esbDepartmentDTO.getDeptCode());
        List<EsbDepartment> esbDepartments = esbDepartmentMapper.selectByExample(example);
        if (CollectionUtils.isNotEmpty(esbDepartments)) {
            EsbDepartment original = esbDepartments.get(0);
            esbDepartment.setId(original.getId());
            esbDepartment.setCreateTime(original.getCreateTime());
            esbDepartmentMapper.updateByPrimaryKeySelective(esbDepartment);
        } else {
            esbDepartment.setCreateTime(LocalDateTime.now());
            esbDepartmentMapper.insertSelective(esbDepartment);
        }
    }

    public long count() {
        return esbDepartmentMapper.countByExample(null);
    }

     */
}
