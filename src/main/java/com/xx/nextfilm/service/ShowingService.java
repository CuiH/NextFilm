package com.xx.nextfilm.service;

import com.xx.nextfilm.dto.ShowingEditor;
import com.xx.nextfilm.entity.ShowingEntity;

/**
 * Created by CuiH on 2016/5/17.
 */
public interface ShowingService {

    ShowingEntity findShowById(Long id);

    ShowingEntity getShowEditorById(Long id);

    boolean createShow(ShowingEditor showingEditor);

    boolean updateShow(ShowingEditor showingEditor);

    void deleteShow(ShowingEntity showingEntity);

}
