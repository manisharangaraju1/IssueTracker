package com.issuetracker.issuetracker.service;

import com.issuetracker.issuetracker.dto.Issue;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ComponentScan
@EnableAutoConfiguration
@SpringBootConfiguration
public class IssueService {

    public List<Issue> getAllIssues() {
        List<Issue> issues = new ArrayList<>();
        issues.add(new Issue(1,"New", "Manisha", new Date(), "2", "No Consistency"));
        issues.add(new Issue(2,"New", "Nikhita", new Date(), "0", "Too Awesome"));
        issues.add(new Issue(3,"New", "Vaibhav", new Date(), "-1", "Too Talented"));
        return issues;
    }
}
