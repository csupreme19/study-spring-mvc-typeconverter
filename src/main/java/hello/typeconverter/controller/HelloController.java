package hello.typeconverter.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Member;

@Slf4j
@RestController
public class HelloController {

    @GetMapping("/hello-v1")
    public String helloV1(HttpServletRequest request) {
        String data = request.getParameter("data"); //문자 타입 조회
        Integer intValue = Integer.valueOf(data); //숫자 타입으로 변경
        log.info("intValue = {}", intValue);
        return "ok";
    }

    @GetMapping("/hello-v2")
    public String helloV2(@RequestParam Integer data) {
        log.info("intValue = {}", data);
        return "ok";
    }

    @GetMapping("/{value}")
    public String get(@PathVariable Integer data) {
        log.info("{}", data);
        return "ok";
    }

    @GetMapping("/{value}")
    public String get(@PathVariable Member member) {
        log.info("{}", member);
        return "ok";
    }

    @Data
    static class Member {
        private Long id;
        private String username;
    }

}
