package ru.kpfu.itis.group501.khaliullin.service;

import ru.kpfu.itis.group501.khaliullin.model.Discussion;
import ru.kpfu.itis.group501.khaliullin.model.Message;

import java.util.List;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20170528
 */
public interface MessageService {
    List<Message> getMessagesByDiscussion(Discussion discussion, int pageNumber);

    int getMaxPageNumber(Discussion discussion);

    void save(Message message);
}
