package org.open.boot.api.kuaidizs.dto;

import java.util.List;

/**
 * 快递助手：模版列表信息对象
 *
 * @author barnak
 */
public class KdzsTemplateListDTO {

    /**
     * 默认模版ID（必须）
     */
    private String modeListShowId;

    /**
     * 模版列表（必须）
     */
    private List<KdzsModeListShowDTO> modeListShows;

    public String getModeListShowId() {
        return modeListShowId;
    }

    public void setModeListShowId(String modeListShowId) {
        this.modeListShowId = modeListShowId;
    }

    public List<KdzsModeListShowDTO> getModeListShows() {
        return modeListShows;
    }

    public void setModeListShows(List<KdzsModeListShowDTO> modeListShows) {
        this.modeListShows = modeListShows;
    }

    @Override
    public String toString() {
        return "KdzsTemplateListResponseDTO{" +
                "modeListShowId='" + modeListShowId + '\'' +
                ", modeListShows=" + modeListShows +
                '}';
    }
}
