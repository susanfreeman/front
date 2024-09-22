package com.ruoyi.risk.service.impl;

import java.util.List;

import cn.hutool.core.date.DateTime;
import com.ruoyi.risk.domain.TblOperatorCard;
import com.ruoyi.risk.mapper.TblOperatorCardMapper;
import com.ruoyi.risk.service.ITblOperatorCardService;
import org.apache.commons.lang.StringUtils;
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
public class TblOperatorCardServiceImpl implements ITblOperatorCardService {
    @Autowired
    private TblOperatorCardMapper tblOperatorCardMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param ID 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public TblOperatorCard selectTblOperatorCardByID(Long ID) {
        return tblOperatorCardMapper.selectTblOperatorCardByID(ID);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param tblOperatorCard 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<TblOperatorCard> selectTblOperatorCardList(TblOperatorCard tblOperatorCard) {
        return tblOperatorCardMapper.selectTblOperatorCardList(tblOperatorCard);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param tblOperatorCard 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertTblOperatorCard(TblOperatorCard tblOperatorCard) {
        tblOperatorCard.setOperTime(DateTime.now());
        return tblOperatorCardMapper.insertTblOperatorCard(tblOperatorCard);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param tblOperatorCard 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateTblOperatorCard(TblOperatorCard tblOperatorCard) {
        tblOperatorCard.setOperTime(DateTime.now());
        return tblOperatorCardMapper.updateTblOperatorCard(tblOperatorCard);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param IDs 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteTblOperatorCardByIDs(String IDs) {
        return tblOperatorCardMapper.deleteTblOperatorCardByIDs(Convert.toStrArray(IDs));
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param ID 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteTblOperatorCardByID(Long ID) {
        return tblOperatorCardMapper.deleteTblOperatorCardByID(ID);
    }
}
