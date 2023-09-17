package com.blog.service;

import java.util.Map;

public interface ConfigService {
    /**
     * 修改配置项
     *
     *@Param configName
     *@Param configValue
     *@Return
     */
    int updateConfig(String configName, String configValue);

    // 获取所有的配置项
    /**
     * 获取所有的配置项
     */
    Map<String, String> getAllConfigs();

}
