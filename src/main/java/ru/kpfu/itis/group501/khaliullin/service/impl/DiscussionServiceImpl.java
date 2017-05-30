package ru.kpfu.itis.group501.khaliullin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.group501.khaliullin.model.Discussion;
import ru.kpfu.itis.group501.khaliullin.repository.DiscussionRepository;
import ru.kpfu.itis.group501.khaliullin.service.DiscussionService;

import java.util.List;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20170528
 */
@Service
public class DiscussionServiceImpl implements DiscussionService {
    private final DiscussionRepository discussionRepository;

    private int pageSize = 3;

    @Autowired
    public DiscussionServiceImpl(DiscussionRepository discussionRepository) {
        this.discussionRepository = discussionRepository;
    }

    @Override
    public List<Discussion> getAll(int pageNumber) {
        Pageable pageable = new PageRequest(pageNumber, pageSize);
        List<Discussion> discussions = discussionRepository.getAll(pageable);
        return discussions;
    }

    @Override
    public int getMaxPageNumber() {
        int totalNumber = discussionRepository.countAll();
        return totalNumber/pageSize - 1;
    }

    @Override
    public void save(Discussion discussion) {
        discussionRepository.save(discussion);
    }

    @Override
    public Discussion getDiscussion(Long id) {
        return discussionRepository.findOne(id);
    }
}
