package com.ruoyi.user.service;

import java.math.BigDecimal;
import java.util.List;
import com.ruoyi.user.domain.TblUserInfo;

/**
 * 用户信息Service接口
 * 
 * @author ruoyi
 * @date 2024-07-20
 */
public interface ITblUserInfoService 
{
    /**
     * 查询用户信息
     * 
     * @param uiId 用户信息主键
     * @return 用户信息
     */
    public TblUserInfo selectTblUserInfoByUiId(Long uiId);

    /**
     * 查询用户信息列表
     * 
     * @param tblUserInfo 用户信息
     * @return 用户信息集合
     */
    public List<TblUserInfo> selectTblUserInfoList(TblUserInfo tblUserInfo);

    /**
     * 查询用户信息列表
     *
     * @param userId 用户信息
     * @return 用户信息集合
     */
    public TblUserInfo selectTblUserInfoByUserId(Long userId);

    /**
     * 查询用户信息列表
     *
     * @param tblUserInfo 用户信息
     * @return 用户信息集合
     */
    public List<TblUserInfo> selectTblUserInfoListByCoinIsnotNull(TblUserInfo tblUserInfo);

    /**
     * 新增用户信息
     * 
     * @param tblUserInfo 用户信息
     * @return 结果
     */
    public int insertTblUserInfo(TblUserInfo tblUserInfo);

    /**
     * 修改用户信息
     * 
     * @param tblUserInfo 用户信息
     * @return 结果
     */
    public int updateTblUserInfo(TblUserInfo tblUserInfo);

    /**
     * 批量删除用户信息
     * 
     * @param uiIds 需要删除的用户信息主键集合
     * @return 结果
     */
    public int deleteTblUserInfoByUiIds(String uiIds);

    /**
     * 删除用户信息信息
     * 
     * @param uiId 用户信息主键
     * @return 结果
     */
    public int deleteTblUserInfoByUiId(Long uiId);

    /**
     * @param tblUserInfo
     */
    public int updateTblUserInfoBalance(TblUserInfo tblUserInfo);

    public int updateTblUserInfoBalanceExchange(Long uiId,String source,String target,String sourceAmount,String targetAmount);

    TblUserInfo selectTblUserInfoByInviteUri(String inviteUri);

    TblUserInfo selectTblUserInfoByCarNo(String carNo);
}
