package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody //html에 나오는 body태그가 아닌, http통신 프로토콜의 응답body부에 내가 이 데이터를 직접 넣어주겠다는 의미.API방식
    public String helloString(@RequestParam("name") String name) {
        return "hello" + name; //"hello spring" 템플릿엔진과의 차이는 엔진같은게 없이 바로 문자가 그대로 내려감.
    }

    //만약 문자가 아닌, "데이터"를 내놓으라 한다면?
    //이것이 이 API방식의 웹개발을 쓰는 목적이다.
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}
