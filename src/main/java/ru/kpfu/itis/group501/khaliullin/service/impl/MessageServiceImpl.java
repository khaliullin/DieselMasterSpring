package ru.kpfu.itis.group501.khaliullin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.group501.khaliullin.model.Discussion;
import ru.kpfu.itis.group501.khaliullin.model.Message;
import ru.kpfu.itis.group501.khaliullin.repository.MessageRepository;
import ru.kpfu.itis.group501.khaliullin.service.MessageService;

import java.util.List;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20170528
 */
@Service
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;

    int pageSize = 5;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public List<Message> getMessagesByDiscussion(Discussion discussion, int pageNumber) {
        Pageable pageable = new PageRequest(pageNumber, pageSize, Sort.Direction.DESC, "created");
        return messageRepository.findAllByDiscussion(discussion, pageable);
    }

    @Override
    public int getMaxPageNumber(Discussion discussion) {
        return messageRepository.countAllByDiscussion(discussion)/pageSize - 1;
    }

    @Override
    public void save(Message message) {
        messageRepository.save(message);
    }
}
