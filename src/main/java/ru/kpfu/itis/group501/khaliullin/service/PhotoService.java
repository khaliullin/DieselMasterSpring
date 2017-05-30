package ru.kpfu.itis.group501.khaliullin.service;

import ru.kpfu.itis.group501.khaliullin.model.Photo;

import java.util.List;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20170528
 */
public interface PhotoService {
    List<Photo> getPhotos(Long id, int pageNumber);

    int getMaxPage(Long id);
}

