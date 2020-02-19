package com.issuetracker.issuetracker.controller;

import com.issuetracker.issuetracker.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IssueController {

    @Autowired
    private IssueService issueService;

    @CrossOrigin
    @RequestMapping(value = "/issues", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return ResponseEntity.ok().body(issueService.getAllIssues());
    }
}
