package com.xx.nextfilm.service;

import com.xx.nextfilm.dto.ShowingEditor;
import com.xx.nextfilm.dto.UserDetailEditor;
import com.xx.nextfilm.entity.ShowingEntity;
import com.xx.nextfilm.entity.UserDetailEntity;

/**
 * Created by CuiH on 2016/5/17.
 */
public interface ShowingService {

    ShowingEntity findShowingById(Long id, boolean needFcm, boolean needSeats);

    ShowingEditor getShowingEditorById(Long id, boolean needFcm, boolean needSeats);

    boolean createShowing(ShowingEditor showingEditor);

    boolean updateShowing(ShowingEditor showingEditor);

    void deleteShowing(ShowingEntity showingEntity);

}
