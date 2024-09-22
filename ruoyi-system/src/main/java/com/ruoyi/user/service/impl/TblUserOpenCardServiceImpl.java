package com.ruoyi.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.user.mapper.TblUserOpenCardMapper;
import com.ruoyi.user.domain.TblUserOpenCard;
import com.ruoyi.user.service.ITblUserOpenCardService;
import com.ruoyi.common.core.text.Convert;

/**
 * 用户开卡信息Service业务层处理
 *
 * @author ruoyi
 * @date 2024-07-20
 */
@Service
public class TblUserOpenCardServiceImpl implements ITblUserOpenCardService {
    @Autowired
    private TblUserOpenCardMapper tblUserOpenCardMapper;

    /**
     * 查询用户开卡信息
     *
     * @param uocId 用户开卡信息主键
     * @return 用户开卡信息
     */
    @Override
    public TblUserOpenCard selectTblUserOpenCardByUocId(Long uocId) {
        return tblUserOpenCardMapper.selectTblUserOpenCardByUocId(uocId);
    }

    @Override
    public TblUserOpenCard selectTblUserOpenCardByCardNo(String cardNo) {
        return tblUserOpenCardMapper.selectTblUserOpenCardByCardNo(cardNo);
    }

    @Override
    public TblUserOpenCard selectTblUserOpenCardByCardId(String cardId) {
        return tblUserOpenCardMapper.selectTblUserOpenCardByCardId(cardId);
    }

    /**
     * 查询用户开卡信息列表
     *
     * @param tblUserOpenCard 用户开卡信息
     * @return 用户开卡信息
     */
    @Override
    public List<TblUserOpenCard> selectTblUserOpenCardList(TblUserOpenCard tblUserOpenCard) {
        return tblUserOpenCardMapper.selectTblUserOpenCardList(tblUserOpenCard);
    }

    /**
     * 查询用户开卡信息列表
     *
     * @param tblUserOpenCard 用户开卡信息
     * @return 用户开卡信息
     */
    @Override
    public List<TblUserOpenCard> selectTblUserOpenCardListGtTransTime(TblUserOpenCard tblUserOpenCard) {
        return tblUserOpenCardMapper.selectTblUserOpenCardListGtTransTime(tblUserOpenCard);
    }

    /**
     * 新增用户开卡信息
     *
     * @param tblUserOpenCard 用户开卡信息
     * @return 结果
     */
    @Override
    public int insertTblUserOpenCard(TblUserOpenCard tblUserOpenCard) {
        return tblUserOpenCardMapper.insertTblUserOpenCard(tblUserOpenCard);
    }

    /**
     * 修改用户开卡信息
     *
     * @param tblUserOpenCard 用户开卡信息
     * @return 结果
     */
    @Override
    public int updateTblUserOpenCard(TblUserOpenCard tblUserOpenCard) {
        return tblUserOpenCardMapper.updateTblUserOpenCard(tblUserOpenCard);
    }

    /**
     * 批量修改卡状态
     *
     * @param tblUserOpenCard 用户开卡信息
     * @return 结果
     */
    @Override
    public int batchUpdateStatus(TblUserOpenCard tblUserOpenCard) {
        return tblUserOpenCardMapper.batchUpdateStatus(tblUserOpenCard);
    }

    /**
     * 按状态 修改用户开卡信息
     *
     * @param tblUserOpenCard 用户开卡信息
     * @return 结果
     */
    @Override
    public int updateTblUserOpenCardByStatus(TblUserOpenCard tblUserOpenCard) {
        return tblUserOpenCardMapper.updateTblUserOpenCardByStatus(tblUserOpenCard);
    }

    /**
     * 批量删除用户开卡信息
     *
     * @param uocIds 需要删除的用户开卡信息主键
     * @return 结果
     */
    @Override
    public int deleteTblUserOpenCardByUocIds(String uocIds) {
        return tblUserOpenCardMapper.deleteTblUserOpenCardByUocIds(Convert.toStrArray(uocIds));
    }

    /**
     * 删除用户开卡信息信息
     *
     * @param uocId 用户开卡信息主键
     * @return 结果
     */
    @Override
    public int deleteTblUserOpenCardByUocId(Long uocId) {
        return tblUserOpenCardMapper.deleteTblUserOpenCardByUocId(uocId);
    }
}
