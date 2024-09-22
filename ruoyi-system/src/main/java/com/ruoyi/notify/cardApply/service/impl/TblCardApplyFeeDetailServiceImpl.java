package com.ruoyi.notify.cardApply.service.impl;

import java.util.List;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import com.ruoyi.notify.cardApply.domain.TblCardApplyFeeDetail;
import com.ruoyi.notify.cardApply.mapper.TblCardApplyFeeDetailMapper;
import com.ruoyi.notify.cardApply.service.ITblCardApplyFeeDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 卡操作手续费明细通知Service业务层处理
 *
 * @author ruoyi
 * @date 2024-08-15
 */
@Service
public class TblCardApplyFeeDetailServiceImpl implements ITblCardApplyFeeDetailService {
    @Autowired
    private TblCardApplyFeeDetailMapper tblCardApplyFeeDetailMapper;

    /**
     * 查询卡操作手续费明细通知
     *
     * @param id 卡操作手续费明细通知主键
     * @return 卡操作手续费明细通知
     */
    @Override
    public TblCardApplyFeeDetail selectTblCardApplyFeeDetailById(Long id) {
        return tblCardApplyFeeDetailMapper.selectTblCardApplyFeeDetailById(id);
    }

    /**
     * 查询卡操作手续费明细通知列表
     *
     * @param tblCardApplyFeeDetail 卡操作手续费明细通知
     * @return 卡操作手续费明细通知
     */
    @Override
    public List<TblCardApplyFeeDetail> selectTblCardApplyFeeDetailList(TblCardApplyFeeDetail tblCardApplyFeeDetail) {
        return tblCardApplyFeeDetailMapper.selectTblCardApplyFeeDetailList(tblCardApplyFeeDetail);
    }

    /**
     * 新增卡操作手续费明细通知
     *
     * @param tblCardApplyFeeDetail 卡操作手续费明细通知
     * @return 结果
     */
    @Override
    public int insertTblCardApplyFeeDetail(TblCardApplyFeeDetail tblCardApplyFeeDetail) {
        return tblCardApplyFeeDetailMapper.insertTblCardApplyFeeDetail(tblCardApplyFeeDetail);
    }

    /**
     * 修改卡操作手续费明细通知
     *
     * @param tblCardApplyFeeDetail 卡操作手续费明细通知
     * @return 结果
     */
    @Override
    public int updateTblCardApplyFeeDetail(TblCardApplyFeeDetail tblCardApplyFeeDetail) {
        return tblCardApplyFeeDetailMapper.updateTblCardApplyFeeDetail(tblCardApplyFeeDetail);
    }

    /**
     * 批量删除卡操作手续费明细通知
     *
     * @param ids 需要删除的卡操作手续费明细通知主键
     * @return 结果
     */
    @Override
    public int deleteTblCardApplyFeeDetailByIds(String ids) {
        return tblCardApplyFeeDetailMapper.deleteTblCardApplyFeeDetailByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除卡操作手续费明细通知信息
     *
     * @param id 卡操作手续费明细通知主键
     * @return 结果
     */
    @Override
    public int deleteTblCardApplyFeeDetailById(Long id) {
        return tblCardApplyFeeDetailMapper.deleteTblCardApplyFeeDetailById(id);
    }

    @Override
    public void insertTblCardApplyFeeDetailBatch(List<TblCardApplyFeeDetail> list) {
        String tableName = "tbl_card_apply_fee_detail_";
        tableName += DateTime.now().toString(DatePattern.SIMPLE_MONTH_PATTERN);
        tblCardApplyFeeDetailMapper.insertTblCardApplyFeeDetailBatch(tableName, list);
    }
}
