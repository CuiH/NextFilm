package com.xx.nextfilm.service;

import com.xx.nextfilm.dto.editor.ShowingEditor1;
import com.xx.nextfilm.dto.editor.ShowingEditor2;
import com.xx.nextfilm.entity.ShowingEntity;

/**
 * Created by CuiH on 2016/5/17.
 */
public interface ShowingService {

    ShowingEntity findShowingById(Long id, boolean needFcm, boolean needSeats);

    ShowingEditor2 getShowingEditor2ById(Long id);

    void createShowing(ShowingEditor1 showingEditor1);

    boolean updateShowing(ShowingEditor2 showingEditor2);

    void deleteShowing(ShowingEntity showingEntity);

}
