package com.monkjavaer.learn.springbootpure;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * spring依赖注入的方式
 * ● 基于构造函数的依赖注入（@Autowired可以省略）
 * ● 基于setter的依赖注入（@Autowired可以省略）
 * ● 基于字段的依赖注入（@Autowired  spring中已经不建议使用）
 *
 * @author monkjavaer
 * @datetime 2022年 05月 02日 20:02
 */
//@Controller
@RestController
public class DiController {

    //    @Autowired
//    @Resource
    private DiHandler diHandler;

    //    @Autowired
    public DiController(DiHandler diHandler) {
        this.diHandler = diHandler;
    }

//    @Autowired
//    public void setDiHandler(DiHandler diHandler) {
//        this.diHandler = diHandler;
//    }

    @PostMapping("/handle-di")
    public String handleDi() {

        return diHandler.handleDi();
    }

}
