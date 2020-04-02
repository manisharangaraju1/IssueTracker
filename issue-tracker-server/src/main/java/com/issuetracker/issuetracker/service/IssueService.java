package com.issuetracker.issuetracker.service;

import com.issuetracker.issuetracker.dto.Issue;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@ComponentScan
@EnableAutoConfiguration
@SpringBootConfiguration
public class IssueService {
    private List<Issue> issues = new ArrayList<>(Arrays.asList(
        new Issue(1,"New", "Manisha", new Date(), "2", "Issue 1"),
        new Issue(2,"New", "Nikhita", new Date(), "0", "Issue 2")));

    public List<Issue> getAllIssues() {
        return issues;
    }

    public Issue addIssue(Issue issue) {
        issue.setId(issues.size()+1);
        issues.add(issue);
        return issue;
    }
}
