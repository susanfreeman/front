package com.ruoyi.notify.cardApply.service.impl;

import java.util.List;

import com.ruoyi.notify.cardApply.domain.TblNotifyCardApply;
import com.ruoyi.notify.cardApply.mapper.TblNotifyCardApplyMapper;
import com.ruoyi.notify.cardApply.service.ITblNotifyCardApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 卡操作通知Service业务层处理
 *
 * @author ruoyi
 * @date 2024-08-15
 */
@Service
public class TblNotifyCardApplyServiceImpl implements ITblNotifyCardApplyService {
    @Autowired
    private TblNotifyCardApplyMapper tblNotifyCardApplyMapper;

    /**
     * 查询卡操作通知
     *
     * @param id 卡操作通知主键
     * @return 卡操作通知
     */
    @Override
    public TblNotifyCardApply selectTblNotifyCardApplyById(Long id) {
        return tblNotifyCardApplyMapper.selectTblNotifyCardApplyById(id);
    }

    /**
     * 查询卡操作通知列表
     *
     * @param tblNotifyCardApply 卡操作通知
     * @return 卡操作通知
     */
    @Override
    public List<TblNotifyCardApply> selectTblNotifyCardApplyList(TblNotifyCardApply tblNotifyCardApply) {
        return tblNotifyCardApplyMapper.selectTblNotifyCardApplyList(tblNotifyCardApply);
    }

    /**
     * 新增卡操作通知
     *
     * @param tblNotifyCardApply 卡操作通知
     * @return 结果
     */
    @Override
    public int insertTblNotifyCardApply(TblNotifyCardApply tblNotifyCardApply) {
        return tblNotifyCardApplyMapper.insertTblNotifyCardApply(tblNotifyCardApply);
    }

    /**
     * 修改卡操作通知
     *
     * @param tblNotifyCardApply 卡操作通知
     * @return 结果
     */
    @Override
    public int updateTblNotifyCardApply(TblNotifyCardApply tblNotifyCardApply) {
        return tblNotifyCardApplyMapper.updateTblNotifyCardApply(tblNotifyCardApply);
    }

    /**
     * 批量删除卡操作通知
     *
     * @param ids 需要删除的卡操作通知主键
     * @return 结果
     */
    @Override
    public int deleteTblNotifyCardApplyByIds(String ids) {
        return tblNotifyCardApplyMapper.deleteTblNotifyCardApplyByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除卡操作通知信息
     *
     * @param id 卡操作通知主键
     * @return 结果
     */
    @Override
    public int deleteTblNotifyCardApplyById(Long id) {
        return tblNotifyCardApplyMapper.deleteTblNotifyCardApplyById(id);
    }

    @Override
    public TblNotifyCardApply selectTblNotifyTransByTranId(Long ttId) {
        return tblNotifyCardApplyMapper.selectTblNotifyTransByTranId(ttId);
    }
}
