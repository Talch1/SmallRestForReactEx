package com.talch.ex.controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class TodoController {
}
