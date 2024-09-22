package com.ruoyi.risk.mapper;

import com.ruoyi.risk.domain.TblRiskLimitData;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2024-08-16
 */
public interface TblRiskLimitDataMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param ID 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public TblRiskLimitData selectTblRiskLimitDataByID(Long ID);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param tblRiskLimitData 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<TblRiskLimitData> selectTblRiskLimitDataList(TblRiskLimitData tblRiskLimitData);

    /**
     * 新增【请填写功能名称】
     * 
     * @param tblRiskLimitData 【请填写功能名称】
     * @return 结果
     */
    public int insertTblRiskLimitData(TblRiskLimitData tblRiskLimitData);

    /**
     * 修改【请填写功能名称】
     * 
     * @param tblRiskLimitData 【请填写功能名称】
     * @return 结果
     */
    public int updateTblRiskLimitData(TblRiskLimitData tblRiskLimitData);

    /**
     * 删除【请填写功能名称】
     * 
     * @param ID 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteTblRiskLimitDataByID(Long ID);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param IDs 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTblRiskLimitDataByIDs(String[] IDs);

    int updateTblRiskLimitDataByCardNo(@Param("cardNo") String cardNo, @Param("transAmt") BigDecimal transAmt, @Param("currentDate") String currentDate);

    TblRiskLimitData selectTblRiskLimitData(TblRiskLimitData riskLimitData);
}
