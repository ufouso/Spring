package com.xpp.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xpp.test.domain.Record;

@RestController
@RequestMapping("/json")
public class TestJsonController {

	@GetMapping("/test1")
	public void twiceJson(@RequestBody Record record) {
		String a = record.getDate();
	}
}
