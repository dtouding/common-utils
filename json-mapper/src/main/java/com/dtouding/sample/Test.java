package com.dtouding.sample;

import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.type.TypeReference;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Test {

    public static void main(String[] args) {
        SwordMan swordMan = new SwordMan();
        swordMan.setId("1");
        swordMan.setName("令狐冲");
        swordMan.setSex("男");
        swordMan.setAge(24);
        swordMan.setSkill("独孤九剑，吸星大法，易筋经");

        String json = JsonUtil.bean2Json(swordMan);
        String json2 = JsonUtil.bean2JsonPretty(swordMan);
        log.info(json);
        log.info(json2);

        SwordMan swordMan2 = JsonUtil.json2Bean(json, SwordMan.class);

        List<SwordMan> list = new ArrayList<SwordMan>();
        list.add(swordMan);
        list.add(swordMan2);
        String str = JsonUtil.bean2Json(list);
        log.info(str);

        List<SwordMan> list2 = JsonUtil.json2Bean(str, new TypeReference<List<SwordMan>>() {
        });
        System.out.println(list2);

        List<SwordMan> list3 = JsonUtil.json2Bean(str, List.class, SwordMan.class);
        System.out.println(list3);
    }
}
