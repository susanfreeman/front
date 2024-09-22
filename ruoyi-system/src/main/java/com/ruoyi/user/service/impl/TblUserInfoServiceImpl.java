package com.ruoyi.user.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.user.domain.TblUserInfo;
import com.ruoyi.user.mapper.TblUserInfoMapper;
import com.ruoyi.user.service.ITblUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户信息Service业务层处理
 *
 * @author ruoyi
 * @date 2024-07-20
 */
@Service
public class TblUserInfoServiceImpl implements ITblUserInfoService {
    @Autowired
    private TblUserInfoMapper tblUserInfoMapper;

    /**
     * 查询用户信息
     *
     * @param uiId 用户信息主键
     * @return 用户信息
     */
    @Override
    public TblUserInfo selectTblUserInfoByUiId(Long uiId) {
        return tblUserInfoMapper.selectTblUserInfoByUiId(uiId);
    }

    /**
     * 查询用户信息列表
     *
     * @param tblUserInfo 用户信息
     * @return 用户信息
     */
    @Override
    public List<TblUserInfo> selectTblUserInfoList(TblUserInfo tblUserInfo) {
        return tblUserInfoMapper.selectTblUserInfoList(tblUserInfo);
    }

    /**
     * 查询用户信息列表
     *
     * @param userId 用户信息
     * @return 用户信息
     */
    @Override
    public TblUserInfo selectTblUserInfoByUserId(Long userId) {
        TblUserInfo userInfo = new TblUserInfo();
        userInfo.setUserId(userId);
        return tblUserInfoMapper.selectTblUserInfoList(userInfo).stream().findFirst().get();
    }

    /**
     * 查询用户信息列表
     *
     * @param tblUserInfo 用户信息
     * @return 用户信息
     */
    @Override
    public List<TblUserInfo> selectTblUserInfoListByCoinIsnotNull(TblUserInfo tblUserInfo) {
        return tblUserInfoMapper.selectTblUserInfoListByCoinIsnotNull(tblUserInfo);
    }

    /**
     * 新增用户信息
     *
     * @param tblUserInfo 用户信息
     * @return 结果
     */
    @Override
    public int insertTblUserInfo(TblUserInfo tblUserInfo) {
        tblUserInfo.setCreateTime(DateUtils.getNowDate());
        return tblUserInfoMapper.insertTblUserInfo(tblUserInfo);
    }

    /**
     * 修改用户信息
     *
     * @param tblUserInfo 用户信息
     * @return 结果
     */
    @Override
    public int updateTblUserInfo(TblUserInfo tblUserInfo) {
        tblUserInfo.setBalanceFroze(null);
        tblUserInfo.setBalance(null);
        tblUserInfo.setBalanceGbp(null);
        tblUserInfo.setBalanceUsdt(null);
        tblUserInfo.setBalanceEur(null);
        return tblUserInfoMapper.updateTblUserInfo(tblUserInfo);
    }

    /**
     * 批量删除用户信息
     *
     * @param uiIds 需要删除的用户信息主键
     * @return 结果
     */
    @Override
    public int deleteTblUserInfoByUiIds(String uiIds) {
        return tblUserInfoMapper.deleteTblUserInfoByUiIds(Convert.toStrArray(uiIds));
    }

    /**
     * 删除用户信息信息
     *
     * @param uiId 用户信息主键
     * @return 结果
     */
    @Override
    public int deleteTblUserInfoByUiId(Long uiId) {
        return tblUserInfoMapper.deleteTblUserInfoByUiId(uiId);
    }

    @Override
    public int updateTblUserInfoBalance(TblUserInfo tblUserInfo) {
        return tblUserInfoMapper.updateTblUserInfoBalance(tblUserInfo);
    }

    @Override
    public int updateTblUserInfoBalanceExchange(Long uiId, String source, String target, String sourceAmount, String targetAmount) {
        Map paraMap = new HashMap<>();
        paraMap.put("uiId", uiId);
        paraMap.put("sourceCurr", source);
        paraMap.put("targetCurr", target);
        paraMap.put("sourceAmount", sourceAmount);
        paraMap.put("targetAmount", targetAmount);
        return tblUserInfoMapper.updateTblUserInfoBalanceExchange(paraMap);
    }

    @Override
    public TblUserInfo selectTblUserInfoByInviteUri(String inviteUri) {
        return tblUserInfoMapper.selectTblUserInfoByInviteUri(inviteUri);
    }

    @Override
    public TblUserInfo selectTblUserInfoByCarNo(String carNo) {
        return tblUserInfoMapper.selectTblUserInfoByCarNo(carNo);
    }
}
