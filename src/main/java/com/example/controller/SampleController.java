package com.example.controller;

import com.example.domain.SampleDTO;
import com.example.domain.SampleDTOList;
import com.example.domain.TodoDTO;
import lombok.extern.log4j.Log4j;
import org.apache.ibatis.javassist.tools.rmi.Sample;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {

    @RequestMapping("/")
    public void basic() {
        log.info("basic..........");
    }

    @GetMapping("/ex01")
    public String ex01(SampleDTO dto) {

        log.info("" + dto);

        return "ex01";
    }

    @GetMapping("/ex02")
    public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
        log.info("name: " + name);
        log.info("age: " + age);

        return "ex02";
    }

    @GetMapping("/ex02List")
    public String ex02List(@RequestParam("ids") List<SampleDTO> ids) {

        log.info("ids: " + ids);

        return "ex02List";
    }

    @GetMapping("/ex02Array")
    public String ex02Array(@RequestParam("ids") String[] ids) {

        log.info("ids: " + Arrays.toString(ids));

        return "ex02Array";
    }

    @GetMapping("/ex02Bean")
    public String ex02Bean(SampleDTOList list) {

        log.info("list dtos: " + list);

        return "ex02Bean";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
    }

    @GetMapping("/ex03")
    public String ex03(TodoDTO todo) {
        log.info("todo: " + todo);
        return "ex03";
    }

    @GetMapping("/ex04")
    public String ex04(SampleDTO dto, int page, RedirectAttributes rttr) {
        rttr.addFlashAttribute("name", "AAA");
        rttr.addFlashAttribute("age", 10);

        return "redirect:/";
    }

    @GetMapping("/ex05")
    public void ex05() {
        log.info("/ex05.......");
    }

    @GetMapping("/ex06")
    @ResponseBody
    public SampleDTO ex06() {
        log.info("/ex06.......");

        SampleDTO dto = new SampleDTO();
        dto.setAge(10);
        dto.setName("?????????");

        return dto;
    }

    @GetMapping("/ex07")
    public ResponseEntity<String> ex07() {
        log.info("/ex07.....");

        String msg = "{\"name\" : \"?????????\"}";

        HttpHeaders header = new HttpHeaders();
        header.add("Content-Type", "application/json;charset=UTF-8");

        return new ResponseEntity<>(msg, header, HttpStatus.OK);
    }


}