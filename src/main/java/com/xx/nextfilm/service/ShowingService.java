package com.xx.nextfilm.service;

import com.xx.nextfilm.dto.ShowingEditor;
import com.xx.nextfilm.entity.ShowingEntity;

/**
 * Created by CuiH on 2016/5/17.
 */
public interface ShowingService {

    ShowingEntity findShowingById(Long id, boolean needFcm);

    ShowingEditor getShowingEditorById(Long id, boolean needFcm);

    boolean createShowing(ShowingEditor showingEditor);

    boolean updateShowing(ShowingEditor showingEditor);

    void deleteShowing(ShowingEntity showingEntity);

}
