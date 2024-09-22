package com.ruoyi.notify.balOperate.service.impl;

import java.util.List;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import com.ruoyi.notify.balOperate.domain.TblBalanceOperateFeeDetail;
import com.ruoyi.notify.balOperate.mapper.TblBalanceOperateFeeDetailMapper;
import com.ruoyi.notify.balOperate.service.ITblBalanceOperateFeeDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 资金变动手续费明细通知Service业务层处理
 *
 * @author ruoyi
 * @date 2024-08-15
 */
@Service
public class TblBalanceOperateFeeDetailServiceImpl implements ITblBalanceOperateFeeDetailService {
    @Autowired
    private TblBalanceOperateFeeDetailMapper tblBalanceOperateFeeDetailMapper;

    /**
     * 查询资金变动手续费明细通知
     *
     * @param id 资金变动手续费明细通知主键
     * @return 资金变动手续费明细通知
     */
    @Override
    public TblBalanceOperateFeeDetail selectTblBalanceOperateFeeDetailById(Long id) {
        return tblBalanceOperateFeeDetailMapper.selectTblBalanceOperateFeeDetailById(id);
    }

    /**
     * 查询资金变动手续费明细通知列表
     *
     * @param tblBalanceOperateFeeDetail 资金变动手续费明细通知
     * @return 资金变动手续费明细通知
     */
    @Override
    public List<TblBalanceOperateFeeDetail> selectTblBalanceOperateFeeDetailList(TblBalanceOperateFeeDetail tblBalanceOperateFeeDetail) {
        return tblBalanceOperateFeeDetailMapper.selectTblBalanceOperateFeeDetailList(tblBalanceOperateFeeDetail);
    }

    /**
     * 新增资金变动手续费明细通知
     *
     * @param tblBalanceOperateFeeDetail 资金变动手续费明细通知
     * @return 结果
     */
    @Override
    public int insertTblBalanceOperateFeeDetail(TblBalanceOperateFeeDetail tblBalanceOperateFeeDetail) {
        return tblBalanceOperateFeeDetailMapper.insertTblBalanceOperateFeeDetail(tblBalanceOperateFeeDetail);
    }

    /**
     * 修改资金变动手续费明细通知
     *
     * @param tblBalanceOperateFeeDetail 资金变动手续费明细通知
     * @return 结果
     */
    @Override
    public int updateTblBalanceOperateFeeDetail(TblBalanceOperateFeeDetail tblBalanceOperateFeeDetail) {
        return tblBalanceOperateFeeDetailMapper.updateTblBalanceOperateFeeDetail(tblBalanceOperateFeeDetail);
    }

    /**
     * 批量删除资金变动手续费明细通知
     *
     * @param ids 需要删除的资金变动手续费明细通知主键
     * @return 结果
     */
    @Override
    public int deleteTblBalanceOperateFeeDetailByIds(String ids) {
        return tblBalanceOperateFeeDetailMapper.deleteTblBalanceOperateFeeDetailByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除资金变动手续费明细通知信息
     *
     * @param id 资金变动手续费明细通知主键
     * @return 结果
     */
    @Override
    public int deleteTblBalanceOperateFeeDetailById(Long id) {
        return tblBalanceOperateFeeDetailMapper.deleteTblBalanceOperateFeeDetailById(id);
    }

    @Override
    public void insertTblBalanceOperateFeeDetailBatch(List<TblBalanceOperateFeeDetail> list) {
        String tableName = "tbl_balance_operate_fee_detail_";
        tableName += DateTime.now().toString(DatePattern.SIMPLE_MONTH_PATTERN);
        tblBalanceOperateFeeDetailMapper.insertTblBalanceOperateFeeDetailBatch(tableName, list);
    }
}
