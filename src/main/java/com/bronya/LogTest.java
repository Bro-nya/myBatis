package com.bronya;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTest {
    private static final Logger logger = LoggerFactory.getLogger(LogTest.class);

    public static void main(String[] args) {
        logger.info("这是一条INFO信息");
        logger.debug("这是一条DEBUG信息");
        logger.error("这是一条ERROR信息", new Exception("测试异常"));

        try {
            int result = 1 / 0;
        } catch (Exception e) {
            logger.error("数学运算错误", e);
        }
    }
}