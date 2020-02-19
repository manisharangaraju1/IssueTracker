package com.issuetracker.issuetracker.datatransform;

import com.issuetracker.issuetracker.dto.Issue;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "issues", path = "issues")
public interface IssueRepository extends PagingAndSortingRepository<Issue, Long> {
    List<Issue> getAllIssues();
}
