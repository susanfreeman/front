package com.ruoyi.risk.service.impl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.risk.domain.TblRiskLimitConfig;
import com.ruoyi.risk.mapper.TblRiskLimitConfigMapper;
import com.ruoyi.risk.service.ITblRiskLimitConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2024-08-16
 */
@Service
public class TblRiskLimitConfigServiceImpl implements ITblRiskLimitConfigService {
    @Autowired
    private TblRiskLimitConfigMapper tblRiskLimitConfigMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param ID 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public TblRiskLimitConfig selectTblRiskLimitConfigByID(Long ID) {
        return tblRiskLimitConfigMapper.selectTblRiskLimitConfigByID(ID);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param tblRiskLimitConfig 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<TblRiskLimitConfig> selectTblRiskLimitConfigList(TblRiskLimitConfig tblRiskLimitConfig) {
        return tblRiskLimitConfigMapper.selectTblRiskLimitConfigList(tblRiskLimitConfig);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param tblRiskLimitConfig 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertTblRiskLimitConfig(TblRiskLimitConfig tblRiskLimitConfig) {
        tblRiskLimitConfig.setCreateTime(DateUtils.getNowDate());
        return tblRiskLimitConfigMapper.insertTblRiskLimitConfig(tblRiskLimitConfig);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param tblRiskLimitConfig 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateTblRiskLimitConfig(TblRiskLimitConfig tblRiskLimitConfig) {
        tblRiskLimitConfig.setUpdateTime(DateUtils.getNowDate());
        return tblRiskLimitConfigMapper.updateTblRiskLimitConfig(tblRiskLimitConfig);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param IDs 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteTblRiskLimitConfigByIDs(String IDs) {
        return tblRiskLimitConfigMapper.deleteTblRiskLimitConfigByIDs(Convert.toStrArray(IDs));
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param ID 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteTblRiskLimitConfigByID(Long ID) {
        return tblRiskLimitConfigMapper.deleteTblRiskLimitConfigByID(ID);
    }

    @Override
    public TblRiskLimitConfig selectTblRiskLimitConfig(String type, String value) {
        return tblRiskLimitConfigMapper.selectTblRiskLimitConfig(type, value);
    }
}
