/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.bryant.austin.mail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 * @author austin bryant
 * @since 17/12/4 16:44
 */
@SpringBootApplication
public class App {

    private static final Log LOG = LogFactory.getLog(App.class);

    public static void main(String[] args) {
        LOG.info("start the web app ... ");
        SpringApplication.run(App.class, args);
        LOG.info("start the app success!");
    }
}
