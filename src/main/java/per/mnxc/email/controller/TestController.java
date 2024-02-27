package per.mnxc.email.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.mnxc.email.utils.SendEmailUtil;

import javax.annotation.Resource;

/**
 * @BelongsProject: email-server
 * @BelongsPackage: per.mnxc.controller
 * @Author: jiangao
 * @CreateTime: 2024-02-27  15:52
 * @Description: 测试
 * @Version: 1.0
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Resource
    private SendEmailUtil sendEmailUtil;
    @GetMapping
    public String test() {
        sendEmailUtil.sendSimpleEmail("gekwoc@staxw.com","[TEST QQ EMAIL]","test");
        return "test";
    }
}
