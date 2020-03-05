package com.issuetracker.issuetracker.controller;

import com.issuetracker.issuetracker.dto.Issue;
import com.issuetracker.issuetracker.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class IssueController {

    @Autowired
    private IssueService issueService;

    @CrossOrigin
    @RequestMapping(value = "/issues", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return ResponseEntity.ok().body(issueService.getAllIssues());
    }

    @CrossOrigin
    @RequestMapping(value = "/issues", method = RequestMethod.POST)
    public ResponseEntity addIssue(@RequestBody Issue issue) {
            System.out.println(issue);
             return ResponseEntity.ok().body(issueService.addIssue(issue));
    }
}
