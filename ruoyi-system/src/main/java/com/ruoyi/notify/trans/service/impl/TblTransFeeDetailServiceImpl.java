package com.ruoyi.notify.trans.service.impl;

import java.util.List;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import com.ruoyi.notify.trans.domain.TblTransFeeDetail;
import com.ruoyi.notify.trans.mapper.TblTransFeeDetailMapper;
import com.ruoyi.notify.trans.service.ITblTransFeeDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 交易通知手续费明细Service业务层处理
 *
 * @author ruoyi
 * @date 2024-08-15
 */
@Service
public class TblTransFeeDetailServiceImpl implements ITblTransFeeDetailService {
    @Autowired
    private TblTransFeeDetailMapper tblTransFeeDetailMapper;

    /**
     * 查询交易通知手续费明细
     *
     * @param id 交易通知手续费明细主键
     * @return 交易通知手续费明细
     */
    @Override
    public TblTransFeeDetail selectTblTransFeeDetailById(Long id) {
        return tblTransFeeDetailMapper.selectTblTransFeeDetailById(id);
    }

    /**
     * 查询交易通知手续费明细列表
     *
     * @param tblTransFeeDetail 交易通知手续费明细
     * @return 交易通知手续费明细
     */
    @Override
    public List<TblTransFeeDetail> selectTblTransFeeDetailList(TblTransFeeDetail tblTransFeeDetail) {
        return tblTransFeeDetailMapper.selectTblTransFeeDetailList(tblTransFeeDetail);
    }

    /**
     * 新增交易通知手续费明细
     *
     * @param tblTransFeeDetail 交易通知手续费明细
     * @return 结果
     */
    @Override
    public int insertTblTransFeeDetail(TblTransFeeDetail tblTransFeeDetail) {
        return tblTransFeeDetailMapper.insertTblTransFeeDetail(tblTransFeeDetail);
    }

    /**
     * 修改交易通知手续费明细
     *
     * @param tblTransFeeDetail 交易通知手续费明细
     * @return 结果
     */
    @Override
    public int updateTblTransFeeDetail(TblTransFeeDetail tblTransFeeDetail) {
        return tblTransFeeDetailMapper.updateTblTransFeeDetail(tblTransFeeDetail);
    }

    /**
     * 批量删除交易通知手续费明细
     *
     * @param ids 需要删除的交易通知手续费明细主键
     * @return 结果
     */
    @Override
    public int deleteTblTransFeeDetailByIds(String ids) {
        return tblTransFeeDetailMapper.deleteTblTransFeeDetailByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除交易通知手续费明细信息
     *
     * @param id 交易通知手续费明细主键
     * @return 结果
     */
    @Override
    public int deleteTblTransFeeDetailById(Long id) {
        return tblTransFeeDetailMapper.deleteTblTransFeeDetailById(id);
    }

    @Override
    public void insertTblTransFeeDetailBatch(List<TblTransFeeDetail> list) {
        String tableName = "tbl_trans_fee_detail_";
        tableName += DateTime.now().toString(DatePattern.SIMPLE_MONTH_PATTERN);
        tblTransFeeDetailMapper.insertTblTransFeeDetailBatch(tableName, list);
    }
}
