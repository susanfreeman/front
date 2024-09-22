package com.ruoyi.risk.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.ruoyi.risk.domain.TblRiskLimitData;
import com.ruoyi.risk.mapper.TblRiskLimitDataMapper;
import com.ruoyi.risk.service.ITblRiskLimitDataService;
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
public class TblRiskLimitDataServiceImpl implements ITblRiskLimitDataService {
    @Autowired
    private TblRiskLimitDataMapper tblRiskLimitDataMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param ID 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public TblRiskLimitData selectTblRiskLimitDataByID(Long ID) {
        return tblRiskLimitDataMapper.selectTblRiskLimitDataByID(ID);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param tblRiskLimitData 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<TblRiskLimitData> selectTblRiskLimitDataList(TblRiskLimitData tblRiskLimitData) {
        return tblRiskLimitDataMapper.selectTblRiskLimitDataList(tblRiskLimitData);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param tblRiskLimitData 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertTblRiskLimitData(TblRiskLimitData tblRiskLimitData) {
        return tblRiskLimitDataMapper.insertTblRiskLimitData(tblRiskLimitData);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param tblRiskLimitData 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateTblRiskLimitData(TblRiskLimitData tblRiskLimitData) {
        return tblRiskLimitDataMapper.updateTblRiskLimitData(tblRiskLimitData);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param IDs 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteTblRiskLimitDataByIDs(String IDs) {
        return tblRiskLimitDataMapper.deleteTblRiskLimitDataByIDs(Convert.toStrArray(IDs));
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param ID 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteTblRiskLimitDataByID(Long ID) {
        return tblRiskLimitDataMapper.deleteTblRiskLimitDataByID(ID);
    }

    @Override
    public int updateTblRiskLimitDataByCardNo(String cardNo, BigDecimal transAmt, String currentDate) {
        return tblRiskLimitDataMapper.updateTblRiskLimitDataByCardNo(cardNo, transAmt, currentDate);
    }

    @Override
    public TblRiskLimitData selectTblRiskLimitData(TblRiskLimitData riskLimitData) {
        return tblRiskLimitDataMapper.selectTblRiskLimitData(riskLimitData);
    }
}
