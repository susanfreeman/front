package com.ruoyi.risk.mapper;

import com.ruoyi.risk.domain.TblRiskLimitConfig;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author ruoyi
 * @date 2024-08-16
 */
public interface TblRiskLimitConfigMapper {
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
     * 删除【请填写功能名称】
     *
     * @param ID 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteTblRiskLimitConfigByID(Long ID);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param IDs 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTblRiskLimitConfigByIDs(String[] IDs);

    TblRiskLimitConfig selectTblRiskLimitConfig(@Param("type") String type, @Param("value") String value);
}
