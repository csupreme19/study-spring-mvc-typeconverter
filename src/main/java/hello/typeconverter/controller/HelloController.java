package hello.typeconverter.controller;

import hello.typeconverter.type.IpPort;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/hello-model")
    public String get(@ModelAttribute Member member) {
        log.info("{}", member);
        return "ok";
    }

    @GetMapping("/ip-port")
    public String ipPort(@RequestParam IpPort ipPort) {
        log.info("ipPort IP = {}", ipPort.getIp());
        log.info("ipPort PORT = {}", ipPort.getPort());
        return "ok";
    }

    @Data
    static class Member {
        private Long id;
        private String username;
    }

}
