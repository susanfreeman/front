package com.ruoyi.coin.service;

import java.util.List;
import com.ruoyi.coin.domain.TblColdCoinAddress;

/**
 * 冷钱包地址Service接口
 * 
 * @author ruoyi
 * @date 2024-07-28
 */
public interface ITblColdCoinAddressService 
{
    /**
     * 查询冷钱包地址
     * 
     * @param coinId 冷钱包地址主键
     * @return 冷钱包地址
     */
    public TblColdCoinAddress selectTblColdCoinAddressByCoinId(Long coinId);

    /**
     * 查询冷钱包地址列表
     * 
     * @param tblColdCoinAddress 冷钱包地址
     * @return 冷钱包地址集合
     */
    public List<TblColdCoinAddress> selectTblColdCoinAddressList(TblColdCoinAddress tblColdCoinAddress);

    /**
     * 新增冷钱包地址
     * 
     * @param tblColdCoinAddress 冷钱包地址
     * @return 结果
     */
    public int insertTblColdCoinAddress(TblColdCoinAddress tblColdCoinAddress);

    /**
     * 新增冷钱包地址
     *
     * @param tblColdCoinAddress 冷钱包地址
     * @return 结果
     */
    public int batchInsertTblColdCoinAddress(TblColdCoinAddress tblColdCoinAddress);

    /**
     * 修改冷钱包地址
     * 
     * @param tblColdCoinAddress 冷钱包地址
     * @return 结果
     */
    public int updateTblColdCoinAddress(TblColdCoinAddress tblColdCoinAddress);

    /**
     * 批量删除冷钱包地址
     * 
     * @param coinIds 需要删除的冷钱包地址主键集合
     * @return 结果
     */
    public int deleteTblColdCoinAddressByCoinIds(String coinIds);

    /**
     * 删除冷钱包地址信息
     * 
     * @param coinId 冷钱包地址主键
     * @return 结果
     */
    public int deleteTblColdCoinAddressByCoinId(Long coinId);
}
