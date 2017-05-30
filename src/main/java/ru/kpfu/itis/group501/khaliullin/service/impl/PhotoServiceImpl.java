package ru.kpfu.itis.group501.khaliullin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.group501.khaliullin.model.Match;
import ru.kpfu.itis.group501.khaliullin.model.Photo;
import ru.kpfu.itis.group501.khaliullin.repository.MatchRepository;
import ru.kpfu.itis.group501.khaliullin.repository.PhotoRepository;
import ru.kpfu.itis.group501.khaliullin.service.PhotoService;

import java.util.List;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20170528
 */
@Service
public class PhotoServiceImpl implements PhotoService {
    private final PhotoRepository photoRepository;
    private final MatchRepository matchRepository;

    private int pageSize = 12;

    @Autowired
    public PhotoServiceImpl(PhotoRepository photoRepository, MatchRepository matchRepository) {
        this.photoRepository = photoRepository;
        this.matchRepository = matchRepository;
    }


    @Override
    public List<Photo> getPhotos(Long id, int pageNumber) {
        Pageable pageable = new PageRequest(pageNumber, pageSize, Sort.Direction.ASC, "name");
        Match match = matchRepository.findOne(id);
        return photoRepository.findAllByMatch(match, pageable);
    }

    @Override
    public int getMaxPage(Long id) {
        Match match = matchRepository.findOne(id);
        return photoRepository.countAllByMatch(match)/pageSize;
    }
}
