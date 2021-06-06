package com.bean.bean.xml;

import org.springframework.stereotype.Component;

/**
 * <h3>bean</h3>
 *
 * @classname:XmlExample
 * @author:xiaodong
 * @date:2021-06-06 23:00:01
 * @description:
 */
@Component
public class XmlExample {
    public XmlExample() {
        System.out.println("Construct Example");
    }

    public void info() {
        System.out.println("Auto wiring example");
    }
}