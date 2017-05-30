package ru.kpfu.itis.group501.khaliullin.service;

import ru.kpfu.itis.group501.khaliullin.model.Discussion;

import java.util.List;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20170528
 */
public interface DiscussionService {
    List<Discussion> getAll(int pageNumber);

    int getMaxPageNumber();

    void save(Discussion discussion);

    Discussion getDiscussion(Long id);
}
