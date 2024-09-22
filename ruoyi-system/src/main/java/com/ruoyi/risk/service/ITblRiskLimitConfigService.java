package com.ruoyi.risk.service;

import com.ruoyi.risk.domain.TblRiskLimitConfig;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2024-08-16
 */
public interface ITblRiskLimitConfigService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param ID 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public TblRiskLimitConfig selectTblRiskLimitConfigByID(Long ID);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param tblRiskLimitConfig 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<TblRiskLimitConfig> selectTblRiskLimitConfigList(TblRiskLimitConfig tblRiskLimitConfig);

    /**
     * 新增【请填写功能名称】
     * 
     * @param tblRiskLimitConfig 【请填写功能名称】
     * @return 结果
     */
    public int insertTblRiskLimitConfig(TblRiskLimitConfig tblRiskLimitConfig);

    /**
     * 修改【请填写功能名称】
     * 
     * @param tblRiskLimitConfig 【请填写功能名称】
     * @return 结果
     */
    public int updateTblRiskLimitConfig(TblRiskLimitConfig tblRiskLimitConfig);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param IDs 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteTblRiskLimitConfigByIDs(String IDs);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param ID 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteTblRiskLimitConfigByID(Long ID);

    TblRiskLimitConfig selectTblRiskLimitConfig(String type, String value);
}
